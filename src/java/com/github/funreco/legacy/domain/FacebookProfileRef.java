package com.github.funreco.legacy.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

public class FacebookProfileRef implements FacebookIdAndName {
    @Id
    private ObjectId id;

    @Property
    private String facebookId;

    @Property
    private String name;

    public static FacebookProfileRef fromIdAndName(String facebookId, String name) {
        FacebookProfileRef ref = new FacebookProfileRef();

        ref.facebookId = facebookId;
        ref.name = name;

        return ref;
    }

    public static FacebookProfileRef fromIdAndName(FacebookIdAndName facebookIdAndName) {
        FacebookProfileRef ref = new FacebookProfileRef();

        ref.facebookId = facebookIdAndName.getFacebookId();
        ref.name = facebookIdAndName.getName();

        return ref;
    }

    public static List<FacebookProfileRef> fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(json);

        List<FacebookProfileRef> friends = new ArrayList<FacebookProfileRef>();

        for (JsonNode node : rootNode.get("data")) {
            String facebookId = node.get("id").getTextValue();
            String name = node.get("name").getTextValue();

            friends.add(fromIdAndName(facebookId, name));
        }

        return friends;
    }

    public FacebookProfileRef() {
    }

    public FacebookProfileRef(FacebookIdAndName profile) {
        this.facebookId = profile.getFacebookId();
        this.name = profile.getName();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FacebookProfileRef{" +
                "facebookId='" + facebookId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacebookProfileRef that = (FacebookProfileRef) o;

        if (facebookId != null ? !facebookId.equals(that.facebookId) : that.facebookId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return facebookId != null ? facebookId.hashCode() : 0;
    }
}
