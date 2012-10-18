package fun.reco

import com.github.funreco.Recommendations

class RecommendationFacade implements RecommendationFacadeService {

	
	public Object updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Profile findProfile(String email, String facebookId) {
		
		List<Profile> profiles = Profile.withCriteria {
			eq('email', email)
			eq('facebookId', facebookId)
			maxResults(2)
		}
		Profile profile = profiles.get(0)
		
		return profile;
	}

	@Override
	public Object updateFriends(String facebookId, List<String> friendsIds) {
		
		Profile profile = Profile.findByFacebookId(facebookId)
		profile.friendsIds = friendsIds
		profile.save()
		
		return null;
	}

	@Override
	public List<Profile> findFriends(String facebookId) {
		
		List<Profile> L = []
		
		Profile profile = Profile.findByFacebookId(facebookId)
		
		for(int i=0; i<profile.friendsIds.size(); i++){
			Profile friend = Profile.findByFacebookId(profile.friendsIds.get(i))
			L.add(friend)
		}
		
		return L;
	}

	@Override
	public Object pushAction(Action action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> findActions(int offset, int limit) {
		List<Action> actions = Action.withCriteria {
			maxResults(limit)
		}
		if(offset >= actions.size()){
			return null;
		}
		for(int i=0; i<offset; i++){
			actions.remove(0)
		}
		return actions;
	}

	@Override
	public List<Action> findActions(String facebookId, int offset, int limit) {
		List<Action> actions = findActions(offset, limit)
		
		if(actions == null){
			return null;
		}
		
		int retard = 0
		for(int i=0; i<actions.size(); i++){
			
			if(!(actions.get(i).profile.facebookId == facebookId) && actions.size() >= 1){
				actions.remove(i-retard)
				retard++
			}
			else if(actions.size() == 0){
				return null
			}
		}
		return actions;
	}

	@Override
	public int countActions() {
		
		return Action.count();
	}

	@Override
	public Recommendations findDefaultRecommendations() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not implemented yet")
	}

	@Override
	public Recommendations findRecommendations(String facebookId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not implemented yet")
	}

}

