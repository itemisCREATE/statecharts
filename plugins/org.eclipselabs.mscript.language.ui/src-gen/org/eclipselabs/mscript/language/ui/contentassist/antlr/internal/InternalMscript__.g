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
T33 : 'real' ;
T34 : '(' ;
T35 : ')' ;
T36 : 'integer' ;
T37 : 'complex' ;
T38 : 'gaussian' ;
T39 : 'boolean' ;
T40 : 'string' ;
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
T57 : 'j' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9230
RULE_IDENT : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9232
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9234
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9236
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9238
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9240
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9242
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 9244
RULE_ANY_OTHER : .;


