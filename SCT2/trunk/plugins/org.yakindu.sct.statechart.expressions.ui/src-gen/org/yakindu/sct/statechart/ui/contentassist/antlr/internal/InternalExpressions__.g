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
T32 : 'entry:' ;
T33 : 'exit:' ;
T34 : 'do:' ;
T35 : ',' ;
T36 : '[' ;
T37 : ']' ;
T38 : 'interface' ;
T39 : ':' ;
T40 : 'internal' ;
T41 : 'var' ;
T42 : '=' ;
T43 : 'event' ;
T44 : 'operation' ;
T45 : '(' ;
T46 : ')' ;
T47 : 'entrypoint' ;
T48 : 'exitpoint' ;
T49 : 'clock' ;
T50 : 'raise' ;
T51 : '||' ;
T52 : '&&' ;
T53 : '!' ;
T54 : 'readonly' ;
T55 : 'external' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5907
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5909
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5911
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5913
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5915
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5917
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5919
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5921
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 5923
RULE_ANY_OTHER : .;


