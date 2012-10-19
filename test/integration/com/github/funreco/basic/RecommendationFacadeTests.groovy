package com.github.funreco.basic;


import fun.reco.Profile;
import fun.reco.Object;
import fun.reco.Action;

class RecommendationFacadeTests {

    RecommendationFacadeImpl facade = new RecommendationFacadeImpl()
	
	Profile profile
	Profile friend1
	Profile friend2
	
	Action action
	
	void setUp(){
		profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		friend1 = new Profile(facebookId:'friend1ID', email:'friend1@test.com', name:'friend1', friendsIds:['testID'])
		friend2 = new Profile(facebookId:'friend2ID', email:'friend2@test.com', name:'friend2', friendsIds:['testID'])
		
		Object o = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		action = new Action(profile: profile, object: o, date: new Date())
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
	
	
	void testUpdateProfile(){
		profile.name = "name updated"
		facade.updateProfile(profile)
		assert Profile.get(profile.id).name == "name updated"
		
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:['friend1ID', 'friend2ID'])
		facade.updateProfile(newProfile)
		assert Profile.get(newProfile.id) != null
	}
	
	void testUpdateProfileNoDuplicataOfFacebookId(){
		Profile newProfile1 = new Profile(facebookId:'newProfileID', email:'new.profile1@test.com', name:'newProfile 1', friendsIds:['friend1ID', 'friend2ID'])
		Profile newProfile2withSameId = new Profile(facebookId:'newProfileID', email:'new.profile2@test.com', name:'newProfile 2', friendsIds:['friend1ID', 'friend2ID'])
		newProfile1 = facade.updateProfile(newProfile1)
		newProfile2withSameId = facade.updateProfile(newProfile2withSameId)
		
		List<Profile> profiles = Profile.withCriteria {
			eq('facebookId', "newProfileID")
			maxResults(10)
		}
		assert profiles.size() == 1
		
		newProfile1.delete()
		newProfile2withSameId.delete()
	}
	
	void testFindProfile() {
		List<Profile> profiles = Profile.list()
		Profile firstProfileSaved = profiles.get(0)
		
		assert facade.findProfile(firstProfileSaved.email, firstProfileSaved.facebookId).id == firstProfileSaved.id
		
	}
	
	void testUpdateFriends() {
		List<Profile> profiles = Profile.list()
		Profile firstProfileSaved = profiles.get(0)
		List<String> initialFriends = firstProfileSaved.friendsIds
		
		facade.updateFriends(firstProfileSaved.facebookId, ["liste updated"])
		assert Profile.get(firstProfileSaved.id).friendsIds == ["liste updated"]
		facade.updateFriends(firstProfileSaved.facebookId, initialFriends)
	}
	
	void testFindFriends() {
		List<Profile> profiles = Profile.list()
		String firstProfileIdSaved = profiles.get(0).facebookId
		List<String> friendsIds = profiles.get(0).friendsIds
		
		assert facade.findFriends(firstProfileIdSaved).get(0).facebookId == friendsIds[0]
	}

	void testPushActionUpdateExistingEntry(){
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:['friend1ID', 'friend2ID'])
		action.profile = newProfile
		
		//act = facade.pushAction(act)
		action.save()
		//assert act.profile.facebookId == "prof"
		assert Action.get(action.id).profile.facebookId == "newProfileID"
		
		List<Action> actions = Action.withCriteria {
			eq("profile", action.profile)
			eq("object", action.object)
			maxResults(1)
		}
		assert actions.size() == 0
		newProfile.delete()
	}
	void testPushActionAddEntry(){
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:['friend1ID', 'friend2ID'])
		
		Object o = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		Action newAction = new Action(profile: newProfile, object: o, date: new Date())
		newAction = facade.pushAction(newAction)
		assert newAction.id != null
		
		action.profile = profile
		action = facade.pushAction(action)
		
		newAction.delete()
		newProfile.delete()
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
		
		Action firstActionSaved = Action.get(facade.findActions(0, 5).get(0).id)
		assert firstActionSaved != null
		String facebookIdInFirstSavedAction = firstActionSaved.profile.facebookId
		
		List<Action> actions = facade.findActions(facebookIdInFirstSavedAction, 0, 10)
		assert actions.get(0).profile.facebookId == facebookIdInFirstSavedAction
		for(int i=0; i<actions.size(); i++){
			assert actions.get(i).profile.facebookId == facebookIdInFirstSavedAction
		}
		
	}
 
	void testCountActions() {
		
		assert facade.countActions() > 0
		
	}
 
	void testFindDefaultRecommendations() {
	}
 
	void testFindRecommendations() {
	}
	 
}



