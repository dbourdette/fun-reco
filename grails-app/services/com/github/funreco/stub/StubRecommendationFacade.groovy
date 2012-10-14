package com.github.funreco.stub

import com.github.funreco.Action;
import com.github.funreco.Friend;
import com.github.funreco.Object;
import com.github.funreco.Profile;
import com.github.funreco.Recommendation;
import com.github.funreco.RecommendationFacade;
import com.github.funreco.Recommendations;
import com.github.funreco.RecommendedObject;


class StubRecommendationFacade implements RecommendationFacade {

	StubRecommendationFacadeData stubRecommendationFacadeData = new StubRecommendationFacadeData()
	
	def updateProfile(Profile profile) {
         throw new UnsupportedOperationException("Won't be implemented")
    }

	Profile findProfile(String email, String facebookId) {
        return stubRecommendationFacadeData.profile
    }

	def updateFriends(String facebookId, List<Friend> friends) {
        throw new UnsupportedOperationException("Won't be implemented")
    }

	List<Friend> findFriends(String facebookId) {
        return stubRecommendationFacadeData.friendsList
    }

	def pushAction(Action action) {
        throw new UnsupportedOperationException("Won't be implemented")
    }

	List<Action> findActions(int offset, int limit) {
        return stubRecommendationFacadeData.actions
    }

    List<Action> findActions(String facebookId, int offset, int limit) {
        return stubRecommendationFacadeData.actions
    }

	int countActions() {
		2
    }

	Recommendations findDefaultRecommendations() {
        return stubRecommendationFacadeData.recommendations
    }

	Recommendations findRecommendations(String facebookId) {
        return stubRecommendationFacadeData.recommendations
    }

}
