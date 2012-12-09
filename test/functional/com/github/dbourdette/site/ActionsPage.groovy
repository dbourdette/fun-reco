package com.github.dbourdette.site
import geb.Page

public class ActionsPage extends Page {

	static url = "actions/index"

	static content = {
		findAllActions { $("#actions").find("li") }
	}
}
