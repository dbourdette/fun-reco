package pages
import geb.Page

class HomePage extends Page{

	static url = "index"

	static at = { title == "Home" }

	static content = {


		findRecommandation {$("ul", 0).find("li").size()}
		findActions{ $("ul", 1).find("li").size()}
		viewAllButton{ $("a", name : "viewAll")}
		findProfile{$("a", href : "?facebookId=650249226") }
	}
}


