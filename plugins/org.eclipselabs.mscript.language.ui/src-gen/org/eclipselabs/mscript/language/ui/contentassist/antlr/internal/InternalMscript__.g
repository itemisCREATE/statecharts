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
T31 : 'enum' ;
T32 : ',' ;
T33 : '(' ;
T34 : ')' ;
T35 : ';' ;
T36 : 'if' ;
T37 : 'elseif' ;
T38 : 'else' ;
T39 : 'while' ;
T40 : 'do' ;
T41 : 'foreach' ;
T42 : 'in' ;
T43 : '=' ;
T44 : 'return' ;
T45 : 'real' ;
T46 : 'int' ;
T47 : 'complex' ;
T48 : 'gauss' ;
T49 : 'bool' ;
T50 : 'string' ;
T51 : 'then' ;
T52 : ':' ;
T53 : 'or' ;
T54 : 'and' ;
T55 : 'not' ;
T56 : '::' ;
T57 : '[' ;
T58 : ']' ;
T59 : '.' ;
T60 : 'begin' ;
T61 : 'end' ;
T62 : 'ref' ;
T63 : 'j' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11529
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11531
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11533
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11535
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11537
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11539
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11541
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 11543
RULE_ANY_OTHER : .;


