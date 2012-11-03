package com.github.dbourdette.security

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
