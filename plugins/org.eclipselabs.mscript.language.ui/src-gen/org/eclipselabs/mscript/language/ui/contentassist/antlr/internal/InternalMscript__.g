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
T39 : 'check' ;
T40 : 'exec' ;
T41 : 'if' ;
T42 : 'elseif' ;
T43 : 'else' ;
T44 : 'while' ;
T45 : 'do' ;
T46 : 'foreach' ;
T47 : 'in' ;
T48 : '=' ;
T49 : 'return' ;
T50 : 'real' ;
T51 : 'int' ;
T52 : 'complex' ;
T53 : 'gauss' ;
T54 : 'bool' ;
T55 : 'string' ;
T56 : 'then' ;
T57 : ':' ;
T58 : 'or' ;
T59 : 'and' ;
T60 : 'not' ;
T61 : '.' ;
T62 : '[' ;
T63 : ']' ;
T64 : '::' ;
T65 : 'begin' ;
T66 : 'end' ;
T67 : 'eval' ;
T68 : 'ref' ;
T69 : 'const' ;
T70 : 'is' ;
T71 : '?' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13060
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13062
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13064
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13066
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13068
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13070
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13072
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 13074
RULE_ANY_OTHER : .;


