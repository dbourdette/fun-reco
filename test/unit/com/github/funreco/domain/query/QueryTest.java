package com.github.funreco.domain.query;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class QueryTest {
    @Test
    public void property() {
        assertThat(Query.property("type", "video")).isEqualTo(new PropertyCriterion("type", "video"));
    }

    @Test
    public void notNull() {
        assertThat(Query.notNull("type")).isEqualTo(new NotNullCriterion("type"));
    }

    @Test
    public void or() {
        assertThat(Query.or(Query.property("type", "video"), Query.property("show", "émission 1")))
                .isEqualTo(new OrCriterion(new PropertyCriterion("type", "video"), new PropertyCriterion("show", "émission 1")));
    }

    @Test
    public void parseProperty() {
        assertThat(Query.parse("type = video")).isEqualTo(new PropertyCriterion("type", "video"));
        assertThat(Query.parse("type=sound")).isEqualTo(new PropertyCriterion("type", "sound"));
    }

    @Test
    public void parseNotNull() {
        assertThat(Query.parse("show != null")).isEqualTo(new NotNullCriterion("show"));
    }

    @Test
    public void parseOr() {
        assertThat(Query.parse("or(type = video, show != null)")).isEqualTo(new OrCriterion(new PropertyCriterion("type", "video"), new NotNullCriterion("show")));
        assertThat(Query.parse("or (type=video,show!=null)")).isEqualTo(new OrCriterion(new PropertyCriterion("type", "video"), new NotNullCriterion("show")));
    }
}
