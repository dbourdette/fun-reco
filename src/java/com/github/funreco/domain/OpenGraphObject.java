package com.github.funreco.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.code.morphia.annotations.Property;

/**
 * @author damien bourdette
 */
public class OpenGraphObject {
    @Property
    private String id;

    /**
     * A property is multi valued.
     */
    @Property
    private Map<String, Set<String>> properties = new HashMap<String, Set<String>>();

    public OpenGraphObject() {
    }

    public OpenGraphObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public OpenGraphObject put(String key, String... values) {
        for (String value : values) {
            ensureKey(key).add(value);
        }

        return this;
    }

    public Set<String> get(String key) {
        return properties.get(key);
    }

    private Set<String> ensureKey(String key) {
        Set<String> values = properties.get(key);

        if (values == null) {
            values = new HashSet<String>();
            properties.put(key, values);
        }

        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenGraphObject that = (OpenGraphObject) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}
