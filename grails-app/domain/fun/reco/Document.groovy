package fun.reco

import org.bson.types.ObjectId;

class Document {
	static mapWith = 'mongo'
	ObjectId id;
	
	String title
	String content
}
