package com.github.funreco.domain.query;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.github.funreco.domain.query.parser.QueryLexer;
import com.github.funreco.domain.query.parser.QueryParser;


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

    public static Criterion parse(String query) {
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
