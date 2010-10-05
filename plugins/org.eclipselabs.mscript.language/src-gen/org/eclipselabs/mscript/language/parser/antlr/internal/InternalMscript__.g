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
T20 : 'func' ;
T21 : '(' ;
T22 : ')' ;
T23 : 'ref' ;
T24 : '=' ;
T25 : 'if' ;
T26 : 'elseif' ;
T27 : 'else' ;
T28 : 'while' ;
T29 : 'do' ;
T30 : 'foreach' ;
T31 : 'in' ;
T32 : 'auto' ;
T33 : 'const' ;
T34 : 'typedef' ;
T35 : 'as' ;
T36 : 'return' ;
T37 : 'real' ;
T38 : '[' ;
T39 : ']' ;
T40 : 'int' ;
T41 : 'complex' ;
T42 : 'gauss' ;
T43 : 'bool' ;
T44 : 'string' ;
T45 : 'type' ;
T46 : '?' ;
T47 : '..' ;
T48 : 'unit' ;
T49 : 'then' ;
T50 : ':' ;
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
T65 : '<' ;
T66 : '<=' ;
T67 : '>' ;
T68 : '>=' ;
T69 : '==' ;
T70 : '!=' ;
T71 : '+' ;
T72 : '.*' ;
T73 : './' ;
T74 : '.^' ;
T75 : 'false' ;
T76 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6516
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6518
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6520
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6522
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6524
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6526
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6528
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6530
RULE_ANY_OTHER : .;


