package com.github.funreco.legacy.domain;

import org.junit.Before;
import org.junit.Test;

import com.github.funreco.legacy.domain.recommandation.OpenGraphRecommendation;

import static com.github.funreco.legacy.domain.recommandation.RecommendedObject.object;
import static org.fest.assertions.Assertions.assertThat;

public class RecommendationTest {
    private OpenGraphRecommendation recommendation = new OpenGraphRecommendation();

    private static final String DUMMY_ID_1 = "10", DUMMY_ID_2 = "12", DUMMY_ID_3 = "67", DUMMY_ID_4 = "89";

    @Before
    public void init() {
        recommendation.forQuery("type=video").recommend(object(DUMMY_ID_1), object(DUMMY_ID_2));
        recommendation.forQuery("type=image").recommend(object(DUMMY_ID_3), object(DUMMY_ID_4));
    }

    @Test
    public void getObjectsWithNoType() {
        assertThat(recommendation.forQuery("").getObjects()).isEmpty();
    }

    @Test
    public void getObjects() {
        assertThat(recommendation.forQuery("type=video").getObjects().size()).isEqualTo(2);
        assertThat(recommendation.forQuery("type=video").getObjects()).contains(object(DUMMY_ID_1), object(DUMMY_ID_2));
    }

}
