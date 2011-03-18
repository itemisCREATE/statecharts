lexer grammar InternalExpressions;
@header {
package org.yakindu.sct.statechart.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T13 : '+' ;
T14 : '-' ;
T15 : '*' ;
T16 : '/' ;
T17 : '%' ;
T18 : '~' ;
T19 : '<' ;
T20 : '<=' ;
T21 : '>' ;
T22 : '>=' ;
T23 : '==' ;
T24 : '!=' ;
T25 : 'int' ;
T26 : 'float' ;
T27 : 'boolean' ;
T28 : 'entry:' ;
T29 : 'exit:' ;
T30 : 'do:' ;
T31 : ',' ;
T32 : '[' ;
T33 : ']' ;
T34 : 'var' ;
T35 : '=' ;
T36 : 'event' ;
T37 : 'raise' ;
T38 : '||' ;
T39 : '&&' ;
T40 : '!' ;
T41 : '(' ;
T42 : ')' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3940
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3942
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3944
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3946
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3948
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3950
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3952
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3954
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 3956
RULE_ANY_OTHER : .;


