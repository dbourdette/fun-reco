package com.github.funreco

class ActionsController {

    RecommendationFacade recommendationFacade

    def index() {
        int offset = params.offset ? params.int("offset") : 0
        int limit = params.max ? params.int("max") : 10

        [actions: recommendationFacade.findActions(offset, limit), total: recommendationFacade.countActions()]
    }
	
	def persistence() {
		def test = new Persistence(first:"Angela",last:"Prestaux", number:29)
		test.save()
	}
	
}