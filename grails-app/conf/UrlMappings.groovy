class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/document/$id?"(controller: "document", , parseRequest: true){
			action = [GET:"show", POST:"save", PUT:"update", DELETE:"remove"]
		  }
		
		"/"(controller: "index")
		"500"(view:'/error')
	}
}
