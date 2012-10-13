package com.github.funreco

class ActionsController {

    //RecommendationFacade recommendationFacade
	StubRecommendationFacade stubRecommendationFacade = new StubRecommendationFacade()

    def index() {
        int offset = params.offset ? params.int("offset") : 0
        int limit = params.max ? params.int("max") : 10

        [actions: stubRecommendationFacade.findActions(offset, limit), total: stubRecommendationFacade.countActions()]
    }
	
}