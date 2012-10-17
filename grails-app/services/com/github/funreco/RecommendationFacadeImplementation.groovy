package com.github.funreco

import java.util.List;

class RecommendationFacadeImplementation implements RecommendationFacade {

	@Override
	public Object updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile findProfile(String email, String facebookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateFriends(String facebookId, List<Friend> friends) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> findFriends(String facebookId) {
		// TODO Auto-generated method stub
		return null;
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
