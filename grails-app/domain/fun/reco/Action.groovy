package fun.reco

import java.util.Date;
import org.bson.types.ObjectId

class Action {
	static mapWith = 'mongo'
	ObjectId id;

	Profile profile
	Object object
	Date date
}
