package com.github.funreco

import com.mongodb.util.JSON
import fun.reco.Action
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*

class ActionRestController {
	
	RecommendationFacade recommendationFacade

	def show() {
		if(params.id && Action.exists(params.id)){
			render Action.findById(params.id) as JSON
		}else{
			render Action.list() as JSON
		}
	}

	def save() {
		if (!params.id && params.action) {
			def logJson = new JSONArray("["+params.action+"]");
			def action = new Action(new JSONObject(logJson[0]))
			if (action.save(flush:true)) {
				render action as JSON
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
		// to implement
	}

	def delete() {
		if(params.id && Action.exists(params.id)){
			Action.get(params.id).delete(flush:true)
		}else{
			response.status = 500
			render ([error: 'Document with this id does not exist'] as JSON)
		}
	}
}
