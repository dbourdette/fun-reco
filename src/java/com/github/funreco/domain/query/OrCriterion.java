package com.github.funreco.domain.query;

import java.util.Arrays;
import java.util.List;

import com.github.funreco.domain.OpenGraphObject;

/**
 * @author damien bourdette
 */
public class OrCriterion implements Criterion {
    private List<Criterion> criteria;

    public OrCriterion(List<Criterion> criteria) {
        this.criteria = criteria;
    }

    public OrCriterion(Criterion... criteria) {
        this(Arrays.asList(criteria));
    }

    @Override
    public boolean match(OpenGraphObject object) {
        for (Criterion criterion : criteria) {
            if (criterion.match(object)) {
                return true;
            }
        }

        return false;
    }
}
