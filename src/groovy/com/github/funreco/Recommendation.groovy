package com.github.funreco

class Recommendation {
    String query
    List<RecommendedObject> objects = new ArrayList<RecommendedObject>()

    void addObject(RecommendedObject object) {
        objects.add(object)
    }
}
