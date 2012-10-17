package fun.reco

import java.util.List;

import com.github.funreco.Recommendations;

interface RecommendationFacadeService {

	def updateProfile(Profile profile);
	
		Profile findProfile(String email, String facebookId);
	
		def updateFriends(String facebookId, List<String> friendsIds);
	
		List<Profile> findFriends(String facebookId);
	
		def pushAction(Action action);
	
		List<Action> findActions(int offset, int limit);
	
		List<Action> findActions(String facebookId, int offset, int limit);
	
		int countActions();
	
		Recommendations findDefaultRecommendations();
	
		Recommendations findRecommendations(String facebookId);
}
