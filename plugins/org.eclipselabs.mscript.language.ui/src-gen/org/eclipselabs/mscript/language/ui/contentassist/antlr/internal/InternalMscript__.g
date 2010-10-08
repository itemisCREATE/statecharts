lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'unit' ;
T13 : 'j' ;
T14 : 'info' ;
T15 : 'warning' ;
T16 : 'error' ;
T17 : 'fatal' ;
T18 : '<' ;
T19 : '<=' ;
T20 : '>' ;
T21 : '>=' ;
T22 : '==' ;
T23 : '!=' ;
T24 : '+' ;
T25 : '-' ;
T26 : '*' ;
T27 : '/' ;
T28 : '.*' ;
T29 : './' ;
T30 : '^' ;
T31 : '.^' ;
T32 : 'false' ;
T33 : 'true' ;
T34 : 'package' ;
T35 : '{' ;
T36 : '}' ;
T37 : 'enum' ;
T38 : ',' ;
T39 : 'type' ;
T40 : '=' ;
T41 : ';' ;
T42 : 'var' ;
T43 : ':' ;
T44 : 'record' ;
T45 : 'func' ;
T46 : '(' ;
T47 : ')' ;
T48 : 'pre' ;
T49 : 'check' ;
T50 : 'if' ;
T51 : 'elseif' ;
T52 : 'else' ;
T53 : 'while' ;
T54 : 'do' ;
T55 : 'foreach' ;
T56 : 'in' ;
T57 : 'return' ;
T58 : 'real' ;
T59 : '[' ;
T60 : ']' ;
T61 : 'int' ;
T62 : 'complex' ;
T63 : 'gauss' ;
T64 : 'bool' ;
T65 : 'string' ;
T66 : '..' ;
T67 : 'then' ;
T68 : 'or' ;
T69 : 'and' ;
T70 : 'not' ;
T71 : '.' ;
T72 : '::' ;
T73 : 'begin' ;
T74 : 'end' ;
T75 : 'eval' ;
T76 : 'auto' ;
T77 : 'const' ;
T78 : 'ref' ;
T79 : '?' ;
T80 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15828
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15830
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15832
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15834
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15836
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15838
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15840
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15842
RULE_ANY_OTHER : .;


