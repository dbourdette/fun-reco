package test.functional.pages;
import geb.Page

public class ActionsPage extends Page {

		static url = "actions/index"
		
			static at = { title == "ActionsPage" }
		
			static content = {
		
				findAllAction {$("ul").find("li").size()}
		}		
}
