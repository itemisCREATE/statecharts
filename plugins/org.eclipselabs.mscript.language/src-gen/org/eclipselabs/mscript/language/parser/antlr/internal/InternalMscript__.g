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
T19 : 'static' ;
T20 : '(' ;
T21 : ')' ;
T22 : 'ref' ;
T23 : '=' ;
T24 : 'if' ;
T25 : 'elseif' ;
T26 : 'else' ;
T27 : 'while' ;
T28 : 'do' ;
T29 : 'foreach' ;
T30 : 'in' ;
T31 : 'auto' ;
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

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5837
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5839
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5841
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5843
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5845
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5847
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5849
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 5851
RULE_ANY_OTHER : .;


