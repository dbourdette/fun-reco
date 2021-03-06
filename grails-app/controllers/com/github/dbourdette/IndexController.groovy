package com.github.dbourdette

import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

class IndexController {

	RecommendationFacade recommendationFacade

    def index() {
        Profile profile = recommendationFacade.findProfile(params.email, params.facebookId);

        def model = [
                email : params.email,
                facebookId : params.facebookId,
                profile : profile
        ]

        if (profile == null) {
            model.recommendation = recommendationFacade.findDefaultRecommendations();
            model.actions = recommendationFacade.findActions(0, 10);
        } else {
            model.recommendation = recommendationFacade.findRecommendations(profile.facebookId);
            model.actions = recommendationFacade.findActions(profile.facebookId, 0, 10);
            model.friends = recommendationFacade.findFriends(profile.facebookId);
        }
		
		if (params.errorMessage != null) {
			model.errorMessage = params.errorMessage;
		}

        render(view: "/index", model : model)
    }
}
