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
T19 : '!=' ;
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
T37 : 'func' ;
T38 : '(' ;
T39 : ')' ;
T40 : '=' ;
T41 : 'if' ;
T42 : 'elseif' ;
T43 : 'else' ;
T44 : 'while' ;
T45 : 'do' ;
T46 : 'foreach' ;
T47 : 'in' ;
T48 : 'var' ;
T49 : 'type' ;
T50 : 'return' ;
T51 : 'real' ;
T52 : '[' ;
T53 : ']' ;
T54 : 'int' ;
T55 : 'complex' ;
T56 : 'gauss' ;
T57 : 'bool' ;
T58 : 'string' ;
T59 : '..' ;
T60 : 'then' ;
T61 : ':' ;
T62 : 'or' ;
T63 : 'and' ;
T64 : 'not' ;
T65 : '.' ;
T66 : '::' ;
T67 : 'begin' ;
T68 : 'end' ;
T69 : 'eval' ;
T70 : 'static' ;
T71 : 'ref' ;
T72 : 'auto' ;
T73 : 'const' ;
T74 : '?' ;
T75 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15484
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15486
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15488
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15490
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15492
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15494
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15496
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 15498
RULE_ANY_OTHER : .;


