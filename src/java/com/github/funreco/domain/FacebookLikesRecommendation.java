package com.github.funreco.domain;

import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity(value = FacebookLikesRecommendation.COLLECTION_NAME, noClassnameStored = true)
public class FacebookLikesRecommendation {
    public static final String COLLECTION_NAME = "facebook.likes.recommandations";

    @Id
    private ObjectId id;

    @Embedded
    private FacebookProfileRef profile;

    @Property
    private List<String> keywords;

    public static FacebookLikesRecommendation forProfile(FacebookIdAndName profile) {
        FacebookLikesRecommendation recommendation = new FacebookLikesRecommendation();

        recommendation.profile = new FacebookProfileRef(profile);

        return recommendation;
    }

    public String getRandomKeyword() {
        if (CollectionUtils.isEmpty(keywords)) {
            return null;
        }

        return keywords.get(new Random().nextInt(keywords.size()));
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public FacebookProfileRef getProfile() {
        return profile;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
