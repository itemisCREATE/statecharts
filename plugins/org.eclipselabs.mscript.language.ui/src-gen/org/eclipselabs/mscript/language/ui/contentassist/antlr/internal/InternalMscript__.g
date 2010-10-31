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
T35 : 'namespace' ;
T36 : '{' ;
T37 : '}' ;
T38 : 'enum' ;
T39 : ',' ;
T40 : 'type' ;
T41 : '=' ;
T42 : ';' ;
T43 : 'record' ;
T44 : ':' ;
T45 : 'func' ;
T46 : '(' ;
T47 : ')' ;
T48 : '->' ;
T49 : 'assert' ;
T50 : 'var' ;
T51 : 'functor' ;
T52 : 'real' ;
T53 : '[' ;
T54 : ']' ;
T55 : 'int' ;
T56 : 'complex' ;
T57 : 'gauss' ;
T58 : 'bool' ;
T59 : 'string' ;
T60 : 'let' ;
T61 : 'in' ;
T62 : 'if' ;
T63 : 'then' ;
T64 : 'else' ;
T65 : 'switch' ;
T66 : 'default' ;
T67 : 'case' ;
T68 : '=>' ;
T69 : '||' ;
T70 : '&&' ;
T71 : '.' ;
T72 : '|' ;
T73 : 'for' ;
T74 : 'begin' ;
T75 : 'end' ;
T76 : 'stateful' ;
T77 : 'static' ;
T78 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16951
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16953
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16955
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16957
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16959
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16961
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16963
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16965
RULE_ANY_OTHER : .;


