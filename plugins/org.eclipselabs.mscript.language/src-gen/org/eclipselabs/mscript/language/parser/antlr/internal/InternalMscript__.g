lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'namespace' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'enum' ;
T16 : ',' ;
T17 : 'type' ;
T18 : '=' ;
T19 : ';' ;
T20 : 'record' ;
T21 : ':' ;
T22 : 'stateful' ;
T23 : 'func' ;
T24 : '<' ;
T25 : '>' ;
T26 : '(' ;
T27 : ')' ;
T28 : '->' ;
T29 : 'static' ;
T30 : 'assert' ;
T31 : 'var' ;
T32 : 'functor' ;
T33 : 'real' ;
T34 : '[' ;
T35 : ']' ;
T36 : 'int' ;
T37 : 'complex' ;
T38 : 'gauss' ;
T39 : 'bool' ;
T40 : 'string' ;
T41 : '?' ;
T42 : 'let' ;
T43 : 'in' ;
T44 : 'if' ;
T45 : 'then' ;
T46 : 'else' ;
T47 : 'switch' ;
T48 : 'default' ;
T49 : 'case' ;
T50 : '=>' ;
T51 : '||' ;
T52 : '&&' ;
T53 : 'is' ;
T54 : 'j' ;
T55 : '.' ;
T56 : 'unit' ;
T57 : '|' ;
T58 : 'begin' ;
T59 : 'end' ;
T60 : 'eval' ;
T61 : '/' ;
T62 : '*' ;
T63 : '^' ;
T64 : '-' ;
T65 : 'info' ;
T66 : 'warning' ;
T67 : 'error' ;
T68 : 'fatal' ;
T69 : '==' ;
T70 : '!=' ;
T71 : '<=' ;
T72 : '>=' ;
T73 : '+' ;
T74 : '.*' ;
T75 : './' ;
T76 : '.^' ;
T77 : '!' ;
T78 : '\'' ;
T79 : 'false' ;
T80 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6723
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6725
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6727
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6729
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6731
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6733
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6735
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6737
RULE_ANY_OTHER : .;


