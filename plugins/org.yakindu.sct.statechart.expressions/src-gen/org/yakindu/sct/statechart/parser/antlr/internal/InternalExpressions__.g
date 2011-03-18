lexer grammar InternalExpressions;
@header {
package org.yakindu.sct.statechart.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T13 : 'entry:' ;
T14 : 'exit:' ;
T15 : 'do:' ;
T16 : ',' ;
T17 : '[' ;
T18 : ']' ;
T19 : '/' ;
T20 : 'var' ;
T21 : '=' ;
T22 : 'event' ;
T23 : 'raise' ;
T24 : '||' ;
T25 : '&&' ;
T26 : '!' ;
T27 : '(' ;
T28 : ')' ;
T29 : '+' ;
T30 : '-' ;
T31 : '*' ;
T32 : '%' ;
T33 : '~' ;
T34 : '<' ;
T35 : '<=' ;
T36 : '>' ;
T37 : '>=' ;
T38 : '==' ;
T39 : '!=' ;
T40 : 'int' ;
T41 : 'float' ;
T42 : 'boolean' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1909
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1911
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1913
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1915
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1917
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1919
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1921
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1923
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 1925
RULE_ANY_OTHER : .;


