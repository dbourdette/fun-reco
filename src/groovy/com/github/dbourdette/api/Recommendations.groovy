package com.github.dbourdette.api

class Recommendations {
	Profile profile
	Map<String, Recommendation> recommendations = new HashMap<String, Recommendation>()

	
	Collection<String> getEntries() {
		return recommendations.values()
	}

	Recommendation forQuery(String query) {
		return recommendations.get(query)
	}

	void addRecommendation(Recommendation recommendation) {
		recommendations.put(recommendation.query, recommendation)
	}


	@Override
	public boolean equals(Recommendations recommendations) {
		return (this.profile.equals(recommendations.profile) && this.recommendations.equals(recommendations.recommendations));
	}
}
