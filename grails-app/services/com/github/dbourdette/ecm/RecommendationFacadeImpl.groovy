package com.github.dbourdette.ecm

import org.bson.types.ObjectId;

import com.github.dbourdette.api.RecommendationFacade;
import com.github.dbourdette.api.Recommendations;
import com.github.dbourdette.api.Profile as PublicProfile
import com.github.dbourdette.api.Action as PublicAction
import com.github.dbourdette.api.Friend as PublicFriend

class RecommendationFacadeImpl implements RecommendationFacade {

	public PublicProfile updateProfile(PublicProfile profile) {
        Profile dbProfile = Profile.findByFacebookId(profile.facebookId)

        if (!dbProfile) {
            dbProfile = new Profile(facebookId: profile.facebookId)
        }

        dbProfile.name = profile.name
        dbProfile.email = profile.email

        dbProfile.save(flush: true)

        return profile
	}

	private PublicProfile findProfile(String facebookId){
		Profile dbProfile = Profile.findByFacebookId(facebookId)
		if (!dbProfile) {
			throw new UnsupportedOperationException("not profile found with facebookId="+facebookId)
		}
		
		PublicProfile profile = new PublicProfile(facebookId:dbProfile.facebookId, email:dbProfile.email, name:dbProfile.name)
		
		return profile
	}
	
	public PublicProfile findProfile(String email, String facebookId) {
		
		List<PublicProfile> profiles = PublicProfile.withCriteria {
			eq('email', email)
			eq('facebookId', facebookId)
			maxResults(1)
		}
		PublicProfile profile = null
		if (profiles.size() > 0){
			profile = profiles.get(0)
		}
		
		return profile;
	}

	@Override
	public PublicProfile updateFriends(String facebookId, List<PublicFriend> friends) {
		
		Profile dbProfile = Profile.findByFacebookId(facebookId)

        if (!dbProfile) {
			throw new UnsupportedOperationException("not profile found with facebookId="+facebookId)
		}

		List<String> friendsIds = []
		for(int i=0; i<friends.size(); i++){
			friendsIds.add(friends.get(i).facebookId)
		}
        dbProfile.friendsIds = friendsIds

        dbProfile.save(flush: true)

		PublicProfile profile = new PublicProfile(facebookId:dbProfile.facebookId, email:dbProfile.email, name:dbProfile.name)
        return profile
	}

	@Override
	public List<PublicProfile> findFriends(String facebookId) {
		
		List<PublicProfile> L = []
		Profile dbProfile = Profile.findByFacebookId(facebookId)
		
		for(int i=0; i<dbProfile.friendsIds.size(); i++){
			PublicProfile friend = findProfile(dbProfile.friendsIds.get(i))
			L.add(friend)
		}
		
		return L;
	}

	@Override
	public PublicAction pushAction(PublicAction action) {
		//TODO
		Action dbAction = Action.findByProfile(Profile.findByFacebookId(action.profile.facebookId))
		Profile dbProfile = Profile.findByFacebookId(action.profile.facebookId)//new Profile(facebookId: action.profile.facebookId, email: action.profile.email, name: action.profile.name)
		Object dbObject = Object.findByObjectId(action.object.id)//new Object(date: new Date(), objectId: action.object.id)
		
		if (!dbAction) {
			dbAction = new Action(profile: dbProfile, object: dbObject, date: action.date)
		}
		if (! dbObject){
			dbObject = new Object(objectId: action.object.id, properties: action.object.properties)
		}

		dbAction.profile = dbProfile
		dbAction.object = dbObject
		dbAction.date = action.date
		
		dbAction.save(flush: true)
		
		return action
	}

	@Override
	public List<PublicAction> findActions(int offset, int limit) {
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
	public List<PublicAction> findActions(String facebookId, int offset, int limit) {
		List<PublicAction> actions = findActions(offset, limit)
		
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

