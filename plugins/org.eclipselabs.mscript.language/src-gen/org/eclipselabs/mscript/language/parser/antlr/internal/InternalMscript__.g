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
T50 : '||' ;
T51 : '&&' ;
T52 : 'is' ;
T53 : '.' ;
T54 : 'j' ;
T55 : '::' ;
T56 : 'begin' ;
T57 : 'end' ;
T58 : 'eval' ;
T59 : '/' ;
T60 : '*' ;
T61 : '^' ;
T62 : '-' ;
T63 : 'info' ;
T64 : 'warning' ;
T65 : 'error' ;
T66 : 'fatal' ;
T67 : '<' ;
T68 : '<=' ;
T69 : '>' ;
T70 : '>=' ;
T71 : '==' ;
T72 : '!=' ;
T73 : '+' ;
T74 : '.*' ;
T75 : './' ;
T76 : '.^' ;
T77 : '!' ;
T78 : 'false' ;
T79 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6745
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6747
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6749
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6751
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6753
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6755
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6757
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 6759
RULE_ANY_OTHER : .;


