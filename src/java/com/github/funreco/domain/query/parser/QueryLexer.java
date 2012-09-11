// $ANTLR 3.4 C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g 2012-09-11 22:44:13

    package com.github.funreco.domain.query.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int ID=4;
    public static final int NEWLINE=5;
    public static final int NULL=6;
    public static final int WS=7;

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
    public String getGrammarFileName() { return "C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:6:6: ( '!=' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:6:8: '!='
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
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:7:6: ( ')' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:7:8: ')'
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:8:7: ( ',' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:8:9: ','
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:9:7: ( '=' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:9:9: '='
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:10:7: ( 'or(' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:10:9: 'or('
            {
            match("or("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:42:6: ( 'null' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:42:9: 'null'
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:43:5: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:43:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:43:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:44:8: ( ( '\\r' )? '\\n' )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:44:9: ( '\\r' )? '\\n'
            {
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:44:9: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:44:9: '\\r'
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
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:45:5: ( ( ' ' | '\\t' )+ )
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:45:9: ( ' ' | '\\t' )+
            {
            // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:45:9: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
        // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | NULL | ID | NEWLINE | WS )
        int alt4=9;
        switch ( input.LA(1) ) {
        case '!':
            {
            alt4=1;
            }
            break;
        case ')':
            {
            alt4=2;
            }
            break;
        case ',':
            {
            alt4=3;
            }
            break;
        case '=':
            {
            alt4=4;
            }
            break;
        case 'o':
            {
            int LA4_5 = input.LA(2);

            if ( (LA4_5=='r') ) {
                int LA4_10 = input.LA(3);

                if ( (LA4_10=='(') ) {
                    alt4=5;
                }
                else {
                    alt4=7;
                }
            }
            else {
                alt4=7;
            }
            }
            break;
        case 'n':
            {
            int LA4_6 = input.LA(2);

            if ( (LA4_6=='u') ) {
                int LA4_11 = input.LA(3);

                if ( (LA4_11=='l') ) {
                    int LA4_13 = input.LA(4);

                    if ( (LA4_13=='l') ) {
                        int LA4_14 = input.LA(5);

                        if ( ((LA4_14 >= 'A' && LA4_14 <= 'Z')||(LA4_14 >= 'a' && LA4_14 <= 'z')) ) {
                            alt4=7;
                        }
                        else {
                            alt4=6;
                        }
                    }
                    else {
                        alt4=7;
                    }
                }
                else {
                    alt4=7;
                }
            }
            else {
                alt4=7;
            }
            }
            break;
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
            {
            alt4=7;
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=8;
            }
            break;
        case '\t':
        case ' ':
            {
            alt4=9;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:10: T__8
                {
                mT__8(); 


                }
                break;
            case 2 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:15: T__9
                {
                mT__9(); 


                }
                break;
            case 3 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:20: T__10
                {
                mT__10(); 


                }
                break;
            case 4 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:26: T__11
                {
                mT__11(); 


                }
                break;
            case 5 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:32: T__12
                {
                mT__12(); 


                }
                break;
            case 6 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:38: NULL
                {
                mNULL(); 


                }
                break;
            case 7 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:43: ID
                {
                mID(); 


                }
                break;
            case 8 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:46: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 9 :
                // C:\\Users\\devarf\\Documents\\GitHub\\fun-reco\\src\\java\\com\\github\\funreco\\domain\\query\\parser\\Query.g:1:54: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}