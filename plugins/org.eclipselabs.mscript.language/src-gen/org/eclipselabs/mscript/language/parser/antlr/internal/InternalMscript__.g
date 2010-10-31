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
T41 : 'let' ;
T42 : 'in' ;
T43 : 'if' ;
T44 : 'then' ;
T45 : 'else' ;
T46 : 'switch' ;
T47 : 'default' ;
T48 : 'case' ;
T49 : '=>' ;
T50 : '||' ;
T51 : '&&' ;
T52 : 'is' ;
T53 : '.' ;
T54 : 'unit' ;
T55 : '|' ;
T56 : 'for' ;
T57 : 'begin' ;
T58 : 'end' ;
T59 : '/' ;
T60 : '*' ;
T61 : '^' ;
T62 : '-' ;
T63 : 'info' ;
T64 : 'warning' ;
T65 : 'error' ;
T66 : 'fatal' ;
T67 : '==' ;
T68 : '!=' ;
T69 : '<=' ;
T70 : '>=' ;
T71 : '+' ;
T72 : '.*' ;
T73 : './' ;
T74 : '.^' ;
T75 : '!' ;
T76 : '\'' ;
T77 : 'false' ;
T78 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6972
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6974
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6976
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6978
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6980
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6982
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6984
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6986
RULE_ANY_OTHER : .;


