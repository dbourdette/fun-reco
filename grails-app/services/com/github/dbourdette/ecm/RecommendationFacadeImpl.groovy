package com.github.dbourdette.ecm

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.github.dbourdette.api.RecommendationFacade;
import com.github.dbourdette.api.Recommendations as PublicRecommendations
import com.github.dbourdette.api.Profile as PublicProfile
import com.github.dbourdette.api.Action as PublicAction
import com.github.dbourdette.api.Friend as PublicFriend
import com.github.dbourdette.api.Object as PublicObject

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

	public PublicObject pushObject(PublicObject object){
		//TODO
		Object dbObject = Object.findByObjectId(object.id)
		
		if (!dbObject) {
			dbObject = new Object(objectId: object.id, properties: object.properties)
		}
		
		
		dbObject.properties = object.properties
		dbObject.save(flush: true)
		
		return object		
	}
	
	@Override
	public PublicAction pushAction(PublicAction action) {
		//TODO
		Date currentDate = new Date()
		Profile dbProfile = Profile.findByFacebookId(action.profile.facebookId)//new Profile(facebookId: action.profile.facebookId, email: action.profile.email, name: action.profile.name)
		Object dbObject = Object.findByObjectId(action.object.id)//new Object(date: new Date(), objectId: action.object.id)
		
		if (! dbObject){
			throw new UnsupportedOperationException("can't push action because object "+action.object.id+" doesn't exist!")
		}
		if (! dbProfile){
			throw new UnsupportedOperationException("can't push action because profile "+action.profile.facebookId+" doesn't exist!")
		}
		
		List<Action> dbActions = Action.withCriteria {
			eq('profile', dbProfile)
			eq('object', dbObject)
		}
		
		Action dbAction = null
		for(int i=0; i<dbActions.size(); i++){
			if(dbActions.get(i).profile.facebookId.equals(action.profile.facebookId) && dbActions.get(i).object.objectId.equals(action.object.id)){
				dbAction = dbActions.get(i)
			}
		}
		if (!dbAction) {
			dbAction = new Action(profile: dbProfile, object: dbObject, date: currentDate)
		}
		

		dbAction.profile = dbProfile
		dbAction.object = dbObject
		dbAction.date = currentDate
		
		dbAction.save(flush: true)
		
		return new PublicAction(profile: new PublicProfile(facebookId: dbProfile.facebookId, email: dbProfile.email, name: dbProfile.name), object: new PublicObject(id: dbObject.objectId, properties: dbObject.properties), date: currentDate)
	}

	public PublicAction convertIntoPublicAction(Action action){
		Profile dbProfile = Profile.findByFacebookId(action.profile.facebookId)
		def profile = new PublicProfile(facebookId: dbProfile.facebookId, email: dbProfile.email, name: dbProfile.name)
		Object dbObject = Object.findByObjectId(action.object.objectId)
		def object = new PublicObject(id: dbObject.objectId, properties: dbObject.properties)
		def publicAction = new PublicAction(profile: profile, object: object, date: action.date)
	
		return publicAction 
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
		
		List<PublicAction> publicActions = []
		for(int i=0; i<actions.size(); i++){
			publicActions.add(convertIntoPublicAction(actions.get(i)))
		}
		
		return publicActions;
	}

	@Override
	public List<PublicAction> findActions(String facebookId, int offset, int limit) {
		Profile dbProfile = Profile.findByFacebookId(facebookId)
		List<Action> actions = Action.withCriteria {
			eq('profile', dbProfile)
			maxResults(limit)
		}
		
		if(offset >= actions.size()){
			return [];
		}
		for(int i=0; i<offset; i++){
			actions.remove(0)
		}
		
		List<PublicAction> publicActions = []
		for(int i=0; i<actions.size(); i++){
			publicActions.add(convertIntoPublicAction(actions.get(i)))
		}
		
		return publicActions;	
	}

	@Override
	public int countActions() {
		return Action.list().size();
	}

	@Override
	public PublicRecommendations findDefaultRecommendations() {
		def lastRecommendation = [:]
		def views = 0
		def today= new Date()
		//List<Profile> profiles = []
		List<Action> actions = Action.withCriteria {
			between("date", today - 15, today)
		}
		
		for (action in actions)
		{
				List<Action> actionsOfObject = Action.withCriteria {
					eq("object",action.object)
				}
				for (act in actionsOfObject)
				{
					// profiles.add(act.profile)
					 views++
				}
				lastRecommendation.put(action.object,views)
			
		}
		lastRecommendation.entrySet().sort{it.value}.reverse()
		Recommendations defaultRecommendation = new Recommendations(recommendations : lastRecommendation, date : today)
		return defaultRecommendation
	}

	@Override
	public PublicRecommendations findRecommendations(String facebookId) {
		def lastRecommendation = [:]
		def views = 0
		def today= new Date()
		List<Action> actionsOfFriends
		Profile profile= Profile.findByFacebookId(facebookId)
		List<Action> actions = Action.findAll()
		for (action in actions)
		{
				Profile friend= action.profile
				if (profile.friendsIds.contains(friend.facebookId))
				{	 
				actionsOfFriends = action
				}
		}
		for (action in actionsOfFriends)
		{
				List<Action> actionsOfObject = Action.withCriteria {
					eq("object",action.object)
				}
				for (act in actionsOfObject)
				{
					 views++
				}
				lastRecommendation.put(action.object,views)
			
		}
		lastRecommendation.entrySet().sort{it.value}.reverse()
		Recommendations defaultRecommendation = new Recommendations(recommendations : lastRecommendation, date : today)
		return defaultRecommendation
	}

}

