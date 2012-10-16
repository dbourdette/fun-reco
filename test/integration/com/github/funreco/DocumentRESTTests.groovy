package com.github.funreco

import fun.reco.Document

import grails.converters.JSON
import groovy.util.GroovyTestCase;


class DocumentRESTTests extends GroovyTestCase {
	
	void setUp() {
		new Document(title: "title1", content: "content1").save(flush:true)
		new Document(title: "title2", content: "content2").save(flush:true)
	}
	 
	void testShow() {
		def controller = new DocumentController()
		controller.show()
		
		assertEquals Document.list().encodeAsJSON(), controller.response.contentAsString
	}
	
	void testShowWithId() {
		def controller = new DocumentController()
		def doc = Document.findByTitle("title1")
		controller.params.id = doc.id
		controller.show()

		assertEquals doc.encodeAsJSON(), controller.response.contentAsString
	}
	
	void testSave() {
		def controller = new DocumentController()
		String json = """{
		  "title" : "title3",
		  "content" : "content3"
		}
		"""
		controller.params.document = json
		controller.save()
		
		assert Document.findByTitle("title3")
	}
	
	void testUpdate() {
		def controller = new DocumentController()
		def doc = Document.findByTitle("title1")
		controller.params.id = doc.id
		controller.params.title = "newTitle"
		controller.update()
		
		assert Document.get(doc.id).title == "newTitle"
	}
	
	void testDelete() {
		def controller = new DocumentController()
		def doc = Document.findByTitle("title1")
		controller.params.id = doc.id
		controller.delete()
		
		assert Document.get(doc.id) == null
	}
}
