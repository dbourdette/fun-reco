package com.github.funreco;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
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
	
	@Before
	void init(){
		profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		fri1 = new Profile(facebookId:'friend1ID', email:'friend1@test.com', name:'friend1', friendsIds:['testID'])
		fri2 = new Profile(facebookId:'friend2ID', email:'friend2@test.com', name:'friend2', friendsIds:['testID'])
		
		Object o = new Object(date: new Date(), objectId: "OID", properties: ["show":["musique", "dance"]])
		act = new Action(profile: profile, Object: o, date: new Date())
		act.save()
		
		fri1.save(flush: true)
		fri2.save(flush: true)
		profile.save(flush: true)
	}
	
	@After
	void cleanUp(){
		fri1.delete()
		fri2.delete()
		profile.delete()
		
		act.delete()
	}
	
	
	@Test
	void updateProfile(){
		//facade.updateProfile(profile)
	}
	
	@Test
	void findProfile() {
		
		assert profile.id != null
		assert (facade.findProfile('test@test.com', 'testID').id == profile.id)
		
	}
	
	@Test
	void updateFriends() {
		facade.updateFriends(profile.facebookId, ["liste updated"])
		assert Profile.get(profile.id).friendsIds == ["liste updated"]
	}
	
	@Test
	void findFriends() {
		
		facade.findFriends("testID").get(0).facebookId == "friend1ID"
		facade.findFriends("testID").get(1).facebookId == "friend2ID"
	}
 
	@Test
	void findActions() {
		
		assert facade.findActions(0, 5).size() == 1
		
		assert facade.findActions(10, 2) == null
		
	}
	
	@Test
	void findActionsWithFaceBookId() {
		
		List<Action> actions = facade.findActions("testID", 0, 10)
		assert actions.get(0).profile.facebookId == "testID"
		for(int i=0; i<actions.size(); i++){
			assert actions.get(i).profile.facebookId == "testID"
		}
		
	}
 
	@Test
	void countActions() {
		
		assert facade.countActions() > 0
		
	}
 
	@Test
	void findDefaultRecommendations() {
	}
 
	@Test
	void findRecommendations() {
	}
	 
}



