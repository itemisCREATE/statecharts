lexer grammar InternalMscript;
@header {
package org.eclipselabs.damos.scripting.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : 'package' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'enumeration' ;
T16 : ',' ;
T17 : 'Real' ;
T18 : '(' ;
T19 : ')' ;
T20 : 'Integer' ;
T21 : 'Boolean' ;
T22 : 'String' ;
T23 : 'if' ;
T24 : 'elseif' ;
T25 : 'else' ;
T26 : 'then' ;
T27 : ':' ;
T28 : 'or' ;
T29 : 'and' ;
T30 : 'not' ;
T31 : '-' ;
T32 : '::' ;
T33 : '=' ;
T34 : '[' ;
T35 : ']' ;
T36 : '.' ;
T37 : ';' ;
T38 : 'begin' ;
T39 : 'end' ;
T40 : '/' ;
T41 : '*' ;
T42 : '^' ;
T43 : '<' ;
T44 : '<=' ;
T45 : '>' ;
T46 : '>=' ;
T47 : '==' ;
T48 : '<>' ;
T49 : '+' ;
T50 : '.+' ;
T51 : '.-' ;
T52 : '.*' ;
T53 : './' ;
T54 : '.^' ;
T55 : 'false' ;
T56 : 'true' ;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3820
RULE_IDENT : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3822
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3824
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3826
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3828
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3830
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3832
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3834
RULE_ANY_OTHER : .;


