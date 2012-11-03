package com.github.dbourdette.basic

import com.github.dbourdette.api.RecommendationFacade;
import com.github.dbourdette.api.Recommendations;
import org.bson.types.ObjectId;

import com.github.dbourdette.api.Profile
import com.github.dbourdette.api.Action
import com.github.dbourdette.api.Friend
import com.github.dbourdette.ecm.Profile as DBProfile

class RecommendationFacadeImpl implements RecommendationFacade {

	public Profile updateProfile(Profile profile) {
        DBProfile dbProfile = DBProfile.findByFacebookId(profile.facebookId)

        if (!dbProfile) {
            dbProfile = new DBProfile(facebookId: profile.facebookId)
        }

        dbProfile.name = profile.name
        dbProfile.email = profile.email

        dbProfile.save(flush: true)

        return profile
	}

	private Profile findProfile(String facebookId){
		List<Profile> profiles = Profile.withCriteria {
			eq('facebookId', facebookId)
			maxResults(1)
		}
		Profile profile = null
		if (profiles.size() > 0){
			profile = profiles.get(0)
		}
		else{
			throw new UnsupportedOperationException("no profile with facebookId = "+ facebookId)
		}
		
		return profile;
	}
	
	public Profile findProfile(String email, String facebookId) {
		
		List<Profile> profiles = Profile.withCriteria {
			eq('email', email)
			eq('facebookId', facebookId)
			maxResults(1)
		}
		Profile profile = null
		if (profiles.size() > 0){
			profile = profiles.get(0)
		}
		
		return profile;
	}

	@Override
	public Profile updateFriends(String facebookId, List<Friend> friends) {
		
		Profile profile = findProfile(facebookId)
		profile.friendsIds = friendsIds
		profile.save()
		
		return profile;
	}

	@Override
	public List<Profile> findFriends(String facebookId) {
		
		List<Profile> L = []
		Profile profile = findProfile(facebookId)
		
		for(int i=0; i<profile.friendsIds.size(); i++){
			Profile friend = findProfile(profile.friendsIds.get(i))
			L.add(friend)
		}
		
		return L;
	}

	@Override
	public Action pushAction(Action action) {
		List<Action> actions = Action.withCriteria {
			eq("profile", action.profile)
			eq("object", action.object)
			maxResults(1)
		}
		
		ObjectId id
		if(actions.size()>0){
			if(action.id != null){
				action.delete()
			}
			Action oldAction = actions.get(0)
			oldAction.date = action.date
			oldAction.save()
			id = oldAction.id
		}
		else{
			action.save()
			id = action.id
		}
		
		return Action.get(id);
	}

	@Override
	public List<Action> findActions(int offset, int limit) {
		List<Action> actions = Action.withCriteria {
			maxResults(limit)
		}
		if(offset >= actions.size()){
			return [];
		}
		for(int i=0; i<offset; i++){
			actions.remove(0)
		}
		return actions;
	}

	@Override
	public List<Action> findActions(String facebookId, int offset, int limit) {
		List<Action> actions = findActions(offset, limit)
		
		int retard = 0
		for(int i=0; i<actions.size(); i++){
			
			if((actions.get(i).profile.facebookId != facebookId) && actions.size() >= 1){
				actions.remove(i-retard)
				retard++
			}
			if(actions.size() == 0){
				break;
			}
		}
		return actions;
	}

	@Override
	public int countActions() {
		return Action.list().size();
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
