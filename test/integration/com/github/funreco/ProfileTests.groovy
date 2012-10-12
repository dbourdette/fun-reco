package com.github.funreco

import fun.reco.Profile;
import groovy.util.GroovyTestCase;

class ProfileTests extends GroovyTestCase {
	
	void testPersistence() {
		def testFriendsList = ["testId1", "testId2"]
		
		def p = new Profile(facebookId: "testFB", email: "testEmail", name: "testName", friendsList: testFriendsList)
		p.save()
	
		assert p.id != null
	
		def test = Profile.get(p.id)
	
		assert test != null
	}
}
