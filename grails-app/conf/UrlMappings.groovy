class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/document/$id?"(resource: "document")
		"/action/$id?"(resource: "action")
		"/"(controller: "index")
		"500"(view:'/error')
	}
}
