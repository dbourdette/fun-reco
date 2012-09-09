package com.github.funreco.domain.query;

/**
 * @author damien bourdette
 */
public class Query {
    public static Criterion property(String key, String value) {
        return new PropertyCriterion(key, value);
    }

    public static Criterion or(Criterion... criteria) {
        return new OrCriterion(criteria);
    }

    public static Criterion and(Criterion... criteria) {
        return new AndCriterion(criteria);
    }

    public static Criterion notNull(String key) {
        return new NotNullCriterion(key);
    }
}
