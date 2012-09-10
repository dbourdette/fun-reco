package com.github.funreco.service

import com.github.funreco.domain.FacebookIdAndName
import com.github.funreco.domain.FacebookProfile
import com.github.funreco.domain.FacebookProfileRef
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.domain.OpenGraphQuery
import com.github.funreco.domain.recommandation.OpenGraphRecommendation
import com.github.funreco.domain.recommandation.RecommendedObject
import com.github.funreco.domain.stats.OpenGraphActionStat
import com.github.funreco.domain.stats.OpenGraphActionStats
import com.google.code.morphia.Datastore
import com.google.code.morphia.query.Query
import org.apache.commons.collections.CollectionUtils
import org.joda.time.DateTime
import org.joda.time.Interval

class RecommendationService {
    OpenGraphQueryService openGraphQueryService

    FacebookFriendsService facebookFriendsService

    Datastore datastore

    public void save(OpenGraphRecommendation recommendation) {
        if (recommendation.size() == 0) {
            return;
        }

        OpenGraphRecommendation dbRecommendation = query(recommendation.getProfile()).get();

        if (dbRecommendation != null) {
            recommendation.setId(dbRecommendation.getId());
        }

        datastore.save(recommendation);
    }

    public OpenGraphRecommendation findRecommendation(FacebookIdAndName profile) {
        return query(profile).get();
    }

    def buildRecommendations(FacebookProfile facebookProfile) {
        List<FacebookProfileRef> myFriends = facebookFriendsService.findFriends(facebookProfile.toRef());

        OpenGraphActionStats stats = findStats(last7Days()).filterByFriends(myFriends);

        OpenGraphRecommendation recommendation = OpenGraphRecommendation.forProfile(facebookProfile);

        for (OpenGraphQuery query : openGraphQueryService.findAll()) {
            OpenGraphActionStats filteredStats = stats.filterByQuery(com.github.funreco.domain.query.Query.parse(query.getQuery()));

            List<RecommendedObject> objects = new ArrayList<RecommendedObject>();

            for (OpenGraphActionStat stat : filteredStats.iterate()) {
                List<FacebookProfileRef> mutualFiends = mutualFiends(stat, myFriends);

                objects.add(RecommendedObject.object(stat.getObject()).by(mutualFiends));
            }

            recommendation.forQuery(query.getQuery()).recommend(objects);
        }

        save(recommendation)
    }

    private List<FacebookProfileRef> mutualFiends(OpenGraphActionStat stat, List<FacebookProfileRef> myFriends) {
        return (List<FacebookProfileRef>) CollectionUtils.intersection(myFriends, stat.getProfiles());
    }

    private Interval last7Days() {
        DateTime now = new DateTime();
        return new Interval(now.minusDays(7), now);
    }

    private OpenGraphActionStats findStats(Interval interval) {
        Query<OpenGraphAction> query = datastore.find(OpenGraphAction.class)
                .filter("date >=", interval.getStart().toDate())
                .filter("date <", interval.getEnd().toDate());

        return OpenGraphActionStats.fromActions(query);
    }

    private Query<OpenGraphRecommendation> query(FacebookIdAndName profile) {
        Query<OpenGraphRecommendation> query = datastore.find(OpenGraphRecommendation.class);

        if (profile == null) {
            query.filter("profile", null);
        } else {
            query.filter("profile.facebookId", profile.getFacebookId());
        }

        return query;
    }
}
