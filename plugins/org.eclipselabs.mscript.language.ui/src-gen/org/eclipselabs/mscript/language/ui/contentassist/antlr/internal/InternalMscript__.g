lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '\'' ;
T13 : 'unit' ;
T14 : 'j' ;
T15 : 'info' ;
T16 : 'warning' ;
T17 : 'error' ;
T18 : 'fatal' ;
T19 : '==' ;
T20 : '!=' ;
T21 : '<' ;
T22 : '<=' ;
T23 : '>' ;
T24 : '>=' ;
T25 : '+' ;
T26 : '-' ;
T27 : '*' ;
T28 : '/' ;
T29 : '.*' ;
T30 : './' ;
T31 : '^' ;
T32 : '.^' ;
T33 : '!' ;
T34 : 'false' ;
T35 : 'true' ;
T36 : 'namespace' ;
T37 : '{' ;
T38 : '}' ;
T39 : 'enum' ;
T40 : ',' ;
T41 : 'type' ;
T42 : '=' ;
T43 : ';' ;
T44 : 'record' ;
T45 : ':' ;
T46 : 'func' ;
T47 : '(' ;
T48 : ')' ;
T49 : '->' ;
T50 : 'assert' ;
T51 : 'var' ;
T52 : 'functor' ;
T53 : 'real' ;
T54 : '[' ;
T55 : ']' ;
T56 : 'int' ;
T57 : 'complex' ;
T58 : 'gauss' ;
T59 : 'bool' ;
T60 : 'string' ;
T61 : 'let' ;
T62 : 'in' ;
T63 : 'if' ;
T64 : 'then' ;
T65 : 'else' ;
T66 : 'switch' ;
T67 : 'default' ;
T68 : 'case' ;
T69 : '=>' ;
T70 : '||' ;
T71 : '&&' ;
T72 : '.' ;
T73 : '|' ;
T74 : 'begin' ;
T75 : 'end' ;
T76 : 'eval' ;
T77 : 'stateful' ;
T78 : 'static' ;
T79 : '?' ;
T80 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16260
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16262
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16264
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16266
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16268
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16270
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16272
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 16274
RULE_ANY_OTHER : .;


