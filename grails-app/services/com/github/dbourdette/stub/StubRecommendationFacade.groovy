package com.github.dbourdette.stub

import com.github.dbourdette.api.RecommendationFacade;
import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Friend;
import com.github.dbourdette.api.Object;
import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.Recommendation;
import com.github.dbourdette.api.Recommendations;
import com.github.dbourdette.api.RecommendedObject;


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
