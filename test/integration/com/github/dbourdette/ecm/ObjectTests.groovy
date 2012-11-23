package com.github.dbourdette.ecm

class ObjectTests extends GroovyTestCase {

	void testSave() {
		Object obj = new Object(date: new Date(), objectId: "testObjectId", objectProperties: ["type": ["video", "show"], "animateur": ["nomAnimateur"]])

        obj.save(flush: true)
	
		assert obj.id
		assert Object.get(obj.id).objectProperties == obj.objectProperties
		assert Object.get(obj.id).objectProperties == ["type": ["video", "show"], "animateur": ["nomAnimateur"]]
		assert obj.objectProperties == ["type": ["video", "show"], "animateur": ["nomAnimateur"]]
	}
}
