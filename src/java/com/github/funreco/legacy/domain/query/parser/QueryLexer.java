// $ANTLR 3.4 /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g 2012-09-12 13:18:57

    package com.github.funreco.legacy.domain.query.parser;


import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QueryLexer() {} 
    public QueryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QueryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:6:7: ( '!=' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:6:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:7:7: ( '(' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:8:7: ( ')' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:8:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:9:7: ( ',' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:9:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:10:7: ( '=' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:10:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:11:7: ( 'and' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:11:9: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:12:7: ( 'or' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:12:9: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:50:6: ( 'null' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:50:9: 'null'
            {
            match("null"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:51:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "ACCENT"
    public final void mACCENT() throws RecognitionException {
        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:52:17: ( '\\u00C0' .. '\\u00D6' | '\\u00D9' .. '\\u00DD' | '\\u00E0' .. '\\u00F6' | '\\u00F9' .. '\\u00FD' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
            {
            if ( (input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D9' && input.LA(1) <= '\u00DD')||(input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F9' && input.LA(1) <= '\u00FD') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACCENT"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:53:16: ( '0' .. '9' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "QUOTE"
    public final void mQUOTE() throws RecognitionException {
        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:54:16: ( '\\'' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:54:18: '\\''
            {
            match('\''); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTE"

    // $ANTLR start "DBL_QUOTE"
    public final void mDBL_QUOTE() throws RecognitionException {
        try {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:55:20: ( '\"' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:55:22: '\"'
            {
            match('\"'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DBL_QUOTE"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:7: ( ( LETTER | DIGIT | ACCENT )+ | ( QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* QUOTE ) | ( DBL_QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* DBL_QUOTE ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
            case '\u00C0':
            case '\u00C1':
            case '\u00C2':
            case '\u00C3':
            case '\u00C4':
            case '\u00C5':
            case '\u00C6':
            case '\u00C7':
            case '\u00C8':
            case '\u00C9':
            case '\u00CA':
            case '\u00CB':
            case '\u00CC':
            case '\u00CD':
            case '\u00CE':
            case '\u00CF':
            case '\u00D0':
            case '\u00D1':
            case '\u00D2':
            case '\u00D3':
            case '\u00D4':
            case '\u00D5':
            case '\u00D6':
            case '\u00D9':
            case '\u00DA':
            case '\u00DB':
            case '\u00DC':
            case '\u00DD':
            case '\u00E0':
            case '\u00E1':
            case '\u00E2':
            case '\u00E3':
            case '\u00E4':
            case '\u00E5':
            case '\u00E6':
            case '\u00E7':
            case '\u00E8':
            case '\u00E9':
            case '\u00EA':
            case '\u00EB':
            case '\u00EC':
            case '\u00ED':
            case '\u00EE':
            case '\u00EF':
            case '\u00F0':
            case '\u00F1':
            case '\u00F2':
            case '\u00F3':
            case '\u00F4':
            case '\u00F5':
            case '\u00F6':
            case '\u00F9':
            case '\u00FA':
            case '\u00FB':
            case '\u00FC':
            case '\u00FD':
                {
                alt4=1;
                }
                break;
            case '\'':
                {
                alt4=2;
                }
                break;
            case '\"':
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:10: ( LETTER | DIGIT | ACCENT )+
                    {
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:10: ( LETTER | DIGIT | ACCENT )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')||(LA1_0 >= '\u00C0' && LA1_0 <= '\u00D6')||(LA1_0 >= '\u00D9' && LA1_0 <= '\u00DD')||(LA1_0 >= '\u00E0' && LA1_0 <= '\u00F6')||(LA1_0 >= '\u00F9' && LA1_0 <= '\u00FD')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D9' && input.LA(1) <= '\u00DD')||(input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F9' && input.LA(1) <= '\u00FD') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:35: ( QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* QUOTE )
                    {
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:35: ( QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* QUOTE )
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:36: QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* QUOTE
                    {
                    mQUOTE(); 


                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:42: ( LETTER | DIGIT | ACCENT | ' ' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==' '||(LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')||(LA2_0 >= '\u00C0' && LA2_0 <= '\u00D6')||(LA2_0 >= '\u00D9' && LA2_0 <= '\u00DD')||(LA2_0 >= '\u00E0' && LA2_0 <= '\u00F6')||(LA2_0 >= '\u00F9' && LA2_0 <= '\u00FD')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
                    	    {
                    	    if ( input.LA(1)==' '||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D9' && input.LA(1) <= '\u00DD')||(input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F9' && input.LA(1) <= '\u00FD') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    mQUOTE(); 


                    }


                    }
                    break;
                case 3 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:78: ( DBL_QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* DBL_QUOTE )
                    {
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:78: ( DBL_QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* DBL_QUOTE )
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:79: DBL_QUOTE ( LETTER | DIGIT | ACCENT | ' ' )* DBL_QUOTE
                    {
                    mDBL_QUOTE(); 


                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:56:89: ( LETTER | DIGIT | ACCENT | ' ' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==' '||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')||(LA3_0 >= '\u00C0' && LA3_0 <= '\u00D6')||(LA3_0 >= '\u00D9' && LA3_0 <= '\u00DD')||(LA3_0 >= '\u00E0' && LA3_0 <= '\u00F6')||(LA3_0 >= '\u00F9' && LA3_0 <= '\u00FD')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
                    	    {
                    	    if ( input.LA(1)==' '||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D9' && input.LA(1) <= '\u00DD')||(input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F9' && input.LA(1) <= '\u00FD') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    mDBL_QUOTE(); 


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:57:8: ( ( '\\r' )? '\\n' )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:57:9: ( '\\r' )? '\\n'
            {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:57:9: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:57:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:58:5: ( ( ' ' | '\\t' )+ )
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:58:9: ( ' ' | '\\t' )+
            {
            // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:58:9: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | NULL | TEXT | NEWLINE | WS )
        int alt7=11;
        switch ( input.LA(1) ) {
        case '!':
            {
            alt7=1;
            }
            break;
        case '(':
            {
            alt7=2;
            }
            break;
        case ')':
            {
            alt7=3;
            }
            break;
        case ',':
            {
            alt7=4;
            }
            break;
        case '=':
            {
            alt7=5;
            }
            break;
        case 'a':
            {
            int LA7_6 = input.LA(2);

            if ( (LA7_6=='n') ) {
                int LA7_12 = input.LA(3);

                if ( (LA7_12=='d') ) {
                    int LA7_15 = input.LA(4);

                    if ( ((LA7_15 >= '0' && LA7_15 <= '9')||(LA7_15 >= 'A' && LA7_15 <= 'Z')||(LA7_15 >= 'a' && LA7_15 <= 'z')||(LA7_15 >= '\u00C0' && LA7_15 <= '\u00D6')||(LA7_15 >= '\u00D9' && LA7_15 <= '\u00DD')||(LA7_15 >= '\u00E0' && LA7_15 <= '\u00F6')||(LA7_15 >= '\u00F9' && LA7_15 <= '\u00FD')) ) {
                        alt7=9;
                    }
                    else {
                        alt7=6;
                    }
                }
                else {
                    alt7=9;
                }
            }
            else {
                alt7=9;
            }
            }
            break;
        case 'o':
            {
            int LA7_7 = input.LA(2);

            if ( (LA7_7=='r') ) {
                int LA7_13 = input.LA(3);

                if ( ((LA7_13 >= '0' && LA7_13 <= '9')||(LA7_13 >= 'A' && LA7_13 <= 'Z')||(LA7_13 >= 'a' && LA7_13 <= 'z')||(LA7_13 >= '\u00C0' && LA7_13 <= '\u00D6')||(LA7_13 >= '\u00D9' && LA7_13 <= '\u00DD')||(LA7_13 >= '\u00E0' && LA7_13 <= '\u00F6')||(LA7_13 >= '\u00F9' && LA7_13 <= '\u00FD')) ) {
                    alt7=9;
                }
                else {
                    alt7=7;
                }
            }
            else {
                alt7=9;
            }
            }
            break;
        case 'n':
            {
            int LA7_8 = input.LA(2);

            if ( (LA7_8=='u') ) {
                int LA7_14 = input.LA(3);

                if ( (LA7_14=='l') ) {
                    int LA7_17 = input.LA(4);

                    if ( (LA7_17=='l') ) {
                        int LA7_19 = input.LA(5);

                        if ( ((LA7_19 >= '0' && LA7_19 <= '9')||(LA7_19 >= 'A' && LA7_19 <= 'Z')||(LA7_19 >= 'a' && LA7_19 <= 'z')||(LA7_19 >= '\u00C0' && LA7_19 <= '\u00D6')||(LA7_19 >= '\u00D9' && LA7_19 <= '\u00DD')||(LA7_19 >= '\u00E0' && LA7_19 <= '\u00F6')||(LA7_19 >= '\u00F9' && LA7_19 <= '\u00FD')) ) {
                            alt7=9;
                        }
                        else {
                            alt7=8;
                        }
                    }
                    else {
                        alt7=9;
                    }
                }
                else {
                    alt7=9;
                }
            }
            else {
                alt7=9;
            }
            }
            break;
        case '\"':
        case '\'':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
        case '\u00C0':
        case '\u00C1':
        case '\u00C2':
        case '\u00C3':
        case '\u00C4':
        case '\u00C5':
        case '\u00C6':
        case '\u00C7':
        case '\u00C8':
        case '\u00C9':
        case '\u00CA':
        case '\u00CB':
        case '\u00CC':
        case '\u00CD':
        case '\u00CE':
        case '\u00CF':
        case '\u00D0':
        case '\u00D1':
        case '\u00D2':
        case '\u00D3':
        case '\u00D4':
        case '\u00D5':
        case '\u00D6':
        case '\u00D9':
        case '\u00DA':
        case '\u00DB':
        case '\u00DC':
        case '\u00DD':
        case '\u00E0':
        case '\u00E1':
        case '\u00E2':
        case '\u00E3':
        case '\u00E4':
        case '\u00E5':
        case '\u00E6':
        case '\u00E7':
        case '\u00E8':
        case '\u00E9':
        case '\u00EA':
        case '\u00EB':
        case '\u00EC':
        case '\u00ED':
        case '\u00EE':
        case '\u00EF':
        case '\u00F0':
        case '\u00F1':
        case '\u00F2':
        case '\u00F3':
        case '\u00F4':
        case '\u00F5':
        case '\u00F6':
        case '\u00F9':
        case '\u00FA':
        case '\u00FB':
        case '\u00FC':
        case '\u00FD':
            {
            alt7=9;
            }
            break;
        case '\n':
        case '\r':
            {
            alt7=10;
            }
            break;
        case '\t':
        case ' ':
            {
            alt7=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;

        }

        switch (alt7) {
            case 1 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:34: T__17
                {
                mT__17(); 


                }
                break;
            case 6 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:40: T__18
                {
                mT__18(); 


                }
                break;
            case 7 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:46: T__19
                {
                mT__19(); 


                }
                break;
            case 8 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:52: NULL
                {
                mNULL(); 


                }
                break;
            case 9 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:57: TEXT
                {
                mTEXT(); 


                }
                break;
            case 10 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:62: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 11 :
                // /Users/bourdette/projects-git/webportals-repositories/src/main/java/fr/rtlgroup/rtlnet/webportals/repositories/community/facebook/domain/query/parser/Query.g:1:70: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}