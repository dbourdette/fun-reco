package com.github.funreco.stub;

import static org.fest.assertions.Assertions.assertThat
import static org.fest.assertions.Assertions.assertEquals

import org.junit.Test;
import org.junit.Before;

import com.github.funreco.Action;
import com.github.funreco.Friend;
import com.github.funreco.Profile;
import com.github.funreco.Recommendation;
import com.github.funreco.RecommendationFacade
import com.github.funreco.Recommendations;
import com.github.funreco.stub.StubRecommendationFacade;
import com.github.funreco.stub.StubRecommendationFacadeData;

class StubRecommendationFacadeTests {

	StubRecommendationFacade stubRecommendationFacade
	StubRecommendationFacadeData stubRecommendationFacadeData
	
	@Before
	void init(){
		
		stubRecommendationFacade = new StubRecommendationFacade()
		stubRecommendationFacadeData = new StubRecommendationFacadeData()
	}
	
	@Test
   void findProfile() {
	   assertThat(stubRecommendationFacade.findProfile("", "")).isEqualTo(stubRecommendationFacadeData.profile)
   }

   @Test
   void findFriends() {
	   assertThat(stubRecommendationFacade.findFriends("")).isEqualTo(stubRecommendationFacadeData.friendsList)
   }

   @Test
   void findActions() {
	   assertThat(stubRecommendationFacade.findActions(0, 10)).isEqualTo(stubRecommendationFacadeData.actions)
	   assertThat(stubRecommendationFacade.findActions("", 0, 10)).isEqualTo(stubRecommendationFacadeData.actions)
   }

   @Test
   void countActions() {
	   assertThat(stubRecommendationFacade.countActions()).isEqualTo(2)
   }

   @Test
   void findDefaultRecommendations() {
	   assertThat(stubRecommendationFacade.findDefaultRecommendations()).isEqualTo(stubRecommendationFacadeData.recommendations)
   }

   @Test
   void findRecommendations() {
	   assertThat(stubRecommendationFacade.findRecommendations("")).isEqualTo(stubRecommendationFacadeData.recommendations)
   }
	
	
}
