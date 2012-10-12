package fun.reco

import org.bson.types.ObjectId;

class Object {
	static mapWith = 'mongo'
	ObjectId id;

    String objectId
    Map<String, Set<String>> properties

}
