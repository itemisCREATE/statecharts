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
T20 : 'interface' ;
T21 : ':' ;
T22 : 'internal' ;
T23 : 'var' ;
T24 : 'readonly' ;
T25 : 'external' ;
T26 : '=' ;
T27 : 'event' ;
T28 : 'operation' ;
T29 : '(' ;
T30 : ')' ;
T31 : 'entrypoint' ;
T32 : 'exitpoint' ;
T33 : 'clock' ;
T34 : 'raise' ;
T35 : '||' ;
T36 : '&&' ;
T37 : '!' ;
T38 : 'in' ;
T39 : 'out' ;
T40 : '+' ;
T41 : '-' ;
T42 : '*' ;
T43 : '%' ;
T44 : '~' ;
T45 : '<' ;
T46 : '<=' ;
T47 : '>' ;
T48 : '>=' ;
T49 : '==' ;
T50 : '!=' ;
T51 : 'void' ;
T52 : 'integer' ;
T53 : 'real' ;
T54 : 'boolean' ;
T55 : 'string' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2741
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2743
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2745
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2747
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2749
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2751
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2753
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2755
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2757
RULE_ANY_OTHER : .;


