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
T22 : 'func' ;
T23 : '<' ;
T24 : '>' ;
T25 : '(' ;
T26 : ')' ;
T27 : 'assert' ;
T28 : 'var' ;
T29 : 'functor' ;
T30 : 'real' ;
T31 : '[' ;
T32 : ']' ;
T33 : 'int' ;
T34 : 'complex' ;
T35 : 'gauss' ;
T36 : 'bool' ;
T37 : 'string' ;
T38 : '?' ;
T39 : 'unit' ;
T40 : 'if' ;
T41 : 'then' ;
T42 : 'else' ;
T43 : 'switch' ;
T44 : 'default' ;
T45 : 'case' ;
T46 : '=>' ;
T47 : '||' ;
T48 : '&&' ;
T49 : 'is' ;
T50 : 'j' ;
T51 : '.' ;
T52 : '|' ;
T53 : 'begin' ;
T54 : 'end' ;
T55 : 'eval' ;
T56 : '/' ;
T57 : '*' ;
T58 : '^' ;
T59 : '-' ;
T60 : 'info' ;
T61 : 'warning' ;
T62 : 'error' ;
T63 : 'fatal' ;
T64 : '==' ;
T65 : '!=' ;
T66 : '<=' ;
T67 : '>=' ;
T68 : '+' ;
T69 : '.*' ;
T70 : './' ;
T71 : '.^' ;
T72 : '!' ;
T73 : '\'' ;
T74 : 'false' ;
T75 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6529
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6531
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6533
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6535
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6537
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6539
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6541
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6543
RULE_ANY_OTHER : .;


