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
T32 : 'var' ;
T33 : 'auto' ;
T34 : 'const' ;
T35 : 'type' ;
T36 : 'return' ;
T37 : 'real' ;
T38 : '[' ;
T39 : ']' ;
T40 : 'int' ;
T41 : 'complex' ;
T42 : 'gauss' ;
T43 : 'bool' ;
T44 : 'string' ;
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
T69 : '!=' ;
T70 : '+' ;
T71 : '.*' ;
T72 : './' ;
T73 : '.^' ;
T74 : 'false' ;
T75 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6566
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6568
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6570
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6572
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6574
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6576
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6578
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6580
RULE_ANY_OTHER : .;


