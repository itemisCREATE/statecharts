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
T23 : 'exec' ;
T24 : '=' ;
T25 : 'if' ;
T26 : 'elseif' ;
T27 : 'else' ;
T28 : 'while' ;
T29 : 'do' ;
T30 : 'foreach' ;
T31 : 'in' ;
T32 : 'const' ;
T33 : 'return' ;
T34 : 'real' ;
T35 : 'int' ;
T36 : 'complex' ;
T37 : 'gauss' ;
T38 : 'bool' ;
T39 : 'string' ;
T40 : 'unit' ;
T41 : 'then' ;
T42 : ':' ;
T43 : 'or' ;
T44 : 'and' ;
T45 : 'not' ;
T46 : 'is' ;
T47 : '-' ;
T48 : '.' ;
T49 : '[' ;
T50 : ']' ;
T51 : 'j' ;
T52 : '::' ;
T53 : 'begin' ;
T54 : 'end' ;
T55 : '?' ;
T56 : 'eval' ;
T57 : '/' ;
T58 : '*' ;
T59 : '^' ;
T60 : '<' ;
T61 : '<=' ;
T62 : '>' ;
T63 : '>=' ;
T64 : '==' ;
T65 : '<>' ;
T66 : '+' ;
T67 : '.*' ;
T68 : './' ;
T69 : '.^' ;
T70 : 'false' ;
T71 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5823
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5825
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5827
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5829
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5831
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5833
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5835
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5837
RULE_ANY_OTHER : .;


