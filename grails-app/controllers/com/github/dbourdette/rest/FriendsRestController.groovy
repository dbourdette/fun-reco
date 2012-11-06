package com.github.dbourdette.rest

import java.util.List;

import grails.plugins.springsecurity.Secured
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.type.TypeReference

import com.github.dbourdette.api.Friend;
import com.github.dbourdette.api.RecommendationFacade;

class FriendsRestController {

	ObjectMapper mapper = new ObjectMapper();
    RecommendationFacade recommendationFacade

	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	def show() {
		def foundFriends = recommendationFacade.findFriends(params.facebookId)
		if (foundFriends) {
			render mapper.writeValueAsString(foundFriends)
		}else{
			response.status = 500
			render ([error: 'Profile not found'] as JSON)
		}
	}

	@Secured(['IS_AUTHENTICATED_FULLY'])
	def save() {
		if (params.friends) {
			List<Friend> friends = mapper.readValue(params.friends, new TypeReference<List<Friend>>(){})
			if (recommendationFacade.updateFriends(params.facebookId, friends)) {
				response.status = 200
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
