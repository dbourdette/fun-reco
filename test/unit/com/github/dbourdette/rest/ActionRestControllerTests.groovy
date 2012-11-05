package com.github.dbourdette.rest

import grails.test.mixin.*
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Object;
import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

@TestFor(ActionRestController)
class ActionRestControllerTests {

    void testSave() {
		def facade = mockFor(RecommendationFacade) 
		facade.demand.pushAction(1..1) {Action action -> action}
		controller.recommendationFacade = facade.createMock()
		Profile profile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName") 
		Object object = new Object(id: "testObjectId", properties: ["type": ["video", "show"], "animateur": ["nomAnimateur"]])
		Action action = new Action(profile: profile, object: object, date: new Date())
		String jsonString = new ObjectMapper().writeValueAsString(action)
		params.action = jsonString
		controller.save()
		
		facade.verify()
		assert response.text == jsonString
	}

}
