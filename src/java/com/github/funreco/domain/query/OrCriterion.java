package com.github.funreco.domain.query;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.github.funreco.domain.OpenGraphObject;

public class OrCriterion implements Query {
    private List<Query> criteria;

    public OrCriterion() {
    }

    public OrCriterion(List<Query> criteria) {
        this.criteria = criteria;
    }

    public OrCriterion(Query... criteria) {
        this(Arrays.asList(criteria));
    }

    @Override
    public boolean match(OpenGraphObject object) {
        for (Query criterion : criteria) {
            if (criterion.match(object)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrCriterion that = (OrCriterion) o;

        if (criteria != null ? !criteria.equals(that.criteria) : that.criteria != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return criteria != null ? criteria.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "or(" + StringUtils.join(criteria, ", ") + ")";
    }
}
