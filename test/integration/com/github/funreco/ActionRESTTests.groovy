package com.github.funreco;

import fun.reco.Action

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import grails.converters.JSON
import groovy.util.GroovyTestCase;


class ActionRESTTests extends GroovyTestCase {
	
	@Before
	void init() {
		def action1  = TestData.testAction()
		action1.save(flush:true)
		def action2  = TestData.testAction()
		action2.save(flush:true)
	}
	 
	@Test
	void testShow() {
		def controller = new ActionRestController()
		controller.show()
		
		assertEquals Action.list().encodeAsJSON(), controller.response.contentAsString
	}
	
	@Test
	void testShowWithId() {
		def controller = new ActionRestController()
		def action = Action.list().get(0)
		controller.params.id = action.id
		controller.show()

		assertEquals action.encodeAsJSON(), controller.response.contentAsString
	}
	
	@Test
	void testSave() {
		def controller = new ActionRestController()
		def action3  = TestData.testAction()
		def size = Action.list().size()
		controller.params.action = action3.encodeAsJSON()
		controller.save()
		
		assert Action.list().size() == size + 1 
	}
	
	@Test
	void testDelete() {
		def controller = new ActionRestController()
		def action = Action.list().get(0)
		controller.params.id = action.id
		controller.delete()
		
		assert Action.get(action.id) == null
	}

}
