package com.github.funreco

import fun.reco.Action
import fun.reco.Object

class ActionTests extends GroovyTestCase {

	void testSave() {
        Object object = TestData.testObject(['type':['video', 'show']])
        Action action = new Action(profile: TestData.testProfile(), object: object, date: new Date())

        action.save(flush: true)
	
		assert action.id
		assert Action.get(action.id)
	}
}

