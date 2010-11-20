lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '\'' ;
T13 : 'unit' ;
T14 : 'info' ;
T15 : 'warning' ;
T16 : 'error' ;
T17 : 'fatal' ;
T18 : '==' ;
T19 : '!=' ;
T20 : '<' ;
T21 : '<=' ;
T22 : '>' ;
T23 : '>=' ;
T24 : '+' ;
T25 : '-' ;
T26 : '*' ;
T27 : '/' ;
T28 : '.*' ;
T29 : './' ;
T30 : '^' ;
T31 : '.^' ;
T32 : '!' ;
T33 : 'false' ;
T34 : 'true' ;
T35 : 'enum' ;
T36 : '{' ;
T37 : '}' ;
T38 : ',' ;
T39 : 'type' ;
T40 : '=' ;
T41 : ';' ;
T42 : 'record' ;
T43 : ':' ;
T44 : 'func' ;
T45 : '(' ;
T46 : ')' ;
T47 : '->' ;
T48 : 'assert' ;
T49 : 'var' ;
T50 : 'functor' ;
T51 : 'real' ;
T52 : '[' ;
T53 : ']' ;
T54 : 'int' ;
T55 : 'complex' ;
T56 : 'gauss' ;
T57 : 'bool' ;
T58 : 'string' ;
T59 : 'let' ;
T60 : 'in' ;
T61 : 'if' ;
T62 : 'then' ;
T63 : 'else' ;
T64 : 'switch' ;
T65 : 'default' ;
T66 : 'case' ;
T67 : '=>' ;
T68 : '||' ;
T69 : '&&' ;
T70 : '.' ;
T71 : '|' ;
T72 : 'for' ;
T73 : 'begin' ;
T74 : 'end' ;
T75 : 'stateful' ;
T76 : 'static' ;
T77 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16889
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16891
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16893
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16895
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16897
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16899
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16901
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16903
RULE_ANY_OTHER : .;


