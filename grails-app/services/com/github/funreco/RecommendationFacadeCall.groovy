package com.github.funreco

import java.util.List;

class RecommendationFacadeCall implements RecommendationFacade {

	def updateProfile(Profile profile) {
		// - TODO
		
   }

   Profile findProfile(String email, String facebookId) {
	   // - TODO
	   
   }

   def updateFriends(String facebookId, List<Friend> friends) {
	   // - TODO
	   
   }

   List<Friend> findFriends(String facebookId) {
	   // - TODO
	   
   }

   def pushAction(Action action) {
	   // - TODO
	   
   }

   List<Action> findActions(int offset, int limit) {
	   // - TODO
	   
   }

   List<Action> findActions(String facebookId, int offset, int limit) {
	   // - TODO
	   
   }

   int countActions() {
	   // - TODO
	   
   }

   Recommendations findDefaultRecommendations() {
	   throw new UnsupportedOperationException("Not implemented yet")
   }

   Recommendations findRecommendations(String facebookId) {
	   throw new UnsupportedOperationException("Not implemented yet")
   }
   
}
