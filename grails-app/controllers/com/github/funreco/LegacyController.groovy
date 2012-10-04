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

		flash.success = "Recommendations have been built"

        redirect(action: "index")
    }

    def buildForProfile() {
        Profile profile = recommendationFacade.findProfile(params.email, params.facebookId);

        if (profile) {
            recommendationEngine.reloadStatsAndQueries()
            recommendationEngine.buildRecommendations(profile.getFacebookId())

            flash.success = "Recommendations have been built for " + profile.getName()
        } else {
            flash.error = "Profile not found"
        }

        redirect(action: "index")
    }

	def bootstrap() {
		try {
			bootstrapDB.reset()
			flash.success = "DB has been bootstraped"
		} catch (Exception e) {
			flash.error = e.toString()
		}

        redirect(action: 'index')
	}
}
