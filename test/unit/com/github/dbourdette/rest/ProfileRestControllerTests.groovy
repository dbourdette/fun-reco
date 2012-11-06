package com.github.dbourdette.rest

import grails.test.mixin.*
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

@TestFor(ProfileRestController)
class ProfileRestControllerTests {
	
	void testSuccessfulShow() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.findProfile(1..1) {String email, String facebookId -> new Profile(facebookId: "testFB", email: "testEmail", name: "testName")}
		controller.recommendationFacade = facade.createMock()
		params.facebookId = "testFacebookId"
		controller.show()
		
		facade.verify()
		ObjectMapper mapper = new ObjectMapper()
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName")
		String jsonString = mapper.writeValueAsString(profile)
		assert response.status == 200
		assert response.text == jsonString
	}
	
	void testFailShow() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.findProfile(1..1) {String email, String facebookId -> null}
		controller.recommendationFacade = facade.createMock()
		params.facebookId = "testFacebookId"
		controller.show()
		
		facade.verify()
		assert response.status == 500
	}

    void testSuccessfulSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.updateProfile(1..1) {Profile profile -> profile}
		controller.recommendationFacade = facade.createMock()
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName")
		ObjectMapper mapper = new ObjectMapper()
		String jsonString = mapper.writeValueAsString(profile)
		params.profile = jsonString
		params.facebookId = "testFB"
		controller.save()
		
		facade.verify()
		assert response.status == 200
		assert response.text == jsonString
		
	}
	
	void testSaveWithoutProfile() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.updateProfile(1..1) {Profile profile -> profile}
		controller.recommendationFacade = facade.createMock()
		controller.save()
		
		assert response.status == 500
	}
	
	void testSaveWithDifferentIds() {
		def facade = mockFor(RecommendationFacade)
		facade.demand.updateProfile(1..1) {Profile profile -> profile}
		controller.recommendationFacade = facade.createMock()
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName")
		ObjectMapper mapper = new ObjectMapper()
		String jsonString = mapper.writeValueAsString(profile)
		params.profile = jsonString
		params.facebookId == "differentTestFB"
		controller.save()
		
		assert response.status == 500
	}

}
