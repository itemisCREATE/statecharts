lexer grammar InternalExpressions;
@header {
package org.yakindu.sct.statechart.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T13 : '@@statechart@@' ;
T14 : '@@state@@' ;
T15 : '@@transition@@' ;
T16 : 'interface' ;
T17 : ':' ;
T18 : 'internal' ;
T19 : 'event' ;
T20 : '=' ;
T21 : 'var' ;
T22 : 'readonly' ;
T23 : 'external' ;
T24 : 'clock' ;
T25 : 'operation' ;
T26 : '(' ;
T27 : ',' ;
T28 : ')' ;
T29 : 'entrypoint' ;
T30 : 'exitpoint' ;
T31 : '/' ;
T32 : '#' ;
T33 : '[' ;
T34 : ']' ;
T35 : ';' ;
T36 : '>' ;
T37 : 'after' ;
T38 : 'enter' ;
T39 : 'exit' ;
T40 : 'oncycle' ;
T41 : 'always' ;
T42 : 'raise' ;
T43 : '||' ;
T44 : '&&' ;
T45 : '!' ;
T46 : 'in' ;
T47 : 'out' ;
T48 : '+' ;
T49 : '-' ;
T50 : '*' ;
T51 : '%' ;
T52 : '~' ;
T53 : '<' ;
T54 : '<=' ;
T55 : '>=' ;
T56 : '==' ;
T57 : '!=' ;
T58 : 's' ;
T59 : 'ms' ;
T60 : 'ns' ;
T61 : 'void' ;
T62 : 'integer' ;
T63 : 'real' ;
T64 : 'boolean' ;
T65 : 'string' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3729
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3731
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3733
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3735
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3737
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3739
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3741
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3743
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3745
RULE_ANY_OTHER : .;


