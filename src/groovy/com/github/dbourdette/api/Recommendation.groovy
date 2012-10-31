package com.github.dbourdette.api

class Recommendation {
    String query
    List<RecommendedObject> objects = new ArrayList<RecommendedObject>()

    void addObject(RecommendedObject object) {
        objects.add(object)
    }
	
	@Override
	public boolean equals(Recommendation recommendation) {
		return (this.objects.equals(recommendation.objects) && this.query == recommendation.query);
	}
}
