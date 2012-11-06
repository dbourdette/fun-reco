package pages
package com.github.dbourdette.pages.api;
import geb.Page

class LoginPage extends Page {
	static url = "login/auth"
	
	static content = {
		loginForm { $("form") }
		username { $("input", type:"text", name:"j_username") }
		password { $("input", type:"password", name:"j_password") }
		loginButton{ $("input", type:"submit", value:"Login") }
	}
}