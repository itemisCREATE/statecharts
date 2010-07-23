lexer grammar InternalMscript;
@header {
package org.eclipselabs.damos.scripting.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'der' ;
T13 : 'initial' ;
T14 : '<' ;
T15 : '<=' ;
T16 : '>' ;
T17 : '>=' ;
T18 : '==' ;
T19 : '<>' ;
T20 : '+' ;
T21 : '-' ;
T22 : '.+' ;
T23 : '.-' ;
T24 : '*' ;
T25 : '/' ;
T26 : '.*' ;
T27 : './' ;
T28 : '^' ;
T29 : '.^' ;
T30 : 'false' ;
T31 : 'true' ;
T32 : 'package' ;
T33 : '{' ;
T34 : '}' ;
T35 : 'enumeration' ;
T36 : ',' ;
T37 : 'if' ;
T38 : 'else' ;
T39 : 'elseif' ;
T40 : 'then' ;
T41 : ':' ;
T42 : 'or' ;
T43 : 'and' ;
T44 : 'not' ;
T45 : '(' ;
T46 : ')' ;
T47 : '::' ;
T48 : '=' ;
T49 : '.' ;
T50 : '[' ;
T51 : ']' ;
T52 : ';' ;
T53 : 'begin' ;
T54 : 'end' ;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8317
RULE_IDENT : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8319
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8321
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8323
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8325
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8327
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8329
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.damos.scripting.ui/src-gen/org/eclipselabs/damos/scripting/ui/contentassist/antlr/internal/InternalMscript.g" 8331
RULE_ANY_OTHER : .;


