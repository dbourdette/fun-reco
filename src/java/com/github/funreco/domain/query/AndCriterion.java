package com.github.funreco.domain.query;

import java.util.Arrays;
import java.util.List;

import com.github.funreco.domain.OpenGraphObject;

/**
 * @author damien bourdette
 */
public class AndCriterion implements Criterion {
    private List<Criterion> criteria;

    public AndCriterion(List<Criterion> criteria) {
        this.criteria = criteria;
    }

    public AndCriterion(Criterion... criteria) {
        this(Arrays.asList(criteria));
    }

    @Override
    public boolean match(OpenGraphObject object) {
        for (Criterion criterion : criteria) {
            if (!criterion.match(object)) {
                return false;
            }
        }

        return true;
    }
}
