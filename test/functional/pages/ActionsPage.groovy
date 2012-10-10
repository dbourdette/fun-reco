package pages
import geb.Page

public class ActionsPage extends Page {

	static url = "actions/index"

	static content = {
		findAllAction {$("ul").find("li").size()}
		
	}
}
