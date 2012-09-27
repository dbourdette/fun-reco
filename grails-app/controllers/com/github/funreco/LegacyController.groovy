package com.github.funreco

import com.github.funreco.legacy.engine.RecommendationEngine
import com.github.funreco.legacy.bootstrap.BootstrapDB

/**
 * Actions for legacy reco engine.
 */
class LegacyController {
    RecommendationEngine recommendationEngine

    BootstrapDB bootstrapDB

    RecommendationFacade recommendationFacade

    def index() {
        render(view: "/legacy/index")
    }

    def build() {
        recommendationEngine.reloadStatsAndQueries()

        recommendationEngine.buildGenericRecommendations()

        redirect(action: "index")
    }

    def buildForProfile() {
        Profile profile = recommendationFacade.findProfile(params.email, params.facebookId);

        if (!profile) {
            return render(view: "/legacy/index", model: [errorMessage: "Profile not found"])
        }

        recommendationEngine.reloadStatsAndQueries()

        recommendationEngine.buildRecommendations(profile.getFacebookId())

        redirect(action: "index")
    }

    def bootstrap() {
        try {
            bootstrapDB.reset()

            return redirect(view: "/legacy/index")
        } catch (Exception e) {
            return render(view: "/legacy/index", model: [errorMessage: e.message])
        }
    }
}
