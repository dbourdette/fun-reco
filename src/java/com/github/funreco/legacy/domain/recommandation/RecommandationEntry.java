package com.github.funreco.legacy.domain.recommandation;

import java.util.List;

public class RecommandationEntry {
    private String query;

    private List<RecommendedObject> objects;

    public RecommandationEntry() {
    }

    public RecommandationEntry(String query, List<RecommendedObject> objects) {
        this.query = query;
        this.objects = objects;
    }

    public String getQuery() {
        return query;
    }

    public List<RecommendedObject> getObjects() {
        return objects;
    }

    public void setObjects(List<RecommendedObject> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "RecommandationEntry{" +
                "query='" + query + '\'' +
                ", objects=" + objects +
                '}';
    }
}
