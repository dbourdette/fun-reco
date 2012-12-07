package com.github.dbourdette.ecm

import com.mongodb.Mongo

class ObjectTests extends GroovyTestCase {
	
	def mongo
	
	void tearDown(){
		def db = mongo.getDB("fun-reco-test")
		db.dropDatabase()
	}

	void testSave() {
		
		def properties = ["type": ["video", "show"], "animateur": ["nomAnimateur"]]
		Object obj = new Object(date: new Date(), objectId: "testObjectId", objectProperties: properties)

        obj.save(flush: true)
	
		assert obj.id
		assert Object.get(obj.id).objectProperties == obj.objectProperties
		assert Object.findByObjectId("testObjectId").objectProperties == properties
	}
}
