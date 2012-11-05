package com.github.dbourdette.rest

import grails.test.mixin.*
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

@TestFor(ProfileRestController)
class ProfileRestControllerTests {

    void testSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.updateProfile(1..1) {Profile profile -> profile}
		controller.recommendationFacade = facade.createMock()
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName")
		ObjectMapper mapper = new ObjectMapper()
		String jsonString = mapper.writeValueAsString(profile)
		params.profile = jsonString
		controller.save()
		
		facade.verify()
		assert response.text == jsonString
	}

}
