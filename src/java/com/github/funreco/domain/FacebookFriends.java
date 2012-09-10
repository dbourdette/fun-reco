package com.github.funreco.domain;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value = FacebookFriends.COLLECTION_NAME, noClassnameStored = true)
public class FacebookFriends {
    public static final String COLLECTION_NAME = "facebook.friends";

    @Id
    private ObjectId id;

    @Embedded
    private FacebookProfileRef profile;

    @Embedded
    private List<FacebookProfileRef> friends;

    public static FacebookFriends fromProfileAndFriends(FacebookIdAndName profile, List<FacebookProfileRef> friends) {
        FacebookFriends facebookFriends = new FacebookFriends();

        facebookFriends.profile = FacebookProfileRef.fromIdAndName(profile);
        facebookFriends.friends = friends;

        return facebookFriends;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public List<FacebookProfileRef> getFriends() {
        return friends;
    }

    public FacebookProfileRef getProfile() {
        return profile;
    }
}
