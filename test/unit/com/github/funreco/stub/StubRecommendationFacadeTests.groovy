package com.github.funreco.stub;

import static org.fest.assertions.Assertions.assertThat
import static org.fest.assertions.Assertions.assertEquals

import org.junit.Test;
import org.junit.Before;

import com.github.funreco.Action;
import com.github.funreco.Friend;
import com.github.funreco.Profile;
import com.github.funreco.Recommendation;
import com.github.funreco.Recommendations;

class StubRecommendationFacadeTests {

	StubRecommendationFacade recommendationFacade
	StubRecommendationFacadeData stubRecommendationFacadeData
	
	@Before
	void init(){
		
		recommendationFacade = new StubRecommendationFacade()
		stubRecommendationFacadeData = new StubRecommendationFacadeData()
	}
	
	@Test
   void findProfile() {
	   assertThat(recommendationFacade.findProfile("", "")).isEqualTo(stubRecommendationFacadeData.profile)
   }
   
   @Test
   void findProfileAttributsComparison() {
	   assertTrue(recommendationFacade.findProfile("", "").facebookId.equals(stubRecommendationFacadeData.profile.facebookId))
	   assertTrue(recommendationFacade.findProfile("", "").email.equals(stubRecommendationFacadeData.profile.email))
	   assertTrue(recommendationFacade.findProfile("", "").name.equals(stubRecommendationFacadeData.profile.name))
   }

   @Test
   void findFriends() {
	   assertThat(recommendationFacade.findFriends("")).isEqualTo(stubRecommendationFacadeData.friendsList)
   }

   @Test
   void findActions() {
	   assertThat(recommendationFacade.findActions(0, 10)).isEqualTo(stubRecommendationFacadeData.actions)
	   assertThat(recommendationFacade.findActions("", 0, 10)).isEqualTo(stubRecommendationFacadeData.actions)
   }

   @Test
   void countActions() {
	   assertThat(recommendationFacade.countActions()).isEqualTo(2)
   }

   @Test
   void findDefaultRecommendations() {
	   assertThat(recommendationFacade.findDefaultRecommendations()).isEqualTo(stubRecommendationFacadeData.recommendations)
   }

   @Test
   void findRecommendations() {
	   assertThat(recommendationFacade.findRecommendations("")).isEqualTo(stubRecommendationFacadeData.recommendations)
   }
	
	
}
