package com.github.funreco

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
}
