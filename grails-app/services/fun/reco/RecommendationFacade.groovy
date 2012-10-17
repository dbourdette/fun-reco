package fun.reco

import com.github.funreco.Recommendations

class RecommendationFacade implements RecommendationFacadeService {

	
	public Object updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		Object o
		return o;
	}

	public Profile findProfile(String email, String facebookId) {
		/*
		Profile profile = Profile.withCriteria {
			like('email', email)
			like('facebookId', facebookId)
		}
		
		print profile.name
		*/
		
		Profile profile = Profile.collection.findOne(email: email, facebookId: facebookId)
		return profile;
	}

	@Override
	public Object updateFriends(String facebookId, List<String> friendsIds) {
		// TODO Auto-generated method stub
		Profile profile = Profile.findByFacebookId(facebookId)
		profile.friendsIds = friendsIds
		profile.save()
		
		return null;
	}

	@Override
	public List<Profile> findFriends(String facebookId) {
		// TODO Auto-generated method stub
		List<Profile> L = []
		
		Profile profile = Profile.findByFacebookId(facebookId)
		print "**********************************************"
		print profile.facebookId
		print "**********************************************"
		/*
		Profile profile = Profile.withCriteria {
			like('facebookId', facebookId)
		}*/
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> findActions(String facebookId, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countActions() {
		// TODO Auto-generated method stub
		return 0;
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

