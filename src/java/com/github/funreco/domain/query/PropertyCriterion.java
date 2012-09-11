package com.github.funreco.domain.query;

import java.util.Set;

import com.github.funreco.domain.OpenGraphObject;

public class PropertyCriterion implements Query {
    private String key;

    private String value;

    public PropertyCriterion() {
    }

    public PropertyCriterion(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean match(OpenGraphObject object) {
        Set<String> values = object.get(key);

        return values != null && values.contains(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyCriterion that = (PropertyCriterion) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
