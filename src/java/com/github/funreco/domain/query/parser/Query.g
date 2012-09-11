grammar Query;

@header {
    package com.github.funreco.domain.query.parser;

    import java.util.Stack;

    import com.github.funreco.domain.query.Criterion;
    import com.github.funreco.domain.query.PropertyCriterion;
    import com.github.funreco.domain.query.NotNullCriterion;
    import com.github.funreco.domain.query.OrCriterion;
}

@lexer::header {
    package com.github.funreco.domain.query.parser;
}

@members {

}

parse returns [Criterion criterion] : c=criterion { $criterion = c; } ;

criterion returns [Criterion criterion] :
    a=or { $criterion = a; } |
    b=notNull { $criterion = b; } |
    c=property { $criterion = c; } ;

property returns [PropertyCriterion criterion] : key=ID '=' value=ID {
    $criterion = new PropertyCriterion($key.text, $value.text);
};

notNull returns [NotNullCriterion criterion] : key=ID '!=' NULL {
    $criterion = new NotNullCriterion($key.text);
};

or returns [OrCriterion orCriterion] :
    'or(' { $orCriterion = new OrCriterion(); }
     e=criterion { $orCriterion.add(e); }
     ( ',' e=criterion { $orCriterion.add(e); } )*  ')' ;

NULL :  'null' ;
ID  :   ('a'..'z'|'A'..'Z')+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;