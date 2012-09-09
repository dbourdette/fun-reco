package com.github.funreco.domain;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author damien bourdette
 */
public class OpenGraphObjectTest {
    @Test
    public void createObjectWithSingleProperty() {
        OpenGraphObject object = new OpenGraphObject().put("type", "video");

        assertThat(object.get("type")).contains("video");
    }

    @Test
    public void createObjectWithMultipleProperties() {
        OpenGraphObject object = new OpenGraphObject();
        object.put("type", "image").put("show", "la grosse émission").put("personnalités", "casimir");

        assertThat(object.get("type")).contains("image");
        assertThat(object.get("show")).contains("la grosse émission");
        assertThat(object.get("personnalités")).contains("casimir");
    }

    @Test
    public void createObjectWithMultipleValuesForAKey() {
        OpenGraphObject object = new OpenGraphObject().put("personnalités", "harpo", "chico", "groucho");

        assertThat(object.get("personnalités")).contains("harpo", "chico", "groucho");
    }

    @Test
    public void equals() {
        OpenGraphObject object1 = new OpenGraphObject().put("type", "image").put("personnalités", "harpo", "chico", "groucho");
        OpenGraphObject object2 = new OpenGraphObject().put("personnalités", "groucho", "harpo", "chico").put("type", "image");

        assertThat(object1).isEqualTo(object2);
    }
}
