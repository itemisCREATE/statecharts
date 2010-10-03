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
T17 : 'record' ;
T18 : ';' ;
T19 : '(' ;
T20 : ')' ;
T21 : 'ref' ;
T22 : 'check' ;
T23 : '=' ;
T24 : 'if' ;
T25 : 'elseif' ;
T26 : 'else' ;
T27 : 'while' ;
T28 : 'do' ;
T29 : 'foreach' ;
T30 : 'in' ;
T31 : 'return' ;
T32 : 'real' ;
T33 : 'int' ;
T34 : 'complex' ;
T35 : 'gauss' ;
T36 : 'bool' ;
T37 : 'string' ;
T38 : 'unit' ;
T39 : 'then' ;
T40 : ':' ;
T41 : 'or' ;
T42 : 'and' ;
T43 : 'not' ;
T44 : '-' ;
T45 : 'j' ;
T46 : '::' ;
T47 : '[' ;
T48 : ']' ;
T49 : '.' ;
T50 : 'begin' ;
T51 : 'end' ;
T52 : '?' ;
T53 : 'eval' ;
T54 : '/' ;
T55 : '*' ;
T56 : '^' ;
T57 : '<' ;
T58 : '<=' ;
T59 : '>' ;
T60 : '>=' ;
T61 : '==' ;
T62 : '<>' ;
T63 : '+' ;
T64 : '.*' ;
T65 : './' ;
T66 : '.^' ;
T67 : 'false' ;
T68 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5577
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5579
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5581
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5583
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5585
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5587
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5589
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5591
RULE_ANY_OTHER : .;


