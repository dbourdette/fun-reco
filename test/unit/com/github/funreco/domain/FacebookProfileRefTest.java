package com.github.funreco.domain;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author damien bourdette
 */
public class FacebookProfileRefTest {
    @Test
    public void fromJson() throws IOException {
        List<FacebookProfileRef> friends = FacebookProfileRef.fromJson(json());

        assertThat(friends.get(0).getFacebookId()).isEqualTo("656646443");
        assertThat(friends.get(0).getName()).isEqualTo("Friend 1");
    }

    private String json() {
        return "{\"data\":[" +
                "{\"name\":\"Friend 1\",\"id\":\"656646443\"}," +
                "{\"name\":\"Friend 2\",\"id\":\"656646444\"}," +
                "{\"name\":\"Friend 3\",\"id\":\"656646445\"}]," +
                "\"paging\":" +
                "{\"next\":\"https:\\/\\/graph.facebook.com\\/650249226\\/friends?value=1&amp;redirect=1&amp;access_token=AAACxdEK8FZAABAHjjf5LSVYZCRxoozztGF2a3rC2ZC7jhk16RviLmZAUPfxDFq1b1RevJhdcGW63V6ZCnuSIKDCmktTC9M9b1M85QYq5b9wZDZD&amp;limit=5000&amp;offset=5000&amp;__after_id=100001533758554\"}" +
                "}";
    }
}
