package com.github.dbourdette.ecm

import org.bson.types.ObjectId

class Action {
	static mapWith = 'mongo'
	ObjectId id;

	Profile profile
	Object object
	Date date
}
