lexer grammar InternalExpressions;
@header {
package org.yakindu.sct.statechart.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T13 : 'in' ;
T14 : 'out' ;
T15 : '+' ;
T16 : '-' ;
T17 : '*' ;
T18 : '/' ;
T19 : '%' ;
T20 : '~' ;
T21 : '<' ;
T22 : '<=' ;
T23 : '>' ;
T24 : '>=' ;
T25 : '==' ;
T26 : '!=' ;
T27 : 's' ;
T28 : 'ms' ;
T29 : 'ns' ;
T30 : 'void' ;
T31 : 'integer' ;
T32 : 'real' ;
T33 : 'boolean' ;
T34 : 'string' ;
T35 : '@@statechart@@' ;
T36 : '@@state@@' ;
T37 : '@@transition@@' ;
T38 : 'interface' ;
T39 : ':' ;
T40 : 'internal' ;
T41 : 'event' ;
T42 : '=' ;
T43 : 'var' ;
T44 : 'clock' ;
T45 : 'operation' ;
T46 : '(' ;
T47 : ')' ;
T48 : ',' ;
T49 : 'entrypoint' ;
T50 : 'exitpoint' ;
T51 : '#' ;
T52 : '[' ;
T53 : ']' ;
T54 : 'after' ;
T55 : 'enter' ;
T56 : 'exit' ;
T57 : 'oncycle' ;
T58 : 'entry:' ;
T59 : 'exit:' ;
T60 : 'do:' ;
T61 : 'raise' ;
T62 : '||' ;
T63 : '&&' ;
T64 : '!' ;
T65 : 'readonly' ;
T66 : 'external' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7475
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7477
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7479
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7481
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7483
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7485
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7487
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7489
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 7491
RULE_ANY_OTHER : .;


