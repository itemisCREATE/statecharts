lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'package' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'enum' ;
T16 : ',' ;
T17 : '(' ;
T18 : ')' ;
T19 : 'ref' ;
T20 : '=' ;
T21 : ';' ;
T22 : 'if' ;
T23 : 'elseif' ;
T24 : 'else' ;
T25 : 'while' ;
T26 : 'do' ;
T27 : 'foreach' ;
T28 : 'in' ;
T29 : 'return' ;
T30 : 'real' ;
T31 : 'int' ;
T32 : 'complex' ;
T33 : 'gauss' ;
T34 : 'bool' ;
T35 : 'string' ;
T36 : 'then' ;
T37 : ':' ;
T38 : 'or' ;
T39 : 'and' ;
T40 : 'not' ;
T41 : '-' ;
T42 : 'j' ;
T43 : '::' ;
T44 : '[' ;
T45 : ']' ;
T46 : '.' ;
T47 : 'begin' ;
T48 : 'end' ;
T49 : '/' ;
T50 : '*' ;
T51 : '^' ;
T52 : '<' ;
T53 : '<=' ;
T54 : '>' ;
T55 : '>=' ;
T56 : '==' ;
T57 : '<>' ;
T58 : '+' ;
T59 : '.*' ;
T60 : './' ;
T61 : '.^' ;
T62 : 'false' ;
T63 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5097
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5099
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5101
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5103
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5105
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5107
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5109
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5111
RULE_ANY_OTHER : .;


