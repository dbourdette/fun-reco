package com.github.funreco.domain.recommandation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.github.funreco.domain.FacebookIdAndName;
import com.github.funreco.domain.FacebookProfileRef;
import com.github.funreco.domain.OpenGraphObject;
import com.github.funreco.engine.OpenGraphActionStat;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

public class RecommendedObject {
    /**
     * Avoids to store too many profiles for each object and get a huge collection in db
     */
    public static final int MAX_PROFILES = 20;

    @Property
    private String id;

    @Embedded
    private List<FacebookProfileRef> by;

    public static RecommendedObject object(OpenGraphObject openGraphObject) {
        return object(openGraphObject.getId());
    }

    public static RecommendedObject object(String id) {
        RecommendedObject object = new RecommendedObject();

        object.id = id;

        return object;
    }

    public static RecommendedObject fromStat(OpenGraphActionStat stat) {
        return object(stat.getObject()).by(stat.getProfiles());
    }

    public RecommendedObject by(List<? extends FacebookIdAndName> by) {
        this.by = pickSomeRandomProfiles(by);

        return this;
    }

    public RecommendedObject by(FacebookIdAndName... by) {
        return by(Arrays.asList(by));
    }

    public static List<FacebookProfileRef> pickSomeRandomProfiles(List<? extends FacebookIdAndName> profiles) {
        List<FacebookProfileRef> result = new ArrayList<FacebookProfileRef>();

        List<FacebookIdAndName> pick = new ArrayList<FacebookIdAndName>(profiles);

        Random random = new Random();

        for (int i = 0; i < Math.min(MAX_PROFILES, profiles.size()); i++) {
            int index = random.nextInt(pick.size());

            result.add(new FacebookProfileRef(pick.remove(index)));
        }

        Collections.shuffle(result);

        return result;
    }

    public RecommendedObject() {
    }

    public List<FacebookProfileRef> getBy() {
        return by;
    }

    public String getId() {
        return id;
    }

    public Long getLongId() {
        try {
            return Long.parseLong(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "RecommendedObject{" +
                "id='" + id + '\'' +
                ", by=" + by +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecommendedObject object = (RecommendedObject) o;

        if (by != null ? !by.equals(object.by) : object.by != null) return false;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (by != null ? by.hashCode() : 0);
        return result;
    }
}
