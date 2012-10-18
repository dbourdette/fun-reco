package com.github.funreco;

import static org.fest.assertions.Assertions.assertTrue;

import fun.reco.RecommendationFacade;
import fun.reco.Profile;
import fun.reco.Object;
import fun.reco.Action;

class RecommendationFacadeTests {

    RecommendationFacade facade = new RecommendationFacade()
	
	Profile profile
	Profile fri1
	Profile fri2
	
	Action act
	
	void setUp(){
		profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		fri1 = new Profile(facebookId:'friend1ID', email:'friend1@test.com', name:'friend1', friendsIds:['testID'])
		fri2 = new Profile(facebookId:'friend2ID', email:'friend2@test.com', name:'friend2', friendsIds:['testID'])
		
		Object o = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		act = new Action(profile: profile, object: o, date: new Date())
		act.save()
		
		fri1.save()
		fri2.save()
		
		profile.save()
		
	}
	
	void tearDown(){
		fri1.delete()
		fri2.delete()
		profile.delete()
		
		act.delete()
	}
	
	
	void testUpdateProfile(){
		profile.name = "name updated"
		facade.updateProfile(profile)
		assert Profile.get(profile.id).name == "name updated"
		
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:['friend1ID', 'friend2ID'])
		Profile newProfile1 = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:['friend1ID', 'friend2ID'])
		facade.updateProfile(newProfile)
		assert Profile.get(newProfile.id).facebookId == "newProfileID"
	}
	
	void testUpdateProfileNoDuplicata(){
		Profile newProfile1 = new Profile(facebookId:'newProfileID', email:'new.profile1@test.com', name:'newProfile 1', friendsIds:['friend1ID', 'friend2ID'])
		Profile newProfile2 = new Profile(facebookId:'newProfileID', email:'new.profile2@test.com', name:'newProfile 2', friendsIds:['friend1ID', 'friend2ID'])
		newProfile1 = facade.updateProfile(newProfile1)
		newProfile2 = facade.updateProfile(newProfile2)
		assert newProfile1.id == newProfile2.id
		
		newProfile1.delete()
		newProfile2.delete()
	}
	
	void testFindProfile() {
		
		assert profile.id != null
		assert (facade.findProfile('test@test.com', 'testID').id == profile.id)
		
	}
	
	void testUpdateFriends() {
		facade.updateFriends(profile.facebookId, ["liste updated"])
		assert Profile.get(profile.id).friendsIds == ["liste updated"]
	}
	
	void testFindFriends() {
		
		facade.findFriends("testID").get(0).facebookId == "friend1ID"
		facade.findFriends("testID").get(1).facebookId == "friend2ID"
	}

	void testPushAction(){
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:['friend1ID', 'friend2ID'])
		act.profile = newProfile
		facade.pushAction(act)
		assert Action.get(act.id).profile.facebookId == "newProfileID"
		
		Object o = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		Action newAction = new Action(profile: profile, object: o, date: new Date())
		newAction = facade.pushAction(newAction)
		assert newAction.id != null
		assert Action.get(newAction.id).profile.facebookId == "testID"
		
		act.profile = profile
		facade.pushAction(act)
		
		newAction.delete()
		newProfile.delete()
	}
	
	void testPpushActionNonDuplicata(){
		Profile newProfile = new Profile(facebookId:'newProfileID', email:'new.profile@test.com', name:'newProfile', friendsIds:[])
		act.profile = newProfile
		act = facade.pushAction(act)
		assert Action.get(act.id).profile.facebookId == "newProfileID"
		
		Object o = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		Action newAction = new Action(profile: profile, object: o, date: new Date())
		newAction = facade.pushAction(newAction)
		assert Action.get(newAction.id).profile.facebookId == "testID"
	}
	
	void testFindActions() {
		
		assert facade.findActions(0, 5).size() >= 1
		
		assert facade.findActions(10, 2) == null
		
	}
	
	void testFindActionsWithFaceBookId() {
		
		assert act != null
		List<Action> actions = facade.findActions("testID", 0, 10)
		assert actions.get(0).profile.facebookId == "testID"
		for(int i=0; i<actions.size(); i++){
			assert actions.get(i).profile.facebookId == "testID"
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



