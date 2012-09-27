package com.github.funreco

/**
 * @author damien bourdette
 */
class Recommendation {
    String query
    List<RecommendedObject> objects = new ArrayList<RecommendedObject>()

    void addObject(RecommendedObject object) {
        objects.add(object)
    }
}
