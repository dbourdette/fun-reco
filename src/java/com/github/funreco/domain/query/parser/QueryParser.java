// $ANTLR 3.4 /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g 2012-09-12 09:21:43

    package com.github.funreco.domain.query.parser;

    import java.util.Stack;

    import com.github.funreco.domain.query.Query;
    import com.github.funreco.domain.query.PropertyCriterion;
    import com.github.funreco.domain.query.NotNullCriterion;
    import com.github.funreco.domain.query.OrCriterion;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "NULL", "TEXT", "WS", "'!='", "'('", "')'", "','", "'='", "'or'"
    };

    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int NEWLINE=4;
    public static final int NULL=5;
    public static final int TEXT=6;
    public static final int WS=7;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QueryParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QueryParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return QueryParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g"; }






    // $ANTLR start "parse"
    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:22:1: parse returns [Query query] : q= criterion ;
    public final Query parse() throws RecognitionException {
        Query query = null;


        Query q =null;


        try {
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:22:29: (q= criterion )
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:22:31: q= criterion
            {
            pushFollow(FOLLOW_criterion_in_parse37);
            q=criterion();

            state._fsp--;


             query = q; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return query;
    }
    // $ANTLR end "parse"



    // $ANTLR start "criterion"
    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:24:1: criterion returns [Query query] : (a= or |b= notNull |c= property );
    public final Query criterion() throws RecognitionException {
        Query query = null;


        OrCriterion a =null;

        NotNullCriterion b =null;

        PropertyCriterion c =null;


        try {
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:24:33: (a= or |b= notNull |c= property )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==TEXT) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==8) ) {
                    alt1=2;
                }
                else if ( (LA1_2==12) ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:25:5: a= or
                    {
                    pushFollow(FOLLOW_or_in_criterion58);
                    a=or();

                    state._fsp--;


                     query = a; 

                    }
                    break;
                case 2 :
                    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:26:5: b= notNull
                    {
                    pushFollow(FOLLOW_notNull_in_criterion70);
                    b=notNull();

                    state._fsp--;


                     query = b; 

                    }
                    break;
                case 3 :
                    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:27:5: c= property
                    {
                    pushFollow(FOLLOW_property_in_criterion82);
                    c=property();

                    state._fsp--;


                     query = c; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return query;
    }
    // $ANTLR end "criterion"



    // $ANTLR start "property"
    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:29:1: property returns [PropertyCriterion criterion] : key= TEXT '=' value= TEXT ;
    public final PropertyCriterion property() throws RecognitionException {
        PropertyCriterion criterion = null;


        Token key=null;
        Token value=null;

        try {
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:29:48: (key= TEXT '=' value= TEXT )
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:29:50: key= TEXT '=' value= TEXT
            {
            key=(Token)match(input,TEXT,FOLLOW_TEXT_in_property99); 

            match(input,12,FOLLOW_12_in_property101); 

            value=(Token)match(input,TEXT,FOLLOW_TEXT_in_property105); 


                criterion = new PropertyCriterion((key!=null?key.getText():null), (value!=null?value.getText():null));


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return criterion;
    }
    // $ANTLR end "property"



    // $ANTLR start "notNull"
    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:33:1: notNull returns [NotNullCriterion criterion] : key= TEXT '!=' NULL ;
    public final NotNullCriterion notNull() throws RecognitionException {
        NotNullCriterion criterion = null;


        Token key=null;

        try {
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:33:46: (key= TEXT '!=' NULL )
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:33:48: key= TEXT '!=' NULL
            {
            key=(Token)match(input,TEXT,FOLLOW_TEXT_in_notNull121); 

            match(input,8,FOLLOW_8_in_notNull123); 

            match(input,NULL,FOLLOW_NULL_in_notNull125); 


                criterion = new NotNullCriterion((key!=null?key.getText():null));


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return criterion;
    }
    // $ANTLR end "notNull"



    // $ANTLR start "or"
    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:37:1: or returns [OrCriterion orCriterion] : 'or' WS '(' e= criterion ( ',' e= criterion )* ')' ;
    public final OrCriterion or() throws RecognitionException {
        OrCriterion orCriterion = null;


        Query e =null;


        try {
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:37:38: ( 'or' WS '(' e= criterion ( ',' e= criterion )* ')' )
            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:38:5: 'or' WS '(' e= criterion ( ',' e= criterion )* ')'
            {
            match(input,13,FOLLOW_13_in_or143); 

            match(input,WS,FOLLOW_WS_in_or145); 

            match(input,9,FOLLOW_9_in_or147); 

             orCriterion = new OrCriterion(); 

            pushFollow(FOLLOW_criterion_in_or158);
            e=criterion();

            state._fsp--;


             orCriterion.add(e); 

            // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:40:6: ( ',' e= criterion )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/bourdette/projects-git/fun-reco/src/java/com/github/funreco/domain/query/parser/Query.g:40:8: ',' e= criterion
            	    {
            	    match(input,11,FOLLOW_11_in_or169); 

            	    pushFollow(FOLLOW_criterion_in_or173);
            	    e=criterion();

            	    state._fsp--;


            	     orCriterion.add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,10,FOLLOW_10_in_or181); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return orCriterion;
    }
    // $ANTLR end "or"

    // Delegated rules


 

    public static final BitSet FOLLOW_criterion_in_parse37 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_in_criterion58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notNull_in_criterion70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_criterion82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_property99 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_property101 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_property105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_notNull121 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_notNull123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NULL_in_notNull125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_or143 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WS_in_or145 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_or147 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_criterion_in_or158 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_11_in_or169 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_criterion_in_or173 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_10_in_or181 = new BitSet(new long[]{0x0000000000000002L});

}