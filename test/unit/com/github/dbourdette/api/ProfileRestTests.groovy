package com.github.dbourdette.api

import grails.test.mixin.*
import org.codehaus.jackson.map.ObjectMapper

@TestFor(ProfileRestController)
class ProfileRestTests {

    void testSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.updateProfile(1..1) {Profile profile -> profile}
		facade.createMock()
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName")
		ObjectMapper mapper = new ObjectMapper()
		String jsonString = mapper.writeValueAsString(profile)
		params.profile = jsonString
		controller.save()
		facade.verify()
	}

}
