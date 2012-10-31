package com.github.dbourdette.stub;

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Friend;
import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.Recommendation;
import com.github.dbourdette.api.Recommendations;

class StubRecommendationFacadeTests{

	StubRecommendationFacade recommendationFacade
	StubRecommendationFacadeData stubRecommendationFacadeData

	void setUp(){
		recommendationFacade = new StubRecommendationFacade()
		stubRecommendationFacadeData = new StubRecommendationFacadeData()
	}

	void testFindProfile() {
		assert recommendationFacade.findProfile("", "") == stubRecommendationFacadeData.profile
	}

	void testFindProfileAttributsComparison() {
		assert recommendationFacade.findProfile("", "").facebookId == stubRecommendationFacadeData.profile.facebookId
		assert recommendationFacade.findProfile("", "").email == stubRecommendationFacadeData.profile.email
		assert recommendationFacade.findProfile("", "").name == stubRecommendationFacadeData.profile.name
	}

	void testFindFriends() {
		assert recommendationFacade.findFriends("") == stubRecommendationFacadeData.friendsList
	}

	void testFindActions() {
		def listActions = stubRecommendationFacadeData.actions
		recommendationFacade.findActions(0, 10).eachWithIndex() { obj, i -> assert obj == listActions.get(i) };
		recommendationFacade.findActions("", 0, 10).eachWithIndex() { obj, i -> assert obj == listActions.get(i) };
	}

	void testCountActions() {
		assert recommendationFacade.countActions() == 2
	}

	void testFindDefaultRecommendations() {
		assert recommendationFacade.findDefaultRecommendations() == stubRecommendationFacadeData.recommendations
	}

	void testFindRecommendations() {
		assert recommendationFacade.findRecommendations("") == stubRecommendationFacadeData.recommendations
	}
}
