package com.github.dbourdette.api

class Recommendations {
    Profile profile
    Map<Object,Integer> recommendations = new HashMap<Object,Integer>()
	
	Date date

   
    void addRecommendation(Object objet, int views) {
        recommendations.put(objet, views)
    }
	
	@Override
	public boolean equals(Recommendations recommendations) {
		return (this.profile.equals(recommendations.profile) && this.recommendations.equals(recommendations.recommendations));
	}
}
