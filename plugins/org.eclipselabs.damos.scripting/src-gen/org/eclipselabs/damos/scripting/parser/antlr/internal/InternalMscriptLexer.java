package org.eclipselabs.damos.scripting.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMscriptLexer extends Lexer {
    public static final int RULE_ANY_OTHER=11;
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
    public static final int T38=38;
    public static final int RULE_REAL=5;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T43=43;
    public static final int Tokens=55;
    public static final int RULE_SL_COMMENT=9;
    public static final int T42=42;
    public static final int T41=41;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int T45=45;
    public static final int RULE_ML_COMMENT=8;
    public static final int T44=44;
    public static final int RULE_STRING=7;
    public static final int T50=50;
    public static final int RULE_IDENT=4;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T52=52;
    public static final int T15=15;
    public static final int RULE_WS=10;
    public static final int T51=51;
    public static final int T16=16;
    public static final int T54=54;
    public static final int T17=17;
    public static final int T53=53;
    public static final int T18=18;
    public static final int T19=19;
    public static final int RULE_INTEGER=6;
    public InternalMscriptLexer() {;} 
    public InternalMscriptLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:10:5: ( 'package' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:10:7: 'package'
            {
            match("package"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:11:5: ( '{' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:11:7: '{'
            {
            match('{'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:12:5: ( '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:12:7: '}'
            {
            match('}'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:13:5: ( 'enumeration' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:13:7: 'enumeration'
            {
            match("enumeration"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:14:5: ( ',' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:14:7: ','
            {
            match(','); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:15:5: ( 'if' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:15:7: 'if'
            {
            match("if"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:16:5: ( 'elseif' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:16:7: 'elseif'
            {
            match("elseif"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:17:5: ( 'else' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:17:7: 'else'
            {
            match("else"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:18:5: ( 'then' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:18:7: 'then'
            {
            match("then"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:19:5: ( ':' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:19:7: ':'
            {
            match(':'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:20:5: ( 'or' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:20:7: 'or'
            {
            match("or"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:21:5: ( 'and' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:21:7: 'and'
            {
            match("and"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:22:5: ( 'not' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:22:7: 'not'
            {
            match("not"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:23:5: ( '-' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:23:7: '-'
            {
            match('-'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:24:5: ( '(' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:24:7: '('
            {
            match('('); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:25:5: ( ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:25:7: ')'
            {
            match(')'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:26:5: ( '::' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:26:7: '::'
            {
            match("::"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:27:5: ( 'der' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:27:7: 'der'
            {
            match("der"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:28:5: ( 'initial' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:28:7: 'initial'
            {
            match("initial"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:29:5: ( '=' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:29:7: '='
            {
            match('='); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:30:5: ( '.' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:30:7: '.'
            {
            match('.'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:31:5: ( '[' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:31:7: '['
            {
            match('['); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:32:5: ( ']' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:32:7: ']'
            {
            match(']'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:33:5: ( ';' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:33:7: ';'
            {
            match(';'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:34:5: ( 'begin' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:34:7: 'begin'
            {
            match("begin"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:35:5: ( 'end' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:35:7: 'end'
            {
            match("end"); 


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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:36:5: ( '/' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:36:7: '/'
            {
            match('/'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:37:5: ( '*' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:37:7: '*'
            {
            match('*'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:38:5: ( '^' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:38:7: '^'
            {
            match('^'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:39:5: ( '<' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:39:7: '<'
            {
            match('<'); 

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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:40:5: ( '<=' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:40:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:41:5: ( '>' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:41:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:42:5: ( '>=' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:42:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:43:5: ( '==' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:43:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:44:5: ( '<>' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:44:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:45:5: ( '+' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:45:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:46:5: ( '.+' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:46:7: '.+'
            {
            match(".+"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:47:5: ( '.-' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:47:7: '.-'
            {
            match(".-"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:48:5: ( '.*' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:48:7: '.*'
            {
            match(".*"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:49:5: ( './' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:49:7: './'
            {
            match("./"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:50:5: ( '.^' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:50:7: '.^'
            {
            match(".^"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:51:5: ( 'false' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:51:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:52:5: ( 'true' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:52:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start RULE_IDENT
    public final void mRULE_IDENT() throws RecognitionException {
        try {
            int _type = RULE_IDENT;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3695:12: ( ( '_' | 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | '_' | 'a' .. 'z' | 'A' .. 'Z' )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3695:14: ( '_' | 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | '_' | 'a' .. 'z' | 'A' .. 'Z' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3695:38: ( '0' .. '9' | '_' | 'a' .. 'z' | 'A' .. 'Z' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:
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
            	    break loop1;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_IDENT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3697:13: ( '\"' (~ ( ( '\\\\' | '\"' ) ) | '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' ) )* '\"' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3697:15: '\"' (~ ( ( '\\\\' | '\"' ) ) | '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3697:19: (~ ( ( '\\\\' | '\"' ) ) | '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }
                else if ( (LA2_0=='\\') ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3697:20: ~ ( ( '\\\\' | '\"' ) )
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
            	case 2 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3697:34: '\\\\' ( '\\'' | '\"' | '?' | '\\\\' | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='?'||input.LA(1)=='\\'||(input.LA(1)>='a' && input.LA(1)<='b')||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t'||input.LA(1)=='v' ) {
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
            	    break loop2;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_REAL
    public final void mRULE_REAL() throws RecognitionException {
        try {
            int _type = RULE_REAL;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:11: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:13: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:13: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

            match('.'); 
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:29: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:30: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:41: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:42: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:52: ( '+' | '-' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='+'||LA5_0=='-') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:63: ( '0' .. '9' )+
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
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3699:64: '0' .. '9'
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
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_REAL

    // $ANTLR start RULE_INTEGER
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3701:14: ( ( '0' .. '9' )+ )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3701:16: ( '0' .. '9' )+
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3701:16: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3701:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INTEGER

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3703:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3703:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3703:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3703:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop10;
                }
            } while (true);

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3705:41: '\\r'
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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3707:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3707:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3707:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3709:16: ( . )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3709:18: .
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
        // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_IDENT | RULE_STRING | RULE_REAL | RULE_INTEGER | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=51;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:102: T35
                {
                mT35(); 

                }
                break;
            case 25 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:106: T36
                {
                mT36(); 

                }
                break;
            case 26 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:110: T37
                {
                mT37(); 

                }
                break;
            case 27 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:114: T38
                {
                mT38(); 

                }
                break;
            case 28 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:118: T39
                {
                mT39(); 

                }
                break;
            case 29 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:122: T40
                {
                mT40(); 

                }
                break;
            case 30 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:126: T41
                {
                mT41(); 

                }
                break;
            case 31 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:130: T42
                {
                mT42(); 

                }
                break;
            case 32 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:134: T43
                {
                mT43(); 

                }
                break;
            case 33 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:138: T44
                {
                mT44(); 

                }
                break;
            case 34 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:142: T45
                {
                mT45(); 

                }
                break;
            case 35 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:146: T46
                {
                mT46(); 

                }
                break;
            case 36 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:150: T47
                {
                mT47(); 

                }
                break;
            case 37 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:154: T48
                {
                mT48(); 

                }
                break;
            case 38 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:158: T49
                {
                mT49(); 

                }
                break;
            case 39 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:162: T50
                {
                mT50(); 

                }
                break;
            case 40 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:166: T51
                {
                mT51(); 

                }
                break;
            case 41 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:170: T52
                {
                mT52(); 

                }
                break;
            case 42 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:174: T53
                {
                mT53(); 

                }
                break;
            case 43 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:178: T54
                {
                mT54(); 

                }
                break;
            case 44 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:182: RULE_IDENT
                {
                mRULE_IDENT(); 

                }
                break;
            case 45 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:193: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 46 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:205: RULE_REAL
                {
                mRULE_REAL(); 

                }
                break;
            case 47 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:215: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 48 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:228: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 49 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:244: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 50 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:260: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 51 :
                // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1:268: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\43\2\uffff\1\43\1\uffff\2\43\1\56\3\43\3\uffff\1\43\1"+
        "\67\1\75\3\uffff\1\43\1\104\2\uffff\1\111\1\113\1\uffff\1\43\1\uffff"+
        "\1\41\1\117\2\uffff\1\43\3\uffff\2\43\1\uffff\1\127\3\43\2\uffff"+
        "\1\133\2\43\3\uffff\1\43\13\uffff\1\43\13\uffff\1\43\2\uffff\1\117"+
        "\2\uffff\2\43\1\143\1\43\1\uffff\3\43\1\uffff\1\150\1\151\1\152"+
        "\3\43\1\157\1\uffff\2\43\1\162\1\163\3\uffff\4\43\1\uffff\2\43\2"+
        "\uffff\1\172\1\173\1\43\1\175\2\43\2\uffff\1\u0080\1\uffff\1\43"+
        "\1\u0082\1\uffff\1\43\1\uffff\2\43\1\u0086\1\uffff";
    static final String DFA14_eofS =
        "\u0087\uffff";
    static final String DFA14_minS =
        "\1\0\1\141\2\uffff\1\154\1\uffff\1\146\1\150\1\72\1\162\1\156\1"+
        "\157\3\uffff\1\145\1\75\1\52\3\uffff\1\145\1\52\2\uffff\2\75\1\uffff"+
        "\1\141\1\uffff\1\0\1\56\2\uffff\1\143\3\uffff\1\163\1\144\1\uffff"+
        "\1\60\1\151\1\145\1\165\2\uffff\1\60\1\144\1\164\3\uffff\1\162\13"+
        "\uffff\1\147\13\uffff\1\154\2\uffff\1\56\2\uffff\1\153\1\145\1\60"+
        "\1\155\1\uffff\1\164\1\156\1\145\1\uffff\3\60\1\151\1\163\1\141"+
        "\1\60\1\uffff\1\145\1\151\2\60\3\uffff\1\156\1\145\1\147\1\146\1"+
        "\uffff\1\162\1\141\2\uffff\2\60\1\145\1\60\1\141\1\154\2\uffff\1"+
        "\60\1\uffff\1\164\1\60\1\uffff\1\151\1\uffff\1\157\1\156\1\60\1"+
        "\uffff";
    static final String DFA14_maxS =
        "\1\ufffe\1\141\2\uffff\1\156\1\uffff\1\156\1\162\1\72\1\162\1\156"+
        "\1\157\3\uffff\1\145\1\75\1\136\3\uffff\1\145\1\57\2\uffff\1\76"+
        "\1\75\1\uffff\1\141\1\uffff\1\ufffe\1\71\2\uffff\1\143\3\uffff\1"+
        "\163\1\165\1\uffff\1\172\1\151\1\145\1\165\2\uffff\1\172\1\144\1"+
        "\164\3\uffff\1\162\13\uffff\1\147\13\uffff\1\154\2\uffff\1\71\2"+
        "\uffff\1\153\1\145\1\172\1\155\1\uffff\1\164\1\156\1\145\1\uffff"+
        "\3\172\1\151\1\163\1\141\1\172\1\uffff\1\145\1\151\2\172\3\uffff"+
        "\1\156\1\145\1\147\1\146\1\uffff\1\162\1\141\2\uffff\2\172\1\145"+
        "\1\172\1\141\1\154\2\uffff\1\172\1\uffff\1\164\1\172\1\uffff\1\151"+
        "\1\uffff\1\157\1\156\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\5\6\uffff\1\16\1\17\1\20\3\uffff\1\26"+
        "\1\27\1\30\2\uffff\1\34\1\35\2\uffff\1\44\1\uffff\1\54\2\uffff\1"+
        "\62\1\63\1\uffff\1\54\1\2\1\3\2\uffff\1\5\4\uffff\1\21\1\12\3\uffff"+
        "\1\16\1\17\1\20\1\uffff\1\42\1\24\1\50\1\51\1\46\1\47\1\45\1\25"+
        "\1\26\1\27\1\30\1\uffff\1\61\1\60\1\33\1\34\1\35\1\37\1\43\1\36"+
        "\1\41\1\40\1\44\1\uffff\1\55\1\57\1\uffff\1\56\1\62\4\uffff\1\6"+
        "\3\uffff\1\13\7\uffff\1\32\4\uffff\1\14\1\15\1\22\4\uffff\1\10\2"+
        "\uffff\1\11\1\53\6\uffff\1\31\1\52\1\uffff\1\7\2\uffff\1\1\1\uffff"+
        "\1\23\3\uffff\1\4";
    static final String DFA14_specialS =
        "\u0087\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\41\2\40\2\41\1\40\22\41\1\40\1\41\1\36\5\41\1\15\1\16\1"+
            "\27\1\33\1\5\1\14\1\21\1\26\12\37\1\10\1\24\1\31\1\20\1\32\2"+
            "\41\32\35\1\22\1\41\1\23\1\30\1\35\1\41\1\12\1\25\1\35\1\17"+
            "\1\4\1\34\2\35\1\6\4\35\1\13\1\11\1\1\3\35\1\7\6\35\1\2\1\41"+
            "\1\3\uff81\41",
            "\1\42",
            "",
            "",
            "\1\46\1\uffff\1\47",
            "",
            "\1\51\7\uffff\1\52",
            "\1\53\11\uffff\1\54",
            "\1\55",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\73\1\74\1\uffff\1\72\1\uffff\1\70\56\uffff\1\71",
            "",
            "",
            "",
            "\1\101",
            "\1\103\4\uffff\1\102",
            "",
            "",
            "\1\107\1\110",
            "\1\112",
            "",
            "\1\115",
            "",
            "\uffff\116",
            "\1\121\1\uffff\12\120",
            "",
            "",
            "\1\123",
            "",
            "",
            "",
            "\1\124",
            "\1\125\20\uffff\1\126",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\130",
            "\1\131",
            "\1\132",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\134",
            "\1\135",
            "",
            "",
            "",
            "\1\136",
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
            "\1\137",
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
            "\1\140",
            "",
            "",
            "\1\121\1\uffff\12\120",
            "",
            "",
            "\1\141",
            "\1\142",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\144",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\153",
            "\1\154",
            "\1\155",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\10\43\1\156\21\43",
            "",
            "\1\160",
            "\1\161",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\1\170",
            "\1\171",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\174",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\176",
            "\1\177",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u0081",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u0083",
            "",
            "\1\u0084",
            "\1\u0085",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_IDENT | RULE_STRING | RULE_REAL | RULE_INTEGER | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}