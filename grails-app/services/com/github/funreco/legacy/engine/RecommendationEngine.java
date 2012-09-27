package com.github.funreco.legacy.engine;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import com.github.funreco.legacy.domain.FacebookIdAndName;
import com.github.funreco.legacy.domain.FacebookProfile;
import com.github.funreco.legacy.domain.FacebookProfileRef;
import com.github.funreco.legacy.domain.OpenGraphAction;
import com.github.funreco.legacy.domain.OpenGraphQuery;
import com.github.funreco.legacy.domain.recommandation.OpenGraphRecommendation;
import com.github.funreco.legacy.domain.recommandation.RecommendedObject;
import com.github.funreco.legacy.service.FacebookFriendsService;
import com.github.funreco.legacy.service.OpenGraphQueryService;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

public class RecommendationEngine {
    private OpenGraphQueryService openGraphQueryService;

    private FacebookFriendsService facebookFriendsService;

    private Datastore communityDatastore;

    private volatile OpenGraphActionStats stats;

    private volatile List<OpenGraphQuery> queries;

    public void reloadStatsAndQueries() {
        stats = findStats(last7Days());
        queries = openGraphQueryService.findAll();
    }

    public OpenGraphRecommendation findRecommendation(FacebookIdAndName profile) {
        return query(profile).get();
    }

    /**
     * Recommendations available for all users
     */
    public OpenGraphRecommendation findGenericRecommendation() {
        return findRecommendation(null);
    }

    /**
     * Recommendations available for all users
     */
    public void buildGenericRecommendations() {
        OpenGraphRecommendation recommendation = OpenGraphRecommendation.forAllProfiles();

        for (OpenGraphQuery query : queries) {
            OpenGraphActionStats filteredStats = stats.filterByQuery(query.getQuery());

            List<RecommendedObject> objects = new ArrayList<RecommendedObject>();

            for (OpenGraphActionStat stat : filteredStats.iterate()) {
                objects.add(RecommendedObject.fromStat(stat));
            }

            recommendation.forQuery(query).recommend(objects);
        }

        save(recommendation);
    }

    public void buildRecommendations(String facebookId) {
        FacebookProfile profile = communityDatastore.createQuery(FacebookProfile.class).filter("facebookId", facebookId).get();

        List<FacebookProfileRef> myFriends = facebookFriendsService.findFriends(profile);

        OpenGraphActionStats myFriendsStats = stats.filterByFriends(myFriends);

        OpenGraphRecommendation recommendation = OpenGraphRecommendation.forProfile(profile);

        for (OpenGraphQuery query : queries) {
            OpenGraphActionStats filteredStats = myFriendsStats.filterByQuery(query.getQuery());

            List<RecommendedObject> objects = new ArrayList<RecommendedObject>();

            for (OpenGraphActionStat stat : filteredStats.iterate()) {
                List<FacebookProfileRef> mutualFiends = mutualFiends(stat, myFriends);

                objects.add(RecommendedObject.object(stat.getObject()).by(mutualFiends));
            }

            recommendation.forQuery(query).recommend(objects);
        }

        save(recommendation);
    }

    public void save(OpenGraphRecommendation recommendation) {
        if (recommendation.size() == 0) {
            return;
        }

        OpenGraphRecommendation dbRecommendation = query(recommendation.getProfile()).get();

        if (dbRecommendation != null) {
            recommendation.setId(dbRecommendation.getId());
        }

        communityDatastore.save(recommendation);
    }

    public OpenGraphActionStats findStats(Interval interval) {
        Query<OpenGraphAction> query = communityDatastore.find(OpenGraphAction.class)
                .filter("date >=", interval.getStart().toDate())
                .filter("date <", interval.getEnd().toDate());

        return OpenGraphActionStats.fromActions(query);
    }

    private List<FacebookProfileRef> mutualFiends(OpenGraphActionStat stat, List<FacebookProfileRef> myFriends) {
        return (List<FacebookProfileRef>) CollectionUtils.intersection(myFriends, stat.getProfiles());
    }

    private Interval last7Days() {
        DateTime now = new DateTime();
        return new Interval(now.minusDays(7), now);
    }

    private Query<OpenGraphRecommendation> query(FacebookIdAndName profile) {
        Query<OpenGraphRecommendation> query = communityDatastore.find(OpenGraphRecommendation.class);

        if (profile == null) {
            query.filter("profile", null);
        } else {
            query.filter("profile.facebookId", profile.getFacebookId());
        }

        return query;
    }

    public void setCommunityDatastore(Datastore communityDatastore) {
        this.communityDatastore = communityDatastore;
    }

    public void setFacebookFriendsService(FacebookFriendsService facebookFriendsService) {
        this.facebookFriendsService = facebookFriendsService;
    }

    public void setOpenGraphQueryService(OpenGraphQueryService openGraphQueryService) {
        this.openGraphQueryService = openGraphQueryService;
    }
}
