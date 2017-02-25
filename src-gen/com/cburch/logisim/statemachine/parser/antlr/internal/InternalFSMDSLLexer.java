package com.cburch.logisim.statemachine.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFSMDSLLexer extends Lexer {
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_BIN=6;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalFSMDSLLexer() {;} 
    public InternalFSMDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalFSMDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:11:7: ( '[' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:11:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:12:7: ( ',' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:12:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:13:7: ( ']' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:13:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:14:7: ( ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:14:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:15:7: ( 'fsm' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:15:9: 'fsm'
            {
            match("fsm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:16:7: ( '{' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:16:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:17:7: ( 'codeWidth' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:17:9: 'codeWidth'
            {
            match("codeWidth"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:18:7: ( '=' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:18:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:19:7: ( 'reset' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:19:9: 'reset'
            {
            match("reset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:20:7: ( '}' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:20:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:21:7: ( 'in' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:21:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:22:7: ( 'out' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:22:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:23:7: ( 'commands' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:23:9: 'commands'
            {
            match("commands"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:24:7: ( '@[' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:24:9: '@['
            {
            match("@["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:25:7: ( 'state' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:25:9: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:26:7: ( 'code' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:26:9: 'code'
            {
            match("code"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:27:7: ( 'transitions' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:27:9: 'transitions'
            {
            match("transitions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:28:7: ( '->' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:28:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:29:7: ( 'goto' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:29:9: 'goto'
            {
            match("goto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:30:7: ( 'when' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:30:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:31:7: ( ':' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:31:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:32:7: ( 'default' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:32:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:33:7: ( '+' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:33:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:34:7: ( '.' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:34:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:35:7: ( '==' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:35:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:36:7: ( '/=' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:36:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:37:7: ( '(' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:37:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:38:7: ( ')' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:38:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:39:7: ( '/' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:39:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "RULE_BIN"
    public final void mRULE_BIN() throws RecognitionException {
        try {
            int _type = RULE_BIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2039:10: ( '\"' ( '0' | '1' )+ '\"' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2039:12: '\"' ( '0' | '1' )+ '\"'
            {
            match('\"'); 
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2039:16: ( '0' | '1' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='1')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIN"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2043:10: ( ( '0' .. '9' )+ )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2043:12: ( '0' .. '9' )+
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2043:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2043:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2045:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2047:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2047:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2047:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2047:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:41: ( '\\r' )? '\\n'
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2049:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2051:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2051:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2051:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2053:16: ( . )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2053:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | RULE_BIN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=37;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:184: RULE_BIN
                {
                mRULE_BIN(); 

                }
                break;
            case 31 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:193: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 32 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:201: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 33 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:210: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 34 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:222: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 35 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:238: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 36 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:254: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 37 :
                // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1:262: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\5\uffff\1\46\1\uffff\1\46\1\52\1\46\1\uffff\2\46\1\40\2\46\1\40\2\46\1\uffff\1\46\2\uffff\1\74\2\uffff\2\40\2\uffff\1\40\6\uffff\1\46\2\uffff\1\46\2\uffff\1\46\1\uffff\1\107\1\46\1\uffff\2\46\1\uffff\2\46\1\uffff\1\46\14\uffff\1\117\3\46\1\uffff\1\123\5\46\2\uffff\1\133\2\46\1\uffff\2\46\1\140\1\141\1\46\1\uffff\1\46\1\uffff\1\46\1\145\1\146\1\46\2\uffff\3\46\2\uffff\5\46\1\160\1\46\1\162\1\46\1\uffff\1\164\1\uffff\1\46\1\uffff\1\46\1\167\1\uffff";
    static final String DFA13_eofS =
        "\170\uffff";
    static final String DFA13_minS =
        "\1\0\4\uffff\1\163\1\uffff\1\157\1\75\1\145\1\uffff\1\156\1\165\1\133\1\164\1\162\1\76\1\157\1\150\1\uffff\1\145\2\uffff\1\52\2\uffff\1\0\1\101\2\uffff\1\0\6\uffff\1\155\2\uffff\1\144\2\uffff\1\163\1\uffff\1\60\1\164\1\uffff\2\141\1\uffff\1\164\1\145\1\uffff\1\146\11\uffff\1\0\2\uffff\1\60\1\145\1\155\1\145\1\uffff\1\60\1\164\1\156\1\157\1\156\1\141\2\uffff\1\60\1\141\1\164\1\uffff\1\145\1\163\2\60\1\165\1\uffff\1\151\1\uffff\1\156\2\60\1\151\2\uffff\1\154\2\144\2\uffff\3\164\1\163\1\151\1\60\1\150\1\60\1\157\1\uffff\1\60\1\uffff\1\156\1\uffff\1\163\1\60\1\uffff";
    static final String DFA13_maxS =
        "\1\uffff\4\uffff\1\163\1\uffff\1\157\1\75\1\145\1\uffff\1\156\1\165\1\133\1\164\1\162\1\76\1\157\1\150\1\uffff\1\145\2\uffff\1\75\2\uffff\1\uffff\1\172\2\uffff\1\uffff\6\uffff\1\155\2\uffff\1\155\2\uffff\1\163\1\uffff\1\172\1\164\1\uffff\2\141\1\uffff\1\164\1\145\1\uffff\1\146\11\uffff\1\uffff\2\uffff\1\172\1\145\1\155\1\145\1\uffff\1\172\1\164\1\156\1\157\1\156\1\141\2\uffff\1\172\1\141\1\164\1\uffff\1\145\1\163\2\172\1\165\1\uffff\1\151\1\uffff\1\156\2\172\1\151\2\uffff\1\154\2\144\2\uffff\3\164\1\163\1\151\1\172\1\150\1\172\1\157\1\uffff\1\172\1\uffff\1\156\1\uffff\1\163\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\3\uffff\1\12\10\uffff\1\25\1\uffff\1\27\1\30\1\uffff\1\33\1\34\2\uffff\1\37\1\40\1\uffff\1\44\1\45\1\1\1\2\1\3\1\4\1\uffff\1\37\1\6\1\uffff\1\31\1\10\1\uffff\1\12\2\uffff\1\16\2\uffff\1\22\2\uffff\1\25\1\uffff\1\27\1\30\1\32\1\42\1\43\1\35\1\33\1\34\1\41\1\uffff\1\40\1\44\4\uffff\1\13\6\uffff\1\36\1\5\3\uffff\1\14\5\uffff\1\36\1\uffff\1\20\4\uffff\1\23\1\24\3\uffff\1\11\1\17\11\uffff\1\26\1\uffff\1\15\1\uffff\1\7\2\uffff\1\21";
    static final String DFA13_specialS =
        "\1\2\31\uffff\1\3\3\uffff\1\1\41\uffff\1\0\67\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\40\2\37\2\40\1\37\22\40\1\37\1\40\1\32\4\40\1\36\1\30\1\31\1\40\1\25\1\2\1\20\1\26\1\27\12\35\1\23\1\4\1\40\1\10\2\40\1\15\32\34\1\1\1\40\1\3\1\33\1\34\1\40\2\34\1\7\1\24\1\34\1\5\1\21\1\34\1\13\5\34\1\14\2\34\1\11\1\16\1\17\2\34\1\22\3\34\1\6\1\40\1\12\uff82\40",
            "",
            "",
            "",
            "",
            "\1\45",
            "",
            "\1\50",
            "\1\51",
            "\1\53",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "\1\66",
            "",
            "",
            "\1\72\4\uffff\1\73\15\uffff\1\71",
            "",
            "",
            "\60\77\2\100\uffce\77",
            "\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\0\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\103",
            "",
            "",
            "\1\104\10\uffff\1\105",
            "",
            "",
            "\1\106",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\110",
            "",
            "\1\111",
            "\1\112",
            "",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\42\77\1\116\15\77\2\100\uffce\77",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "",
            "\12\46\7\uffff\26\46\1\132\3\46\4\uffff\1\46\1\uffff\32\46",
            "\1\134",
            "\1\135",
            "",
            "\1\136",
            "\1\137",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\142",
            "",
            "\1\143",
            "",
            "\1\144",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\147",
            "",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "",
            "",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\161",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\163",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\165",
            "",
            "\1\166",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | RULE_BIN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_64 = input.LA(1);

                        s = -1;
                        if ( (LA13_64=='\"') ) {s = 78;}

                        else if ( ((LA13_64>='\u0000' && LA13_64<='!')||(LA13_64>='#' && LA13_64<='/')||(LA13_64>='2' && LA13_64<='\uFFFF')) ) {s = 63;}

                        else if ( ((LA13_64>='0' && LA13_64<='1')) ) {s = 64;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_30 = input.LA(1);

                        s = -1;
                        if ( ((LA13_30>='\u0000' && LA13_30<='\uFFFF')) ) {s = 63;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='[') ) {s = 1;}

                        else if ( (LA13_0==',') ) {s = 2;}

                        else if ( (LA13_0==']') ) {s = 3;}

                        else if ( (LA13_0==';') ) {s = 4;}

                        else if ( (LA13_0=='f') ) {s = 5;}

                        else if ( (LA13_0=='{') ) {s = 6;}

                        else if ( (LA13_0=='c') ) {s = 7;}

                        else if ( (LA13_0=='=') ) {s = 8;}

                        else if ( (LA13_0=='r') ) {s = 9;}

                        else if ( (LA13_0=='}') ) {s = 10;}

                        else if ( (LA13_0=='i') ) {s = 11;}

                        else if ( (LA13_0=='o') ) {s = 12;}

                        else if ( (LA13_0=='@') ) {s = 13;}

                        else if ( (LA13_0=='s') ) {s = 14;}

                        else if ( (LA13_0=='t') ) {s = 15;}

                        else if ( (LA13_0=='-') ) {s = 16;}

                        else if ( (LA13_0=='g') ) {s = 17;}

                        else if ( (LA13_0=='w') ) {s = 18;}

                        else if ( (LA13_0==':') ) {s = 19;}

                        else if ( (LA13_0=='d') ) {s = 20;}

                        else if ( (LA13_0=='+') ) {s = 21;}

                        else if ( (LA13_0=='.') ) {s = 22;}

                        else if ( (LA13_0=='/') ) {s = 23;}

                        else if ( (LA13_0=='(') ) {s = 24;}

                        else if ( (LA13_0==')') ) {s = 25;}

                        else if ( (LA13_0=='\"') ) {s = 26;}

                        else if ( (LA13_0=='^') ) {s = 27;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='b')||LA13_0=='e'||LA13_0=='h'||(LA13_0>='j' && LA13_0<='n')||(LA13_0>='p' && LA13_0<='q')||(LA13_0>='u' && LA13_0<='v')||(LA13_0>='x' && LA13_0<='z')) ) {s = 28;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 29;}

                        else if ( (LA13_0=='\'') ) {s = 30;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 31;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||LA13_0=='*'||LA13_0=='<'||(LA13_0>='>' && LA13_0<='?')||LA13_0=='\\'||LA13_0=='`'||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {s = 32;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA13_26 = input.LA(1);

                        s = -1;
                        if ( ((LA13_26>='\u0000' && LA13_26<='/')||(LA13_26>='2' && LA13_26<='\uFFFF')) ) {s = 63;}

                        else if ( ((LA13_26>='0' && LA13_26<='1')) ) {s = 64;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}