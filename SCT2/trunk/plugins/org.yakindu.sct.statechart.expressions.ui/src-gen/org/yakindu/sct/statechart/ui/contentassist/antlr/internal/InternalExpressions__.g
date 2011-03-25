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
T27 : 'void' ;
T28 : 'integer' ;
T29 : 'real' ;
T30 : 'boolean' ;
T31 : 'string' ;
T32 : '@@statechart@@' ;
T33 : '@@state@@' ;
T34 : '@@transition@@' ;
T35 : 'interface' ;
T36 : ':' ;
T37 : 'internal' ;
T38 : 'event' ;
T39 : '=' ;
T40 : 'var' ;
T41 : 'clock' ;
T42 : 'operation' ;
T43 : '(' ;
T44 : ')' ;
T45 : ',' ;
T46 : 'entrypoint' ;
T47 : 'exitpoint' ;
T48 : '#' ;
T49 : '[' ;
T50 : ']' ;
T51 : 'entry:' ;
T52 : 'exit:' ;
T53 : 'do:' ;
T54 : 'raise' ;
T55 : '||' ;
T56 : '&&' ;
T57 : '!' ;
T58 : 'readonly' ;
T59 : 'external' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6846
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6848
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6850
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6852
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6854
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6856
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6858
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6860
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 6862
RULE_ANY_OTHER : .;


