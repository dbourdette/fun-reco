package com.github.funreco

import com.mongodb.util.JSON
import fun.reco.Document
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*

class DocumentController {

	def show() {
		if(params.id && Document.exists(params.id)){
			render Document.findById(params.id) as JSON
		}else{
			render Document.list() as JSON
		}
	}

	def save() {
		if (!params.id && params.document) {
			def logJson = new JSONArray("["+params.document+"]");
			def doc = new Document(new JSONObject(logJson[0]))
			if (doc.save(flush:true)) {
				render doc as JSON
			}else{
			response.status = 500
			render ([error: 'Parsing failed'] as JSON)
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
	
	def delete() {
		if(params.id && Document.exists(params.id)){
			Document.get(params.id).delete(flush:true)
		}else{
			response.status = 500
			render ([error: 'Document with this id does not exist'] as JSON)
		}
	}
}

