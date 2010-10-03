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
T31 : 'const' ;
T32 : 'return' ;
T33 : 'real' ;
T34 : 'int' ;
T35 : 'complex' ;
T36 : 'gauss' ;
T37 : 'bool' ;
T38 : 'string' ;
T39 : 'unit' ;
T40 : 'then' ;
T41 : ':' ;
T42 : 'or' ;
T43 : 'and' ;
T44 : 'not' ;
T45 : '-' ;
T46 : '.' ;
T47 : '[' ;
T48 : ']' ;
T49 : 'j' ;
T50 : '::' ;
T51 : 'begin' ;
T52 : 'end' ;
T53 : '?' ;
T54 : 'eval' ;
T55 : '/' ;
T56 : '*' ;
T57 : '^' ;
T58 : '<' ;
T59 : '<=' ;
T60 : '>' ;
T61 : '>=' ;
T62 : '==' ;
T63 : '<>' ;
T64 : '+' ;
T65 : '.*' ;
T66 : './' ;
T67 : '.^' ;
T68 : 'false' ;
T69 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5658
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5660
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5662
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5664
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5666
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5668
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5670
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5672
RULE_ANY_OTHER : .;


