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
T29 : 'real' ;
T30 : 'int' ;
T31 : 'complex' ;
T32 : 'gauss' ;
T33 : 'bool' ;
T34 : 'string' ;
T35 : 'then' ;
T36 : ':' ;
T37 : 'or' ;
T38 : 'and' ;
T39 : 'not' ;
T40 : '-' ;
T41 : 'j' ;
T42 : '::' ;
T43 : '[' ;
T44 : ']' ;
T45 : '.' ;
T46 : 'begin' ;
T47 : 'end' ;
T48 : '/' ;
T49 : '*' ;
T50 : '^' ;
T51 : '<' ;
T52 : '<=' ;
T53 : '>' ;
T54 : '>=' ;
T55 : '==' ;
T56 : '<>' ;
T57 : '+' ;
T58 : '.*' ;
T59 : './' ;
T60 : '.^' ;
T61 : 'false' ;
T62 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4985
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4987
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4989
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4991
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4993
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4995
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4997
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4999
RULE_ANY_OTHER : .;


