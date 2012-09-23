package com.github.funreco

/**
 * @author damien bourdette
 */
class Recommendation {
    String query
    List<RecommendedEntity> entities = new ArrayList<RecommendedEntity>()

    void addEntity(RecommendedEntity entity) {
        entities.add(entity)
    }
}
