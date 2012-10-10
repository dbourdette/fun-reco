package fun.reco

import org.bson.types.ObjectId;

class Persistence {
	
	static mapWith = 'mongo'
	ObjectId id;
	String first
	String last
	int number
		
    static constraints = {
    }
}
