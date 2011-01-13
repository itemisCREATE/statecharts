lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '\'' ;
T13 : 'info' ;
T14 : 'warning' ;
T15 : 'error' ;
T16 : 'fatal' ;
T17 : '==' ;
T18 : '!=' ;
T19 : '<' ;
T20 : '<=' ;
T21 : '>' ;
T22 : '>=' ;
T23 : '+' ;
T24 : '-' ;
T25 : '*' ;
T26 : '/' ;
T27 : '.*' ;
T28 : './' ;
T29 : '^' ;
T30 : '.^' ;
T31 : '!' ;
T32 : 'false' ;
T33 : 'true' ;
T34 : 'enum' ;
T35 : '{' ;
T36 : '}' ;
T37 : ',' ;
T38 : 'type' ;
T39 : '=' ;
T40 : ';' ;
T41 : 'record' ;
T42 : ':' ;
T43 : 'func' ;
T44 : '(' ;
T45 : ')' ;
T46 : '->' ;
T47 : 'assert' ;
T48 : 'var' ;
T49 : 'functor' ;
T50 : 'real' ;
T51 : '[' ;
T52 : ']' ;
T53 : 'int' ;
T54 : 'complex' ;
T55 : 'gauss' ;
T56 : 'bool' ;
T57 : 'string' ;
T58 : 'let' ;
T59 : 'in' ;
T60 : 'if' ;
T61 : 'then' ;
T62 : 'else' ;
T63 : 'switch' ;
T64 : 'default' ;
T65 : 'case' ;
T66 : '=>' ;
T67 : '||' ;
T68 : '&&' ;
T69 : 'is' ;
T70 : '.' ;
T71 : '|' ;
T72 : 'for' ;
T73 : '$' ;
T74 : 'begin' ;
T75 : 'end' ;
T76 : 'stateful' ;
T77 : 'static' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17000
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17002
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17004
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17006
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17008
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17010
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17012
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 17014
RULE_ANY_OTHER : .;


