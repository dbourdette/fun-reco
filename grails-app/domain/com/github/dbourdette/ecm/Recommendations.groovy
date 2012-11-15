package com.github.dbourdette.ecm

import org.bson.types.ObjectId

class Recommendations {
	static mapWith = 'mongo'
	ObjectId id;
	
	Profile profile
	Map<Object,Integer> recommendations
	Date date
	
}
