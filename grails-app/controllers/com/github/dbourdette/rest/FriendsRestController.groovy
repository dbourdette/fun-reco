package com.github.dbourdette.rest

import com.github.dbourdette.api.Friend
import com.github.dbourdette.api.RecommendationFacade
import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.codehaus.jackson.map.ObjectMapper

class FriendsRestController {

	ObjectMapper mapper = new ObjectMapper()

    RecommendationFacade recommendationFacade

	@Secured(['IS_AUTHENTICATED_FULLY'])
	def show() {
		def friends = recommendationFacade.findFriends(params.facebookId)

        if (friends) {
			render mapper.writeValueAsString(friends)
		} else{
			response.status = 404
			render ([error: 'Profile not found'] as JSON)
		}
	}

	@Secured(['IS_AUTHENTICATED_FULLY'])
	def save() {
        def friends = []
        request.JSON.each { friends << new Friend(it) }

        try {
            recommendationFacade.updateFriends(params.facebookId, friends)
            render ([status: 'success'] as JSON)
        } catch (e) {
            response.status = 500
            render ([status: 'error', reason: "Failed to update friends, reason: ${e.message}"] as JSON)
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
		render ([error: 'Operation (yet ?) not allowed'] as JSON)
	}
}
