package com.github.funreco

import com.github.funreco.domain.FacebookProfile
import com.github.funreco.engine.RecommendationEngine
import com.github.funreco.service.FacebookFriendsService
import com.github.funreco.service.FacebookLikesRecommendationService
import com.github.funreco.service.FacebookProfileService
import com.github.funreco.service.OpenGraphActionService
import com.github.funreco.service.OpenGraphQueryService
import com.google.code.morphia.Datastore
import org.apache.commons.lang.StringUtils
import org.bson.types.ObjectId
import com.github.funreco.bootstrap.BootstrapDB

class IndexController {

    Datastore datastore

    OpenGraphQueryService openGraphQueryService

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
            model["actions"] = openGraphActionService.findLatests();
        } else {
            model["recommendation"] = recommendationEngine.findRecommendation(profile);
            model["actions"] = openGraphActionService.findLatestsByProfile(profile);
            model["facebookLikesRecommendation"] = facebookLikesRecommendationService.findRecommendation(profile);
            model["friends"] = facebookFriendsService.findFriends(profile);
        }

        render(view: "/index", model : model)
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

    def buildRecommendations() {
        FacebookProfile profile = datastore.get(FacebookProfile.class, new ObjectId(params.id))

        recommendationEngine.buildStats()
        recommendationEngine.loadQueries()
        recommendationEngine.buildRecommendations(profile)

        redirect(action: 'profile', id: params.id)
    }
}
