package com.github.dbourdette.api

import grails.test.mixin.*

@TestFor(ProfileRestController)
class ProfileRestTests {

    void testSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.updateProfile(1..1) {Profile profile -> profile}
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName")
		params.profile = profile
		controller.save()

		facade.verify()
	}

}
