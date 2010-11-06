lexer grammar InternalExpressions;
@header {
package org.yakindu.sct.statechart.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T14 : ',' ;
T15 : 'after' ;
T16 : '(' ;
T17 : ')' ;
T18 : 'var' ;
T19 : ';' ;
T20 : 'raise' ;
T21 : '||' ;
T22 : '&&' ;
T23 : '^' ;
T24 : '|' ;
T25 : '&' ;
T26 : '?' ;
T27 : ':' ;
T28 : 's' ;
T29 : 'ms' ;
T30 : 'ns' ;
T31 : '=' ;
T32 : '*=' ;
T33 : '/=' ;
T34 : '%=' ;
T35 : '+=' ;
T36 : '-=' ;
T37 : '<<=' ;
T38 : '>>=' ;
T39 : '&=' ;
T40 : '^=' ;
T41 : '|=' ;
T42 : '==' ;
T43 : '!=' ;
T44 : '<' ;
T45 : '>' ;
T46 : '<=' ;
T47 : '>=' ;
T48 : '<<' ;
T49 : '>>' ;
T50 : '+' ;
T51 : '-' ;
T52 : '*' ;
T53 : '/' ;
T54 : '%' ;
T55 : '~' ;
T56 : '!' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2547
RULE_BOOLEAN_LITERAL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2549
RULE_HEX_LITERAL : '0' ('x'|'X') ('0'..'9'|'a'..'f'|'A'..'F')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2551
RULE_FLOATING_POINT_LITERAL : ('0'..'9')* '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? ('f'|'F'|'d'|'D')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2553
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2555
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2557
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2559
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2561
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2563
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g" 2565
RULE_ANY_OTHER : .;


