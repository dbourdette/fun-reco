package com.github.dbourdette.ecm;

import com.github.dbourdette.api.Friend as PublicFriend
import com.github.dbourdette.api.Profile as PublicProfile
import com.github.dbourdette.api.Object as PublicObject
import com.github.dbourdette.api.Action as PublicAction


class RecommendationFacadeTests {

    RecommendationFacadeImpl facade = new RecommendationFacadeImpl()
	
	
	void setUp(){
	}
	
	void tearDown(){
	}

	void testObjectPercistence(){
		Object dbObject = new Object(objectId: "testOID", properties: ["show":["musique", "dance"]], date: new Date())
		dbObject.save(flush: true)
		assert Object.findByObjectId("testOID") != null
		assert Object.findByObjectId("testOID").properties == ["show":["musique", "dance"]]
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

	void testPushObject(){
		//arrange
		def properties = ["show":["musique", "dance"]]
		String objectId = "objectId"
		def publicObject = new PublicObject(id: objectId, properties: properties)
		
		//act
		facade.pushObject(publicObject)
		Object object = new Object(objectId: "OIDdirectSave", properties: ["show":["musique", "dance"]], date: new Date())
		object.save(flush: true)
		
		//assert
		assert Object.findByObjectId("OIDdirectSave") != null
		assert Object.findByObjectId(objectId) != null
	}
	
	void testPushActionNewEntry(){
		// arrange
		def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
		def publicObjectId = "publicObjectId"
		def publicObject = new PublicObject(id: publicObjectId, properties: ["show":["musique", "dance"]])
		def action = new PublicAction(profile: profile, object: publicObject, date: new Date())

		// act
		facade.updateProfile(profile)
		facade.pushObject(publicObject)
		facade.pushAction(action)

		// assert
		//Action actionSaved = Action.findByProfile(Profile.findByFacebookId(profile.facebookId))
		Profile dbProfile = Profile.findByFacebookId(profile.facebookId)
		Object dbObject = Object.findByObjectId(publicObjectId)
		List<Action> dbActions = Action.withCriteria {
			eq('profile', dbProfile)
			eq('object', dbObject)
		}
		assert dbActions.size() == 1
		assert dbActions.get(0).object == Object.findByObjectId(publicObject.id)
	}
	
	void testPushActionUpdateExistingEntry(){
		//arrange
		//pushing new action
		    // arrange
		    def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
			def publicObjectId = "publicObjectId"
		    def publicObject = new PublicObject(id: publicObjectId, properties: ["show":["musique", "dance"]])
		    def action = new PublicAction(profile: profile, object: publicObject, date: new Date())

		    // act
		    facade.updateProfile(profile)
			facade.pushObject(publicObject)
		    facade.pushAction(action)
		
		//act
		Date firstDate = action.date
		action = facade.pushAction(action)
		Date secondDate = action.date
		
		//assert
		assert firstDate.compareTo(secondDate) < 0
	}
	
	void testPushActionNoDuplicata(){
		//arrange
		//pushing new action
			// arrange
			def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
			def publicObjectId = "publicObjectId"
			def publicObject = new PublicObject(id: publicObjectId, properties: ["show":["musique", "dance"]])
			def action = new PublicAction(profile: profile, object: publicObject, date: new Date())

			// act
			facade.updateProfile(profile)
			facade.pushObject(publicObject)
			facade.pushAction(action)
		
		//act
		int sizeBefore = facade.findActions(0, 5).size()
		action = facade.pushAction(action)
		int sizeAfter = facade.findActions(0, 5).size()
		
		//assert
		assert sizeBefore == sizeAfter
	}
	
	void testFindActions() {
		// arrange
		def profile = new PublicProfile(facebookId: "fbId", email: "123@test.com", name: "123")
		def publicObjectId = "publicObjectId"
		def publicObject = new PublicObject(id: publicObjectId, properties: ["show":["musique", "dance"]])
		def action = new PublicAction(profile: profile, object: publicObject, date: new Date())
		
		//act
		facade.updateProfile(profile)
		facade.pushObject(publicObject)
		facade.pushAction(action)
		
		//assert
		assert facade.findActions(0, 5).size() >= 1
		assert facade.findActions(10, 2).size() == 0
	}
	
	void testFindActionsWithFaceBookId() {
		//arrange
		def profile1 = new PublicProfile(facebookId: "fbId1", email: "123@test.com", name: "123")
		def profile2 = new PublicProfile(facebookId: "fbId2", email: "456@test.com", name: "456")
		def publicObject = new PublicObject(id: "publicObjectId", properties: ["show":["musique", "dance"]])
		def action1 = new PublicAction(profile: profile1, object: publicObject, date: new Date())
		def action2 = new PublicAction(profile: profile2, object: publicObject, date: new Date())
		facade.updateProfile(profile1)
		facade.updateProfile(profile2)
		facade.pushObject(publicObject)
		facade.pushAction(action1)
		facade.pushAction(action2)
		
		def facebookId1 = profile1.facebookId
		def facebookId2 = profile2.facebookId
		
		//act
		List<PublicAction> actions = facade.findActions(facebookId2, 0, 10)
		
		//assert
		assert actions.size() >= 1
		for(int i=0; i<actions.size(); i++){
			assert actions.get(i).profile.facebookId.equals(facebookId2)
		}
	}
 
	void testCountActions() {
		
		assert facade.countActions() > 0
		
	}
 
	void testFindDefaultRecommendations() {
		//arrange (push actions)
		def profile1 = new PublicProfile(facebookId: "fbId1", email: "123@test.com", name: "123")
		def profile2 = new PublicProfile(facebookId: "fbId2", email: "456@test.com", name: "456")
		def publicObject = new PublicObject(id: "publicObjectId", properties: ["show":["musique", "dance"]])
		def action1 = new PublicAction(profile: profile1, object: publicObject, date: new Date())
		def action2 = new PublicAction(profile: profile2, object: publicObject, date: new Date())
		facade.updateProfile(profile1)
		facade.updateProfile(profile2)
		facade.pushObject(publicObject)
		facade.pushAction(action1)
		facade.pushAction(action2)
		
		//act
		List<PublicAction> actionsRecommended = facade.findDefaultRecommendations()
		
		//assert
		assert actionsRecommended.size() >=1
		//assert actionsRecommended
	}
 
	void testFindRecommendations() {
	}
	 
}



