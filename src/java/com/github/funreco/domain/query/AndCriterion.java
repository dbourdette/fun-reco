package com.github.funreco.domain.query;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.github.funreco.domain.OpenGraphObject;

public class AndCriterion implements Query {
    private List<Query> criteria;

    public AndCriterion() {
    }

    public AndCriterion(List<Query> criteria) {
        this.criteria = criteria;
    }

    public AndCriterion(Query... criteria) {
        this(Arrays.asList(criteria));
    }

    public void add(Query criterion) {
        criteria.add(criterion);
    }

    @Override
    public boolean match(OpenGraphObject object) {
        for (Query criterion : criteria) {
            if (!criterion.match(object)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AndCriterion that = (AndCriterion) o;

        if (criteria != null ? !criteria.equals(that.criteria) : that.criteria != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return criteria != null ? criteria.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "and(" + StringUtils.join(criteria, ", ") + ")";
    }
}
