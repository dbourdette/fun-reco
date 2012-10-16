package com.github.funreco

import fun.reco.Object

class ObjectTests extends GroovyTestCase {

	void testSave() {
        Object object = TestData.testObject(["type": ["video", "show"], "animateur": ["nomAnimateur"]])

        object.save(flush: true)
	
		assert object.id
		assert Object.get(object.id)
	}
}
