package com.github.funreco.service

import com.github.funreco.domain.FacebookIdAndName
import com.github.funreco.domain.FacebookLikesRecommendation
import com.google.code.morphia.Datastore
import com.google.code.morphia.query.Query

class FacebookLikesRecommendationService {
    Datastore datastore;

    public void save(FacebookLikesRecommendation recommendation) {
        FacebookLikesRecommendation dbRecommendation = query(recommendation.getProfile()).get();

        if (dbRecommendation != null) {
            recommendation.setId(dbRecommendation.getId());
        }

        datastore.save(recommendation);
    }

    public FacebookLikesRecommendation findRecommendation(FacebookIdAndName profile) {
        if (profile == null) {
            return null;
        }

        return query(profile).get();
    }

    private Query<FacebookLikesRecommendation> query(FacebookIdAndName profile) {
        Query<FacebookLikesRecommendation> query = datastore.find(FacebookLikesRecommendation.class);

        query.filter("profile.facebookId", profile.getFacebookId());

        return query;
    }
}
