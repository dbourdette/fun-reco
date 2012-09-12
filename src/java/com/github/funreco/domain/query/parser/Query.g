grammar Query;

@header {
    package com.github.funreco.domain.query.parser;

    import java.util.Stack;

    import com.github.funreco.domain.query.Query;
    import com.github.funreco.domain.query.PropertyCriterion;
    import com.github.funreco.domain.query.NotNullCriterion;
    import com.github.funreco.domain.query.OrCriterion;
}

@lexer::header {
    package com.github.funreco.domain.query.parser;
}

@members {

}

parse returns [Query query] : q=criterion { $query = q; } ;

criterion returns [Query query] :
    a=or { $query = a; } |
    b=notNull { $query = b; } |
    c=property { $query = c; } ;

property returns [PropertyCriterion criterion] : key=TEXT '=' value=TEXT {
    $criterion = new PropertyCriterion($key.text, $value.text);
};

notNull returns [NotNullCriterion criterion] : key=TEXT '!=' NULL {
    $criterion = new NotNullCriterion($key.text);
};

or returns [OrCriterion orCriterion] :
    'or' WS '(' { $orCriterion = new OrCriterion(); }
     e=criterion { $orCriterion.add(e); }
     ( ',' e=criterion { $orCriterion.add(e); } )*  ')' ;

NULL :  'null' ;
TEXT  :   ('a'..'z'|'A'..'Z')+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;