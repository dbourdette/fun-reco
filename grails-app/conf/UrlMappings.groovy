class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/profile/$id?"(resource: "profileRest")
		"/action/$id?"(resource: "actionRest")
		"/"(controller: "index")
		"500"(view:'/error')
	}
}
