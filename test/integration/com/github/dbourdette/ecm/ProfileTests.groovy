package com.github.dbourdette.ecm

import java.util.List;
import org.codehaus.jackson.map.ObjectMapper
import com.mongodb.Mongo

class ProfileTests extends GroovyTestCase {
	
	def mongo
	
	void tearDown(){
		def db = mongo.getDB("fun-reco-test")
		db.dropDatabase()
	}

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








