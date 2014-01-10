package org.yakindu.base.expressions.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionsLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__20=20;
    public static final int RULE_BOOL=5;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_HEX=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_FLOAT=7;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=9;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=12;

    // delegates
    // delegators

    public InternalExpressionsLexer() {;} 
    public InternalExpressionsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExpressionsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:11:7: ( '=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:11:9: '='
            {
            match('='); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:12:7: ( '*=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:12:9: '*='
            {
            match("*="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:13:7: ( '/=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:13:9: '/='
            {
            match("/="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:14:7: ( '%=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:14:9: '%='
            {
            match("%="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:15:7: ( '+=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:15:9: '+='
            {
            match("+="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:16:7: ( '-=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:16:9: '-='
            {
            match("-="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:17:7: ( '<<=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:17:9: '<<='
            {
            match("<<="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:18:7: ( '>>=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:18:9: '>>='
            {
            match(">>="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:19:7: ( '&=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:19:9: '&='
            {
            match("&="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:20:7: ( '^=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:20:9: '^='
            {
            match("^="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:21:7: ( '|=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:21:9: '|='
            {
            match("|="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:22:7: ( '<<' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:22:9: '<<'
            {
            match("<<"); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:23:7: ( '>>' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:23:9: '>>'
            {
            match(">>"); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:24:7: ( '+' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:24:9: '+'
            {
            match('+'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:25:7: ( '-' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:25:9: '-'
            {
            match('-'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:26:7: ( '*' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:26:9: '*'
            {
            match('*'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:27:7: ( '/' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:27:9: '/'
            {
            match('/'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:28:7: ( '%' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:28:9: '%'
            {
            match('%'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:29:7: ( '~' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:29:9: '~'
            {
            match('~'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:30:7: ( '<' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:30:9: '<'
            {
            match('<'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:31:7: ( '<=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:31:9: '<='
            {
            match("<="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:32:7: ( '>' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:32:9: '>'
            {
            match('>'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:33:7: ( '>=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:33:9: '>='
            {
            match(">="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:34:7: ( '==' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:34:9: '=='
            {
            match("=="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:35:7: ( '!=' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:35:9: '!='
            {
            match("!="); 


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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:36:7: ( '?' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:36:9: '?'
            {
            match('?'); 

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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:37:7: ( ':' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:37:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:38:7: ( '||' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:38:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:39:7: ( '&&' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:39:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:40:7: ( '!' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:40:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:41:7: ( '^' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:41:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:42:7: ( '|' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:42:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:43:7: ( '&' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:43:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:44:7: ( '.' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:44:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:45:7: ( ')' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:45:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:46:7: ( ',' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:46:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:47:7: ( '(' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:47:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:11: ( ( 'true' | 'false' | 'yes' | 'no' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:13: ( 'true' | 'false' | 'yes' | 'no' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:13: ( 'true' | 'false' | 'yes' | 'no' )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt1=1;
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            case 'y':
                {
                alt1=3;
                }
                break;
            case 'n':
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:21: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:29: 'yes'
                    {
                    match("yes"); 


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4985:35: 'no'
                    {
                    match("no"); 


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
    // $ANTLR end "RULE_BOOL"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4987:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4987:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4987:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4989:12: ( RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' | 'd' | 'D' )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4989:14: RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' | 'd' | 'D' )?
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4989:36: ( 'e' ( '-' | '+' ) RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='e') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4989:37: 'e' ( '-' | '+' ) RULE_INT
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mRULE_INT(); 

                    }
                    break;

            }

            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4989:62: ( 'f' | 'F' | 'd' | 'D' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='D'||LA4_0=='F'||LA4_0=='d'||LA4_0=='f') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


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
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4991:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4991:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4991:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4991:11: '^'
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

            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4991:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:
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
            	    break loop6;
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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4993:10: ( ( '0' .. '9' )+ )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4993:12: ( '0' .. '9' )+
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4993:12: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4993:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4995:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop9;
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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4997:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4997:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4997:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4997:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop12;
                }
            } while (true);

            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:41: ( '\\r' )? '\\n'
                    {
                    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:4999:41: '\\r'
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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:5001:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:5001:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:5001:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:5003:16: ( . )
            // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:5003:18: .
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
        // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | RULE_BOOL | RULE_HEX | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=47;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:232: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 39 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:242: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 40 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:251: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 41 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:262: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 42 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:270: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 43 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:279: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 44 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:291: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 45 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:307: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 46 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:323: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 47 :
                // ../org.yakindu.base.expressions.ui/src-gen/org/yakindu/base/expressions/ui/contentassist/antlr/internal/InternalExpressions.g:1:331: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\1\40\1\42\1\46\1\50\1\52\1\54\1\57\1\62\1\65\1\67\1\73"+
        "\1\uffff\1\76\6\uffff\4\70\2\112\1\uffff\2\36\20\uffff\1\120\2\uffff"+
        "\1\122\24\uffff\3\70\1\126\3\uffff\1\112\6\uffff\2\70\1\126\1\uffff"+
        "\1\126\1\70\1\126";
    static final String DFA16_eofS =
        "\132\uffff";
    static final String DFA16_minS =
        "\1\0\2\75\1\52\3\75\1\74\1\75\1\46\2\75\1\uffff\1\75\6\uffff\1"+
        "\162\1\141\1\145\1\157\2\56\1\uffff\2\0\20\uffff\1\75\2\uffff\1"+
        "\75\24\uffff\1\165\1\154\1\163\1\60\3\uffff\1\56\6\uffff\1\145\1"+
        "\163\1\60\1\uffff\1\60\1\145\1\60";
    static final String DFA16_maxS =
        "\1\uffff\7\75\1\76\1\75\1\172\1\174\1\uffff\1\75\6\uffff\1\162"+
        "\1\141\1\145\1\157\1\170\1\71\1\uffff\2\uffff\20\uffff\1\75\2\uffff"+
        "\1\75\24\uffff\1\165\1\154\1\163\1\172\3\uffff\1\71\6\uffff\1\145"+
        "\1\163\1\172\1\uffff\1\172\1\145\1\172";
    static final String DFA16_acceptS =
        "\14\uffff\1\23\1\uffff\1\32\1\33\1\42\1\43\1\44\1\45\6\uffff\1"+
        "\51\2\uffff\1\56\1\57\1\30\1\1\1\2\1\20\1\3\1\54\1\55\1\21\1\4\1"+
        "\22\1\5\1\16\1\6\1\17\1\uffff\1\25\1\24\1\uffff\1\27\1\26\1\11\1"+
        "\35\1\41\1\12\1\37\1\51\1\13\1\34\1\40\1\23\1\31\1\36\1\32\1\33"+
        "\1\42\1\43\1\44\1\45\4\uffff\1\47\1\52\1\50\1\uffff\1\53\1\56\1"+
        "\7\1\14\1\10\1\15\3\uffff\1\46\3\uffff";
    static final String DFA16_specialS =
        "\1\2\32\uffff\1\0\1\1\75\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\36\2\35\2\36\1\35\22\36\1\35\1\15\1\33\2\36\1\4\1\11\1"+
            "\34\1\23\1\21\1\2\1\5\1\22\1\6\1\20\1\3\1\30\11\31\1\17\1\36"+
            "\1\7\1\1\1\10\1\16\1\36\32\32\3\36\1\12\1\32\1\36\5\32\1\25"+
            "\7\32\1\27\5\32\1\24\4\32\1\26\1\32\1\36\1\13\1\36\1\14\uff81"+
            "\36",
            "\1\37",
            "\1\41",
            "\1\44\4\uffff\1\45\15\uffff\1\43",
            "\1\47",
            "\1\51",
            "\1\53",
            "\1\55\1\56",
            "\1\61\1\60",
            "\1\64\26\uffff\1\63",
            "\1\66\3\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\71\76\uffff\1\72",
            "",
            "\1\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\113\1\uffff\12\114\36\uffff\1\111\37\uffff\1\111",
            "\1\113\1\uffff\12\114",
            "",
            "\0\115",
            "\0\115",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\117",
            "",
            "",
            "\1\121",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "",
            "\1\113\1\uffff\12\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\127",
            "\1\130",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\131",
            "\12\70\7\uffff\32\70\4\uffff\1\70\1\uffff\32\70"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | RULE_BOOL | RULE_HEX | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_27 = input.LA(1);

                        s = -1;
                        if ( ((LA16_27>='\u0000' && LA16_27<='\uFFFF')) ) {s = 77;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_28 = input.LA(1);

                        s = -1;
                        if ( ((LA16_28>='\u0000' && LA16_28<='\uFFFF')) ) {s = 77;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='=') ) {s = 1;}

                        else if ( (LA16_0=='*') ) {s = 2;}

                        else if ( (LA16_0=='/') ) {s = 3;}

                        else if ( (LA16_0=='%') ) {s = 4;}

                        else if ( (LA16_0=='+') ) {s = 5;}

                        else if ( (LA16_0=='-') ) {s = 6;}

                        else if ( (LA16_0=='<') ) {s = 7;}

                        else if ( (LA16_0=='>') ) {s = 8;}

                        else if ( (LA16_0=='&') ) {s = 9;}

                        else if ( (LA16_0=='^') ) {s = 10;}

                        else if ( (LA16_0=='|') ) {s = 11;}

                        else if ( (LA16_0=='~') ) {s = 12;}

                        else if ( (LA16_0=='!') ) {s = 13;}

                        else if ( (LA16_0=='?') ) {s = 14;}

                        else if ( (LA16_0==':') ) {s = 15;}

                        else if ( (LA16_0=='.') ) {s = 16;}

                        else if ( (LA16_0==')') ) {s = 17;}

                        else if ( (LA16_0==',') ) {s = 18;}

                        else if ( (LA16_0=='(') ) {s = 19;}

                        else if ( (LA16_0=='t') ) {s = 20;}

                        else if ( (LA16_0=='f') ) {s = 21;}

                        else if ( (LA16_0=='y') ) {s = 22;}

                        else if ( (LA16_0=='n') ) {s = 23;}

                        else if ( (LA16_0=='0') ) {s = 24;}

                        else if ( ((LA16_0>='1' && LA16_0<='9')) ) {s = 25;}

                        else if ( ((LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='e')||(LA16_0>='g' && LA16_0<='m')||(LA16_0>='o' && LA16_0<='s')||(LA16_0>='u' && LA16_0<='x')||LA16_0=='z') ) {s = 26;}

                        else if ( (LA16_0=='\"') ) {s = 27;}

                        else if ( (LA16_0=='\'') ) {s = 28;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 29;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||(LA16_0>='#' && LA16_0<='$')||LA16_0==';'||LA16_0=='@'||(LA16_0>='[' && LA16_0<=']')||LA16_0=='`'||LA16_0=='{'||LA16_0=='}'||(LA16_0>='\u007F' && LA16_0<='\uFFFF')) ) {s = 30;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}