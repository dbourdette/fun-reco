package com.github.funreco

import com.github.funreco.bootstrap.BootstrapDB
import com.github.funreco.domain.FacebookProfile
import com.github.funreco.engine.RecommendationEngine
import com.github.funreco.service.FacebookFriendsService
import com.github.funreco.service.FacebookLikesRecommendationService
import com.github.funreco.service.FacebookProfileService
import com.github.funreco.service.OpenGraphActionService
import com.google.code.morphia.Datastore
import org.apache.commons.lang.StringUtils

class IndexController {

    Datastore datastore

    FacebookProfileService facebookProfileService

    RecommendationEngine recommendationEngine

    OpenGraphActionService openGraphActionService

    FacebookFriendsService facebookFriendsService

    FacebookLikesRecommendationService facebookLikesRecommendationService

    BootstrapDB bootstrapDB

    def index() {
        FacebookProfile profile = findByEmailOrFacebookId(params.email, params.facebookId);

        def model = [
                email : params.email,
                facebookId : params.facebookId,
                profile : profile
        ]

        if (profile == null) {
            model["recommendation"] = recommendationEngine.findGenericRecommendation();
            model["actions"] = openGraphActionService.findLatests(10);
        } else {
            model["recommendation"] = recommendationEngine.findRecommendation(profile);
            model["actions"] = openGraphActionService.findLatestsByProfile(profile);
            model["facebookLikesRecommendation"] = facebookLikesRecommendationService.findRecommendation(profile);
            model["friends"] = facebookFriendsService.findFriends(profile);
        }

        render(view: "/index", model : model)
    }

    def buildRecommendations() {
        FacebookProfile profile = findByEmailOrFacebookId(params.email, params.facebookId);

        recommendationEngine.reloadStatsAndQueries()

        if (profile == null) {
            recommendationEngine.buildGenericRecommendations()
        } else {
            recommendationEngine.buildRecommendations(profile)
        }

        redirect(action: "index", params : [facebookId : params.facebookId])
    }

    def bootstrap() {
        bootstrapDB.reset()

        redirect(action: "index")
    }

    private FacebookProfile findByEmailOrFacebookId(String email, String facebookId) {
        if (StringUtils.isNotEmpty(email)) {
            return facebookProfileService.findByEmail(email);
        }

        if (StringUtils.isNotEmpty(facebookId)) {
            return facebookProfileService.findByFacebookId(facebookId);
        }

        return null;
    }
}
