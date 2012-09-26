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
		
		if (params.error_message != null) {
			model["error_message"] = params.error_message;
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
		def error_message;
		try {
			bootstrapDB.reset()
		}
		catch (Exception e) {
			error_message = e.message;
		}

        redirect(action: "index", params : [error_message : error_message])
    }
}
