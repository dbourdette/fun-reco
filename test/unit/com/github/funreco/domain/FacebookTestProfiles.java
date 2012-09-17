package com.github.funreco.domain;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

public class FacebookTestProfiles {
    public static FacebookProfile johnDoe() {
        return aProfile("john.doe@unkown.com");
    }

    public static FacebookProfile janeDoe() {
        return aProfile("jane.doe@unkown.com");
    }

    public static FacebookProfile profileForId(int id) {
        return aProfile("testprofile" + id + "@unkown.com");
    }

    public static FacebookProfileRef aProfileRef(String email) {
        return aProfile(email).toRef();
    }

    public static FacebookProfile aProfile(String email) {
        String name = StringUtils.substringBefore(email, "@");
        String id = String.valueOf(email.hashCode());

        try {
            return FacebookProfile.fromJson("{" +
                    "\"id\" : \"" + id + "\"," +
                    "\"email\" : \"" + email + "\"," +
                    "\"name\" : \"" + name + "\"" +
                    "}");
        } catch (IOException e) {
            throw new RuntimeException("Failed to create profile", e);
        }
    }
}
