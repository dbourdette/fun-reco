package pages;
import geb.Page

public class ActionsPage extends Page {

		static url = "actions/index"
		
			static at = { title == "ActionsPage" }
		
			static content = {
			 
				action { $("g", var : "action")
					findAction { action.find("li") }
			
}
