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
T54 : ';' ;
T55 : 'after' ;
T56 : 'entry' ;
T57 : 'exit' ;
T58 : 'oncycle' ;
T59 : 'always' ;
T60 : 'raise' ;
T61 : '||' ;
T62 : '&&' ;
T63 : '!' ;
T64 : 'readonly' ;
T65 : 'external' ;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8288
RULE_BOOL : ('true'|'false');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8290
RULE_FLOAT : ('-'|'+')? RULE_INT '.' RULE_INT ('e' ('-'|'+') RULE_INT)?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8292
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8294
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8296
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8298
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8300
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8302
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.yakindu.sct.statechart.expressions.ui/src-gen/org/yakindu/sct/statechart/ui/contentassist/antlr/internal/InternalExpressions.g" 8304
RULE_ANY_OTHER : .;


