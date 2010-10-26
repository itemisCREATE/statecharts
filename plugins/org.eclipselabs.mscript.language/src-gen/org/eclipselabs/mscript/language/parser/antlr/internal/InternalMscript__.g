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
T27 : '->' ;
T28 : 'assert' ;
T29 : 'var' ;
T30 : 'functor' ;
T31 : 'real' ;
T32 : '[' ;
T33 : ']' ;
T34 : 'int' ;
T35 : 'complex' ;
T36 : 'gauss' ;
T37 : 'bool' ;
T38 : 'string' ;
T39 : '?' ;
T40 : 'unit' ;
T41 : 'if' ;
T42 : 'then' ;
T43 : 'else' ;
T44 : 'switch' ;
T45 : 'default' ;
T46 : 'case' ;
T47 : '=>' ;
T48 : '||' ;
T49 : '&&' ;
T50 : 'is' ;
T51 : 'j' ;
T52 : '.' ;
T53 : '|' ;
T54 : 'begin' ;
T55 : 'end' ;
T56 : 'eval' ;
T57 : '/' ;
T58 : '*' ;
T59 : '^' ;
T60 : '-' ;
T61 : 'info' ;
T62 : 'warning' ;
T63 : 'error' ;
T64 : 'fatal' ;
T65 : '==' ;
T66 : '!=' ;
T67 : '<=' ;
T68 : '>=' ;
T69 : '+' ;
T70 : '.*' ;
T71 : './' ;
T72 : '.^' ;
T73 : '!' ;
T74 : '\'' ;
T75 : 'false' ;
T76 : 'true' ;

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


