package com.github.funreco

import fun.reco.Object
import org.junit.Test

class ObjectTests extends GroovyTestCase {

    @Test
	void save() {
        Object object = TestData.testObject(["type": ["video", "show"], "animateur": ["nomAnimateur"]])

        object.save()
	
		assert object.id
		assert Object.get(object.id)
	}
}
