package com.github.dbourdette.ecm

import java.util.List;

import com.github.dbourdette.ecm.Action;
import com.github.dbourdette.ecm.Profile;
import com.github.dbourdette.api.Recommendations;

interface RecommendationFacadeService {

	    Profile updateProfile(Profile profile);
	
		Profile findProfile(String email, String facebookId);
	
		Profile updateFriends(String facebookId, List<String> friendsIds);
	
		List<Profile> findFriends(String facebookId);
	
		Action pushAction(Action action);
	
		List<Action> findActions(int offset, int limit);
	
		List<Action> findActions(String facebookId, int offset, int limit);
	
		int countActions();
	
		Recommendations findDefaultRecommendations();
	
		Recommendations findRecommendations(String facebookId);
}
