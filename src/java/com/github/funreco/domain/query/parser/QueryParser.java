// $ANTLR 3.4 /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g 2012-09-12 13:18:56

    package com.github.funreco.domain.query.parser;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.github.funreco.domain.query.AndCriterion;
import com.github.funreco.domain.query.NotNullCriterion;
import com.github.funreco.domain.query.OrCriterion;
import com.github.funreco.domain.query.PropertyCriterion;
import com.github.funreco.domain.query.Query;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACCENT", "DBL_QUOTE", "DIGIT", "LETTER", "NEWLINE", "NULL", "QUOTE", "TEXT", "WS", "'!='", "'('", "')'", "','", "'='", "'and'", "'or'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int ACCENT=4;
    public static final int DBL_QUOTE=5;
    public static final int DIGIT=6;
    public static final int LETTER=7;
    public static final int NEWLINE=8;
    public static final int NULL=9;
    public static final int QUOTE=10;
    public static final int TEXT=11;
    public static final int WS=12;

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
    public String getGrammarFileName() { return "/Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g"; }






    // $ANTLR start "parse"
    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:23:1: parse returns [Query query] : q= criterion ;
    public final Query parse() throws RecognitionException {
        Query query = null;


        Query q =null;


        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:23:29: (q= criterion )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:23:31: q= criterion
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
    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:25:1: criterion returns [Query query] : (a= and |b= or |c= notNull |d= property );
    public final Query criterion() throws RecognitionException {
        Query query = null;


        AndCriterion a =null;

        OrCriterion b =null;

        NotNullCriterion c =null;

        PropertyCriterion d =null;


        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:25:33: (a= and |b= or |c= notNull |d= property )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case TEXT:
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==13) ) {
                    alt1=3;
                }
                else if ( (LA1_3==17) ) {
                    alt1=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:26:5: a= and
                    {
                    pushFollow(FOLLOW_and_in_criterion58);
                    a=and();

                    state._fsp--;


                     query = a; 

                    }
                    break;
                case 2 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:27:5: b= or
                    {
                    pushFollow(FOLLOW_or_in_criterion70);
                    b=or();

                    state._fsp--;


                     query = b; 

                    }
                    break;
                case 3 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:28:5: c= notNull
                    {
                    pushFollow(FOLLOW_notNull_in_criterion82);
                    c=notNull();

                    state._fsp--;


                     query = c; 

                    }
                    break;
                case 4 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:29:5: d= property
                    {
                    pushFollow(FOLLOW_property_in_criterion94);
                    d=property();

                    state._fsp--;


                     query = d; 

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
    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:31:1: property returns [PropertyCriterion criterion] : key= TEXT '=' value= TEXT ;
    public final PropertyCriterion property() throws RecognitionException {
        PropertyCriterion criterion = null;


        Token key=null;
        Token value=null;

        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:31:48: (key= TEXT '=' value= TEXT )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:32:5: key= TEXT '=' value= TEXT
            {
            key=(Token)match(input,TEXT,FOLLOW_TEXT_in_property115); 

            match(input,17,FOLLOW_17_in_property117); 

            value=(Token)match(input,TEXT,FOLLOW_TEXT_in_property122); 


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
    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:36:1: notNull returns [NotNullCriterion criterion] : key= TEXT '!=' NULL ;
    public final NotNullCriterion notNull() throws RecognitionException {
        NotNullCriterion criterion = null;


        Token key=null;

        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:36:46: (key= TEXT '!=' NULL )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:36:48: key= TEXT '!=' NULL
            {
            key=(Token)match(input,TEXT,FOLLOW_TEXT_in_notNull138); 

            match(input,13,FOLLOW_13_in_notNull140); 

            match(input,NULL,FOLLOW_NULL_in_notNull142); 


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
    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:40:1: or returns [OrCriterion orCriterion] : 'or' '(' e= criterion ( ',' e= criterion )* ')' ;
    public final OrCriterion or() throws RecognitionException {
        OrCriterion orCriterion = null;


        Query e =null;


        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:40:38: ( 'or' '(' e= criterion ( ',' e= criterion )* ')' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:41:5: 'or' '(' e= criterion ( ',' e= criterion )* ')'
            {
            match(input,19,FOLLOW_19_in_or160); 

            match(input,14,FOLLOW_14_in_or162); 

             orCriterion = new OrCriterion(); 

            pushFollow(FOLLOW_criterion_in_or173);
            e=criterion();

            state._fsp--;


             orCriterion.add(e); 

            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:43:6: ( ',' e= criterion )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:43:8: ',' e= criterion
            	    {
            	    match(input,16,FOLLOW_16_in_or184); 

            	    pushFollow(FOLLOW_criterion_in_or188);
            	    e=criterion();

            	    state._fsp--;


            	     orCriterion.add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,15,FOLLOW_15_in_or196); 

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



    // $ANTLR start "and"
    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:45:1: and returns [AndCriterion andCriterion] : 'and' '(' e= criterion ( ',' e= criterion )* ')' ;
    public final AndCriterion and() throws RecognitionException {
        AndCriterion andCriterion = null;


        Query e =null;


        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:45:41: ( 'and' '(' e= criterion ( ',' e= criterion )* ')' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:46:5: 'and' '(' e= criterion ( ',' e= criterion )* ')'
            {
            match(input,18,FOLLOW_18_in_and213); 

            match(input,14,FOLLOW_14_in_and215); 

             andCriterion = new AndCriterion(); 

            pushFollow(FOLLOW_criterion_in_and225);
            e=criterion();

            state._fsp--;


             andCriterion.add(e); 

            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:48:5: ( ',' e= criterion )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:48:7: ',' e= criterion
            	    {
            	    match(input,16,FOLLOW_16_in_and235); 

            	    pushFollow(FOLLOW_criterion_in_and239);
            	    e=criterion();

            	    state._fsp--;


            	     andCriterion.add(e); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,15,FOLLOW_15_in_and247); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return andCriterion;
    }
    // $ANTLR end "and"

    // Delegated rules


 

    public static final BitSet FOLLOW_criterion_in_parse37 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_in_criterion58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_in_criterion70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notNull_in_criterion82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_criterion94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_property115 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_property117 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_TEXT_in_property122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_notNull138 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_notNull140 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NULL_in_notNull142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_or160 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_or162 = new BitSet(new long[]{0x00000000000C0800L});
    public static final BitSet FOLLOW_criterion_in_or173 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_or184 = new BitSet(new long[]{0x00000000000C0800L});
    public static final BitSet FOLLOW_criterion_in_or188 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_or196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_and213 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_and215 = new BitSet(new long[]{0x00000000000C0800L});
    public static final BitSet FOLLOW_criterion_in_and225 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_and235 = new BitSet(new long[]{0x00000000000C0800L});
    public static final BitSet FOLLOW_criterion_in_and239 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_and247 = new BitSet(new long[]{0x0000000000000002L});

}