package com.github.funreco

import fun.reco.Object;
import groovy.util.GroovyTestCase;


class ObjectTests extends GroovyTestCase {
	
	void testPersistence() {
		def testProperties = ["type": ["video", "show"], "animateur": ["nomAnimateur"]]
		
		def o = new Object(objectId: "testObjectId", properties: testProperties)
		o.save()
	
		assert o.id != null
	
		def test = Object.get(o.id)
	
		assert test != null
	}
}
