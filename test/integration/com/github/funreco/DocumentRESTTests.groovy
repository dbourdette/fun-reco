package com.github.funreco

import fun.reco.Document

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import grails.converters.JSON
import groovy.util.GroovyTestCase;


class DocumentRESTTests extends GroovyTestCase {
	
	@Before
	void init() {
		def doc1 = new Document(title: "title1", content: "content1")
		doc1.save(flush:true)
		def doc2 = new Document(title: "title2", content: "content2")
		doc2.save(flush:true)
	}
	 
	@Test
	void testShow() {
		def controller = new DocumentController()
		controller.show()
		
		assertEquals Document.list().encodeAsJSON(), controller.response.contentAsString
	}
	
	@Test
	void testShowWithId() {
		def controller = new DocumentController()
		def doc = Document.findByTitle("title1")
		controller.params.id = doc.id
		controller.show()

		assertEquals doc.encodeAsJSON(), controller.response.contentAsString
	}
	
	@Test
	void testSave() {
		def controller = new DocumentController()
		def doc3 = new Document(title: "title3", content: "content3")
		controller.params.document = doc3.encodeAsJSON()
		controller.save()
		
		assert Document.findByTitle("title3")
	}
	
	@Test
	void testUpdate() {
		def controller = new DocumentController()
		def doc = Document.findByTitle("title1")
		controller.params.id = doc.id
		controller.params.title = "newTitle"
		controller.update()
		
		assert Document.get(doc.id).title == "newTitle"
	}
	
	@Test
	void testDelete() {
		def controller = new DocumentController()
		def doc = Document.findByTitle("title1")
		controller.params.id = doc.id
		controller.delete()
		
		assert Document.get(doc.id) == null
	}
}
