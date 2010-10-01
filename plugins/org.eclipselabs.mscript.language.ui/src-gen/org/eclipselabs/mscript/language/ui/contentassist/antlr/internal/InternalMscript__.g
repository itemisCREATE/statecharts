lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

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
T20 : '*' ;
T21 : '/' ;
T22 : '.*' ;
T23 : './' ;
T24 : '^' ;
T25 : '.^' ;
T26 : 'false' ;
T27 : 'true' ;
T28 : 'package' ;
T29 : '{' ;
T30 : '}' ;
T31 : 'enumeration' ;
T32 : ',' ;
T33 : '(' ;
T34 : ')' ;
T35 : ';' ;
T36 : 'if' ;
T37 : 'elseif' ;
T38 : 'else' ;
T39 : 'while' ;
T40 : '=' ;
T41 : 'real' ;
T42 : 'integer' ;
T43 : 'complex' ;
T44 : 'gaussian' ;
T45 : 'boolean' ;
T46 : 'string' ;
T47 : 'then' ;
T48 : ':' ;
T49 : 'or' ;
T50 : 'and' ;
T51 : 'not' ;
T52 : '::' ;
T53 : '[' ;
T54 : ']' ;
T55 : '.' ;
T56 : 'begin' ;
T57 : 'end' ;
T58 : 'j' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10796
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10798
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10800
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10802
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10804
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10806
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10808
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 10810
RULE_ANY_OTHER : .;


