package com.github.funreco

import fun.reco.Action
import fun.reco.Object;
import fun.reco.Profile;
import groovy.util.GroovyTestCase


class ActionTests extends GroovyTestCase {
	
	void testPersistence() {
		def testFriendsList = ["testId1", "testId2"]
		def testProfile = new Profile(facebookId: "testFB", email: "testEmail", name: "testName", friendsList: testFriendsList)
		def testMap = ['type':['video', 'show']]
		def testObject = new Object(objectId: "testObjectId", properties: testMap)
		
		def a = new Action(profile: testProfile, object: testObject, date: new Date())
		a.save()
	
		assert a.id != null
	
		def test = Action.get(a.id)
	
		assert test != null
	}
}

