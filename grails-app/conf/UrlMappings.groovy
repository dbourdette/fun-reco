class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/document/$id?"(controller: "document", , parseRequest: true){
			action = [GET:"show", POST:"insert", PUT:"update", DELETE:"delete"]
		  }
		
		"/"(controller: "index")
		"500"(view:'/error')
	}
}
