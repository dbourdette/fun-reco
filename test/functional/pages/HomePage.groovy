package pages
import geb.Page

class HomePage extends Page {

	static url = "index"
	
		static at = { title == "HomePage" }
	
		static content = {
		 
			recommandationEnt {$("g", var : "recommandationEntry")}
			findRecommandation{ $(recommandationEnt.find("ul").find("li"))}
			action { $("g", var : "action")
			findAction { action.find("li") }
			
				
			}
			
			
		}
	
	
}
