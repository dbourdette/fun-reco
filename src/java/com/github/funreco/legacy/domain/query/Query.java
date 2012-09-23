package com.github.funreco.legacy.domain.query;

import com.github.funreco.legacy.domain.OpenGraphObject;

public interface Query {
    public boolean match(OpenGraphObject object);
}
