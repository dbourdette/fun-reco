package com.github.funreco

import fun.reco.Persistence;
import groovy.util.GroovyTestCase

class PersistenceTest extends GroovyTestCase {
	
	void testPersistenceMongo() {
		def p = new Persistence(first:"Angela",last:"Prestaux", number:29)
		p.save()
	
		assert p.id != null
	
		def test = Persistence.get(p.id)
	
		assert test != null
	}
}
