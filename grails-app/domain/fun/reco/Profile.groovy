package fun.reco

import org.bson.types.ObjectId;

class Profile {
	static mapWith = 'mongo'
	ObjectId id;
	
	String facebookId
	String email
	String name
	List<String> friendsList
}
