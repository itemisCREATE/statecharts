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
T17 : 'real' ;
T18 : '(' ;
T19 : ')' ;
T20 : 'integer' ;
T21 : 'complex' ;
T22 : 'gaussian' ;
T23 : 'boolean' ;
T24 : 'string' ;
T25 : 'if' ;
T26 : 'elseif' ;
T27 : 'else' ;
T28 : 'then' ;
T29 : ':' ;
T30 : 'or' ;
T31 : 'and' ;
T32 : 'not' ;
T33 : '-' ;
T34 : 'j' ;
T35 : '::' ;
T36 : '=' ;
T37 : '[' ;
T38 : ']' ;
T39 : '.' ;
T40 : ';' ;
T41 : 'begin' ;
T42 : 'end' ;
T43 : '/' ;
T44 : '*' ;
T45 : '^' ;
T46 : '<' ;
T47 : '<=' ;
T48 : '>' ;
T49 : '>=' ;
T50 : '==' ;
T51 : '<>' ;
T52 : '+' ;
T53 : '.*' ;
T54 : './' ;
T55 : '.^' ;
T56 : 'false' ;
T57 : 'true' ;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4035
RULE_IDENT : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4037
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4039
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4041
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4043
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4045
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4047
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g" 4049
RULE_ANY_OTHER : .;


