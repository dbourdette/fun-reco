package com.github.dbourdette.ecm.security

class SecRole {

	static mapWith = 'mongo'
	String authority
	
	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
