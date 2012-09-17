package com.github.funreco.domain.query;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class QueriesTest {
    @Test
    public void property() {
        assertThat(Queries.property("type", "video")).isEqualTo(new PropertyCriterion("type", "video"));
    }

    @Test
    public void notNull() {
        assertThat(Queries.notNull("type")).isEqualTo(new NotNullCriterion("type"));
    }

    @Test
    public void or() {
        assertThat(Queries.or(Queries.property("type", "video"), Queries.property("show", "émission 1")))
                .isEqualTo(new OrCriterion(new PropertyCriterion("type", "video"), new PropertyCriterion("show", "émission 1")));
    }

    @Test
    public void propertyToString() {
        assertThat(Queries.property("type", "video").toString()).isEqualTo("type='video'");
    }

    @Test
    public void notNullToString() {
        assertThat(Queries.notNull("show").toString()).isEqualTo("show!=null");
    }

    @Test
    public void andToString() {
        assertThat(Queries.and(Queries.property("type", "video"), Queries.notNull("show")).toString()).isEqualTo("and(type='video', show!=null)");
    }

    @Test
    public void orToString() {
        assertThat(Queries.or(Queries.property("type", "video"), Queries.notNull("show")).toString()).isEqualTo("or(type='video', show!=null)");
    }

    @Test
    public void parseProperty() {
        Query expected = Queries.property("type", "video");

        assertThat(Queries.parse("type = video")).isEqualTo(expected);
        assertThat(Queries.parse("type=video")).isEqualTo(expected);
    }

    @Test
    public void parsePropertyWithSpace() {
        Query expected = Queries.property("speaker", "Bruno Guillon");

        assertThat(Queries.parse("speaker = 'Bruno Guillon'  ")).isEqualTo(expected);
        assertThat(Queries.parse("speaker='Bruno Guillon'")).isEqualTo(expected);
    }

    @Test
    public void parsePropertyAccents() {
        Query expected = Queries.property("speaker", "Héhé èéà");

        assertThat(Queries.parse("speaker = 'Héhé èéà'")).isEqualTo(expected);
    }

    @Test
    public void parseNotNull() {
        assertThat(Queries.parse("show != null")).isEqualTo(new NotNullCriterion("show"));
    }

    @Test
    public void parseOr() {
        Query expected = Queries.or(Queries.property("type", "video"), Queries.notNull("show"));

        assertThat(Queries.parse("or(type = video, show != null)")).isEqualTo(expected);
        assertThat(Queries.parse("or (type=video,show!=null)")).isEqualTo(expected);
    }

    @Test
    public void parseAnd() {
        Query expected = Queries.and(Queries.property("type", "video"), Queries.notNull("show"));

        assertThat(Queries.parse("and(type = video, show != null)")).isEqualTo(expected);
        assertThat(Queries.parse("and (type=video,show!=null)")).isEqualTo(expected);
    }

    @Test
    public void parseNested() {
        Query expected = Queries.and(
                Queries.property("type", "video"),
                Queries.or(Queries.property("tag", "starfloor2010"), Queries.property("tag", "starfloor2011"), Queries.property("tag", "starfloor2012")));

        assertThat(Queries.parse("and(type=video, or(tag=starfloor2010, tag=starfloor2011, tag=starfloor2012))")).isEqualTo(expected);
    }
}
