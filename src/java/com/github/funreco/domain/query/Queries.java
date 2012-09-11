package com.github.funreco.domain.query;

import org.apache.commons.lang.StringUtils;

public class Queries {
    public static Query property(String key, String value) {
        return new PropertyCriterion(key, value);
    }

    public static Query or(Query... criteria) {
        return new OrCriterion(criteria);
    }

    public static Query and(Query... criteria) {
        return new AndCriterion(criteria);
    }

    public static Query notNull(String key) {
        return new NotNullCriterion(key);
    }

    public static Query parse(String query) {
        String[] keyValue = StringUtils.split(query, "=");

        return Queries.property(StringUtils.trim(keyValue[0]), StringUtils.trim(keyValue[1]));
    }
}
