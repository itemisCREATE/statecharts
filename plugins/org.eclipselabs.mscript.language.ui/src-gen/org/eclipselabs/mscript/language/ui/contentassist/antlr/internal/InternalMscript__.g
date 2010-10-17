lexer grammar InternalMscript;
@header {
package org.eclipselabs.mscript.language.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : 'var' ;
T13 : 'unit' ;
T14 : 'j' ;
T15 : 'info' ;
T16 : 'warning' ;
T17 : 'error' ;
T18 : 'fatal' ;
T19 : '=' ;
T20 : '+=' ;
T21 : '-=' ;
T22 : '*=' ;
T23 : '/=' ;
T24 : '==' ;
T25 : '!=' ;
T26 : '<' ;
T27 : '<=' ;
T28 : '>' ;
T29 : '>=' ;
T30 : '+' ;
T31 : '-' ;
T32 : '*' ;
T33 : '/' ;
T34 : '.*' ;
T35 : './' ;
T36 : '^' ;
T37 : '.^' ;
T38 : '!' ;
T39 : '++' ;
T40 : '--' ;
T41 : 'false' ;
T42 : 'true' ;
T43 : 'package' ;
T44 : '{' ;
T45 : '}' ;
T46 : 'enum' ;
T47 : ',' ;
T48 : 'type' ;
T49 : ';' ;
T50 : ':' ;
T51 : 'record' ;
T52 : 'func' ;
T53 : '(' ;
T54 : ')' ;
T55 : 'pre' ;
T56 : 'check' ;
T57 : 'if' ;
T58 : 'elseif' ;
T59 : 'else' ;
T60 : 'while' ;
T61 : 'do' ;
T62 : 'for' ;
T63 : 'foreach' ;
T64 : 'in' ;
T65 : 'switch' ;
T66 : 'default' ;
T67 : 'case' ;
T68 : 'continue' ;
T69 : 'break' ;
T70 : 'return' ;
T71 : 'real' ;
T72 : '[' ;
T73 : ']' ;
T74 : 'int' ;
T75 : 'complex' ;
T76 : 'gauss' ;
T77 : 'bool' ;
T78 : 'string' ;
T79 : '?' ;
T80 : '||' ;
T81 : '&&' ;
T82 : '.' ;
T83 : '::' ;
T84 : 'begin' ;
T85 : 'end' ;
T86 : 'eval' ;
T87 : 'const' ;
T88 : 'ref' ;
T89 : 'is' ;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18342
RULE_ID : ('_'|'a'..'z'|'A'..'Z') ('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18344
RULE_STRING : '"' (~(('\\'|'"'))|'\\' ('\''|'"'|'?'|'\\'|'a'|'b'|'f'|'n'|'r'|'t'|'v'))* '"';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18346
RULE_REAL : ('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18348
RULE_INTEGER : ('0'..'9')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18350
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18352
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18354
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipselabs.mscript.language.ui/src-gen/org/eclipselabs/mscript/language/ui/contentassist/antlr/internal/InternalMscript.g" 18356
RULE_ANY_OTHER : .;


