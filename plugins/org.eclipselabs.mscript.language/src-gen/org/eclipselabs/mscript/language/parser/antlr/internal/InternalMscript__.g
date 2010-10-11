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
T17 : 'type' ;
T18 : '=' ;
T19 : ';' ;
T20 : 'var' ;
T21 : 'const' ;
T22 : ':' ;
T23 : 'record' ;
T24 : 'func' ;
T25 : '(' ;
T26 : ')' ;
T27 : 'pre' ;
T28 : 'check' ;
T29 : 'ref' ;
T30 : 'if' ;
T31 : 'elseif' ;
T32 : 'else' ;
T33 : 'while' ;
T34 : 'do' ;
T35 : 'foreach' ;
T36 : 'in' ;
T37 : 'return' ;
T38 : 'real' ;
T39 : '[' ;
T40 : ']' ;
T41 : 'int' ;
T42 : 'complex' ;
T43 : 'gauss' ;
T44 : 'bool' ;
T45 : 'string' ;
T46 : '?' ;
T47 : '..' ;
T48 : 'unit' ;
T49 : 'then' ;
T50 : 'or' ;
T51 : 'and' ;
T52 : 'not' ;
T53 : 'is' ;
T54 : '-' ;
T55 : '.' ;
T56 : 'j' ;
T57 : '::' ;
T58 : 'begin' ;
T59 : 'end' ;
T60 : 'eval' ;
T61 : '/' ;
T62 : '*' ;
T63 : '^' ;
T64 : 'info' ;
T65 : 'warning' ;
T66 : 'error' ;
T67 : 'fatal' ;
T68 : '<' ;
T69 : '<=' ;
T70 : '>' ;
T71 : '>=' ;
T72 : '==' ;
T73 : '!=' ;
T74 : '+' ;
T75 : '.*' ;
T76 : './' ;
T77 : '.^' ;
T78 : 'false' ;
T79 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6744
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6746
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6748
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6750
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6752
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6754
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6756
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6758
RULE_ANY_OTHER : .;


