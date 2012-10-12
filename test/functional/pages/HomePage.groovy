package pages
import geb.Page

class HomePage extends Page {

	static url = "index"

	static at = { title == "Home" }

	static content = {
		findRecommandations { $("#recommandations").find("li") }
		findActions { $("#actions").find("li") }
		viewAllActionsButton { $("a", name : "viewAll" ) }
        findFirstProfileLink { $(".profileLink", 0) }
        currentProfile { $("#profile", 0).text() }
	}
}


