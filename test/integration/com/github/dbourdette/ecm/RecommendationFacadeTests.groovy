package com.github.dbourdette.ecm;

import com.github.dbourdette.api.Friend as PublicFriend
import com.github.dbourdette.api.Profile as PublicProfile
import com.github.dbourdette.api.Object as PublicObject
import com.github.dbourdette.api.Action as PublicAction


class RecommendationFacadeTests {

    RecommendationFacadeImpl facade = new RecommendationFacadeImpl()
	
	Profile profile
	Profile friend1
	Profile friend2
	
	Object object
	Action action
	
	void setUp(){
		profile = new Profile(facebookId:'testID', email:'test@test.com', name:'test', friendsIds:['friend1ID', 'friend2ID'])
		friend1 = new Profile(facebookId:'friend1ID', email:'friend1@test.com', name:'friend1', friendsIds:['testID'])
		friend2 = new Profile(facebookId:'friend2ID', email:'friend2@test.com', name:'friend2', friendsIds:['testID'])
		
		object = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		object.save(flush: true)
		action = new Action(profile: profile, object: object, date: new Date())
		action.save()
		
		friend1.save()
		friend2.save()
		
		profile.save()
		
	}
	
	void tearDown(){
		friend1.delete()
		friend2.delete()
		profile.delete()
		
		action.delete()
	}

    void testUpdateUnknownProfile() {
        // arrange
        def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")

        // act
        def profileUpdated = facade.updateProfile(profile)

        // assert
        def dbProfile = Profile.findByEmail('123@test.com')
        assert dbProfile.name == '123'
        assert dbProfile.facebookId == 'fbId'
		assert profileUpdated.name == '123'
    }
	
	void testUpdateExistingProfile(){
		//arrange
		def fbID = 'ProfileID'
		def profile = new PublicProfile(facebookId:fbID, email:'profile@test.com', name:'Profile')
		facade.updateProfile(profile)
		
		//act
		def profileWithExistingID = new PublicProfile(facebookId:fbID, email:'newprofile@test.com', name:'newProfile')
		def profileReturned = facade.updateProfile(profileWithExistingID)
		
		//assert
		assert profileReturned.name == "newProfile"
		assert profileReturned.email == 'newprofile@test.com'
	}
	
	void testUpdateProfileNoDuplicataOfFacebookId(){
		//arrange
		def fbID = 'ProfileID'
		def profile = new PublicProfile(facebookId:fbID, email:'profile@test.com', name:'Profile')
		facade.updateProfile(profile)
		
		//act
		def profileWithExistingID = new PublicProfile(facebookId:fbID, email:'newprofile@test.com', name:'newProfile')
		def profileReturned = facade.updateProfile(profileWithExistingID)
		
		//assert
		Profile profileSaved = Profile.findByFacebookId(profile.facebookId)
		assert profileSaved.name == "newProfile"
		assert profileSaved.email == 'newprofile@test.com'
	}
	
	void testFindProfile() {
		// arrange
        def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
		facade.updateProfile(profile)
		
        // act
        def profileFound = facade.findProfile(profile.facebookId)

        // assert
        assert profileFound.name == '123'
        assert profileFound.facebookId == 'fbId'
        assert profileFound.email == '123@test.com'
	}
	
	void testUpdateFriends() {
		//arrange
		def friend = new PublicFriend(facebookId: "friendId", name: "friend")
		def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
		facade.updateProfile(profile)
		
		//act
		facade.updateFriends(profile.facebookId, [friend])
		
		//assert
		assert Profile.findByFacebookId(profile.facebookId).friendsIds == [friend.facebookId]
	}
	
	void testFindFriends() {
		//arrange
		def friend = new PublicFriend(facebookId: "friendId", name: "friend")
		def friendProfile = new PublicProfile(facebookId: friend.facebookId, email: "friend@test.com", name: friend.name)
		def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
		facade.updateProfile(profile)
		facade.updateProfile(friendProfile)
		facade.updateFriends(profile.facebookId, [friendProfile])
		
		//act
		PublicProfile friendFound = facade.findFriends(profile.facebookId).get(0)
		
		//assert
		assert friendFound.equals(friendProfile)
	}

	void testPushActionNewEntry(){
		// arrange
		def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
		def publicObject = new PublicObject(id: object.objectId, properties: ["show":["musique", "dance"]])
		def action = new PublicAction(profile: profile, object: publicObject, date: new Date())

		// act
		facade.updateProfile(profile)
		facade.pushAction(action)

		// assert
		Action actionSaved = Action.findByProfile(Profile.findByFacebookId(profile.facebookId))
		assert actionSaved.profile == Profile.findByFacebookId(profile.facebookId)
	}
	
	void testPushActionUpdateExistingEntry(){
		//arrange
		def newProfile = new PublicProfile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile')
		def object = new PublicObject(id: "objectId", properties: ["show":["musique", "dance"]])
		def action = new PublicAction(profile: newProfile, object: object, date: new Date())
		
		//act
		action = facade.pushAction(action)
		
		//assert act.profile.facebookId == "prof"
		assert Action.findByObject(Object.findByObjectId(object.id)).profile.facebookId == "newProfileID"
	}
	
	void testPpushActionNonDuplicata(){
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:[])
		action.profile = newProfile
		action = facade.pushAction(action)
		
		List<Action> actionList = Action.withCriteria {
			eq("profile", action.profile)
			eq("object", action.object)
			maxResults(1)
		}
		assert actionList.size() == 1
		
		assert Action.get(action.id).profile.facebookId == "newProfileID"
		action.profile = profile
		action = facade.pushAction(action)
		
		Action actionEnBase = Action.get(action.id)
		assert actionEnBase != null
		Action newActionEqualsActionEnBase = new Action(profile: actionEnBase.profile, object: actionEnBase.object, date: new Date())
		newActionEqualsActionEnBase = facade.pushAction(newActionEqualsActionEnBase)
		
		List<Action> actions = Action.withCriteria {
			eq('profile', actionEnBase.profile)
			maxResults(10)
		}
		assert actions.size() == 1
		
		actionEnBase.delete()
		newProfile.delete()
	}
	
	void testFindActions() {
		
		assert facade.findActions(0, 5).size() >= 1
		assert Action.get(facade.findActions(0, 5).get(0).id) != null
		assert facade.findActions(10, 2).size() == 0
		
	}
	
	void testFindActionsWithFaceBookId() {
		//arrange
		Action firstActionSaved = Action.get(facade.findActions(0, 5).get(0).id)
		String facebookIdInFirstSavedAction = firstActionSaved.profile.facebookId
		
		//act
		List<Action> actions = facade.findActions(facebookIdInFirstSavedAction, 0, 10)
		
		//assert
		assert firstActionSaved != null
		assert actions.get(0).profile.facebookId == facebookIdInFirstSavedAction
		/*for(int i=0; i<actions.size(); i++){
			assert actions.get(i).profile.facebookId == facebookIdInFirstSavedAction
		}*/
	}
 
	void testCountActions() {
		
		assert facade.countActions() > 0
		
	}
 
	void testFindDefaultRecommendations() {
		assert action.object != null
		facade.findDefaultRecommendations()
	}
 
	void testFindRecommendations() {
	}
	 
}



