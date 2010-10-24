lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '\'' ;
T13 : 'unit' ;
T14 : 'j' ;
T15 : 'info' ;
T16 : 'warning' ;
T17 : 'error' ;
T18 : 'fatal' ;
T19 : '==' ;
T20 : '!=' ;
T21 : '<' ;
T22 : '<=' ;
T23 : '>' ;
T24 : '>=' ;
T25 : '+' ;
T26 : '-' ;
T27 : '*' ;
T28 : '/' ;
T29 : '.*' ;
T30 : './' ;
T31 : '^' ;
T32 : '.^' ;
T33 : '!' ;
T34 : 'false' ;
T35 : 'true' ;
T36 : 'namespace' ;
T37 : '{' ;
T38 : '}' ;
T39 : 'enum' ;
T40 : ',' ;
T41 : 'type' ;
T42 : '=' ;
T43 : ';' ;
T44 : 'record' ;
T45 : ':' ;
T46 : 'func' ;
T47 : '(' ;
T48 : ')' ;
T49 : 'assert' ;
T50 : 'var' ;
T51 : 'functor' ;
T52 : 'real' ;
T53 : '[' ;
T54 : ']' ;
T55 : 'int' ;
T56 : 'complex' ;
T57 : 'gauss' ;
T58 : 'bool' ;
T59 : 'string' ;
T60 : 'if' ;
T61 : 'then' ;
T62 : 'else' ;
T63 : 'switch' ;
T64 : 'default' ;
T65 : 'case' ;
T66 : '=>' ;
T67 : '||' ;
T68 : '&&' ;
T69 : '.' ;
T70 : '|' ;
T71 : 'begin' ;
T72 : 'end' ;
T73 : 'eval' ;
T74 : '?' ;
T75 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15796
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15798
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15800
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15802
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15804
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15806
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15808
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15810
RULE_ANY_OTHER : .;


