package com.github.funreco

import fun.reco.Document

import grails.test.mixin.TestFor
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import grails.converters.JSON

@TestFor(DocumentController)
class DocumentRESTTests {
	
	@Before
	void init() {
		def doc1 = new Document(title: "title1", content: "content1")
		doc1.save(flush:true)
		def doc2 = new Document(title: "title2", content: "content2")
		doc2.save(flush:true)
	}
	 
	@Test
	void testShow() {
	
		controller.show()

		assert response.text == Document.list().encodeAsJSON()

	}
	
	@Test
	void testShowWithId() {
		def doc = Document.findByTitle("title1")
		params.id = doc.id
		
		controller.show()

		assert response.text == doc.encodeAsJSON()
	}
	
	@Test
	void testSave() {
		def doc3 = new Document(title: "title3", content: "content3")
		params.document = doc3.encodeAsJSON()
		
		controller.save()
		
		assert Document.findByTitle("title3")
		assert response.text == doc3.encodeAsJSON()
	}
	
	@Test
	void testUpdate() {
		def doc = Document.findByTitle("title1")
		params.id = doc.id
		params.title = "newTitle"
		
		controller.update()
		
		assert Document.get(doc.id).title == "newTitle"
	}
	
	@Test
	void testDelete() {
		def doc = Document.findByTitle("title1")
		params.id = doc.id
		
		controller.delete()
		
		assert !Document.get(doc.id)
	}
}
