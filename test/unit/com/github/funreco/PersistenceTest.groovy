package com.github.funreco

import groovy.util.GroovyTestCase

class PersitenceTest extends GroovyTestCase {
	void testPersistence() {
		def test = new Persistence(first:"Angela",last:"Prestaux", number:29)
		def test2 = Persistence.findAll()
		assert test == test2
	}
}
