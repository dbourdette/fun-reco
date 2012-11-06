package com.github.dbourdette.rest

import grails.plugins.springsecurity.Secured
import grails.converters.JSON
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

class ProfileRestController {

	RecommendationFacade recommendationFacade
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	def show() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def save() {
		if (params.profile) {
			ObjectMapper mapper = new ObjectMapper();
			Profile profile = mapper.readValue(params.profile, Profile.class);
			if (recommendationFacade.updateProfile(profile)) {
				render mapper.writeValueAsString(profile)
			}else{
				response.status = 500
				render ([error: 'Parsing failed'] as JSON)
			}
		}else{
			response.status = 500
			render ([error: 'Operation not allowed'] as JSON)
		}
	}
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def update() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def delete() {
		response.status = 500
		render ([error: 'Operation not allowed'] as JSON)
	}
}
