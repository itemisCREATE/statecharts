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
T35 : '>' ;
T36 : 'after' ;
T37 : 'enter' ;
T38 : 'exit' ;
T39 : 'oncycle' ;
T40 : 'raise' ;
T41 : '||' ;
T42 : '&&' ;
T43 : '!' ;
T44 : 'in' ;
T45 : 'out' ;
T46 : '+' ;
T47 : '-' ;
T48 : '*' ;
T49 : '%' ;
T50 : '~' ;
T51 : '<' ;
T52 : '<=' ;
T53 : '>=' ;
T54 : '==' ;
T55 : '!=' ;
T56 : 's' ;
T57 : 'ms' ;
T58 : 'ns' ;
T59 : 'void' ;
T60 : 'integer' ;
T61 : 'real' ;
T62 : 'boolean' ;
T63 : 'string' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3495
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3497
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3499
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3501
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3503
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3505
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3507
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3509
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 3511
RULE_ANY_OTHER : .;


