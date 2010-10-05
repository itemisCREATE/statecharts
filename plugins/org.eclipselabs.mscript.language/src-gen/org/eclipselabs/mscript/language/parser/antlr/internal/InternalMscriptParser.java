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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'enum'", "','", "'record'", "';'", "'static'", "'func'", "'('", "')'", "'ref'", "'='", "'if'", "'elseif'", "'else'", "'while'", "'do'", "'foreach'", "'in'", "'var'", "'auto'", "'const'", "'type'", "'return'", "'real'", "'['", "']'", "'int'", "'complex'", "'gauss'", "'bool'", "'string'", "'?'", "'..'", "'unit'", "'then'", "':'", "'or'", "'and'", "'not'", "'is'", "'-'", "'.'", "'j'", "'::'", "'begin'", "'end'", "'eval'", "'/'", "'*'", "'^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'+'", "'.*'", "'./'", "'.^'", "'false'", "'true'"
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

                if ( (LA2_0==12||LA2_0==15||LA2_0==17||(LA2_0>=19 && LA2_0<=20)||(LA2_0>=32 && LA2_0<=35)||LA2_0==37||(LA2_0>=40 && LA2_0<=44)||LA2_0==47) ) {
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:217:1: rulePackageDefinitionElement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration ) ;
    public final EObject rulePackageDefinitionElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_EnumerationDefinition_1 = null;

        EObject this_RecordDefinition_2 = null;

        EObject this_FunctionDefinition_3 = null;

        EObject this_TypeDefinition_4 = null;

        EObject this_VariableDeclaration_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:222:6: ( (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 19:
                {
                int LA3_4 = input.LA(2);

                if ( (LA3_4==20) ) {
                    alt3=4;
                }
                else if ( (LA3_4==32||LA3_4==37||(LA3_4>=40 && LA3_4<=44)||LA3_4==47) ) {
                    alt3=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration )", 3, 4, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                alt3=4;
                }
                break;
            case 35:
                {
                alt3=5;
                }
                break;
            case 32:
            case 33:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 47:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration )", 3, 0, input);

                throw nvae;
            }

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:244:5: this_RecordDefinition_2= ruleRecordDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getRecordDefinitionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRecordDefinition_in_rulePackageDefinitionElement421);
                    this_RecordDefinition_2=ruleRecordDefinition();
                    _fsp--;

                     
                            current = this_RecordDefinition_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:254:5: this_FunctionDefinition_3= ruleFunctionDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getFunctionDefinitionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_rulePackageDefinitionElement448);
                    this_FunctionDefinition_3=ruleFunctionDefinition();
                    _fsp--;

                     
                            current = this_FunctionDefinition_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:264:5: this_TypeDefinition_4= ruleTypeDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getTypeDefinitionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeDefinition_in_rulePackageDefinitionElement475);
                    this_TypeDefinition_4=ruleTypeDefinition();
                    _fsp--;

                     
                            current = this_TypeDefinition_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:274:5: this_VariableDeclaration_5= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getVariableDeclarationParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_rulePackageDefinitionElement502);
                    this_VariableDeclaration_5=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_5; 
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:290:1: entryRuleEnumerationDefinition returns [EObject current=null] : iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF ;
    public final EObject entryRuleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:291:2: (iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:292:2: iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition537);
            iv_ruleEnumerationDefinition=ruleEnumerationDefinition();
            _fsp--;

             current =iv_ruleEnumerationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationDefinition547); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:299:1: ruleEnumerationDefinition returns [EObject current=null] : ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) ;
    public final EObject ruleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:304:6: ( ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:305:1: ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:305:1: ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:305:3: 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}'
            {
            match(input,15,FOLLOW_15_in_ruleEnumerationDefinition582); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:309:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:310:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:310:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:311:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleEnumerationDefinition603);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEnumerationDefinition613); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:337:1: ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID||LA5_0==56) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:337:2: ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:337:2: ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:338:1: (lv_literals_3_0= ruleEnumerationLiteralDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:338:1: (lv_literals_3_0= ruleEnumerationLiteralDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:339:3: lv_literals_3_0= ruleEnumerationLiteralDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDeclarationParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition635);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:361:2: ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:361:4: ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleEnumerationDefinition646); 

                    	            createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:365:1: ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:366:1: (lv_literals_5_0= ruleEnumerationLiteralDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:366:1: (lv_literals_5_0= ruleEnumerationLiteralDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:367:3: lv_literals_5_0= ruleEnumerationLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDeclarationParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition667);
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

            match(input,14,FOLLOW_14_in_ruleEnumerationDefinition681); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:401:1: entryRuleEnumerationLiteralDeclaration returns [EObject current=null] : iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF ;
    public final EObject entryRuleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:402:2: (iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:403:2: iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationLiteralDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration717);
            iv_ruleEnumerationLiteralDeclaration=ruleEnumerationLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumerationLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration727); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:410:1: ruleEnumerationLiteralDeclaration returns [EObject current=null] : ( (lv_name_0_0= ruleKeywordID ) ) ;
    public final EObject ruleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:415:6: ( ( (lv_name_0_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:416:1: ( (lv_name_0_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:416:1: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:417:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:417:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:418:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumerationLiteralDeclarationAccess().getNameKeywordIDParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleEnumerationLiteralDeclaration772);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
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
    // $ANTLR end ruleEnumerationLiteralDeclaration


    // $ANTLR start entryRuleRecordDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:448:1: entryRuleRecordDefinition returns [EObject current=null] : iv_ruleRecordDefinition= ruleRecordDefinition EOF ;
    public final EObject entryRuleRecordDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:449:2: (iv_ruleRecordDefinition= ruleRecordDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:450:2: iv_ruleRecordDefinition= ruleRecordDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition807);
            iv_ruleRecordDefinition=ruleRecordDefinition();
            _fsp--;

             current =iv_ruleRecordDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordDefinition817); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:457:1: ruleRecordDefinition returns [EObject current=null] : ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' ) ;
    public final EObject ruleRecordDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fields_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:462:6: ( ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:463:1: ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:463:1: ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:463:3: 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}'
            {
            match(input,17,FOLLOW_17_in_ruleRecordDefinition852); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getRecordKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:467:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:468:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:468:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:469:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleRecordDefinition873);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleRecordDefinition883); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:495:1: ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||LA6_0==37||(LA6_0>=40 && LA6_0<=44)||(LA6_0>=56 && LA6_0<=57)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:496:1: (lv_fields_3_0= ruleRecordFieldDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:496:1: (lv_fields_3_0= ruleRecordFieldDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:497:3: lv_fields_3_0= ruleRecordFieldDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecordDefinitionAccess().getFieldsRecordFieldDeclarationParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition904);
            	    lv_fields_3_0=ruleRecordFieldDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRecordDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"fields",
            	    	        		lv_fields_3_0, 
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

            match(input,14,FOLLOW_14_in_ruleRecordDefinition915); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:531:1: entryRuleRecordFieldDeclaration returns [EObject current=null] : iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF ;
    public final EObject entryRuleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordFieldDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:532:2: (iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:533:2: iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordFieldDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration951);
            iv_ruleRecordFieldDeclaration=ruleRecordFieldDeclaration();
            _fsp--;

             current =iv_ruleRecordFieldDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordFieldDeclaration961); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:540:1: ruleRecordFieldDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleRecordFieldDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) ) )* ';' ) ;
    public final EObject ruleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_items_1_0 = null;

        EObject lv_items_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:545:6: ( ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleRecordFieldDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) ) )* ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:546:1: ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleRecordFieldDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) ) )* ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:546:1: ( ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleRecordFieldDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) ) )* ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:546:2: ( (lv_type_0_0= ruleDataTypeSpecifier ) ) ( (lv_items_1_0= ruleRecordFieldDeclarationItem ) ) ( ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) ) )* ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:546:2: ( (lv_type_0_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:547:1: (lv_type_0_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:547:1: (lv_type_0_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:548:3: lv_type_0_0= ruleDataTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getTypeDataTypeSpecifierParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1007);
            lv_type_0_0=ruleDataTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:570:2: ( (lv_items_1_0= ruleRecordFieldDeclarationItem ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:571:1: (lv_items_1_0= ruleRecordFieldDeclarationItem )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:571:1: (lv_items_1_0= ruleRecordFieldDeclarationItem )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:572:3: lv_items_1_0= ruleRecordFieldDeclarationItem
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getItemsRecordFieldDeclarationItemParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRecordFieldDeclarationItem_in_ruleRecordFieldDeclaration1028);
            lv_items_1_0=ruleRecordFieldDeclarationItem();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"items",
            	        		lv_items_1_0, 
            	        		"RecordFieldDeclarationItem", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:594:2: ( ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:594:4: ',' ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleRecordFieldDeclaration1039); 

            	            createLeafNode(grammarAccess.getRecordFieldDeclarationAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:598:1: ( (lv_items_3_0= ruleRecordFieldDeclarationItem ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:599:1: (lv_items_3_0= ruleRecordFieldDeclarationItem )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:599:1: (lv_items_3_0= ruleRecordFieldDeclarationItem )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:600:3: lv_items_3_0= ruleRecordFieldDeclarationItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getItemsRecordFieldDeclarationItemParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRecordFieldDeclarationItem_in_ruleRecordFieldDeclaration1060);
            	    lv_items_3_0=ruleRecordFieldDeclarationItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_3_0, 
            	    	        		"RecordFieldDeclarationItem", 
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

            match(input,18,FOLLOW_18_in_ruleRecordFieldDeclaration1072); 

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


    // $ANTLR start entryRuleRecordFieldDeclarationItem
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:634:1: entryRuleRecordFieldDeclarationItem returns [EObject current=null] : iv_ruleRecordFieldDeclarationItem= ruleRecordFieldDeclarationItem EOF ;
    public final EObject entryRuleRecordFieldDeclarationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordFieldDeclarationItem = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:635:2: (iv_ruleRecordFieldDeclarationItem= ruleRecordFieldDeclarationItem EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:636:2: iv_ruleRecordFieldDeclarationItem= ruleRecordFieldDeclarationItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordFieldDeclarationItemRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordFieldDeclarationItem_in_entryRuleRecordFieldDeclarationItem1108);
            iv_ruleRecordFieldDeclarationItem=ruleRecordFieldDeclarationItem();
            _fsp--;

             current =iv_ruleRecordFieldDeclarationItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordFieldDeclarationItem1118); 

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
    // $ANTLR end entryRuleRecordFieldDeclarationItem


    // $ANTLR start ruleRecordFieldDeclarationItem
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:643:1: ruleRecordFieldDeclarationItem returns [EObject current=null] : ( (lv_name_0_0= ruleKeywordID ) ) ;
    public final EObject ruleRecordFieldDeclarationItem() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:648:6: ( ( (lv_name_0_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:649:1: ( (lv_name_0_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:649:1: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:650:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:650:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:651:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationItemAccess().getNameKeywordIDParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleRecordFieldDeclarationItem1163);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationItemRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
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
    // $ANTLR end ruleRecordFieldDeclarationItem


    // $ANTLR start entryRuleFunctionDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:681:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:682:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:683:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1198);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();
            _fsp--;

             current =iv_ruleFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition1208); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:690:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_8_0= ruleBlock ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_body_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:695:6: ( ( ( (lv_static_0_0= 'static' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_8_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:1: ( ( (lv_static_0_0= 'static' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_8_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:1: ( ( (lv_static_0_0= 'static' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_8_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:2: ( (lv_static_0_0= 'static' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_8_0= ruleBlock ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:2: ( (lv_static_0_0= 'static' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:697:1: (lv_static_0_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:697:1: (lv_static_0_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:698:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleFunctionDefinition1251); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getStaticStaticKeyword_0_0(), "static"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
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

            match(input,20,FOLLOW_20_in_ruleFunctionDefinition1275); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getFuncKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:721:1: ( (lv_name_2_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:722:1: (lv_name_2_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:722:1: (lv_name_2_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:723:3: lv_name_2_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getNameKeywordIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleFunctionDefinition1296);
            lv_name_2_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,21,FOLLOW_21_in_ruleFunctionDefinition1306); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:749:1: ( ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||LA10_0==19||LA10_0==23||(LA10_0>=33 && LA10_0<=34)||LA10_0==37||(LA10_0>=40 && LA10_0<=44)||LA10_0==47||(LA10_0>=56 && LA10_0<=57)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:749:2: ( (lv_parameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:749:2: ( (lv_parameters_4_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:750:1: (lv_parameters_4_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:750:1: (lv_parameters_4_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:751:3: lv_parameters_4_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterDeclarationParserRuleCall_4_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1328);
                    lv_parameters_4_0=ruleParameterDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"parameters",
                    	        		lv_parameters_4_0, 
                    	        		"ParameterDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:773:2: ( ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==16) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:773:4: ',' ( (lv_parameters_6_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionDefinition1339); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_4_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:777:1: ( (lv_parameters_6_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:778:1: (lv_parameters_6_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:778:1: (lv_parameters_6_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:779:3: lv_parameters_6_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterDeclarationParserRuleCall_4_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1360);
                    	    lv_parameters_6_0=ruleParameterDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"parameters",
                    	    	        		lv_parameters_6_0, 
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleFunctionDefinition1374); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_5(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:805:1: ( (lv_body_8_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:806:1: (lv_body_8_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:806:1: (lv_body_8_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:807:3: lv_body_8_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunctionDefinition1395);
            lv_body_8_0=ruleBlock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_8_0, 
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:837:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:838:2: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:839:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1431);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();
            _fsp--;

             current =iv_ruleParameterDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterDeclaration1441); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:846:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_reference_1_0=null;
        EObject lv_modifier_0_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:851:6: ( ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:852:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:852:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:852:2: ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:852:2: ( (lv_modifier_0_0= ruleVariableModifier ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19||(LA11_0>=33 && LA11_0<=34)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:853:1: (lv_modifier_0_0= ruleVariableModifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:853:1: (lv_modifier_0_0= ruleVariableModifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:854:3: lv_modifier_0_0= ruleVariableModifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getModifierVariableModifierParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableModifier_in_ruleParameterDeclaration1487);
                    lv_modifier_0_0=ruleVariableModifier();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"modifier",
                    	        		lv_modifier_0_0, 
                    	        		"VariableModifier", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:876:3: ( (lv_reference_1_0= 'ref' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:877:1: (lv_reference_1_0= 'ref' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:877:1: (lv_reference_1_0= 'ref' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:878:3: lv_reference_1_0= 'ref'
                    {
                    lv_reference_1_0=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleParameterDeclaration1506); 

                            createLeafNode(grammarAccess.getParameterDeclarationAccess().getReferenceRefKeyword_1_0(), "reference"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "reference", true, "ref", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:897:3: ( (lv_type_2_0= ruleTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:898:1: (lv_type_2_0= ruleTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:898:1: (lv_type_2_0= ruleTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:899:3: lv_type_2_0= ruleTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeSpecifierParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeSpecifier_in_ruleParameterDeclaration1541);
            lv_type_2_0=ruleTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
            	        		"TypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:921:2: ( (lv_name_3_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:922:1: (lv_name_3_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:922:1: (lv_name_3_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:923:3: lv_name_3_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getNameKeywordIDParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleParameterDeclaration1562);
            lv_name_3_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"KeywordID", 
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
    // $ANTLR end ruleParameterDeclaration


    // $ANTLR start entryRuleStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:953:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:954:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:955:2: iv_ruleStatement= ruleStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement1598);
            iv_ruleStatement=ruleStatement();
            _fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement1608); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:962:1: ruleStatement returns [EObject current=null] : (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Block_0 = null;

        EObject this_FeatureCallStatement_1 = null;

        EObject this_IfStatement_2 = null;

        EObject this_WhileStatement_3 = null;

        EObject this_DoWhileStatement_4 = null;

        EObject this_ForeachStatement_5 = null;

        EObject this_TypeDefinition_6 = null;

        EObject this_VariableDeclaration_7 = null;

        EObject this_ReturnStatement_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:967:6: ( (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:968:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:968:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )
            int alt13=9;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt13=1;
                }
                break;
            case RULE_ID:
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 21:
            case 38:
            case 56:
            case 57:
            case 58:
            case 59:
            case 74:
            case 75:
                {
                alt13=2;
                }
                break;
            case 47:
                {
                int LA13_3 = input.LA(2);

                if ( (LA13_3==21) ) {
                    alt13=2;
                }
                else if ( (LA13_3==RULE_ID||LA13_3==56) ) {
                    alt13=8;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("968:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case 25:
                {
                alt13=3;
                }
                break;
            case 28:
                {
                alt13=4;
                }
                break;
            case 29:
                {
                alt13=5;
                }
                break;
            case 30:
                {
                alt13=6;
                }
                break;
            case 35:
                {
                alt13=7;
                }
                break;
            case 19:
            case 32:
            case 33:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt13=8;
                }
                break;
            case 36:
                {
                alt13=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("968:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:969:5: this_Block_0= ruleBlock
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1655);
                    this_Block_0=ruleBlock();
                    _fsp--;

                     
                            current = this_Block_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:979:5: this_FeatureCallStatement_1= ruleFeatureCallStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getFeatureCallStatementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCallStatement_in_ruleStatement1682);
                    this_FeatureCallStatement_1=ruleFeatureCallStatement();
                    _fsp--;

                     
                            current = this_FeatureCallStatement_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:989:5: this_IfStatement_2= ruleIfStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement1709);
                    this_IfStatement_2=ruleIfStatement();
                    _fsp--;

                     
                            current = this_IfStatement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:999:5: this_WhileStatement_3= ruleWhileStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1736);
                    this_WhileStatement_3=ruleWhileStatement();
                    _fsp--;

                     
                            current = this_WhileStatement_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1009:5: this_DoWhileStatement_4= ruleDoWhileStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getDoWhileStatementParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoWhileStatement_in_ruleStatement1763);
                    this_DoWhileStatement_4=ruleDoWhileStatement();
                    _fsp--;

                     
                            current = this_DoWhileStatement_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1019:5: this_ForeachStatement_5= ruleForeachStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getForeachStatementParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleForeachStatement_in_ruleStatement1790);
                    this_ForeachStatement_5=ruleForeachStatement();
                    _fsp--;

                     
                            current = this_ForeachStatement_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1029:5: this_TypeDefinition_6= ruleTypeDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getTypeDefinitionParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleStatement1817);
                    this_TypeDefinition_6=ruleTypeDefinition();
                    _fsp--;

                     
                            current = this_TypeDefinition_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:5: this_VariableDeclaration_7= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStatement1844);
                    this_VariableDeclaration_7=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_7; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1049:5: this_ReturnStatement_8= ruleReturnStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_8(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement1871);
                    this_ReturnStatement_8=ruleReturnStatement();
                    _fsp--;

                     
                            current = this_ReturnStatement_8; 
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1065:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1066:2: (iv_ruleBlock= ruleBlock EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1067:2: iv_ruleBlock= ruleBlock EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockRule(), currentNode); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock1906);
            iv_ruleBlock=ruleBlock();
            _fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock1916); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1074:1: ruleBlock returns [EObject current=null] : ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1079:6: ( ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1080:1: ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1080:1: ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1080:2: () '{' ( (lv_statements_2_0= ruleStatement ) )* '}'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1080:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1081:5: 
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

            match(input,13,FOLLOW_13_in_ruleBlock1960); 

                    createLeafNode(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1095:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_ID && LA14_0<=RULE_STRING)||LA14_0==13||LA14_0==19||LA14_0==21||LA14_0==25||(LA14_0>=28 && LA14_0<=30)||(LA14_0>=32 && LA14_0<=38)||(LA14_0>=40 && LA14_0<=44)||LA14_0==47||(LA14_0>=56 && LA14_0<=59)||(LA14_0>=74 && LA14_0<=75)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1096:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1096:1: (lv_statements_2_0= ruleStatement )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1097:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock1981);
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
            	    break loop14;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleBlock1992); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1131:1: entryRuleFeatureCallStatement returns [EObject current=null] : iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF ;
    public final EObject entryRuleFeatureCallStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1132:2: (iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1133:2: iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallStatement_in_entryRuleFeatureCallStatement2028);
            iv_ruleFeatureCallStatement=ruleFeatureCallStatement();
            _fsp--;

             current =iv_ruleFeatureCallStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallStatement2038); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1140:1: ruleFeatureCallStatement returns [EObject current=null] : ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( '=' ( (lv_assignedValue_2_0= ruleExpression ) ) )? ';' ) ;
    public final EObject ruleFeatureCallStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_featureCall_0_0 = null;

        EObject lv_assignedValue_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1145:6: ( ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( '=' ( (lv_assignedValue_2_0= ruleExpression ) ) )? ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1146:1: ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( '=' ( (lv_assignedValue_2_0= ruleExpression ) ) )? ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1146:1: ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( '=' ( (lv_assignedValue_2_0= ruleExpression ) ) )? ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1146:2: ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( '=' ( (lv_assignedValue_2_0= ruleExpression ) ) )? ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1146:2: ( (lv_featureCall_0_0= ruleFeatureCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1147:1: (lv_featureCall_0_0= ruleFeatureCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1147:1: (lv_featureCall_0_0= ruleFeatureCall )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1148:3: lv_featureCall_0_0= ruleFeatureCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFeatureCallStatementAccess().getFeatureCallFeatureCallParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFeatureCall_in_ruleFeatureCallStatement2084);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1170:2: ( '=' ( (lv_assignedValue_2_0= ruleExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1170:4: '=' ( (lv_assignedValue_2_0= ruleExpression ) )
                    {
                    match(input,24,FOLLOW_24_in_ruleFeatureCallStatement2095); 

                            createLeafNode(grammarAccess.getFeatureCallStatementAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1174:1: ( (lv_assignedValue_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1175:1: (lv_assignedValue_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1175:1: (lv_assignedValue_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1176:3: lv_assignedValue_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallStatementAccess().getAssignedValueExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCallStatement2116);
                    lv_assignedValue_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallStatementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"assignedValue",
                    	        		lv_assignedValue_2_0, 
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

            match(input,18,FOLLOW_18_in_ruleFeatureCallStatement2128); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1210:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1211:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1212:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement2164);
            iv_ruleIfStatement=ruleIfStatement();
            _fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement2174); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1219:1: ruleIfStatement returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseBody_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1224:6: ( ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1225:1: ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1225:1: ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1225:3: 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )?
            {
            match(input,25,FOLLOW_25_in_ruleIfStatement2209); 

                    createLeafNode(grammarAccess.getIfStatementAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1229:1: ( (lv_cases_1_0= ruleIfCase ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1230:1: (lv_cases_1_0= ruleIfCase )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1230:1: (lv_cases_1_0= ruleIfCase )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1231:3: lv_cases_1_0= ruleIfCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getCasesIfCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleIfCase_in_ruleIfStatement2230);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1253:2: ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1253:4: 'elseif' ( (lv_cases_3_0= ruleIfCase ) )
            	    {
            	    match(input,26,FOLLOW_26_in_ruleIfStatement2241); 

            	            createLeafNode(grammarAccess.getIfStatementAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1257:1: ( (lv_cases_3_0= ruleIfCase ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1258:1: (lv_cases_3_0= ruleIfCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1258:1: (lv_cases_3_0= ruleIfCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1259:3: lv_cases_3_0= ruleIfCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getCasesIfCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleIfCase_in_ruleIfStatement2262);
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
            	    break loop16;
                }
            } while (true);

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1281:4: ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1281:6: 'else' ( (lv_elseBody_5_0= ruleBlock ) )
                    {
                    match(input,27,FOLLOW_27_in_ruleIfStatement2275); 

                            createLeafNode(grammarAccess.getIfStatementAccess().getElseKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1285:1: ( (lv_elseBody_5_0= ruleBlock ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1286:1: (lv_elseBody_5_0= ruleBlock )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1286:1: (lv_elseBody_5_0= ruleBlock )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1287:3: lv_elseBody_5_0= ruleBlock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getElseBodyBlockParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement2296);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1317:1: entryRuleIfCase returns [EObject current=null] : iv_ruleIfCase= ruleIfCase EOF ;
    public final EObject entryRuleIfCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1318:2: (iv_ruleIfCase= ruleIfCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1319:2: iv_ruleIfCase= ruleIfCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfCase_in_entryRuleIfCase2334);
            iv_ruleIfCase=ruleIfCase();
            _fsp--;

             current =iv_ruleIfCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfCase2344); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1326:1: ruleIfCase returns [EObject current=null] : ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) ) ;
    public final EObject ruleIfCase() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_body_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1331:6: ( ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:1: ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:1: ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:2: ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:2: ( (lv_condition_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1333:1: (lv_condition_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1333:1: (lv_condition_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1334:3: lv_condition_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfCaseAccess().getConditionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfCase2390);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1356:2: ( (lv_body_1_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1357:1: (lv_body_1_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1357:1: (lv_body_1_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1358:3: lv_body_1_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfCaseAccess().getBodyBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfCase2411);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1388:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1389:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1390:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhileStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement2447);
            iv_ruleWhileStatement=ruleWhileStatement();
            _fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement2457); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1397:1: ruleWhileStatement returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1402:6: ( ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1403:1: ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1403:1: ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1403:3: 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) )
            {
            match(input,28,FOLLOW_28_in_ruleWhileStatement2492); 

                    createLeafNode(grammarAccess.getWhileStatementAccess().getWhileKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1407:1: ( (lv_predicate_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1408:1: (lv_predicate_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1408:1: (lv_predicate_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1409:3: lv_predicate_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileStatement2513);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1431:2: ( (lv_body_2_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1432:1: (lv_body_2_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1432:1: (lv_body_2_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1433:3: lv_body_2_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement2534);
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


    // $ANTLR start entryRuleDoWhileStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1463:1: entryRuleDoWhileStatement returns [EObject current=null] : iv_ruleDoWhileStatement= ruleDoWhileStatement EOF ;
    public final EObject entryRuleDoWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoWhileStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1464:2: (iv_ruleDoWhileStatement= ruleDoWhileStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1465:2: iv_ruleDoWhileStatement= ruleDoWhileStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoWhileStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoWhileStatement_in_entryRuleDoWhileStatement2570);
            iv_ruleDoWhileStatement=ruleDoWhileStatement();
            _fsp--;

             current =iv_ruleDoWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoWhileStatement2580); 

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
    // $ANTLR end entryRuleDoWhileStatement


    // $ANTLR start ruleDoWhileStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1472:1: ruleDoWhileStatement returns [EObject current=null] : ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleDoWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_body_1_0 = null;

        EObject lv_predicate_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1477:6: ( ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1478:1: ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1478:1: ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1478:3: 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';'
            {
            match(input,29,FOLLOW_29_in_ruleDoWhileStatement2615); 

                    createLeafNode(grammarAccess.getDoWhileStatementAccess().getDoKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1482:1: ( (lv_body_1_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1483:1: (lv_body_1_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1483:1: (lv_body_1_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1484:3: lv_body_1_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoWhileStatementAccess().getBodyBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleDoWhileStatement2636);
            lv_body_1_0=ruleBlock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoWhileStatementRule().getType().getClassifier());
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

            match(input,28,FOLLOW_28_in_ruleDoWhileStatement2646); 

                    createLeafNode(grammarAccess.getDoWhileStatementAccess().getWhileKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1510:1: ( (lv_predicate_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1511:1: (lv_predicate_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1511:1: (lv_predicate_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1512:3: lv_predicate_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoWhileStatementAccess().getPredicateExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleDoWhileStatement2667);
            lv_predicate_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoWhileStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"predicate",
            	        		lv_predicate_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleDoWhileStatement2677); 

                    createLeafNode(grammarAccess.getDoWhileStatementAccess().getSemicolonKeyword_4(), null); 
                

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
    // $ANTLR end ruleDoWhileStatement


    // $ANTLR start entryRuleForeachStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1546:1: entryRuleForeachStatement returns [EObject current=null] : iv_ruleForeachStatement= ruleForeachStatement EOF ;
    public final EObject entryRuleForeachStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeachStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1547:2: (iv_ruleForeachStatement= ruleForeachStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1548:2: iv_ruleForeachStatement= ruleForeachStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForeachStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleForeachStatement_in_entryRuleForeachStatement2713);
            iv_ruleForeachStatement=ruleForeachStatement();
            _fsp--;

             current =iv_ruleForeachStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForeachStatement2723); 

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
    // $ANTLR end entryRuleForeachStatement


    // $ANTLR start ruleForeachStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1555:1: ruleForeachStatement returns [EObject current=null] : ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) ) ;
    public final EObject ruleForeachStatement() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_elementName_1_0 = null;

        EObject lv_collectionExpression_3_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1560:6: ( ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1561:1: ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1561:1: ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1561:3: 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) )
            {
            match(input,30,FOLLOW_30_in_ruleForeachStatement2758); 

                    createLeafNode(grammarAccess.getForeachStatementAccess().getForeachKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1565:1: ( (lv_elementName_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1566:1: (lv_elementName_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1566:1: (lv_elementName_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1567:3: lv_elementName_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getForeachStatementAccess().getElementNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleForeachStatement2779);
            lv_elementName_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getForeachStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"elementName",
            	        		lv_elementName_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,31,FOLLOW_31_in_ruleForeachStatement2789); 

                    createLeafNode(grammarAccess.getForeachStatementAccess().getInKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1593:1: ( (lv_collectionExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1594:1: (lv_collectionExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1594:1: (lv_collectionExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1595:3: lv_collectionExpression_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getForeachStatementAccess().getCollectionExpressionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleForeachStatement2810);
            lv_collectionExpression_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getForeachStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"collectionExpression",
            	        		lv_collectionExpression_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1617:2: ( (lv_body_4_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1618:1: (lv_body_4_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1618:1: (lv_body_4_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1619:3: lv_body_4_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getForeachStatementAccess().getBodyBlockParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleForeachStatement2831);
            lv_body_4_0=ruleBlock();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getForeachStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"body",
            	        		lv_body_4_0, 
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
    // $ANTLR end ruleForeachStatement


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1649:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1650:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1651:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2867);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2877); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1658:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) ) ( (lv_items_5_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) ) )* ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_modifier_0_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_items_5_0 = null;

        EObject lv_items_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1663:6: ( ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) ) ( (lv_items_5_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) ) )* ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1664:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) ) ( (lv_items_5_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) ) )* ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1664:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) ) ( (lv_items_5_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) ) )* ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1664:2: ( (lv_modifier_0_0= ruleVariableModifier ) )? ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) ) ( (lv_items_5_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) ) )* ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1664:2: ( (lv_modifier_0_0= ruleVariableModifier ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19||(LA18_0>=33 && LA18_0<=34)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1665:1: (lv_modifier_0_0= ruleVariableModifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1665:1: (lv_modifier_0_0= ruleVariableModifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1666:3: lv_modifier_0_0= ruleVariableModifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getModifierVariableModifierParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableModifier_in_ruleVariableDeclaration2923);
                    lv_modifier_0_0=ruleVariableModifier();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"modifier",
                    	        		lv_modifier_0_0, 
                    	        		"VariableModifier", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1688:3: ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 37:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt19=1;
                }
                break;
            case 47:
                {
                alt19=2;
                }
                break;
            case 32:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1688:3: ( ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) ) | ( (lv_type_2_0= ruleUnitTypeSpecifier ) ) | ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) ) )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1688:4: ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1688:4: ( (lv_type_1_0= rulePrimitiveTypeSpecifier ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1689:1: (lv_type_1_0= rulePrimitiveTypeSpecifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1689:1: (lv_type_1_0= rulePrimitiveTypeSpecifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1690:3: lv_type_1_0= rulePrimitiveTypeSpecifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypePrimitiveTypeSpecifierParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleVariableDeclaration2946);
                    lv_type_1_0=rulePrimitiveTypeSpecifier();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_1_0, 
                    	        		"PrimitiveTypeSpecifier", 
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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1713:6: ( (lv_type_2_0= ruleUnitTypeSpecifier ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1713:6: ( (lv_type_2_0= ruleUnitTypeSpecifier ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1714:1: (lv_type_2_0= ruleUnitTypeSpecifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1714:1: (lv_type_2_0= ruleUnitTypeSpecifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1715:3: lv_type_2_0= ruleUnitTypeSpecifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeUnitTypeSpecifierParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitTypeSpecifier_in_ruleVariableDeclaration2973);
                    lv_type_2_0=ruleUnitTypeSpecifier();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_2_0, 
                    	        		"UnitTypeSpecifier", 
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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1738:6: ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1738:6: ( 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1738:8: 'var' ( (lv_type_4_0= ruleNamedTypeSpecifier ) )
                    {
                    match(input,32,FOLLOW_32_in_ruleVariableDeclaration2990); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getVarKeyword_1_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1742:1: ( (lv_type_4_0= ruleNamedTypeSpecifier ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1743:1: (lv_type_4_0= ruleNamedTypeSpecifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1743:1: (lv_type_4_0= ruleNamedTypeSpecifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1744:3: lv_type_4_0= ruleNamedTypeSpecifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeNamedTypeSpecifierParserRuleCall_1_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleVariableDeclaration3011);
                    lv_type_4_0=ruleNamedTypeSpecifier();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_4_0, 
                    	        		"NamedTypeSpecifier", 
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1766:4: ( (lv_items_5_0= ruleVariableDeclarationItem ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1767:1: (lv_items_5_0= ruleVariableDeclarationItem )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1767:1: (lv_items_5_0= ruleVariableDeclarationItem )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1768:3: lv_items_5_0= ruleVariableDeclarationItem
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getItemsVariableDeclarationItemParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration3034);
            lv_items_5_0=ruleVariableDeclarationItem();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"items",
            	        		lv_items_5_0, 
            	        		"VariableDeclarationItem", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1790:2: ( ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==16) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1790:4: ',' ( (lv_items_7_0= ruleVariableDeclarationItem ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleVariableDeclaration3045); 

            	            createLeafNode(grammarAccess.getVariableDeclarationAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1794:1: ( (lv_items_7_0= ruleVariableDeclarationItem ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1795:1: (lv_items_7_0= ruleVariableDeclarationItem )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1795:1: (lv_items_7_0= ruleVariableDeclarationItem )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1796:3: lv_items_7_0= ruleVariableDeclarationItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getItemsVariableDeclarationItemParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration3066);
            	    lv_items_7_0=ruleVariableDeclarationItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_7_0, 
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
            	    break loop20;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleVariableDeclaration3078); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_4(), null); 
                

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


    // $ANTLR start entryRuleVariableModifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1830:1: entryRuleVariableModifier returns [EObject current=null] : iv_ruleVariableModifier= ruleVariableModifier EOF ;
    public final EObject entryRuleVariableModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableModifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1831:2: (iv_ruleVariableModifier= ruleVariableModifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1832:2: iv_ruleVariableModifier= ruleVariableModifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableModifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableModifier_in_entryRuleVariableModifier3114);
            iv_ruleVariableModifier=ruleVariableModifier();
            _fsp--;

             current =iv_ruleVariableModifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableModifier3124); 

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
    // $ANTLR end entryRuleVariableModifier


    // $ANTLR start ruleVariableModifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1839:1: ruleVariableModifier returns [EObject current=null] : ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) ) ;
    public final EObject ruleVariableModifier() throws RecognitionException {
        EObject current = null;

        Token lv_Auto_0_0=null;
        Token lv_Constant_1_0=null;
        Token lv_Static_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1844:6: ( ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1845:1: ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1845:1: ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt21=1;
                }
                break;
            case 34:
                {
                alt21=2;
                }
                break;
            case 19:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1845:1: ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1845:2: ( (lv_Auto_0_0= 'auto' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1845:2: ( (lv_Auto_0_0= 'auto' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1846:1: (lv_Auto_0_0= 'auto' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1846:1: (lv_Auto_0_0= 'auto' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1847:3: lv_Auto_0_0= 'auto'
                    {
                    lv_Auto_0_0=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleVariableModifier3167); 

                            createLeafNode(grammarAccess.getVariableModifierAccess().getAutoAutoKeyword_0_0(), "Auto"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableModifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "Auto", lv_Auto_0_0, "auto", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1867:6: ( (lv_Constant_1_0= 'const' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1867:6: ( (lv_Constant_1_0= 'const' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1868:1: (lv_Constant_1_0= 'const' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1868:1: (lv_Constant_1_0= 'const' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1869:3: lv_Constant_1_0= 'const'
                    {
                    lv_Constant_1_0=(Token)input.LT(1);
                    match(input,34,FOLLOW_34_in_ruleVariableModifier3204); 

                            createLeafNode(grammarAccess.getVariableModifierAccess().getConstantConstKeyword_1_0(), "Constant"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableModifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "Constant", lv_Constant_1_0, "const", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1889:6: ( (lv_Static_2_0= 'static' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1889:6: ( (lv_Static_2_0= 'static' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1890:1: (lv_Static_2_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1890:1: (lv_Static_2_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1891:3: lv_Static_2_0= 'static'
                    {
                    lv_Static_2_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleVariableModifier3241); 

                            createLeafNode(grammarAccess.getVariableModifierAccess().getStaticStaticKeyword_2_0(), "Static"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableModifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "Static", lv_Static_2_0, "static", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // $ANTLR end ruleVariableModifier


    // $ANTLR start entryRuleVariableDeclarationItem
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1918:1: entryRuleVariableDeclarationItem returns [EObject current=null] : iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF ;
    public final EObject entryRuleVariableDeclarationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationItem = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1919:2: (iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1920:2: iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationItemRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclarationItem_in_entryRuleVariableDeclarationItem3290);
            iv_ruleVariableDeclarationItem=ruleVariableDeclarationItem();
            _fsp--;

             current =iv_ruleVariableDeclarationItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationItem3300); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1927:1: ruleVariableDeclarationItem returns [EObject current=null] : ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationItem() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_initialValue_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1932:6: ( ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1933:1: ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1933:1: ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1933:2: ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1933:2: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1934:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1934:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1935:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationItemAccess().getNameKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleVariableDeclarationItem3346);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationItemRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1957:2: ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1957:4: '=' ( (lv_initialValue_2_0= ruleExpression ) )
                    {
                    match(input,24,FOLLOW_24_in_ruleVariableDeclarationItem3357); 

                            createLeafNode(grammarAccess.getVariableDeclarationItemAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1961:1: ( (lv_initialValue_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1962:1: (lv_initialValue_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1962:1: (lv_initialValue_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1963:3: lv_initialValue_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationItemAccess().getInitialValueExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclarationItem3378);
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


    // $ANTLR start entryRuleTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1993:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1994:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1995:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition3416);
            iv_ruleTypeDefinition=ruleTypeDefinition();
            _fsp--;

             current =iv_ruleTypeDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition3426); 

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
    // $ANTLR end entryRuleTypeDefinition


    // $ANTLR start ruleTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2002:1: ruleTypeDefinition returns [EObject current=null] : ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2007:6: ( ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2008:1: ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2008:1: ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2008:3: 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';'
            {
            match(input,35,FOLLOW_35_in_ruleTypeDefinition3461); 

                    createLeafNode(grammarAccess.getTypeDefinitionAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2012:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2013:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2013:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2014:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleTypeDefinition3482);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,24,FOLLOW_24_in_ruleTypeDefinition3492); 

                    createLeafNode(grammarAccess.getTypeDefinitionAccess().getEqualsSignKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2040:1: ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2041:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2041:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2042:3: lv_type_3_0= rulePrimitiveTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeDefinitionAccess().getTypePrimitiveTypeSpecifierParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeDefinition3513);
            lv_type_3_0=rulePrimitiveTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeDefinitionRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleTypeDefinition3523); 

                    createLeafNode(grammarAccess.getTypeDefinitionAccess().getSemicolonKeyword_4(), null); 
                

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
    // $ANTLR end ruleTypeDefinition


    // $ANTLR start entryRuleReturnStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2076:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2077:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2078:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReturnStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement3559);
            iv_ruleReturnStatement=ruleReturnStatement();
            _fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement3569); 

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
    // $ANTLR end entryRuleReturnStatement


    // $ANTLR start ruleReturnStatement
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2085:1: ruleReturnStatement returns [EObject current=null] : ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2090:6: ( ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2091:1: ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2091:1: ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2091:3: 'return' ( (lv_value_1_0= ruleExpression ) ) ';'
            {
            match(input,36,FOLLOW_36_in_ruleReturnStatement3604); 

                    createLeafNode(grammarAccess.getReturnStatementAccess().getReturnKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2095:1: ( (lv_value_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2096:1: (lv_value_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2096:1: (lv_value_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2097:3: lv_value_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReturnStatementAccess().getValueExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement3625);
            lv_value_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReturnStatementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleReturnStatement3635); 

                    createLeafNode(grammarAccess.getReturnStatementAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleReturnStatement


    // $ANTLR start entryRuleTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2131:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2132:2: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2133:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeSpecifier_in_entryRuleTypeSpecifier3671);
            iv_ruleTypeSpecifier=ruleTypeSpecifier();
            _fsp--;

             current =iv_ruleTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeSpecifier3681); 

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
    // $ANTLR end entryRuleTypeSpecifier


    // $ANTLR start ruleTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2140:1: ruleTypeSpecifier returns [EObject current=null] : (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeSpecifier_0 = null;

        EObject this_UnitTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2145:6: ( (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2146:1: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2146:1: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID||LA23_0==37||(LA23_0>=40 && LA23_0<=44)||(LA23_0>=56 && LA23_0<=57)) ) {
                alt23=1;
            }
            else if ( (LA23_0==47) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2146:1: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2147:5: this_DataTypeSpecifier_0= ruleDataTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeSpecifierAccess().getDataTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleTypeSpecifier3728);
                    this_DataTypeSpecifier_0=ruleDataTypeSpecifier();
                    _fsp--;

                     
                            current = this_DataTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2157:5: this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeSpecifierAccess().getUnitTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnitTypeSpecifier_in_ruleTypeSpecifier3755);
                    this_UnitTypeSpecifier_1=ruleUnitTypeSpecifier();
                    _fsp--;

                     
                            current = this_UnitTypeSpecifier_1; 
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
    // $ANTLR end ruleTypeSpecifier


    // $ANTLR start entryRuleDataTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2173:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2174:2: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2175:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier3790);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();
            _fsp--;

             current =iv_ruleDataTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeSpecifier3800); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2182:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeSpecifier_0 = null;

        EObject this_NamedTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2187:6: ( (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2188:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2188:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37||(LA24_0>=40 && LA24_0<=44)) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_ID||(LA24_0>=56 && LA24_0<=57)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2188:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2189:5: this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPrimitiveTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier3847);
                    this_PrimitiveTypeSpecifier_0=rulePrimitiveTypeSpecifier();
                    _fsp--;

                     
                            current = this_PrimitiveTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2199:5: this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getNamedTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier3874);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2215:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2216:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2217:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier3909);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();
            _fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier3919); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2224:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2229:6: ( (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2230:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2230:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 37:
            case 40:
            case 41:
            case 42:
                {
                alt25=1;
                }
                break;
            case 43:
                {
                alt25=2;
                }
                break;
            case 44:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2230:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2231:5: this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericalTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier3966);
                    this_NumericalTypeSpecifier_0=ruleNumericalTypeSpecifier();
                    _fsp--;

                     
                            current = this_NumericalTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2241:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier3993);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();
                    _fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2251:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier4020);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2267:1: entryRuleNumericalTypeSpecifier returns [EObject current=null] : iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF ;
    public final EObject entryRuleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2268:2: (iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2269:2: iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier4055);
            iv_ruleNumericalTypeSpecifier=ruleNumericalTypeSpecifier();
            _fsp--;

             current =iv_ruleNumericalTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier4065); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2276:1: ruleNumericalTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) ;
    public final EObject ruleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;

        EObject this_ComplexTypeSpecifier_2 = null;

        EObject this_GaussianTypeSpecifier_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2281:6: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2282:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2282:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt26=1;
                }
                break;
            case 40:
                {
                alt26=2;
                }
                break;
            case 41:
                {
                alt26=3;
                }
                break;
            case 42:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2282:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2283:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier4112);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();
                    _fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2293:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier4139);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();
                    _fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2303:5: this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getComplexTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericalTypeSpecifier4166);
                    this_ComplexTypeSpecifier_2=ruleComplexTypeSpecifier();
                    _fsp--;

                     
                            current = this_ComplexTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2313:5: this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getGaussianTypeSpecifierParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericalTypeSpecifier4193);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2329:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2330:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2331:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier4228);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();
            _fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier4238); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2338:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2343:6: ( ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2344:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2344:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2344:2: () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2344:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2345:5: 
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

            match(input,37,FOLLOW_37_in_ruleRealTypeSpecifier4282); 

                    createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2359:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==21) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2359:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleRealTypeSpecifier4293); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2363:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2364:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2364:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2365:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier4314);
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

                    match(input,22,FOLLOW_22_in_ruleRealTypeSpecifier4324); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2391:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2391:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleRealTypeSpecifier4337); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2395:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2396:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2396:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2397:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4358);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2419:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==16) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2419:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleRealTypeSpecifier4369); 

                    	            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2423:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2424:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2424:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2425:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4390);
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
                    	    break loop28;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleRealTypeSpecifier4402); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2459:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2460:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2461:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier4440);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();
            _fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier4450); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2468:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2473:6: ( ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2474:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2474:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2474:2: () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2474:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2475:5: 
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

            match(input,40,FOLLOW_40_in_ruleIntegerTypeSpecifier4494); 

                    createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2489:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==21) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2489:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleIntegerTypeSpecifier4505); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2493:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2494:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2494:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2495:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier4526);
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

                    match(input,22,FOLLOW_22_in_ruleIntegerTypeSpecifier4536); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2521:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2521:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleIntegerTypeSpecifier4549); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2525:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2526:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2526:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2527:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4570);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2549:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==16) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2549:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleIntegerTypeSpecifier4581); 

                    	            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2553:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2554:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2554:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2555:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4602);
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
                    	    break loop31;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleIntegerTypeSpecifier4614); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2589:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2590:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2591:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier4652);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();
            _fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier4662); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2598:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2603:6: ( ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2604:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2604:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2604:2: () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2604:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2605:5: 
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

            match(input,41,FOLLOW_41_in_ruleComplexTypeSpecifier4706); 

                    createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2619:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==21) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2619:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleComplexTypeSpecifier4717); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2623:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2624:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2624:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2625:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier4738);
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

                    match(input,22,FOLLOW_22_in_ruleComplexTypeSpecifier4748); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2651:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2651:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleComplexTypeSpecifier4761); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2655:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2656:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2656:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2657:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4782);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2679:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==16) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2679:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleComplexTypeSpecifier4793); 

                    	            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2683:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2684:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2684:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2685:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4814);
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
                    	    break loop34;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleComplexTypeSpecifier4826); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2719:1: entryRuleGaussianTypeSpecifier returns [EObject current=null] : iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF ;
    public final EObject entryRuleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGaussianTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2720:2: (iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2721:2: iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier4864);
            iv_ruleGaussianTypeSpecifier=ruleGaussianTypeSpecifier();
            _fsp--;

             current =iv_ruleGaussianTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier4874); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2728:1: ruleGaussianTypeSpecifier returns [EObject current=null] : ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2733:6: ( ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2734:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2734:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2734:2: () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2734:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2735:5: 
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

            match(input,42,FOLLOW_42_in_ruleGaussianTypeSpecifier4918); 

                    createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2749:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==21) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2749:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleGaussianTypeSpecifier4929); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2753:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2754:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2754:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2755:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier4950);
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

                    match(input,22,FOLLOW_22_in_ruleGaussianTypeSpecifier4960); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2781:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2781:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleGaussianTypeSpecifier4973); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2785:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2786:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2786:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2787:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier4994);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2809:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==16) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2809:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleGaussianTypeSpecifier5005); 

                    	            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2813:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2814:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2814:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2815:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier5026);
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
                    	    break loop37;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleGaussianTypeSpecifier5038); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2849:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2850:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2851:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier5076);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();
            _fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier5086); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2858:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2863:6: ( ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2864:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2864:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2864:2: () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2864:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2865:5: 
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

            match(input,43,FOLLOW_43_in_ruleBooleanTypeSpecifier5130); 

                    createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getBoolKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2879:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==38) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2879:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleBooleanTypeSpecifier5141); 

                            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2883:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2884:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2884:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2885:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5162);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2907:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==16) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2907:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleBooleanTypeSpecifier5173); 

                    	            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2911:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2912:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2912:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2913:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5194);
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
                    	    break loop39;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleBooleanTypeSpecifier5206); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2947:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2948:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2949:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier5244);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();
            _fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier5254); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2956:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2961:6: ( ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2962:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2962:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2962:2: () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2962:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2963:5: 
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

            match(input,44,FOLLOW_44_in_ruleStringTypeSpecifier5298); 

                    createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getStringKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2977:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==38) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2977:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleStringTypeSpecifier5309); 

                            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2981:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2982:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2982:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2983:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5330);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3005:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==16) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3005:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleStringTypeSpecifier5341); 

                    	            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3009:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3010:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3010:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3011:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5362);
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
                    	    break loop41;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleStringTypeSpecifier5374); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3045:1: entryRuleNamedTypeSpecifier returns [EObject current=null] : iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF ;
    public final EObject entryRuleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3046:2: (iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3047:2: iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier5412);
            iv_ruleNamedTypeSpecifier=ruleNamedTypeSpecifier();
            _fsp--;

             current =iv_ruleNamedTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTypeSpecifier5422); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3054:1: ruleNamedTypeSpecifier returns [EObject current=null] : ( ( (lv_typeReference_0_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_0_0 = null;

        EObject lv_dimensions_2_0 = null;

        EObject lv_dimensions_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3059:6: ( ( ( (lv_typeReference_0_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3060:1: ( ( (lv_typeReference_0_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3060:1: ( ( (lv_typeReference_0_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3060:2: ( (lv_typeReference_0_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3060:2: ( (lv_typeReference_0_0= ruleSymbolReference ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3061:1: (lv_typeReference_0_0= ruleSymbolReference )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3061:1: (lv_typeReference_0_0= ruleSymbolReference )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3062:3: lv_typeReference_0_0= ruleSymbolReference
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getTypeReferenceSymbolReferenceParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSymbolReference_in_ruleNamedTypeSpecifier5468);
            lv_typeReference_0_0=ruleSymbolReference();
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
            	        		"SymbolReference", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3084:2: ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3084:4: '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,38,FOLLOW_38_in_ruleNamedTypeSpecifier5479); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3088:1: ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3089:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3089:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3090:3: lv_dimensions_2_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5500);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3112:2: ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==16) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3112:4: ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleNamedTypeSpecifier5511); 

                    	            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getCommaKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3116:1: ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3117:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3117:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3118:3: lv_dimensions_4_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5532);
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
                    	    break loop43;
                        }
                    } while (true);

                    match(input,39,FOLLOW_39_in_ruleNamedTypeSpecifier5544); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3152:1: entryRuleArrayDimensionSpecification returns [EObject current=null] : iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF ;
    public final EObject entryRuleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayDimensionSpecification = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3153:2: (iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3154:2: iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayDimensionSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification5582);
            iv_ruleArrayDimensionSpecification=ruleArrayDimensionSpecification();
            _fsp--;

             current =iv_ruleArrayDimensionSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayDimensionSpecification5592); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3161:1: ruleArrayDimensionSpecification returns [EObject current=null] : ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) ) ;
    public final EObject ruleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_unspecified_0_0=null;
        EObject lv_size_1_0 = null;

        EObject lv_endIndex_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3166:6: ( ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3167:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3167:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==45) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)||LA46_0==21||LA46_0==25||LA46_0==38||LA46_0==47||LA46_0==52||LA46_0==54||(LA46_0>=56 && LA46_0<=59)||(LA46_0>=74 && LA46_0<=75)) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3167:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3167:2: ( (lv_unspecified_0_0= '?' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3167:2: ( (lv_unspecified_0_0= '?' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3168:1: (lv_unspecified_0_0= '?' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3168:1: (lv_unspecified_0_0= '?' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3169:3: lv_unspecified_0_0= '?'
                    {
                    lv_unspecified_0_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleArrayDimensionSpecification5635); 

                            createLeafNode(grammarAccess.getArrayDimensionSpecificationAccess().getUnspecifiedQuestionMarkKeyword_0_0(), "unspecified"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArrayDimensionSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "unspecified", true, "?", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3189:6: ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3189:6: ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3189:7: ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3189:7: ( (lv_size_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3190:1: (lv_size_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3190:1: (lv_size_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3191:3: lv_size_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getSizeExpressionParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5676);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3213:2: ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==46) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3213:3: () '..' ( (lv_endIndex_4_0= ruleExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3213:3: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3214:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getArrayDimensionSpecificationAccess().getArrayDimensionSpecificationBeginIndexAction_1_1_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "beginIndex", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getArrayDimensionSpecificationBeginIndexAction_1_1_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            match(input,46,FOLLOW_46_in_ruleArrayDimensionSpecification5696); 

                                    createLeafNode(grammarAccess.getArrayDimensionSpecificationAccess().getFullStopFullStopKeyword_1_1_1(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3233:1: ( (lv_endIndex_4_0= ruleExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3234:1: (lv_endIndex_4_0= ruleExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3234:1: (lv_endIndex_4_0= ruleExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3235:3: lv_endIndex_4_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getEndIndexExpressionParserRuleCall_1_1_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5717);
                            lv_endIndex_4_0=ruleExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getArrayDimensionSpecificationRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"endIndex",
                            	        		lv_endIndex_4_0, 
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
    // $ANTLR end ruleArrayDimensionSpecification


    // $ANTLR start entryRuleUnitTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3265:1: entryRuleUnitTypeSpecifier returns [EObject current=null] : iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF ;
    public final EObject entryRuleUnitTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3266:2: (iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3267:2: iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitTypeSpecifier_in_entryRuleUnitTypeSpecifier5756);
            iv_ruleUnitTypeSpecifier=ruleUnitTypeSpecifier();
            _fsp--;

             current =iv_ruleUnitTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitTypeSpecifier5766); 

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
    // $ANTLR end entryRuleUnitTypeSpecifier


    // $ANTLR start ruleUnitTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3274:1: ruleUnitTypeSpecifier returns [EObject current=null] : ( () 'unit' ) ;
    public final EObject ruleUnitTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3279:6: ( ( () 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3280:1: ( () 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3280:1: ( () 'unit' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3280:2: () 'unit'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3280:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3281:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnitTypeSpecifierAccess().getUnitTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnitTypeSpecifierAccess().getUnitTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,47,FOLLOW_47_in_ruleUnitTypeSpecifier5810); 

                    createLeafNode(grammarAccess.getUnitTypeSpecifierAccess().getUnitKeyword_1(), null); 
                

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
    // $ANTLR end ruleUnitTypeSpecifier


    // $ANTLR start entryRuleExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3303:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3304:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3305:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression5846);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression5856); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3312:1: ruleExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        EObject this_RangeExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3317:6: ( (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3318:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3318:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==25) ) {
                alt47=1;
            }
            else if ( ((LA47_0>=RULE_ID && LA47_0<=RULE_STRING)||LA47_0==21||LA47_0==38||LA47_0==47||LA47_0==52||LA47_0==54||(LA47_0>=56 && LA47_0<=59)||(LA47_0>=74 && LA47_0<=75)) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3318:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3319:5: this_ConditionalExpression_0= ruleConditionalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression5903);
                    this_ConditionalExpression_0=ruleConditionalExpression();
                    _fsp--;

                     
                            current = this_ConditionalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3329:5: this_RangeExpression_1= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression5930);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3345:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3346:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3347:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5965);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression5975); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3354:1: ruleConditionalExpression returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3359:6: ( ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3360:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3360:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3360:3: 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,25,FOLLOW_25_in_ruleConditionalExpression6010); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3364:1: ( (lv_cases_1_0= ruleConditionalExpressionCase ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3365:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3365:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3366:3: lv_cases_1_0= ruleConditionalExpressionCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression6031);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3388:2: ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==26) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3388:4: 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    {
            	    match(input,26,FOLLOW_26_in_ruleConditionalExpression6042); 

            	            createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3392:1: ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3393:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3393:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3394:3: lv_cases_3_0= ruleConditionalExpressionCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression6063);
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
            	    break loop48;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_ruleConditionalExpression6075); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3420:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3421:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3421:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3422:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getElseExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpression6096);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3452:1: entryRuleConditionalExpressionCase returns [EObject current=null] : iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF ;
    public final EObject entryRuleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressionCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3453:2: (iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3454:2: iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase6132);
            iv_ruleConditionalExpressionCase=ruleConditionalExpressionCase();
            _fsp--;

             current =iv_ruleConditionalExpressionCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpressionCase6142); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3461:1: ruleConditionalExpressionCase returns [EObject current=null] : ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject lv_conditionExpression_0_0 = null;

        EObject lv_thenExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3466:6: ( ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3467:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3467:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3467:2: ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3467:2: ( (lv_conditionExpression_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3468:1: (lv_conditionExpression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3468:1: (lv_conditionExpression_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3469:3: lv_conditionExpression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getConditionExpressionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6188);
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

            match(input,48,FOLLOW_48_in_ruleConditionalExpressionCase6198); 

                    createLeafNode(grammarAccess.getConditionalExpressionCaseAccess().getThenKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3495:1: ( (lv_thenExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3496:1: (lv_thenExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3496:1: (lv_thenExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3497:3: lv_thenExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getThenExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6219);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3527:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3528:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3529:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression6255);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression6265); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3536:1: ruleRangeExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_end_3_0 = null;

        EObject lv_end_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3541:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3542:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3542:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3543:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6312);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3551:1: ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==49) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3551:2: () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3551:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3552:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRangeExpressionAccess().getRangeExpressionBeginAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "begin", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRangeExpressionAccess().getRangeExpressionBeginAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,49,FOLLOW_49_in_ruleRangeExpression6331); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3571:1: ( (lv_end_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3572:1: (lv_end_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3572:1: (lv_end_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3573:3: lv_end_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getEndLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6352);
                    lv_end_3_0=ruleLogicalOrExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"end",
                    	        		lv_end_3_0, 
                    	        		"LogicalOrExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3595:2: ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==49) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3595:3: () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3595:3: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3596:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getRangeExpressionAccess().getRangeExpressionIncrementAction_1_3_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "increment", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getRangeExpressionAccess().getRangeExpressionIncrementAction_1_3_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            match(input,49,FOLLOW_49_in_ruleRangeExpression6372); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_1(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3615:1: ( (lv_end_6_0= ruleLogicalOrExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3616:1: (lv_end_6_0= ruleLogicalOrExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3616:1: (lv_end_6_0= ruleLogicalOrExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3617:3: lv_end_6_0= ruleLogicalOrExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getEndLogicalOrExpressionParserRuleCall_1_3_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6393);
                            lv_end_6_0=ruleLogicalOrExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"end",
                            	        		lv_end_6_0, 
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3647:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3648:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3649:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression6433);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression6443); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3656:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3661:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3662:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3662:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3663:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6490);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3671:1: ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==50) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3671:2: () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3671:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3672:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3687:2: ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==50) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3687:4: 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,50,FOLLOW_50_in_ruleLogicalOrExpression6510); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3691:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3692:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3692:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3693:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6531);
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
                    	    if ( cnt51 >= 1 ) break loop51;
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3723:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3724:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3725:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6571);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression6581); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3732:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3737:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3738:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3738:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3739:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6628);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3747:1: ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==51) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3747:2: () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3747:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3748:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3763:2: ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==51) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3763:4: 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    {
                    	    match(input,51,FOLLOW_51_in_ruleLogicalAndExpression6648); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3767:1: ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3768:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3768:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3769:3: lv_operands_3_0= ruleLogicalNotExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsLogicalNotExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6669);
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
                    	    if ( cnt53 >= 1 ) break loop53;
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3799:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3800:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3801:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6709);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression6719); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3808:1: ruleLogicalNotExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3813:6: ( (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3814:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3814:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_STRING)||LA55_0==21||LA55_0==38||LA55_0==47||LA55_0==54||(LA55_0>=56 && LA55_0<=59)||(LA55_0>=74 && LA55_0<=75)) ) {
                alt55=1;
            }
            else if ( (LA55_0==52) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3814:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3815:5: this_RelationalExpression_0= ruleRelationalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6766);
                    this_RelationalExpression_0=ruleRelationalExpression();
                    _fsp--;

                     
                            current = this_RelationalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3824:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3824:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3824:7: () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3824:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3825:5: 
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

                    match(input,52,FOLLOW_52_in_ruleLogicalNotExpression6791); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getNotKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3839:1: ( (lv_operand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3840:1: (lv_operand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3840:1: (lv_operand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3841:3: lv_operand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6812);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3871:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3872:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3873:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6849);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression6859); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3880:1: ruleRelationalExpression returns [EObject current=null] : (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_typeTest_2_0=null;
        EObject this_AddSubtractExpression_0 = null;

        EObject lv_type_3_0 = null;

        Enumerator lv_operator_4_0 = null;

        EObject lv_rightOperand_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3885:6: ( (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3886:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3886:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3887:5: this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression6906);
            this_AddSubtractExpression_0=ruleAddSubtractExpression();
            _fsp--;

             
                    current = this_AddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3895:1: ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==53||(LA57_0>=64 && LA57_0<=69)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3895:2: () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3895:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3896:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3911:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==53) ) {
                        alt56=1;
                    }
                    else if ( ((LA56_0>=64 && LA56_0<=69)) ) {
                        alt56=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("3911:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) )", 56, 0, input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3911:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3911:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3911:4: ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3911:4: ( (lv_typeTest_2_0= 'is' ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3912:1: (lv_typeTest_2_0= 'is' )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3912:1: (lv_typeTest_2_0= 'is' )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3913:3: lv_typeTest_2_0= 'is'
                            {
                            lv_typeTest_2_0=(Token)input.LT(1);
                            match(input,53,FOLLOW_53_in_ruleRelationalExpression6935); 

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

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3932:2: ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3933:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3933:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3934:3: lv_type_3_0= ruleDataTypeSpecifier
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6969);
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
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3957:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3957:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3957:7: ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3957:7: ( (lv_operator_4_0= ruleRelationalOperator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3958:1: (lv_operator_4_0= ruleRelationalOperator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3958:1: (lv_operator_4_0= ruleRelationalOperator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3959:3: lv_operator_4_0= ruleRelationalOperator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6998);
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

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3981:2: ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3982:1: (lv_rightOperand_5_0= ruleAddSubtractExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3982:1: (lv_rightOperand_5_0= ruleAddSubtractExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3983:3: lv_rightOperand_5_0= ruleAddSubtractExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAddSubtractExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression7019);
                            lv_rightOperand_5_0=ruleAddSubtractExpression();
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
                            	        		"AddSubtractExpression", 
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


    // $ANTLR start entryRuleAddSubtractExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4013:1: entryRuleAddSubtractExpression returns [EObject current=null] : iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF ;
    public final EObject entryRuleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddSubtractExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4014:2: (iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4015:2: iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression7059);
            iv_ruleAddSubtractExpression=ruleAddSubtractExpression();
            _fsp--;

             current =iv_ruleAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddSubtractExpression7069); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4022:1: ruleAddSubtractExpression returns [EObject current=null] : (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+ )? ) ;
    public final EObject ruleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplyDivideExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4027:6: ( (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4028:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4028:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4029:5: this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression7116);
            this_MultiplyDivideExpression_0=ruleMultiplyDivideExpression();
            _fsp--;

             
                    current = this_MultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4037:1: ( () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+ )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==54||LA59_0==70) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4037:2: () ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4037:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4038:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAddSubtractExpressionAccess().getAddSubtractExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getAddSubtractExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4053:2: ( (lv_rightParts_2_0= ruleAddSubtractExpressionPart ) )+
                    int cnt58=0;
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==54||LA58_0==70) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4054:1: (lv_rightParts_2_0= ruleAddSubtractExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4054:1: (lv_rightParts_2_0= ruleAddSubtractExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4055:3: lv_rightParts_2_0= ruleAddSubtractExpressionPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getRightPartsAddSubtractExpressionPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractExpressionPart_in_ruleAddSubtractExpression7146);
                    	    lv_rightParts_2_0=ruleAddSubtractExpressionPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAddSubtractExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightParts",
                    	    	        		lv_rightParts_2_0, 
                    	    	        		"AddSubtractExpressionPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt58 >= 1 ) break loop58;
                                EarlyExitException eee =
                                    new EarlyExitException(58, input);
                                throw eee;
                        }
                        cnt58++;
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


    // $ANTLR start entryRuleAddSubtractExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4085:1: entryRuleAddSubtractExpressionPart returns [EObject current=null] : iv_ruleAddSubtractExpressionPart= ruleAddSubtractExpressionPart EOF ;
    public final EObject entryRuleAddSubtractExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddSubtractExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4086:2: (iv_ruleAddSubtractExpressionPart= ruleAddSubtractExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4087:2: iv_ruleAddSubtractExpressionPart= ruleAddSubtractExpressionPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddSubtractExpressionPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddSubtractExpressionPart_in_entryRuleAddSubtractExpressionPart7185);
            iv_ruleAddSubtractExpressionPart=ruleAddSubtractExpressionPart();
            _fsp--;

             current =iv_ruleAddSubtractExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddSubtractExpressionPart7195); 

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
    // $ANTLR end entryRuleAddSubtractExpressionPart


    // $ANTLR start ruleAddSubtractExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4094:1: ruleAddSubtractExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleAddSubtractOperator ) ) ( (lv_operand_1_0= ruleMultiplyDivideExpression ) ) ) ;
    public final EObject ruleAddSubtractExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4099:6: ( ( ( (lv_operator_0_0= ruleAddSubtractOperator ) ) ( (lv_operand_1_0= ruleMultiplyDivideExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4100:1: ( ( (lv_operator_0_0= ruleAddSubtractOperator ) ) ( (lv_operand_1_0= ruleMultiplyDivideExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4100:1: ( ( (lv_operator_0_0= ruleAddSubtractOperator ) ) ( (lv_operand_1_0= ruleMultiplyDivideExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4100:2: ( (lv_operator_0_0= ruleAddSubtractOperator ) ) ( (lv_operand_1_0= ruleMultiplyDivideExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4100:2: ( (lv_operator_0_0= ruleAddSubtractOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4101:1: (lv_operator_0_0= ruleAddSubtractOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4101:1: (lv_operator_0_0= ruleAddSubtractOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4102:3: lv_operator_0_0= ruleAddSubtractOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionPartAccess().getOperatorAddSubtractOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpressionPart7241);
            lv_operator_0_0=ruleAddSubtractOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAddSubtractExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_0_0, 
            	        		"AddSubtractOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4124:2: ( (lv_operand_1_0= ruleMultiplyDivideExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4125:1: (lv_operand_1_0= ruleMultiplyDivideExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4125:1: (lv_operand_1_0= ruleMultiplyDivideExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4126:3: lv_operand_1_0= ruleMultiplyDivideExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionPartAccess().getOperandMultiplyDivideExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpressionPart7262);
            lv_operand_1_0=ruleMultiplyDivideExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAddSubtractExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_1_0, 
            	        		"MultiplyDivideExpression", 
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
    // $ANTLR end ruleAddSubtractExpressionPart


    // $ANTLR start entryRuleMultiplyDivideExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4156:1: entryRuleMultiplyDivideExpression returns [EObject current=null] : iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF ;
    public final EObject entryRuleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4157:2: (iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4158:2: iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression7298);
            iv_ruleMultiplyDivideExpression=ruleMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyDivideExpression7308); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4165:1: ruleMultiplyDivideExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+ )? ) ;
    public final EObject ruleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4170:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4171:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4171:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4172:5: this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression7355);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4180:1: ( () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+ )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=61 && LA61_0<=62)||(LA61_0>=71 && LA61_0<=72)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4180:2: () ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4180:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4181:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getMultiplyDivideExpressionAccess().getMultiplyDivideExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getMultiplyDivideExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4196:2: ( (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart ) )+
                    int cnt60=0;
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( ((LA60_0>=61 && LA60_0<=62)||(LA60_0>=71 && LA60_0<=72)) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4197:1: (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4197:1: (lv_rightParts_2_0= ruleMultiplyDivideExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4198:3: lv_rightParts_2_0= ruleMultiplyDivideExpressionPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getRightPartsMultiplyDivideExpressionPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideExpressionPart_in_ruleMultiplyDivideExpression7385);
                    	    lv_rightParts_2_0=ruleMultiplyDivideExpressionPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMultiplyDivideExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightParts",
                    	    	        		lv_rightParts_2_0, 
                    	    	        		"MultiplyDivideExpressionPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt60 >= 1 ) break loop60;
                                EarlyExitException eee =
                                    new EarlyExitException(60, input);
                                throw eee;
                        }
                        cnt60++;
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


    // $ANTLR start entryRuleMultiplyDivideExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4228:1: entryRuleMultiplyDivideExpressionPart returns [EObject current=null] : iv_ruleMultiplyDivideExpressionPart= ruleMultiplyDivideExpressionPart EOF ;
    public final EObject entryRuleMultiplyDivideExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4229:2: (iv_ruleMultiplyDivideExpressionPart= ruleMultiplyDivideExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4230:2: iv_ruleMultiplyDivideExpressionPart= ruleMultiplyDivideExpressionPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplyDivideExpressionPart_in_entryRuleMultiplyDivideExpressionPart7424);
            iv_ruleMultiplyDivideExpressionPart=ruleMultiplyDivideExpressionPart();
            _fsp--;

             current =iv_ruleMultiplyDivideExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyDivideExpressionPart7434); 

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
    // $ANTLR end entryRuleMultiplyDivideExpressionPart


    // $ANTLR start ruleMultiplyDivideExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4237:1: ruleMultiplyDivideExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleMultiplyDivideOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) ;
    public final EObject ruleMultiplyDivideExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4242:6: ( ( ( (lv_operator_0_0= ruleMultiplyDivideOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4243:1: ( ( (lv_operator_0_0= ruleMultiplyDivideOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4243:1: ( ( (lv_operator_0_0= ruleMultiplyDivideOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4243:2: ( (lv_operator_0_0= ruleMultiplyDivideOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4243:2: ( (lv_operator_0_0= ruleMultiplyDivideOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4244:1: (lv_operator_0_0= ruleMultiplyDivideOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4244:1: (lv_operator_0_0= ruleMultiplyDivideOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4245:3: lv_operator_0_0= ruleMultiplyDivideOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionPartAccess().getOperatorMultiplyDivideOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpressionPart7480);
            lv_operator_0_0=ruleMultiplyDivideOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplyDivideExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_0_0, 
            	        		"MultiplyDivideOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4267:2: ( (lv_operand_1_0= rulePowerExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4268:1: (lv_operand_1_0= rulePowerExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4268:1: (lv_operand_1_0= rulePowerExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4269:3: lv_operand_1_0= rulePowerExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionPartAccess().getOperandPowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpressionPart7501);
            lv_operand_1_0=rulePowerExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplyDivideExpressionPartRule().getType().getClassifier());
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
    // $ANTLR end ruleMultiplyDivideExpressionPart


    // $ANTLR start entryRulePowerExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4299:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4300:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4301:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression7537);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression7547); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4308:1: rulePowerExpression returns [EObject current=null] : (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryMinusExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4313:6: ( (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4314:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4314:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4315:5: this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryMinusExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7594);
            this_UnaryMinusExpression_0=ruleUnaryMinusExpression();
            _fsp--;

             
                    current = this_UnaryMinusExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4323:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==63||LA62_0==73) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4323:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4323:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4324:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4339:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4340:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4340:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4341:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression7624);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4363:2: ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4364:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4364:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4365:3: lv_exponent_3_0= ruleUnaryMinusExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryMinusExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7645);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4395:1: entryRuleUnaryMinusExpression returns [EObject current=null] : iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF ;
    public final EObject entryRuleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryMinusExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4396:2: (iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4397:2: iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryMinusExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression7683);
            iv_ruleUnaryMinusExpression=ruleUnaryMinusExpression();
            _fsp--;

             current =iv_ruleUnaryMinusExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryMinusExpression7693); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4404:1: ruleUnaryMinusExpression returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) ) ;
    public final EObject ruleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject this_FeatureCall_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4409:6: ( (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4410:1: (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4410:1: (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_ID && LA63_0<=RULE_STRING)||LA63_0==21||LA63_0==38||LA63_0==47||(LA63_0>=56 && LA63_0<=59)||(LA63_0>=74 && LA63_0<=75)) ) {
                alt63=1;
            }
            else if ( (LA63_0==54) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4410:1: (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) )", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4411:5: this_FeatureCall_0= ruleFeatureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getFeatureCallParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7740);
                    this_FeatureCall_0=ruleFeatureCall();
                    _fsp--;

                     
                            current = this_FeatureCall_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4420:6: ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4420:6: ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4420:7: () '-' ( (lv_operand_3_0= ruleFeatureCall ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4420:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4421:5: 
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

                    match(input,54,FOLLOW_54_in_ruleUnaryMinusExpression7765); 

                            createLeafNode(grammarAccess.getUnaryMinusExpressionAccess().getHyphenMinusKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4435:1: ( (lv_operand_3_0= ruleFeatureCall ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4436:1: (lv_operand_3_0= ruleFeatureCall )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4436:1: (lv_operand_3_0= ruleFeatureCall )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4437:3: lv_operand_3_0= ruleFeatureCall
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getOperandFeatureCallParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7786);
                    lv_operand_3_0=ruleFeatureCall();
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
                    	        		"FeatureCall", 
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


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4467:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4468:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4469:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall7823);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall7833); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4476:1: ruleFeatureCall returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_CallablePrimaryExpression_1 = null;

        EObject lv_parts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4481:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4482:1: (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4482:1: (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=RULE_REAL && LA66_0<=RULE_STRING)||LA66_0==47||(LA66_0>=58 && LA66_0<=59)||(LA66_0>=74 && LA66_0<=75)) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_ID||LA66_0==21||LA66_0==38||(LA66_0>=56 && LA66_0<=57)) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4482:1: (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) )", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4483:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleFeatureCall7880);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4492:6: (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4492:6: (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4493:5: this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getCallablePrimaryExpressionParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall7908);
                    this_CallablePrimaryExpression_1=ruleCallablePrimaryExpression();
                    _fsp--;

                     
                            current = this_CallablePrimaryExpression_1; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4501:1: ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==21||LA65_0==38||LA65_0==55) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4501:2: () ( (lv_parts_3_0= ruleFeatureCallPart ) )+
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4501:2: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4502:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_1_1_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "target", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_1_1_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4517:2: ( (lv_parts_3_0= ruleFeatureCallPart ) )+
                            int cnt64=0;
                            loop64:
                            do {
                                int alt64=2;
                                int LA64_0 = input.LA(1);

                                if ( (LA64_0==21||LA64_0==38||LA64_0==55) ) {
                                    alt64=1;
                                }


                                switch (alt64) {
                            	case 1 :
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4518:1: (lv_parts_3_0= ruleFeatureCallPart )
                            	    {
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4518:1: (lv_parts_3_0= ruleFeatureCallPart )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4519:3: lv_parts_3_0= ruleFeatureCallPart
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_1_1_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall7938);
                            	    lv_parts_3_0=ruleFeatureCallPart();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"parts",
                            	    	        		lv_parts_3_0, 
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
                            	    if ( cnt64 >= 1 ) break loop64;
                                        EarlyExitException eee =
                                            new EarlyExitException(64, input);
                                        throw eee;
                                }
                                cnt64++;
                            } while (true);


                            }
                            break;

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
    // $ANTLR end ruleFeatureCall


    // $ANTLR start entryRuleFeatureCallPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4549:1: entryRuleFeatureCallPart returns [EObject current=null] : iv_ruleFeatureCallPart= ruleFeatureCallPart EOF ;
    public final EObject entryRuleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4550:2: (iv_ruleFeatureCallPart= ruleFeatureCallPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4551:2: iv_ruleFeatureCallPart= ruleFeatureCallPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart7978);
            iv_ruleFeatureCallPart=ruleFeatureCallPart();
            _fsp--;

             current =iv_ruleFeatureCallPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallPart7988); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4558:1: ruleFeatureCallPart returns [EObject current=null] : (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall ) ;
    public final EObject ruleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject this_FeatureReference_0 = null;

        EObject this_ArrayElementReference_1 = null;

        EObject this_OperationCall_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4563:6: ( (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4564:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4564:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall )
            int alt67=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt67=1;
                }
                break;
            case 38:
                {
                alt67=2;
                }
                break;
            case 21:
                {
                alt67=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4564:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall )", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4565:5: this_FeatureReference_0= ruleFeatureReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getFeatureReferenceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureReference_in_ruleFeatureCallPart8035);
                    this_FeatureReference_0=ruleFeatureReference();
                    _fsp--;

                     
                            current = this_FeatureReference_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4575:5: this_ArrayElementReference_1= ruleArrayElementReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getArrayElementReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayElementReference_in_ruleFeatureCallPart8062);
                    this_ArrayElementReference_1=ruleArrayElementReference();
                    _fsp--;

                     
                            current = this_ArrayElementReference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4585:5: this_OperationCall_2= ruleOperationCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getOperationCallParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCall_in_ruleFeatureCallPart8089);
                    this_OperationCall_2=ruleOperationCall();
                    _fsp--;

                     
                            current = this_OperationCall_2; 
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


    // $ANTLR start entryRuleFeatureReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4601:1: entryRuleFeatureReference returns [EObject current=null] : iv_ruleFeatureReference= ruleFeatureReference EOF ;
    public final EObject entryRuleFeatureReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4602:2: (iv_ruleFeatureReference= ruleFeatureReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4603:2: iv_ruleFeatureReference= ruleFeatureReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference8124);
            iv_ruleFeatureReference=ruleFeatureReference();
            _fsp--;

             current =iv_ruleFeatureReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureReference8134); 

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
    // $ANTLR end entryRuleFeatureReference


    // $ANTLR start ruleFeatureReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4610:1: ruleFeatureReference returns [EObject current=null] : ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) ) ;
    public final EObject ruleFeatureReference() throws RecognitionException {
        EObject current = null;

        Token lv_featureName_1_1=null;
        Token lv_featureName_1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4615:6: ( ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4616:1: ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4616:1: ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4616:3: '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) )
            {
            match(input,55,FOLLOW_55_in_ruleFeatureReference8169); 

                    createLeafNode(grammarAccess.getFeatureReferenceAccess().getFullStopKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4620:1: ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4621:1: ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4621:1: ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4622:1: (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4622:1: (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                alt68=1;
            }
            else if ( (LA68_0==47) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4622:1: (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' )", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4623:3: lv_featureName_1_1= RULE_ID
                    {
                    lv_featureName_1_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureReference8188); 

                    			createLeafNode(grammarAccess.getFeatureReferenceAccess().getFeatureNameIDTerminalRuleCall_1_0_0(), "featureName"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"featureName",
                    	        		lv_featureName_1_1, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4644:8: lv_featureName_1_2= 'unit'
                    {
                    lv_featureName_1_2=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleFeatureReference8209); 

                            createLeafNode(grammarAccess.getFeatureReferenceAccess().getFeatureNameUnitKeyword_1_0_1(), "featureName"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "featureName", lv_featureName_1_2, null, lastConsumedNode);
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
    // $ANTLR end ruleFeatureReference


    // $ANTLR start entryRuleArrayElementReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4673:1: entryRuleArrayElementReference returns [EObject current=null] : iv_ruleArrayElementReference= ruleArrayElementReference EOF ;
    public final EObject entryRuleArrayElementReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayElementReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4674:2: (iv_ruleArrayElementReference= ruleArrayElementReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4675:2: iv_ruleArrayElementReference= ruleArrayElementReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayElementReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayElementReference_in_entryRuleArrayElementReference8261);
            iv_ruleArrayElementReference=ruleArrayElementReference();
            _fsp--;

             current =iv_ruleArrayElementReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayElementReference8271); 

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
    // $ANTLR end entryRuleArrayElementReference


    // $ANTLR start ruleArrayElementReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4682:1: ruleArrayElementReference returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) ;
    public final EObject ruleArrayElementReference() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4687:6: ( ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4688:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4688:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4688:3: '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']'
            {
            match(input,38,FOLLOW_38_in_ruleArrayElementReference8306); 

                    createLeafNode(grammarAccess.getArrayElementReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4692:1: ( (lv_subscripts_1_0= ruleSubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4693:1: (lv_subscripts_1_0= ruleSubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4693:1: (lv_subscripts_1_0= ruleSubscript )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4694:3: lv_subscripts_1_0= ruleSubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayElementReferenceAccess().getSubscriptsSubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSubscript_in_ruleArrayElementReference8327);
            lv_subscripts_1_0=ruleSubscript();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayElementReferenceRule().getType().getClassifier());
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4716:2: ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==16) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4716:4: ',' ( (lv_subscripts_3_0= ruleSubscript ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleArrayElementReference8338); 

            	            createLeafNode(grammarAccess.getArrayElementReferenceAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4720:1: ( (lv_subscripts_3_0= ruleSubscript ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4721:1: (lv_subscripts_3_0= ruleSubscript )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4721:1: (lv_subscripts_3_0= ruleSubscript )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4722:3: lv_subscripts_3_0= ruleSubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayElementReferenceAccess().getSubscriptsSubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubscript_in_ruleArrayElementReference8359);
            	    lv_subscripts_3_0=ruleSubscript();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArrayElementReferenceRule().getType().getClassifier());
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
            	    break loop69;
                }
            } while (true);

            match(input,39,FOLLOW_39_in_ruleArrayElementReference8371); 

                    createLeafNode(grammarAccess.getArrayElementReferenceAccess().getRightSquareBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleArrayElementReference


    // $ANTLR start entryRuleOperationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4756:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4757:2: (iv_ruleOperationCall= ruleOperationCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4758:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCall_in_entryRuleOperationCall8407);
            iv_ruleOperationCall=ruleOperationCall();
            _fsp--;

             current =iv_ruleOperationCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCall8417); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4765:1: ruleOperationCall returns [EObject current=null] : ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4770:6: ( ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4771:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4771:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4771:2: () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4771:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4772:5: 
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

            match(input,21,FOLLOW_21_in_ruleOperationCall8461); 

                    createLeafNode(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4786:1: ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_ID && LA71_0<=RULE_STRING)||LA71_0==21||LA71_0==25||LA71_0==38||LA71_0==47||LA71_0==52||LA71_0==54||(LA71_0>=56 && LA71_0<=59)||(LA71_0>=74 && LA71_0<=75)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4786:2: ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4786:2: ( (lv_arguments_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4787:1: (lv_arguments_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4787:1: (lv_arguments_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4788:3: lv_arguments_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall8483);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4810:2: ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==16) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4810:4: ',' ( (lv_arguments_4_0= ruleExpression ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleOperationCall8494); 

                    	            createLeafNode(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4814:1: ( (lv_arguments_4_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4815:1: (lv_arguments_4_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4815:1: (lv_arguments_4_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4816:3: lv_arguments_4_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall8515);
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
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,22,FOLLOW_22_in_ruleOperationCall8529); 

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


    // $ANTLR start entryRuleCallablePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4850:1: entryRuleCallablePrimaryExpression returns [EObject current=null] : iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF ;
    public final EObject entryRuleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallablePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4851:2: (iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4852:2: iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallablePrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression8565);
            iv_ruleCallablePrimaryExpression=ruleCallablePrimaryExpression();
            _fsp--;

             current =iv_ruleCallablePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallablePrimaryExpression8575); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4859:1: ruleCallablePrimaryExpression returns [EObject current=null] : (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject ruleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MatrixConstructionOperator_0 = null;

        EObject this_SymbolReference_1 = null;

        EObject this_ParenthesizedExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4864:6: ( (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4865:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4865:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt72=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt72=1;
                }
                break;
            case RULE_ID:
            case 56:
            case 57:
                {
                alt72=2;
                }
                break;
            case 21:
                {
                alt72=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4865:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression )", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4866:5: this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getMatrixConstructionOperatorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_ruleCallablePrimaryExpression8622);
                    this_MatrixConstructionOperator_0=ruleMatrixConstructionOperator();
                    _fsp--;

                     
                            current = this_MatrixConstructionOperator_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4876:5: this_SymbolReference_1= ruleSymbolReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getSymbolReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSymbolReference_in_ruleCallablePrimaryExpression8649);
                    this_SymbolReference_1=ruleSymbolReference();
                    _fsp--;

                     
                            current = this_SymbolReference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4886:5: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression8676);
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


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4902:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4903:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4904:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression8711);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression8721); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4911:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_UnitConstructionOperator_1 = null;

        EObject this_BeginExpression_2 = null;

        EObject this_EndExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4916:6: ( (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4917:1: (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4917:1: (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression )
            int alt73=4;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 74:
            case 75:
                {
                alt73=1;
                }
                break;
            case 47:
                {
                alt73=2;
                }
                break;
            case 58:
                {
                alt73=3;
                }
                break;
            case 59:
                {
                alt73=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4917:1: (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression )", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4918:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression8768);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4928:5: this_UnitConstructionOperator_1= ruleUnitConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnitConstructionOperatorParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression8795);
                    this_UnitConstructionOperator_1=ruleUnitConstructionOperator();
                    _fsp--;

                     
                            current = this_UnitConstructionOperator_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4938:5: this_BeginExpression_2= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression8822);
                    this_BeginExpression_2=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4948:5: this_EndExpression_3= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression8849);
                    this_EndExpression_3=ruleEndExpression();
                    _fsp--;

                     
                            current = this_EndExpression_3; 
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4964:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4965:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4966:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral8884);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral8894); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4973:1: ruleLiteral returns [EObject current=null] : (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4978:6: ( (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4979:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4979:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt74=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt74=1;
                }
                break;
            case 74:
            case 75:
                {
                alt74=2;
                }
                break;
            case RULE_STRING:
                {
                alt74=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4979:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4980:5: this_NumericalLiteral_0= ruleNumericalLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericalLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalLiteral_in_ruleLiteral8941);
                    this_NumericalLiteral_0=ruleNumericalLiteral();
                    _fsp--;

                     
                            current = this_NumericalLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4990:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral8968);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5000:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral8995);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5016:1: entryRuleNumericalLiteral returns [EObject current=null] : iv_ruleNumericalLiteral= ruleNumericalLiteral EOF ;
    public final EObject entryRuleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5017:2: (iv_ruleNumericalLiteral= ruleNumericalLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5018:2: iv_ruleNumericalLiteral= ruleNumericalLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral9030);
            iv_ruleNumericalLiteral=ruleNumericalLiteral();
            _fsp--;

             current =iv_ruleNumericalLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalLiteral9040); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5025:1: ruleNumericalLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5030:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5031:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5031:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_REAL) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_INTEGER) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5031:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5032:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral9087);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5042:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral9114);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5058:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5059:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5060:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral9149);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral9159); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5067:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_imaginary_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5072:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5073:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5073:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5073:2: ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5073:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5074:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5074:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5075:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral9201); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5097:2: ( (lv_imaginary_1_0= 'j' ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==56) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5098:1: (lv_imaginary_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5098:1: (lv_imaginary_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5099:3: lv_imaginary_1_0= 'j'
                    {
                    lv_imaginary_1_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleRealLiteral9224); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getImaginaryJKeyword_1_0(), "imaginary"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "imaginary", true, "j", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5118:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==21) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5118:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleRealLiteral9249); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5122:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5123:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5123:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5124:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral9270);
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

                    match(input,22,FOLLOW_22_in_ruleRealLiteral9280); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5158:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5159:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5160:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral9318);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral9328); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5167:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_imaginary_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5172:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5173:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5173:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5173:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5173:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5174:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5174:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5175:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral9370); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5197:2: ( (lv_imaginary_1_0= 'j' ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==56) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5198:1: (lv_imaginary_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5198:1: (lv_imaginary_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5199:3: lv_imaginary_1_0= 'j'
                    {
                    lv_imaginary_1_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleIntegerLiteral9393); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getImaginaryJKeyword_1_0(), "imaginary"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "imaginary", true, "j", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5218:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==21) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5218:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleIntegerLiteral9418); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5222:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5223:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5223:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5224:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral9439);
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

                    match(input,22,FOLLOW_22_in_ruleIntegerLiteral9449); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5258:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5259:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5260:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral9487);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral9497); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5267:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5272:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5273:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5273:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5274:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5274:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5275:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral9542);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5305:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5306:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5307:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral9577);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral9587); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5314:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5319:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5320:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5320:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5321:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5321:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5322:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral9628); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5352:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5353:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5354:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9668);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName9678); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5361:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_identifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_identifiers_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5366:6: ( ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5367:1: ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5367:1: ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5367:2: ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5367:2: ( (lv_identifiers_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5368:1: (lv_identifiers_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5368:1: (lv_identifiers_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5369:3: lv_identifiers_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getIdentifiersKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleQualifiedName9724);
            lv_identifiers_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"identifiers",
            	        		lv_identifiers_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5391:2: ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==57) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5391:4: '::' ( (lv_identifiers_2_0= ruleKeywordID ) )
            	    {
            	    match(input,57,FOLLOW_57_in_ruleQualifiedName9735); 

            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5395:1: ( (lv_identifiers_2_0= ruleKeywordID ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5396:1: (lv_identifiers_2_0= ruleKeywordID )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5396:1: (lv_identifiers_2_0= ruleKeywordID )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5397:3: lv_identifiers_2_0= ruleKeywordID
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getIdentifiersKeywordIDParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordID_in_ruleQualifiedName9756);
            	    lv_identifiers_2_0=ruleKeywordID();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"identifiers",
            	    	        		lv_identifiers_2_0, 
            	    	        		"KeywordID", 
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


    // $ANTLR start entryRuleSymbolReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:1: entryRuleSymbolReference returns [EObject current=null] : iv_ruleSymbolReference= ruleSymbolReference EOF ;
    public final EObject entryRuleSymbolReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5428:2: (iv_ruleSymbolReference= ruleSymbolReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5429:2: iv_ruleSymbolReference= ruleSymbolReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSymbolReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleSymbolReference_in_entryRuleSymbolReference9794);
            iv_ruleSymbolReference=ruleSymbolReference();
            _fsp--;

             current =iv_ruleSymbolReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSymbolReference9804); 

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
    // $ANTLR end entryRuleSymbolReference


    // $ANTLR start ruleSymbolReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5436:1: ruleSymbolReference returns [EObject current=null] : ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleSymbolReference() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        EObject lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5441:6: ( ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5442:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5442:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5442:2: ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5442:2: ( (lv_global_0_0= '::' ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==57) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5443:1: (lv_global_0_0= '::' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5443:1: (lv_global_0_0= '::' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5444:3: lv_global_0_0= '::'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleSymbolReference9847); 

                            createLeafNode(grammarAccess.getSymbolReferenceAccess().getGlobalColonColonKeyword_0_0(), "global"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSymbolReferenceRule().getType().getClassifier());
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5463:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5464:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5464:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5465:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSymbolReferenceAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSymbolReference9882);
            lv_name_1_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSymbolReferenceRule().getType().getClassifier());
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
    // $ANTLR end ruleSymbolReference


    // $ANTLR start entryRuleSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5495:1: entryRuleSubscript returns [EObject current=null] : iv_ruleSubscript= ruleSubscript EOF ;
    public final EObject entryRuleSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5496:2: (iv_ruleSubscript= ruleSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5497:2: iv_ruleSubscript= ruleSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubscript_in_entryRuleSubscript9918);
            iv_ruleSubscript=ruleSubscript();
            _fsp--;

             current =iv_ruleSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubscript9928); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5504:1: ruleSubscript returns [EObject current=null] : ( ( (lv_all_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleSubscript() throws RecognitionException {
        EObject current = null;

        Token lv_all_0_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5509:6: ( ( ( (lv_all_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5510:1: ( ( (lv_all_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5510:1: ( ( (lv_all_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==49) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=RULE_ID && LA82_0<=RULE_STRING)||LA82_0==21||LA82_0==25||LA82_0==38||LA82_0==47||LA82_0==52||LA82_0==54||(LA82_0>=56 && LA82_0<=59)||(LA82_0>=74 && LA82_0<=75)) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5510:1: ( ( (lv_all_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5510:2: ( (lv_all_0_0= ':' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5510:2: ( (lv_all_0_0= ':' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5511:1: (lv_all_0_0= ':' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5511:1: (lv_all_0_0= ':' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5512:3: lv_all_0_0= ':'
                    {
                    lv_all_0_0=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_ruleSubscript9971); 

                            createLeafNode(grammarAccess.getSubscriptAccess().getAllColonKeyword_0_0(), "all"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubscriptRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "all", true, ":", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5532:6: ( (lv_expression_1_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5532:6: ( (lv_expression_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5533:1: (lv_expression_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5533:1: (lv_expression_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5534:3: lv_expression_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubscript10011);
                    lv_expression_1_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubscriptRule().getType().getClassifier());
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
    // $ANTLR end ruleSubscript


    // $ANTLR start entryRuleMatrixConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5564:1: entryRuleMatrixConstructionOperator returns [EObject current=null] : iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF ;
    public final EObject entryRuleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5565:2: (iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5566:2: iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMatrixConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator10047);
            iv_ruleMatrixConstructionOperator=ruleMatrixConstructionOperator();
            _fsp--;

             current =iv_ruleMatrixConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixConstructionOperator10057); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5573:1: ruleMatrixConstructionOperator returns [EObject current=null] : ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionLists_1_0 = null;

        EObject lv_expressionLists_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5578:6: ( ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5579:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5579:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5579:3: '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,38,FOLLOW_38_in_ruleMatrixConstructionOperator10092); 

                    createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5583:1: ( (lv_expressionLists_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5584:1: (lv_expressionLists_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5584:1: (lv_expressionLists_1_0= ruleExpressionList )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5585:3: lv_expressionLists_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10113);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5607:2: ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==18) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5607:4: ';' ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleMatrixConstructionOperator10124); 

            	            createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5611:1: ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5612:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5612:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5613:3: lv_expressionLists_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10145);
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
            	    break loop83;
                }
            } while (true);

            match(input,39,FOLLOW_39_in_ruleMatrixConstructionOperator10157); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5647:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5648:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5649:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList10193);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList10203); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5656:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5661:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5662:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5662:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5662:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5662:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5663:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5663:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5664:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10249);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5686:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==16) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5686:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleExpressionList10260); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5690:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5691:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5691:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5692:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10281);
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
            	    break loop84;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5722:1: entryRuleUnitConstructionOperator returns [EObject current=null] : iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF ;
    public final EObject entryRuleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5723:2: (iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5724:2: iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10319);
            iv_ruleUnitConstructionOperator=ruleUnitConstructionOperator();
            _fsp--;

             current =iv_ruleUnitConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitConstructionOperator10329); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5731:1: ruleUnitConstructionOperator returns [EObject current=null] : ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' ) ;
    public final EObject ruleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_unitExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5736:6: ( ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5737:1: ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5737:1: ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5737:3: 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')'
            {
            match(input,47,FOLLOW_47_in_ruleUnitConstructionOperator10364); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitKeyword_0(), null); 
                
            match(input,21,FOLLOW_21_in_ruleUnitConstructionOperator10374); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5745:1: ( (lv_unitExpression_2_0= ruleUnitExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5746:1: (lv_unitExpression_2_0= ruleUnitExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5746:1: (lv_unitExpression_2_0= ruleUnitExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5747:3: lv_unitExpression_2_0= ruleUnitExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitExpressionUnitExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10395);
            lv_unitExpression_2_0=ruleUnitExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"unitExpression",
            	        		lv_unitExpression_2_0, 
            	        		"UnitExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,22,FOLLOW_22_in_ruleUnitConstructionOperator10405); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5781:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5782:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5783:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10441);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression10451); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5790:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5795:6: ( ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5796:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5796:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5796:3: '(' ( (lv_expression_1_0= ruleExpression ) ) ')'
            {
            match(input,21,FOLLOW_21_in_ruleParenthesizedExpression10486); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5800:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5801:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5801:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5802:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10507);
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

            match(input,22,FOLLOW_22_in_ruleParenthesizedExpression10517); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5836:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5837:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5838:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10553);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression10563); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5845:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5850:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5851:1: ( () 'begin' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5851:1: ( () 'begin' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5851:2: () 'begin'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5851:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5852:5: 
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

            match(input,58,FOLLOW_58_in_ruleBeginExpression10607); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5874:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5875:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5876:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression10643);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression10653); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5883:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5888:6: ( ( () 'end' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5889:1: ( () 'end' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5889:1: ( () 'end' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5889:2: () 'end'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5889:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5890:5: 
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

            match(input,59,FOLLOW_59_in_ruleEndExpression10697); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5912:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5913:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5914:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10733);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression10743); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5921:1: ruleUnitExpression returns [EObject current=null] : ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_unspecified_0_0=null;
        EObject lv_expression_2_0 = null;

        EObject lv_numerator_3_0 = null;

        EObject lv_denominator_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5926:6: ( ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5927:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5927:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )
            int alt86=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt86=1;
                }
                break;
            case 60:
                {
                alt86=2;
                }
                break;
            case RULE_ID:
            case RULE_INTEGER:
            case 56:
                {
                alt86=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5927:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5927:2: ( (lv_unspecified_0_0= '?' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5927:2: ( (lv_unspecified_0_0= '?' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5928:1: (lv_unspecified_0_0= '?' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5928:1: (lv_unspecified_0_0= '?' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5929:3: lv_unspecified_0_0= '?'
                    {
                    lv_unspecified_0_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleUnitExpression10786); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getUnspecifiedQuestionMarkKeyword_0_0(), "unspecified"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "unspecified", true, "?", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5949:6: ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5949:6: ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5949:8: 'eval' ( (lv_expression_2_0= ruleExpression ) )
                    {
                    match(input,60,FOLLOW_60_in_ruleUnitExpression10816); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getEvalKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5953:1: ( (lv_expression_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5954:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5954:1: (lv_expression_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5955:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getExpressionExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleUnitExpression10837);
                    lv_expression_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
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


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:6: ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:6: ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:7: ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:7: ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5979:1: (lv_numerator_3_0= ruleUnitExpressionNumerator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5979:1: (lv_numerator_3_0= ruleUnitExpressionNumerator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5980:3: lv_numerator_3_0= ruleUnitExpressionNumerator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10866);
                    lv_numerator_3_0=ruleUnitExpressionNumerator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"numerator",
                    	        		lv_numerator_3_0, 
                    	        		"UnitExpressionNumerator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6002:2: ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==61) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6002:4: '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) )
                            {
                            match(input,61,FOLLOW_61_in_ruleUnitExpression10877); 

                                    createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_2_1_0(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6006:1: ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6007:1: (lv_denominator_5_0= ruleUnitExpressionDenominator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6007:1: (lv_denominator_5_0= ruleUnitExpressionDenominator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6008:3: lv_denominator_5_0= ruleUnitExpressionDenominator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_2_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10898);
                            lv_denominator_5_0=ruleUnitExpressionDenominator();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"denominator",
                            	        		lv_denominator_5_0, 
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
    // $ANTLR end ruleUnitExpression


    // $ANTLR start entryRuleUnitExpressionNumerator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6038:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6039:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6040:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator10937);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator10947); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6047:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6052:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6053:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6053:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_INTEGER) ) {
                alt88=1;
            }
            else if ( (LA88_0==RULE_ID||LA88_0==56) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6053:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6053:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6053:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6054:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6054:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6055:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator10989); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6078:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6078:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6078:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6078:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6079:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6079:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6080:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11022);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6102:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==62) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6102:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,62,FOLLOW_62_in_ruleUnitExpressionNumerator11033); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6106:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6107:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6107:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6108:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11054);
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
                    	    break loop87;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6138:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6139:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6140:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11093);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11103); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6147:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6152:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6153:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6153:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID||LA90_0==56) ) {
                alt90=1;
            }
            else if ( (LA90_0==21) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6153:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6153:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6153:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6154:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6154:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6155:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11149);
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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6178:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6178:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6178:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,21,FOLLOW_21_in_ruleUnitExpressionDenominator11166); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6182:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6183:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6183:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6184:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11187);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6206:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==62) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6206:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,62,FOLLOW_62_in_ruleUnitExpressionDenominator11198); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6210:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6211:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6211:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6212:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11219);
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
                    	    break loop89;
                        }
                    } while (true);

                    match(input,22,FOLLOW_22_in_ruleUnitExpressionDenominator11231); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6246:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6247:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6248:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11268);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor11278); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6255:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operand_0_0 = null;

        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6260:6: ( ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6261:1: ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6261:1: ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6261:2: ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6261:2: ( (lv_operand_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6262:1: (lv_operand_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6262:1: (lv_operand_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6263:3: lv_operand_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getOperandKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleUnitExpressionFactor11324);
            lv_operand_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionFactorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6285:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==63) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6285:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,63,FOLLOW_63_in_ruleUnitExpressionFactor11335); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6289:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6290:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6290:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6291:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11356);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6321:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6322:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6323:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11394);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent11404); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6330:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6335:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6336:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6336:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6336:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6336:2: ( (lv_negative_0_0= '-' ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==54) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6337:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6337:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6338:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleUnitExpressionExponent11447); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6357:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6359:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11478); 

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


    // $ANTLR start entryRuleKeywordID
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6389:1: entryRuleKeywordID returns [String current=null] : iv_ruleKeywordID= ruleKeywordID EOF ;
    public final String entryRuleKeywordID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordID = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6390:2: (iv_ruleKeywordID= ruleKeywordID EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6391:2: iv_ruleKeywordID= ruleKeywordID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeywordID_in_entryRuleKeywordID11520);
            iv_ruleKeywordID=ruleKeywordID();
            _fsp--;

             current =iv_ruleKeywordID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordID11531); 

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
    // $ANTLR end entryRuleKeywordID


    // $ANTLR start ruleKeywordID
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6398:1: ruleKeywordID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'j' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6403:6: ( (this_ID_0= RULE_ID | kw= 'j' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6404:1: (this_ID_0= RULE_ID | kw= 'j' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6404:1: (this_ID_0= RULE_ID | kw= 'j' )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_ID) ) {
                alt93=1;
            }
            else if ( (LA93_0==56) ) {
                alt93=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6404:1: (this_ID_0= RULE_ID | kw= 'j' )", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6404:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordID11571); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(grammarAccess.getKeywordIDAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6413:2: kw= 'j'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleKeywordID11595); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getKeywordIDAccess().getJKeyword_1(), null); 
                        

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
    // $ANTLR end ruleKeywordID


    // $ANTLR start ruleRelationalOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6426:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6430:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6431:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6431:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )
            int alt94=6;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt94=1;
                }
                break;
            case 65:
                {
                alt94=2;
                }
                break;
            case 66:
                {
                alt94=3;
                }
                break;
            case 67:
                {
                alt94=4;
                }
                break;
            case 68:
                {
                alt94=5;
                }
                break;
            case 69:
                {
                alt94=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6431:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6431:2: ( '<' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6431:2: ( '<' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6431:4: '<'
                    {
                    match(input,64,FOLLOW_64_in_ruleRelationalOperator11647); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6437:6: ( '<=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6437:6: ( '<=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6437:8: '<='
                    {
                    match(input,65,FOLLOW_65_in_ruleRelationalOperator11662); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6443:6: ( '>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6443:6: ( '>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6443:8: '>'
                    {
                    match(input,66,FOLLOW_66_in_ruleRelationalOperator11677); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6449:6: ( '>=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6449:6: ( '>=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6449:8: '>='
                    {
                    match(input,67,FOLLOW_67_in_ruleRelationalOperator11692); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6455:6: ( '==' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6455:6: ( '==' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6455:8: '=='
                    {
                    match(input,68,FOLLOW_68_in_ruleRelationalOperator11707); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6461:6: ( '!=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6461:6: ( '!=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6461:8: '!='
                    {
                    match(input,69,FOLLOW_69_in_ruleRelationalOperator11722); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6471:1: ruleAddSubtractOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAddSubtractOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6475:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6476:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6476:1: ( ( '+' ) | ( '-' ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==70) ) {
                alt95=1;
            }
            else if ( (LA95_0==54) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6476:1: ( ( '+' ) | ( '-' ) )", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6476:2: ( '+' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6476:2: ( '+' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6476:4: '+'
                    {
                    match(input,70,FOLLOW_70_in_ruleAddSubtractOperator11765); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6482:6: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6482:6: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6482:8: '-'
                    {
                    match(input,54,FOLLOW_54_in_ruleAddSubtractOperator11780); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6492:1: ruleMultiplyDivideOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplyDivideOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6496:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6497:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6497:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt96=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt96=1;
                }
                break;
            case 61:
                {
                alt96=2;
                }
                break;
            case 71:
                {
                alt96=3;
                }
                break;
            case 72:
                {
                alt96=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6497:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6497:2: ( '*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6497:2: ( '*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6497:4: '*'
                    {
                    match(input,62,FOLLOW_62_in_ruleMultiplyDivideOperator11823); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6503:6: ( '/' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6503:6: ( '/' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6503:8: '/'
                    {
                    match(input,61,FOLLOW_61_in_ruleMultiplyDivideOperator11838); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6509:6: ( '.*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6509:6: ( '.*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6509:8: '.*'
                    {
                    match(input,71,FOLLOW_71_in_ruleMultiplyDivideOperator11853); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6515:6: ( './' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6515:6: ( './' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6515:8: './'
                    {
                    match(input,72,FOLLOW_72_in_ruleMultiplyDivideOperator11868); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6525:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:1: ( ( '^' ) | ( '.^' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==63) ) {
                alt97=1;
            }
            else if ( (LA97_0==73) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6530:1: ( ( '^' ) | ( '.^' ) )", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:2: ( '^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:2: ( '^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6530:4: '^'
                    {
                    match(input,63,FOLLOW_63_in_rulePowerOperator11911); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6536:6: ( '.^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6536:6: ( '.^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6536:8: '.^'
                    {
                    match(input,73,FOLLOW_73_in_rulePowerOperator11926); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6546:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6550:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6551:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6551:1: ( ( 'false' ) | ( 'true' ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==74) ) {
                alt98=1;
            }
            else if ( (LA98_0==75) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6551:1: ( ( 'false' ) | ( 'true' ) )", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6551:2: ( 'false' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6551:2: ( 'false' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6551:4: 'false'
                    {
                    match(input,74,FOLLOW_74_in_ruleBooleanKind11969); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6557:6: ( 'true' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6557:6: ( 'true' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6557:8: 'true'
                    {
                    match(input,75,FOLLOW_75_in_ruleBooleanKind11984); 

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


 

    public static final BitSet FOLLOW_ruleMscript_in_entryRuleMscript75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMscript85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_ruleMscript130 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackageDefinition211 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDefinition232 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackageDefinition242 = new BitSet(new long[]{0x00009F2F001AD000L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_rulePackageDefinition263 = new BitSet(new long[]{0x00009F2F001AD000L});
    public static final BitSet FOLLOW_14_in_rulePackageDefinition274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_entryRulePackageDefinitionElement310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinitionElement320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rulePackageDefinitionElement367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_rulePackageDefinitionElement394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_rulePackageDefinitionElement421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_rulePackageDefinitionElement448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rulePackageDefinitionElement475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_rulePackageDefinitionElement502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationDefinition547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationDefinition582 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleEnumerationDefinition603 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationDefinition613 = new BitSet(new long[]{0x0100000000004010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition635 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_ruleEnumerationDefinition646 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition667 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationDefinition681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleEnumerationLiteralDeclaration772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordDefinition817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRecordDefinition852 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleRecordDefinition873 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRecordDefinition883 = new BitSet(new long[]{0x03001F2000004010L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition904 = new BitSet(new long[]{0x03001F2000004010L});
    public static final BitSet FOLLOW_14_in_ruleRecordDefinition915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordFieldDeclaration961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1007 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclarationItem_in_ruleRecordFieldDeclaration1028 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleRecordFieldDeclaration1039 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclarationItem_in_ruleRecordFieldDeclaration1060 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleRecordFieldDeclaration1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclarationItem_in_entryRuleRecordFieldDeclarationItem1108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordFieldDeclarationItem1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleRecordFieldDeclarationItem1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFunctionDefinition1251 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFunctionDefinition1275 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleFunctionDefinition1296 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFunctionDefinition1306 = new BitSet(new long[]{0x03009F2600C80010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1328 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionDefinition1339 = new BitSet(new long[]{0x03009F2600880010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1360 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_22_in_ruleFunctionDefinition1374 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunctionDefinition1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterDeclaration1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableModifier_in_ruleParameterDeclaration1487 = new BitSet(new long[]{0x03009F2000800010L});
    public static final BitSet FOLLOW_23_in_ruleParameterDeclaration1506 = new BitSet(new long[]{0x03009F2000000010L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_ruleParameterDeclaration1541 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleParameterDeclaration1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement1598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallStatement_in_ruleStatement1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoWhileStatement_in_ruleStatement1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeachStatement_in_ruleStatement1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleStatement1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStatement1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock1906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleBlock1960 = new BitSet(new long[]{0x0F009F7F722860F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock1981 = new BitSet(new long[]{0x0F009F7F722860F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_14_in_ruleBlock1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallStatement_in_entryRuleFeatureCallStatement2028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallStatement2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleFeatureCallStatement2084 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_24_in_ruleFeatureCallStatement2095 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCallStatement2116 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureCallStatement2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement2164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleIfStatement2209 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfCase_in_ruleIfStatement2230 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_26_in_ruleIfStatement2241 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfCase_in_ruleIfStatement2262 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_27_in_ruleIfStatement2275 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement2296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfCase_in_entryRuleIfCase2334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfCase2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfCase2390 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfCase2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement2447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleWhileStatement2492 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileStatement2513 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoWhileStatement_in_entryRuleDoWhileStatement2570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoWhileStatement2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDoWhileStatement2615 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleDoWhileStatement2636 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleDoWhileStatement2646 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDoWhileStatement2667 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDoWhileStatement2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeachStatement_in_entryRuleForeachStatement2713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForeachStatement2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleForeachStatement2758 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleForeachStatement2779 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleForeachStatement2789 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleForeachStatement2810 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleForeachStatement2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableModifier_in_ruleVariableDeclaration2923 = new BitSet(new long[]{0x00009F2100000000L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleVariableDeclaration2946 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitTypeSpecifier_in_ruleVariableDeclaration2973 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_32_in_ruleVariableDeclaration2990 = new BitSet(new long[]{0x0300000000000010L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleVariableDeclaration3011 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration3034 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleVariableDeclaration3045 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration3066 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleVariableDeclaration3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableModifier_in_entryRuleVariableModifier3114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableModifier3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVariableModifier3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVariableModifier3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVariableModifier3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_entryRuleVariableDeclarationItem3290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationItem3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleVariableDeclarationItem3346 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleVariableDeclarationItem3357 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclarationItem3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition3416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleTypeDefinition3461 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleTypeDefinition3482 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypeDefinition3492 = new BitSet(new long[]{0x00001F2000000000L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeDefinition3513 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTypeDefinition3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement3559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleReturnStatement3604 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement3625 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReturnStatement3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_entryRuleTypeSpecifier3671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeSpecifier3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleTypeSpecifier3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitTypeSpecifier_in_ruleTypeSpecifier3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier3790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeSpecifier3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier3847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier3909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier4055 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier4139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericalTypeSpecifier4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericalTypeSpecifier4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier4228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier4238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleRealTypeSpecifier4282 = new BitSet(new long[]{0x0000004000200002L});
    public static final BitSet FOLLOW_21_in_ruleRealTypeSpecifier4293 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier4314 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleRealTypeSpecifier4324 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleRealTypeSpecifier4337 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4358 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleRealTypeSpecifier4369 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4390 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleRealTypeSpecifier4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier4440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleIntegerTypeSpecifier4494 = new BitSet(new long[]{0x0000004000200002L});
    public static final BitSet FOLLOW_21_in_ruleIntegerTypeSpecifier4505 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier4526 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleIntegerTypeSpecifier4536 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleIntegerTypeSpecifier4549 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4570 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleIntegerTypeSpecifier4581 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4602 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleIntegerTypeSpecifier4614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier4652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleComplexTypeSpecifier4706 = new BitSet(new long[]{0x0000004000200002L});
    public static final BitSet FOLLOW_21_in_ruleComplexTypeSpecifier4717 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier4738 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleComplexTypeSpecifier4748 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleComplexTypeSpecifier4761 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4782 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleComplexTypeSpecifier4793 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4814 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleComplexTypeSpecifier4826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier4864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier4874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleGaussianTypeSpecifier4918 = new BitSet(new long[]{0x0000004000200002L});
    public static final BitSet FOLLOW_21_in_ruleGaussianTypeSpecifier4929 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier4950 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleGaussianTypeSpecifier4960 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleGaussianTypeSpecifier4973 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier4994 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleGaussianTypeSpecifier5005 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier5026 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleGaussianTypeSpecifier5038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier5076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier5086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBooleanTypeSpecifier5130 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleBooleanTypeSpecifier5141 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5162 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleBooleanTypeSpecifier5173 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5194 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleBooleanTypeSpecifier5206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier5244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier5254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleStringTypeSpecifier5298 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleStringTypeSpecifier5309 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5330 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleStringTypeSpecifier5341 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5362 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleStringTypeSpecifier5374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier5412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTypeSpecifier5422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymbolReference_in_ruleNamedTypeSpecifier5468 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleNamedTypeSpecifier5479 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5500 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedTypeSpecifier5511 = new BitSet(new long[]{0x0F50A040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5532 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleNamedTypeSpecifier5544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification5582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayDimensionSpecification5592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleArrayDimensionSpecification5635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5676 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleArrayDimensionSpecification5696 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitTypeSpecifier_in_entryRuleUnitTypeSpecifier5756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitTypeSpecifier5766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleUnitTypeSpecifier5810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression5846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression5930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression5975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleConditionalExpression6010 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression6031 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression6042 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression6063 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_27_in_ruleConditionalExpression6075 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpression6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase6132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpressionCase6142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6188 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleConditionalExpressionCase6198 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression6255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression6265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6312 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRangeExpression6331 = new BitSet(new long[]{0x0F508040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6352 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRangeExpression6372 = new BitSet(new long[]{0x0F508040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression6433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6490 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLogicalOrExpression6510 = new BitSet(new long[]{0x0F508040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6531 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression6581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6628 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleLogicalAndExpression6648 = new BitSet(new long[]{0x0F508040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6669 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleLogicalNotExpression6791 = new BitSet(new long[]{0x0F408040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression6859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression6906 = new BitSet(new long[]{0x0020000000000002L,0x000000000000003FL});
    public static final BitSet FOLLOW_53_in_ruleRelationalExpression6935 = new BitSet(new long[]{0x03001F2000000010L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6998 = new BitSet(new long[]{0x0F408040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression7019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression7059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddSubtractExpression7069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression7116 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAddSubtractExpressionPart_in_ruleAddSubtractExpression7146 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAddSubtractExpressionPart_in_entryRuleAddSubtractExpressionPart7185 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddSubtractExpressionPart7195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpressionPart7241 = new BitSet(new long[]{0x0F408040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpressionPart7262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression7298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyDivideExpression7308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression7355 = new BitSet(new long[]{0x6000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpressionPart_in_ruleMultiplyDivideExpression7385 = new BitSet(new long[]{0x6000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpressionPart_in_entryRuleMultiplyDivideExpressionPart7424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyDivideExpressionPart7434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpressionPart7480 = new BitSet(new long[]{0x0F408040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpressionPart7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression7537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression7547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7594 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression7624 = new BitSet(new long[]{0x0F408040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression7683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryMinusExpression7693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnaryMinusExpression7765 = new BitSet(new long[]{0x0F008040002000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall7823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall7833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleFeatureCall7880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall7908 = new BitSet(new long[]{0x0080004000200002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall7938 = new BitSet(new long[]{0x0080004000200002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart7978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallPart7988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_ruleFeatureCallPart8035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementReference_in_ruleFeatureCallPart8062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_ruleFeatureCallPart8089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference8124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureReference8134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFeatureReference8169 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureReference8188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureReference8209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementReference_in_entryRuleArrayElementReference8261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayElementReference8271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleArrayElementReference8306 = new BitSet(new long[]{0x0F528040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayElementReference8327 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_16_in_ruleArrayElementReference8338 = new BitSet(new long[]{0x0F528040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayElementReference8359 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_39_in_ruleArrayElementReference8371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_entryRuleOperationCall8407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCall8417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOperationCall8461 = new BitSet(new long[]{0x0F508040026000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall8483 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_16_in_ruleOperationCall8494 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall8515 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_22_in_ruleOperationCall8529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression8565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallablePrimaryExpression8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_ruleCallablePrimaryExpression8622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymbolReference_in_ruleCallablePrimaryExpression8649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression8711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression8721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression8768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression8795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression8822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression8849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral8884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral8894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_ruleLiteral8941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral8968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral8995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral9030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalLiteral9040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral9087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral9114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral9149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral9159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral9201 = new BitSet(new long[]{0x0100000000200002L});
    public static final BitSet FOLLOW_56_in_ruleRealLiteral9224 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleRealLiteral9249 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral9270 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleRealLiteral9280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral9318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral9328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral9370 = new BitSet(new long[]{0x0100000000200002L});
    public static final BitSet FOLLOW_56_in_ruleIntegerLiteral9393 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleIntegerLiteral9418 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral9439 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleIntegerLiteral9449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral9487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral9497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral9542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral9577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral9587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral9628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleQualifiedName9724 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQualifiedName9735 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleQualifiedName9756 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_ruleSymbolReference_in_entryRuleSymbolReference9794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSymbolReference9804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSymbolReference9847 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSymbolReference9882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubscript_in_entryRuleSubscript9918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubscript9928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleSubscript9971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubscript10011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator10047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixConstructionOperator10057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleMatrixConstructionOperator10092 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10113 = new BitSet(new long[]{0x0000008000040000L});
    public static final BitSet FOLLOW_18_in_ruleMatrixConstructionOperator10124 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10145 = new BitSet(new long[]{0x0000008000040000L});
    public static final BitSet FOLLOW_39_in_ruleMatrixConstructionOperator10157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList10193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList10203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10249 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionList10260 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10281 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitConstructionOperator10329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleUnitConstructionOperator10364 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnitConstructionOperator10374 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10395 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUnitConstructionOperator10405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression10451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleParenthesizedExpression10486 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10507 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParenthesizedExpression10517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression10563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleBeginExpression10607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression10643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression10653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleEndExpression10697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression10743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleUnitExpression10786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUnitExpression10816 = new BitSet(new long[]{0x0F508040022000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleUnitExpression10837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10866 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnitExpression10877 = new BitSet(new long[]{0x0100000000200010L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator10937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator10947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator10989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11022 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleUnitExpressionNumerator11033 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11054 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleUnitExpressionDenominator11166 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11187 = new BitSet(new long[]{0x4000000000400000L});
    public static final BitSet FOLLOW_62_in_ruleUnitExpressionDenominator11198 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11219 = new BitSet(new long[]{0x4000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUnitExpressionDenominator11231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor11278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleUnitExpressionFactor11324 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleUnitExpressionFactor11335 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent11404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnitExpressionExponent11447 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_entryRuleKeywordID11520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordID11531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordID11571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleKeywordID11595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleRelationalOperator11647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleRelationalOperator11662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleRelationalOperator11677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleRelationalOperator11692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRelationalOperator11707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleRelationalOperator11722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAddSubtractOperator11765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAddSubtractOperator11780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleMultiplyDivideOperator11823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleMultiplyDivideOperator11838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleMultiplyDivideOperator11853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplyDivideOperator11868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rulePowerOperator11911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rulePowerOperator11926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleBooleanKind11969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleBooleanKind11984 = new BitSet(new long[]{0x0000000000000002L});

}