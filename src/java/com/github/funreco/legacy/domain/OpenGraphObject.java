package com.github.funreco.legacy.domain;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

public class OpenGraphObject {
    @Property
    private String id;

    /**
     * A property is multi valued.
     */
    @Embedded
    private Map<String, Set<String>> properties = new HashMap<String, Set<String>>();

    public OpenGraphObject() {
    }

    public OpenGraphObject(Long id) {
        this.id = id.toString();
    }

    public OpenGraphObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public OpenGraphObject put(String key, String... values) {
        Collections.addAll(ensureKey(key), values);

        return this;
    }

    /**
     * Reads properties from standard java properties form
     */
    public void setProperties(String properties) {
        this.properties = new HashMap<String, Set<String>>();

        Properties props = new Properties();

        try {
            props.load(new StringReader(properties));
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to read properties", e);
        }

        for (Object object : props.keySet()) {
            String key = (String) object;

            put(key, StringUtils.split((String) props.get(key), ","));
        }
    }

    public Set<String> get(String key) {
        return properties.get(key);
    }

    public Map<String, Set<String>> getProperties() {
        return properties;
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
    public String toString() {
        return "OpenGraphObject{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                '}';
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
