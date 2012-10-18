package com.github.funreco

import java.util.List;

import fun.reco.Profile
import org.codehaus.jackson.map.ObjectMapper

class ProfileTests extends GroovyTestCase {

	void testSave() {
		Profile profile = TestData.testProfile()

        profile.save(flush: true)

		assert profile.id
		assert Profile.get(profile.id)
		
	}
	
	void testJackson() {
		String json = """{
		  "facebookId" : "testFacebookId",
		  "email" : "testEmail",
		  "name" : "testName",
		  "friendsIds" : ["testId1", "testId2"] 
		}
		"""
		ObjectMapper mapper = new ObjectMapper();
		Profile profile = mapper.readValue(json, Profile.class);
		
		assert profile.facebookId == "testFacebookId"
		assert profile.email == "testEmail"
		assert profile.name == "testName"
		assert profile.friendsIds == ["testId1", "testId2"]

	}
	
}








