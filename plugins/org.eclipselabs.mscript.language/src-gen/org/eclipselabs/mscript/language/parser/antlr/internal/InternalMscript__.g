lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'enum' ;
T13 : '{' ;
T14 : ',' ;
T15 : '}' ;
T16 : 'type' ;
T17 : '=' ;
T18 : ';' ;
T19 : 'record' ;
T20 : ':' ;
T21 : 'stateful' ;
T22 : 'func' ;
T23 : '<' ;
T24 : '>' ;
T25 : '(' ;
T26 : ')' ;
T27 : '->' ;
T28 : 'static' ;
T29 : 'assert' ;
T30 : 'var' ;
T31 : 'functor' ;
T32 : 'real' ;
T33 : '[' ;
T34 : ']' ;
T35 : 'int' ;
T36 : 'complex' ;
T37 : 'gauss' ;
T38 : 'bool' ;
T39 : 'string' ;
T40 : 'let' ;
T41 : 'in' ;
T42 : 'if' ;
T43 : 'then' ;
T44 : 'else' ;
T45 : 'switch' ;
T46 : 'default' ;
T47 : 'case' ;
T48 : '=>' ;
T49 : '||' ;
T50 : '&&' ;
T51 : 'is' ;
T52 : '.' ;
T53 : '|' ;
T54 : 'for' ;
T55 : '$' ;
T56 : 'begin' ;
T57 : 'end' ;
T58 : '/' ;
T59 : '*' ;
T60 : '^' ;
T61 : '-' ;
T62 : 'info' ;
T63 : 'warning' ;
T64 : 'error' ;
T65 : 'fatal' ;
T66 : '==' ;
T67 : '!=' ;
T68 : '<=' ;
T69 : '>=' ;
T70 : '+' ;
T71 : '.*' ;
T72 : './' ;
T73 : '.^' ;
T74 : '!' ;
T75 : '\'' ;
T76 : 'false' ;
T77 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6898
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6900
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6902
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6904
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6906
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6908
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6910
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6912
RULE_ANY_OTHER : .;


