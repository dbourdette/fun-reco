package com.github.funreco

import com.mongodb.util.JSON
import fun.reco.Document
import grails.converters.JSON

class DocumentController {

	def show() {
		if(params.id && Document.exists(params.id)){
			render Document.findById(params.id) as JSON
		}else{
			render Document.list() as JSON
		}
	}

	def save() {
		if (!params.id) {
			def doc = new Document(params.document)
			if(doc.save()){
				render doc as JSON
			}else{
				response.status = 500
				render ([error: doc.errors] as JSON)
			}
		}else{
			response.status = 500
			render ([error: 'Operation not allowed'] as JSON)
		}
		
	}
	
	def update() {
		if(params.id && Document.exists(params.id)){
			def doc = Document.get(params.id)
			if (params.title) {doc.title = params.title}
			if (params.content) {doc.content = params.title}
			doc.save()
		}else{
			response.status = 500
			render ([error: 'Document with this id does not exist'] as JSON)
		}
	}
	
	def remove() {
		if(params.id && Document.exists(params.id)){
			def doc = Document.get(params.id)
			doc.delete()
		}else{
			response.status = 500
			render ([error: 'Document with this id does not exist'] as JSON)
		}
	}
}

