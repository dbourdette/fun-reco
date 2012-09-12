package com.github.funreco.domain.query;

import com.github.funreco.domain.OpenGraphObject;


/**
 * @author damien bourdette
 */
public interface Query {
    public boolean match(OpenGraphObject object);
}
