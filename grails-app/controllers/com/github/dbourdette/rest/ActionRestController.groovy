package com.github.dbourdette.rest

import grails.plugins.springsecurity.Secured
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.RecommendationFacade;

class ActionRestController {
	
	ObjectMapper mapper = new ObjectMapper()
	RecommendationFacade recommendationFacade
	
	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_REMEMBERED'])
	def show() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}

	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_FULLY'])
	def save() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
	
	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_FULLY'])
	def update() {
		if (params.action) {
			Action action = mapper.readValue(params.action, Action.class);
			if (action.profile.facebookId == params.facebookId) {
				if (recommendationFacade.pushAction(action)) {
					render mapper.writeValueAsString(action)
				}else{
					response.status = 500
					render ([error: 'Parsing failed'] as JSON)
				}
			}else{
				response.status = 500
				render ([error: 'Facebook IDs are not matching'] as JSON)
			}
		}else{
			response.status = 500
			render ([error: 'Operation not allowed'] as JSON)
		}
	}
	
	@Secured(['ROLE_ADMIN','ROLE_USER','IS_AUTHENTICATED_FULLY'])
	def delete() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
}
