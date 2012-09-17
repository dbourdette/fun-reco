package com.github.funreco.domain;

import java.util.Arrays;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FacebookLikesRecommendationTest {
    @Test
    public void getRandomKeyword() {
        FacebookLikesRecommendation recommendation = FacebookLikesRecommendation.forProfile(FacebookTestProfiles.johnDoe());
        recommendation.setKeywords(Arrays.asList("gaga", "guetta"));

        for (int i = 0; i < 100; i++) {
            assertThat(recommendation.getRandomKeyword()).isIn("gaga", "guetta");
        }
    }

    @Test
    public void getRandomKeywordWithNoKeyword() {
        FacebookLikesRecommendation recommendation = FacebookLikesRecommendation.forProfile(FacebookTestProfiles.johnDoe());

        assertThat(recommendation.getRandomKeyword()).isNull();
    }
}
