package com.github.dbourdette.api

import grails.plugins.springsecurity.Secured
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*
import org.codehaus.jackson.map.ObjectMapper

class ActionRestController {
	
	RecommendationFacade recommendationFacade
	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_REMEMBERED'])
	def show() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}

	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_FULLY'])
	def save() {
		if (params.action) {
			ObjectMapper mapper = new ObjectMapper();
			Action action = mapper.readValue(params.action, Action.class);
			if (recommendationFacade.pushAction(action)) {
				render mapper.writeValueAsString(action)
			}else{
				response.status = 500
				render ([error: 'Parsing failed'] as JSON)
			}
		}else{
			response.status = 500
			render ([error: 'Operation not allowed'] as JSON)
		}
	}
	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_FULLY'])
	def update() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_FULLY'])
	def delete() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
}
