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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'enumeration'", "','", "'('", "')'", "'='", "';'", "'if'", "'elseif'", "'else'", "'while'", "'real'", "'integer'", "'complex'", "'gaussian'", "'boolean'", "'string'", "'then'", "':'", "'or'", "'and'", "'not'", "'-'", "'j'", "'::'", "'['", "']'", "'.'", "'begin'", "'end'", "'/'", "'*'", "'^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'<>'", "'+'", "'.*'", "'./'", "'.^'", "'false'", "'true'"
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
        	return "Mscript";	
       	}
       	
       	@Override
       	protected MscriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleMscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:78:1: entryRuleMscript returns [EObject current=null] : iv_ruleMscript= ruleMscript EOF ;
    public final EObject entryRuleMscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:79:2: (iv_ruleMscript= ruleMscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:80:2: iv_ruleMscript= ruleMscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleMscript_in_entryRuleMscript75);
            iv_ruleMscript=ruleMscript();
            _fsp--;

             current =iv_ruleMscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMscript85); 

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
    // $ANTLR end entryRuleMscript


    // $ANTLR start ruleMscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:87:1: ruleMscript returns [EObject current=null] : ( (lv_packages_0_0= rulePackageDefinition ) )* ;
    public final EObject ruleMscript() throws RecognitionException {
        EObject current = null;

        EObject lv_packages_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:92:6: ( ( (lv_packages_0_0= rulePackageDefinition ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_packages_0_0= rulePackageDefinition ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_packages_0_0= rulePackageDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:94:1: (lv_packages_0_0= rulePackageDefinition )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:94:1: (lv_packages_0_0= rulePackageDefinition )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:95:3: lv_packages_0_0= rulePackageDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMscriptAccess().getPackagesPackageDefinitionParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageDefinition_in_ruleMscript130);
            	    lv_packages_0_0=rulePackageDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMscriptRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"packages",
            	    	        		lv_packages_0_0, 
            	    	        		"PackageDefinition", 
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
    // $ANTLR end ruleMscript


    // $ANTLR start entryRulePackageDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:125:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:126:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:127:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition166);
            iv_rulePackageDefinition=rulePackageDefinition();
            _fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition176); 

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
    // $ANTLR end entryRulePackageDefinition


    // $ANTLR start rulePackageDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:134:1: rulePackageDefinition returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:139:6: ( ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:1: ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:1: ( 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:3: 'package' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}'
            {
            match(input,12,FOLLOW_12_in_rulePackageDefinition211); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:144:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:145:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:145:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:146:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDefinition232);
            lv_name_1_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPackageDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_rulePackageDefinition242); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:172:1: ( (lv_elements_3_0= rulePackageDefinitionElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||LA2_0==12||LA2_0==15||(LA2_0>=25 && LA2_0<=30)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:173:1: (lv_elements_3_0= rulePackageDefinitionElement )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:173:1: (lv_elements_3_0= rulePackageDefinitionElement )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:174:3: lv_elements_3_0= rulePackageDefinitionElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPackageDefinitionAccess().getElementsPackageDefinitionElementParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageDefinitionElement_in_rulePackageDefinition263);
            	    lv_elements_3_0=rulePackageDefinitionElement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPackageDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_3_0, 
            	    	        		"PackageDefinitionElement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_rulePackageDefinition274); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end rulePackageDefinition


    // $ANTLR start entryRulePackageDefinitionElement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:208:1: entryRulePackageDefinitionElement returns [EObject current=null] : iv_rulePackageDefinitionElement= rulePackageDefinitionElement EOF ;
    public final EObject entryRulePackageDefinitionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinitionElement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:209:2: (iv_rulePackageDefinitionElement= rulePackageDefinitionElement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:210:2: iv_rulePackageDefinitionElement= rulePackageDefinitionElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageDefinitionElementRule(), currentNode); 
            pushFollow(FOLLOW_rulePackageDefinitionElement_in_entryRulePackageDefinitionElement310);
            iv_rulePackageDefinitionElement=rulePackageDefinitionElement();
            _fsp--;

             current =iv_rulePackageDefinitionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinitionElement320); 

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
    // $ANTLR end entryRulePackageDefinitionElement


    // $ANTLR start rulePackageDefinitionElement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:217:1: rulePackageDefinitionElement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_VariableDeclaration_3= ruleVariableDeclaration ) ;
    public final EObject rulePackageDefinitionElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_EnumerationDefinition_1 = null;

        EObject this_FunctionDefinition_2 = null;

        EObject this_VariableDeclaration_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:222:6: ( (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_VariableDeclaration_3= ruleVariableDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_VariableDeclaration_3= ruleVariableDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_VariableDeclaration_3= ruleVariableDeclaration )
            int alt3=4;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:224:5: this_PackageDefinition_0= rulePackageDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getPackageDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePackageDefinition_in_rulePackageDefinitionElement367);
                    this_PackageDefinition_0=rulePackageDefinition();
                    _fsp--;

                     
                            current = this_PackageDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:234:5: this_EnumerationDefinition_1= ruleEnumerationDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getEnumerationDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumerationDefinition_in_rulePackageDefinitionElement394);
                    this_EnumerationDefinition_1=ruleEnumerationDefinition();
                    _fsp--;

                     
                            current = this_EnumerationDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:244:5: this_FunctionDefinition_2= ruleFunctionDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getFunctionDefinitionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_rulePackageDefinitionElement421);
                    this_FunctionDefinition_2=ruleFunctionDefinition();
                    _fsp--;

                     
                            current = this_FunctionDefinition_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:254:5: this_VariableDeclaration_3= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getVariableDeclarationParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_rulePackageDefinitionElement448);
                    this_VariableDeclaration_3=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_3; 
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
    // $ANTLR end rulePackageDefinitionElement


    // $ANTLR start entryRuleEnumerationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:270:1: entryRuleEnumerationDefinition returns [EObject current=null] : iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF ;
    public final EObject entryRuleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:271:2: (iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:272:2: iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition483);
            iv_ruleEnumerationDefinition=ruleEnumerationDefinition();
            _fsp--;

             current =iv_ruleEnumerationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationDefinition493); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:279:1: ruleEnumerationDefinition returns [EObject current=null] : ( 'enumeration' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) ;
    public final EObject ruleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:284:6: ( ( 'enumeration' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:285:1: ( 'enumeration' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:285:1: ( 'enumeration' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:285:3: 'enumeration' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}'
            {
            match(input,15,FOLLOW_15_in_ruleEnumerationDefinition528); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getEnumerationKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:289:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:290:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:290:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationDefinition545); 

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

            match(input,13,FOLLOW_13_in_ruleEnumerationDefinition560); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:317:1: ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:317:2: ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:317:2: ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:318:1: (lv_literals_3_0= ruleEnumerationLiteralDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:318:1: (lv_literals_3_0= ruleEnumerationLiteralDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:319:3: lv_literals_3_0= ruleEnumerationLiteralDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDeclarationParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition582);
                    lv_literals_3_0=ruleEnumerationLiteralDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"literals",
                    	        		lv_literals_3_0, 
                    	        		"EnumerationLiteralDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:341:2: ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:341:4: ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleEnumerationDefinition593); 

                    	            createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:345:1: ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:346:1: (lv_literals_5_0= ruleEnumerationLiteralDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:346:1: (lv_literals_5_0= ruleEnumerationLiteralDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:347:3: lv_literals_5_0= ruleEnumerationLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDeclarationParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition614);
                    	    lv_literals_5_0=ruleEnumerationLiteralDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"literals",
                    	    	        		lv_literals_5_0, 
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

            match(input,14,FOLLOW_14_in_ruleEnumerationDefinition628); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:381:1: entryRuleEnumerationLiteralDeclaration returns [EObject current=null] : iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF ;
    public final EObject entryRuleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:382:2: (iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:383:2: iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationLiteralDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration664);
            iv_ruleEnumerationLiteralDeclaration=ruleEnumerationLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumerationLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration674); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:390:1: ruleEnumerationLiteralDeclaration returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:395:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:396:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:396:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:397:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:397:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:398:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationLiteralDeclaration715); 

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


    // $ANTLR start entryRuleFunctionDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:428:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:429:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:430:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition755);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();
            _fsp--;

             current =iv_ruleFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition765); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:437:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleDataTypeSpecifier ) )? ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_returnType_0_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_body_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:442:6: ( ( ( (lv_returnType_0_0= ruleDataTypeSpecifier ) )? ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:443:1: ( ( (lv_returnType_0_0= ruleDataTypeSpecifier ) )? ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:443:1: ( ( (lv_returnType_0_0= ruleDataTypeSpecifier ) )? ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:443:2: ( (lv_returnType_0_0= ruleDataTypeSpecifier ) )? ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:443:2: ( (lv_returnType_0_0= ruleDataTypeSpecifier ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=25 && LA6_0<=30)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==RULE_ID||LA6_2==38) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:444:1: (lv_returnType_0_0= ruleDataTypeSpecifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:444:1: (lv_returnType_0_0= ruleDataTypeSpecifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:445:3: lv_returnType_0_0= ruleDataTypeSpecifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getReturnTypeDataTypeSpecifierParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleFunctionDefinition811);
                    lv_returnType_0_0=ruleDataTypeSpecifier();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"returnType",
                    	        		lv_returnType_0_0, 
                    	        		"DataTypeSpecifier", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:467:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:468:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:468:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:469:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionDefinition829); 

            			createLeafNode(grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
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

            match(input,17,FOLLOW_17_in_ruleFunctionDefinition844); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:495:1: ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=25 && LA8_0<=30)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:495:2: ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:495:2: ( (lv_parameters_3_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:496:1: (lv_parameters_3_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:496:1: (lv_parameters_3_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:497:3: lv_parameters_3_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterDeclarationParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition866);
                    lv_parameters_3_0=ruleParameterDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"parameters",
                    	        		lv_parameters_3_0, 
                    	        		"ParameterDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:519:2: ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:519:4: ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionDefinition877); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:523:1: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:524:1: (lv_parameters_5_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:524:1: (lv_parameters_5_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:525:3: lv_parameters_5_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterDeclarationParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition898);
                    	    lv_parameters_5_0=ruleParameterDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"parameters",
                    	    	        		lv_parameters_5_0, 
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
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleFunctionDefinition912); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:551:1: ( (lv_body_7_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:552:1: (lv_body_7_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:552:1: (lv_body_7_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:553:3: lv_body_7_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunctionDefinition933);
            lv_body_7_0=ruleBlock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_7_0, 
            	        		"Block", 
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
    // $ANTLR end ruleFunctionDefinition


    // $ANTLR start entryRuleParameterDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:583:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:584:2: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:585:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration969);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();
            _fsp--;

             current =iv_ruleParameterDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterDeclaration979); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:592:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:597:6: ( ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:598:1: ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:598:1: ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:598:2: ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:598:2: ( (lv_type_0_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:599:1: (lv_type_0_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:599:1: (lv_type_0_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:600:3: lv_type_0_0= ruleDataTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeDataTypeSpecifierParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleParameterDeclaration1025);
            lv_type_0_0=ruleDataTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_0_0, 
            	        		"DataTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:622:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:623:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:623:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:624:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameterDeclaration1042); 

            			createLeafNode(grammarAccess.getParameterDeclarationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
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


    // $ANTLR start entryRuleStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:654:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:655:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:656:2: iv_ruleStatement= ruleStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement1083);
            iv_ruleStatement=ruleStatement();
            _fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement1093); 

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
    // $ANTLR end entryRuleStatement


    // $ANTLR start ruleStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:663:1: ruleStatement returns [EObject current=null] : (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_VariableDeclaration_4= ruleVariableDeclaration ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Block_0 = null;

        EObject this_FeatureCallStatement_1 = null;

        EObject this_IfStatement_2 = null;

        EObject this_WhileStatement_3 = null;

        EObject this_VariableDeclaration_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:668:6: ( (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_VariableDeclaration_4= ruleVariableDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:669:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_VariableDeclaration_4= ruleVariableDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:669:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_VariableDeclaration_4= ruleVariableDeclaration )
            int alt9=5;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:670:5: this_Block_0= ruleBlock
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1140);
                    this_Block_0=ruleBlock();
                    _fsp--;

                     
                            current = this_Block_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:680:5: this_FeatureCallStatement_1= ruleFeatureCallStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getFeatureCallStatementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCallStatement_in_ruleStatement1167);
                    this_FeatureCallStatement_1=ruleFeatureCallStatement();
                    _fsp--;

                     
                            current = this_FeatureCallStatement_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:690:5: this_IfStatement_2= ruleIfStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement1194);
                    this_IfStatement_2=ruleIfStatement();
                    _fsp--;

                     
                            current = this_IfStatement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:700:5: this_WhileStatement_3= ruleWhileStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1221);
                    this_WhileStatement_3=ruleWhileStatement();
                    _fsp--;

                     
                            current = this_WhileStatement_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:710:5: this_VariableDeclaration_4= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStatement1248);
                    this_VariableDeclaration_4=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_4; 
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
    // $ANTLR end ruleStatement


    // $ANTLR start entryRuleBlock
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:726:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:727:2: (iv_ruleBlock= ruleBlock EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:728:2: iv_ruleBlock= ruleBlock EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockRule(), currentNode); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock1283);
            iv_ruleBlock=ruleBlock();
            _fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock1293); 

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
    // $ANTLR end entryRuleBlock


    // $ANTLR start ruleBlock
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:735:1: ruleBlock returns [EObject current=null] : ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:740:6: ( ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:741:1: ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:741:1: ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:741:2: () '{' ( (lv_statements_2_0= ruleStatement ) )* '}'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:741:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:742:5: 
            {
             
                    temp=factory.create(grammarAccess.getBlockAccess().getBlockAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getBlockAccess().getBlockAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,13,FOLLOW_13_in_ruleBlock1337); 

                    createLeafNode(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:756:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==13||LA10_0==21||(LA10_0>=24 && LA10_0<=30)||LA10_0==38) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:757:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:757:1: (lv_statements_2_0= ruleStatement )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:758:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock1358);
            	    lv_statements_2_0=ruleStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBlockRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"statements",
            	    	        		lv_statements_2_0, 
            	    	        		"Statement", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleBlock1369); 

                    createLeafNode(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleBlock


    // $ANTLR start entryRuleFeatureCallStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:792:1: entryRuleFeatureCallStatement returns [EObject current=null] : iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF ;
    public final EObject entryRuleFeatureCallStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:793:2: (iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:794:2: iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallStatement_in_entryRuleFeatureCallStatement1405);
            iv_ruleFeatureCallStatement=ruleFeatureCallStatement();
            _fsp--;

             current =iv_ruleFeatureCallStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallStatement1415); 

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
    // $ANTLR end entryRuleFeatureCallStatement


    // $ANTLR start ruleFeatureCallStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:801:1: ruleFeatureCallStatement returns [EObject current=null] : ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' ) ;
    public final EObject ruleFeatureCallStatement() throws RecognitionException {
        EObject current = null;

        Token lv_assignment_1_0=null;
        EObject lv_featureCall_0_0 = null;

        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:806:6: ( ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:807:1: ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:807:1: ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:807:2: ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:807:2: ( (lv_featureCall_0_0= ruleFeatureCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:808:1: (lv_featureCall_0_0= ruleFeatureCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:808:1: (lv_featureCall_0_0= ruleFeatureCall )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:809:3: lv_featureCall_0_0= ruleFeatureCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFeatureCallStatementAccess().getFeatureCallFeatureCallParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFeatureCall_in_ruleFeatureCallStatement1461);
            lv_featureCall_0_0=ruleFeatureCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFeatureCallStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"featureCall",
            	        		lv_featureCall_0_0, 
            	        		"FeatureCall", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:831:2: ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:831:3: ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:831:3: ( (lv_assignment_1_0= '=' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:832:1: (lv_assignment_1_0= '=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:832:1: (lv_assignment_1_0= '=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:833:3: lv_assignment_1_0= '='
                    {
                    lv_assignment_1_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleFeatureCallStatement1480); 

                            createLeafNode(grammarAccess.getFeatureCallStatementAccess().getAssignmentEqualsSignKeyword_1_0_0(), "assignment"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "assignment", true, "=", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:852:2: ( (lv_expression_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:853:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:853:1: (lv_expression_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:854:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallStatementAccess().getExpressionExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCallStatement1514);
                    lv_expression_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_2_0, 
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

            match(input,20,FOLLOW_20_in_ruleFeatureCallStatement1526); 

                    createLeafNode(grammarAccess.getFeatureCallStatementAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleFeatureCallStatement


    // $ANTLR start entryRuleIfStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:888:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:889:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:890:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement1562);
            iv_ruleIfStatement=ruleIfStatement();
            _fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement1572); 

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
    // $ANTLR end entryRuleIfStatement


    // $ANTLR start ruleIfStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:897:1: ruleIfStatement returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseBody_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:902:6: ( ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:903:1: ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:903:1: ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:903:3: 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )?
            {
            match(input,21,FOLLOW_21_in_ruleIfStatement1607); 

                    createLeafNode(grammarAccess.getIfStatementAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:907:1: ( (lv_cases_1_0= ruleIfCase ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:908:1: (lv_cases_1_0= ruleIfCase )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:908:1: (lv_cases_1_0= ruleIfCase )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:909:3: lv_cases_1_0= ruleIfCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getCasesIfCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleIfCase_in_ruleIfStatement1628);
            lv_cases_1_0=ruleIfCase();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"cases",
            	        		lv_cases_1_0, 
            	        		"IfCase", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:931:2: ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:931:4: 'elseif' ( (lv_cases_3_0= ruleIfCase ) )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleIfStatement1639); 

            	            createLeafNode(grammarAccess.getIfStatementAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:935:1: ( (lv_cases_3_0= ruleIfCase ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:936:1: (lv_cases_3_0= ruleIfCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:936:1: (lv_cases_3_0= ruleIfCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:937:3: lv_cases_3_0= ruleIfCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getCasesIfCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleIfCase_in_ruleIfStatement1660);
            	    lv_cases_3_0=ruleIfCase();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getIfStatementRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"cases",
            	    	        		lv_cases_3_0, 
            	    	        		"IfCase", 
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:959:4: ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:959:6: 'else' ( (lv_elseBody_5_0= ruleBlock ) )
                    {
                    match(input,23,FOLLOW_23_in_ruleIfStatement1673); 

                            createLeafNode(grammarAccess.getIfStatementAccess().getElseKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:963:1: ( (lv_elseBody_5_0= ruleBlock ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:1: (lv_elseBody_5_0= ruleBlock )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:1: (lv_elseBody_5_0= ruleBlock )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:965:3: lv_elseBody_5_0= ruleBlock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getElseBodyBlockParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1694);
                    lv_elseBody_5_0=ruleBlock();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIfStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"elseBody",
                    	        		lv_elseBody_5_0, 
                    	        		"Block", 
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
    // $ANTLR end ruleIfStatement


    // $ANTLR start entryRuleIfCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:995:1: entryRuleIfCase returns [EObject current=null] : iv_ruleIfCase= ruleIfCase EOF ;
    public final EObject entryRuleIfCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:996:2: (iv_ruleIfCase= ruleIfCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:997:2: iv_ruleIfCase= ruleIfCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfCase_in_entryRuleIfCase1732);
            iv_ruleIfCase=ruleIfCase();
            _fsp--;

             current =iv_ruleIfCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfCase1742); 

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
    // $ANTLR end entryRuleIfCase


    // $ANTLR start ruleIfCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1004:1: ruleIfCase returns [EObject current=null] : ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) ) ;
    public final EObject ruleIfCase() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_body_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1009:6: ( ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1010:1: ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1010:1: ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1010:2: ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1010:2: ( (lv_condition_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1011:1: (lv_condition_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1011:1: (lv_condition_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1012:3: lv_condition_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfCaseAccess().getConditionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfCase1788);
            lv_condition_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1034:2: ( (lv_body_1_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1035:1: (lv_body_1_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1035:1: (lv_body_1_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1036:3: lv_body_1_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfCaseAccess().getBodyBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfCase1809);
            lv_body_1_0=ruleBlock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_1_0, 
            	        		"Block", 
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
    // $ANTLR end ruleIfCase


    // $ANTLR start entryRuleWhileStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1066:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1067:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1068:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhileStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1845);
            iv_ruleWhileStatement=ruleWhileStatement();
            _fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement1855); 

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
    // $ANTLR end entryRuleWhileStatement


    // $ANTLR start ruleWhileStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1075:1: ruleWhileStatement returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1080:6: ( ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1081:1: ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1081:1: ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1081:3: 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) )
            {
            match(input,24,FOLLOW_24_in_ruleWhileStatement1890); 

                    createLeafNode(grammarAccess.getWhileStatementAccess().getWhileKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1085:1: ( (lv_predicate_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1086:1: (lv_predicate_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1086:1: (lv_predicate_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1087:3: lv_predicate_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileStatement1911);
            lv_predicate_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWhileStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"predicate",
            	        		lv_predicate_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1109:2: ( (lv_body_2_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1110:1: (lv_body_2_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1110:1: (lv_body_2_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1111:3: lv_body_2_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement1932);
            lv_body_2_0=ruleBlock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getWhileStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_2_0, 
            	        		"Block", 
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
    // $ANTLR end ruleWhileStatement


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1141:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1142:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1143:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1968);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration1978); 

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
    // $ANTLR end entryRuleVariableDeclaration


    // $ANTLR start ruleVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1150:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) ) )* ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_items_1_0 = null;

        EObject lv_items_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1155:6: ( ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) ) )* ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1156:1: ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) ) )* ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1156:1: ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) ) )* ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1156:2: ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) ) )* ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1156:2: ( (lv_type_0_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1157:1: (lv_type_0_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1157:1: (lv_type_0_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1158:3: lv_type_0_0= ruleDataTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeSpecifierParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleVariableDeclaration2024);
            lv_type_0_0=ruleDataTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_0_0, 
            	        		"DataTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1180:2: ( (lv_items_1_0= ruleVariableDeclarationItem ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1181:1: (lv_items_1_0= ruleVariableDeclarationItem )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1181:1: (lv_items_1_0= ruleVariableDeclarationItem )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1182:3: lv_items_1_0= ruleVariableDeclarationItem
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getItemsVariableDeclarationItemParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration2045);
            lv_items_1_0=ruleVariableDeclarationItem();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"items",
            	        		lv_items_1_0, 
            	        		"VariableDeclarationItem", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1204:2: ( ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==16) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1204:4: ',' ( (lv_items_3_0= ruleVariableDeclarationItem ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleVariableDeclaration2056); 

            	            createLeafNode(grammarAccess.getVariableDeclarationAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1208:1: ( (lv_items_3_0= ruleVariableDeclarationItem ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1209:1: (lv_items_3_0= ruleVariableDeclarationItem )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1209:1: (lv_items_3_0= ruleVariableDeclarationItem )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1210:3: lv_items_3_0= ruleVariableDeclarationItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getItemsVariableDeclarationItemParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration2077);
            	    lv_items_3_0=ruleVariableDeclarationItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_3_0, 
            	    	        		"VariableDeclarationItem", 
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
            	    break loop14;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_ruleVariableDeclaration2089); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start entryRuleVariableDeclarationItem
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1244:1: entryRuleVariableDeclarationItem returns [EObject current=null] : iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF ;
    public final EObject entryRuleVariableDeclarationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationItem = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1245:2: (iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1246:2: iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationItemRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclarationItem_in_entryRuleVariableDeclarationItem2125);
            iv_ruleVariableDeclarationItem=ruleVariableDeclarationItem();
            _fsp--;

             current =iv_ruleVariableDeclarationItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationItem2135); 

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
    // $ANTLR end entryRuleVariableDeclarationItem


    // $ANTLR start ruleVariableDeclarationItem
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1253:1: ruleVariableDeclarationItem returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_initialValue_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1258:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1259:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1259:1: ( ( (lv_name_0_0= RULE_ID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1259:2: ( (lv_name_0_0= RULE_ID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1259:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1260:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1260:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1261:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclarationItem2177); 

            			createLeafNode(grammarAccess.getVariableDeclarationItemAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationItemRule().getType().getClassifier());
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1283:2: ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1283:4: '=' ( (lv_initialValue_2_0= ruleExpression ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleVariableDeclarationItem2193); 

                            createLeafNode(grammarAccess.getVariableDeclarationItemAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1287:1: ( (lv_initialValue_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1288:1: (lv_initialValue_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1288:1: (lv_initialValue_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1289:3: lv_initialValue_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationItemAccess().getInitialValueExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclarationItem2214);
                    lv_initialValue_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationItemRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"initialValue",
                    	        		lv_initialValue_2_0, 
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
    // $ANTLR end ruleVariableDeclarationItem


    // $ANTLR start entryRuleDataTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1319:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1320:2: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1321:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2252);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();
            _fsp--;

             current =iv_ruleDataTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeSpecifier2262); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1328:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeSpecifier_0 = null;

        EObject this_NamedTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1333:6: ( (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1334:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1334:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=25 && LA16_0<=30)) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ID) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1334:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1335:5: this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPrimitiveTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2309);
                    this_PrimitiveTypeSpecifier_0=rulePrimitiveTypeSpecifier();
                    _fsp--;

                     
                            current = this_PrimitiveTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1345:5: this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getNamedTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2336);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1361:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1362:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1363:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2371);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();
            _fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2381); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1370:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1375:6: ( (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1376:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1376:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 25:
            case 26:
            case 27:
            case 28:
                {
                alt17=1;
                }
                break;
            case 29:
                {
                alt17=2;
                }
                break;
            case 30:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1376:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1377:5: this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericalTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier2428);
                    this_NumericalTypeSpecifier_0=ruleNumericalTypeSpecifier();
                    _fsp--;

                     
                            current = this_NumericalTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1387:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2455);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();
                    _fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1397:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2482);
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


    // $ANTLR start entryRuleNumericalTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1413:1: entryRuleNumericalTypeSpecifier returns [EObject current=null] : iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF ;
    public final EObject entryRuleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1414:2: (iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1415:2: iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier2517);
            iv_ruleNumericalTypeSpecifier=ruleNumericalTypeSpecifier();
            _fsp--;

             current =iv_ruleNumericalTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier2527); 

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
    // $ANTLR end entryRuleNumericalTypeSpecifier


    // $ANTLR start ruleNumericalTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1422:1: ruleNumericalTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) ;
    public final EObject ruleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;

        EObject this_ComplexTypeSpecifier_2 = null;

        EObject this_GaussianTypeSpecifier_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1427:6: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1428:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1428:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt18=1;
                }
                break;
            case 26:
                {
                alt18=2;
                }
                break;
            case 27:
                {
                alt18=3;
                }
                break;
            case 28:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1428:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1429:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier2574);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();
                    _fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1439:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier2601);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();
                    _fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1449:5: this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getComplexTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericalTypeSpecifier2628);
                    this_ComplexTypeSpecifier_2=ruleComplexTypeSpecifier();
                    _fsp--;

                     
                            current = this_ComplexTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1459:5: this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getGaussianTypeSpecifierParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericalTypeSpecifier2655);
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
    // $ANTLR end ruleNumericalTypeSpecifier


    // $ANTLR start entryRuleRealTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1475:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1476:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1477:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier2690);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();
            _fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier2700); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1484:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1489:6: ( ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:2: () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:5: 
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

            match(input,25,FOLLOW_25_in_ruleRealTypeSpecifier2744); 

                    createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1505:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1505:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleRealTypeSpecifier2755); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1509:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1510:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1510:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1511:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier2776);
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

                    match(input,18,FOLLOW_18_in_ruleRealTypeSpecifier2786); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1545:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1546:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1547:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier2824);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();
            _fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier2834); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1554:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () 'integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1559:6: ( ( () 'integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1560:1: ( () 'integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1560:1: ( () 'integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1560:2: () 'integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1560:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1561:5: 
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

            match(input,26,FOLLOW_26_in_ruleIntegerTypeSpecifier2878); 

                    createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntegerKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1575:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==17) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1575:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleIntegerTypeSpecifier2889); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1579:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1580:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1580:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1581:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier2910);
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

                    match(input,18,FOLLOW_18_in_ruleIntegerTypeSpecifier2920); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1615:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1616:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1617:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier2958);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();
            _fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier2968); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1624:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1629:6: ( ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1630:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1630:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1630:2: () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1630:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1631:5: 
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

            match(input,27,FOLLOW_27_in_ruleComplexTypeSpecifier3012); 

                    createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1645:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1645:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleComplexTypeSpecifier3023); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1649:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1650:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1650:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1651:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3044);
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

                    match(input,18,FOLLOW_18_in_ruleComplexTypeSpecifier3054); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1685:1: entryRuleGaussianTypeSpecifier returns [EObject current=null] : iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF ;
    public final EObject entryRuleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGaussianTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1686:2: (iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1687:2: iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3092);
            iv_ruleGaussianTypeSpecifier=ruleGaussianTypeSpecifier();
            _fsp--;

             current =iv_ruleGaussianTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3102); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1694:1: ruleGaussianTypeSpecifier returns [EObject current=null] : ( () 'gaussian' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1699:6: ( ( () 'gaussian' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:1: ( () 'gaussian' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:1: ( () 'gaussian' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:2: () 'gaussian' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1701:5: 
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

            match(input,28,FOLLOW_28_in_ruleGaussianTypeSpecifier3146); 

                    createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussianKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1715:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1715:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleGaussianTypeSpecifier3157); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1719:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1720:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1720:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1721:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3178);
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

                    match(input,18,FOLLOW_18_in_ruleGaussianTypeSpecifier3188); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1755:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1756:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1757:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3226);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();
            _fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3236); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1764:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () 'boolean' ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1769:6: ( ( () 'boolean' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1770:1: ( () 'boolean' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1770:1: ( () 'boolean' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1770:2: () 'boolean'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1770:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1771:5: 
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

            match(input,29,FOLLOW_29_in_ruleBooleanTypeSpecifier3280); 

                    createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getBooleanKeyword_1(), null); 
                

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1793:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1794:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1795:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier3316);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();
            _fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier3326); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1802:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () 'string' ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1807:6: ( ( () 'string' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1808:1: ( () 'string' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1808:1: ( () 'string' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1808:2: () 'string'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1808:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1809:5: 
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

            match(input,30,FOLLOW_30_in_ruleStringTypeSpecifier3370); 

                    createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getStringKeyword_1(), null); 
                

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1831:1: entryRuleNamedTypeSpecifier returns [EObject current=null] : iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF ;
    public final EObject entryRuleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1832:2: (iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1833:2: iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier3406);
            iv_ruleNamedTypeSpecifier=ruleNamedTypeSpecifier();
            _fsp--;

             current =iv_ruleNamedTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTypeSpecifier3416); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1840:1: ruleNamedTypeSpecifier returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1845:6: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1846:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1846:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1847:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1847:1: (lv_name_0_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1848:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getNameQualifiedNameParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier3461);
            lv_name_0_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"QualifiedName", 
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
    // $ANTLR end ruleNamedTypeSpecifier


    // $ANTLR start entryRuleExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1878:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1879:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1880:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression3496);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression3506); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1887:1: ruleExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        EObject this_RangeExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1892:6: ( (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1893:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1893:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==21) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||LA23_0==17||(LA23_0>=35 && LA23_0<=36)||(LA23_0>=38 && LA23_0<=39)||(LA23_0>=42 && LA23_0<=43)||(LA23_0>=57 && LA23_0<=58)) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1893:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1894:5: this_ConditionalExpression_0= ruleConditionalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression3553);
                    this_ConditionalExpression_0=ruleConditionalExpression();
                    _fsp--;

                     
                            current = this_ConditionalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1904:5: this_RangeExpression_1= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression3580);
                    this_RangeExpression_1=ruleRangeExpression();
                    _fsp--;

                     
                            current = this_RangeExpression_1; 
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


    // $ANTLR start entryRuleConditionalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1920:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1921:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression3615);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression3625); 

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
    // $ANTLR end entryRuleConditionalExpression


    // $ANTLR start ruleConditionalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1929:1: ruleConditionalExpression returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1934:6: ( ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1935:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1935:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1935:3: 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,21,FOLLOW_21_in_ruleConditionalExpression3660); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1939:1: ( (lv_cases_1_0= ruleConditionalExpressionCase ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1940:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1940:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1941:3: lv_cases_1_0= ruleConditionalExpressionCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression3681);
            lv_cases_1_0=ruleConditionalExpressionCase();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"cases",
            	        		lv_cases_1_0, 
            	        		"ConditionalExpressionCase", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1963:2: ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==22) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1963:4: 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleConditionalExpression3692); 

            	            createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1967:1: ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1968:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1968:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1969:3: lv_cases_3_0= ruleConditionalExpressionCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression3713);
            	    lv_cases_3_0=ruleConditionalExpressionCase();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"cases",
            	    	        		lv_cases_3_0, 
            	    	        		"ConditionalExpressionCase", 
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

            match(input,23,FOLLOW_23_in_ruleConditionalExpression3725); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1995:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1996:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1996:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1997:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getElseExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpression3746);
            lv_elseExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
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
    // $ANTLR end ruleConditionalExpression


    // $ANTLR start entryRuleConditionalExpressionCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2027:1: entryRuleConditionalExpressionCase returns [EObject current=null] : iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF ;
    public final EObject entryRuleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressionCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2028:2: (iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2029:2: iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase3782);
            iv_ruleConditionalExpressionCase=ruleConditionalExpressionCase();
            _fsp--;

             current =iv_ruleConditionalExpressionCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpressionCase3792); 

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
    // $ANTLR end entryRuleConditionalExpressionCase


    // $ANTLR start ruleConditionalExpressionCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2036:1: ruleConditionalExpressionCase returns [EObject current=null] : ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject lv_conditionExpression_0_0 = null;

        EObject lv_thenExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2041:6: ( ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2042:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2042:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2042:2: ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2042:2: ( (lv_conditionExpression_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2043:1: (lv_conditionExpression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2043:1: (lv_conditionExpression_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2044:3: lv_conditionExpression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getConditionExpressionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase3838);
            lv_conditionExpression_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"conditionExpression",
            	        		lv_conditionExpression_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,31,FOLLOW_31_in_ruleConditionalExpressionCase3848); 

                    createLeafNode(grammarAccess.getConditionalExpressionCaseAccess().getThenKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2070:1: ( (lv_thenExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2071:1: (lv_thenExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2071:1: (lv_thenExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2072:3: lv_thenExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getThenExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase3869);
            lv_thenExpression_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"thenExpression",
            	        		lv_thenExpression_2_0, 
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
    // $ANTLR end ruleConditionalExpressionCase


    // $ANTLR start entryRuleRangeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2102:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2103:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2104:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression3905);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression3915); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2111:1: ruleRangeExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_expressions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2116:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2117:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2117:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2118:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression3962);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2126:1: ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2126:2: () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2126:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2127:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRangeExpressionAccess().getRangeExpressionExpressionsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "expressions", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRangeExpressionAccess().getRangeExpressionExpressionsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,32,FOLLOW_32_in_ruleRangeExpression3981); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2146:1: ( (lv_expressions_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2147:1: (lv_expressions_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2147:1: (lv_expressions_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2148:3: lv_expressions_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getExpressionsLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression4002);
                    lv_expressions_3_0=ruleLogicalOrExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"expressions",
                    	        		lv_expressions_3_0, 
                    	        		"LogicalOrExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2170:2: ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==32) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2170:4: ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) )
                            {
                            match(input,32,FOLLOW_32_in_ruleRangeExpression4013); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_0(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2174:1: ( (lv_expressions_5_0= ruleLogicalOrExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2175:1: (lv_expressions_5_0= ruleLogicalOrExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2175:1: (lv_expressions_5_0= ruleLogicalOrExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2176:3: lv_expressions_5_0= ruleLogicalOrExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getExpressionsLogicalOrExpressionParserRuleCall_1_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression4034);
                            lv_expressions_5_0=ruleLogicalOrExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"expressions",
                            	        		lv_expressions_5_0, 
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


    // $ANTLR start entryRuleLogicalOrExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2206:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2207:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2208:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression4074);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression4084); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2215:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2220:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2221:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2221:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2222:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4131);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2230:1: ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2230:2: () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2230:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2231:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2246:2: ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==33) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2246:4: 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,33,FOLLOW_33_in_ruleLogicalOrExpression4151); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2250:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2251:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2251:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2252:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4172);
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
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2282:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2283:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2284:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression4212);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression4222); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2291:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2296:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2297:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2297:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2298:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4269);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2306:1: ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==34) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2306:2: () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2306:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2307:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2322:2: ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2322:4: 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    {
                    	    match(input,34,FOLLOW_34_in_ruleLogicalAndExpression4289); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2326:1: ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2327:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2327:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2328:3: lv_operands_3_0= ruleLogicalNotExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsLogicalNotExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4310);
                    	    lv_operands_3_0=ruleLogicalNotExpression();
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
                    	    	        		"LogicalNotExpression", 
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
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
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


    // $ANTLR start entryRuleLogicalNotExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2358:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2359:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2360:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression4350);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression4360); 

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
    // $ANTLR end entryRuleLogicalNotExpression


    // $ANTLR start ruleLogicalNotExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2367:1: ruleLogicalNotExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2372:6: ( (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2373:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2373:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_STRING)||LA31_0==17||LA31_0==36||(LA31_0>=38 && LA31_0<=39)||(LA31_0>=42 && LA31_0<=43)||(LA31_0>=57 && LA31_0<=58)) ) {
                alt31=1;
            }
            else if ( (LA31_0==35) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2373:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2374:5: this_RelationalExpression_0= ruleRelationalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression4407);
                    this_RelationalExpression_0=ruleRelationalExpression();
                    _fsp--;

                     
                            current = this_RelationalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2383:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2383:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2383:7: () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2383:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2384:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,35,FOLLOW_35_in_ruleLogicalNotExpression4432); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getNotKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2398:1: ( (lv_operand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2399:1: (lv_operand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2399:1: (lv_operand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2400:3: lv_operand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression4453);
                    lv_operand_3_0=ruleRelationalExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLogicalNotExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operand",
                    	        		lv_operand_3_0, 
                    	        		"RelationalExpression", 
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
    // $ANTLR end ruleLogicalNotExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2430:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2431:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2432:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression4490);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression4500); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2439:1: ruleRelationalExpression returns [EObject current=null] : (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddSubtractExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2444:6: ( (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2445:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2445:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2446:5: this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression4547);
            this_AddSubtractExpression_0=ruleAddSubtractExpression();
            _fsp--;

             
                    current = this_AddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2454:1: ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=47 && LA33_0<=52)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2454:2: () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2454:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2455:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:2: ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0>=47 && LA32_0<=52)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:3: ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:3: ( (lv_operators_2_0= ruleRelationalOperator ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2471:1: (lv_operators_2_0= ruleRelationalOperator )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2471:1: (lv_operators_2_0= ruleRelationalOperator )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2472:3: lv_operators_2_0= ruleRelationalOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorsRelationalOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression4578);
                    	    lv_operators_2_0=ruleRelationalOperator();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operators",
                    	    	        		lv_operators_2_0, 
                    	    	        		"RelationalOperator", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }

                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2494:2: ( (lv_operands_3_0= ruleAddSubtractExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2495:1: (lv_operands_3_0= ruleAddSubtractExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2495:1: (lv_operands_3_0= ruleAddSubtractExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2496:3: lv_operands_3_0= ruleAddSubtractExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperandsAddSubtractExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression4599);
                    	    lv_operands_3_0=ruleAddSubtractExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"AddSubtractExpression", 
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
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAddSubtractExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2526:1: entryRuleAddSubtractExpression returns [EObject current=null] : iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF ;
    public final EObject entryRuleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddSubtractExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2527:2: (iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2528:2: iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression4639);
            iv_ruleAddSubtractExpression=ruleAddSubtractExpression();
            _fsp--;

             current =iv_ruleAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddSubtractExpression4649); 

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
    // $ANTLR end entryRuleAddSubtractExpression


    // $ANTLR start ruleAddSubtractExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2535:1: ruleAddSubtractExpression returns [EObject current=null] : (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) ;
    public final EObject ruleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplyDivideExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2540:6: ( (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2541:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2541:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2542:5: this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression4696);
            this_MultiplyDivideExpression_0=ruleMultiplyDivideExpression();
            _fsp--;

             
                    current = this_MultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2550:1: ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==36||LA35_0==53) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2550:2: () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2550:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2551:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAddSubtractExpressionAccess().getAddSubtractExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getAddSubtractExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2566:2: ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==36||LA34_0==53) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2566:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2566:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2567:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2567:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2568:3: lv_operators_2_0= ruleAddSubtractOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperatorsAddSubtractOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression4727);
                    	    lv_operators_2_0=ruleAddSubtractOperator();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAddSubtractExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operators",
                    	    	        		lv_operators_2_0, 
                    	    	        		"AddSubtractOperator", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }

                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2590:2: ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2591:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2591:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2592:3: lv_operands_3_0= ruleMultiplyDivideExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperandsMultiplyDivideExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression4748);
                    	    lv_operands_3_0=ruleMultiplyDivideExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAddSubtractExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"MultiplyDivideExpression", 
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
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
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
    // $ANTLR end ruleAddSubtractExpression


    // $ANTLR start entryRuleMultiplyDivideExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2622:1: entryRuleMultiplyDivideExpression returns [EObject current=null] : iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF ;
    public final EObject entryRuleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2623:2: (iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2624:2: iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression4788);
            iv_ruleMultiplyDivideExpression=ruleMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyDivideExpression4798); 

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
    // $ANTLR end entryRuleMultiplyDivideExpression


    // $ANTLR start ruleMultiplyDivideExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2631:1: ruleMultiplyDivideExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) ;
    public final EObject ruleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2636:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2637:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2637:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2638:5: this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression4845);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2646:1: ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=44 && LA37_0<=45)||(LA37_0>=54 && LA37_0<=55)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2646:2: () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2646:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2647:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getMultiplyDivideExpressionAccess().getMultiplyDivideExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getMultiplyDivideExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2662:2: ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( ((LA36_0>=44 && LA36_0<=45)||(LA36_0>=54 && LA36_0<=55)) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2662:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2662:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2663:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2663:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2664:3: lv_operators_2_0= ruleMultiplyDivideOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperatorsMultiplyDivideOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression4876);
                    	    lv_operators_2_0=ruleMultiplyDivideOperator();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMultiplyDivideExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operators",
                    	    	        		lv_operators_2_0, 
                    	    	        		"MultiplyDivideOperator", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }

                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2686:2: ( (lv_operands_3_0= rulePowerExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2687:1: (lv_operands_3_0= rulePowerExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2687:1: (lv_operands_3_0= rulePowerExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2688:3: lv_operands_3_0= rulePowerExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperandsPowerExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression4897);
                    	    lv_operands_3_0=rulePowerExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMultiplyDivideExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"PowerExpression", 
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
                    	    if ( cnt36 >= 1 ) break loop36;
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
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
    // $ANTLR end ruleMultiplyDivideExpression


    // $ANTLR start entryRulePowerExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2718:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2719:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2720:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression4937);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression4947); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2727:1: rulePowerExpression returns [EObject current=null] : (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryMinusExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2732:6: ( (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2733:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2733:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2734:5: this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryMinusExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression4994);
            this_UnaryMinusExpression_0=ruleUnaryMinusExpression();
            _fsp--;

             
                    current = this_UnaryMinusExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2742:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==46||LA38_0==56) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2742:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2742:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2743:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2758:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2759:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2759:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2760:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression5024);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2782:2: ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2783:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2783:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2784:3: lv_exponent_3_0= ruleUnaryMinusExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryMinusExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression5045);
                    lv_exponent_3_0=ruleUnaryMinusExpression();
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
                    	        		"UnaryMinusExpression", 
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


    // $ANTLR start entryRuleUnaryMinusExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2814:1: entryRuleUnaryMinusExpression returns [EObject current=null] : iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF ;
    public final EObject entryRuleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryMinusExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2815:2: (iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2816:2: iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryMinusExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression5083);
            iv_ruleUnaryMinusExpression=ruleUnaryMinusExpression();
            _fsp--;

             current =iv_ruleUnaryMinusExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryMinusExpression5093); 

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
    // $ANTLR end entryRuleUnaryMinusExpression


    // $ANTLR start ruleUnaryMinusExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2823:1: ruleUnaryMinusExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2828:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2829:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2829:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)||LA39_0==17||(LA39_0>=38 && LA39_0<=39)||(LA39_0>=42 && LA39_0<=43)||(LA39_0>=57 && LA39_0<=58)) ) {
                alt39=1;
            }
            else if ( (LA39_0==36) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2829:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2830:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression5140);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2839:6: ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2839:6: ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2839:7: () '-' ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2839:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2840:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getUnaryMinusExpressionAccess().getUnaryMinusExpressionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getUnaryMinusExpressionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,36,FOLLOW_36_in_ruleUnaryMinusExpression5165); 

                            createLeafNode(grammarAccess.getUnaryMinusExpressionAccess().getHyphenMinusKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2854:1: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2855:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2855:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2856:3: lv_operand_3_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression5186);
                    lv_operand_3_0=rulePrimaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryMinusExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operand",
                    	        		lv_operand_3_0, 
                    	        		"PrimaryExpression", 
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
    // $ANTLR end ruleUnaryMinusExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2886:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2887:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2888:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression5223);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression5233); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2895:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_MatrixConstructionOperator_3= ruleMatrixConstructionOperator | this_BeginExpression_4= ruleBeginExpression | this_EndExpression_5= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_ParenthesizedExpression_2 = null;

        EObject this_MatrixConstructionOperator_3 = null;

        EObject this_BeginExpression_4 = null;

        EObject this_EndExpression_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2900:6: ( (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_MatrixConstructionOperator_3= ruleMatrixConstructionOperator | this_BeginExpression_4= ruleBeginExpression | this_EndExpression_5= ruleEndExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2901:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_MatrixConstructionOperator_3= ruleMatrixConstructionOperator | this_BeginExpression_4= ruleBeginExpression | this_EndExpression_5= ruleEndExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2901:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_MatrixConstructionOperator_3= ruleMatrixConstructionOperator | this_BeginExpression_4= ruleBeginExpression | this_EndExpression_5= ruleEndExpression )
            int alt40=6;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 57:
            case 58:
                {
                alt40=1;
                }
                break;
            case RULE_ID:
            case 38:
                {
                alt40=2;
                }
                break;
            case 17:
                {
                alt40=3;
                }
                break;
            case 39:
                {
                alt40=4;
                }
                break;
            case 42:
                {
                alt40=5;
                }
                break;
            case 43:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2901:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_MatrixConstructionOperator_3= ruleMatrixConstructionOperator | this_BeginExpression_4= ruleBeginExpression | this_EndExpression_5= ruleEndExpression )", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2902:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression5280);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2912:5: this_FeatureCall_1= ruleFeatureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePrimaryExpression5307);
                    this_FeatureCall_1=ruleFeatureCall();
                    _fsp--;

                     
                            current = this_FeatureCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2922:5: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression5334);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();
                    _fsp--;

                     
                            current = this_ParenthesizedExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2932:5: this_MatrixConstructionOperator_3= ruleMatrixConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMatrixConstructionOperatorParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_rulePrimaryExpression5361);
                    this_MatrixConstructionOperator_3=ruleMatrixConstructionOperator();
                    _fsp--;

                     
                            current = this_MatrixConstructionOperator_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2942:5: this_BeginExpression_4= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression5388);
                    this_BeginExpression_4=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2952:5: this_EndExpression_5= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression5415);
                    this_EndExpression_5=ruleEndExpression();
                    _fsp--;

                     
                            current = this_EndExpression_5; 
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


    // $ANTLR start entryRuleLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2968:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2969:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2970:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral5450);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral5460); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2977:1: ruleLiteral returns [EObject current=null] : (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2982:6: ( (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2983:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2983:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt41=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt41=1;
                }
                break;
            case 57:
            case 58:
                {
                alt41=2;
                }
                break;
            case RULE_STRING:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2983:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2984:5: this_NumericalLiteral_0= ruleNumericalLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericalLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalLiteral_in_ruleLiteral5507);
                    this_NumericalLiteral_0=ruleNumericalLiteral();
                    _fsp--;

                     
                            current = this_NumericalLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2994:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral5534);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3004:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral5561);
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


    // $ANTLR start entryRuleNumericalLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3020:1: entryRuleNumericalLiteral returns [EObject current=null] : iv_ruleNumericalLiteral= ruleNumericalLiteral EOF ;
    public final EObject entryRuleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3021:2: (iv_ruleNumericalLiteral= ruleNumericalLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3022:2: iv_ruleNumericalLiteral= ruleNumericalLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral5596);
            iv_ruleNumericalLiteral=ruleNumericalLiteral();
            _fsp--;

             current =iv_ruleNumericalLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalLiteral5606); 

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
    // $ANTLR end entryRuleNumericalLiteral


    // $ANTLR start ruleNumericalLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3029:1: ruleNumericalLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3034:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3035:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3035:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_REAL) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_INTEGER) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3035:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3036:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral5653);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3046:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral5680);
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
    // $ANTLR end ruleNumericalLiteral


    // $ANTLR start entryRuleRealLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3062:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3063:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3064:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral5715);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral5725); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3071:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_complex_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3076:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3077:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3077:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3077:2: ( (lv_value_0_0= RULE_REAL ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3077:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3078:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3078:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3079:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral5767); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3101:2: ( (lv_complex_1_0= 'j' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==37) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3102:1: (lv_complex_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3102:1: (lv_complex_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3103:3: lv_complex_1_0= 'j'
                    {
                    lv_complex_1_0=(Token)input.LT(1);
                    match(input,37,FOLLOW_37_in_ruleRealLiteral5790); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getComplexJKeyword_1_0(), "complex"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "complex", true, "j", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3122:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==17) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3122:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleRealLiteral5815); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3126:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3127:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3127:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3128:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral5836);
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

                    match(input,18,FOLLOW_18_in_ruleRealLiteral5846); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3162:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3163:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3164:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral5884);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral5894); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3171:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_complex_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3176:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3177:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3177:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3177:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_complex_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3177:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3178:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3178:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3179:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral5936); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3201:2: ( (lv_complex_1_0= 'j' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==37) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3202:1: (lv_complex_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3202:1: (lv_complex_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3203:3: lv_complex_1_0= 'j'
                    {
                    lv_complex_1_0=(Token)input.LT(1);
                    match(input,37,FOLLOW_37_in_ruleIntegerLiteral5959); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getComplexJKeyword_1_0(), "complex"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "complex", true, "j", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3222:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==17) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3222:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleIntegerLiteral5984); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3226:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3227:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3227:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3228:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral6005);
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

                    match(input,18,FOLLOW_18_in_ruleIntegerLiteral6015); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3262:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3263:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3264:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral6053);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral6063); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3271:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3276:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3277:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3277:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3278:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3278:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3279:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral6108);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3309:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3310:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3311:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral6143);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral6153); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3318:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3323:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3324:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3324:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3325:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3325:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3326:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral6194); 

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


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3356:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3357:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3358:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6234);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6244); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3365:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '::' ( (lv_identifiers_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_identifiers_0_0=null;
        Token lv_identifiers_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3370:6: ( ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '::' ( (lv_identifiers_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3371:1: ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '::' ( (lv_identifiers_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3371:1: ( ( (lv_identifiers_0_0= RULE_ID ) ) ( '::' ( (lv_identifiers_2_0= RULE_ID ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3371:2: ( (lv_identifiers_0_0= RULE_ID ) ) ( '::' ( (lv_identifiers_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3371:2: ( (lv_identifiers_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3372:1: (lv_identifiers_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3372:1: (lv_identifiers_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3373:3: lv_identifiers_0_0= RULE_ID
            {
            lv_identifiers_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6286); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3395:2: ( '::' ( (lv_identifiers_2_0= RULE_ID ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==38) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3395:4: '::' ( (lv_identifiers_2_0= RULE_ID ) )
            	    {
            	    match(input,38,FOLLOW_38_in_ruleQualifiedName6302); 

            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3399:1: ( (lv_identifiers_2_0= RULE_ID ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3400:1: (lv_identifiers_2_0= RULE_ID )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3400:1: (lv_identifiers_2_0= RULE_ID )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3401:3: lv_identifiers_2_0= RULE_ID
            	    {
            	    lv_identifiers_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6319); 

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
            	    break loop47;
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


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3431:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3432:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3433:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall6362);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall6372); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3440:1: ruleFeatureCall returns [EObject current=null] : ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_componentReferences_2_0= ruleComponentReference ) )* ( ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')' )? ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        Token lv_operationCall_3_0=null;
        EObject lv_name_1_0 = null;

        EObject lv_componentReferences_2_0 = null;

        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3445:6: ( ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_componentReferences_2_0= ruleComponentReference ) )* ( ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_componentReferences_2_0= ruleComponentReference ) )* ( ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_componentReferences_2_0= ruleComponentReference ) )* ( ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:2: ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_componentReferences_2_0= ruleComponentReference ) )* ( ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:2: ( (lv_global_0_0= '::' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==38) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3447:1: (lv_global_0_0= '::' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3447:1: (lv_global_0_0= '::' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3448:3: lv_global_0_0= '::'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,38,FOLLOW_38_in_ruleFeatureCall6415); 

                            createLeafNode(grammarAccess.getFeatureCallAccess().getGlobalColonColonKeyword_0_0(), "global"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "global", true, "::", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3467:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3468:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3468:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3469:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFeatureCall6450);
            lv_name_1_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3491:2: ( (lv_componentReferences_2_0= ruleComponentReference ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==39||LA49_0==41) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3492:1: (lv_componentReferences_2_0= ruleComponentReference )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3492:1: (lv_componentReferences_2_0= ruleComponentReference )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3493:3: lv_componentReferences_2_0= ruleComponentReference
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getComponentReferencesComponentReferenceParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentReference_in_ruleFeatureCall6471);
            	    lv_componentReferences_2_0=ruleComponentReference();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"componentReferences",
            	    	        		lv_componentReferences_2_0, 
            	    	        		"ComponentReference", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3515:3: ( ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==17) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3515:4: ( (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )? ')'
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3515:4: ( (lv_operationCall_3_0= '(' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3516:1: (lv_operationCall_3_0= '(' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3516:1: (lv_operationCall_3_0= '(' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3517:3: lv_operationCall_3_0= '('
                    {
                    lv_operationCall_3_0=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleFeatureCall6491); 

                            createLeafNode(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_3_0_0(), "operationCall"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "operationCall", true, "(", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3536:2: ( ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING)||LA51_0==17||LA51_0==21||(LA51_0>=35 && LA51_0<=36)||(LA51_0>=38 && LA51_0<=39)||(LA51_0>=42 && LA51_0<=43)||(LA51_0>=57 && LA51_0<=58)) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3536:3: ( (lv_arguments_4_0= ruleExpression ) ) ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )*
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3536:3: ( (lv_arguments_4_0= ruleExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3537:1: (lv_arguments_4_0= ruleExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3537:1: (lv_arguments_4_0= ruleExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3538:3: lv_arguments_4_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsExpressionParserRuleCall_3_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall6526);
                            lv_arguments_4_0=ruleExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
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

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3560:2: ( ',' ( (lv_arguments_6_0= ruleExpression ) ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==16) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3560:4: ',' ( (lv_arguments_6_0= ruleExpression ) )
                            	    {
                            	    match(input,16,FOLLOW_16_in_ruleFeatureCall6537); 

                            	            createLeafNode(grammarAccess.getFeatureCallAccess().getCommaKeyword_3_1_1_0(), null); 
                            	        
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3564:1: ( (lv_arguments_6_0= ruleExpression ) )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3565:1: (lv_arguments_6_0= ruleExpression )
                            	    {
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3565:1: (lv_arguments_6_0= ruleExpression )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3566:3: lv_arguments_6_0= ruleExpression
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsExpressionParserRuleCall_3_1_1_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall6558);
                            	    lv_arguments_6_0=ruleExpression();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"arguments",
                            	    	        		lv_arguments_6_0, 
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
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,18,FOLLOW_18_in_ruleFeatureCall6572); 

                            createLeafNode(grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_3_2(), null); 
                        

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
    // $ANTLR end ruleFeatureCall


    // $ANTLR start entryRuleComponentReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3600:1: entryRuleComponentReference returns [EObject current=null] : iv_ruleComponentReference= ruleComponentReference EOF ;
    public final EObject entryRuleComponentReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3601:2: (iv_ruleComponentReference= ruleComponentReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3602:2: iv_ruleComponentReference= ruleComponentReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComponentReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleComponentReference_in_entryRuleComponentReference6610);
            iv_ruleComponentReference=ruleComponentReference();
            _fsp--;

             current =iv_ruleComponentReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentReference6620); 

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
    // $ANTLR end entryRuleComponentReference


    // $ANTLR start ruleComponentReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3609:1: ruleComponentReference returns [EObject current=null] : (this_ArrayReference_0= ruleArrayReference | this_MemberReference_1= ruleMemberReference ) ;
    public final EObject ruleComponentReference() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayReference_0 = null;

        EObject this_MemberReference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3614:6: ( (this_ArrayReference_0= ruleArrayReference | this_MemberReference_1= ruleMemberReference ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3615:1: (this_ArrayReference_0= ruleArrayReference | this_MemberReference_1= ruleMemberReference )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3615:1: (this_ArrayReference_0= ruleArrayReference | this_MemberReference_1= ruleMemberReference )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==39) ) {
                alt53=1;
            }
            else if ( (LA53_0==41) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3615:1: (this_ArrayReference_0= ruleArrayReference | this_MemberReference_1= ruleMemberReference )", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3616:5: this_ArrayReference_0= ruleArrayReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getComponentReferenceAccess().getArrayReferenceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayReference_in_ruleComponentReference6667);
                    this_ArrayReference_0=ruleArrayReference();
                    _fsp--;

                     
                            current = this_ArrayReference_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3626:5: this_MemberReference_1= ruleMemberReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getComponentReferenceAccess().getMemberReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMemberReference_in_ruleComponentReference6694);
                    this_MemberReference_1=ruleMemberReference();
                    _fsp--;

                     
                            current = this_MemberReference_1; 
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
    // $ANTLR end ruleComponentReference


    // $ANTLR start entryRuleArrayReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3642:1: entryRuleArrayReference returns [EObject current=null] : iv_ruleArrayReference= ruleArrayReference EOF ;
    public final EObject entryRuleArrayReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3643:2: (iv_ruleArrayReference= ruleArrayReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3644:2: iv_ruleArrayReference= ruleArrayReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayReference_in_entryRuleArrayReference6729);
            iv_ruleArrayReference=ruleArrayReference();
            _fsp--;

             current =iv_ruleArrayReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayReference6739); 

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
    // $ANTLR end entryRuleArrayReference


    // $ANTLR start ruleArrayReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3651:1: ruleArrayReference returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) ;
    public final EObject ruleArrayReference() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3656:6: ( ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3657:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3657:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3657:3: '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']'
            {
            match(input,39,FOLLOW_39_in_ruleArrayReference6774); 

                    createLeafNode(grammarAccess.getArrayReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3661:1: ( (lv_subscripts_1_0= ruleSubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3662:1: (lv_subscripts_1_0= ruleSubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3662:1: (lv_subscripts_1_0= ruleSubscript )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3663:3: lv_subscripts_1_0= ruleSubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayReferenceAccess().getSubscriptsSubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSubscript_in_ruleArrayReference6795);
            lv_subscripts_1_0=ruleSubscript();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"subscripts",
            	        		lv_subscripts_1_0, 
            	        		"Subscript", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3685:2: ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3685:4: ',' ( (lv_subscripts_3_0= ruleSubscript ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleArrayReference6806); 

            	            createLeafNode(grammarAccess.getArrayReferenceAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3689:1: ( (lv_subscripts_3_0= ruleSubscript ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3690:1: (lv_subscripts_3_0= ruleSubscript )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3690:1: (lv_subscripts_3_0= ruleSubscript )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3691:3: lv_subscripts_3_0= ruleSubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayReferenceAccess().getSubscriptsSubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubscript_in_ruleArrayReference6827);
            	    lv_subscripts_3_0=ruleSubscript();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArrayReferenceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subscripts",
            	    	        		lv_subscripts_3_0, 
            	    	        		"Subscript", 
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
            	    break loop54;
                }
            } while (true);

            match(input,40,FOLLOW_40_in_ruleArrayReference6839); 

                    createLeafNode(grammarAccess.getArrayReferenceAccess().getRightSquareBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleArrayReference


    // $ANTLR start entryRuleMemberReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3725:1: entryRuleMemberReference returns [EObject current=null] : iv_ruleMemberReference= ruleMemberReference EOF ;
    public final EObject entryRuleMemberReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemberReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3726:2: (iv_ruleMemberReference= ruleMemberReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3727:2: iv_ruleMemberReference= ruleMemberReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMemberReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleMemberReference_in_entryRuleMemberReference6875);
            iv_ruleMemberReference=ruleMemberReference();
            _fsp--;

             current =iv_ruleMemberReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMemberReference6885); 

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
    // $ANTLR end entryRuleMemberReference


    // $ANTLR start ruleMemberReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3734:1: ruleMemberReference returns [EObject current=null] : ( '.' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleMemberReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3739:6: ( ( '.' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3740:1: ( '.' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3740:1: ( '.' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3740:3: '.' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,41,FOLLOW_41_in_ruleMemberReference6920); 

                    createLeafNode(grammarAccess.getMemberReferenceAccess().getFullStopKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3744:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3745:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3745:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3746:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMemberReference6937); 

            			createLeafNode(grammarAccess.getMemberReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMemberReferenceRule().getType().getClassifier());
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
    // $ANTLR end ruleMemberReference


    // $ANTLR start entryRuleSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3776:1: entryRuleSubscript returns [EObject current=null] : iv_ruleSubscript= ruleSubscript EOF ;
    public final EObject entryRuleSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3777:2: (iv_ruleSubscript= ruleSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3778:2: iv_ruleSubscript= ruleSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubscript_in_entryRuleSubscript6978);
            iv_ruleSubscript=ruleSubscript();
            _fsp--;

             current =iv_ruleSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubscript6988); 

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
    // $ANTLR end entryRuleSubscript


    // $ANTLR start ruleSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3785:1: ruleSubscript returns [EObject current=null] : (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) ;
    public final EObject ruleSubscript() throws RecognitionException {
        EObject current = null;

        EObject this_ColonSubscript_0 = null;

        EObject this_ExpressionSubscript_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3790:6: ( (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3791:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3791:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==32) ) {
                alt55=1;
            }
            else if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_STRING)||LA55_0==17||LA55_0==21||(LA55_0>=35 && LA55_0<=36)||(LA55_0>=38 && LA55_0<=39)||(LA55_0>=42 && LA55_0<=43)||(LA55_0>=57 && LA55_0<=58)) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3791:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3792:5: this_ColonSubscript_0= ruleColonSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getColonSubscriptParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleColonSubscript_in_ruleSubscript7035);
                    this_ColonSubscript_0=ruleColonSubscript();
                    _fsp--;

                     
                            current = this_ColonSubscript_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3802:5: this_ExpressionSubscript_1= ruleExpressionSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getExpressionSubscriptParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionSubscript_in_ruleSubscript7062);
                    this_ExpressionSubscript_1=ruleExpressionSubscript();
                    _fsp--;

                     
                            current = this_ExpressionSubscript_1; 
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
    // $ANTLR end ruleSubscript


    // $ANTLR start entryRuleColonSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3818:1: entryRuleColonSubscript returns [EObject current=null] : iv_ruleColonSubscript= ruleColonSubscript EOF ;
    public final EObject entryRuleColonSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3819:2: (iv_ruleColonSubscript= ruleColonSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3820:2: iv_ruleColonSubscript= ruleColonSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getColonSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript7097);
            iv_ruleColonSubscript=ruleColonSubscript();
            _fsp--;

             current =iv_ruleColonSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColonSubscript7107); 

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
    // $ANTLR end entryRuleColonSubscript


    // $ANTLR start ruleColonSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3827:1: ruleColonSubscript returns [EObject current=null] : ( () ':' ) ;
    public final EObject ruleColonSubscript() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3832:6: ( ( () ':' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3833:1: ( () ':' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3833:1: ( () ':' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3833:2: () ':'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3833:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3834:5: 
            {
             
                    temp=factory.create(grammarAccess.getColonSubscriptAccess().getColonSubscriptAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getColonSubscriptAccess().getColonSubscriptAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,32,FOLLOW_32_in_ruleColonSubscript7151); 

                    createLeafNode(grammarAccess.getColonSubscriptAccess().getColonKeyword_1(), null); 
                

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
    // $ANTLR end ruleColonSubscript


    // $ANTLR start entryRuleExpressionSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3856:1: entryRuleExpressionSubscript returns [EObject current=null] : iv_ruleExpressionSubscript= ruleExpressionSubscript EOF ;
    public final EObject entryRuleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3857:2: (iv_ruleExpressionSubscript= ruleExpressionSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3858:2: iv_ruleExpressionSubscript= ruleExpressionSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript7187);
            iv_ruleExpressionSubscript=ruleExpressionSubscript();
            _fsp--;

             current =iv_ruleExpressionSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionSubscript7197); 

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
    // $ANTLR end entryRuleExpressionSubscript


    // $ANTLR start ruleExpressionSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3865:1: ruleExpressionSubscript returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3870:6: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3871:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3871:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3872:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3872:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3873:3: lv_expression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionSubscriptAccess().getExpressionExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionSubscript7242);
            lv_expression_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionSubscriptRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_0_0, 
            	        		"Expression", 
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
    // $ANTLR end ruleExpressionSubscript


    // $ANTLR start entryRuleMatrixConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3903:1: entryRuleMatrixConstructionOperator returns [EObject current=null] : iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF ;
    public final EObject entryRuleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3904:2: (iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3905:2: iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMatrixConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator7277);
            iv_ruleMatrixConstructionOperator=ruleMatrixConstructionOperator();
            _fsp--;

             current =iv_ruleMatrixConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixConstructionOperator7287); 

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
    // $ANTLR end entryRuleMatrixConstructionOperator


    // $ANTLR start ruleMatrixConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3912:1: ruleMatrixConstructionOperator returns [EObject current=null] : ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionLists_1_0 = null;

        EObject lv_expressionLists_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3917:6: ( ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3918:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3918:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3918:3: '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,39,FOLLOW_39_in_ruleMatrixConstructionOperator7322); 

                    createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3922:1: ( (lv_expressionLists_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3923:1: (lv_expressionLists_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3923:1: (lv_expressionLists_1_0= ruleExpressionList )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3924:3: lv_expressionLists_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator7343);
            lv_expressionLists_1_0=ruleExpressionList();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMatrixConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressionLists",
            	        		lv_expressionLists_1_0, 
            	        		"ExpressionList", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3946:2: ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==20) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3946:4: ';' ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    {
            	    match(input,20,FOLLOW_20_in_ruleMatrixConstructionOperator7354); 

            	            createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3950:1: ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3951:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3951:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3952:3: lv_expressionLists_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator7375);
            	    lv_expressionLists_3_0=ruleExpressionList();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMatrixConstructionOperatorRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionLists",
            	    	        		lv_expressionLists_3_0, 
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
            	    break loop56;
                }
            } while (true);

            match(input,40,FOLLOW_40_in_ruleMatrixConstructionOperator7387); 

                    createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getRightSquareBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleMatrixConstructionOperator


    // $ANTLR start entryRuleExpressionList
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3986:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3987:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3988:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList7423);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList7433); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3995:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4000:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4001:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4001:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4001:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4001:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4002:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4002:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4003:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList7479);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4025:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==16) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4025:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleExpressionList7490); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4029:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4030:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4030:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4031:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList7511);
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
            	    break loop57;
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


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4061:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4062:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4063:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression7549);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression7559); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4070:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4075:6: ( ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4076:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4076:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4076:3: '(' ( (lv_expression_1_0= ruleExpression ) ) ')'
            {
            match(input,17,FOLLOW_17_in_ruleParenthesizedExpression7594); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4080:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4081:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4081:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4082:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression7615);
            lv_expression_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParenthesizedExpressionRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleParenthesizedExpression7625); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4116:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4117:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4118:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression7661);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression7671); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4125:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4130:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4131:1: ( () 'begin' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4131:1: ( () 'begin' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4131:2: () 'begin'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4131:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4132:5: 
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

            match(input,42,FOLLOW_42_in_ruleBeginExpression7715); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4154:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4155:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4156:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression7751);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression7761); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4163:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4168:6: ( ( () 'end' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4169:1: ( () 'end' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4169:1: ( () 'end' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4169:2: () 'end'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4169:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4170:5: 
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

            match(input,43,FOLLOW_43_in_ruleEndExpression7805); 

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


    // $ANTLR start entryRuleUnitExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4192:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4193:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4194:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression7841);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression7851); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4201:1: ruleUnitExpression returns [EObject current=null] : ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_numerator_0_0 = null;

        EObject lv_denominator_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4206:6: ( ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4207:1: ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4207:1: ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4207:2: ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4207:2: ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4208:1: (lv_numerator_0_0= ruleUnitExpressionNumerator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4208:1: (lv_numerator_0_0= ruleUnitExpressionNumerator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4209:3: lv_numerator_0_0= ruleUnitExpressionNumerator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression7897);
            lv_numerator_0_0=ruleUnitExpressionNumerator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"numerator",
            	        		lv_numerator_0_0, 
            	        		"UnitExpressionNumerator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4231:2: ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==44) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4231:4: '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) )
                    {
                    match(input,44,FOLLOW_44_in_ruleUnitExpression7908); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4235:1: ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4236:1: (lv_denominator_2_0= ruleUnitExpressionDenominator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4236:1: (lv_denominator_2_0= ruleUnitExpressionDenominator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4237:3: lv_denominator_2_0= ruleUnitExpressionDenominator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression7929);
                    lv_denominator_2_0=ruleUnitExpressionDenominator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"denominator",
                    	        		lv_denominator_2_0, 
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4267:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4268:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4269:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator7967);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator7977); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4276:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4281:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4282:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4282:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_INTEGER) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_ID) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4282:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4282:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4282:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4283:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4283:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4284:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator8019); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4307:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4307:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4307:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4307:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4308:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4308:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4309:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator8052);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4331:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==45) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4331:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,45,FOLLOW_45_in_ruleUnitExpressionNumerator8063); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4335:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4336:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4336:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4337:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator8084);
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
                    	    break loop59;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4367:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4368:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4369:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator8123);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator8133); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4376:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4381:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4382:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4382:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID) ) {
                alt62=1;
            }
            else if ( (LA62_0==17) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4382:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4382:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4382:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4383:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4383:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4384:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator8179);
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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4407:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4407:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4407:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,17,FOLLOW_17_in_ruleUnitExpressionDenominator8196); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4411:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4412:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4412:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4413:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator8217);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4435:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==45) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4435:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,45,FOLLOW_45_in_ruleUnitExpressionDenominator8228); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4439:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4440:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4440:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4441:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator8249);
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
                    	    break loop61;
                        }
                    } while (true);

                    match(input,18,FOLLOW_18_in_ruleUnitExpressionDenominator8261); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4475:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4476:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4477:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor8298);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor8308); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4484:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;
        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4489:6: ( ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4490:1: ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4490:1: ( ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4490:2: ( (lv_operand_0_0= RULE_ID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4490:2: ( (lv_operand_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4491:1: (lv_operand_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4491:1: (lv_operand_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4492:3: lv_operand_0_0= RULE_ID
            {
            lv_operand_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitExpressionFactor8350); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4514:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==46) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4514:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,46,FOLLOW_46_in_ruleUnitExpressionFactor8366); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4518:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4519:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4519:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4520:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor8387);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4550:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4551:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4552:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent8425);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent8435); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4559:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4564:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4565:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4565:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4565:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4565:2: ( (lv_negative_0_0= '-' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==36) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4566:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4566:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4567:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleUnitExpressionExponent8478); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4586:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4587:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4587:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4588:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent8509); 

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


    // $ANTLR start ruleRelationalOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4618:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4622:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4623:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4623:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            int alt65=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt65=1;
                }
                break;
            case 48:
                {
                alt65=2;
                }
                break;
            case 49:
                {
                alt65=3;
                }
                break;
            case 50:
                {
                alt65=4;
                }
                break;
            case 51:
                {
                alt65=5;
                }
                break;
            case 52:
                {
                alt65=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4623:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4623:2: ( '<' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4623:2: ( '<' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4623:4: '<'
                    {
                    match(input,47,FOLLOW_47_in_ruleRelationalOperator8562); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4629:6: ( '<=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4629:6: ( '<=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4629:8: '<='
                    {
                    match(input,48,FOLLOW_48_in_ruleRelationalOperator8577); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4635:6: ( '>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4635:6: ( '>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4635:8: '>'
                    {
                    match(input,49,FOLLOW_49_in_ruleRelationalOperator8592); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4641:6: ( '>=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4641:6: ( '>=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4641:8: '>='
                    {
                    match(input,50,FOLLOW_50_in_ruleRelationalOperator8607); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4647:6: ( '==' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4647:6: ( '==' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4647:8: '=='
                    {
                    match(input,51,FOLLOW_51_in_ruleRelationalOperator8622); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4653:6: ( '<>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4653:6: ( '<>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4653:8: '<>'
                    {
                    match(input,52,FOLLOW_52_in_ruleRelationalOperator8637); 

                            current = grammarAccess.getRelationalOperatorAccess().getNotEqualToEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getNotEqualToEnumLiteralDeclaration_5(), null); 
                        

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


    // $ANTLR start ruleAddSubtractOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4663:1: ruleAddSubtractOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAddSubtractOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4667:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4668:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4668:1: ( ( '+' ) | ( '-' ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==53) ) {
                alt66=1;
            }
            else if ( (LA66_0==36) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4668:1: ( ( '+' ) | ( '-' ) )", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4668:2: ( '+' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4668:2: ( '+' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4668:4: '+'
                    {
                    match(input,53,FOLLOW_53_in_ruleAddSubtractOperator8680); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4674:6: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4674:6: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4674:8: '-'
                    {
                    match(input,36,FOLLOW_36_in_ruleAddSubtractOperator8695); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getSubtractEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleAddSubtractOperator


    // $ANTLR start ruleMultiplyDivideOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4684:1: ruleMultiplyDivideOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplyDivideOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4688:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4689:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4689:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt67=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt67=1;
                }
                break;
            case 44:
                {
                alt67=2;
                }
                break;
            case 54:
                {
                alt67=3;
                }
                break;
            case 55:
                {
                alt67=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4689:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4689:2: ( '*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4689:2: ( '*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4689:4: '*'
                    {
                    match(input,45,FOLLOW_45_in_ruleMultiplyDivideOperator8738); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4695:6: ( '/' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4695:6: ( '/' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4695:8: '/'
                    {
                    match(input,44,FOLLOW_44_in_ruleMultiplyDivideOperator8753); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4701:6: ( '.*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4701:6: ( '.*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4701:8: '.*'
                    {
                    match(input,54,FOLLOW_54_in_ruleMultiplyDivideOperator8768); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4707:6: ( './' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4707:6: ( './' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4707:8: './'
                    {
                    match(input,55,FOLLOW_55_in_ruleMultiplyDivideOperator8783); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseDivideEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseDivideEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end ruleMultiplyDivideOperator


    // $ANTLR start rulePowerOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4717:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4721:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4722:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4722:1: ( ( '^' ) | ( '.^' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==46) ) {
                alt68=1;
            }
            else if ( (LA68_0==56) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4722:1: ( ( '^' ) | ( '.^' ) )", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4722:2: ( '^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4722:2: ( '^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4722:4: '^'
                    {
                    match(input,46,FOLLOW_46_in_rulePowerOperator8826); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4728:6: ( '.^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4728:6: ( '.^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4728:8: '.^'
                    {
                    match(input,56,FOLLOW_56_in_rulePowerOperator8841); 

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


    // $ANTLR start ruleBooleanKind
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4738:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4742:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4743:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4743:1: ( ( 'false' ) | ( 'true' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==57) ) {
                alt69=1;
            }
            else if ( (LA69_0==58) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4743:1: ( ( 'false' ) | ( 'true' ) )", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4743:2: ( 'false' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4743:2: ( 'false' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4743:4: 'false'
                    {
                    match(input,57,FOLLOW_57_in_ruleBooleanKind8884); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4749:6: ( 'true' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4749:6: ( 'true' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4749:8: 'true'
                    {
                    match(input,58,FOLLOW_58_in_ruleBooleanKind8899); 

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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA3_eotS =
        "\177\uffff";
    static final String DFA3_eofS =
        "\177\uffff";
    static final String DFA3_minS =
        "\1\4\2\uffff\10\4\1\20\3\4\1\uffff\1\4\2\22\1\uffff\6\22\3\4\1\6"+
        "\3\4\1\6\3\4\1\6\3\4\1\6\1\4\1\22\1\4\1\6\3\22\1\4\1\6\3\22\1\4"+
        "\1\6\3\22\1\4\1\6\2\22\1\6\1\22\2\6\1\22\2\6\1\22\2\6\1\22\2\6\1"+
        "\22\1\6\1\4\1\22\1\6\1\22\1\6\1\22\1\6\1\4\1\22\1\6\1\22\1\6\1\22"+
        "\1\6\1\4\1\22\1\6\1\22\1\6\1\22\1\6\1\4\1\22\1\6\1\22\1\6\2\22\1"+
        "\6\2\22\1\6\2\22\1\6\2\22\5\6\1\22\1\6\1\22\1\6\1\22\1\6\1\22";
    static final String DFA3_maxS =
        "\1\36\2\uffff\4\21\2\4\1\46\1\6\1\24\3\6\1\uffff\1\4\1\54\1\56\1"+
        "\uffff\1\54\1\56\1\54\1\56\1\54\1\56\1\46\1\21\1\4\1\44\1\4\1\21"+
        "\1\4\1\44\1\4\1\21\1\4\1\44\1\4\1\21\1\4\1\44\1\4\1\56\1\4\1\6\1"+
        "\55\2\56\1\4\1\6\1\55\2\56\1\4\1\6\1\55\2\56\1\4\1\6\1\55\1\56\1"+
        "\44\1\56\2\44\1\56\2\44\1\56\2\44\1\56\1\44\1\6\1\22\1\44\1\4\1"+
        "\22\1\6\1\55\1\6\1\22\1\44\1\4\1\22\1\6\1\55\1\6\1\22\1\44\1\4\1"+
        "\22\1\6\1\55\1\6\1\22\1\44\1\4\1\22\1\6\1\55\1\6\1\55\1\56\1\6\1"+
        "\55\1\56\1\6\1\55\1\56\1\6\1\55\1\56\4\44\1\6\1\55\1\6\1\55\1\6"+
        "\1\55\1\6\1\55";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\14\uffff\1\3\3\uffff\1\4\153\uffff";
    static final String DFA3_specialS =
        "\177\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\11\7\uffff\1\1\2\uffff\1\2\11\uffff\1\3\1\4\1\5\1\6\1\7\1"+
            "\10",
            "",
            "",
            "\1\13\14\uffff\1\12",
            "\1\13\14\uffff\1\14",
            "\1\13\14\uffff\1\15",
            "\1\13\14\uffff\1\16",
            "\1\13",
            "\1\13",
            "\1\13\14\uffff\1\17\24\uffff\1\20",
            "\1\22\1\uffff\1\21",
            "\1\23\1\17\1\uffff\2\23",
            "\1\25\1\uffff\1\24",
            "\1\27\1\uffff\1\26",
            "\1\31\1\uffff\1\30",
            "",
            "\1\32",
            "\1\34\31\uffff\1\33",
            "\1\34\31\uffff\1\33\1\36\1\35",
            "",
            "\1\40\31\uffff\1\37",
            "\1\40\31\uffff\1\37\1\42\1\41",
            "\1\44\31\uffff\1\43",
            "\1\44\31\uffff\1\43\1\46\1\45",
            "\1\50\31\uffff\1\47",
            "\1\50\31\uffff\1\47\1\52\1\51",
            "\1\13\41\uffff\1\20",
            "\1\53\14\uffff\1\54",
            "\1\13",
            "\1\56\35\uffff\1\55",
            "\1\57",
            "\1\60\14\uffff\1\61",
            "\1\13",
            "\1\63\35\uffff\1\62",
            "\1\64",
            "\1\65\14\uffff\1\66",
            "\1\13",
            "\1\70\35\uffff\1\67",
            "\1\71",
            "\1\72\14\uffff\1\73",
            "\1\13",
            "\1\75\35\uffff\1\74",
            "\1\76",
            "\1\34\33\uffff\1\77",
            "\1\100",
            "\1\56",
            "\1\34\31\uffff\1\33\1\36",
            "\1\34\31\uffff\1\33\1\36\1\101",
            "\1\40\33\uffff\1\102",
            "\1\103",
            "\1\63",
            "\1\40\31\uffff\1\37\1\42",
            "\1\40\31\uffff\1\37\1\42\1\104",
            "\1\44\33\uffff\1\105",
            "\1\106",
            "\1\70",
            "\1\44\31\uffff\1\43\1\46",
            "\1\44\31\uffff\1\43\1\46\1\107",
            "\1\50\33\uffff\1\110",
            "\1\111",
            "\1\75",
            "\1\50\31\uffff\1\47\1\52",
            "\1\50\31\uffff\1\47\1\52\1\112",
            "\1\114\35\uffff\1\113",
            "\1\117\32\uffff\1\116\1\115",
            "\1\121\35\uffff\1\120",
            "\1\123\35\uffff\1\122",
            "\1\126\32\uffff\1\125\1\124",
            "\1\130\35\uffff\1\127",
            "\1\132\35\uffff\1\131",
            "\1\135\32\uffff\1\134\1\133",
            "\1\137\35\uffff\1\136",
            "\1\141\35\uffff\1\140",
            "\1\144\32\uffff\1\143\1\142",
            "\1\146\35\uffff\1\145",
            "\1\114",
            "\1\34",
            "\1\150\35\uffff\1\147",
            "\1\151",
            "\1\34",
            "\1\121",
            "\1\34\31\uffff\1\33\1\36",
            "\1\123",
            "\1\40",
            "\1\153\35\uffff\1\152",
            "\1\154",
            "\1\40",
            "\1\130",
            "\1\40\31\uffff\1\37\1\42",
            "\1\132",
            "\1\44",
            "\1\156\35\uffff\1\155",
            "\1\157",
            "\1\44",
            "\1\137",
            "\1\44\31\uffff\1\43\1\46",
            "\1\141",
            "\1\50",
            "\1\161\35\uffff\1\160",
            "\1\162",
            "\1\50",
            "\1\146",
            "\1\50\31\uffff\1\47\1\52",
            "\1\150",
            "\1\117\32\uffff\1\116",
            "\1\117\32\uffff\1\116\1\163",
            "\1\153",
            "\1\126\32\uffff\1\125",
            "\1\126\32\uffff\1\125\1\164",
            "\1\156",
            "\1\135\32\uffff\1\134",
            "\1\135\32\uffff\1\134\1\165",
            "\1\161",
            "\1\144\32\uffff\1\143",
            "\1\144\32\uffff\1\143\1\166",
            "\1\170\35\uffff\1\167",
            "\1\172\35\uffff\1\171",
            "\1\174\35\uffff\1\173",
            "\1\176\35\uffff\1\175",
            "\1\170",
            "\1\117\32\uffff\1\116",
            "\1\172",
            "\1\126\32\uffff\1\125",
            "\1\174",
            "\1\135\32\uffff\1\134",
            "\1\176",
            "\1\144\32\uffff\1\143"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_VariableDeclaration_3= ruleVariableDeclaration )";
        }
    }
    static final String DFA9_eotS =
        "\11\uffff";
    static final String DFA9_eofS =
        "\11\uffff";
    static final String DFA9_minS =
        "\1\4\2\uffff\1\4\3\uffff\2\4";
    static final String DFA9_maxS =
        "\1\46\2\uffff\1\51\3\uffff\1\4\1\51";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\1\4\1\5\2\uffff";
    static final String DFA9_specialS =
        "\11\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\3\10\uffff\1\1\7\uffff\1\4\2\uffff\1\5\6\6\7\uffff\1\2",
            "",
            "",
            "\1\6\14\uffff\1\2\1\uffff\2\2\21\uffff\1\7\1\2\1\uffff\1\2",
            "",
            "",
            "",
            "\1\10",
            "\1\6\14\uffff\1\2\1\uffff\2\2\21\uffff\1\7\1\2\1\uffff\1\2"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "669:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_VariableDeclaration_4= ruleVariableDeclaration )";
        }
    }
 

    public static final BitSet FOLLOW_ruleMscript_in_entryRuleMscript75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMscript85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_ruleMscript130 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackageDefinition211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDefinition232 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackageDefinition242 = new BitSet(new long[]{0x000000007E00D010L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_rulePackageDefinition263 = new BitSet(new long[]{0x000000007E00D010L});
    public static final BitSet FOLLOW_14_in_rulePackageDefinition274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_entryRulePackageDefinitionElement310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinitionElement320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rulePackageDefinitionElement367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_rulePackageDefinitionElement394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_rulePackageDefinitionElement421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_rulePackageDefinitionElement448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationDefinition493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationDefinition528 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationDefinition545 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationDefinition560 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition582 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_ruleEnumerationDefinition593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition614 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationDefinition628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationLiteralDeclaration715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleFunctionDefinition811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionDefinition829 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionDefinition844 = new BitSet(new long[]{0x000000007E040010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition866 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionDefinition877 = new BitSet(new long[]{0x000000007E000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition898 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleFunctionDefinition912 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunctionDefinition933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterDeclaration979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleParameterDeclaration1025 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameterDeclaration1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement1083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallStatement_in_ruleStatement1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStatement1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock1283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleBlock1337 = new BitSet(new long[]{0x000000407F206010L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock1358 = new BitSet(new long[]{0x000000407F206010L});
    public static final BitSet FOLLOW_14_in_ruleBlock1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallStatement_in_entryRuleFeatureCallStatement1405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallStatement1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleFeatureCallStatement1461 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_ruleFeatureCallStatement1480 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCallStatement1514 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFeatureCallStatement1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleIfStatement1607 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleIfCase_in_ruleIfStatement1628 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_ruleIfStatement1639 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleIfCase_in_ruleIfStatement1660 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_23_in_ruleIfStatement1673 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfCase_in_entryRuleIfCase1732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfCase1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfCase1788 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfCase1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleWhileStatement1890 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileStatement1911 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleVariableDeclaration2024 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration2045 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_16_in_ruleVariableDeclaration2056 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration2077 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleVariableDeclaration2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_entryRuleVariableDeclarationItem2125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationItem2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclarationItem2177 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclarationItem2193 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclarationItem2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeSpecifier2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier2517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier2527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericalTypeSpecifier2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericalTypeSpecifier2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier2690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleRealTypeSpecifier2744 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleRealTypeSpecifier2755 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier2776 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRealTypeSpecifier2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier2824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleIntegerTypeSpecifier2878 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleIntegerTypeSpecifier2889 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier2910 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIntegerTypeSpecifier2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier2958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleComplexTypeSpecifier3012 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleComplexTypeSpecifier3023 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3044 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleComplexTypeSpecifier3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleGaussianTypeSpecifier3146 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleGaussianTypeSpecifier3157 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3178 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleGaussianTypeSpecifier3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBooleanTypeSpecifier3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier3316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleStringTypeSpecifier3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier3406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTypeSpecifier3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression3496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression3580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression3615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleConditionalExpression3660 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression3681 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleConditionalExpression3692 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression3713 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleConditionalExpression3725 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpression3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase3782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpressionCase3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase3838 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleConditionalExpressionCase3848 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression3905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression3962 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleRangeExpression3981 = new BitSet(new long[]{0x06000CD8000200F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression4002 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleRangeExpression4013 = new BitSet(new long[]{0x06000CD8000200F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression4034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression4074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4131 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleLogicalOrExpression4151 = new BitSet(new long[]{0x06000CD8000200F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4172 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression4212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression4222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4269 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleLogicalAndExpression4289 = new BitSet(new long[]{0x06000CD8000200F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4310 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression4350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression4407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLogicalNotExpression4432 = new BitSet(new long[]{0x06000CD0000200F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression4453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression4490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression4500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression4547 = new BitSet(new long[]{0x001F800000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression4578 = new BitSet(new long[]{0x06000CD0000200F0L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression4599 = new BitSet(new long[]{0x001F800000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression4639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddSubtractExpression4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression4696 = new BitSet(new long[]{0x0020001000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression4727 = new BitSet(new long[]{0x06000CD0000200F0L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression4748 = new BitSet(new long[]{0x0020001000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression4788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyDivideExpression4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression4845 = new BitSet(new long[]{0x00C0300000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression4876 = new BitSet(new long[]{0x06000CD0000200F0L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression4897 = new BitSet(new long[]{0x00C0300000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression4937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression4947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression4994 = new BitSet(new long[]{0x0100400000000002L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression5024 = new BitSet(new long[]{0x06000CD0000200F0L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression5045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression5083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryMinusExpression5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression5140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryMinusExpression5165 = new BitSet(new long[]{0x06000CC0000200F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression5186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression5223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePrimaryExpression5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression5334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_rulePrimaryExpression5361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral5450 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral5460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_ruleLiteral5507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral5534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral5561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral5596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalLiteral5606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral5653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral5715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral5767 = new BitSet(new long[]{0x0000002000020002L});
    public static final BitSet FOLLOW_37_in_ruleRealLiteral5790 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleRealLiteral5815 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral5836 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRealLiteral5846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral5884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral5936 = new BitSet(new long[]{0x0000002000020002L});
    public static final BitSet FOLLOW_37_in_ruleIntegerLiteral5959 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleIntegerLiteral5984 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral6005 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIntegerLiteral6015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral6053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral6108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral6143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral6194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6286 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName6302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6319 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall6362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall6372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleFeatureCall6415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeatureCall6450 = new BitSet(new long[]{0x0000028000020002L});
    public static final BitSet FOLLOW_ruleComponentReference_in_ruleFeatureCall6471 = new BitSet(new long[]{0x0000028000020002L});
    public static final BitSet FOLLOW_17_in_ruleFeatureCall6491 = new BitSet(new long[]{0x06000CD8002600F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall6526 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureCall6537 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall6558 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureCall6572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentReference_in_entryRuleComponentReference6610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentReference6620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayReference_in_ruleComponentReference6667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMemberReference_in_ruleComponentReference6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayReference_in_entryRuleArrayReference6729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayReference6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleArrayReference6774 = new BitSet(new long[]{0x06000CD9002200F0L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayReference6795 = new BitSet(new long[]{0x0000010000010000L});
    public static final BitSet FOLLOW_16_in_ruleArrayReference6806 = new BitSet(new long[]{0x06000CD9002200F0L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayReference6827 = new BitSet(new long[]{0x0000010000010000L});
    public static final BitSet FOLLOW_40_in_ruleArrayReference6839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMemberReference_in_entryRuleMemberReference6875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMemberReference6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleMemberReference6920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMemberReference6937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubscript_in_entryRuleSubscript6978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubscript6988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_ruleSubscript7035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_ruleSubscript7062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript7097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColonSubscript7107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleColonSubscript7151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript7187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionSubscript7197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionSubscript7242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator7277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixConstructionOperator7287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleMatrixConstructionOperator7322 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator7343 = new BitSet(new long[]{0x0000010000100000L});
    public static final BitSet FOLLOW_20_in_ruleMatrixConstructionOperator7354 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator7375 = new BitSet(new long[]{0x0000010000100000L});
    public static final BitSet FOLLOW_40_in_ruleMatrixConstructionOperator7387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList7423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList7433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList7479 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionList7490 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList7511 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression7549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression7559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedExpression7594 = new BitSet(new long[]{0x06000CD8002200F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression7615 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleParenthesizedExpression7625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression7661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression7671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleBeginExpression7715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression7751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression7761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleEndExpression7805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression7841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression7851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression7897 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleUnitExpression7908 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression7929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator7967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator7977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator8019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator8052 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleUnitExpressionNumerator8063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator8084 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator8123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator8133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator8179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleUnitExpressionDenominator8196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator8217 = new BitSet(new long[]{0x0000200000040000L});
    public static final BitSet FOLLOW_45_in_ruleUnitExpressionDenominator8228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator8249 = new BitSet(new long[]{0x0000200000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnitExpressionDenominator8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor8298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor8308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitExpressionFactor8350 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleUnitExpressionFactor8366 = new BitSet(new long[]{0x0000001000000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor8387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent8425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent8435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnitExpressionExponent8478 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent8509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelationalOperator8562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelationalOperator8577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRelationalOperator8592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelationalOperator8607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRelationalOperator8622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleRelationalOperator8637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleAddSubtractOperator8680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAddSubtractOperator8695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleMultiplyDivideOperator8738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleMultiplyDivideOperator8753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleMultiplyDivideOperator8768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleMultiplyDivideOperator8783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulePowerOperator8826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rulePowerOperator8841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleBooleanKind8884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleBooleanKind8899 = new BitSet(new long[]{0x0000000000000002L});

}