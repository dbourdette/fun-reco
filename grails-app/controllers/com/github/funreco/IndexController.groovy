package com.github.funreco

class IndexController {

	//RecommendationFacade recommendationFacade
	StubRecommendationFacade stubRecommendationFacade = new StubRecommendationFacade()

    def index() {
        Profile profile = stubRecommendationFacade.findProfile(params.email, params.facebookId);
		
		
        def model = [
                email : params.email,
                facebookId : params.facebookId,
                profile : profile
        ]

        if (profile == null) {
            model["recommendation"] = stubRecommendationFacade.findDefaultRecommendations();
			println model["recommendation"]
            model["actions"] = stubRecommendationFacade.findActions(0, 10);
        } else {
            model["recommendation"] = stubRecommendationFacade.findRecommendations(profile.facebookId);
            model["actions"] = stubRecommendationFacade.findActions(profile.facebookId, 0, 10);
            model["friends"] = stubRecommendationFacade.findFriends(profile.facebookId);
        }
		
		if (params.errorMessage != null) {
			model["errorMessage"] = params.errorMessage;
		}

        render(view: "/index", model : model)
    }
}
