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
T33 : 'typedef' ;
T34 : 'as' ;
T35 : 'return' ;
T36 : 'real' ;
T37 : '[' ;
T38 : ']' ;
T39 : 'int' ;
T40 : 'complex' ;
T41 : 'gauss' ;
T42 : 'bool' ;
T43 : 'string' ;
T44 : 'type' ;
T45 : '?' ;
T46 : '..' ;
T47 : 'unit' ;
T48 : 'then' ;
T49 : ':' ;
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
T64 : '<' ;
T65 : '<=' ;
T66 : '>' ;
T67 : '>=' ;
T68 : '==' ;
T69 : '<>' ;
T70 : '+' ;
T71 : '.*' ;
T72 : './' ;
T73 : '.^' ;
T74 : 'false' ;
T75 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6570
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6572
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6574
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6576
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6578
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6580
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6582
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6584
RULE_ANY_OTHER : .;


