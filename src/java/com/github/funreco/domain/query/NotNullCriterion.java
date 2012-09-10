package com.github.funreco.domain.query;

import com.github.funreco.domain.OpenGraphObject;

/**
 * @author damien bourdette
 */
public class NotNullCriterion implements Criterion {
    private String key;

    public NotNullCriterion(String key) {
        this.key = key;
    }

    @Override
    public boolean match(OpenGraphObject object) {
        return object.get(key) != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotNullCriterion that = (NotNullCriterion) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }
}
