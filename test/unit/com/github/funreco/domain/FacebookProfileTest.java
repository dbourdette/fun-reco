package com.github.funreco.domain;

import java.io.IOException;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author damien bourdette
 */
public class FacebookProfileTest {
    @Test
    public void fromJson() throws IOException {
        assertThat(FacebookProfile.fromJson(json()).getFacebookId()).isEqualTo("19292868552");
        assertThat(FacebookProfile.fromJson(json()).getName()).isEqualTo("Facebook Platform");
        assertThat(FacebookProfile.fromJson(json()).getUsername()).isEqualTo("platform");
    }

    private String json() {
        return "{\n" +
                "   \"name\": \"Facebook Platform\",\n" +
                "   \"website\": \"http://developers.facebook.com\",\n" +
                "   \"username\": \"platform\",\n" +
                "   \"founded\": \"May 2007\",\n" +
                "   \"company_overview\": \"Facebook Platform enables anyone to build...\",\n" +
                "   \"mission\": \"To make the web more open and social.\",\n" +
                "   \"products\": \"Facebook Application Programming Interface (API)...\",\n" +
                "   \"likes\": 449921,\n" +
                "   \"id\": 19292868552,\n" +
                "   \"category\": \"Technology\"\n" +
                "}";
    }
}
