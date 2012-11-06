class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/api/profile/$facebookId"(resource: "profileRest")
		"/api/profile/$facebookId/actions"(resource: "actionRest")
		"/api/profile/$facebookId/friends"(resource: "friendsRest")
		"/"(controller: "index")
		"500"(view:'/error')
	}
}
