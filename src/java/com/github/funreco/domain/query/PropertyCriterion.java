package com.github.funreco.domain.query;

import java.util.Set;

import com.github.funreco.domain.OpenGraphObject;

/**
 * @author damien bourdette
 */
public class PropertyCriterion implements Criterion {
    private String key;

    private String value;

    public PropertyCriterion(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean match(OpenGraphObject object) {
        Set<String> values = object.get(key);

        return values != null && values.contains(value);
    }
}
