package com.github.dbourdette.ecm

import com.mongodb.Mongo

class ActionTests extends GroovyTestCase {
	
	def mongo
	
	void tearDown(){
		def db = mongo.getDB("fun-reco-test")
		db.dropDatabase()
	}

	void testSave() {
        Object object = TestData.testObject(['type':['video', 'show']])
        Action action = new Action(profile: TestData.testProfile(), object: object, date: new Date())

        action.save(flush: true)
	
		assert action.id
		assert Action.get(action.id)
	}
}

