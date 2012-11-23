package com.github.dbourdette.stub

import java.util.List;

import com.github.dbourdette.api.Action;
import com.github.dbourdette.api.Friend;
import com.github.dbourdette.api.Object;
import com.github.dbourdette.api.Profile
import com.github.dbourdette.api.Recommendation;
import com.github.dbourdette.api.Recommendations;
import com.github.dbourdette.api.RecommendedObject;

class StubRecommendationFacadeData {

	/*
	 * Data Stub
	 */
	private def profile
	private Object object1
	private Object object2
	
	private Friend friend1
	private Friend friend2
	private Friend friend3
	
	private List<Friend> friendsList
	
	private RecommendedObject recommendedObject1
	private RecommendedObject recommendedObject2
	
	private Recommendation recommendation
	private Recommendations recommendations
	
	private List<Action> actions
	
	StubRecommendationFacadeData(){
		// le profile
		profile = new Profile(facebookId: "423BH5H342V3", email: "jdoo@mail.com", name: "John DOO")
		
		// deux objets
		Set<String> propSet11 = ['show', 'music']
		Set<String> propSet12 = ['junior']
		Set<String> propSet13 = ['David Guetta']
		Map<String, Set<String>> prop1 = ['type': propSet11, 'tag': propSet12, 'people': propSet13]
		object1 = new Object(id: "7752446397", objectProperties: prop1)
		
		Set<String> propSet21 = ['video', 'concert']
		Set<String> propSet22 = ['video', 'star']
		Map<String, Set<String>> prop2 = ['type': propSet21, 'tag': propSet22]
		object2 = new Object(id: "7752420290", objectProperties: prop2)
		
		
		//trois amis
		friend1 = new Friend(facebookId : "524368438", name : "Olivier Lagache")
		friend2 = new Friend(facebookId : "528899091", name : "Anne Cohen")
		friend3 = new Friend(facebookId : "531380794", name : "Daniel Chan")
		List<Friend> l1 = [friend1, friend2, friend3]
		List<Friend> l2 = [friend1]
		
		friendsList = l1
		
		//deux recommendations d'objets
		recommendedObject1 = new RecommendedObject(object: object1, by: l1)
		recommendedObject2 = new RecommendedObject(object: object2, by: l2)
		
		//les recommendations
		recommendation = new Recommendation(query : "type='sound'", objects: [recommendedObject1, recommendedObject2])
		
		Map<String, Recommendation> recoMap1 = ['R1': recommendation]
		recommendations = new Recommendations(profile: profile, recommendations: recoMap1)
		
		//les actions
		actions = [new Action(profile: profile, object: object1, date: new Date()), new Action(profile: profile, object: object2, date: new Date())]
		/*
		 *
		 */
	}
	
	
}
