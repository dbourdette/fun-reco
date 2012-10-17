package com.github.funreco;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.fest.assertions.Assertions.assertTrue;

import fun.reco.RecommendationFacade
import fun.reco.Profile

class RecommendationFacadeTests {

    RecommendationFacade facade = new RecommendationFacade()
	/*
	@Before
	void init(){
		Profile profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		profile.save(flush: true)
	}
	
	@After
	void cleanUp(){
		profile.delete()
	}
	*/
	
	@Test
	void profileTest() {
		Profile profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		assert profile.facebookId == 'testID'
	}
	
	@Test
	void findProfile() {
		Profile profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		assert profile.facebookId != null
		profile.save(flush: true)
		
		assert profile.id != null
		assert facade.findProfile('test@test.com', 'testID').id != null
		assert (facade.findProfile('test@test.com', 'testID').id == profile.id)
		
		profile.delete()
	}
	
	@Test
	void findFriends() {
		Profile profile = new Profile(facebookId:'testID', email:'test@test.com', name:'Mr. test', friendsIds:['friend1ID', 'friend2ID'])
		profile.save()
		facade.findFriends("testID").get(0).facebookId == "friend1ID"
		
		profile.delete()
	}
 
	@Test
	void findActions() {
	}
 
	@Test
	void countActions() {
	}
 
	@Test
	void findDefaultRecommendations() {
	}
 
	@Test
	void findRecommendations() {
	}
	 
}



