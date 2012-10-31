package com.github.dbourdette.api

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*
import org.codehaus.jackson.map.ObjectMapper

class ProfileRestController {

	RecommendationFacade recommendationFacade
	
		def show() {
			response.status = 500
			render ([error: 'Operation not allowed'] as JSON)
		}
	
		def save() {
			if (params.profile) {
				ObjectMapper mapper = new ObjectMapper();
				Profile profile = mapper.readValue(params.profile, Profile.class);
				if (recommendationFacade.updateProfile(profile)) {
					render profile as JSON
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
