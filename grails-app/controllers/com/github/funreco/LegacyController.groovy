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
            flash.error = "Profile not found"
			return redirect(action: "index")
        }

        recommendationEngine.reloadStatsAndQueries()

        recommendationEngine.buildRecommendations(profile.getFacebookId())

        redirect(action: "index")
    }

	def bootstrap() {
		try {
			bootstrapDB.reset()
			flash.success = "DB has been bootstraped"
			redirect(action: 'index')
		} catch (Exception e) {
			flash.error = e.toString()
			redirect(action: 'index')
		}
	}
}
