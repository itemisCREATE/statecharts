lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'unit' ;
T13 : 'j' ;
T14 : '<' ;
T15 : '<=' ;
T16 : '>' ;
T17 : '>=' ;
T18 : '==' ;
T19 : '<>' ;
T20 : '+' ;
T21 : '-' ;
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
T33 : 'enum' ;
T34 : ',' ;
T35 : 'record' ;
T36 : ';' ;
T37 : '(' ;
T38 : ')' ;
T39 : 'if' ;
T40 : 'elseif' ;
T41 : 'else' ;
T42 : 'while' ;
T43 : 'do' ;
T44 : 'foreach' ;
T45 : 'in' ;
T46 : '=' ;
T47 : 'return' ;
T48 : 'real' ;
T49 : 'int' ;
T50 : 'complex' ;
T51 : 'gauss' ;
T52 : 'bool' ;
T53 : 'string' ;
T54 : 'then' ;
T55 : ':' ;
T56 : 'or' ;
T57 : 'and' ;
T58 : 'not' ;
T59 : '.' ;
T60 : '[' ;
T61 : ']' ;
T62 : '::' ;
T63 : 'begin' ;
T64 : 'end' ;
T65 : 'eval' ;
T66 : 'static' ;
T67 : 'ref' ;
T68 : 'auto' ;
T69 : 'const' ;
T70 : 'is' ;
T71 : '?' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13053
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13055
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13057
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13059
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13061
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13063
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13065
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13067
RULE_ANY_OTHER : .;


