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
T21 : ':' ;
T22 : 'auto' ;
T23 : 'const' ;
T24 : 'record' ;
T25 : 'func' ;
T26 : '(' ;
T27 : ')' ;
T28 : 'pre' ;
T29 : 'check' ;
T30 : 'ref' ;
T31 : 'if' ;
T32 : 'elseif' ;
T33 : 'else' ;
T34 : 'while' ;
T35 : 'do' ;
T36 : 'foreach' ;
T37 : 'in' ;
T38 : 'return' ;
T39 : 'real' ;
T40 : '[' ;
T41 : ']' ;
T42 : 'int' ;
T43 : 'complex' ;
T44 : 'gauss' ;
T45 : 'bool' ;
T46 : 'string' ;
T47 : '?' ;
T48 : '..' ;
T49 : 'unit' ;
T50 : 'then' ;
T51 : 'or' ;
T52 : 'and' ;
T53 : 'not' ;
T54 : 'is' ;
T55 : '-' ;
T56 : '.' ;
T57 : 'j' ;
T58 : '::' ;
T59 : 'begin' ;
T60 : 'end' ;
T61 : 'eval' ;
T62 : '/' ;
T63 : '*' ;
T64 : '^' ;
T65 : 'info' ;
T66 : 'warning' ;
T67 : 'error' ;
T68 : 'fatal' ;
T69 : '<' ;
T70 : '<=' ;
T71 : '>' ;
T72 : '>=' ;
T73 : '==' ;
T74 : '!=' ;
T75 : '+' ;
T76 : '.*' ;
T77 : './' ;
T78 : '.^' ;
T79 : 'false' ;
T80 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6780
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6782
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6784
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6786
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6788
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6790
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6792
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6794
RULE_ANY_OTHER : .;


