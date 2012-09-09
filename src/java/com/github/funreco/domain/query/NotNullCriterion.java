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
}
