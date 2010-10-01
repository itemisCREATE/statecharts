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
T15 : 'enumeration' ;
T16 : ',' ;
T17 : '(' ;
T18 : ')' ;
T19 : '=' ;
T20 : ';' ;
T21 : 'if' ;
T22 : 'elseif' ;
T23 : 'else' ;
T24 : 'while' ;
T25 : 'real' ;
T26 : 'integer' ;
T27 : 'complex' ;
T28 : 'gaussian' ;
T29 : 'boolean' ;
T30 : 'string' ;
T31 : 'then' ;
T32 : ':' ;
T33 : 'or' ;
T34 : 'and' ;
T35 : 'not' ;
T36 : '-' ;
T37 : 'j' ;
T38 : '::' ;
T39 : '[' ;
T40 : ']' ;
T41 : '.' ;
T42 : 'begin' ;
T43 : 'end' ;
T44 : '/' ;
T45 : '*' ;
T46 : '^' ;
T47 : '<' ;
T48 : '<=' ;
T49 : '>' ;
T50 : '>=' ;
T51 : '==' ;
T52 : '<>' ;
T53 : '+' ;
T54 : '.*' ;
T55 : './' ;
T56 : '.^' ;
T57 : 'false' ;
T58 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4758
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4760
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4762
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4764
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4766
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4768
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4770
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4772
RULE_ANY_OTHER : .;


