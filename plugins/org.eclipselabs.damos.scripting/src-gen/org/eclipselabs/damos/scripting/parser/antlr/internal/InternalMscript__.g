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
T17 : 'if' ;
T18 : 'elseif' ;
T19 : 'else' ;
T20 : 'then' ;
T21 : ':' ;
T22 : 'or' ;
T23 : 'and' ;
T24 : 'not' ;
T25 : '-' ;
T26 : '(' ;
T27 : ')' ;
T28 : '::' ;
T29 : 'der' ;
T30 : 'initial' ;
T31 : '=' ;
T32 : '.' ;
T33 : '[' ;
T34 : ']' ;
T35 : ';' ;
T36 : 'begin' ;
T37 : 'end' ;
T38 : '/' ;
T39 : '*' ;
T40 : '^' ;
T41 : '<' ;
T42 : '<=' ;
T43 : '>' ;
T44 : '>=' ;
T45 : '==' ;
T46 : '<>' ;
T47 : '+' ;
T48 : '.+' ;
T49 : '.-' ;
T50 : '.*' ;
T51 : './' ;
T52 : '.^' ;
T53 : 'false' ;
T54 : 'true' ;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3695
RULE_IDENT : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3697
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3699
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3701
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3703
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3705
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3707
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g" 3709
RULE_ANY_OTHER : .;


