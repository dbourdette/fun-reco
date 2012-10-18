package fun.reco

import java.util.List;
import fun.reco.Profile;
import fun.reco.Action;
import com.github.funreco.Recommendations;

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
