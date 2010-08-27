lexer grammar InternalMscript;
@header {
package org.eclipselabs.damos.scripting.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '<' ;
T13 : '<=' ;
T14 : '>' ;
T15 : '>=' ;
T16 : '==' ;
T17 : '<>' ;
T18 : '+' ;
T19 : '-' ;
T20 : '.+' ;
T21 : '.-' ;
T22 : '*' ;
T23 : '/' ;
T24 : '.*' ;
T25 : './' ;
T26 : '^' ;
T27 : '.^' ;
T28 : 'false' ;
T29 : 'true' ;
T30 : 'package' ;
T31 : '{' ;
T32 : '}' ;
T33 : 'enumeration' ;
T34 : ',' ;
T35 : 'Real' ;
T36 : '(' ;
T37 : ')' ;
T38 : 'Integer' ;
T39 : 'Boolean' ;
T40 : 'String' ;
T41 : 'if' ;
T42 : 'else' ;
T43 : 'elseif' ;
T44 : 'then' ;
T45 : ':' ;
T46 : 'or' ;
T47 : 'and' ;
T48 : 'not' ;
T49 : '::' ;
T50 : '=' ;
T51 : '[' ;
T52 : ']' ;
T53 : '.' ;
T54 : ';' ;
T55 : 'begin' ;
T56 : 'end' ;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8767
RULE_IDENT : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8769
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8771
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8773
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8775
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8777
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8779
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8781
RULE_ANY_OTHER : .;


