package com.github.funreco;

import fun.reco.Profile

import groovy.util.GroovyTestCase;
import grails.converters.JSON

class ProfileRESTTests extends GroovyTestCase {
	
	void testSave() {
		def controller = new ProfileRestController()
		def profile  = TestData.testProfile()
		def size = Profile.list().size()
		controller.params.profile = profile.encodeAsJSON()
		controller.save()
		
		assert Profile.list().size() == size + 1
	}

}
