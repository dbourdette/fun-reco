package com.github.funreco.stub;

import static org.fest.assertions.Assertions.assertThat

import java.util.*;

import org.junit.Test;

import com.github.funreco.Action;
import com.github.funreco.Friend;
import com.github.funreco.Profile;
import com.github.funreco.RecommendationFacadeCall;
import com.github.funreco.Recommendations

class StubRecommendationFacadeTests {

	private StubRecommendationFacade stub
	private StubRecommendationFacadeData data
	
	@Before
	void init(){
		
		stub = new StubRecommendationFacade()
		data = new StubRecommendationFacadeData()
	}
	@Test
   void findProfile() {
	   assertThat(stub.findProfile("", "")).isEqualTo(data.profile)
   }

   @Test
   void findFriends() {
	   assertThat(stub.findFriends("")).isEqualTo(data.friendsList)
   }

   @Test
   void findActions() {
	   assertThat(stub.findActions(0, 10)).isEqualTo(data.actions)
	   assertThat(stub.findActions("", 0, 10)).isEqualTo(data.actions)
   }

   @Test
   void countActions() {
	   assertThat(stub.countActions()).isEqualTo(2)
   }

   @Test
   void findDefaultRecommendations() {
	   assertThat(stub.findDefaultRecommendations()).isEqualTo(data.recommendations)
   }

   @Test
   void findRecommendations() {
	   assertThat(stub.findRecommendations("")).isEqualTo(data.recommendations)
   }
	
	
}
