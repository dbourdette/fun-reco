package com.github.funreco.domain.query;

import com.github.funreco.domain.OpenGraphObject;

/**
 * @author damien bourdette
 */
public interface Criterion {
    public boolean match(OpenGraphObject object);
}
