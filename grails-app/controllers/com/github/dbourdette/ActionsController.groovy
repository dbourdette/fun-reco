package com.github.dbourdette

import com.github.dbourdette.api.RecommendationFacade;

class ActionsController {

    RecommendationFacade recommendationFacade

    def index() {
        int offset = params.offset ? params.int("offset") : 0
        int limit = params.max ? params.int("max") : 10
		
		def actions
		if (params.facebookIdForAction) {
			actions = recommendationFacade.findActions(params.facebookIdForAction, 0, 100);
		} else {
			actions = recommendationFacade.findActions(offset, limit)
		}
		if (actions.size() == 0) {
			flash.error = "No actions to display"
		}
        [actions: actions, total: recommendationFacade.countActions()]
    }
	
}