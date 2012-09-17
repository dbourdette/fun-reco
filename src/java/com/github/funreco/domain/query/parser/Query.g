grammar Query;

@header {
    package com.github.funreco.domain.query.parser;

    import java.util.Stack;

    import com.github.funreco.domain.query.Query;
    import com.github.funreco.domain.query.PropertyCriterion;
    import com.github.funreco.domain.query.NotNullCriterion;
    import com.github.funreco.domain.query.OrCriterion;
    import com.github.funreco.domain.query.AndCriterion;
}

@lexer::header {
    package com.github.funreco.domain.query.parser;
}

@members {

}

parse returns [Query query] : q=criterion { $query = q; } ;

criterion returns [Query query] :
    a=and { $query = a; } |
    b=or { $query = b; } |
    c=notNull { $query = c; } |
    d=property { $query = d; } ;

property returns [PropertyCriterion criterion] :
    key=TEXT '=' value= TEXT {
    $criterion = new PropertyCriterion($key.text, $value.text);
};

notNull returns [NotNullCriterion criterion] : key=TEXT '!=' NULL {
    $criterion = new NotNullCriterion($key.text);
};

or returns [OrCriterion orCriterion] :
    'or' '(' { $orCriterion = new OrCriterion(); }
     e=criterion { $orCriterion.add(e); }
     ( ',' e=criterion { $orCriterion.add(e); } )*  ')' ;

and returns [AndCriterion andCriterion] :
    'and' '(' { $andCriterion = new AndCriterion(); }
    e=criterion { $andCriterion.add(e); }
    ( ',' e=criterion { $andCriterion.add(e); } )*  ')' ;

NULL :  'null' ;
fragment LETTER : 'a'..'z' | 'A'..'Z' ;
fragment ACCENT : '\u00C0'..'\u00D6' | '\u00D9'..'\u00DD' | '\u00E0'..'\u00F6' |'\u00F9'..'\u00FD';
fragment DIGIT : '0'..'9' ;
fragment QUOTE : '\'' ;
fragment DBL_QUOTE : '"' ;
TEXT  :  (LETTER|DIGIT|ACCENT)+ | (QUOTE (LETTER|DIGIT|ACCENT|' ')* QUOTE) | (DBL_QUOTE (LETTER|DIGIT|ACCENT|' ')* DBL_QUOTE) ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;