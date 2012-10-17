package com.github.funreco;

import fun.reco.Action

import grails.converters.JSON
import groovy.util.GroovyTestCase;


class ActionRESTTests extends GroovyTestCase {
	
	void testSave() {
		def controller = new ActionRestController()
		def action  = TestData.testAction()
		def size = Action.list().size()
		controller.params.action = action.encodeAsJSON()
		controller.save()
		
		assert Action.list().size() == size + 1 
	}

}
