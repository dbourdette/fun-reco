package com.github.funreco

import com.github.funreco.legacy.bootstrap.BootstrapDB
import com.github.funreco.legacy.engine.RecommendationEngine

class IndexController {

    RecommendationEngine recommendationEngine

    RecommendationFacade recommendationFacade

    BootstrapDB bootstrapDB

    def index() {
        Profile profile = recommendationFacade.findProfile(params.email, params.facebookId);

        def model = [
                email : params.email,
                facebookId : params.facebookId,
                profile : profile
        ]

        if (profile == null) {
            model["recommendation"] = recommendationFacade.findDefaultRecommendations();
            model["actions"] = recommendationFacade.findActions(0, 10);
        } else {
            model["recommendation"] = recommendationFacade.findRecommendations(profile.facebookId);
            model["actions"] = recommendationFacade.findActions(profile.facebookId, 0, 10);
            model["friends"] = recommendationFacade.findFriends(profile.facebookId);
        }

        render(view: "/index", model : model)
    }

    def buildRecommendations() {
        Profile profile = recommendationFacade.findProfile(params.email, params.facebookId);

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
}
