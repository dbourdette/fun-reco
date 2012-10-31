package com.github.dbourdette.api

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*
import org.codehaus.jackson.map.ObjectMapper

class ActionRestController {
	
	RecommendationFacade recommendationFacade

	def show() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}

	def save() {
		if (params.action) {
			ObjectMapper mapper = new ObjectMapper();
			Action action = mapper.readValue(params.action, Action.class);
			if (recommendationFacade.pushAction(action)) {
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
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}

	def delete() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
}
