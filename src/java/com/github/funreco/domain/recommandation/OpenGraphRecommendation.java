package com.github.funreco.domain.recommandation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.github.funreco.domain.FacebookIdAndName;
import com.github.funreco.domain.FacebookProfileRef;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PostLoad;
import com.google.code.morphia.annotations.PrePersist;
import com.google.code.morphia.annotations.Transient;

/**
 * Recommendations for a profile
 */
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

    public RecommandationEntry getEntry(String key) {
        return map.get(key);
    }

    public RecommendationAppender forQuery(String query) {
         return new RecommendationAppender(query);
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "entries=" + entries +
                ", id=" + id +
                ", profile=" + profile +
                '}';
    }

    public class RecommendationAppender {
        private String query;

        public RecommendationAppender(String query) {
            this.query = query;
        }

        public void recommend(List<RecommendedObject> objects) {
            map.put(query, new RecommandationEntry(query, objects));
        }
    }
}
