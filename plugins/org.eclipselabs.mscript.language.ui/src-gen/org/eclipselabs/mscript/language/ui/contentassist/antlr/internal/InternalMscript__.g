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
T33 : 'record' ;
T34 : ';' ;
T35 : '(' ;
T36 : ')' ;
T37 : 'check' ;
T38 : 'if' ;
T39 : 'elseif' ;
T40 : 'else' ;
T41 : 'while' ;
T42 : 'do' ;
T43 : 'foreach' ;
T44 : 'in' ;
T45 : '=' ;
T46 : 'return' ;
T47 : 'real' ;
T48 : 'int' ;
T49 : 'complex' ;
T50 : 'gauss' ;
T51 : 'bool' ;
T52 : 'string' ;
T53 : 'unit' ;
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
T66 : 'ref' ;
T67 : 'const' ;
T68 : 'j' ;
T69 : '?' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12757
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12759
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12761
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12763
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12765
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12767
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12769
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 12771
RULE_ANY_OTHER : .;


