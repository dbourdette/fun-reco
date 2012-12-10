package com.github.dbourdette.rest

import grails.plugins.springsecurity.Secured
import grails.converters.JSON
import org.codehaus.jackson.map.ObjectMapper

import com.github.dbourdette.api.Profile;
import com.github.dbourdette.api.RecommendationFacade;

class ProfileRestController {
	
	ObjectMapper mapper = new ObjectMapper();

	RecommendationFacade recommendationFacade
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def show() {
		def foundProfile = recommendationFacade.findProfile("", params.facebookId)

        if (foundProfile) {
			render mapper.writeValueAsString(foundProfile)
		} else{
			response.status = 404
			render ([status: 'error', error: 'Profile not found'] as JSON)
		}
	}
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def save() {
        try {
            recommendationFacade.updateProfile(new Profile(request.JSON))
            render ([status: 'success'] as JSON)
        } catch (e) {
            response.status = 500
            render ([status: 'error', reason: "Failed to update profile, reason: ${e.message}"] as JSON)
        }
	}
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def update() {
		response.status = 405
		render ([error: 'Operation not allowed'] as JSON)
	}
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def delete() {
		response.status = 405
		render ([error: 'Operation not (yet ?) allowed'] as JSON)
	}
}
