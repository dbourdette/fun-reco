package com.github.funreco

import com.github.funreco.domain.FacebookProfile
import com.github.funreco.domain.OpenGraphAction
import com.github.funreco.domain.OpenGraphObject
import com.github.funreco.service.OpenGraphActionService
import com.github.funreco.service.FacebookProfileService
import com.google.code.morphia.Datastore

class ActionsController {
	
	Datastore datastore
	
	OpenGraphActionService openGraphActionService

    def index() {
		
		def model = [
			actions : openGraphActionService.findLatests(-1),
			actionCount : 78
		]
		

        render(view: "/actions/index", model : model)
    }
	
}

