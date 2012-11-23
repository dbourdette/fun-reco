package com.github.dbourdette.rest

import grails.test.mixin.*
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Object;
import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

@TestFor(ActionRestController)
class ActionRestControllerTests {

    private static final String FACEBOOK_ID = "testFB"

    private static final Date ACTION_DATE = new Date()

    private def facade;

    void testSuccessfulUpdate() {
        controller.recommendationFacade = createMock {Action action -> action}
		params.action = testProfileJson()
		params.facebookId = FACEBOOK_ID

		controller.update()
		
		facade.verify()
		assert response.status == 200
		assert response.text == testProfileJson()
	}
	
	void testFailUpdate() {
        controller.recommendationFacade = createMock {Action action -> null}
        params.action = testProfileJson()
		params.facebookId = FACEBOOK_ID

		controller.update()
		
		facade.verify()
		assert response.status == 500
	}
	
	void testUpdateWithDifferentIds() {
        params.action = testProfileJson()
		params.facebookId = "wrongTestFB"

		controller.update()

		assert response.status == 500
	}

    private RecommendationFacade createMock(Closure closure) {
        facade = mockFor(RecommendationFacade)
        facade.demand.pushAction(1..1, closure)
        facade.createMock()
    }

    private String testProfileJson() {
        Profile profile = new Profile(facebookId: FACEBOOK_ID, email: "testEmail", name: "testName")
        Object object = new Object(id: "testObjectId", objectProperties: ["type": ["video", "show"], "animateur": ["nomAnimateur"]])
        Action action = new Action(profile: profile, object: object, date: ACTION_DATE)

        new ObjectMapper().writeValueAsString(action)
    }
	
	

}
