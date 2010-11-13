package org.eclipselabs.mscript.language.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipselabs.mscript.language.services.MscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'enum'", "'{'", "','", "'}'", "'type'", "'='", "';'", "'record'", "':'", "'stateful'", "'func'", "'<'", "'>'", "'('", "')'", "'->'", "'static'", "'assert'", "'var'", "'functor'", "'real'", "'['", "']'", "'int'", "'complex'", "'gauss'", "'bool'", "'string'", "'let'", "'in'", "'if'", "'then'", "'else'", "'switch'", "'default'", "'case'", "'=>'", "'||'", "'&&'", "'is'", "'.'", "'unit'", "'|'", "'for'", "'begin'", "'end'", "'/'", "'*'", "'^'", "'-'", "'info'", "'warning'", "'error'", "'fatal'", "'=='", "'!='", "'<='", "'>='", "'+'", "'.*'", "'./'", "'.^'", "'!'", "'\\''", "'false'", "'true'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_REAL=5;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_INTEGER=6;
    public static final int RULE_ML_COMMENT=8;

        public InternalMscriptParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g"; }



     	private MscriptGrammarAccess grammarAccess;
     	
        public InternalMscriptParser(TokenStream input, IAstFactory factory, MscriptGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Module";	
       	}
       	
       	@Override
       	protected MscriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModule
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:78:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:79:2: (iv_ruleModule= ruleModule EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:80:2: iv_ruleModule= ruleModule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule75);
            iv_ruleModule=ruleModule();
            _fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModule


    // $ANTLR start ruleModule
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:87:1: ruleModule returns [EObject current=null] : ( (lv_definitions_0_0= ruleDefinition ) )* ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:92:6: ( ( (lv_definitions_0_0= ruleDefinition ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_definitions_0_0= ruleDefinition ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_definitions_0_0= ruleDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==16||LA1_0==19||(LA1_0>=21 && LA1_0<=22)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:94:1: (lv_definitions_0_0= ruleDefinition )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:94:1: (lv_definitions_0_0= ruleDefinition )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:95:3: lv_definitions_0_0= ruleDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModuleAccess().getDefinitionsDefinitionParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefinition_in_ruleModule130);
            	    lv_definitions_0_0=ruleDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"definitions",
            	    	        		lv_definitions_0_0, 
            	    	        		"Definition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModule


    // $ANTLR start entryRuleDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:125:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:126:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:127:2: iv_ruleDefinition= ruleDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition166);
            iv_ruleDefinition=ruleDefinition();
            _fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDefinition


    // $ANTLR start ruleDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:134:1: ruleDefinition returns [EObject current=null] : (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeDefinition_0 = null;

        EObject this_FunctionDefinition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:139:6: ( (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12||LA2_0==16||LA2_0==19) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=21 && LA2_0<=22)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("140:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:141:5: this_DataTypeDefinition_0= ruleDataTypeDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getDataTypeDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataTypeDefinition_in_ruleDefinition223);
                    this_DataTypeDefinition_0=ruleDataTypeDefinition();
                    _fsp--;

                     
                            current = this_DataTypeDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:151:5: this_FunctionDefinition_1= ruleFunctionDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getFunctionDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_ruleDefinition250);
                    this_FunctionDefinition_1=ruleFunctionDefinition();
                    _fsp--;

                     
                            current = this_FunctionDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDefinition


    // $ANTLR start entryRuleDataTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:167:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:168:2: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:169:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeDefinition_in_entryRuleDataTypeDefinition285);
            iv_ruleDataTypeDefinition=ruleDataTypeDefinition();
            _fsp--;

             current =iv_ruleDataTypeDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeDefinition295); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataTypeDefinition


    // $ANTLR start ruleDataTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:176:1: ruleDataTypeDefinition returns [EObject current=null] : (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_EnumerationDefinition_0 = null;

        EObject this_RecordDefinition_1 = null;

        EObject this_TypeAliasDefinition_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:181:6: ( (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:182:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:182:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 16:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("182:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:183:5: this_EnumerationDefinition_0= ruleEnumerationDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getEnumerationDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumerationDefinition_in_ruleDataTypeDefinition342);
                    this_EnumerationDefinition_0=ruleEnumerationDefinition();
                    _fsp--;

                     
                            current = this_EnumerationDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:193:5: this_RecordDefinition_1= ruleRecordDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getRecordDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRecordDefinition_in_ruleDataTypeDefinition369);
                    this_RecordDefinition_1=ruleRecordDefinition();
                    _fsp--;

                     
                            current = this_RecordDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:203:5: this_TypeAliasDefinition_2= ruleTypeAliasDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getTypeAliasDefinitionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeAliasDefinition_in_ruleDataTypeDefinition396);
                    this_TypeAliasDefinition_2=ruleTypeAliasDefinition();
                    _fsp--;

                     
                            current = this_TypeAliasDefinition_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDataTypeDefinition


    // $ANTLR start entryRuleEnumerationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:219:1: entryRuleEnumerationDefinition returns [EObject current=null] : iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF ;
    public final EObject entryRuleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:220:2: (iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:221:2: iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition431);
            iv_ruleEnumerationDefinition=ruleEnumerationDefinition();
            _fsp--;

             current =iv_ruleEnumerationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationDefinition441); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnumerationDefinition


    // $ANTLR start ruleEnumerationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:228:1: ruleEnumerationDefinition returns [EObject current=null] : ( 'enum' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) ;
    public final EObject ruleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_literalDeclarations_3_0 = null;

        EObject lv_literalDeclarations_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:233:6: ( ( 'enum' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:234:1: ( 'enum' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:234:1: ( 'enum' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:234:3: 'enum' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}'
            {
            match(input,12,FOLLOW_12_in_ruleEnumerationDefinition476); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:238:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:239:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:239:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:240:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationDefinition493); 

            			createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEnumerationDefinition508); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:266:1: ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:266:2: ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:266:2: ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:267:1: (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:267:1: (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:268:3: lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralDeclarationsEnumerationLiteralDeclarationParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition530);
                    lv_literalDeclarations_3_0=ruleEnumerationLiteralDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"literalDeclarations",
                    	        		lv_literalDeclarations_3_0, 
                    	        		"EnumerationLiteralDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:290:2: ( ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==14) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:290:4: ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleEnumerationDefinition541); 

                    	            createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:294:1: ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:295:1: (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:295:1: (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:296:3: lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralDeclarationsEnumerationLiteralDeclarationParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition562);
                    	    lv_literalDeclarations_5_0=ruleEnumerationLiteralDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"literalDeclarations",
                    	    	        		lv_literalDeclarations_5_0, 
                    	    	        		"EnumerationLiteralDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleEnumerationDefinition576); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEnumerationDefinition


    // $ANTLR start entryRuleEnumerationLiteralDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:330:1: entryRuleEnumerationLiteralDeclaration returns [EObject current=null] : iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF ;
    public final EObject entryRuleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:331:2: (iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:332:2: iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationLiteralDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration612);
            iv_ruleEnumerationLiteralDeclaration=ruleEnumerationLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumerationLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration622); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnumerationLiteralDeclaration


    // $ANTLR start ruleEnumerationLiteralDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:339:1: ruleEnumerationLiteralDeclaration returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:344:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:345:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:345:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:346:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:346:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:347:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationLiteralDeclaration663); 

            			createLeafNode(grammarAccess.getEnumerationLiteralDeclarationAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEnumerationLiteralDeclaration


    // $ANTLR start entryRuleTypeAliasDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:377:1: entryRuleTypeAliasDefinition returns [EObject current=null] : iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF ;
    public final EObject entryRuleTypeAliasDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAliasDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:378:2: (iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:379:2: iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeAliasDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeAliasDefinition_in_entryRuleTypeAliasDefinition703);
            iv_ruleTypeAliasDefinition=ruleTypeAliasDefinition();
            _fsp--;

             current =iv_ruleTypeAliasDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAliasDefinition713); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTypeAliasDefinition


    // $ANTLR start ruleTypeAliasDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:386:1: ruleTypeAliasDefinition returns [EObject current=null] : ( 'type' ( (lv_name_1_0= RULE_ID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' ) ;
    public final EObject ruleTypeAliasDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:391:6: ( ( 'type' ( (lv_name_1_0= RULE_ID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:392:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:392:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:392:3: 'type' ( (lv_name_1_0= RULE_ID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';'
            {
            match(input,16,FOLLOW_16_in_ruleTypeAliasDefinition748); 

                    createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:396:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:397:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:397:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:398:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeAliasDefinition765); 

            			createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeAliasDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleTypeAliasDefinition780); 

                    createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getEqualsSignKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:424:1: ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:425:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:425:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:426:3: lv_type_3_0= rulePrimitiveTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeAliasDefinitionAccess().getTypePrimitiveTypeSpecifierParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeAliasDefinition801);
            lv_type_3_0=rulePrimitiveTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeAliasDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_3_0, 
            	        		"PrimitiveTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleTypeAliasDefinition811); 

                    createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getSemicolonKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeAliasDefinition


    // $ANTLR start entryRuleRecordDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:460:1: entryRuleRecordDefinition returns [EObject current=null] : iv_ruleRecordDefinition= ruleRecordDefinition EOF ;
    public final EObject entryRuleRecordDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:461:2: (iv_ruleRecordDefinition= ruleRecordDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:462:2: iv_ruleRecordDefinition= ruleRecordDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition847);
            iv_ruleRecordDefinition=ruleRecordDefinition();
            _fsp--;

             current =iv_ruleRecordDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordDefinition857); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRecordDefinition


    // $ANTLR start ruleRecordDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:469:1: ruleRecordDefinition returns [EObject current=null] : ( 'record' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* '}' ) ;
    public final EObject ruleRecordDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_fieldDeclarations_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:474:6: ( ( 'record' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:475:1: ( 'record' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:475:1: ( 'record' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:475:3: 'record' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* '}'
            {
            match(input,19,FOLLOW_19_in_ruleRecordDefinition892); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getRecordKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:479:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:480:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:480:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:481:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordDefinition909); 

            			createLeafNode(grammarAccess.getRecordDefinitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleRecordDefinition924); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:507:1: ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:508:1: (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:508:1: (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:509:3: lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecordDefinitionAccess().getFieldDeclarationsRecordFieldDeclarationParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition945);
            	    lv_fieldDeclarations_3_0=ruleRecordFieldDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRecordDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"fieldDeclarations",
            	    	        		lv_fieldDeclarations_3_0, 
            	    	        		"RecordFieldDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleRecordDefinition956); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRecordDefinition


    // $ANTLR start entryRuleRecordFieldDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:543:1: entryRuleRecordFieldDeclaration returns [EObject current=null] : iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF ;
    public final EObject entryRuleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordFieldDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:544:2: (iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:545:2: iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordFieldDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration992);
            iv_ruleRecordFieldDeclaration=ruleRecordFieldDeclaration();
            _fsp--;

             current =iv_ruleRecordFieldDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordFieldDeclaration1002); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRecordFieldDeclaration


    // $ANTLR start ruleRecordFieldDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:552:1: ruleRecordFieldDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' ) ;
    public final EObject ruleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:557:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:558:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:558:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:558:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:558:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:559:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:559:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:560:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordFieldDeclaration1044); 

            			createLeafNode(grammarAccess.getRecordFieldDeclarationAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,20,FOLLOW_20_in_ruleRecordFieldDeclaration1059); 

                    createLeafNode(grammarAccess.getRecordFieldDeclarationAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:586:1: ( (lv_type_2_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:587:1: (lv_type_2_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:587:1: (lv_type_2_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:588:3: lv_type_2_0= ruleDataTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getTypeDataTypeSpecifierParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1080);
            lv_type_2_0=ruleDataTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
            	        		"DataTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleRecordFieldDeclaration1090); 

                    createLeafNode(grammarAccess.getRecordFieldDeclarationAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRecordFieldDeclaration


    // $ANTLR start entryRuleFunctionDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:622:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:623:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:624:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1126);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();
            _fsp--;

             current =iv_ruleFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition1136); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFunctionDefinition


    // $ANTLR start ruleFunctionDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:631:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= RULE_ID ) ) ( '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertionStatements_18_0= ruleAssertionStatement ) ) | ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equationStatements_21_0= ruleEquationStatement ) ) )* '}' ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_stateful_0_0=null;
        Token lv_name_2_0=null;
        EObject lv_templateParameterDeclarations_4_0 = null;

        EObject lv_templateParameterDeclarations_6_0 = null;

        EObject lv_inputParameterDeclarations_9_0 = null;

        EObject lv_inputParameterDeclarations_11_0 = null;

        EObject lv_outputParameterDeclarations_14_0 = null;

        EObject lv_outputParameterDeclarations_16_0 = null;

        EObject lv_assertionStatements_18_0 = null;

        EObject lv_functorDeclarations_19_0 = null;

        EObject lv_stateVariableDeclarations_20_0 = null;

        EObject lv_equationStatements_21_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:636:6: ( ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= RULE_ID ) ) ( '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertionStatements_18_0= ruleAssertionStatement ) ) | ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equationStatements_21_0= ruleEquationStatement ) ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:637:1: ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= RULE_ID ) ) ( '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertionStatements_18_0= ruleAssertionStatement ) ) | ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equationStatements_21_0= ruleEquationStatement ) ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:637:1: ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= RULE_ID ) ) ( '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertionStatements_18_0= ruleAssertionStatement ) ) | ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equationStatements_21_0= ruleEquationStatement ) ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:637:2: ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= RULE_ID ) ) ( '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertionStatements_18_0= ruleAssertionStatement ) ) | ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equationStatements_21_0= ruleEquationStatement ) ) )* '}'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:637:2: ( (lv_stateful_0_0= 'stateful' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:638:1: (lv_stateful_0_0= 'stateful' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:638:1: (lv_stateful_0_0= 'stateful' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:639:3: lv_stateful_0_0= 'stateful'
                    {
                    lv_stateful_0_0=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleFunctionDefinition1179); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getStatefulStatefulKeyword_0_0(), "stateful"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "stateful", true, "stateful", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleFunctionDefinition1203); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getFuncKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:662:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:663:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:663:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:664:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionDefinition1220); 

            			createLeafNode(grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:686:2: ( '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:686:4: '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* '>'
                    {
                    match(input,23,FOLLOW_23_in_ruleFunctionDefinition1236); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLessThanSignKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:690:1: ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:691:1: (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:691:1: (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:692:3: lv_templateParameterDeclarations_4_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTemplateParameterDeclarationsParameterDeclarationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1257);
                    lv_templateParameterDeclarations_4_0=ruleParameterDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"templateParameterDeclarations",
                    	        		lv_templateParameterDeclarations_4_0, 
                    	        		"ParameterDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:714:2: ( ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==14) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:714:4: ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleFunctionDefinition1268); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:718:1: ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:719:1: (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:719:1: (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:720:3: lv_templateParameterDeclarations_6_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTemplateParameterDeclarationsParameterDeclarationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1289);
                    	    lv_templateParameterDeclarations_6_0=ruleParameterDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"templateParameterDeclarations",
                    	    	        		lv_templateParameterDeclarations_6_0, 
                    	    	        		"ParameterDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_ruleFunctionDefinition1301); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getGreaterThanSignKeyword_3_3(), null); 
                        

                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_ruleFunctionDefinition1313); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:750:1: ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:750:2: ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:750:2: ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:751:1: (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:751:1: (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:752:3: lv_inputParameterDeclarations_9_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getInputParameterDeclarationsParameterDeclarationParserRuleCall_5_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1335);
                    lv_inputParameterDeclarations_9_0=ruleParameterDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"inputParameterDeclarations",
                    	        		lv_inputParameterDeclarations_9_0, 
                    	        		"ParameterDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:774:2: ( ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==14) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:774:4: ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleFunctionDefinition1346); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_5_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:778:1: ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:779:1: (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:779:1: (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:780:3: lv_inputParameterDeclarations_11_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getInputParameterDeclarationsParameterDeclarationParserRuleCall_5_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1367);
                    	    lv_inputParameterDeclarations_11_0=ruleParameterDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"inputParameterDeclarations",
                    	    	        		lv_inputParameterDeclarations_11_0, 
                    	    	        		"ParameterDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_ruleFunctionDefinition1381); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_6(), null); 
                
            match(input,27,FOLLOW_27_in_ruleFunctionDefinition1391); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getHyphenMinusGreaterThanSignKeyword_7(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:810:1: ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:811:1: (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:811:1: (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:812:3: lv_outputParameterDeclarations_14_0= ruleParameterDeclaration
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getOutputParameterDeclarationsParameterDeclarationParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1412);
            lv_outputParameterDeclarations_14_0=ruleParameterDeclaration();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"outputParameterDeclarations",
            	        		lv_outputParameterDeclarations_14_0, 
            	        		"ParameterDeclaration", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:834:2: ( ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:834:4: ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleFunctionDefinition1423); 

            	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_9_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:838:1: ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:839:1: (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:839:1: (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:840:3: lv_outputParameterDeclarations_16_0= ruleParameterDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getOutputParameterDeclarationsParameterDeclarationParserRuleCall_9_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1444);
            	    lv_outputParameterDeclarations_16_0=ruleParameterDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"outputParameterDeclarations",
            	    	        		lv_outputParameterDeclarations_16_0, 
            	    	        		"ParameterDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleFunctionDefinition1456); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftCurlyBracketKeyword_10(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:866:1: ( ( (lv_assertionStatements_18_0= ruleAssertionStatement ) ) | ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equationStatements_21_0= ruleEquationStatement ) ) )*
            loop13:
            do {
                int alt13=5;
                switch ( input.LA(1) ) {
                case 28:
                case 29:
                    {
                    alt13=1;
                    }
                    break;
                case 31:
                    {
                    alt13=2;
                    }
                    break;
                case 30:
                    {
                    alt13=3;
                    }
                    break;
                case RULE_ID:
                case RULE_REAL:
                case RULE_INTEGER:
                case RULE_STRING:
                case 13:
                case 25:
                case 33:
                case 40:
                case 42:
                case 45:
                case 53:
                case 56:
                case 57:
                case 61:
                case 74:
                case 76:
                case 77:
                    {
                    alt13=4;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:866:2: ( (lv_assertionStatements_18_0= ruleAssertionStatement ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:866:2: ( (lv_assertionStatements_18_0= ruleAssertionStatement ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:867:1: (lv_assertionStatements_18_0= ruleAssertionStatement )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:867:1: (lv_assertionStatements_18_0= ruleAssertionStatement )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:868:3: lv_assertionStatements_18_0= ruleAssertionStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getAssertionStatementsAssertionStatementParserRuleCall_11_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssertionStatement_in_ruleFunctionDefinition1478);
            	    lv_assertionStatements_18_0=ruleAssertionStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"assertionStatements",
            	    	        		lv_assertionStatements_18_0, 
            	    	        		"AssertionStatement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:891:6: ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:891:6: ( (lv_functorDeclarations_19_0= ruleFunctorDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:892:1: (lv_functorDeclarations_19_0= ruleFunctorDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:892:1: (lv_functorDeclarations_19_0= ruleFunctorDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:893:3: lv_functorDeclarations_19_0= ruleFunctorDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctorDeclarationsFunctorDeclarationParserRuleCall_11_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFunctorDeclaration_in_ruleFunctionDefinition1505);
            	    lv_functorDeclarations_19_0=ruleFunctorDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"functorDeclarations",
            	    	        		lv_functorDeclarations_19_0, 
            	    	        		"FunctorDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:916:6: ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:916:6: ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:917:1: (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:917:1: (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:918:3: lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getStateVariableDeclarationsStateVariableDeclarationParserRuleCall_11_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStateVariableDeclaration_in_ruleFunctionDefinition1532);
            	    lv_stateVariableDeclarations_20_0=ruleStateVariableDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"stateVariableDeclarations",
            	    	        		lv_stateVariableDeclarations_20_0, 
            	    	        		"StateVariableDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:941:6: ( (lv_equationStatements_21_0= ruleEquationStatement ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:941:6: ( (lv_equationStatements_21_0= ruleEquationStatement ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:942:1: (lv_equationStatements_21_0= ruleEquationStatement )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:942:1: (lv_equationStatements_21_0= ruleEquationStatement )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:943:3: lv_equationStatements_21_0= ruleEquationStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getEquationStatementsEquationStatementParserRuleCall_11_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquationStatement_in_ruleFunctionDefinition1559);
            	    lv_equationStatements_21_0=ruleEquationStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"equationStatements",
            	    	        		lv_equationStatements_21_0, 
            	    	        		"EquationStatement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleFunctionDefinition1571); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightCurlyBracketKeyword_12(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFunctionDefinition


    // $ANTLR start entryRuleParameterDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:977:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:978:2: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:979:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1607);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();
            _fsp--;

             current =iv_ruleParameterDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterDeclaration1617); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParameterDeclaration


    // $ANTLR start ruleParameterDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:986:1: ruleParameterDeclaration returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:991:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:992:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:992:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:993:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:993:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:994:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameterDeclaration1658); 

            			createLeafNode(grammarAccess.getParameterDeclarationAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParameterDeclaration


    // $ANTLR start entryRuleAssertionStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1024:1: entryRuleAssertionStatement returns [EObject current=null] : iv_ruleAssertionStatement= ruleAssertionStatement EOF ;
    public final EObject entryRuleAssertionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertionStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1025:2: (iv_ruleAssertionStatement= ruleAssertionStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1026:2: iv_ruleAssertionStatement= ruleAssertionStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssertionStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssertionStatement_in_entryRuleAssertionStatement1698);
            iv_ruleAssertionStatement=ruleAssertionStatement();
            _fsp--;

             current =iv_ruleAssertionStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertionStatement1708); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAssertionStatement


    // $ANTLR start ruleAssertionStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1033:1: ruleAssertionStatement returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? 'assert' ( (lv_condition_2_0= ruleExpression ) ) ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleAssertionStatement() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        EObject lv_condition_2_0 = null;

        Enumerator lv_statusKind_4_0 = null;

        EObject lv_message_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1038:6: ( ( ( (lv_static_0_0= 'static' ) )? 'assert' ( (lv_condition_2_0= ruleExpression ) ) ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:1: ( ( (lv_static_0_0= 'static' ) )? 'assert' ( (lv_condition_2_0= ruleExpression ) ) ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:1: ( ( (lv_static_0_0= 'static' ) )? 'assert' ( (lv_condition_2_0= ruleExpression ) ) ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:2: ( (lv_static_0_0= 'static' ) )? 'assert' ( (lv_condition_2_0= ruleExpression ) ) ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:2: ( (lv_static_0_0= 'static' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1040:1: (lv_static_0_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1040:1: (lv_static_0_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1041:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleAssertionStatement1751); 

                            createLeafNode(grammarAccess.getAssertionStatementAccess().getStaticStaticKeyword_0_0(), "static"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAssertionStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "static", true, "static", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,29,FOLLOW_29_in_ruleAssertionStatement1775); 

                    createLeafNode(grammarAccess.getAssertionStatementAccess().getAssertKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1064:1: ( (lv_condition_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1065:1: (lv_condition_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1065:1: (lv_condition_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1066:3: lv_condition_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssertionStatementAccess().getConditionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssertionStatement1796);
            lv_condition_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssertionStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,20,FOLLOW_20_in_ruleAssertionStatement1806); 

                    createLeafNode(grammarAccess.getAssertionStatementAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1092:1: ( (lv_statusKind_4_0= ruleAssertionStatusKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1093:1: (lv_statusKind_4_0= ruleAssertionStatusKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1093:1: (lv_statusKind_4_0= ruleAssertionStatusKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1094:3: lv_statusKind_4_0= ruleAssertionStatusKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssertionStatementAccess().getStatusKindAssertionStatusKindEnumRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssertionStatusKind_in_ruleAssertionStatement1827);
            lv_statusKind_4_0=ruleAssertionStatusKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssertionStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"statusKind",
            	        		lv_statusKind_4_0, 
            	        		"AssertionStatusKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1116:2: ( (lv_message_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1117:1: (lv_message_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1117:1: (lv_message_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1118:3: lv_message_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssertionStatementAccess().getMessageExpressionParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssertionStatement1848);
            lv_message_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssertionStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"message",
            	        		lv_message_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleAssertionStatement1858); 

                    createLeafNode(grammarAccess.getAssertionStatementAccess().getSemicolonKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssertionStatement


    // $ANTLR start entryRuleStateVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1152:1: entryRuleStateVariableDeclaration returns [EObject current=null] : iv_ruleStateVariableDeclaration= ruleStateVariableDeclaration EOF ;
    public final EObject entryRuleStateVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1153:2: (iv_ruleStateVariableDeclaration= ruleStateVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1154:2: iv_ruleStateVariableDeclaration= ruleStateVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateVariableDeclaration_in_entryRuleStateVariableDeclaration1894);
            iv_ruleStateVariableDeclaration=ruleStateVariableDeclaration();
            _fsp--;

             current =iv_ruleStateVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateVariableDeclaration1904); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStateVariableDeclaration


    // $ANTLR start ruleStateVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1161:1: ruleStateVariableDeclaration returns [EObject current=null] : ( 'var' ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleStateVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1166:6: ( ( 'var' ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1167:1: ( 'var' ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1167:1: ( 'var' ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1167:3: 'var' ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            match(input,30,FOLLOW_30_in_ruleStateVariableDeclaration1939); 

                    createLeafNode(grammarAccess.getStateVariableDeclarationAccess().getVarKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1171:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1172:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1172:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1173:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateVariableDeclaration1956); 

            			createLeafNode(grammarAccess.getStateVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStateVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleStateVariableDeclaration1971); 

                    createLeafNode(grammarAccess.getStateVariableDeclarationAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateVariableDeclaration


    // $ANTLR start entryRuleFunctorDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1207:1: entryRuleFunctorDeclaration returns [EObject current=null] : iv_ruleFunctorDeclaration= ruleFunctorDeclaration EOF ;
    public final EObject entryRuleFunctorDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctorDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1208:2: (iv_ruleFunctorDeclaration= ruleFunctorDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1209:2: iv_ruleFunctorDeclaration= ruleFunctorDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctorDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctorDeclaration_in_entryRuleFunctorDeclaration2007);
            iv_ruleFunctorDeclaration=ruleFunctorDeclaration();
            _fsp--;

             current =iv_ruleFunctorDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctorDeclaration2017); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFunctorDeclaration


    // $ANTLR start ruleFunctorDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1216:1: ruleFunctorDeclaration returns [EObject current=null] : ( 'functor' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' ) ;
    public final EObject ruleFunctorDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_functionName_3_0 = null;

        EObject lv_templateArgumentDeclarations_5_0 = null;

        EObject lv_templateArgumentDeclarations_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1221:6: ( ( 'functor' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1222:1: ( 'functor' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1222:1: ( 'functor' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1222:3: 'functor' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';'
            {
            match(input,31,FOLLOW_31_in_ruleFunctorDeclaration2052); 

                    createLeafNode(grammarAccess.getFunctorDeclarationAccess().getFunctorKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1226:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1227:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1227:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1228:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctorDeclaration2069); 

            			createLeafNode(grammarAccess.getFunctorDeclarationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,20,FOLLOW_20_in_ruleFunctorDeclaration2084); 

                    createLeafNode(grammarAccess.getFunctorDeclarationAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1254:1: ( (lv_functionName_3_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1255:1: (lv_functionName_3_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1255:1: (lv_functionName_3_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1256:3: lv_functionName_3_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getFunctionNameQualifiedNameParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFunctorDeclaration2105);
            lv_functionName_3_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"functionName",
            	        		lv_functionName_3_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1278:2: ( '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1278:4: '<' ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )* '>'
                    {
                    match(input,23,FOLLOW_23_in_ruleFunctorDeclaration2116); 

                            createLeafNode(grammarAccess.getFunctorDeclarationAccess().getLessThanSignKeyword_4_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1282:1: ( (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1283:1: (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1283:1: (lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1284:3: lv_templateArgumentDeclarations_5_0= ruleArgumentDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getTemplateArgumentDeclarationsArgumentDeclarationParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2137);
                    lv_templateArgumentDeclarations_5_0=ruleArgumentDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"templateArgumentDeclarations",
                    	        		lv_templateArgumentDeclarations_5_0, 
                    	        		"ArgumentDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1306:2: ( ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==14) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1306:4: ',' ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleFunctorDeclaration2148); 

                    	            createLeafNode(grammarAccess.getFunctorDeclarationAccess().getCommaKeyword_4_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1310:1: ( (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1311:1: (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1311:1: (lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1312:3: lv_templateArgumentDeclarations_7_0= ruleArgumentDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getTemplateArgumentDeclarationsArgumentDeclarationParserRuleCall_4_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2169);
                    	    lv_templateArgumentDeclarations_7_0=ruleArgumentDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"templateArgumentDeclarations",
                    	    	        		lv_templateArgumentDeclarations_7_0, 
                    	    	        		"ArgumentDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_ruleFunctorDeclaration2181); 

                            createLeafNode(grammarAccess.getFunctorDeclarationAccess().getGreaterThanSignKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleFunctorDeclaration2193); 

                    createLeafNode(grammarAccess.getFunctorDeclarationAccess().getSemicolonKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFunctorDeclaration


    // $ANTLR start entryRuleArgumentDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1350:1: entryRuleArgumentDeclaration returns [EObject current=null] : iv_ruleArgumentDeclaration= ruleArgumentDeclaration EOF ;
    public final EObject entryRuleArgumentDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1351:2: (iv_ruleArgumentDeclaration= ruleArgumentDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1352:2: iv_ruleArgumentDeclaration= ruleArgumentDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArgumentDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleArgumentDeclaration_in_entryRuleArgumentDeclaration2229);
            iv_ruleArgumentDeclaration=ruleArgumentDeclaration();
            _fsp--;

             current =iv_ruleArgumentDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentDeclaration2239); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArgumentDeclaration


    // $ANTLR start ruleArgumentDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1359:1: ruleArgumentDeclaration returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleArgumentDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1364:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1365:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1365:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1366:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1366:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1367:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArgumentDeclaration2280); 

            			createLeafNode(grammarAccess.getArgumentDeclarationAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArgumentDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArgumentDeclaration


    // $ANTLR start entryRuleEquationStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1397:1: entryRuleEquationStatement returns [EObject current=null] : iv_ruleEquationStatement= ruleEquationStatement EOF ;
    public final EObject entryRuleEquationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquationStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1398:2: (iv_ruleEquationStatement= ruleEquationStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1399:2: iv_ruleEquationStatement= ruleEquationStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEquationStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleEquationStatement_in_entryRuleEquationStatement2320);
            iv_ruleEquationStatement=ruleEquationStatement();
            _fsp--;

             current =iv_ruleEquationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquationStatement2330); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEquationStatement


    // $ANTLR start ruleEquationStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1406:1: ruleEquationStatement returns [EObject current=null] : ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleEquationStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_leftHandSide_0_0 = null;

        EObject lv_rightHandSide_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1411:6: ( ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1412:1: ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1412:1: ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1412:2: ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1412:2: ( (lv_leftHandSide_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1413:1: (lv_leftHandSide_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1413:1: (lv_leftHandSide_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1414:3: lv_leftHandSide_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEquationStatementAccess().getLeftHandSideExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEquationStatement2376);
            lv_leftHandSide_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEquationStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"leftHandSide",
            	        		lv_leftHandSide_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEquationStatement2386); 

                    createLeafNode(grammarAccess.getEquationStatementAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1440:1: ( (lv_rightHandSide_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1441:1: (lv_rightHandSide_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1441:1: (lv_rightHandSide_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1442:3: lv_rightHandSide_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEquationStatementAccess().getRightHandSideExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEquationStatement2407);
            lv_rightHandSide_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEquationStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rightHandSide",
            	        		lv_rightHandSide_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleEquationStatement2417); 

                    createLeafNode(grammarAccess.getEquationStatementAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEquationStatement


    // $ANTLR start entryRuleDataTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1476:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1477:2: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1478:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2453);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();
            _fsp--;

             current =iv_ruleDataTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeSpecifier2463); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDataTypeSpecifier


    // $ANTLR start ruleDataTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1485:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeSpecifier_0 = null;

        EObject this_NamedTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:6: ( (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32||(LA17_0>=35 && LA17_0<=39)) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1491:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1492:5: this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPrimitiveTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2510);
                    this_PrimitiveTypeSpecifier_0=rulePrimitiveTypeSpecifier();
                    _fsp--;

                     
                            current = this_PrimitiveTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1502:5: this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getNamedTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2537);
                    this_NamedTypeSpecifier_1=ruleNamedTypeSpecifier();
                    _fsp--;

                     
                            current = this_NamedTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDataTypeSpecifier


    // $ANTLR start entryRulePrimitiveTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1518:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1519:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1520:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2572);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();
            _fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2582); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePrimitiveTypeSpecifier


    // $ANTLR start rulePrimitiveTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1527:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1532:6: ( (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1533:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1533:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 32:
            case 35:
            case 36:
            case 37:
                {
                alt18=1;
                }
                break;
            case 38:
                {
                alt18=2;
                }
                break;
            case 39:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1533:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1534:5: this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericTypeSpecifier_in_rulePrimitiveTypeSpecifier2629);
                    this_NumericTypeSpecifier_0=ruleNumericTypeSpecifier();
                    _fsp--;

                     
                            current = this_NumericTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1544:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2656);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();
                    _fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1554:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2683);
                    this_StringTypeSpecifier_2=ruleStringTypeSpecifier();
                    _fsp--;

                     
                            current = this_StringTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimitiveTypeSpecifier


    // $ANTLR start entryRuleNumericTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1570:1: entryRuleNumericTypeSpecifier returns [EObject current=null] : iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF ;
    public final EObject entryRuleNumericTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1571:2: (iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1572:2: iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericTypeSpecifier_in_entryRuleNumericTypeSpecifier2718);
            iv_ruleNumericTypeSpecifier=ruleNumericTypeSpecifier();
            _fsp--;

             current =iv_ruleNumericTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericTypeSpecifier2728); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNumericTypeSpecifier


    // $ANTLR start ruleNumericTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1579:1: ruleNumericTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) ;
    public final EObject ruleNumericTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;

        EObject this_ComplexTypeSpecifier_2 = null;

        EObject this_GaussianTypeSpecifier_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1584:6: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1585:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1585:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt19=1;
                }
                break;
            case 35:
                {
                alt19=2;
                }
                break;
            case 36:
                {
                alt19=3;
                }
                break;
            case 37:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1585:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1586:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericTypeSpecifier2775);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();
                    _fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1596:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericTypeSpecifier2802);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();
                    _fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1606:5: this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getComplexTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericTypeSpecifier2829);
                    this_ComplexTypeSpecifier_2=ruleComplexTypeSpecifier();
                    _fsp--;

                     
                            current = this_ComplexTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1616:5: this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getGaussianTypeSpecifierParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericTypeSpecifier2856);
                    this_GaussianTypeSpecifier_3=ruleGaussianTypeSpecifier();
                    _fsp--;

                     
                            current = this_GaussianTypeSpecifier_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNumericTypeSpecifier


    // $ANTLR start entryRuleRealTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1632:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1633:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1634:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier2891);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();
            _fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier2901); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRealTypeSpecifier


    // $ANTLR start ruleRealTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1641:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1646:6: ( ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1647:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1647:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1647:2: () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1647:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1648:5: 
            {
             
                    temp=factory.create(grammarAccess.getRealTypeSpecifierAccess().getRealTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getRealTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,32,FOLLOW_32_in_ruleRealTypeSpecifier2945); 

                    createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1662:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1662:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleRealTypeSpecifier2956); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1666:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1667:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1667:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1668:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier2977);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleRealTypeSpecifier2987); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1694:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1694:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleRealTypeSpecifier3000); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1698:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1699:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1699:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3021);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1722:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==14) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1722:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleRealTypeSpecifier3032); 

                    	            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1726:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1727:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1727:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1728:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3053);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getRealTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleRealTypeSpecifier3065); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRealTypeSpecifier


    // $ANTLR start entryRuleIntegerTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1762:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1763:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1764:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier3103);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();
            _fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier3113); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIntegerTypeSpecifier


    // $ANTLR start ruleIntegerTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1771:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1776:6: ( ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1777:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1777:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1777:2: () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1777:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1778:5: 
            {
             
                    temp=factory.create(grammarAccess.getIntegerTypeSpecifierAccess().getIntegerTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntegerTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,35,FOLLOW_35_in_ruleIntegerTypeSpecifier3157); 

                    createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1792:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1792:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleIntegerTypeSpecifier3168); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1796:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1797:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1797:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1798:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier3189);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleIntegerTypeSpecifier3199); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1824:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1824:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleIntegerTypeSpecifier3212); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1828:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1829:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1829:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1830:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3233);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1852:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==14) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1852:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleIntegerTypeSpecifier3244); 

                    	            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1856:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1857:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1857:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1858:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3265);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getIntegerTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleIntegerTypeSpecifier3277); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIntegerTypeSpecifier


    // $ANTLR start entryRuleComplexTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1892:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1893:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1894:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier3315);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();
            _fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier3325); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleComplexTypeSpecifier


    // $ANTLR start ruleComplexTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1901:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1906:6: ( ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1907:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1907:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1907:2: () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1907:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1908:5: 
            {
             
                    temp=factory.create(grammarAccess.getComplexTypeSpecifierAccess().getComplexTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,36,FOLLOW_36_in_ruleComplexTypeSpecifier3369); 

                    createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleComplexTypeSpecifier3380); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1926:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1927:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1927:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1928:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3401);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleComplexTypeSpecifier3411); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1954:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1954:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleComplexTypeSpecifier3424); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1958:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1959:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1959:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1960:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3445);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1982:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==14) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1982:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleComplexTypeSpecifier3456); 

                    	            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1986:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1987:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1987:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1988:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3477);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleComplexTypeSpecifier3489); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComplexTypeSpecifier


    // $ANTLR start entryRuleGaussianTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2022:1: entryRuleGaussianTypeSpecifier returns [EObject current=null] : iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF ;
    public final EObject entryRuleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGaussianTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2023:2: (iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2024:2: iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3527);
            iv_ruleGaussianTypeSpecifier=ruleGaussianTypeSpecifier();
            _fsp--;

             current =iv_ruleGaussianTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3537); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGaussianTypeSpecifier


    // $ANTLR start ruleGaussianTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2031:1: ruleGaussianTypeSpecifier returns [EObject current=null] : ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2036:6: ( ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2037:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2037:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2037:2: () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2037:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2038:5: 
            {
             
                    temp=factory.create(grammarAccess.getGaussianTypeSpecifierAccess().getGaussianTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussianTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,37,FOLLOW_37_in_ruleGaussianTypeSpecifier3581); 

                    createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2052:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2052:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleGaussianTypeSpecifier3592); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2056:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2057:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2057:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2058:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3613);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGaussianTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleGaussianTypeSpecifier3623); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2084:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2084:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleGaussianTypeSpecifier3636); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2088:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2089:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2089:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2090:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3657);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGaussianTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2112:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==14) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2112:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleGaussianTypeSpecifier3668); 

                    	            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2116:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2117:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2117:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2118:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3689);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGaussianTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleGaussianTypeSpecifier3701); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGaussianTypeSpecifier


    // $ANTLR start entryRuleBooleanTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2152:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2153:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2154:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3739);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();
            _fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3749); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanTypeSpecifier


    // $ANTLR start ruleBooleanTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2161:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2166:6: ( ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2167:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2167:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2167:2: () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2167:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2168:5: 
            {
             
                    temp=factory.create(grammarAccess.getBooleanTypeSpecifierAccess().getBooleanTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getBooleanTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,38,FOLLOW_38_in_ruleBooleanTypeSpecifier3793); 

                    createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getBoolKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2182:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==33) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2182:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleBooleanTypeSpecifier3804); 

                            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2186:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2187:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2187:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2188:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3825);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBooleanTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_3_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2210:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==14) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2210:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleBooleanTypeSpecifier3836); 

                    	            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2214:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2215:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2215:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2216:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3857);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBooleanTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_5_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleBooleanTypeSpecifier3869); 

                            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getRightSquareBracketKeyword_2_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanTypeSpecifier


    // $ANTLR start entryRuleStringTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2250:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2251:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2252:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier3907);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();
            _fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier3917); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStringTypeSpecifier


    // $ANTLR start ruleStringTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2259:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2264:6: ( ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2265:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2265:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2265:2: () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2265:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2266:5: 
            {
             
                    temp=factory.create(grammarAccess.getStringTypeSpecifierAccess().getStringTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getStringTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,39,FOLLOW_39_in_ruleStringTypeSpecifier3961); 

                    createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getStringKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2280:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2280:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleStringTypeSpecifier3972); 

                            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2284:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2285:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2285:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2286:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier3993);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStringTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_3_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2308:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==14) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2308:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleStringTypeSpecifier4004); 

                    	            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2312:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2313:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2313:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2314:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4025);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getStringTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_5_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleStringTypeSpecifier4037); 

                            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getRightSquareBracketKeyword_2_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringTypeSpecifier


    // $ANTLR start entryRuleNamedTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2348:1: entryRuleNamedTypeSpecifier returns [EObject current=null] : iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF ;
    public final EObject entryRuleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2349:2: (iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2350:2: iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier4075);
            iv_ruleNamedTypeSpecifier=ruleNamedTypeSpecifier();
            _fsp--;

             current =iv_ruleNamedTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTypeSpecifier4085); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNamedTypeSpecifier


    // $ANTLR start ruleNamedTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2357:1: ruleNamedTypeSpecifier returns [EObject current=null] : ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_0_0 = null;

        EObject lv_dimensions_2_0 = null;

        EObject lv_dimensions_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2362:6: ( ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2363:1: ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2363:1: ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2363:2: ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2363:2: ( (lv_typeReference_0_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2364:1: (lv_typeReference_0_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2364:1: (lv_typeReference_0_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2365:3: lv_typeReference_0_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getTypeReferenceQualifiedNameParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier4131);
            lv_typeReference_0_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"typeReference",
            	        		lv_typeReference_0_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2387:2: ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2387:4: '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleNamedTypeSpecifier4142); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2391:1: ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2392:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2392:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2393:3: lv_dimensions_2_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4163);
                    lv_dimensions_2_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_2_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2415:2: ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==14) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2415:4: ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleNamedTypeSpecifier4174); 

                    	            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getCommaKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2419:1: ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2420:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2420:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2421:3: lv_dimensions_4_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4195);
                    	    lv_dimensions_4_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_4_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleNamedTypeSpecifier4207); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getRightSquareBracketKeyword_1_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamedTypeSpecifier


    // $ANTLR start entryRuleArrayDimensionSpecification
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2455:1: entryRuleArrayDimensionSpecification returns [EObject current=null] : iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF ;
    public final EObject entryRuleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayDimensionSpecification = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2456:2: (iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2457:2: iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayDimensionSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification4245);
            iv_ruleArrayDimensionSpecification=ruleArrayDimensionSpecification();
            _fsp--;

             current =iv_ruleArrayDimensionSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayDimensionSpecification4255); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArrayDimensionSpecification


    // $ANTLR start ruleArrayDimensionSpecification
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2464:1: ruleArrayDimensionSpecification returns [EObject current=null] : ( () ( (lv_size_1_0= ruleExpression ) )? ) ;
    public final EObject ruleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_size_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2469:6: ( ( () ( (lv_size_1_0= ruleExpression ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:1: ( () ( (lv_size_1_0= ruleExpression ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:1: ( () ( (lv_size_1_0= ruleExpression ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:2: () ( (lv_size_1_0= ruleExpression ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2471:5: 
            {
             
                    temp=factory.create(grammarAccess.getArrayDimensionSpecificationAccess().getArrayDimensionSpecificationAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getArrayDimensionSpecificationAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2481:2: ( (lv_size_1_0= ruleExpression ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)||LA38_0==13||LA38_0==25||LA38_0==33||LA38_0==40||LA38_0==42||LA38_0==45||LA38_0==53||(LA38_0>=56 && LA38_0<=57)||LA38_0==61||LA38_0==74||(LA38_0>=76 && LA38_0<=77)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2482:1: (lv_size_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2482:1: (lv_size_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2483:3: lv_size_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getSizeExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification4310);
                    lv_size_1_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArrayDimensionSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"size",
                    	        		lv_size_1_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayDimensionSpecification


    // $ANTLR start entryRuleExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2513:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2514:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2515:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4347);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4357); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2522:1: ruleExpression returns [EObject current=null] : (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LetExpression_0 = null;

        EObject this_IfExpression_1 = null;

        EObject this_SwitchExpression_2 = null;

        EObject this_RangeExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2527:6: ( (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2528:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2528:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )
            int alt39=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt39=1;
                }
                break;
            case 42:
                {
                alt39=2;
                }
                break;
            case 45:
                {
                alt39=3;
                }
                break;
            case RULE_ID:
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 13:
            case 25:
            case 33:
            case 53:
            case 56:
            case 57:
            case 61:
            case 74:
            case 76:
            case 77:
                {
                alt39=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2528:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2529:5: this_LetExpression_0= ruleLetExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getLetExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLetExpression_in_ruleExpression4404);
                    this_LetExpression_0=ruleLetExpression();
                    _fsp--;

                     
                            current = this_LetExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2539:5: this_IfExpression_1= ruleIfExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIfExpression_in_ruleExpression4431);
                    this_IfExpression_1=ruleIfExpression();
                    _fsp--;

                     
                            current = this_IfExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2549:5: this_SwitchExpression_2= ruleSwitchExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getSwitchExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSwitchExpression_in_ruleExpression4458);
                    this_SwitchExpression_2=ruleSwitchExpression();
                    _fsp--;

                     
                            current = this_SwitchExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2559:5: this_RangeExpression_3= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression4485);
                    this_RangeExpression_3=ruleRangeExpression();
                    _fsp--;

                     
                            current = this_RangeExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleLetExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2575:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2576:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2577:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLetExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLetExpression_in_entryRuleLetExpression4520);
            iv_ruleLetExpression=ruleLetExpression();
            _fsp--;

             current =iv_ruleLetExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpression4530); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLetExpression


    // $ANTLR start ruleLetExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2584:1: ruleLetExpression returns [EObject current=null] : ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_variables_1_0 = null;

        EObject lv_variables_3_0 = null;

        EObject lv_targetExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2589:6: ( ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2590:1: ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2590:1: ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2590:3: 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) )
            {
            match(input,40,FOLLOW_40_in_ruleLetExpression4565); 

                    createLeafNode(grammarAccess.getLetExpressionAccess().getLetKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2594:1: ( (lv_variables_1_0= ruleLetExpressionVariable ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2595:1: (lv_variables_1_0= ruleLetExpressionVariable )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2595:1: (lv_variables_1_0= ruleLetExpressionVariable )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2596:3: lv_variables_1_0= ruleLetExpressionVariable
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionAccess().getVariablesLetExpressionVariableParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4586);
            lv_variables_1_0=ruleLetExpressionVariable();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"variables",
            	        		lv_variables_1_0, 
            	        		"LetExpressionVariable", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2618:2: ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==14) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2618:4: ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleLetExpression4597); 

            	            createLeafNode(grammarAccess.getLetExpressionAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2622:1: ( (lv_variables_3_0= ruleLetExpressionVariable ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2623:1: (lv_variables_3_0= ruleLetExpressionVariable )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2623:1: (lv_variables_3_0= ruleLetExpressionVariable )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2624:3: lv_variables_3_0= ruleLetExpressionVariable
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLetExpressionAccess().getVariablesLetExpressionVariableParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4618);
            	    lv_variables_3_0=ruleLetExpressionVariable();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLetExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"variables",
            	    	        		lv_variables_3_0, 
            	    	        		"LetExpressionVariable", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            match(input,41,FOLLOW_41_in_ruleLetExpression4630); 

                    createLeafNode(grammarAccess.getLetExpressionAccess().getInKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2650:1: ( (lv_targetExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2651:1: (lv_targetExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2651:1: (lv_targetExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2652:3: lv_targetExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionAccess().getTargetExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression4651);
            lv_targetExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"targetExpression",
            	        		lv_targetExpression_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLetExpression


    // $ANTLR start entryRuleLetExpressionVariable
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2682:1: entryRuleLetExpressionVariable returns [EObject current=null] : iv_ruleLetExpressionVariable= ruleLetExpressionVariable EOF ;
    public final EObject entryRuleLetExpressionVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpressionVariable = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2683:2: (iv_ruleLetExpressionVariable= ruleLetExpressionVariable EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2684:2: iv_ruleLetExpressionVariable= ruleLetExpressionVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLetExpressionVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleLetExpressionVariable_in_entryRuleLetExpressionVariable4687);
            iv_ruleLetExpressionVariable=ruleLetExpressionVariable();
            _fsp--;

             current =iv_ruleLetExpressionVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpressionVariable4697); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLetExpressionVariable


    // $ANTLR start ruleLetExpressionVariable
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2691:1: ruleLetExpressionVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpressionVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_assignedExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2696:6: ( ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2697:1: ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2697:1: ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2697:2: ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2697:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2698:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2698:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2699:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLetExpressionVariable4739); 

            			createLeafNode(grammarAccess.getLetExpressionVariableAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleLetExpressionVariable4754); 

                    createLeafNode(grammarAccess.getLetExpressionVariableAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2725:1: ( (lv_assignedExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2726:1: (lv_assignedExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2726:1: (lv_assignedExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2727:3: lv_assignedExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionVariableAccess().getAssignedExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpressionVariable4775);
            lv_assignedExpression_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"assignedExpression",
            	        		lv_assignedExpression_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLetExpressionVariable


    // $ANTLR start entryRuleIfExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2757:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2758:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2759:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression4811);
            iv_ruleIfExpression=ruleIfExpression();
            _fsp--;

             current =iv_ruleIfExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression4821); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIfExpression


    // $ANTLR start ruleIfExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2766:1: ruleIfExpression returns [EObject current=null] : ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2771:6: ( ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2772:1: ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2772:1: ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2772:3: 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,42,FOLLOW_42_in_ruleIfExpression4856); 

                    createLeafNode(grammarAccess.getIfExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2776:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2777:1: (lv_condition_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2777:1: (lv_condition_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2778:3: lv_condition_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getConditionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression4877);
            lv_condition_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,43,FOLLOW_43_in_ruleIfExpression4887); 

                    createLeafNode(grammarAccess.getIfExpressionAccess().getThenKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2804:1: ( (lv_thenExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2805:1: (lv_thenExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2805:1: (lv_thenExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2806:3: lv_thenExpression_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression4908);
            lv_thenExpression_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"thenExpression",
            	        		lv_thenExpression_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,44,FOLLOW_44_in_ruleIfExpression4918); 

                    createLeafNode(grammarAccess.getIfExpressionAccess().getElseKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2832:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2833:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2833:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2834:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionExpressionParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression4939);
            lv_elseExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"elseExpression",
            	        		lv_elseExpression_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIfExpression


    // $ANTLR start entryRuleSwitchExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2864:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2865:2: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2866:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSwitchExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression4975);
            iv_ruleSwitchExpression=ruleSwitchExpression();
            _fsp--;

             current =iv_ruleSwitchExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchExpression4985); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSwitchExpression


    // $ANTLR start ruleSwitchExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2873:1: ruleSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_controlExpression_1_0 = null;

        EObject lv_cases_2_0 = null;

        EObject lv_defaultExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2878:6: ( ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2879:1: ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2879:1: ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2879:3: 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) )
            {
            match(input,45,FOLLOW_45_in_ruleSwitchExpression5020); 

                    createLeafNode(grammarAccess.getSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2883:1: ( (lv_controlExpression_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2884:1: (lv_controlExpression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2884:1: (lv_controlExpression_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2885:3: lv_controlExpression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getControlExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression5041);
            lv_controlExpression_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"controlExpression",
            	        		lv_controlExpression_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2907:2: ( (lv_cases_2_0= ruleSwitchCase ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==47) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2908:1: (lv_cases_2_0= ruleSwitchCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2908:1: (lv_cases_2_0= ruleSwitchCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2909:3: lv_cases_2_0= ruleSwitchCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getCasesSwitchCaseParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchExpression5062);
            	    lv_cases_2_0=ruleSwitchCase();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"cases",
            	    	        		lv_cases_2_0, 
            	    	        		"SwitchCase", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            match(input,46,FOLLOW_46_in_ruleSwitchExpression5073); 

                    createLeafNode(grammarAccess.getSwitchExpressionAccess().getDefaultKeyword_3(), null); 
                
            match(input,20,FOLLOW_20_in_ruleSwitchExpression5083); 

                    createLeafNode(grammarAccess.getSwitchExpressionAccess().getColonKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2939:1: ( (lv_defaultExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2940:1: (lv_defaultExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2940:1: (lv_defaultExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2941:3: lv_defaultExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionExpressionParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression5104);
            lv_defaultExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"defaultExpression",
            	        		lv_defaultExpression_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSwitchExpression


    // $ANTLR start entryRuleSwitchCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2971:1: entryRuleSwitchCase returns [EObject current=null] : iv_ruleSwitchCase= ruleSwitchCase EOF ;
    public final EObject entryRuleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2972:2: (iv_ruleSwitchCase= ruleSwitchCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2973:2: iv_ruleSwitchCase= ruleSwitchCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSwitchCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase5140);
            iv_ruleSwitchCase=ruleSwitchCase();
            _fsp--;

             current =iv_ruleSwitchCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchCase5150); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSwitchCase


    // $ANTLR start ruleSwitchCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2980:1: ruleSwitchCase returns [EObject current=null] : ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject lv_caseExpression_1_0 = null;

        EObject lv_resultExpression_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2985:6: ( ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2986:1: ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2986:1: ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2986:3: 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) )
            {
            match(input,47,FOLLOW_47_in_ruleSwitchCase5185); 

                    createLeafNode(grammarAccess.getSwitchCaseAccess().getCaseKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2990:1: ( (lv_caseExpression_1_0= ruleImpliesExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2991:1: (lv_caseExpression_1_0= ruleImpliesExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2991:1: (lv_caseExpression_1_0= ruleImpliesExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2992:3: lv_caseExpression_1_0= ruleImpliesExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchCaseAccess().getCaseExpressionImpliesExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleSwitchCase5206);
            lv_caseExpression_1_0=ruleImpliesExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"caseExpression",
            	        		lv_caseExpression_1_0, 
            	        		"ImpliesExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,20,FOLLOW_20_in_ruleSwitchCase5216); 

                    createLeafNode(grammarAccess.getSwitchCaseAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3018:1: ( (lv_resultExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3019:1: (lv_resultExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3019:1: (lv_resultExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3020:3: lv_resultExpression_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchCaseAccess().getResultExpressionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchCase5237);
            lv_resultExpression_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"resultExpression",
            	        		lv_resultExpression_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSwitchCase


    // $ANTLR start entryRuleRangeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3050:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3051:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3052:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression5273);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression5283); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRangeExpression


    // $ANTLR start ruleRangeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3059:1: ruleRangeExpression returns [EObject current=null] : (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpression_0 = null;

        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3064:6: ( (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3065:1: (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3065:1: (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3066:5: this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getImpliesExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5330);
            this_ImpliesExpression_0=ruleImpliesExpression();
            _fsp--;

             
                    current = this_ImpliesExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3074:1: ( () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==20) ) {
                int LA43_1 = input.LA(2);

                if ( ((LA43_1>=RULE_ID && LA43_1<=RULE_STRING)||LA43_1==13||LA43_1==25||LA43_1==33||LA43_1==53||(LA43_1>=56 && LA43_1<=57)||LA43_1==61||LA43_1==74||(LA43_1>=76 && LA43_1<=77)) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3074:2: () ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3074:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3075:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRangeExpressionAccess().getRangeExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRangeExpressionAccess().getRangeExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,20,FOLLOW_20_in_ruleRangeExpression5349); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3094:1: ( (lv_operands_3_0= ruleImpliesExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3095:1: (lv_operands_3_0= ruleImpliesExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3095:1: (lv_operands_3_0= ruleImpliesExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3096:3: lv_operands_3_0= ruleImpliesExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getOperandsImpliesExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5370);
                    lv_operands_3_0=ruleImpliesExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"operands",
                    	        		lv_operands_3_0, 
                    	        		"ImpliesExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3118:2: ( ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==20) ) {
                        int LA42_1 = input.LA(2);

                        if ( ((LA42_1>=RULE_ID && LA42_1<=RULE_STRING)||LA42_1==13||LA42_1==25||LA42_1==33||LA42_1==53||(LA42_1>=56 && LA42_1<=57)||LA42_1==61||LA42_1==74||(LA42_1>=76 && LA42_1<=77)) ) {
                            alt42=1;
                        }
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3118:4: ':' ( (lv_operands_5_0= ruleImpliesExpression ) )
                            {
                            match(input,20,FOLLOW_20_in_ruleRangeExpression5381); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_0(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3122:1: ( (lv_operands_5_0= ruleImpliesExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3123:1: (lv_operands_5_0= ruleImpliesExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3123:1: (lv_operands_5_0= ruleImpliesExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3124:3: lv_operands_5_0= ruleImpliesExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getOperandsImpliesExpressionParserRuleCall_1_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5402);
                            lv_operands_5_0=ruleImpliesExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"operands",
                            	        		lv_operands_5_0, 
                            	        		"ImpliesExpression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRangeExpression


    // $ANTLR start entryRuleImpliesExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3154:1: entryRuleImpliesExpression returns [EObject current=null] : iv_ruleImpliesExpression= ruleImpliesExpression EOF ;
    public final EObject entryRuleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3155:2: (iv_ruleImpliesExpression= ruleImpliesExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3156:2: iv_ruleImpliesExpression= ruleImpliesExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImpliesExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression5442);
            iv_ruleImpliesExpression=ruleImpliesExpression();
            _fsp--;

             current =iv_ruleImpliesExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImpliesExpression5452); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleImpliesExpression


    // $ANTLR start ruleImpliesExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3163:1: ruleImpliesExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3168:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3169:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3169:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3170:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getImpliesExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5499);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3178:1: ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==48) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3178:2: () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3178:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3179:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getImpliesExpressionAccess().getImpliesExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getImpliesExpressionAccess().getImpliesExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,48,FOLLOW_48_in_ruleImpliesExpression5518); 

                            createLeafNode(grammarAccess.getImpliesExpressionAccess().getEqualsSignGreaterThanSignKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3198:1: ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3199:1: (lv_rightOperand_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3199:1: (lv_rightOperand_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3200:3: lv_rightOperand_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getImpliesExpressionAccess().getRightOperandLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5539);
                    lv_rightOperand_3_0=ruleLogicalOrExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getImpliesExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightOperand",
                    	        		lv_rightOperand_3_0, 
                    	        		"LogicalOrExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleImpliesExpression


    // $ANTLR start entryRuleLogicalOrExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3230:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3231:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3232:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5577);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression5587); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLogicalOrExpression


    // $ANTLR start ruleLogicalOrExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3239:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3244:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3245:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3245:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3246:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5634);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3254:1: ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==49) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3254:2: () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3254:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3255:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3270:2: ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt45=0;
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==49) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3270:4: '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,49,FOLLOW_49_in_ruleLogicalOrExpression5654); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3274:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3275:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3275:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3276:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5675);
                    	    lv_operands_3_0=ruleLogicalAndExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getLogicalOrExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"LogicalAndExpression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt45 >= 1 ) break loop45;
                                EarlyExitException eee =
                                    new EarlyExitException(45, input);
                                throw eee;
                        }
                        cnt45++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalOrExpression


    // $ANTLR start entryRuleLogicalAndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3306:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3307:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3308:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5715);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression5725); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLogicalAndExpression


    // $ANTLR start ruleLogicalAndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3315:1: ruleLogicalAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3320:6: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3321:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3321:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3322:5: this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getEqualityExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression5772);
            this_EqualityExpression_0=ruleEqualityExpression();
            _fsp--;

             
                    current = this_EqualityExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3330:1: ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==50) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3330:2: () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3330:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3331:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3346:2: ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==50) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3346:4: '&&' ( (lv_operands_3_0= ruleEqualityExpression ) )
                    	    {
                    	    match(input,50,FOLLOW_50_in_ruleLogicalAndExpression5792); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3350:1: ( (lv_operands_3_0= ruleEqualityExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3351:1: (lv_operands_3_0= ruleEqualityExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3351:1: (lv_operands_3_0= ruleEqualityExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3352:3: lv_operands_3_0= ruleEqualityExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsEqualityExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression5813);
                    	    lv_operands_3_0=ruleEqualityExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getLogicalAndExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"EqualityExpression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt47 >= 1 ) break loop47;
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalAndExpression


    // $ANTLR start entryRuleEqualityExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3382:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3383:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3384:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5853);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5863); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEqualityExpression


    // $ANTLR start ruleEqualityExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3391:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3396:6: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3397:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3397:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3398:5: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5910);
            this_RelationalExpression_0=ruleRelationalExpression();
            _fsp--;

             
                    current = this_RelationalExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3406:1: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=66 && LA49_0<=67)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3406:2: () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3406:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3407:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3422:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3423:1: (lv_operator_2_0= ruleEqualityOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3423:1: (lv_operator_2_0= ruleEqualityOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3424:3: lv_operator_2_0= ruleEqualityOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression5940);
                    lv_operator_2_0=ruleEqualityOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"EqualityOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:2: ( (lv_rightOperand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3447:1: (lv_rightOperand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3447:1: (lv_rightOperand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3448:3: lv_rightOperand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5961);
                    lv_rightOperand_3_0=ruleRelationalExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightOperand",
                    	        		lv_rightOperand_3_0, 
                    	        		"RelationalExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3478:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3479:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3480:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5999);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression6009); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3487:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_typeTest_2_0=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_type_3_0 = null;

        Enumerator lv_operator_4_0 = null;

        EObject lv_rightOperand_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3492:6: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3493:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3493:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3494:5: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6056);
            this_AdditiveExpression_0=ruleAdditiveExpression();
            _fsp--;

             
                    current = this_AdditiveExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3502:1: ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=23 && LA51_0<=24)||LA51_0==51||(LA51_0>=68 && LA51_0<=69)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3502:2: () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3502:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3503:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3518:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==51) ) {
                        alt50=1;
                    }
                    else if ( ((LA50_0>=23 && LA50_0<=24)||(LA50_0>=68 && LA50_0<=69)) ) {
                        alt50=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("3518:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) )", 50, 0, input);

                        throw nvae;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3518:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3518:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3518:4: ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3518:4: ( (lv_typeTest_2_0= 'is' ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3519:1: (lv_typeTest_2_0= 'is' )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3519:1: (lv_typeTest_2_0= 'is' )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3520:3: lv_typeTest_2_0= 'is'
                            {
                            lv_typeTest_2_0=(Token)input.LT(1);
                            match(input,51,FOLLOW_51_in_ruleRelationalExpression6085); 

                                    createLeafNode(grammarAccess.getRelationalExpressionAccess().getTypeTestIsKeyword_1_1_0_0_0(), "typeTest"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "typeTest", true, "is", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3539:2: ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3540:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3540:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3541:3: lv_type_3_0= ruleDataTypeSpecifier
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6119);
                            lv_type_3_0=ruleDataTypeSpecifier();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"type",
                            	        		lv_type_3_0, 
                            	        		"DataTypeSpecifier", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3564:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3564:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3564:7: ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3564:7: ( (lv_operator_4_0= ruleRelationalOperator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3565:1: (lv_operator_4_0= ruleRelationalOperator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3565:1: (lv_operator_4_0= ruleRelationalOperator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3566:3: lv_operator_4_0= ruleRelationalOperator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6148);
                            lv_operator_4_0=ruleRelationalOperator();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"operator",
                            	        		lv_operator_4_0, 
                            	        		"RelationalOperator", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3588:2: ( (lv_rightOperand_5_0= ruleAdditiveExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3589:1: (lv_rightOperand_5_0= ruleAdditiveExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3589:1: (lv_rightOperand_5_0= ruleAdditiveExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3590:3: lv_rightOperand_5_0= ruleAdditiveExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6169);
                            lv_rightOperand_5_0=ruleAdditiveExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"rightOperand",
                            	        		lv_rightOperand_5_0, 
                            	        		"AdditiveExpression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3620:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3621:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3622:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6209);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression6219); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3629:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3634:6: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3635:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3635:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3636:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6266);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();
            _fsp--;

             
                    current = this_MultiplicativeExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3644:1: ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==61||LA53_0==70) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3644:2: () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3644:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3645:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3660:2: ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==61||LA52_0==70) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3661:1: (lv_rightParts_2_0= ruleAdditiveExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3661:1: (lv_rightParts_2_0= ruleAdditiveExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3662:3: lv_rightParts_2_0= ruleAdditiveExpressionPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightPartsAdditiveExpressionPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6296);
                    	    lv_rightParts_2_0=ruleAdditiveExpressionPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightParts",
                    	    	        		lv_rightParts_2_0, 
                    	    	        		"AdditiveExpressionPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleAdditiveExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3692:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3693:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3694:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6335);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();
            _fsp--;

             current =iv_ruleAdditiveExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6345); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAdditiveExpressionPart


    // $ANTLR start ruleAdditiveExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3701:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3706:6: ( ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3707:1: ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3707:1: ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3707:2: ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3707:2: ( (lv_operator_0_0= ruleAdditiveOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3708:1: (lv_operator_0_0= ruleAdditiveOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3708:1: (lv_operator_0_0= ruleAdditiveOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3709:3: lv_operator_0_0= ruleAdditiveOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOperatorAdditiveOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6391);
            lv_operator_0_0=ruleAdditiveOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_0_0, 
            	        		"AdditiveOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3731:2: ( (lv_operand_1_0= ruleMultiplicativeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3732:1: (lv_operand_1_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3732:1: (lv_operand_1_0= ruleMultiplicativeExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3733:3: lv_operand_1_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOperandMultiplicativeExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6412);
            lv_operand_1_0=ruleMultiplicativeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_1_0, 
            	        		"MultiplicativeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAdditiveExpressionPart


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3763:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3764:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3765:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6448);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6458); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3772:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3777:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3778:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3778:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3779:5: this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpression6505);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:1: ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=58 && LA55_0<=59)||(LA55_0>=71 && LA55_0<=72)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:2: () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3788:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3803:2: ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+
                    int cnt54=0;
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( ((LA54_0>=58 && LA54_0<=59)||(LA54_0>=71 && LA54_0<=72)) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3804:1: (lv_rightParts_2_0= ruleMultiplicativeExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3804:1: (lv_rightParts_2_0= ruleMultiplicativeExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3805:3: lv_rightParts_2_0= ruleMultiplicativeExpressionPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightPartsMultiplicativeExpressionPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6535);
                    	    lv_rightParts_2_0=ruleMultiplicativeExpressionPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightParts",
                    	    	        		lv_rightParts_2_0, 
                    	    	        		"MultiplicativeExpressionPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt54 >= 1 ) break loop54;
                                EarlyExitException eee =
                                    new EarlyExitException(54, input);
                                throw eee;
                        }
                        cnt54++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleMultiplicativeExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3835:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3836:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3837:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6574);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();
            _fsp--;

             current =iv_ruleMultiplicativeExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6584); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleMultiplicativeExpressionPart


    // $ANTLR start ruleMultiplicativeExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3844:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3849:6: ( ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3850:1: ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3850:1: ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3850:2: ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3850:2: ( (lv_operator_0_0= ruleMultiplicativeOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3851:1: (lv_operator_0_0= ruleMultiplicativeOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3851:1: (lv_operator_0_0= ruleMultiplicativeOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3852:3: lv_operator_0_0= ruleMultiplicativeOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOperatorMultiplicativeOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6630);
            lv_operator_0_0=ruleMultiplicativeOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_0_0, 
            	        		"MultiplicativeOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3874:2: ( (lv_operand_1_0= rulePowerExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3875:1: (lv_operand_1_0= rulePowerExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3875:1: (lv_operand_1_0= rulePowerExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3876:3: lv_operand_1_0= rulePowerExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOperandPowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpressionPart6651);
            lv_operand_1_0=rulePowerExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_1_0, 
            	        		"PowerExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicativeExpressionPart


    // $ANTLR start entryRulePowerExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3906:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3907:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3908:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression6687);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression6697); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePowerExpression


    // $ANTLR start rulePowerExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3915:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3920:6: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3921:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3921:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3922:5: this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryExpression_in_rulePowerExpression6744);
            this_UnaryExpression_0=ruleUnaryExpression();
            _fsp--;

             
                    current = this_UnaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3930:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==60||LA56_0==73) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3930:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3930:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3931:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "operand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3946:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3947:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3947:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3948:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression6774);
                    lv_operator_2_0=rulePowerOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPowerExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"PowerOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3970:2: ( (lv_exponent_3_0= ruleUnaryExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3971:1: (lv_exponent_3_0= ruleUnaryExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3971:1: (lv_exponent_3_0= ruleUnaryExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3972:3: lv_exponent_3_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_rulePowerExpression6795);
                    lv_exponent_3_0=ruleUnaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPowerExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exponent",
                    	        		lv_exponent_3_0, 
                    	        		"UnaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePowerExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4002:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4003:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4004:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6833);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6843); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnaryExpression


    // $ANTLR start ruleUnaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4011:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4016:6: ( (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4017:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4017:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_ID && LA57_0<=RULE_STRING)||LA57_0==13||LA57_0==25||LA57_0==33||LA57_0==53||(LA57_0>=56 && LA57_0<=57)||(LA57_0>=76 && LA57_0<=77)) ) {
                alt57=1;
            }
            else if ( (LA57_0==61||LA57_0==74) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4017:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4018:5: this_PostfixExpression_0= rulePostfixExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6890);
                    this_PostfixExpression_0=rulePostfixExpression();
                    _fsp--;

                     
                            current = this_PostfixExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4027:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4027:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4027:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4027:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4028:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4038:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4039:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4039:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4040:3: lv_operator_2_0= ruleUnaryOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6926);
                    lv_operator_2_0=ruleUnaryOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"UnaryOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4062:2: ( (lv_operand_3_0= rulePostfixExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4063:1: (lv_operand_3_0= rulePostfixExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4063:1: (lv_operand_3_0= rulePostfixExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4064:3: lv_operand_3_0= rulePostfixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandPostfixExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6947);
                    lv_operand_3_0=rulePostfixExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operand",
                    	        		lv_operand_3_0, 
                    	        		"PostfixExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnaryExpression


    // $ANTLR start entryRulePostfixExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4094:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4095:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4096:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPostfixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6984);
            iv_rulePostfixExpression=rulePostfixExpression();
            _fsp--;

             current =iv_rulePostfixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6994); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePostfixExpression


    // $ANTLR start rulePostfixExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4103:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4108:6: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4109:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4109:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4110:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7041);
            this_PrimaryExpression_0=rulePrimaryExpression();
            _fsp--;

             
                    current = this_PrimaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4118:1: ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==75) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4118:2: () ( (lv_operator_2_0= rulePostfixOperator ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4118:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4119:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "operand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4134:2: ( (lv_operator_2_0= rulePostfixOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4135:1: (lv_operator_2_0= rulePostfixOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4135:1: (lv_operator_2_0= rulePostfixOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4136:3: lv_operator_2_0= rulePostfixOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPostfixExpressionAccess().getOperatorPostfixOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePostfixOperator_in_rulePostfixExpression7071);
                    lv_operator_2_0=rulePostfixOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPostfixExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"PostfixOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePostfixExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4166:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4167:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4168:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7109);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression7119); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4175:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_UnitConstructionOperator_2 = null;

        EObject this_BeginExpression_3 = null;

        EObject this_EndExpression_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4180:6: ( (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4181:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4181:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )
            int alt59=5;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 76:
            case 77:
                {
                alt59=1;
                }
                break;
            case RULE_ID:
            case 13:
            case 25:
            case 33:
                {
                alt59=2;
                }
                break;
            case 53:
                {
                alt59=3;
                }
                break;
            case 56:
                {
                alt59=4;
                }
                break;
            case 57:
                {
                alt59=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4181:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4182:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression7166);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4192:5: this_FeatureCall_1= ruleFeatureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7193);
                    this_FeatureCall_1=ruleFeatureCall();
                    _fsp--;

                     
                            current = this_FeatureCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4202:5: this_UnitConstructionOperator_2= ruleUnitConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnitConstructionOperatorParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression7220);
                    this_UnitConstructionOperator_2=ruleUnitConstructionOperator();
                    _fsp--;

                     
                            current = this_UnitConstructionOperator_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4212:5: this_BeginExpression_3= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression7247);
                    this_BeginExpression_3=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4222:5: this_EndExpression_4= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression7274);
                    this_EndExpression_4=ruleEndExpression();
                    _fsp--;

                     
                            current = this_EndExpression_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleCallablePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4238:1: entryRuleCallablePrimaryExpression returns [EObject current=null] : iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF ;
    public final EObject entryRuleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallablePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4239:2: (iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4240:2: iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallablePrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression7309);
            iv_ruleCallablePrimaryExpression=ruleCallablePrimaryExpression();
            _fsp--;

             current =iv_ruleCallablePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallablePrimaryExpression7319); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCallablePrimaryExpression


    // $ANTLR start ruleCallablePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4247:1: ruleCallablePrimaryExpression returns [EObject current=null] : (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject ruleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayConstructionOperator_0 = null;

        EObject this_ArrayConcatenationOperator_1 = null;

        EObject this_ParenthesizedExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4252:6: ( (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4253:1: (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4253:1: (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt60=1;
                }
                break;
            case 33:
                {
                alt60=2;
                }
                break;
            case 25:
                {
                alt60=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4253:1: (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression )", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4254:5: this_ArrayConstructionOperator_0= ruleArrayConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getArrayConstructionOperatorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayConstructionOperator_in_ruleCallablePrimaryExpression7366);
                    this_ArrayConstructionOperator_0=ruleArrayConstructionOperator();
                    _fsp--;

                     
                            current = this_ArrayConstructionOperator_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4264:5: this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getArrayConcatenationOperatorParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_ruleCallablePrimaryExpression7393);
                    this_ArrayConcatenationOperator_1=ruleArrayConcatenationOperator();
                    _fsp--;

                     
                            current = this_ArrayConcatenationOperator_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4274:5: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression7420);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();
                    _fsp--;

                     
                            current = this_ParenthesizedExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCallablePrimaryExpression


    // $ANTLR start entryRuleLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4290:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4291:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4292:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral7455);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral7465); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLiteral


    // $ANTLR start ruleLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4299:1: ruleLiteral returns [EObject current=null] : (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4304:6: ( (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4305:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4305:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt61=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt61=1;
                }
                break;
            case 76:
            case 77:
                {
                alt61=2;
                }
                break;
            case RULE_STRING:
                {
                alt61=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4305:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4306:5: this_NumericLiteral_0= ruleNumericLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericLiteral_in_ruleLiteral7512);
                    this_NumericLiteral_0=ruleNumericLiteral();
                    _fsp--;

                     
                            current = this_NumericLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4316:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral7539);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4326:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral7566);
                    this_StringLiteral_2=ruleStringLiteral();
                    _fsp--;

                     
                            current = this_StringLiteral_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLiteral


    // $ANTLR start entryRuleNumericLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4342:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4343:2: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4344:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericLiteral_in_entryRuleNumericLiteral7601);
            iv_ruleNumericLiteral=ruleNumericLiteral();
            _fsp--;

             current =iv_ruleNumericLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericLiteral7611); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNumericLiteral


    // $ANTLR start ruleNumericLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4351:1: ruleNumericLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4356:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4357:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4357:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_REAL) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_INTEGER) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4357:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4358:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericLiteral7658);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4368:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericLiteral7685);
                    this_IntegerLiteral_1=ruleIntegerLiteral();
                    _fsp--;

                     
                            current = this_IntegerLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNumericLiteral


    // $ANTLR start entryRuleRealLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4384:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4385:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4386:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7720);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral7730); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRealLiteral


    // $ANTLR start ruleRealLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4393:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_modifier_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4398:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4399:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4399:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4399:2: ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4399:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4400:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4400:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4401:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral7772); 

            			createLeafNode(grammarAccess.getRealLiteralAccess().getValueREALTerminalRuleCall_0_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"REAL", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4423:2: ( (lv_modifier_1_0= RULE_ID ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4424:1: (lv_modifier_1_0= RULE_ID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4424:1: (lv_modifier_1_0= RULE_ID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4425:3: lv_modifier_1_0= RULE_ID
                    {
                    lv_modifier_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealLiteral7794); 

                    			createLeafNode(grammarAccess.getRealLiteralAccess().getModifierIDTerminalRuleCall_1_0(), "modifier"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"modifier",
                    	        		lv_modifier_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4447:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==25) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4447:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleRealLiteral7811); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4451:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4452:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4452:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4453:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral7832);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleRealLiteral7842); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRealLiteral


    // $ANTLR start entryRuleIntegerLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4487:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4488:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4489:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral7880);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral7890); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIntegerLiteral


    // $ANTLR start ruleIntegerLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4496:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_modifier_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4501:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4502:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4502:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4502:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4502:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4503:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4503:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4504:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral7932); 

            			createLeafNode(grammarAccess.getIntegerLiteralAccess().getValueINTEGERTerminalRuleCall_0_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"INTEGER", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4526:2: ( (lv_modifier_1_0= RULE_ID ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4527:1: (lv_modifier_1_0= RULE_ID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4527:1: (lv_modifier_1_0= RULE_ID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4528:3: lv_modifier_1_0= RULE_ID
                    {
                    lv_modifier_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerLiteral7954); 

                    			createLeafNode(grammarAccess.getIntegerLiteralAccess().getModifierIDTerminalRuleCall_1_0(), "modifier"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"modifier",
                    	        		lv_modifier_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4550:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==25) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4550:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleIntegerLiteral7971); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4554:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4555:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4555:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4556:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral7992);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleIntegerLiteral8002); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIntegerLiteral


    // $ANTLR start entryRuleBooleanLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4590:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4591:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4592:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8040);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8050); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanLiteral


    // $ANTLR start ruleBooleanLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4599:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4604:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4606:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4606:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4607:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral8095);
            lv_value_0_0=ruleBooleanKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"BooleanKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanLiteral


    // $ANTLR start entryRuleStringLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4637:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4638:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4639:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral8130);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral8140); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStringLiteral


    // $ANTLR start ruleStringLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4646:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4651:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4652:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4652:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4653:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4653:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4654:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral8181); 

            			createLeafNode(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringLiteral


    // $ANTLR start entryRuleSimpleName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4684:1: entryRuleSimpleName returns [EObject current=null] : iv_ruleSimpleName= ruleSimpleName EOF ;
    public final EObject entryRuleSimpleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4685:2: (iv_ruleSimpleName= ruleSimpleName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4686:2: iv_ruleSimpleName= ruleSimpleName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleName_in_entryRuleSimpleName8221);
            iv_ruleSimpleName=ruleSimpleName();
            _fsp--;

             current =iv_ruleSimpleName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleName8231); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimpleName


    // $ANTLR start ruleSimpleName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4693:1: ruleSimpleName returns [EObject current=null] : ( () ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleName() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4698:6: ( ( () ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4699:1: ( () ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4699:1: ( () ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4699:2: () ( (lv_identifier_1_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4699:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4700:5: 
            {
             
                    temp=factory.create(grammarAccess.getSimpleNameAccess().getSimpleNameAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getSimpleNameAccess().getSimpleNameAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4710:2: ( (lv_identifier_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4711:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4711:1: (lv_identifier_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4712:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleName8282); 

            			createLeafNode(grammarAccess.getSimpleNameAccess().getIdentifierIDTerminalRuleCall_1_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSimpleName


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4742:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4743:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4744:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8323);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall8333); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFeatureCall


    // $ANTLR start ruleFeatureCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4751:1: ruleFeatureCall returns [EObject current=null] : ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_CallablePrimaryExpression_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_target_4_0 = null;

        EObject lv_parts_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4756:6: ( ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4757:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4757:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==13||LA70_0==25||LA70_0==33) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_ID) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4757:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4757:2: (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4757:2: (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4758:5: this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getCallablePrimaryExpressionParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall8381);
                    this_CallablePrimaryExpression_0=ruleCallablePrimaryExpression();
                    _fsp--;

                     
                            current = this_CallablePrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4766:1: ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==25||LA68_0==33||LA68_0==52) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4766:2: () ( (lv_parts_2_0= ruleFeatureCallPart ) )+
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4766:2: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4767:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_0_1_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "target", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_0_1_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4782:2: ( (lv_parts_2_0= ruleFeatureCallPart ) )+
                            int cnt67=0;
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==25||LA67_0==33||LA67_0==52) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4783:1: (lv_parts_2_0= ruleFeatureCallPart )
                            	    {
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4783:1: (lv_parts_2_0= ruleFeatureCallPart )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4784:3: lv_parts_2_0= ruleFeatureCallPart
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_0_1_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8411);
                            	    lv_parts_2_0=ruleFeatureCallPart();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"parts",
                            	    	        		lv_parts_2_0, 
                            	    	        		"FeatureCallPart", 
                            	    	        		currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt67 >= 1 ) break loop67;
                                        EarlyExitException eee =
                                            new EarlyExitException(67, input);
                                        throw eee;
                                }
                                cnt67++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:6: ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:6: ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:7: () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4808:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4818:2: ( (lv_target_4_0= ruleSimpleName ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4819:1: (lv_target_4_0= ruleSimpleName )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4819:1: (lv_target_4_0= ruleSimpleName )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4820:3: lv_target_4_0= ruleSimpleName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getTargetSimpleNameParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSimpleName_in_ruleFeatureCall8452);
                    lv_target_4_0=ruleSimpleName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"target",
                    	        		lv_target_4_0, 
                    	        		"SimpleName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4842:2: ( (lv_parts_5_0= ruleFeatureCallPart ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==25||LA69_0==33||LA69_0==52) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4843:1: (lv_parts_5_0= ruleFeatureCallPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4843:1: (lv_parts_5_0= ruleFeatureCallPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4844:3: lv_parts_5_0= ruleFeatureCallPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_1_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8473);
                    	    lv_parts_5_0=ruleFeatureCallPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"parts",
                    	    	        		lv_parts_5_0, 
                    	    	        		"FeatureCallPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFeatureCall


    // $ANTLR start entryRuleFeatureCallPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4874:1: entryRuleFeatureCallPart returns [EObject current=null] : iv_ruleFeatureCallPart= ruleFeatureCallPart EOF ;
    public final EObject entryRuleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4875:2: (iv_ruleFeatureCallPart= ruleFeatureCallPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4876:2: iv_ruleFeatureCallPart= ruleFeatureCallPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart8511);
            iv_ruleFeatureCallPart=ruleFeatureCallPart();
            _fsp--;

             current =iv_ruleFeatureCallPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallPart8521); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFeatureCallPart


    // $ANTLR start ruleFeatureCallPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4883:1: ruleFeatureCallPart returns [EObject current=null] : (this_FeatureAccess_0= ruleFeatureAccess | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationCall_2= ruleOperationCall | this_IterationCall_3= ruleIterationCall ) ;
    public final EObject ruleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject this_FeatureAccess_0 = null;

        EObject this_ArrayElementAccess_1 = null;

        EObject this_OperationCall_2 = null;

        EObject this_IterationCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4888:6: ( (this_FeatureAccess_0= ruleFeatureAccess | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationCall_2= ruleOperationCall | this_IterationCall_3= ruleIterationCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4889:1: (this_FeatureAccess_0= ruleFeatureAccess | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationCall_2= ruleOperationCall | this_IterationCall_3= ruleIterationCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4889:1: (this_FeatureAccess_0= ruleFeatureAccess | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationCall_2= ruleOperationCall | this_IterationCall_3= ruleIterationCall )
            int alt71=4;
            alt71 = dfa71.predict(input);
            switch (alt71) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4890:5: this_FeatureAccess_0= ruleFeatureAccess
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getFeatureAccessParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureAccess_in_ruleFeatureCallPart8568);
                    this_FeatureAccess_0=ruleFeatureAccess();
                    _fsp--;

                     
                            current = this_FeatureAccess_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4900:5: this_ArrayElementAccess_1= ruleArrayElementAccess
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getArrayElementAccessParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayElementAccess_in_ruleFeatureCallPart8595);
                    this_ArrayElementAccess_1=ruleArrayElementAccess();
                    _fsp--;

                     
                            current = this_ArrayElementAccess_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4910:5: this_OperationCall_2= ruleOperationCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getOperationCallParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCall_in_ruleFeatureCallPart8622);
                    this_OperationCall_2=ruleOperationCall();
                    _fsp--;

                     
                            current = this_OperationCall_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4920:5: this_IterationCall_3= ruleIterationCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getIterationCallParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIterationCall_in_ruleFeatureCallPart8649);
                    this_IterationCall_3=ruleIterationCall();
                    _fsp--;

                     
                            current = this_IterationCall_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFeatureCallPart


    // $ANTLR start entryRuleFeatureAccess
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4936:1: entryRuleFeatureAccess returns [EObject current=null] : iv_ruleFeatureAccess= ruleFeatureAccess EOF ;
    public final EObject entryRuleFeatureAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureAccess = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4937:2: (iv_ruleFeatureAccess= ruleFeatureAccess EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4938:2: iv_ruleFeatureAccess= ruleFeatureAccess EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureAccessRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureAccess_in_entryRuleFeatureAccess8684);
            iv_ruleFeatureAccess=ruleFeatureAccess();
            _fsp--;

             current =iv_ruleFeatureAccess; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureAccess8694); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFeatureAccess


    // $ANTLR start ruleFeatureAccess
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4945:1: ruleFeatureAccess returns [EObject current=null] : ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) ) ;
    public final EObject ruleFeatureAccess() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4950:6: ( ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4951:1: ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4951:1: ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4951:3: '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) )
            {
            match(input,52,FOLLOW_52_in_ruleFeatureAccess8729); 

                    createLeafNode(grammarAccess.getFeatureAccessAccess().getFullStopKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4955:1: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4956:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4956:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4957:1: (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4957:1: (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) ) {
                alt72=1;
            }
            else if ( (LA72_0==53) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4957:1: (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4958:3: lv_name_1_1= RULE_ID
                    {
                    lv_name_1_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureAccess8748); 

                    			createLeafNode(grammarAccess.getFeatureAccessAccess().getNameIDTerminalRuleCall_1_0_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureAccessRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_1, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4979:8: lv_name_1_2= 'unit'
                    {
                    lv_name_1_2=(Token)input.LT(1);
                    match(input,53,FOLLOW_53_in_ruleFeatureAccess8769); 

                            createLeafNode(grammarAccess.getFeatureAccessAccess().getNameUnitKeyword_1_0_1(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureAccessRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_1_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFeatureAccess


    // $ANTLR start entryRuleArrayElementAccess
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5008:1: entryRuleArrayElementAccess returns [EObject current=null] : iv_ruleArrayElementAccess= ruleArrayElementAccess EOF ;
    public final EObject entryRuleArrayElementAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayElementAccess = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5009:2: (iv_ruleArrayElementAccess= ruleArrayElementAccess EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5010:2: iv_ruleArrayElementAccess= ruleArrayElementAccess EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayElementAccessRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayElementAccess_in_entryRuleArrayElementAccess8821);
            iv_ruleArrayElementAccess=ruleArrayElementAccess();
            _fsp--;

             current =iv_ruleArrayElementAccess; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayElementAccess8831); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArrayElementAccess


    // $ANTLR start ruleArrayElementAccess
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5017:1: ruleArrayElementAccess returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* ']' ) ;
    public final EObject ruleArrayElementAccess() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5022:6: ( ( '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5023:1: ( '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5023:1: ( '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5023:3: '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* ']'
            {
            match(input,33,FOLLOW_33_in_ruleArrayElementAccess8866); 

                    createLeafNode(grammarAccess.getArrayElementAccessAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5027:1: ( (lv_subscripts_1_0= ruleArraySubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5028:1: (lv_subscripts_1_0= ruleArraySubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5028:1: (lv_subscripts_1_0= ruleArraySubscript )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5029:3: lv_subscripts_1_0= ruleArraySubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayElementAccessAccess().getSubscriptsArraySubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess8887);
            lv_subscripts_1_0=ruleArraySubscript();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayElementAccessRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"subscripts",
            	        		lv_subscripts_1_0, 
            	        		"ArraySubscript", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5051:2: ( ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==14) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5051:4: ',' ( (lv_subscripts_3_0= ruleArraySubscript ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleArrayElementAccess8898); 

            	            createLeafNode(grammarAccess.getArrayElementAccessAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5055:1: ( (lv_subscripts_3_0= ruleArraySubscript ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5056:1: (lv_subscripts_3_0= ruleArraySubscript )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5056:1: (lv_subscripts_3_0= ruleArraySubscript )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5057:3: lv_subscripts_3_0= ruleArraySubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayElementAccessAccess().getSubscriptsArraySubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess8919);
            	    lv_subscripts_3_0=ruleArraySubscript();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArrayElementAccessRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subscripts",
            	    	        		lv_subscripts_3_0, 
            	    	        		"ArraySubscript", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_ruleArrayElementAccess8931); 

                    createLeafNode(grammarAccess.getArrayElementAccessAccess().getRightSquareBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayElementAccess


    // $ANTLR start entryRuleArraySubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5091:1: entryRuleArraySubscript returns [EObject current=null] : iv_ruleArraySubscript= ruleArraySubscript EOF ;
    public final EObject entryRuleArraySubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5092:2: (iv_ruleArraySubscript= ruleArraySubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5093:2: iv_ruleArraySubscript= ruleArraySubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArraySubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleArraySubscript_in_entryRuleArraySubscript8967);
            iv_ruleArraySubscript=ruleArraySubscript();
            _fsp--;

             current =iv_ruleArraySubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArraySubscript8977); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArraySubscript


    // $ANTLR start ruleArraySubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5100:1: ruleArraySubscript returns [EObject current=null] : ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleArraySubscript() throws RecognitionException {
        EObject current = null;

        Token lv_slice_0_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5105:6: ( ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==20) ) {
                alt74=1;
            }
            else if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_STRING)||LA74_0==13||LA74_0==25||LA74_0==33||LA74_0==40||LA74_0==42||LA74_0==45||LA74_0==53||(LA74_0>=56 && LA74_0<=57)||LA74_0==61||LA74_0==74||(LA74_0>=76 && LA74_0<=77)) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5106:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:2: ( (lv_slice_0_0= ':' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:2: ( (lv_slice_0_0= ':' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5107:1: (lv_slice_0_0= ':' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5107:1: (lv_slice_0_0= ':' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5108:3: lv_slice_0_0= ':'
                    {
                    lv_slice_0_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleArraySubscript9020); 

                            createLeafNode(grammarAccess.getArraySubscriptAccess().getSliceColonKeyword_0_0(), "slice"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArraySubscriptRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "slice", true, ":", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5128:6: ( (lv_expression_1_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5128:6: ( (lv_expression_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5129:1: (lv_expression_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5129:1: (lv_expression_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5130:3: lv_expression_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getArraySubscriptAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArraySubscript9060);
                    lv_expression_1_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArraySubscriptRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_1_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArraySubscript


    // $ANTLR start entryRuleOperationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5160:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5161:2: (iv_ruleOperationCall= ruleOperationCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5162:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCall_in_entryRuleOperationCall9096);
            iv_ruleOperationCall=ruleOperationCall();
            _fsp--;

             current =iv_ruleOperationCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCall9106); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOperationCall


    // $ANTLR start ruleOperationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5169:1: ruleOperationCall returns [EObject current=null] : ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5174:6: ( ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5175:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5175:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5175:2: () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5175:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5176:5: 
            {
             
                    temp=factory.create(grammarAccess.getOperationCallAccess().getOperationCallAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getOperationCallAccess().getOperationCallAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,25,FOLLOW_25_in_ruleOperationCall9150); 

                    createLeafNode(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5190:1: ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_ID && LA76_0<=RULE_STRING)||LA76_0==13||LA76_0==25||LA76_0==33||LA76_0==40||LA76_0==42||LA76_0==45||LA76_0==53||(LA76_0>=56 && LA76_0<=57)||LA76_0==61||LA76_0==74||(LA76_0>=76 && LA76_0<=77)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5190:2: ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5190:2: ( (lv_arguments_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5191:1: (lv_arguments_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5191:1: (lv_arguments_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5192:3: lv_arguments_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall9172);
                    lv_arguments_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"arguments",
                    	        		lv_arguments_2_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5214:2: ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==14) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5214:4: ',' ( (lv_arguments_4_0= ruleExpression ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleOperationCall9183); 

                    	            createLeafNode(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5218:1: ( (lv_arguments_4_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5219:1: (lv_arguments_4_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5219:1: (lv_arguments_4_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5220:3: lv_arguments_4_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall9204);
                    	    lv_arguments_4_0=ruleExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getOperationCallRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"arguments",
                    	    	        		lv_arguments_4_0, 
                    	    	        		"Expression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_ruleOperationCall9218); 

                    createLeafNode(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOperationCall


    // $ANTLR start entryRuleIterationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5254:1: entryRuleIterationCall returns [EObject current=null] : iv_ruleIterationCall= ruleIterationCall EOF ;
    public final EObject entryRuleIterationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5255:2: (iv_ruleIterationCall= ruleIterationCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5256:2: iv_ruleIterationCall= ruleIterationCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIterationCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleIterationCall_in_entryRuleIterationCall9254);
            iv_ruleIterationCall=ruleIterationCall();
            _fsp--;

             current =iv_ruleIterationCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIterationCall9264); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIterationCall


    // $ANTLR start ruleIterationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5263:1: ruleIterationCall returns [EObject current=null] : ( () '(' ( (lv_variables_2_0= ruleIterationVariable ) ) ( ',' ( (lv_variables_4_0= ruleIterationVariable ) ) )* ( ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleIterationCall() throws RecognitionException {
        EObject current = null;

        EObject lv_variables_2_0 = null;

        EObject lv_variables_4_0 = null;

        EObject lv_accumulator_6_0 = null;

        EObject lv_expression_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5268:6: ( ( () '(' ( (lv_variables_2_0= ruleIterationVariable ) ) ( ',' ( (lv_variables_4_0= ruleIterationVariable ) ) )* ( ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5269:1: ( () '(' ( (lv_variables_2_0= ruleIterationVariable ) ) ( ',' ( (lv_variables_4_0= ruleIterationVariable ) ) )* ( ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5269:1: ( () '(' ( (lv_variables_2_0= ruleIterationVariable ) ) ( ',' ( (lv_variables_4_0= ruleIterationVariable ) ) )* ( ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5269:2: () '(' ( (lv_variables_2_0= ruleIterationVariable ) ) ( ',' ( (lv_variables_4_0= ruleIterationVariable ) ) )* ( ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5269:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5270:5: 
            {
             
                    temp=factory.create(grammarAccess.getIterationCallAccess().getIterationCallAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getIterationCallAccess().getIterationCallAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,25,FOLLOW_25_in_ruleIterationCall9308); 

                    createLeafNode(grammarAccess.getIterationCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5284:1: ( (lv_variables_2_0= ruleIterationVariable ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5285:1: (lv_variables_2_0= ruleIterationVariable )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5285:1: (lv_variables_2_0= ruleIterationVariable )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5286:3: lv_variables_2_0= ruleIterationVariable
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIterationCallAccess().getVariablesIterationVariableParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleIterationVariable_in_ruleIterationCall9329);
            lv_variables_2_0=ruleIterationVariable();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIterationCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"variables",
            	        		lv_variables_2_0, 
            	        		"IterationVariable", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5308:2: ( ',' ( (lv_variables_4_0= ruleIterationVariable ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==14) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5308:4: ',' ( (lv_variables_4_0= ruleIterationVariable ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleIterationCall9340); 

            	            createLeafNode(grammarAccess.getIterationCallAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5312:1: ( (lv_variables_4_0= ruleIterationVariable ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5313:1: (lv_variables_4_0= ruleIterationVariable )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5313:1: (lv_variables_4_0= ruleIterationVariable )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5314:3: lv_variables_4_0= ruleIterationVariable
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getIterationCallAccess().getVariablesIterationVariableParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleIterationVariable_in_ruleIterationCall9361);
            	    lv_variables_4_0=ruleIterationVariable();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getIterationCallRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"variables",
            	    	        		lv_variables_4_0, 
            	    	        		"IterationVariable", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5336:4: ( ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==18) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5336:6: ';' ( (lv_accumulator_6_0= ruleIterationAccumulator ) )
                    {
                    match(input,18,FOLLOW_18_in_ruleIterationCall9374); 

                            createLeafNode(grammarAccess.getIterationCallAccess().getSemicolonKeyword_4_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5340:1: ( (lv_accumulator_6_0= ruleIterationAccumulator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5341:1: (lv_accumulator_6_0= ruleIterationAccumulator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5341:1: (lv_accumulator_6_0= ruleIterationAccumulator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5342:3: lv_accumulator_6_0= ruleIterationAccumulator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIterationCallAccess().getAccumulatorIterationAccumulatorParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleIterationAccumulator_in_ruleIterationCall9395);
                    lv_accumulator_6_0=ruleIterationAccumulator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIterationCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"accumulator",
                    	        		lv_accumulator_6_0, 
                    	        		"IterationAccumulator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,54,FOLLOW_54_in_ruleIterationCall9407); 

                    createLeafNode(grammarAccess.getIterationCallAccess().getVerticalLineKeyword_5(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5368:1: ( (lv_expression_8_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5369:1: (lv_expression_8_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5369:1: (lv_expression_8_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5370:3: lv_expression_8_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIterationCallAccess().getExpressionExpressionParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIterationCall9428);
            lv_expression_8_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIterationCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_8_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleIterationCall9438); 

                    createLeafNode(grammarAccess.getIterationCallAccess().getRightParenthesisKeyword_7(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIterationCall


    // $ANTLR start entryRuleIterationVariable
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5404:1: entryRuleIterationVariable returns [EObject current=null] : iv_ruleIterationVariable= ruleIterationVariable EOF ;
    public final EObject entryRuleIterationVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationVariable = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5405:2: (iv_ruleIterationVariable= ruleIterationVariable EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5406:2: iv_ruleIterationVariable= ruleIterationVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIterationVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleIterationVariable_in_entryRuleIterationVariable9474);
            iv_ruleIterationVariable=ruleIterationVariable();
            _fsp--;

             current =iv_ruleIterationVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIterationVariable9484); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIterationVariable


    // $ANTLR start ruleIterationVariable
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5413:1: ruleIterationVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleIterationVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5418:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5419:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5419:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5420:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5420:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5421:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIterationVariable9525); 

            			createLeafNode(grammarAccess.getIterationVariableAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIterationVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIterationVariable


    // $ANTLR start entryRuleIterationAccumulator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5451:1: entryRuleIterationAccumulator returns [EObject current=null] : iv_ruleIterationAccumulator= ruleIterationAccumulator EOF ;
    public final EObject entryRuleIterationAccumulator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationAccumulator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5452:2: (iv_ruleIterationAccumulator= ruleIterationAccumulator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5453:2: iv_ruleIterationAccumulator= ruleIterationAccumulator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIterationAccumulatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleIterationAccumulator_in_entryRuleIterationAccumulator9565);
            iv_ruleIterationAccumulator=ruleIterationAccumulator();
            _fsp--;

             current =iv_ruleIterationAccumulator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIterationAccumulator9575); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIterationAccumulator


    // $ANTLR start ruleIterationAccumulator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5460:1: ruleIterationAccumulator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_initializer_2_0= ruleExpression ) ) ) ;
    public final EObject ruleIterationAccumulator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_initializer_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5465:6: ( ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_initializer_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5466:1: ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_initializer_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5466:1: ( ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_initializer_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5466:2: ( (lv_name_0_0= RULE_ID ) ) '=' ( (lv_initializer_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5466:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5467:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5467:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5468:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIterationAccumulator9617); 

            			createLeafNode(grammarAccess.getIterationAccumulatorAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIterationAccumulatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleIterationAccumulator9632); 

                    createLeafNode(grammarAccess.getIterationAccumulatorAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5494:1: ( (lv_initializer_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5495:1: (lv_initializer_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5495:1: (lv_initializer_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5496:3: lv_initializer_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIterationAccumulatorAccess().getInitializerExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIterationAccumulator9653);
            lv_initializer_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIterationAccumulatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"initializer",
            	        		lv_initializer_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIterationAccumulator


    // $ANTLR start entryRuleArrayConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5526:1: entryRuleArrayConstructionOperator returns [EObject current=null] : iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF ;
    public final EObject entryRuleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5527:2: (iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5528:2: iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator9689);
            iv_ruleArrayConstructionOperator=ruleArrayConstructionOperator();
            _fsp--;

             current =iv_ruleArrayConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConstructionOperator9699); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArrayConstructionOperator


    // $ANTLR start ruleArrayConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5535:1: ruleArrayConstructionOperator returns [EObject current=null] : ( '{' ( (lv_expressions_1_0= ruleExpression ) ) ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) '}' ) ;
    public final EObject ruleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_iterationClauses_5_0 = null;

        EObject lv_iterationClauses_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5540:6: ( ( '{' ( (lv_expressions_1_0= ruleExpression ) ) ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5541:1: ( '{' ( (lv_expressions_1_0= ruleExpression ) ) ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5541:1: ( '{' ( (lv_expressions_1_0= ruleExpression ) ) ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5541:3: '{' ( (lv_expressions_1_0= ruleExpression ) ) ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) '}'
            {
            match(input,13,FOLLOW_13_in_ruleArrayConstructionOperator9734); 

                    createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5545:1: ( (lv_expressions_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5546:1: (lv_expressions_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5546:1: (lv_expressions_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5547:3: lv_expressions_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getExpressionsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleArrayConstructionOperator9755);
            lv_expressions_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressions",
            	        		lv_expressions_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5569:2: ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=14 && LA81_0<=15)) ) {
                alt81=1;
            }
            else if ( (LA81_0==55) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5569:2: ( ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) )", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5569:3: ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5569:3: ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==14) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5569:5: ',' ( (lv_expressions_3_0= ruleExpression ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleArrayConstructionOperator9767); 

                    	            createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getCommaKeyword_2_0_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5573:1: ( (lv_expressions_3_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5574:1: (lv_expressions_3_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5574:1: (lv_expressions_3_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5575:3: lv_expressions_3_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getExpressionsExpressionParserRuleCall_2_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleArrayConstructionOperator9788);
                    	    lv_expressions_3_0=ruleExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getArrayConstructionOperatorRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"expressions",
                    	    	        		lv_expressions_3_0, 
                    	    	        		"Expression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5598:6: ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5598:6: ( 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5598:8: 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )*
                    {
                    match(input,55,FOLLOW_55_in_ruleArrayConstructionOperator9807); 

                            createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getForKeyword_2_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:1: ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5603:1: (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5603:1: (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5604:3: lv_iterationClauses_5_0= ruleArrayConstructionIterationClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getIterationClausesArrayConstructionIterationClauseParserRuleCall_2_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator9828);
                    lv_iterationClauses_5_0=ruleArrayConstructionIterationClause();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArrayConstructionOperatorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"iterationClauses",
                    	        		lv_iterationClauses_5_0, 
                    	        		"ArrayConstructionIterationClause", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5626:2: ( ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==14) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5626:4: ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) )
                    	    {
                    	    match(input,14,FOLLOW_14_in_ruleArrayConstructionOperator9839); 

                    	            createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getCommaKeyword_2_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5630:1: ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5631:1: (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5631:1: (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5632:3: lv_iterationClauses_7_0= ruleArrayConstructionIterationClause
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getIterationClausesArrayConstructionIterationClauseParserRuleCall_2_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator9860);
                    	    lv_iterationClauses_7_0=ruleArrayConstructionIterationClause();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getArrayConstructionOperatorRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"iterationClauses",
                    	    	        		lv_iterationClauses_7_0, 
                    	    	        		"ArrayConstructionIterationClause", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop80;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleArrayConstructionOperator9874); 

                    createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getRightCurlyBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayConstructionOperator


    // $ANTLR start entryRuleArrayConstructionIterationClause
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5666:1: entryRuleArrayConstructionIterationClause returns [EObject current=null] : iv_ruleArrayConstructionIterationClause= ruleArrayConstructionIterationClause EOF ;
    public final EObject entryRuleArrayConstructionIterationClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConstructionIterationClause = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5667:2: (iv_ruleArrayConstructionIterationClause= ruleArrayConstructionIterationClause EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5668:2: iv_ruleArrayConstructionIterationClause= ruleArrayConstructionIterationClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConstructionIterationClauseRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConstructionIterationClause_in_entryRuleArrayConstructionIterationClause9910);
            iv_ruleArrayConstructionIterationClause=ruleArrayConstructionIterationClause();
            _fsp--;

             current =iv_ruleArrayConstructionIterationClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConstructionIterationClause9920); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArrayConstructionIterationClause


    // $ANTLR start ruleArrayConstructionIterationClause
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5675:1: ruleArrayConstructionIterationClause returns [EObject current=null] : ( ( (lv_variableName_0_0= RULE_ID ) ) 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleArrayConstructionIterationClause() throws RecognitionException {
        EObject current = null;

        Token lv_variableName_0_0=null;
        EObject lv_collectionExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5680:6: ( ( ( (lv_variableName_0_0= RULE_ID ) ) 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5681:1: ( ( (lv_variableName_0_0= RULE_ID ) ) 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5681:1: ( ( (lv_variableName_0_0= RULE_ID ) ) 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5681:2: ( (lv_variableName_0_0= RULE_ID ) ) 'in' ( (lv_collectionExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5681:2: ( (lv_variableName_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5682:1: (lv_variableName_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5682:1: (lv_variableName_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5683:3: lv_variableName_0_0= RULE_ID
            {
            lv_variableName_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrayConstructionIterationClause9962); 

            			createLeafNode(grammarAccess.getArrayConstructionIterationClauseAccess().getVariableNameIDTerminalRuleCall_0_0(), "variableName"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayConstructionIterationClauseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"variableName",
            	        		lv_variableName_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,41,FOLLOW_41_in_ruleArrayConstructionIterationClause9977); 

                    createLeafNode(grammarAccess.getArrayConstructionIterationClauseAccess().getInKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5709:1: ( (lv_collectionExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5710:1: (lv_collectionExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5710:1: (lv_collectionExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5711:3: lv_collectionExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionIterationClauseAccess().getCollectionExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleArrayConstructionIterationClause9998);
            lv_collectionExpression_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayConstructionIterationClauseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"collectionExpression",
            	        		lv_collectionExpression_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayConstructionIterationClause


    // $ANTLR start entryRuleArrayConcatenationOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5741:1: entryRuleArrayConcatenationOperator returns [EObject current=null] : iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF ;
    public final EObject entryRuleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConcatenationOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5742:2: (iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5743:2: iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConcatenationOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator10034);
            iv_ruleArrayConcatenationOperator=ruleArrayConcatenationOperator();
            _fsp--;

             current =iv_ruleArrayConcatenationOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConcatenationOperator10044); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArrayConcatenationOperator


    // $ANTLR start ruleArrayConcatenationOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5750:1: ruleArrayConcatenationOperator returns [EObject current=null] : ( '[' ( (lv_rows_1_0= ruleExpressionList ) ) ( ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_rows_1_0 = null;

        EObject lv_rows_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5755:6: ( ( '[' ( (lv_rows_1_0= ruleExpressionList ) ) ( ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5756:1: ( '[' ( (lv_rows_1_0= ruleExpressionList ) ) ( ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5756:1: ( '[' ( (lv_rows_1_0= ruleExpressionList ) ) ( ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5756:3: '[' ( (lv_rows_1_0= ruleExpressionList ) ) ( ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,33,FOLLOW_33_in_ruleArrayConcatenationOperator10079); 

                    createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5760:1: ( (lv_rows_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5761:1: (lv_rows_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5761:1: (lv_rows_1_0= ruleExpressionList )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5762:3: lv_rows_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getRowsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10100);
            lv_rows_1_0=ruleExpressionList();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayConcatenationOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"rows",
            	        		lv_rows_1_0, 
            	        		"ExpressionList", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5784:2: ( ';' ( (lv_rows_3_0= ruleExpressionList ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==18) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5784:4: ';' ( (lv_rows_3_0= ruleExpressionList ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleArrayConcatenationOperator10111); 

            	            createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5788:1: ( (lv_rows_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5789:1: (lv_rows_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5789:1: (lv_rows_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5790:3: lv_rows_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getRowsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10132);
            	    lv_rows_3_0=ruleExpressionList();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArrayConcatenationOperatorRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"rows",
            	    	        		lv_rows_3_0, 
            	    	        		"ExpressionList", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_ruleArrayConcatenationOperator10144); 

                    createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getRightSquareBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayConcatenationOperator


    // $ANTLR start entryRuleExpressionList
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5824:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5825:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5826:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList10180);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList10190); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpressionList


    // $ANTLR start ruleExpressionList
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5833:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5838:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5839:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5839:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5839:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5839:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5840:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5840:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5841:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10236);
            lv_expressions_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionListRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressions",
            	        		lv_expressions_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5863:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==14) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5863:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleExpressionList10247); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5867:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5868:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5868:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5869:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10268);
            	    lv_expressions_2_0=ruleExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getExpressionListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressions",
            	    	        		lv_expressions_2_0, 
            	    	        		"Expression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExpressionList


    // $ANTLR start entryRuleUnitConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5899:1: entryRuleUnitConstructionOperator returns [EObject current=null] : iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF ;
    public final EObject entryRuleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5900:2: (iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5901:2: iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10306);
            iv_ruleUnitConstructionOperator=ruleUnitConstructionOperator();
            _fsp--;

             current =iv_ruleUnitConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitConstructionOperator10316); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnitConstructionOperator


    // $ANTLR start ruleUnitConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5908:1: ruleUnitConstructionOperator returns [EObject current=null] : ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' ) ;
    public final EObject ruleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5913:6: ( ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5914:1: ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5914:1: ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5914:3: 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')'
            {
            match(input,53,FOLLOW_53_in_ruleUnitConstructionOperator10351); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitKeyword_0(), null); 
                
            match(input,25,FOLLOW_25_in_ruleUnitConstructionOperator10361); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5922:1: ( (lv_unit_2_0= ruleUnitExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5923:1: (lv_unit_2_0= ruleUnitExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5923:1: (lv_unit_2_0= ruleUnitExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5924:3: lv_unit_2_0= ruleUnitExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitUnitExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10382);
            lv_unit_2_0=ruleUnitExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"unit",
            	        		lv_unit_2_0, 
            	        		"UnitExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,26,FOLLOW_26_in_ruleUnitConstructionOperator10392); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitConstructionOperator


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5958:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5959:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5960:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10428);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression10438); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParenthesizedExpression


    // $ANTLR start ruleParenthesizedExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5967:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5972:6: ( ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5973:1: ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5973:1: ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5973:3: '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')'
            {
            match(input,25,FOLLOW_25_in_ruleParenthesizedExpression10473); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5977:1: ( (lv_expressions_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:1: (lv_expressions_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:1: (lv_expressions_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5979:3: lv_expressions_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10494);
            lv_expressions_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParenthesizedExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressions",
            	        		lv_expressions_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6001:2: ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==14) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6001:4: ',' ( (lv_expressions_3_0= ruleExpression ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleParenthesizedExpression10505); 

            	            createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6005:1: ( (lv_expressions_3_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6006:1: (lv_expressions_3_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6006:1: (lv_expressions_3_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6007:3: lv_expressions_3_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionsExpressionParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10526);
            	    lv_expressions_3_0=ruleExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getParenthesizedExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressions",
            	    	        		lv_expressions_3_0, 
            	    	        		"Expression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            match(input,26,FOLLOW_26_in_ruleParenthesizedExpression10538); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParenthesizedExpression


    // $ANTLR start entryRuleBeginExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6041:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6042:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6043:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10574);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression10584); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBeginExpression


    // $ANTLR start ruleBeginExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6050:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6055:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6056:1: ( () 'begin' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6056:1: ( () 'begin' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6056:2: () 'begin'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6056:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6057:5: 
            {
             
                    temp=factory.create(grammarAccess.getBeginExpressionAccess().getBeginExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getBeginExpressionAccess().getBeginExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,56,FOLLOW_56_in_ruleBeginExpression10628); 

                    createLeafNode(grammarAccess.getBeginExpressionAccess().getBeginKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBeginExpression


    // $ANTLR start entryRuleEndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6079:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6080:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6081:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression10664);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression10674); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEndExpression


    // $ANTLR start ruleEndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6088:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6093:6: ( ( () 'end' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6094:1: ( () 'end' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6094:1: ( () 'end' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6094:2: () 'end'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6094:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6095:5: 
            {
             
                    temp=factory.create(grammarAccess.getEndExpressionAccess().getEndExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getEndExpressionAccess().getEndExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,57,FOLLOW_57_in_ruleEndExpression10718); 

                    createLeafNode(grammarAccess.getEndExpressionAccess().getEndKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEndExpression


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6117:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6118:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6119:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10754);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6126:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_identifiers_0_0=null;
        Token lv_identifiers_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6131:6: ( ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6132:1: ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6132:1: ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6132:2: ( (lv_identifiers_0_0= RULE_ID ) ) ( '.' ( (lv_identifiers_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6132:2: ( (lv_identifiers_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6133:1: (lv_identifiers_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6133:1: (lv_identifiers_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6134:3: lv_identifiers_0_0= RULE_ID
            {
            lv_identifiers_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10806); 

            			createLeafNode(grammarAccess.getQualifiedNameAccess().getIdentifiersIDTerminalRuleCall_0_0(), "identifiers"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"identifiers",
            	        		lv_identifiers_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6156:2: ( '.' ( (lv_identifiers_2_0= RULE_ID ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==52) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6156:4: '.' ( (lv_identifiers_2_0= RULE_ID ) )
            	    {
            	    match(input,52,FOLLOW_52_in_ruleQualifiedName10822); 

            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6160:1: ( (lv_identifiers_2_0= RULE_ID ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6161:1: (lv_identifiers_2_0= RULE_ID )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6161:1: (lv_identifiers_2_0= RULE_ID )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6162:3: lv_identifiers_2_0= RULE_ID
            	    {
            	    lv_identifiers_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10839); 

            	    			createLeafNode(grammarAccess.getQualifiedNameAccess().getIdentifiersIDTerminalRuleCall_1_1_0(), "identifiers"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"identifiers",
            	    	        		lv_identifiers_2_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleUnitExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6192:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6193:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6194:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10882);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression10892); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnitExpression


    // $ANTLR start ruleUnitExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6201:1: ruleUnitExpression returns [EObject current=null] : ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_numerator_1_0 = null;

        EObject lv_denominator_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6206:6: ( ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6207:1: ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6207:1: ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6207:2: () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6207:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6208:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnitExpressionAccess().getUnitExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnitExpressionAccess().getUnitExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6218:2: ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ID||LA87_0==RULE_INTEGER) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6218:3: ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6218:3: ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6219:1: (lv_numerator_1_0= ruleUnitExpressionNumerator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6219:1: (lv_numerator_1_0= ruleUnitExpressionNumerator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6220:3: lv_numerator_1_0= ruleUnitExpressionNumerator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10948);
                    lv_numerator_1_0=ruleUnitExpressionNumerator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"numerator",
                    	        		lv_numerator_1_0, 
                    	        		"UnitExpressionNumerator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6242:2: ( '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==58) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6242:4: '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) )
                            {
                            match(input,58,FOLLOW_58_in_ruleUnitExpression10959); 

                                    createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_1_1_0(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6246:1: ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6247:1: (lv_denominator_3_0= ruleUnitExpressionDenominator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6247:1: (lv_denominator_3_0= ruleUnitExpressionDenominator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6248:3: lv_denominator_3_0= ruleUnitExpressionDenominator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10980);
                            lv_denominator_3_0=ruleUnitExpressionDenominator();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"denominator",
                            	        		lv_denominator_3_0, 
                            	        		"UnitExpressionDenominator", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpression


    // $ANTLR start entryRuleUnitExpressionNumerator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6278:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6279:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6280:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator11020);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator11030); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnitExpressionNumerator


    // $ANTLR start ruleUnitExpressionNumerator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6287:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6292:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6293:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6293:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_INTEGER) ) {
                alt89=1;
            }
            else if ( (LA89_0==RULE_ID) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6293:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6293:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6293:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6294:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6294:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6295:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator11072); 

                    			createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getOneINTEGERTerminalRuleCall_0_0(), "one"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionNumeratorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"one",
                    	        		lv_one_0_0, 
                    	        		"INTEGER", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6318:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6318:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6318:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6318:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6319:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6319:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6320:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11105);
                    lv_factors_1_0=ruleUnitExpressionFactor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionNumeratorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"factors",
                    	        		lv_factors_1_0, 
                    	        		"UnitExpressionFactor", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6342:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==59) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6342:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,59,FOLLOW_59_in_ruleUnitExpressionNumerator11116); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6346:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6347:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6347:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6348:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11137);
                    	    lv_factors_3_0=ruleUnitExpressionFactor();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUnitExpressionNumeratorRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"factors",
                    	    	        		lv_factors_3_0, 
                    	    	        		"UnitExpressionFactor", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionNumerator


    // $ANTLR start entryRuleUnitExpressionDenominator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6378:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6379:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6380:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11176);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11186); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnitExpressionDenominator


    // $ANTLR start ruleUnitExpressionDenominator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6387:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6392:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6393:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6393:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                alt91=1;
            }
            else if ( (LA91_0==25) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6393:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6393:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6393:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6394:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6394:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6395:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11232);
                    lv_factors_0_0=ruleUnitExpressionFactor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionDenominatorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"factors",
                    	        		lv_factors_0_0, 
                    	        		"UnitExpressionFactor", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6418:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6418:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6418:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,25,FOLLOW_25_in_ruleUnitExpressionDenominator11249); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6422:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6423:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6423:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6424:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11270);
                    lv_factors_2_0=ruleUnitExpressionFactor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionDenominatorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"factors",
                    	        		lv_factors_2_0, 
                    	        		"UnitExpressionFactor", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6446:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==59) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6446:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,59,FOLLOW_59_in_ruleUnitExpressionDenominator11281); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6450:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6451:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6451:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6452:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11302);
                    	    lv_factors_4_0=ruleUnitExpressionFactor();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUnitExpressionDenominatorRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"factors",
                    	    	        		lv_factors_4_0, 
                    	    	        		"UnitExpressionFactor", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);

                    match(input,26,FOLLOW_26_in_ruleUnitExpressionDenominator11314); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getRightParenthesisKeyword_1_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionDenominator


    // $ANTLR start entryRuleUnitExpressionFactor
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6486:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6487:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6488:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11351);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor11361); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnitExpressionFactor


    // $ANTLR start ruleUnitExpressionFactor
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6495:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;
        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6500:6: ( ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6501:1: ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6501:1: ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6501:2: ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6501:2: ( (lv_operand_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6502:1: (lv_operand_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6502:1: (lv_operand_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6503:3: lv_operand_0_0= RULE_ID
            {
            lv_operand_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitExpressionFactor11403); 

            			createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getOperandIDTerminalRuleCall_0_0(), "operand"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionFactorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6525:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==60) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6525:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,60,FOLLOW_60_in_ruleUnitExpressionFactor11419); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6531:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11440);
                    lv_exponent_2_0=ruleUnitExpressionExponent();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionFactorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exponent",
                    	        		lv_exponent_2_0, 
                    	        		"UnitExpressionExponent", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionFactor


    // $ANTLR start entryRuleUnitExpressionExponent
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6561:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6562:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6563:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11478);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent11488); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnitExpressionExponent


    // $ANTLR start ruleUnitExpressionExponent
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6570:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6575:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6576:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6576:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6576:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6576:2: ( (lv_negative_0_0= '-' ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==61) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6577:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6577:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6578:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_ruleUnitExpressionExponent11531); 

                            createLeafNode(grammarAccess.getUnitExpressionExponentAccess().getNegativeHyphenMinusKeyword_0_0(), "negative"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionExponentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "negative", true, "-", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6597:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6598:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6598:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6599:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11562); 

            			createLeafNode(grammarAccess.getUnitExpressionExponentAccess().getValueINTEGERTerminalRuleCall_1_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionExponentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"INTEGER", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionExponent


    // $ANTLR start ruleAssertionStatusKind
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6629:1: ruleAssertionStatusKind returns [Enumerator current=null] : ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) ) ;
    public final Enumerator ruleAssertionStatusKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6633:6: ( ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6634:1: ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6634:1: ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) )
            int alt94=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt94=1;
                }
                break;
            case 63:
                {
                alt94=2;
                }
                break;
            case 64:
                {
                alt94=3;
                }
                break;
            case 65:
                {
                alt94=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6634:1: ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) )", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6634:2: ( 'info' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6634:2: ( 'info' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6634:4: 'info'
                    {
                    match(input,62,FOLLOW_62_in_ruleAssertionStatusKind11615); 

                            current = grammarAccess.getAssertionStatusKindAccess().getInfoEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getInfoEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6640:6: ( 'warning' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6640:6: ( 'warning' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6640:8: 'warning'
                    {
                    match(input,63,FOLLOW_63_in_ruleAssertionStatusKind11630); 

                            current = grammarAccess.getAssertionStatusKindAccess().getWarningEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getWarningEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6646:6: ( 'error' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6646:6: ( 'error' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6646:8: 'error'
                    {
                    match(input,64,FOLLOW_64_in_ruleAssertionStatusKind11645); 

                            current = grammarAccess.getAssertionStatusKindAccess().getErrorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getErrorEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6652:6: ( 'fatal' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6652:6: ( 'fatal' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6652:8: 'fatal'
                    {
                    match(input,65,FOLLOW_65_in_ruleAssertionStatusKind11660); 

                            current = grammarAccess.getAssertionStatusKindAccess().getFatalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getFatalEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssertionStatusKind


    // $ANTLR start ruleEqualityOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6662:1: ruleEqualityOperator returns [Enumerator current=null] : ( ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6666:6: ( ( ( '==' ) | ( '!=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6667:1: ( ( '==' ) | ( '!=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6667:1: ( ( '==' ) | ( '!=' ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==66) ) {
                alt95=1;
            }
            else if ( (LA95_0==67) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6667:1: ( ( '==' ) | ( '!=' ) )", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6667:2: ( '==' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6667:2: ( '==' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6667:4: '=='
                    {
                    match(input,66,FOLLOW_66_in_ruleEqualityOperator11703); 

                            current = grammarAccess.getEqualityOperatorAccess().getEqualToEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getEqualToEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6673:6: ( '!=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6673:6: ( '!=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6673:8: '!='
                    {
                    match(input,67,FOLLOW_67_in_ruleEqualityOperator11718); 

                            current = grammarAccess.getEqualityOperatorAccess().getNotEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getNotEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEqualityOperator


    // $ANTLR start ruleRelationalOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6683:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6687:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6688:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6688:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) )
            int alt96=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt96=1;
                }
                break;
            case 68:
                {
                alt96=2;
                }
                break;
            case 24:
                {
                alt96=3;
                }
                break;
            case 69:
                {
                alt96=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6688:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) )", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6688:2: ( '<' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6688:2: ( '<' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6688:4: '<'
                    {
                    match(input,23,FOLLOW_23_in_ruleRelationalOperator11761); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6694:6: ( '<=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6694:6: ( '<=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6694:8: '<='
                    {
                    match(input,68,FOLLOW_68_in_ruleRelationalOperator11776); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6700:6: ( '>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6700:6: ( '>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6700:8: '>'
                    {
                    match(input,24,FOLLOW_24_in_ruleRelationalOperator11791); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6706:6: ( '>=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6706:6: ( '>=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6706:8: '>='
                    {
                    match(input,69,FOLLOW_69_in_ruleRelationalOperator11806); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRelationalOperator


    // $ANTLR start ruleAdditiveOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6716:1: ruleAdditiveOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6720:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6721:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6721:1: ( ( '+' ) | ( '-' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==70) ) {
                alt97=1;
            }
            else if ( (LA97_0==61) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6721:1: ( ( '+' ) | ( '-' ) )", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6721:2: ( '+' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6721:2: ( '+' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6721:4: '+'
                    {
                    match(input,70,FOLLOW_70_in_ruleAdditiveOperator11849); 

                            current = grammarAccess.getAdditiveOperatorAccess().getAdditionEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getAdditionEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:6: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:6: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:8: '-'
                    {
                    match(input,61,FOLLOW_61_in_ruleAdditiveOperator11864); 

                            current = grammarAccess.getAdditiveOperatorAccess().getSubtractionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getSubtractionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAdditiveOperator


    // $ANTLR start ruleMultiplicativeOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6737:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6741:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6742:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6742:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt98=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt98=1;
                }
                break;
            case 58:
                {
                alt98=2;
                }
                break;
            case 71:
                {
                alt98=3;
                }
                break;
            case 72:
                {
                alt98=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6742:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6742:2: ( '*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6742:2: ( '*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6742:4: '*'
                    {
                    match(input,59,FOLLOW_59_in_ruleMultiplicativeOperator11907); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMultiplicationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getMultiplicationEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6748:6: ( '/' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6748:6: ( '/' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6748:8: '/'
                    {
                    match(input,58,FOLLOW_58_in_ruleMultiplicativeOperator11922); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivisionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getDivisionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6754:6: ( '.*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6754:6: ( '.*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6754:8: '.*'
                    {
                    match(input,71,FOLLOW_71_in_ruleMultiplicativeOperator11937); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getElementWiseMultiplicationEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getElementWiseMultiplicationEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6760:6: ( './' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6760:6: ( './' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6760:8: './'
                    {
                    match(input,72,FOLLOW_72_in_ruleMultiplicativeOperator11952); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getElementWiseDivisionEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getElementWiseDivisionEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicativeOperator


    // $ANTLR start rulePowerOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6770:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6774:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6775:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6775:1: ( ( '^' ) | ( '.^' ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==60) ) {
                alt99=1;
            }
            else if ( (LA99_0==73) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6775:1: ( ( '^' ) | ( '.^' ) )", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6775:2: ( '^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6775:2: ( '^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6775:4: '^'
                    {
                    match(input,60,FOLLOW_60_in_rulePowerOperator11995); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6781:6: ( '.^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6781:6: ( '.^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6781:8: '.^'
                    {
                    match(input,73,FOLLOW_73_in_rulePowerOperator12010); 

                            current = grammarAccess.getPowerOperatorAccess().getElementWisePowerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getElementWisePowerEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePowerOperator


    // $ANTLR start ruleUnaryOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6791:1: ruleUnaryOperator returns [Enumerator current=null] : ( ( '-' ) | ( '!' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6795:6: ( ( ( '-' ) | ( '!' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6796:1: ( ( '-' ) | ( '!' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6796:1: ( ( '-' ) | ( '!' ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==61) ) {
                alt100=1;
            }
            else if ( (LA100_0==74) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6796:1: ( ( '-' ) | ( '!' ) )", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6796:2: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6796:2: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6796:4: '-'
                    {
                    match(input,61,FOLLOW_61_in_ruleUnaryOperator12053); 

                            current = grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6802:6: ( '!' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6802:6: ( '!' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6802:8: '!'
                    {
                    match(input,74,FOLLOW_74_in_ruleUnaryOperator12068); 

                            current = grammarAccess.getUnaryOperatorAccess().getLogicalNotEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getLogicalNotEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnaryOperator


    // $ANTLR start rulePostfixOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6812:1: rulePostfixOperator returns [Enumerator current=null] : ( '\\'' ) ;
    public final Enumerator rulePostfixOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6816:6: ( ( '\\'' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6817:1: ( '\\'' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6817:1: ( '\\'' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6817:3: '\\''
            {
            match(input,75,FOLLOW_75_in_rulePostfixOperator12110); 

                    current = grammarAccess.getPostfixOperatorAccess().getTransposeEnumLiteralDeclaration().getEnumLiteral().getInstance();
                    createLeafNode(grammarAccess.getPostfixOperatorAccess().getTransposeEnumLiteralDeclaration(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePostfixOperator


    // $ANTLR start ruleBooleanKind
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6827:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6831:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6832:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6832:1: ( ( 'false' ) | ( 'true' ) )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==76) ) {
                alt101=1;
            }
            else if ( (LA101_0==77) ) {
                alt101=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6832:1: ( ( 'false' ) | ( 'true' ) )", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6832:2: ( 'false' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6832:2: ( 'false' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6832:4: 'false'
                    {
                    match(input,76,FOLLOW_76_in_ruleBooleanKind12152); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6838:6: ( 'true' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6838:6: ( 'true' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6838:8: 'true'
                    {
                    match(input,77,FOLLOW_77_in_ruleBooleanKind12167); 

                            current = grammarAccess.getBooleanKindAccess().getTrueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getTrueEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanKind


    protected DFA71 dfa71 = new DFA71(this);
    static final String DFA71_eotS =
        "\11\uffff";
    static final String DFA71_eofS =
        "\11\uffff";
    static final String DFA71_minS =
        "\1\31\2\uffff\1\4\1\uffff\1\16\1\4\1\uffff\1\16";
    static final String DFA71_maxS =
        "\1\64\2\uffff\1\115\1\uffff\1\113\1\115\1\uffff\1\113";
    static final String DFA71_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\2\uffff\1\4\1\uffff";
    static final String DFA71_specialS =
        "\11\uffff}>";
    static final String[] DFA71_transitionS = {
            "\1\3\7\uffff\1\2\22\uffff\1\1",
            "",
            "",
            "\1\5\3\4\5\uffff\1\4\13\uffff\2\4\6\uffff\1\4\6\uffff\1\4\1"+
            "\uffff\1\4\2\uffff\1\4\7\uffff\1\4\2\uffff\2\4\3\uffff\1\4\14"+
            "\uffff\1\4\1\uffff\2\4",
            "",
            "\1\6\3\uffff\1\7\1\uffff\1\4\2\uffff\4\4\6\uffff\1\4\16\uffff"+
            "\5\4\1\uffff\1\7\3\uffff\4\4\4\uffff\10\4\1\uffff\1\4",
            "\1\10\3\4\5\uffff\1\4\13\uffff\1\4\7\uffff\1\4\6\uffff\1\4\1"+
            "\uffff\1\4\2\uffff\1\4\7\uffff\1\4\2\uffff\2\4\3\uffff\1\4\14"+
            "\uffff\1\4\1\uffff\2\4",
            "",
            "\1\6\3\uffff\1\7\1\uffff\1\4\2\uffff\4\4\6\uffff\1\4\16\uffff"+
            "\5\4\1\uffff\1\7\3\uffff\4\4\4\uffff\10\4\1\uffff\1\4"
    };

    static final short[] DFA71_eot = DFA.unpackEncodedString(DFA71_eotS);
    static final short[] DFA71_eof = DFA.unpackEncodedString(DFA71_eofS);
    static final char[] DFA71_min = DFA.unpackEncodedStringToUnsignedChars(DFA71_minS);
    static final char[] DFA71_max = DFA.unpackEncodedStringToUnsignedChars(DFA71_maxS);
    static final short[] DFA71_accept = DFA.unpackEncodedString(DFA71_acceptS);
    static final short[] DFA71_special = DFA.unpackEncodedString(DFA71_specialS);
    static final short[][] DFA71_transition;

    static {
        int numStates = DFA71_transitionS.length;
        DFA71_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA71_transition[i] = DFA.unpackEncodedString(DFA71_transitionS[i]);
        }
    }

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = DFA71_eot;
            this.eof = DFA71_eof;
            this.min = DFA71_min;
            this.max = DFA71_max;
            this.accept = DFA71_accept;
            this.special = DFA71_special;
            this.transition = DFA71_transition;
        }
        public String getDescription() {
            return "4889:1: (this_FeatureAccess_0= ruleFeatureAccess | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationCall_2= ruleOperationCall | this_IterationCall_3= ruleIterationCall )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleModule130 = new BitSet(new long[]{0x0000000000691002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeDefinition_in_ruleDefinition223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_ruleDefinition250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeDefinition_in_entryRuleDataTypeDefinition285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeDefinition295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_ruleDataTypeDefinition342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_ruleDataTypeDefinition369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAliasDefinition_in_ruleDataTypeDefinition396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationDefinition441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleEnumerationDefinition476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationDefinition493 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationDefinition508 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition530 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationDefinition541 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition562 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationDefinition576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationLiteralDeclaration663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAliasDefinition_in_entryRuleTypeAliasDefinition703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAliasDefinition713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTypeAliasDefinition748 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeAliasDefinition765 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeAliasDefinition780 = new BitSet(new long[]{0x000000F900000000L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeAliasDefinition801 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTypeAliasDefinition811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordDefinition857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleRecordDefinition892 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordDefinition909 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRecordDefinition924 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition945 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleRecordDefinition956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordFieldDeclaration1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordFieldDeclaration1044 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleRecordFieldDeclaration1059 = new BitSet(new long[]{0x000000F900000010L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1080 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRecordFieldDeclaration1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFunctionDefinition1179 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFunctionDefinition1203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionDefinition1220 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleFunctionDefinition1236 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1257 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1289 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleFunctionDefinition1301 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFunctionDefinition1313 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1335 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1346 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1367 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleFunctionDefinition1381 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleFunctionDefinition1391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1412 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1423 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1444 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleFunctionDefinition1456 = new BitSet(new long[]{0x23202502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleAssertionStatement_in_ruleFunctionDefinition1478 = new BitSet(new long[]{0x23202502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleFunctorDeclaration_in_ruleFunctionDefinition1505 = new BitSet(new long[]{0x23202502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleStateVariableDeclaration_in_ruleFunctionDefinition1532 = new BitSet(new long[]{0x23202502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleEquationStatement_in_ruleFunctionDefinition1559 = new BitSet(new long[]{0x23202502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_15_in_ruleFunctionDefinition1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterDeclaration1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameterDeclaration1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertionStatement_in_entryRuleAssertionStatement1698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertionStatement1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAssertionStatement1751 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAssertionStatement1775 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssertionStatement1796 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssertionStatement1806 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleAssertionStatusKind_in_ruleAssertionStatement1827 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssertionStatement1848 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssertionStatement1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateVariableDeclaration_in_entryRuleStateVariableDeclaration1894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateVariableDeclaration1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleStateVariableDeclaration1939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateVariableDeclaration1956 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStateVariableDeclaration1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctorDeclaration_in_entryRuleFunctorDeclaration2007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctorDeclaration2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleFunctorDeclaration2052 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctorDeclaration2069 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFunctorDeclaration2084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFunctorDeclaration2105 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_23_in_ruleFunctorDeclaration2116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2137 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleFunctorDeclaration2148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2169 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleFunctorDeclaration2181 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunctorDeclaration2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentDeclaration_in_entryRuleArgumentDeclaration2229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentDeclaration2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArgumentDeclaration2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquationStatement_in_entryRuleEquationStatement2320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquationStatement2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEquationStatement2376 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEquationStatement2386 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEquationStatement2407 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEquationStatement2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeSpecifier2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericTypeSpecifier_in_rulePrimitiveTypeSpecifier2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericTypeSpecifier_in_entryRuleNumericTypeSpecifier2718 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericTypeSpecifier2728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericTypeSpecifier2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericTypeSpecifier2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericTypeSpecifier2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericTypeSpecifier2856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier2891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRealTypeSpecifier2945 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleRealTypeSpecifier2956 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier2977 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleRealTypeSpecifier2987 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleRealTypeSpecifier3000 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3021 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleRealTypeSpecifier3032 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3053 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleRealTypeSpecifier3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier3103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleIntegerTypeSpecifier3157 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleIntegerTypeSpecifier3168 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier3189 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIntegerTypeSpecifier3199 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleIntegerTypeSpecifier3212 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3233 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleIntegerTypeSpecifier3244 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3265 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleIntegerTypeSpecifier3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier3315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier3325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComplexTypeSpecifier3369 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleComplexTypeSpecifier3380 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3401 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleComplexTypeSpecifier3411 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleComplexTypeSpecifier3424 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3445 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleComplexTypeSpecifier3456 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3477 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleComplexTypeSpecifier3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGaussianTypeSpecifier3581 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleGaussianTypeSpecifier3592 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3613 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleGaussianTypeSpecifier3623 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleGaussianTypeSpecifier3636 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3657 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleGaussianTypeSpecifier3668 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3689 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleGaussianTypeSpecifier3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleBooleanTypeSpecifier3793 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanTypeSpecifier3804 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3825 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleBooleanTypeSpecifier3836 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3857 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleBooleanTypeSpecifier3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier3907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringTypeSpecifier3961 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleStringTypeSpecifier3972 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier3993 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleStringTypeSpecifier4004 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4025 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleStringTypeSpecifier4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier4075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTypeSpecifier4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier4131 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleNamedTypeSpecifier4142 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4163 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedTypeSpecifier4174 = new BitSet(new long[]{0x23202506020060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4195 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleNamedTypeSpecifier4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification4245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayDimensionSpecification4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification4310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_ruleExpression4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_ruleExpression4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_ruleExpression4458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_entryRuleLetExpression4520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpression4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleLetExpression4565 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4586 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_14_in_ruleLetExpression4597 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4618 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_41_in_ruleLetExpression4630 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpressionVariable_in_entryRuleLetExpressionVariable4687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpressionVariable4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLetExpressionVariable4739 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLetExpressionVariable4754 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpressionVariable4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression4811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleIfExpression4856 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression4877 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleIfExpression4887 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression4908 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleIfExpression4918 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression4975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchExpression4985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleSwitchExpression5020 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression5041 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchExpression5062 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_46_in_ruleSwitchExpression5073 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSwitchExpression5083 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression5104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase5140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchCase5150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSwitchCase5185 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleSwitchCase5206 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSwitchCase5216 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchCase5237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression5273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5330 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleRangeExpression5349 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5370 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleRangeExpression5381 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression5442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImpliesExpression5452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5499 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_ruleImpliesExpression5518 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression5587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5634 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleLogicalOrExpression5654 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5675 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression5772 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLogicalAndExpression5792 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression5813 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5910 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression5940 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression6009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6056 = new BitSet(new long[]{0x0008000001800002L,0x0000000000000030L});
    public static final BitSet FOLLOW_51_in_ruleRelationalExpression6085 = new BitSet(new long[]{0x000000F900000010L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6148 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression6219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6266 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6296 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6391 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpression6505 = new BitSet(new long[]{0x0C00000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6535 = new BitSet(new long[]{0x0C00000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6630 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpressionPart6651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression6687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression6697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rulePowerExpression6744 = new BitSet(new long[]{0x1000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression6774 = new BitSet(new long[]{0x23200002020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rulePowerExpression6795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6926 = new BitSet(new long[]{0x03200002020020F0L,0x0000000000003000L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7041 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_rulePostfixOperator_in_rulePostfixExpression7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression7166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression7220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression7274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression7309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallablePrimaryExpression7319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_ruleCallablePrimaryExpression7366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_ruleCallablePrimaryExpression7393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression7420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral7455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral7465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericLiteral_in_ruleLiteral7512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral7539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral7566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericLiteral_in_entryRuleNumericLiteral7601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericLiteral7611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericLiteral7658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericLiteral7685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral7730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral7772 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealLiteral7794 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleRealLiteral7811 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral7832 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleRealLiteral7842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral7880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral7890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral7932 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerLiteral7954 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleIntegerLiteral7971 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral7992 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIntegerLiteral8002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral8095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral8130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral8140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral8181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleName_in_entryRuleSimpleName8221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleName8231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleName8282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall8333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall8381 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8411 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleSimpleName_in_ruleFeatureCall8452 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8473 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart8511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallPart8521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureAccess_in_ruleFeatureCallPart8568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementAccess_in_ruleFeatureCallPart8595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_ruleFeatureCallPart8622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationCall_in_ruleFeatureCallPart8649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureAccess_in_entryRuleFeatureAccess8684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureAccess8694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleFeatureAccess8729 = new BitSet(new long[]{0x0020000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureAccess8748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleFeatureAccess8769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementAccess_in_entryRuleArrayElementAccess8821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayElementAccess8831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArrayElementAccess8866 = new BitSet(new long[]{0x23202502021020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess8887 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleArrayElementAccess8898 = new BitSet(new long[]{0x23202502021020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess8919 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleArrayElementAccess8931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArraySubscript_in_entryRuleArraySubscript8967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArraySubscript8977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleArraySubscript9020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArraySubscript9060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_entryRuleOperationCall9096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCall9106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOperationCall9150 = new BitSet(new long[]{0x23202502060020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall9172 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleOperationCall9183 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall9204 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleOperationCall9218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationCall_in_entryRuleIterationCall9254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIterationCall9264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleIterationCall9308 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIterationVariable_in_ruleIterationCall9329 = new BitSet(new long[]{0x0040000000044000L});
    public static final BitSet FOLLOW_14_in_ruleIterationCall9340 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIterationVariable_in_ruleIterationCall9361 = new BitSet(new long[]{0x0040000000044000L});
    public static final BitSet FOLLOW_18_in_ruleIterationCall9374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIterationAccumulator_in_ruleIterationCall9395 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleIterationCall9407 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIterationCall9428 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIterationCall9438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationVariable_in_entryRuleIterationVariable9474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIterationVariable9484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIterationVariable9525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationAccumulator_in_entryRuleIterationAccumulator9565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIterationAccumulator9575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIterationAccumulator9617 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIterationAccumulator9632 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIterationAccumulator9653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator9689 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConstructionOperator9699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleArrayConstructionOperator9734 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayConstructionOperator9755 = new BitSet(new long[]{0x008000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleArrayConstructionOperator9767 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayConstructionOperator9788 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_55_in_ruleArrayConstructionOperator9807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator9828 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleArrayConstructionOperator9839 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator9860 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleArrayConstructionOperator9874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionIterationClause_in_entryRuleArrayConstructionIterationClause9910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConstructionIterationClause9920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrayConstructionIterationClause9962 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleArrayConstructionIterationClause9977 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayConstructionIterationClause9998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator10034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConcatenationOperator10044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArrayConcatenationOperator10079 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10100 = new BitSet(new long[]{0x0000000400040000L});
    public static final BitSet FOLLOW_18_in_ruleArrayConcatenationOperator10111 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10132 = new BitSet(new long[]{0x0000000400040000L});
    public static final BitSet FOLLOW_34_in_ruleArrayConcatenationOperator10144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList10180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList10190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10236 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionList10247 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10268 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitConstructionOperator10316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleUnitConstructionOperator10351 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleUnitConstructionOperator10361 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10382 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUnitConstructionOperator10392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression10438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleParenthesizedExpression10473 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10494 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedExpression10505 = new BitSet(new long[]{0x23202502020020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10526 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedExpression10538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression10584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBeginExpression10628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression10664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression10674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleEndExpression10718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10806 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_ruleQualifiedName10822 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10839 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression10892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10948 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUnitExpression10959 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator11020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator11030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator11072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11105 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUnitExpressionNumerator11116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11137 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleUnitExpressionDenominator11249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11270 = new BitSet(new long[]{0x0800000004000000L});
    public static final BitSet FOLLOW_59_in_ruleUnitExpressionDenominator11281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11302 = new BitSet(new long[]{0x0800000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUnitExpressionDenominator11314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor11361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitExpressionFactor11403 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUnitExpressionFactor11419 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent11488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnitExpressionExponent11531 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAssertionStatusKind11615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAssertionStatusKind11630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAssertionStatusKind11645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAssertionStatusKind11660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleEqualityOperator11703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleEqualityOperator11718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleRelationalOperator11761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRelationalOperator11776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRelationalOperator11791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleRelationalOperator11806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAdditiveOperator11849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleAdditiveOperator11864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleMultiplicativeOperator11907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMultiplicativeOperator11922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleMultiplicativeOperator11937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplicativeOperator11952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rulePowerOperator11995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rulePowerOperator12010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnaryOperator12053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleUnaryOperator12068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rulePostfixOperator12110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleBooleanKind12152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleBooleanKind12167 = new BitSet(new long[]{0x0000000000000002L});

}