package com.github.funreco.legacy.domain.recommandation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.github.funreco.legacy.domain.FacebookIdAndName;
import com.github.funreco.legacy.domain.FacebookProfileRef;
import com.github.funreco.legacy.domain.OpenGraphQuery;
import com.github.funreco.legacy.domain.query.Query;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PostLoad;
import com.google.code.morphia.annotations.PrePersist;
import com.google.code.morphia.annotations.Transient;

@Entity(value = OpenGraphRecommendation.COLLECTION_NAME, noClassnameStored = true)
public class OpenGraphRecommendation {
    public static final String COLLECTION_NAME = "facebook.opengraph.recommandations";

    @Id
    private ObjectId id;

    /**
     * profile can be null, meaning we target all users.
     */
    @Embedded
    private FacebookProfileRef profile;

    @Embedded
    private List<RecommandationEntry> entries = new ArrayList<RecommandationEntry>();

    @Transient
    private Map<String, RecommandationEntry> map = new HashMap<String, RecommandationEntry>();

    public static OpenGraphRecommendation forAllProfiles() {
        return new OpenGraphRecommendation();
    }

    public static OpenGraphRecommendation forProfile(FacebookIdAndName profile) {
        OpenGraphRecommendation recommendation = new OpenGraphRecommendation();

        recommendation.profile = new FacebookProfileRef(profile);

        return recommendation;
    }

    @PostLoad
    public void fillMap() {
        map.clear();

        for (RecommandationEntry entry : entries) {
            map.put(entry.getQuery(), entry);
        }
    }

    @PrePersist
    public void fillEntries() {
        entries.clear();
        entries.addAll(map.values());
    }

    public OpenGraphRecommendation() {
    }

    public int size() {
        return map.size();
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

    public Collection<RecommandationEntry> getEntries() {
        return map.values();
    }

    public List<String> getQueries() {
        List<String> queries = new ArrayList<String>();

        queries.addAll(map.keySet());
        Collections.sort(queries);

        return queries;
    }

    public RecommandationEntry getEntry(String query) {
        return map.get(query);
    }

    public RecommendationHelper forQuery(String query) {
        return new RecommendationHelper(query);
    }

    public RecommendationHelper forQuery(Query query) {
        return forQuery(query.toString());
    }

    public RecommendationHelper forQuery(OpenGraphQuery query) {
        return forQuery(query.getQuery());
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "entries=" + entries +
                ", id=" + id +
                ", profile=" + profile +
                '}';
    }

    public class RecommendationHelper {
        private String query;

        public RecommendationHelper(String query) {
            this.query = query;
        }

        public List<RecommendedObject> getObjects() {
            RecommandationEntry entry = map.get(query);

            if (entry == null) {
                return Collections.emptyList();
            }

            return entry.getObjects();
        }

        public void recommend(List<RecommendedObject> objects) {
            if (objects == null || objects.size() == 0) {
                return;
            }

            map.put(query, new RecommandationEntry(query, objects));
        }

        public void recommend(RecommendedObject... objects) {
            if (objects == null || objects.length == 0) {
                return;
            }

            map.put(query, new RecommandationEntry(query, Arrays.asList(objects)));
        }
    }
}
