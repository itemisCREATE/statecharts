package org.yakindu.sct.statechart.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionsLexer extends Lexer {
    public static final int RULE_ID=8;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_BOOL=4;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int EOF=-1;
    public static final int T24=24;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_INT=5;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int RULE_FLOAT=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int T42=42;
    public static final int Tokens=43;
    public static final int T41=41;
    public static final int T40=40;
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_STRING=6;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int RULE_WS=11;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    public InternalExpressionsLexer() {;} 
    public InternalExpressionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g"; }

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:10:5: ( '+' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:10:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:11:5: ( '-' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:11:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:12:5: ( '*' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:12:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:13:5: ( '/' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:13:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:14:5: ( '%' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:14:7: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:15:5: ( '~' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:15:7: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:16:5: ( '<' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:16:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:17:5: ( '<=' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:17:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:18:5: ( '>' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:18:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:19:5: ( '>=' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:19:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:20:5: ( '==' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:20:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:21:5: ( '!=' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:21:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:22:5: ( 'int' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:22:7: 'int'
            {
            match("int"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:23:5: ( 'float' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:23:7: 'float'
            {
            match("float"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:24:5: ( 'boolean' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:24:7: 'boolean'
            {
            match("boolean"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:25:5: ( 'entry:' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:25:7: 'entry:'
            {
            match("entry:"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:26:5: ( 'exit:' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:26:7: 'exit:'
            {
            match("exit:"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:27:5: ( 'do:' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:27:7: 'do:'
            {
            match("do:"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:28:5: ( ',' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:28:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:29:5: ( '[' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:29:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:30:5: ( ']' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:30:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:31:5: ( 'var' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:31:7: 'var'
            {
            match("var"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:32:5: ( '=' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:32:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:33:5: ( 'event' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:33:7: 'event'
            {
            match("event"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:34:5: ( 'raise' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:34:7: 'raise'
            {
            match("raise"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:35:5: ( '||' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:35:7: '||'
            {
            match("||"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:36:5: ( '&&' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:36:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:37:5: ( '!' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:37:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:38:5: ( '(' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:38:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:39:5: ( ')' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:39:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start RULE_BOOL
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3940:11: ( ( 'true' | 'false' ) )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3940:13: ( 'true' | 'false' )
            {
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3940:13: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3940:13: ( 'true' | 'false' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3940:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3940:21: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BOOL

    // $ANTLR start RULE_FLOAT
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3942:12: ( ( '-' | '+' )? RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3942:14: ( '-' | '+' )? RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )?
            {
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3942:14: ( '-' | '+' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3942:47: ( 'e' ( '-' | '+' ) RULE_INT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='e') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3942:48: 'e' ( '-' | '+' ) RULE_INT
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    mRULE_INT(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_FLOAT

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3944:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3944:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3944:11: ( '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='^') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3944:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3944:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3946:10: ( ( '0' .. '9' )+ )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3946:12: ( '0' .. '9' )+
            {
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3946:12: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3946:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3948:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFE')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFE')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3948:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3950:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3950:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3950:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFE')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3950:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:41: ( '\\r' )? '\\n'
                    {
                    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3952:41: '\\r'
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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3954:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3954:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3954:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3956:16: ( . )
            // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:3956:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:8: ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | RULE_BOOL | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=39;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:10: T13
                {
                mT13(); 

                }
                break;
            case 2 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:14: T14
                {
                mT14(); 

                }
                break;
            case 3 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:18: T15
                {
                mT15(); 

                }
                break;
            case 4 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:22: T16
                {
                mT16(); 

                }
                break;
            case 5 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:26: T17
                {
                mT17(); 

                }
                break;
            case 6 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:30: T18
                {
                mT18(); 

                }
                break;
            case 7 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:34: T19
                {
                mT19(); 

                }
                break;
            case 8 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:38: T20
                {
                mT20(); 

                }
                break;
            case 9 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:42: T21
                {
                mT21(); 

                }
                break;
            case 10 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:46: T22
                {
                mT22(); 

                }
                break;
            case 11 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:50: T23
                {
                mT23(); 

                }
                break;
            case 12 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:54: T24
                {
                mT24(); 

                }
                break;
            case 13 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:58: T25
                {
                mT25(); 

                }
                break;
            case 14 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:62: T26
                {
                mT26(); 

                }
                break;
            case 15 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:66: T27
                {
                mT27(); 

                }
                break;
            case 16 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:70: T28
                {
                mT28(); 

                }
                break;
            case 17 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:74: T29
                {
                mT29(); 

                }
                break;
            case 18 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:78: T30
                {
                mT30(); 

                }
                break;
            case 19 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:82: T31
                {
                mT31(); 

                }
                break;
            case 20 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:86: T32
                {
                mT32(); 

                }
                break;
            case 21 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:90: T33
                {
                mT33(); 

                }
                break;
            case 22 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:94: T34
                {
                mT34(); 

                }
                break;
            case 23 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:98: T35
                {
                mT35(); 

                }
                break;
            case 24 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:102: T36
                {
                mT36(); 

                }
                break;
            case 25 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:106: T37
                {
                mT37(); 

                }
                break;
            case 26 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:110: T38
                {
                mT38(); 

                }
                break;
            case 27 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:114: T39
                {
                mT39(); 

                }
                break;
            case 28 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:118: T40
                {
                mT40(); 

                }
                break;
            case 29 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:122: T41
                {
                mT41(); 

                }
                break;
            case 30 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:126: T42
                {
                mT42(); 

                }
                break;
            case 31 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:130: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 32 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:140: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 33 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:151: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 34 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:159: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 35 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:168: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 36 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:180: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 37 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:196: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 38 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:212: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 39 :
                // ../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g:1:220: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\1\41\1\43\1\uffff\1\47\2\uffff\1\53\1\55\1\57\1\61\5\63"+
        "\3\uffff\2\63\2\40\2\uffff\1\63\1\105\1\40\1\uffff\2\40\23\uffff"+
        "\1\63\1\uffff\7\63\3\uffff\2\63\4\uffff\1\63\1\uffff\1\105\2\uffff"+
        "\1\124\6\63\1\uffff\1\133\2\63\1\uffff\6\63\1\uffff\1\63\1\145\1"+
        "\146\1\145\1\63\1\uffff\1\63\1\151\1\152\2\uffff\1\63\3\uffff\1"+
        "\154\1\uffff";
    static final String DFA15_eofS =
        "\155\uffff";
    static final String DFA15_minS =
        "\1\0\2\60\1\uffff\1\52\2\uffff\4\75\1\156\1\141\1\157\1\156\1\157"+
        "\3\uffff\2\141\1\174\1\46\2\uffff\1\162\1\56\1\101\1\uffff\2\0\23"+
        "\uffff\1\164\1\uffff\1\157\1\154\1\157\1\151\1\164\1\145\1\72\3"+
        "\uffff\1\162\1\151\4\uffff\1\165\1\uffff\1\56\2\uffff\1\60\1\141"+
        "\1\163\1\154\1\164\1\162\1\156\1\uffff\1\60\1\163\1\145\1\uffff"+
        "\1\164\2\145\1\72\1\171\1\164\1\uffff\1\145\3\60\1\141\1\uffff\1"+
        "\72\2\60\2\uffff\1\156\3\uffff\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\ufffe\2\71\1\uffff\1\57\2\uffff\4\75\1\156\1\154\1\157\1\170"+
        "\1\157\3\uffff\2\141\1\174\1\46\2\uffff\1\162\1\71\1\172\1\uffff"+
        "\2\ufffe\23\uffff\1\164\1\uffff\1\157\1\154\1\157\1\151\1\164\1"+
        "\145\1\72\3\uffff\1\162\1\151\4\uffff\1\165\1\uffff\1\71\2\uffff"+
        "\1\172\1\141\1\163\1\154\1\164\1\162\1\156\1\uffff\1\172\1\163\1"+
        "\145\1\uffff\1\164\2\145\1\72\1\171\1\164\1\uffff\1\145\3\172\1"+
        "\141\1\uffff\1\72\2\172\2\uffff\1\156\3\uffff\1\172\1\uffff";
    static final String DFA15_acceptS =
        "\3\uffff\1\3\1\uffff\1\5\1\6\11\uffff\1\23\1\24\1\25\4\uffff\1\35"+
        "\1\36\3\uffff\1\41\2\uffff\1\46\1\47\1\1\1\40\1\2\1\3\1\45\1\44"+
        "\1\4\1\5\1\6\1\10\1\7\1\12\1\11\1\13\1\27\1\14\1\34\1\uffff\1\41"+
        "\7\uffff\1\23\1\24\1\25\2\uffff\1\32\1\33\1\35\1\36\1\uffff\1\42"+
        "\1\uffff\1\43\1\46\7\uffff\1\22\3\uffff\1\15\6\uffff\1\26\5\uffff"+
        "\1\21\3\uffff\1\37\1\16\1\uffff\1\20\1\30\1\31\1\uffff\1\17";
    static final String DFA15_specialS =
        "\155\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\40\2\37\2\40\1\37\22\40\1\37\1\12\1\35\2\40\1\5\1\26\1\36"+
            "\1\27\1\30\1\3\1\1\1\20\1\2\1\40\1\4\12\32\2\40\1\7\1\11\1\10"+
            "\2\40\32\34\1\21\1\40\1\22\1\33\1\34\1\40\1\34\1\15\1\34\1\17"+
            "\1\16\1\14\2\34\1\13\10\34\1\24\1\34\1\31\1\34\1\23\4\34\1\40"+
            "\1\25\1\40\1\6\uff80\40",
            "\12\42",
            "\12\42",
            "",
            "\1\46\4\uffff\1\45",
            "",
            "",
            "\1\52",
            "\1\54",
            "\1\56",
            "\1\60",
            "\1\62",
            "\1\65\12\uffff\1\64",
            "\1\66",
            "\1\70\7\uffff\1\71\1\uffff\1\67",
            "\1\72",
            "",
            "",
            "",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "",
            "",
            "\1\104",
            "\1\42\1\uffff\12\106",
            "\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\uffff\107",
            "\uffff\107",
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
            "\1\111",
            "",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "",
            "",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            "\1\123",
            "",
            "\1\42\1\uffff\12\106",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\134",
            "\1\135",
            "",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "\1\144",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\147",
            "",
            "\1\150",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\1\153",
            "",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | RULE_BOOL | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}