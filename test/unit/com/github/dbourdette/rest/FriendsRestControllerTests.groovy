package com.github.dbourdette.rest

import grails.test.mixin.*
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Friend;
import com.github.dbourdette.api.RecommendationFacade;

@TestFor(FriendsRestController)
class FriendsRestControllerTests {

    void testSuccessfulShow() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.findFriends(1..1) {String facebookId -> [new Friend(name: "nameFriend1", facebookId: "testFB1"), new Friend(name: "nameFriend2", facebookId: "testFB2")]}
		controller.recommendationFacade = facade.createMock()
		params.facebookId = "testFacebookId"
		controller.show()
		
		facade.verify()
		ObjectMapper mapper = new ObjectMapper()
		List<Friend> friends = [new Friend(name: "nameFriend1", facebookId: "testFB1"), new Friend(name: "nameFriend2", facebookId: "testFB2")]
		String jsonString = mapper.writeValueAsString(friends)
		assert response.status == 200
		assert response.text == jsonString
	}
	
	void testFailShow() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.findFriends(1..1) {String facebookId -> null}
		controller.recommendationFacade = facade.createMock()
		params.facebookId = "testFacebookId"
		controller.show()
		
		facade.verify()
		assert response.status == 500
	}

    void testSuccessfulSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.updateFriends(1..1) {String facebookId, List<Friend> friends -> facebookId}
		controller.recommendationFacade = facade.createMock()
		List<Friend> friends = [new Friend(name: "nameFriend1", facebookId: "testFB1"), new Friend(name: "nameFriend2", facebookId: "testFB2")]
		ObjectMapper mapper = new ObjectMapper()
		String jsonString = mapper.writeValueAsString(friends)
		params.friends = jsonString
		params.facebookId = "testFB"
		controller.save()
		
		facade.verify()
		assert response.status == 200		
	}
	
	void testSaveWithoutFriends() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.updateFriends(1..1) {String facebookId, List<Friend> friends -> facebookId}
		controller.recommendationFacade = facade.createMock()
		controller.save()
		
		assert response.status == 500
	}
	
	void testFailSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.updateFriends(1..1) {String facebookId, List<Friend> friends -> null}
		controller.recommendationFacade = facade.createMock()
		List<Friend> friends = [new Friend(name: "nameFriend1", facebookId: "testFB1"), new Friend(name: "nameFriend2", facebookId: "testFB2")]
		ObjectMapper mapper = new ObjectMapper()
		String jsonString = mapper.writeValueAsString(friends)
		params.friends = jsonString
		params.facebookId = "testFB"
		controller.save()
		
		facade.verify()
		assert response.status == 500
	}

}
