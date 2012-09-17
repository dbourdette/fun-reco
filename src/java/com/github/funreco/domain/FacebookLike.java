package com.github.funreco.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class FacebookLike {
    private String category;

    private String name;

    public static List<FacebookLike> fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(json);

        List<FacebookLike> likes = new ArrayList<FacebookLike>();

        for (JsonNode node : rootNode.get("data")) {
            String category = node.get("category").getTextValue();
            String name = node.get("name").getTextValue();

            likes.add(FacebookLike.fromCategoryAndName(category, name));
        }

        return likes;
    }

    public static FacebookLike fromCategoryAndName(String category, String name) {
        FacebookLike like = new FacebookLike();

        like.category = category;
        like.name = name;

        return like;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FacebookLike{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
