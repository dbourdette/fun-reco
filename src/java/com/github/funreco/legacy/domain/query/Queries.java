package com.github.funreco.legacy.domain.query;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.github.funreco.legacy.domain.query.parser.QueryLexer;
import com.github.funreco.legacy.domain.query.parser.QueryParser;

public class Queries {
    public static PropertyCriterion property(String key, String value) {
        return new PropertyCriterion(key, value);
    }

    public static PropertyCriterion property(String key, Long value) {
        return property(key, value.toString());
    }

    public static OrCriterion or(Query... criteria) {
        return new OrCriterion(criteria);
    }

    public static AndCriterion and(Query... criteria) {
        return new AndCriterion(criteria);
    }

    public static NotNullCriterion notNull(String key) {
        return new NotNullCriterion(key);
    }

    public static Query parse(String query) {
        QueryLexer lex = new QueryLexer(new ANTLRStringStream(query));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        QueryParser parser = new QueryParser(tokens);

        try {
            return parser.parse();
        } catch (RecognitionException e) {
            throw new IllegalArgumentException("Failed to parse query", e);
        }
    }
}
