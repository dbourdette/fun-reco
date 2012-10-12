package com.github.funreco

import fun.reco.Action
import fun.reco.Object
import org.junit.Test

class ActionTests extends GroovyTestCase {

    @Test
	void save() {
        Object object = TestData.testObject(['type':['video', 'show']])
        Action action = new Action(profile: TestData.testProfile(), object: object, date: new Date())

        action.save()
	
		assert action.id
		assert Action.get(action.id)
	}
}

