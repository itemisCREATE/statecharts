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
T35 : 'for' ;
T36 : 'foreach' ;
T37 : 'in' ;
T38 : 'switch' ;
T39 : 'default' ;
T40 : 'case' ;
T41 : 'continue' ;
T42 : 'break' ;
T43 : 'return' ;
T44 : 'real' ;
T45 : '[' ;
T46 : ']' ;
T47 : 'int' ;
T48 : 'complex' ;
T49 : 'gauss' ;
T50 : 'bool' ;
T51 : 'string' ;
T52 : '?' ;
T53 : 'unit' ;
T54 : '||' ;
T55 : '&&' ;
T56 : 'is' ;
T57 : '.' ;
T58 : 'j' ;
T59 : '::' ;
T60 : 'begin' ;
T61 : 'end' ;
T62 : 'eval' ;
T63 : '/' ;
T64 : '*' ;
T65 : '^' ;
T66 : '-' ;
T67 : 'info' ;
T68 : 'warning' ;
T69 : 'error' ;
T70 : 'fatal' ;
T71 : '+=' ;
T72 : '-=' ;
T73 : '*=' ;
T74 : '/=' ;
T75 : '==' ;
T76 : '!=' ;
T77 : '<' ;
T78 : '<=' ;
T79 : '>' ;
T80 : '>=' ;
T81 : '+' ;
T82 : '.*' ;
T83 : './' ;
T84 : '.^' ;
T85 : '!' ;
T86 : '++' ;
T87 : '--' ;
T88 : 'false' ;
T89 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7530
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7532
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7534
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7536
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7538
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7540
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7542
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 7544
RULE_ANY_OTHER : .;


