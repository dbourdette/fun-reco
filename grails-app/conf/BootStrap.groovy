
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.Mongo

import com.github.dbourdette.ecm.Object;
import com.github.dbourdette.ecm.Profile;
import com.github.dbourdette.ecm.Action
import grails.converters.JSON

import com.github.dbourdette.ecm.security.SecRole;
import com.github.dbourdette.ecm.security.SecUser;
import com.github.dbourdette.ecm.security.SecUserSecRole;

class BootStrap {

	def init = { servletContext ->
            def roleAdmin = new SecRole(authority: 'ROLE_ADMIN').save()
            def roleUser = new SecRole(authority: 'ROLE_USER').save()
     	    def userAdmin = new SecUser(username: 'admin', password: 'admin', enabled: true)
            userAdmin.save()
            SecUserSecRole.create(userAdmin, roleAdmin)
		environments {
			test {
				new Mongo().getDB("fun-reco-test").dropDatabase();
			}
		}
			
		JSON.registerObjectMarshaller(Profile) {
			def returnArray = [:]
			returnArray['facebookId'] = it.facebookId
			returnArray['email'] = it.email
			returnArray['name'] = it.name
			returnArray['friendsIds'] = it.friendsIds
			return returnArray
		}
					
		JSON.registerObjectMarshaller(Object) {
			def returnArray = [:]
			returnArray['objectId'] = it.objectId
			returnArray['properties'] = it.properties
			returnArray['date'] = it.date
			return returnArray
		}
				
		JSON.registerObjectMarshaller(Action) {
			def returnArray = [:]
			returnArray['profile'] = it.profile
			returnArray['object'] = it.object
			returnArray['date'] = it.date
			return returnArray
		}
	}
	
    def destroy = {
    }
}

