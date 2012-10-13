package com.github.funreco

import com.mongodb.util.JSON
import fun.reco.Document

class DocumentController {

	def show = {
		if(params.id && Document.exists(params.id)){
			render Document.findById(params.id) as JSON
		}else{
			render Document.list() as JSON
		}
	}

	def save = {
		def doc = new Document(params['document'])
		if(doc.save()){
			render doc as JSON
		}else{
			render doc.errors
		}
	}
	
	def update = {
		if(params.id && Document.exists(params.id)){
			// update the doc
		}else{
			// render error 
		}
	}
	
	def remove = {
		if(params.id && Document.exists(params.id)){
			// delete the doc
		}else{
			// render error
		}
	}
}

