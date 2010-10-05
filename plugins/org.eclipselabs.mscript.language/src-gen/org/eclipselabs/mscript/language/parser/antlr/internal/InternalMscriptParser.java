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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'enum'", "','", "'record'", "';'", "'static'", "'('", "')'", "'ref'", "'='", "'if'", "'elseif'", "'else'", "'while'", "'do'", "'foreach'", "'in'", "'auto'", "'const'", "'typedef'", "'as'", "'return'", "'real'", "'['", "']'", "'int'", "'complex'", "'gauss'", "'bool'", "'string'", "'type'", "'?'", "'..'", "'unit'", "'then'", "':'", "'or'", "'and'", "'not'", "'is'", "'-'", "'.'", "'j'", "'::'", "'begin'", "'end'", "'eval'", "'/'", "'*'", "'^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'<>'", "'+'", "'.*'", "'./'", "'.^'", "'false'", "'true'"
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

                if ( (LA2_0==RULE_ID||LA2_0==12||LA2_0==15||LA2_0==17||LA2_0==19||(LA2_0>=31 && LA2_0<=33)||LA2_0==36||(LA2_0>=39 && LA2_0<=44)||LA2_0==47||LA2_0==56) ) {
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

                if ( (LA3_4==RULE_ID||LA3_4==56) ) {
                    alt3=4;
                }
                else if ( (LA3_4==36||(LA3_4>=39 && LA3_4<=44)||LA3_4==47) ) {
                    alt3=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition | this_RecordDefinition_2= ruleRecordDefinition | this_FunctionDefinition_3= ruleFunctionDefinition | this_TypeDefinition_4= ruleTypeDefinition | this_VariableDeclaration_5= ruleVariableDeclaration )", 3, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 56:
                {
                alt3=4;
                }
                break;
            case 33:
                {
                alt3=5;
                }
                break;
            case 31:
            case 32:
            case 36:
            case 39:
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

                if ( (LA6_0==36||(LA6_0>=39 && LA6_0<=44)) ) {
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:690:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? ( (lv_name_1_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_body_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:695:6: ( ( ( (lv_static_0_0= 'static' ) )? ( (lv_name_1_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:1: ( ( (lv_static_0_0= 'static' ) )? ( (lv_name_1_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:1: ( ( (lv_static_0_0= 'static' ) )? ( (lv_name_1_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:696:2: ( (lv_static_0_0= 'static' ) )? ( (lv_name_1_0= ruleKeywordID ) ) '(' ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )? ')' ( (lv_body_7_0= ruleBlock ) )
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:717:3: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:718:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:718:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:719:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleFunctionDefinition1286);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
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

            match(input,20,FOLLOW_20_in_ruleFunctionDefinition1296); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:745:1: ( ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19||LA10_0==22||(LA10_0>=31 && LA10_0<=32)||LA10_0==36||(LA10_0>=39 && LA10_0<=44)||LA10_0==47) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:745:2: ( (lv_parameters_3_0= ruleParameterDeclaration ) ) ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:745:2: ( (lv_parameters_3_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:746:1: (lv_parameters_3_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:746:1: (lv_parameters_3_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:747:3: lv_parameters_3_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterDeclarationParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1318);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:769:2: ( ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==16) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:769:4: ',' ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionDefinition1329); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:773:1: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:774:1: (lv_parameters_5_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:774:1: (lv_parameters_5_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:775:3: lv_parameters_5_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterDeclarationParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1350);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,21,FOLLOW_21_in_ruleFunctionDefinition1364); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:801:1: ( (lv_body_7_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:802:1: (lv_body_7_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:802:1: (lv_body_7_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:803:3: lv_body_7_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunctionDefinition1385);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:833:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:834:2: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:835:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1421);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();
            _fsp--;

             current =iv_ruleParameterDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterDeclaration1431); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:842:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_reference_1_0=null;
        EObject lv_modifier_0_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:847:6: ( ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:848:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:848:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:848:2: ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_reference_1_0= 'ref' ) )? ( (lv_type_2_0= ruleTypeSpecifier ) ) ( (lv_name_3_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:848:2: ( (lv_modifier_0_0= ruleVariableModifier ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19||(LA11_0>=31 && LA11_0<=32)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:849:1: (lv_modifier_0_0= ruleVariableModifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:849:1: (lv_modifier_0_0= ruleVariableModifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:850:3: lv_modifier_0_0= ruleVariableModifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getModifierVariableModifierParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableModifier_in_ruleParameterDeclaration1477);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:872:3: ( (lv_reference_1_0= 'ref' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:873:1: (lv_reference_1_0= 'ref' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:873:1: (lv_reference_1_0= 'ref' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:874:3: lv_reference_1_0= 'ref'
                    {
                    lv_reference_1_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleParameterDeclaration1496); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:893:3: ( (lv_type_2_0= ruleTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:894:1: (lv_type_2_0= ruleTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:894:1: (lv_type_2_0= ruleTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:895:3: lv_type_2_0= ruleTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeSpecifierParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeSpecifier_in_ruleParameterDeclaration1531);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:917:2: ( (lv_name_3_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:918:1: (lv_name_3_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:918:1: (lv_name_3_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:919:3: lv_name_3_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getNameKeywordIDParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleParameterDeclaration1552);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:949:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:950:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:951:2: iv_ruleStatement= ruleStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement1588);
            iv_ruleStatement=ruleStatement();
            _fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement1598); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:958:1: ruleStatement returns [EObject current=null] : (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement ) ;
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
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:963:6: ( (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )
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
            case 20:
            case 37:
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

                if ( (LA13_3==20) ) {
                    alt13=2;
                }
                else if ( (LA13_3==RULE_ID||LA13_3==56) ) {
                    alt13=8;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("964:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            case 24:
                {
                alt13=3;
                }
                break;
            case 27:
                {
                alt13=4;
                }
                break;
            case 28:
                {
                alt13=5;
                }
                break;
            case 29:
                {
                alt13=6;
                }
                break;
            case 33:
                {
                alt13=7;
                }
                break;
            case 19:
            case 31:
            case 32:
            case 36:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt13=8;
                }
                break;
            case 35:
                {
                alt13=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("964:1: (this_Block_0= ruleBlock | this_FeatureCallStatement_1= ruleFeatureCallStatement | this_IfStatement_2= ruleIfStatement | this_WhileStatement_3= ruleWhileStatement | this_DoWhileStatement_4= ruleDoWhileStatement | this_ForeachStatement_5= ruleForeachStatement | this_TypeDefinition_6= ruleTypeDefinition | this_VariableDeclaration_7= ruleVariableDeclaration | this_ReturnStatement_8= ruleReturnStatement )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:965:5: this_Block_0= ruleBlock
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1645);
                    this_Block_0=ruleBlock();
                    _fsp--;

                     
                            current = this_Block_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:975:5: this_FeatureCallStatement_1= ruleFeatureCallStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getFeatureCallStatementParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCallStatement_in_ruleStatement1672);
                    this_FeatureCallStatement_1=ruleFeatureCallStatement();
                    _fsp--;

                     
                            current = this_FeatureCallStatement_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:985:5: this_IfStatement_2= ruleIfStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement1699);
                    this_IfStatement_2=ruleIfStatement();
                    _fsp--;

                     
                            current = this_IfStatement_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:995:5: this_WhileStatement_3= ruleWhileStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1726);
                    this_WhileStatement_3=ruleWhileStatement();
                    _fsp--;

                     
                            current = this_WhileStatement_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1005:5: this_DoWhileStatement_4= ruleDoWhileStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getDoWhileStatementParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoWhileStatement_in_ruleStatement1753);
                    this_DoWhileStatement_4=ruleDoWhileStatement();
                    _fsp--;

                     
                            current = this_DoWhileStatement_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1015:5: this_ForeachStatement_5= ruleForeachStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getForeachStatementParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleForeachStatement_in_ruleStatement1780);
                    this_ForeachStatement_5=ruleForeachStatement();
                    _fsp--;

                     
                            current = this_ForeachStatement_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1025:5: this_TypeDefinition_6= ruleTypeDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getTypeDefinitionParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleStatement1807);
                    this_TypeDefinition_6=ruleTypeDefinition();
                    _fsp--;

                     
                            current = this_TypeDefinition_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1035:5: this_VariableDeclaration_7= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStatement1834);
                    this_VariableDeclaration_7=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_7; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1045:5: this_ReturnStatement_8= ruleReturnStatement
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_8(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement1861);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1061:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1062:2: (iv_ruleBlock= ruleBlock EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1063:2: iv_ruleBlock= ruleBlock EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBlockRule(), currentNode); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock1896);
            iv_ruleBlock=ruleBlock();
            _fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock1906); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1070:1: ruleBlock returns [EObject current=null] : ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1075:6: ( ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1076:1: ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1076:1: ( () '{' ( (lv_statements_2_0= ruleStatement ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1076:2: () '{' ( (lv_statements_2_0= ruleStatement ) )* '}'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1076:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1077:5: 
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

            match(input,13,FOLLOW_13_in_ruleBlock1950); 

                    createLeafNode(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1091:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_ID && LA14_0<=RULE_STRING)||LA14_0==13||(LA14_0>=19 && LA14_0<=20)||LA14_0==24||(LA14_0>=27 && LA14_0<=29)||(LA14_0>=31 && LA14_0<=33)||(LA14_0>=35 && LA14_0<=37)||(LA14_0>=39 && LA14_0<=44)||LA14_0==47||(LA14_0>=56 && LA14_0<=59)||(LA14_0>=74 && LA14_0<=75)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1092:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1092:1: (lv_statements_2_0= ruleStatement )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1093:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock1971);
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

            match(input,14,FOLLOW_14_in_ruleBlock1982); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1127:1: entryRuleFeatureCallStatement returns [EObject current=null] : iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF ;
    public final EObject entryRuleFeatureCallStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1128:2: (iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1129:2: iv_ruleFeatureCallStatement= ruleFeatureCallStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallStatement_in_entryRuleFeatureCallStatement2018);
            iv_ruleFeatureCallStatement=ruleFeatureCallStatement();
            _fsp--;

             current =iv_ruleFeatureCallStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallStatement2028); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1136:1: ruleFeatureCallStatement returns [EObject current=null] : ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' ) ;
    public final EObject ruleFeatureCallStatement() throws RecognitionException {
        EObject current = null;

        Token lv_assignment_1_0=null;
        EObject lv_featureCall_0_0 = null;

        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1141:6: ( ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1142:1: ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1142:1: ( ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1142:2: ( (lv_featureCall_0_0= ruleFeatureCall ) ) ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )? ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1142:2: ( (lv_featureCall_0_0= ruleFeatureCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1143:1: (lv_featureCall_0_0= ruleFeatureCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1143:1: (lv_featureCall_0_0= ruleFeatureCall )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1144:3: lv_featureCall_0_0= ruleFeatureCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFeatureCallStatementAccess().getFeatureCallFeatureCallParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFeatureCall_in_ruleFeatureCallStatement2074);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1166:2: ( ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1166:3: ( (lv_assignment_1_0= '=' ) ) ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1166:3: ( (lv_assignment_1_0= '=' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1167:1: (lv_assignment_1_0= '=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1167:1: (lv_assignment_1_0= '=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1168:3: lv_assignment_1_0= '='
                    {
                    lv_assignment_1_0=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleFeatureCallStatement2093); 

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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1187:2: ( (lv_expression_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1188:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1188:1: (lv_expression_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1189:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallStatementAccess().getExpressionExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCallStatement2127);
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

            match(input,18,FOLLOW_18_in_ruleFeatureCallStatement2139); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1223:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1224:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1225:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement2175);
            iv_ruleIfStatement=ruleIfStatement();
            _fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement2185); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1232:1: ruleIfStatement returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseBody_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1237:6: ( ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1238:1: ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1238:1: ( 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1238:3: 'if' ( (lv_cases_1_0= ruleIfCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )* ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )?
            {
            match(input,24,FOLLOW_24_in_ruleIfStatement2220); 

                    createLeafNode(grammarAccess.getIfStatementAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1242:1: ( (lv_cases_1_0= ruleIfCase ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1243:1: (lv_cases_1_0= ruleIfCase )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1243:1: (lv_cases_1_0= ruleIfCase )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1244:3: lv_cases_1_0= ruleIfCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getCasesIfCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleIfCase_in_ruleIfStatement2241);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1266:2: ( 'elseif' ( (lv_cases_3_0= ruleIfCase ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1266:4: 'elseif' ( (lv_cases_3_0= ruleIfCase ) )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleIfStatement2252); 

            	            createLeafNode(grammarAccess.getIfStatementAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1270:1: ( (lv_cases_3_0= ruleIfCase ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1271:1: (lv_cases_3_0= ruleIfCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1271:1: (lv_cases_3_0= ruleIfCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1272:3: lv_cases_3_0= ruleIfCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getCasesIfCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleIfCase_in_ruleIfStatement2273);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1294:4: ( 'else' ( (lv_elseBody_5_0= ruleBlock ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1294:6: 'else' ( (lv_elseBody_5_0= ruleBlock ) )
                    {
                    match(input,26,FOLLOW_26_in_ruleIfStatement2286); 

                            createLeafNode(grammarAccess.getIfStatementAccess().getElseKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1298:1: ( (lv_elseBody_5_0= ruleBlock ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1299:1: (lv_elseBody_5_0= ruleBlock )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1299:1: (lv_elseBody_5_0= ruleBlock )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1300:3: lv_elseBody_5_0= ruleBlock
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIfStatementAccess().getElseBodyBlockParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement2307);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1330:1: entryRuleIfCase returns [EObject current=null] : iv_ruleIfCase= ruleIfCase EOF ;
    public final EObject entryRuleIfCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1331:2: (iv_ruleIfCase= ruleIfCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:2: iv_ruleIfCase= ruleIfCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfCase_in_entryRuleIfCase2345);
            iv_ruleIfCase=ruleIfCase();
            _fsp--;

             current =iv_ruleIfCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfCase2355); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1339:1: ruleIfCase returns [EObject current=null] : ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) ) ;
    public final EObject ruleIfCase() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_body_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1344:6: ( ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1345:1: ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1345:1: ( ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1345:2: ( (lv_condition_0_0= ruleExpression ) ) ( (lv_body_1_0= ruleBlock ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1345:2: ( (lv_condition_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1346:1: (lv_condition_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1346:1: (lv_condition_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1347:3: lv_condition_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfCaseAccess().getConditionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfCase2401);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1369:2: ( (lv_body_1_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1370:1: (lv_body_1_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1370:1: (lv_body_1_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1371:3: lv_body_1_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfCaseAccess().getBodyBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfCase2422);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1401:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1402:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1403:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhileStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement2458);
            iv_ruleWhileStatement=ruleWhileStatement();
            _fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement2468); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1410:1: ruleWhileStatement returns [EObject current=null] : ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        EObject lv_body_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1415:6: ( ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1416:1: ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1416:1: ( 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1416:3: 'while' ( (lv_predicate_1_0= ruleExpression ) ) ( (lv_body_2_0= ruleBlock ) )
            {
            match(input,27,FOLLOW_27_in_ruleWhileStatement2503); 

                    createLeafNode(grammarAccess.getWhileStatementAccess().getWhileKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1420:1: ( (lv_predicate_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1421:1: (lv_predicate_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1421:1: (lv_predicate_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1422:3: lv_predicate_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileStatement2524);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1444:2: ( (lv_body_2_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1445:1: (lv_body_2_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1445:1: (lv_body_2_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1446:3: lv_body_2_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement2545);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1476:1: entryRuleDoWhileStatement returns [EObject current=null] : iv_ruleDoWhileStatement= ruleDoWhileStatement EOF ;
    public final EObject entryRuleDoWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoWhileStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1477:2: (iv_ruleDoWhileStatement= ruleDoWhileStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1478:2: iv_ruleDoWhileStatement= ruleDoWhileStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoWhileStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoWhileStatement_in_entryRuleDoWhileStatement2581);
            iv_ruleDoWhileStatement=ruleDoWhileStatement();
            _fsp--;

             current =iv_ruleDoWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoWhileStatement2591); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1485:1: ruleDoWhileStatement returns [EObject current=null] : ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleDoWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_body_1_0 = null;

        EObject lv_predicate_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:6: ( ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:1: ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:1: ( 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:3: 'do' ( (lv_body_1_0= ruleBlock ) ) 'while' ( (lv_predicate_3_0= ruleExpression ) ) ';'
            {
            match(input,28,FOLLOW_28_in_ruleDoWhileStatement2626); 

                    createLeafNode(grammarAccess.getDoWhileStatementAccess().getDoKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1495:1: ( (lv_body_1_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1496:1: (lv_body_1_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1496:1: (lv_body_1_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1497:3: lv_body_1_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoWhileStatementAccess().getBodyBlockParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleDoWhileStatement2647);
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

            match(input,27,FOLLOW_27_in_ruleDoWhileStatement2657); 

                    createLeafNode(grammarAccess.getDoWhileStatementAccess().getWhileKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1523:1: ( (lv_predicate_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1524:1: (lv_predicate_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1524:1: (lv_predicate_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1525:3: lv_predicate_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoWhileStatementAccess().getPredicateExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleDoWhileStatement2678);
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

            match(input,18,FOLLOW_18_in_ruleDoWhileStatement2688); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1559:1: entryRuleForeachStatement returns [EObject current=null] : iv_ruleForeachStatement= ruleForeachStatement EOF ;
    public final EObject entryRuleForeachStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeachStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1560:2: (iv_ruleForeachStatement= ruleForeachStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1561:2: iv_ruleForeachStatement= ruleForeachStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getForeachStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleForeachStatement_in_entryRuleForeachStatement2724);
            iv_ruleForeachStatement=ruleForeachStatement();
            _fsp--;

             current =iv_ruleForeachStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForeachStatement2734); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1568:1: ruleForeachStatement returns [EObject current=null] : ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) ) ;
    public final EObject ruleForeachStatement() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_elementName_1_0 = null;

        EObject lv_collectionExpression_3_0 = null;

        EObject lv_body_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1573:6: ( ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1574:1: ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1574:1: ( 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1574:3: 'foreach' ( (lv_elementName_1_0= ruleKeywordID ) ) 'in' ( (lv_collectionExpression_3_0= ruleExpression ) ) ( (lv_body_4_0= ruleBlock ) )
            {
            match(input,29,FOLLOW_29_in_ruleForeachStatement2769); 

                    createLeafNode(grammarAccess.getForeachStatementAccess().getForeachKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1578:1: ( (lv_elementName_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1579:1: (lv_elementName_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1579:1: (lv_elementName_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1580:3: lv_elementName_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getForeachStatementAccess().getElementNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleForeachStatement2790);
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

            match(input,30,FOLLOW_30_in_ruleForeachStatement2800); 

                    createLeafNode(grammarAccess.getForeachStatementAccess().getInKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1606:1: ( (lv_collectionExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1607:1: (lv_collectionExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1607:1: (lv_collectionExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1608:3: lv_collectionExpression_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getForeachStatementAccess().getCollectionExpressionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleForeachStatement2821);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1630:2: ( (lv_body_4_0= ruleBlock ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1631:1: (lv_body_4_0= ruleBlock )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1631:1: (lv_body_4_0= ruleBlock )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1632:3: lv_body_4_0= ruleBlock
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getForeachStatementAccess().getBodyBlockParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleForeachStatement2842);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1662:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1663:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1664:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2878);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2888); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1671:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_items_2_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) ) )* ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_modifier_0_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1676:6: ( ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_items_2_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) ) )* ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1677:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_items_2_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) ) )* ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1677:1: ( ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_items_2_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) ) )* ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1677:2: ( (lv_modifier_0_0= ruleVariableModifier ) )? ( (lv_type_1_0= ruleTypeSpecifier ) ) ( (lv_items_2_0= ruleVariableDeclarationItem ) ) ( ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) ) )* ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1677:2: ( (lv_modifier_0_0= ruleVariableModifier ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19||(LA18_0>=31 && LA18_0<=32)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1678:1: (lv_modifier_0_0= ruleVariableModifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1678:1: (lv_modifier_0_0= ruleVariableModifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1679:3: lv_modifier_0_0= ruleVariableModifier
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getModifierVariableModifierParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableModifier_in_ruleVariableDeclaration2934);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1701:3: ( (lv_type_1_0= ruleTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1702:1: (lv_type_1_0= ruleTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1702:1: (lv_type_1_0= ruleTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1703:3: lv_type_1_0= ruleTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeSpecifierParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeSpecifier_in_ruleVariableDeclaration2956);
            lv_type_1_0=ruleTypeSpecifier();
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
            	        		"TypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1725:2: ( (lv_items_2_0= ruleVariableDeclarationItem ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1726:1: (lv_items_2_0= ruleVariableDeclarationItem )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1726:1: (lv_items_2_0= ruleVariableDeclarationItem )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1727:3: lv_items_2_0= ruleVariableDeclarationItem
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getItemsVariableDeclarationItemParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration2977);
            lv_items_2_0=ruleVariableDeclarationItem();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"items",
            	        		lv_items_2_0, 
            	        		"VariableDeclarationItem", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1749:2: ( ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==16) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1749:4: ',' ( (lv_items_4_0= ruleVariableDeclarationItem ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleVariableDeclaration2988); 

            	            createLeafNode(grammarAccess.getVariableDeclarationAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1753:1: ( (lv_items_4_0= ruleVariableDeclarationItem ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1754:1: (lv_items_4_0= ruleVariableDeclarationItem )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1754:1: (lv_items_4_0= ruleVariableDeclarationItem )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1755:3: lv_items_4_0= ruleVariableDeclarationItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getItemsVariableDeclarationItemParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration3009);
            	    lv_items_4_0=ruleVariableDeclarationItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_4_0, 
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
            	    break loop19;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleVariableDeclaration3021); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1789:1: entryRuleVariableModifier returns [EObject current=null] : iv_ruleVariableModifier= ruleVariableModifier EOF ;
    public final EObject entryRuleVariableModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableModifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1790:2: (iv_ruleVariableModifier= ruleVariableModifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1791:2: iv_ruleVariableModifier= ruleVariableModifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableModifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableModifier_in_entryRuleVariableModifier3057);
            iv_ruleVariableModifier=ruleVariableModifier();
            _fsp--;

             current =iv_ruleVariableModifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableModifier3067); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1798:1: ruleVariableModifier returns [EObject current=null] : ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) ) ;
    public final EObject ruleVariableModifier() throws RecognitionException {
        EObject current = null;

        Token lv_Auto_0_0=null;
        Token lv_Constant_1_0=null;
        Token lv_Static_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1803:6: ( ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1804:1: ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1804:1: ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt20=1;
                }
                break;
            case 32:
                {
                alt20=2;
                }
                break;
            case 19:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1804:1: ( ( (lv_Auto_0_0= 'auto' ) ) | ( (lv_Constant_1_0= 'const' ) ) | ( (lv_Static_2_0= 'static' ) ) )", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1804:2: ( (lv_Auto_0_0= 'auto' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1804:2: ( (lv_Auto_0_0= 'auto' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1805:1: (lv_Auto_0_0= 'auto' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1805:1: (lv_Auto_0_0= 'auto' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1806:3: lv_Auto_0_0= 'auto'
                    {
                    lv_Auto_0_0=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleVariableModifier3110); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1826:6: ( (lv_Constant_1_0= 'const' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1826:6: ( (lv_Constant_1_0= 'const' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1827:1: (lv_Constant_1_0= 'const' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1827:1: (lv_Constant_1_0= 'const' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1828:3: lv_Constant_1_0= 'const'
                    {
                    lv_Constant_1_0=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_ruleVariableModifier3147); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1848:6: ( (lv_Static_2_0= 'static' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1848:6: ( (lv_Static_2_0= 'static' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1849:1: (lv_Static_2_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1849:1: (lv_Static_2_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1850:3: lv_Static_2_0= 'static'
                    {
                    lv_Static_2_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleVariableModifier3184); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1877:1: entryRuleVariableDeclarationItem returns [EObject current=null] : iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF ;
    public final EObject entryRuleVariableDeclarationItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationItem = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1878:2: (iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1879:2: iv_ruleVariableDeclarationItem= ruleVariableDeclarationItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationItemRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclarationItem_in_entryRuleVariableDeclarationItem3233);
            iv_ruleVariableDeclarationItem=ruleVariableDeclarationItem();
            _fsp--;

             current =iv_ruleVariableDeclarationItem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationItem3243); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1886:1: ruleVariableDeclarationItem returns [EObject current=null] : ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationItem() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_initialValue_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1891:6: ( ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1892:1: ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1892:1: ( ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1892:2: ( (lv_name_0_0= ruleKeywordID ) ) ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1892:2: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1893:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1893:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1894:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationItemAccess().getNameKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleVariableDeclarationItem3289);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1916:2: ( '=' ( (lv_initialValue_2_0= ruleExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1916:4: '=' ( (lv_initialValue_2_0= ruleExpression ) )
                    {
                    match(input,23,FOLLOW_23_in_ruleVariableDeclarationItem3300); 

                            createLeafNode(grammarAccess.getVariableDeclarationItemAccess().getEqualsSignKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1920:1: ( (lv_initialValue_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1921:1: (lv_initialValue_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1921:1: (lv_initialValue_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:3: lv_initialValue_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationItemAccess().getInitialValueExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclarationItem3321);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1952:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1953:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1954:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition3359);
            iv_ruleTypeDefinition=ruleTypeDefinition();
            _fsp--;

             current =iv_ruleTypeDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition3369); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1961:1: ruleTypeDefinition returns [EObject current=null] : ( 'typedef' ( (lv_type_1_0= ruleDataTypeSpecifier ) ) 'as' ( (lv_name_3_0= ruleKeywordID ) ) ';' ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1966:6: ( ( 'typedef' ( (lv_type_1_0= ruleDataTypeSpecifier ) ) 'as' ( (lv_name_3_0= ruleKeywordID ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1967:1: ( 'typedef' ( (lv_type_1_0= ruleDataTypeSpecifier ) ) 'as' ( (lv_name_3_0= ruleKeywordID ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1967:1: ( 'typedef' ( (lv_type_1_0= ruleDataTypeSpecifier ) ) 'as' ( (lv_name_3_0= ruleKeywordID ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1967:3: 'typedef' ( (lv_type_1_0= ruleDataTypeSpecifier ) ) 'as' ( (lv_name_3_0= ruleKeywordID ) ) ';'
            {
            match(input,33,FOLLOW_33_in_ruleTypeDefinition3404); 

                    createLeafNode(grammarAccess.getTypeDefinitionAccess().getTypedefKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1971:1: ( (lv_type_1_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1972:1: (lv_type_1_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1972:1: (lv_type_1_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1973:3: lv_type_1_0= ruleDataTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeDefinitionAccess().getTypeDataTypeSpecifierParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleTypeDefinition3425);
            lv_type_1_0=ruleDataTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"DataTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,34,FOLLOW_34_in_ruleTypeDefinition3435); 

                    createLeafNode(grammarAccess.getTypeDefinitionAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1999:1: ( (lv_name_3_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2000:1: (lv_name_3_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2000:1: (lv_name_3_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2001:3: lv_name_3_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeDefinitionAccess().getNameKeywordIDParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleTypeDefinition3456);
            lv_name_3_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeDefinitionRule().getType().getClassifier());
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

            match(input,18,FOLLOW_18_in_ruleTypeDefinition3466); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2035:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2036:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2037:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReturnStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement3502);
            iv_ruleReturnStatement=ruleReturnStatement();
            _fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement3512); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2044:1: ruleReturnStatement returns [EObject current=null] : ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2049:6: ( ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2050:1: ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2050:1: ( 'return' ( (lv_value_1_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2050:3: 'return' ( (lv_value_1_0= ruleExpression ) ) ';'
            {
            match(input,35,FOLLOW_35_in_ruleReturnStatement3547); 

                    createLeafNode(grammarAccess.getReturnStatementAccess().getReturnKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2054:1: ( (lv_value_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2055:1: (lv_value_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2055:1: (lv_value_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2056:3: lv_value_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReturnStatementAccess().getValueExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement3568);
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

            match(input,18,FOLLOW_18_in_ruleReturnStatement3578); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2090:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2091:2: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2092:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeSpecifier_in_entryRuleTypeSpecifier3614);
            iv_ruleTypeSpecifier=ruleTypeSpecifier();
            _fsp--;

             current =iv_ruleTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeSpecifier3624); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2099:1: ruleTypeSpecifier returns [EObject current=null] : (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeSpecifier_0 = null;

        EObject this_UnitTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2104:6: ( (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2105:1: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2105:1: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36||(LA22_0>=39 && LA22_0<=44)) ) {
                alt22=1;
            }
            else if ( (LA22_0==47) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2105:1: (this_DataTypeSpecifier_0= ruleDataTypeSpecifier | this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2106:5: this_DataTypeSpecifier_0= ruleDataTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeSpecifierAccess().getDataTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleTypeSpecifier3671);
                    this_DataTypeSpecifier_0=ruleDataTypeSpecifier();
                    _fsp--;

                     
                            current = this_DataTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2116:5: this_UnitTypeSpecifier_1= ruleUnitTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeSpecifierAccess().getUnitTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnitTypeSpecifier_in_ruleTypeSpecifier3698);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2132:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2133:2: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2134:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier3733);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();
            _fsp--;

             current =iv_ruleDataTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeSpecifier3743); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2141:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeSpecifier_0 = null;

        EObject this_NamedTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2146:6: ( (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2147:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2147:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36||(LA23_0>=39 && LA23_0<=43)) ) {
                alt23=1;
            }
            else if ( (LA23_0==44) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2147:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2148:5: this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPrimitiveTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier3790);
                    this_PrimitiveTypeSpecifier_0=rulePrimitiveTypeSpecifier();
                    _fsp--;

                     
                            current = this_PrimitiveTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2158:5: this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getNamedTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier3817);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2174:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2175:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2176:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier3852);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();
            _fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier3862); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2183:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2188:6: ( (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2189:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2189:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 36:
            case 39:
            case 40:
            case 41:
                {
                alt24=1;
                }
                break;
            case 42:
                {
                alt24=2;
                }
                break;
            case 43:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2189:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2190:5: this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericalTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier3909);
                    this_NumericalTypeSpecifier_0=ruleNumericalTypeSpecifier();
                    _fsp--;

                     
                            current = this_NumericalTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2200:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier3936);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();
                    _fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2210:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier3963);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2226:1: entryRuleNumericalTypeSpecifier returns [EObject current=null] : iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF ;
    public final EObject entryRuleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2227:2: (iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2228:2: iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier3998);
            iv_ruleNumericalTypeSpecifier=ruleNumericalTypeSpecifier();
            _fsp--;

             current =iv_ruleNumericalTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier4008); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2235:1: ruleNumericalTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) ;
    public final EObject ruleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;

        EObject this_ComplexTypeSpecifier_2 = null;

        EObject this_GaussianTypeSpecifier_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2240:6: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2241:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2241:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt25=1;
                }
                break;
            case 39:
                {
                alt25=2;
                }
                break;
            case 40:
                {
                alt25=3;
                }
                break;
            case 41:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2241:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2242:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier4055);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();
                    _fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2252:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier4082);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();
                    _fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2262:5: this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getComplexTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericalTypeSpecifier4109);
                    this_ComplexTypeSpecifier_2=ruleComplexTypeSpecifier();
                    _fsp--;

                     
                            current = this_ComplexTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2272:5: this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getGaussianTypeSpecifierParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericalTypeSpecifier4136);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2288:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2289:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2290:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier4171);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();
            _fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier4181); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2297:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2302:6: ( ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2303:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2303:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2303:2: () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2303:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2304:5: 
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

            match(input,36,FOLLOW_36_in_ruleRealTypeSpecifier4225); 

                    createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2318:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2318:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleRealTypeSpecifier4236); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2322:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2323:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2323:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2324:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier4257);
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

                    match(input,21,FOLLOW_21_in_ruleRealTypeSpecifier4267); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2350:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==37) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2350:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleRealTypeSpecifier4280); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2354:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2355:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2355:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2356:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4301);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2378:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==16) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2378:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleRealTypeSpecifier4312); 

                    	            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2382:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2383:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2383:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2384:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4333);
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
                    	    break loop27;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleRealTypeSpecifier4345); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2418:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2419:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2420:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier4383);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();
            _fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier4393); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2427:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2432:6: ( ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2433:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2433:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2433:2: () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2433:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2434:5: 
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

            match(input,39,FOLLOW_39_in_ruleIntegerTypeSpecifier4437); 

                    createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2448:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==20) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2448:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleIntegerTypeSpecifier4448); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2452:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2453:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2453:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2454:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier4469);
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

                    match(input,21,FOLLOW_21_in_ruleIntegerTypeSpecifier4479); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2480:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2480:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleIntegerTypeSpecifier4492); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2484:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2485:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2485:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2486:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4513);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2508:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==16) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2508:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleIntegerTypeSpecifier4524); 

                    	            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2512:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2513:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2513:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2514:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4545);
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
                    	    break loop30;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleIntegerTypeSpecifier4557); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2548:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2549:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2550:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier4595);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();
            _fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier4605); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2557:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2562:6: ( ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2563:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2563:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2563:2: () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2563:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2564:5: 
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

            match(input,40,FOLLOW_40_in_ruleComplexTypeSpecifier4649); 

                    createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2578:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==20) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2578:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleComplexTypeSpecifier4660); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2582:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2583:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2583:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2584:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier4681);
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

                    match(input,21,FOLLOW_21_in_ruleComplexTypeSpecifier4691); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2610:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2610:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleComplexTypeSpecifier4704); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2614:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2615:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2615:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2616:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4725);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2638:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==16) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2638:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleComplexTypeSpecifier4736); 

                    	            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2642:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2643:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2643:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2644:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4757);
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
                    	    break loop33;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleComplexTypeSpecifier4769); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2678:1: entryRuleGaussianTypeSpecifier returns [EObject current=null] : iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF ;
    public final EObject entryRuleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGaussianTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2679:2: (iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2680:2: iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier4807);
            iv_ruleGaussianTypeSpecifier=ruleGaussianTypeSpecifier();
            _fsp--;

             current =iv_ruleGaussianTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier4817); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2687:1: ruleGaussianTypeSpecifier returns [EObject current=null] : ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2692:6: ( ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2693:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2693:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2693:2: () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2693:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2694:5: 
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

            match(input,41,FOLLOW_41_in_ruleGaussianTypeSpecifier4861); 

                    createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2708:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==20) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2708:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleGaussianTypeSpecifier4872); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2712:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2713:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2713:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2714:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier4893);
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

                    match(input,21,FOLLOW_21_in_ruleGaussianTypeSpecifier4903); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2740:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==37) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2740:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleGaussianTypeSpecifier4916); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2744:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2745:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2745:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2746:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier4937);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2768:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==16) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2768:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleGaussianTypeSpecifier4948); 

                    	            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2772:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2773:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2773:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2774:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier4969);
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
                    	    break loop36;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleGaussianTypeSpecifier4981); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2808:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2809:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2810:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier5019);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();
            _fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier5029); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2817:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2822:6: ( ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2823:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2823:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2823:2: () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2823:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2824:5: 
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

            match(input,42,FOLLOW_42_in_ruleBooleanTypeSpecifier5073); 

                    createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getBoolKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2838:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==37) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2838:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleBooleanTypeSpecifier5084); 

                            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2842:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2843:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2843:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2844:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5105);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2866:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==16) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2866:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleBooleanTypeSpecifier5116); 

                    	            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2870:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2871:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2871:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2872:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5137);
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
                    	    break loop38;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleBooleanTypeSpecifier5149); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2906:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2907:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2908:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier5187);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();
            _fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier5197); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2915:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2920:6: ( ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2921:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2921:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2921:2: () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2921:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2922:5: 
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

            match(input,43,FOLLOW_43_in_ruleStringTypeSpecifier5241); 

                    createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getStringKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2936:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==37) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2936:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleStringTypeSpecifier5252); 

                            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2940:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2941:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2941:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2942:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5273);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2964:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==16) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2964:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleStringTypeSpecifier5284); 

                    	            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2968:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2969:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2969:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2970:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5305);
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
                    	    break loop40;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleStringTypeSpecifier5317); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3004:1: entryRuleNamedTypeSpecifier returns [EObject current=null] : iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF ;
    public final EObject entryRuleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3005:2: (iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3006:2: iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier5355);
            iv_ruleNamedTypeSpecifier=ruleNamedTypeSpecifier();
            _fsp--;

             current =iv_ruleNamedTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTypeSpecifier5365); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3013:1: ruleNamedTypeSpecifier returns [EObject current=null] : ( 'type' ( (lv_typeReference_1_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_1_0 = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3018:6: ( ( 'type' ( (lv_typeReference_1_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3019:1: ( 'type' ( (lv_typeReference_1_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3019:1: ( 'type' ( (lv_typeReference_1_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3019:3: 'type' ( (lv_typeReference_1_0= ruleSymbolReference ) ) ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            match(input,44,FOLLOW_44_in_ruleNamedTypeSpecifier5400); 

                    createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3023:1: ( (lv_typeReference_1_0= ruleSymbolReference ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3024:1: (lv_typeReference_1_0= ruleSymbolReference )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3024:1: (lv_typeReference_1_0= ruleSymbolReference )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3025:3: lv_typeReference_1_0= ruleSymbolReference
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getTypeReferenceSymbolReferenceParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSymbolReference_in_ruleNamedTypeSpecifier5421);
            lv_typeReference_1_0=ruleSymbolReference();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"typeReference",
            	        		lv_typeReference_1_0, 
            	        		"SymbolReference", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3047:2: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==37) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3047:4: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleNamedTypeSpecifier5432); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3051:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3052:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3052:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3053:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5453);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3075:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==16) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3075:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleNamedTypeSpecifier5464); 

                    	            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3079:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3080:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3080:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3081:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5485);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
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
                    	    break loop42;
                        }
                    } while (true);

                    match(input,38,FOLLOW_38_in_ruleNamedTypeSpecifier5497); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getRightSquareBracketKeyword_2_3(), null); 
                        

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3115:1: entryRuleArrayDimensionSpecification returns [EObject current=null] : iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF ;
    public final EObject entryRuleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayDimensionSpecification = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3116:2: (iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3117:2: iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayDimensionSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification5535);
            iv_ruleArrayDimensionSpecification=ruleArrayDimensionSpecification();
            _fsp--;

             current =iv_ruleArrayDimensionSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayDimensionSpecification5545); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3124:1: ruleArrayDimensionSpecification returns [EObject current=null] : ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) ) ;
    public final EObject ruleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_unspecified_0_0=null;
        EObject lv_size_1_0 = null;

        EObject lv_endIndex_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3129:6: ( ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3130:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3130:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==45) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_STRING)||LA45_0==20||LA45_0==24||LA45_0==37||LA45_0==47||LA45_0==52||LA45_0==54||(LA45_0>=56 && LA45_0<=59)||(LA45_0>=74 && LA45_0<=75)) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3130:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? ) )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3130:2: ( (lv_unspecified_0_0= '?' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3130:2: ( (lv_unspecified_0_0= '?' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3131:1: (lv_unspecified_0_0= '?' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3131:1: (lv_unspecified_0_0= '?' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3132:3: lv_unspecified_0_0= '?'
                    {
                    lv_unspecified_0_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleArrayDimensionSpecification5588); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3152:6: ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3152:6: ( ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3152:7: ( (lv_size_1_0= ruleExpression ) ) ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3152:7: ( (lv_size_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3153:1: (lv_size_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3153:1: (lv_size_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3154:3: lv_size_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getSizeExpressionParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5629);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3176:2: ( () '..' ( (lv_endIndex_4_0= ruleExpression ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==46) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3176:3: () '..' ( (lv_endIndex_4_0= ruleExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3176:3: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3177:5: 
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

                            match(input,46,FOLLOW_46_in_ruleArrayDimensionSpecification5649); 

                                    createLeafNode(grammarAccess.getArrayDimensionSpecificationAccess().getFullStopFullStopKeyword_1_1_1(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3196:1: ( (lv_endIndex_4_0= ruleExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3197:1: (lv_endIndex_4_0= ruleExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3197:1: (lv_endIndex_4_0= ruleExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3198:3: lv_endIndex_4_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getEndIndexExpressionParserRuleCall_1_1_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5670);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3228:1: entryRuleUnitTypeSpecifier returns [EObject current=null] : iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF ;
    public final EObject entryRuleUnitTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3229:2: (iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3230:2: iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitTypeSpecifier_in_entryRuleUnitTypeSpecifier5709);
            iv_ruleUnitTypeSpecifier=ruleUnitTypeSpecifier();
            _fsp--;

             current =iv_ruleUnitTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitTypeSpecifier5719); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3237:1: ruleUnitTypeSpecifier returns [EObject current=null] : ( () 'unit' ) ;
    public final EObject ruleUnitTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3242:6: ( ( () 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3243:1: ( () 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3243:1: ( () 'unit' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3243:2: () 'unit'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3243:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3244:5: 
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

            match(input,47,FOLLOW_47_in_ruleUnitTypeSpecifier5763); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3266:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3267:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3268:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression5799);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression5809); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3275:1: ruleExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        EObject this_RangeExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3280:6: ( (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3281:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3281:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==24) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)||LA46_0==20||LA46_0==37||LA46_0==47||LA46_0==52||LA46_0==54||(LA46_0>=56 && LA46_0<=59)||(LA46_0>=74 && LA46_0<=75)) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3281:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3282:5: this_ConditionalExpression_0= ruleConditionalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression5856);
                    this_ConditionalExpression_0=ruleConditionalExpression();
                    _fsp--;

                     
                            current = this_ConditionalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3292:5: this_RangeExpression_1= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression5883);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3308:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3309:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3310:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5918);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression5928); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3317:1: ruleConditionalExpression returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3322:6: ( ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3323:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3323:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3323:3: 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,24,FOLLOW_24_in_ruleConditionalExpression5963); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3327:1: ( (lv_cases_1_0= ruleConditionalExpressionCase ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3328:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3328:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3329:3: lv_cases_1_0= ruleConditionalExpressionCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression5984);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3351:2: ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==25) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3351:4: 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleConditionalExpression5995); 

            	            createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3355:1: ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3356:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3356:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3357:3: lv_cases_3_0= ruleConditionalExpressionCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression6016);
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
            	    break loop47;
                }
            } while (true);

            match(input,26,FOLLOW_26_in_ruleConditionalExpression6028); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3383:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3384:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3384:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3385:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getElseExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpression6049);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3415:1: entryRuleConditionalExpressionCase returns [EObject current=null] : iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF ;
    public final EObject entryRuleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressionCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3416:2: (iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3417:2: iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase6085);
            iv_ruleConditionalExpressionCase=ruleConditionalExpressionCase();
            _fsp--;

             current =iv_ruleConditionalExpressionCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpressionCase6095); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3424:1: ruleConditionalExpressionCase returns [EObject current=null] : ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject lv_conditionExpression_0_0 = null;

        EObject lv_thenExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3429:6: ( ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3430:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3430:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3430:2: ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3430:2: ( (lv_conditionExpression_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3431:1: (lv_conditionExpression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3431:1: (lv_conditionExpression_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3432:3: lv_conditionExpression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getConditionExpressionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6141);
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

            match(input,48,FOLLOW_48_in_ruleConditionalExpressionCase6151); 

                    createLeafNode(grammarAccess.getConditionalExpressionCaseAccess().getThenKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3458:1: ( (lv_thenExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3459:1: (lv_thenExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3459:1: (lv_thenExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3460:3: lv_thenExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getThenExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6172);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3490:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3491:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3492:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression6208);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression6218); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3499:1: ruleRangeExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_end_3_0 = null;

        EObject lv_end_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3504:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3505:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3505:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3506:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6265);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3514:1: ( () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )? )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==49) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3514:2: () ':' ( (lv_end_3_0= ruleLogicalOrExpression ) ) ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3514:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3515:5: 
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

                    match(input,49,FOLLOW_49_in_ruleRangeExpression6284); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3534:1: ( (lv_end_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3535:1: (lv_end_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3535:1: (lv_end_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3536:3: lv_end_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getEndLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6305);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3558:2: ( () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==49) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3558:3: () ':' ( (lv_end_6_0= ruleLogicalOrExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3558:3: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3559:5: 
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

                            match(input,49,FOLLOW_49_in_ruleRangeExpression6325); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_1(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3578:1: ( (lv_end_6_0= ruleLogicalOrExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3579:1: (lv_end_6_0= ruleLogicalOrExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3579:1: (lv_end_6_0= ruleLogicalOrExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3580:3: lv_end_6_0= ruleLogicalOrExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getEndLogicalOrExpressionParserRuleCall_1_3_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6346);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3610:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3611:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3612:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression6386);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression6396); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3619:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3624:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3625:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3625:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3626:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6443);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3634:1: ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==50) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3634:2: () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3634:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3635:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3650:2: ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==50) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3650:4: 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,50,FOLLOW_50_in_ruleLogicalOrExpression6463); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3654:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3655:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3655:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3656:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6484);
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
                    	    if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3686:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3687:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3688:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6524);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression6534); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3695:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3700:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3701:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3701:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3702:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6581);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3710:1: ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==51) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3710:2: () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3710:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3711:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3726:2: ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==51) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3726:4: 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    {
                    	    match(input,51,FOLLOW_51_in_ruleLogicalAndExpression6601); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3730:1: ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3731:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3731:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3732:3: lv_operands_3_0= ruleLogicalNotExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsLogicalNotExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6622);
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
    // $ANTLR end ruleLogicalAndExpression


    // $ANTLR start entryRuleLogicalNotExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3762:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3763:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3764:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6662);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression6672); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3771:1: ruleLogicalNotExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3776:6: ( (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3777:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3777:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_STRING)||LA54_0==20||LA54_0==37||LA54_0==47||LA54_0==54||(LA54_0>=56 && LA54_0<=59)||(LA54_0>=74 && LA54_0<=75)) ) {
                alt54=1;
            }
            else if ( (LA54_0==52) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3777:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3778:5: this_RelationalExpression_0= ruleRelationalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6719);
                    this_RelationalExpression_0=ruleRelationalExpression();
                    _fsp--;

                     
                            current = this_RelationalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:7: () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3787:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3788:5: 
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

                    match(input,52,FOLLOW_52_in_ruleLogicalNotExpression6744); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getNotKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3802:1: ( (lv_operand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3803:1: (lv_operand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3803:1: (lv_operand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3804:3: lv_operand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6765);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3834:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3835:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3836:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6802);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression6812); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3843:1: ruleRelationalExpression returns [EObject current=null] : (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_typeTest_2_0=null;
        EObject this_AddSubtractExpression_0 = null;

        EObject lv_type_3_0 = null;

        Enumerator lv_operator_4_0 = null;

        EObject lv_rightOperand_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3848:6: ( (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3849:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3849:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3850:5: this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression6859);
            this_AddSubtractExpression_0=ruleAddSubtractExpression();
            _fsp--;

             
                    current = this_AddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3858:1: ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==53||(LA56_0>=64 && LA56_0<=69)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3858:2: () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3858:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3859:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3874:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==53) ) {
                        alt55=1;
                    }
                    else if ( ((LA55_0>=64 && LA55_0<=69)) ) {
                        alt55=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("3874:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) ) )", 55, 0, input);

                        throw nvae;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3874:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3874:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3874:4: ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3874:4: ( (lv_typeTest_2_0= 'is' ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3875:1: (lv_typeTest_2_0= 'is' )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3875:1: (lv_typeTest_2_0= 'is' )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3876:3: lv_typeTest_2_0= 'is'
                            {
                            lv_typeTest_2_0=(Token)input.LT(1);
                            match(input,53,FOLLOW_53_in_ruleRelationalExpression6888); 

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

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3895:2: ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3896:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3896:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3897:3: lv_type_3_0= ruleDataTypeSpecifier
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6922);
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
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3920:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3920:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3920:7: ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3920:7: ( (lv_operator_4_0= ruleRelationalOperator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3921:1: (lv_operator_4_0= ruleRelationalOperator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3921:1: (lv_operator_4_0= ruleRelationalOperator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3922:3: lv_operator_4_0= ruleRelationalOperator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6951);
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

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3944:2: ( (lv_rightOperand_5_0= ruleAddSubtractExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3945:1: (lv_rightOperand_5_0= ruleAddSubtractExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3945:1: (lv_rightOperand_5_0= ruleAddSubtractExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3946:3: lv_rightOperand_5_0= ruleAddSubtractExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAddSubtractExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression6972);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3976:1: entryRuleAddSubtractExpression returns [EObject current=null] : iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF ;
    public final EObject entryRuleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddSubtractExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3977:2: (iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3978:2: iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression7012);
            iv_ruleAddSubtractExpression=ruleAddSubtractExpression();
            _fsp--;

             current =iv_ruleAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddSubtractExpression7022); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3985:1: ruleAddSubtractExpression returns [EObject current=null] : (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) ;
    public final EObject ruleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplyDivideExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3990:6: ( (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3991:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3991:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3992:5: this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression7069);
            this_MultiplyDivideExpression_0=ruleMultiplyDivideExpression();
            _fsp--;

             
                    current = this_MultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4000:1: ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==54||LA58_0==70) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4000:2: () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4000:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4001:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4016:2: ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==54||LA57_0==70) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4016:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4016:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4017:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4017:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4018:3: lv_operators_2_0= ruleAddSubtractOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperatorsAddSubtractOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression7100);
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

                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4040:2: ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4041:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4041:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4042:3: lv_operands_3_0= ruleMultiplyDivideExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperandsMultiplyDivideExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression7121);
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
                    	    if ( cnt57 >= 1 ) break loop57;
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4072:1: entryRuleMultiplyDivideExpression returns [EObject current=null] : iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF ;
    public final EObject entryRuleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4073:2: (iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4074:2: iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression7161);
            iv_ruleMultiplyDivideExpression=ruleMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyDivideExpression7171); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4081:1: ruleMultiplyDivideExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) ;
    public final EObject ruleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4086:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4087:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4087:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4088:5: this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression7218);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4096:1: ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=61 && LA60_0<=62)||(LA60_0>=71 && LA60_0<=72)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4096:2: () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4096:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4097:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4112:2: ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    int cnt59=0;
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( ((LA59_0>=61 && LA59_0<=62)||(LA59_0>=71 && LA59_0<=72)) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4112:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4112:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4113:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4113:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4114:3: lv_operators_2_0= ruleMultiplyDivideOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperatorsMultiplyDivideOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression7249);
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

                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4136:2: ( (lv_operands_3_0= rulePowerExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4137:1: (lv_operands_3_0= rulePowerExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4137:1: (lv_operands_3_0= rulePowerExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4138:3: lv_operands_3_0= rulePowerExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperandsPowerExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression7270);
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
                    	    if ( cnt59 >= 1 ) break loop59;
                                EarlyExitException eee =
                                    new EarlyExitException(59, input);
                                throw eee;
                        }
                        cnt59++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4168:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4169:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4170:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression7310);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression7320); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4177:1: rulePowerExpression returns [EObject current=null] : (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryMinusExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4182:6: ( (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4183:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4183:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4184:5: this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryMinusExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7367);
            this_UnaryMinusExpression_0=ruleUnaryMinusExpression();
            _fsp--;

             
                    current = this_UnaryMinusExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4192:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==63||LA61_0==73) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4192:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4192:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4193:5: 
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4208:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4209:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4209:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4210:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression7397);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4232:2: ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4233:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4233:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4234:3: lv_exponent_3_0= ruleUnaryMinusExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryMinusExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7418);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4264:1: entryRuleUnaryMinusExpression returns [EObject current=null] : iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF ;
    public final EObject entryRuleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryMinusExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4265:2: (iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4266:2: iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryMinusExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression7456);
            iv_ruleUnaryMinusExpression=ruleUnaryMinusExpression();
            _fsp--;

             current =iv_ruleUnaryMinusExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryMinusExpression7466); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4273:1: ruleUnaryMinusExpression returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) ) ;
    public final EObject ruleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject this_FeatureCall_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4278:6: ( (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4279:1: (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4279:1: (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_ID && LA62_0<=RULE_STRING)||LA62_0==20||LA62_0==37||LA62_0==47||(LA62_0>=56 && LA62_0<=59)||(LA62_0>=74 && LA62_0<=75)) ) {
                alt62=1;
            }
            else if ( (LA62_0==54) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4279:1: (this_FeatureCall_0= ruleFeatureCall | ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) ) )", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4280:5: this_FeatureCall_0= ruleFeatureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getFeatureCallParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7513);
                    this_FeatureCall_0=ruleFeatureCall();
                    _fsp--;

                     
                            current = this_FeatureCall_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:6: ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:6: ( () '-' ( (lv_operand_3_0= ruleFeatureCall ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:7: () '-' ( (lv_operand_3_0= ruleFeatureCall ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4290:5: 
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

                    match(input,54,FOLLOW_54_in_ruleUnaryMinusExpression7538); 

                            createLeafNode(grammarAccess.getUnaryMinusExpressionAccess().getHyphenMinusKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4304:1: ( (lv_operand_3_0= ruleFeatureCall ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4305:1: (lv_operand_3_0= ruleFeatureCall )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4305:1: (lv_operand_3_0= ruleFeatureCall )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4306:3: lv_operand_3_0= ruleFeatureCall
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getOperandFeatureCallParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7559);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4336:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4337:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4338:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall7596);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall7606); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4345:1: ruleFeatureCall returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_CallablePrimaryExpression_1 = null;

        EObject lv_parts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4350:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4351:1: (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4351:1: (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_REAL && LA65_0<=RULE_STRING)||LA65_0==47||(LA65_0>=58 && LA65_0<=59)||(LA65_0>=74 && LA65_0<=75)) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_ID||LA65_0==20||LA65_0==37||(LA65_0>=56 && LA65_0<=57)) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4351:1: (this_PrimaryExpression_0= rulePrimaryExpression | (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? ) )", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4352:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleFeatureCall7653);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4361:6: (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4361:6: (this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4362:5: this_CallablePrimaryExpression_1= ruleCallablePrimaryExpression ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getCallablePrimaryExpressionParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall7681);
                    this_CallablePrimaryExpression_1=ruleCallablePrimaryExpression();
                    _fsp--;

                     
                            current = this_CallablePrimaryExpression_1; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4370:1: ( () ( (lv_parts_3_0= ruleFeatureCallPart ) )+ )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==20||LA64_0==37||LA64_0==55) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4370:2: () ( (lv_parts_3_0= ruleFeatureCallPart ) )+
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4370:2: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4371:5: 
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

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4386:2: ( (lv_parts_3_0= ruleFeatureCallPart ) )+
                            int cnt63=0;
                            loop63:
                            do {
                                int alt63=2;
                                int LA63_0 = input.LA(1);

                                if ( (LA63_0==20||LA63_0==37||LA63_0==55) ) {
                                    alt63=1;
                                }


                                switch (alt63) {
                            	case 1 :
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4387:1: (lv_parts_3_0= ruleFeatureCallPart )
                            	    {
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4387:1: (lv_parts_3_0= ruleFeatureCallPart )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4388:3: lv_parts_3_0= ruleFeatureCallPart
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_1_1_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall7711);
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
                            	    if ( cnt63 >= 1 ) break loop63;
                                        EarlyExitException eee =
                                            new EarlyExitException(63, input);
                                        throw eee;
                                }
                                cnt63++;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4418:1: entryRuleFeatureCallPart returns [EObject current=null] : iv_ruleFeatureCallPart= ruleFeatureCallPart EOF ;
    public final EObject entryRuleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4419:2: (iv_ruleFeatureCallPart= ruleFeatureCallPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4420:2: iv_ruleFeatureCallPart= ruleFeatureCallPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart7751);
            iv_ruleFeatureCallPart=ruleFeatureCallPart();
            _fsp--;

             current =iv_ruleFeatureCallPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallPart7761); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4427:1: ruleFeatureCallPart returns [EObject current=null] : (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall ) ;
    public final EObject ruleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject this_FeatureReference_0 = null;

        EObject this_ArrayElementReference_1 = null;

        EObject this_OperationCall_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4432:6: ( (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4433:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4433:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt66=1;
                }
                break;
            case 37:
                {
                alt66=2;
                }
                break;
            case 20:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4433:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall )", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4434:5: this_FeatureReference_0= ruleFeatureReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getFeatureReferenceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureReference_in_ruleFeatureCallPart7808);
                    this_FeatureReference_0=ruleFeatureReference();
                    _fsp--;

                     
                            current = this_FeatureReference_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4444:5: this_ArrayElementReference_1= ruleArrayElementReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getArrayElementReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayElementReference_in_ruleFeatureCallPart7835);
                    this_ArrayElementReference_1=ruleArrayElementReference();
                    _fsp--;

                     
                            current = this_ArrayElementReference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4454:5: this_OperationCall_2= ruleOperationCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getOperationCallParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCall_in_ruleFeatureCallPart7862);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4470:1: entryRuleFeatureReference returns [EObject current=null] : iv_ruleFeatureReference= ruleFeatureReference EOF ;
    public final EObject entryRuleFeatureReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4471:2: (iv_ruleFeatureReference= ruleFeatureReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4472:2: iv_ruleFeatureReference= ruleFeatureReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference7897);
            iv_ruleFeatureReference=ruleFeatureReference();
            _fsp--;

             current =iv_ruleFeatureReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureReference7907); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4479:1: ruleFeatureReference returns [EObject current=null] : ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) ) ;
    public final EObject ruleFeatureReference() throws RecognitionException {
        EObject current = null;

        Token lv_featureName_1_1=null;
        Token lv_featureName_1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4484:6: ( ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4485:1: ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4485:1: ( '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4485:3: '.' ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) )
            {
            match(input,55,FOLLOW_55_in_ruleFeatureReference7942); 

                    createLeafNode(grammarAccess.getFeatureReferenceAccess().getFullStopKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4489:1: ( ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4490:1: ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4490:1: ( (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4491:1: (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4491:1: (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                alt67=1;
            }
            else if ( (LA67_0==47) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4491:1: (lv_featureName_1_1= RULE_ID | lv_featureName_1_2= 'unit' )", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4492:3: lv_featureName_1_1= RULE_ID
                    {
                    lv_featureName_1_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureReference7961); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4513:8: lv_featureName_1_2= 'unit'
                    {
                    lv_featureName_1_2=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleFeatureReference7982); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4542:1: entryRuleArrayElementReference returns [EObject current=null] : iv_ruleArrayElementReference= ruleArrayElementReference EOF ;
    public final EObject entryRuleArrayElementReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayElementReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4543:2: (iv_ruleArrayElementReference= ruleArrayElementReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4544:2: iv_ruleArrayElementReference= ruleArrayElementReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayElementReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayElementReference_in_entryRuleArrayElementReference8034);
            iv_ruleArrayElementReference=ruleArrayElementReference();
            _fsp--;

             current =iv_ruleArrayElementReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayElementReference8044); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4551:1: ruleArrayElementReference returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) ;
    public final EObject ruleArrayElementReference() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4556:6: ( ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4557:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4557:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4557:3: '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']'
            {
            match(input,37,FOLLOW_37_in_ruleArrayElementReference8079); 

                    createLeafNode(grammarAccess.getArrayElementReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4561:1: ( (lv_subscripts_1_0= ruleSubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4562:1: (lv_subscripts_1_0= ruleSubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4562:1: (lv_subscripts_1_0= ruleSubscript )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4563:3: lv_subscripts_1_0= ruleSubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayElementReferenceAccess().getSubscriptsSubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSubscript_in_ruleArrayElementReference8100);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4585:2: ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==16) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4585:4: ',' ( (lv_subscripts_3_0= ruleSubscript ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleArrayElementReference8111); 

            	            createLeafNode(grammarAccess.getArrayElementReferenceAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4589:1: ( (lv_subscripts_3_0= ruleSubscript ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4590:1: (lv_subscripts_3_0= ruleSubscript )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4590:1: (lv_subscripts_3_0= ruleSubscript )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4591:3: lv_subscripts_3_0= ruleSubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayElementReferenceAccess().getSubscriptsSubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubscript_in_ruleArrayElementReference8132);
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
            	    break loop68;
                }
            } while (true);

            match(input,38,FOLLOW_38_in_ruleArrayElementReference8144); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4625:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4626:2: (iv_ruleOperationCall= ruleOperationCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4627:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCall_in_entryRuleOperationCall8180);
            iv_ruleOperationCall=ruleOperationCall();
            _fsp--;

             current =iv_ruleOperationCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCall8190); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4634:1: ruleOperationCall returns [EObject current=null] : ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4639:6: ( ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4640:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4640:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4640:2: () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4640:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4641:5: 
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

            match(input,20,FOLLOW_20_in_ruleOperationCall8234); 

                    createLeafNode(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4655:1: ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=RULE_ID && LA70_0<=RULE_STRING)||LA70_0==20||LA70_0==24||LA70_0==37||LA70_0==47||LA70_0==52||LA70_0==54||(LA70_0>=56 && LA70_0<=59)||(LA70_0>=74 && LA70_0<=75)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4655:2: ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4655:2: ( (lv_arguments_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4656:1: (lv_arguments_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4656:1: (lv_arguments_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4657:3: lv_arguments_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall8256);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4679:2: ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==16) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4679:4: ',' ( (lv_arguments_4_0= ruleExpression ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleOperationCall8267); 

                    	            createLeafNode(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4683:1: ( (lv_arguments_4_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4684:1: (lv_arguments_4_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4684:1: (lv_arguments_4_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4685:3: lv_arguments_4_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall8288);
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
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,21,FOLLOW_21_in_ruleOperationCall8302); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4719:1: entryRuleCallablePrimaryExpression returns [EObject current=null] : iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF ;
    public final EObject entryRuleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallablePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4720:2: (iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4721:2: iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallablePrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression8338);
            iv_ruleCallablePrimaryExpression=ruleCallablePrimaryExpression();
            _fsp--;

             current =iv_ruleCallablePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallablePrimaryExpression8348); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4728:1: ruleCallablePrimaryExpression returns [EObject current=null] : (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject ruleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MatrixConstructionOperator_0 = null;

        EObject this_SymbolReference_1 = null;

        EObject this_ParenthesizedExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4733:6: ( (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4734:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4734:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt71=1;
                }
                break;
            case RULE_ID:
            case 56:
            case 57:
                {
                alt71=2;
                }
                break;
            case 20:
                {
                alt71=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4734:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_SymbolReference_1= ruleSymbolReference | this_ParenthesizedExpression_2= ruleParenthesizedExpression )", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4735:5: this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getMatrixConstructionOperatorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_ruleCallablePrimaryExpression8395);
                    this_MatrixConstructionOperator_0=ruleMatrixConstructionOperator();
                    _fsp--;

                     
                            current = this_MatrixConstructionOperator_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4745:5: this_SymbolReference_1= ruleSymbolReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getSymbolReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSymbolReference_in_ruleCallablePrimaryExpression8422);
                    this_SymbolReference_1=ruleSymbolReference();
                    _fsp--;

                     
                            current = this_SymbolReference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4755:5: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression8449);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4771:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4772:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4773:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression8484);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression8494); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4780:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_UnitConstructionOperator_1 = null;

        EObject this_BeginExpression_2 = null;

        EObject this_EndExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4785:6: ( (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4786:1: (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4786:1: (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression )
            int alt72=4;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 74:
            case 75:
                {
                alt72=1;
                }
                break;
            case 47:
                {
                alt72=2;
                }
                break;
            case 58:
                {
                alt72=3;
                }
                break;
            case 59:
                {
                alt72=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4786:1: (this_Literal_0= ruleLiteral | this_UnitConstructionOperator_1= ruleUnitConstructionOperator | this_BeginExpression_2= ruleBeginExpression | this_EndExpression_3= ruleEndExpression )", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4787:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression8541);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4797:5: this_UnitConstructionOperator_1= ruleUnitConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnitConstructionOperatorParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression8568);
                    this_UnitConstructionOperator_1=ruleUnitConstructionOperator();
                    _fsp--;

                     
                            current = this_UnitConstructionOperator_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:5: this_BeginExpression_2= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression8595);
                    this_BeginExpression_2=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4817:5: this_EndExpression_3= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression8622);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4833:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4834:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4835:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral8657);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral8667); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4842:1: ruleLiteral returns [EObject current=null] : (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4847:6: ( (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4848:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4848:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt73=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt73=1;
                }
                break;
            case 74:
            case 75:
                {
                alt73=2;
                }
                break;
            case RULE_STRING:
                {
                alt73=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4848:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4849:5: this_NumericalLiteral_0= ruleNumericalLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericalLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalLiteral_in_ruleLiteral8714);
                    this_NumericalLiteral_0=ruleNumericalLiteral();
                    _fsp--;

                     
                            current = this_NumericalLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4859:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral8741);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4869:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral8768);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4885:1: entryRuleNumericalLiteral returns [EObject current=null] : iv_ruleNumericalLiteral= ruleNumericalLiteral EOF ;
    public final EObject entryRuleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4886:2: (iv_ruleNumericalLiteral= ruleNumericalLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4887:2: iv_ruleNumericalLiteral= ruleNumericalLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral8803);
            iv_ruleNumericalLiteral=ruleNumericalLiteral();
            _fsp--;

             current =iv_ruleNumericalLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalLiteral8813); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4894:1: ruleNumericalLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4899:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4900:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4900:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_REAL) ) {
                alt74=1;
            }
            else if ( (LA74_0==RULE_INTEGER) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4900:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4901:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral8860);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4911:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral8887);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4927:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4928:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4929:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral8922);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral8932); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4936:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_imaginary_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4941:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4942:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4942:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4942:2: ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4942:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4943:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4943:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4944:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral8974); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4966:2: ( (lv_imaginary_1_0= 'j' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==56) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4967:1: (lv_imaginary_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4967:1: (lv_imaginary_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4968:3: lv_imaginary_1_0= 'j'
                    {
                    lv_imaginary_1_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleRealLiteral8997); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4987:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==20) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4987:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleRealLiteral9022); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4991:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4992:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4992:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4993:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral9043);
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

                    match(input,21,FOLLOW_21_in_ruleRealLiteral9053); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5027:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5028:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5029:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral9091);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral9101); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5036:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_imaginary_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5041:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5042:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5042:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5042:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5042:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5043:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5043:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5044:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral9143); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5066:2: ( (lv_imaginary_1_0= 'j' ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==56) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5067:1: (lv_imaginary_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5067:1: (lv_imaginary_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5068:3: lv_imaginary_1_0= 'j'
                    {
                    lv_imaginary_1_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleIntegerLiteral9166); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5087:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==20) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5087:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleIntegerLiteral9191); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5091:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5092:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5092:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5093:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral9212);
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

                    match(input,21,FOLLOW_21_in_ruleIntegerLiteral9222); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5127:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5128:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5129:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral9260);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral9270); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5136:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5141:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5142:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5142:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5143:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5143:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5144:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral9315);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5174:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5175:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5176:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral9350);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral9360); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5183:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5188:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5189:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5189:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5190:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5190:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5191:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral9401); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5221:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5222:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5223:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9441);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName9451); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5230:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_identifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_identifiers_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5235:6: ( ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5236:1: ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5236:1: ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5236:2: ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5236:2: ( (lv_identifiers_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5237:1: (lv_identifiers_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5237:1: (lv_identifiers_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5238:3: lv_identifiers_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getIdentifiersKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleQualifiedName9497);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5260:2: ( '::' ( (lv_identifiers_2_0= ruleKeywordID ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==57) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5260:4: '::' ( (lv_identifiers_2_0= ruleKeywordID ) )
            	    {
            	    match(input,57,FOLLOW_57_in_ruleQualifiedName9508); 

            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5264:1: ( (lv_identifiers_2_0= ruleKeywordID ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5265:1: (lv_identifiers_2_0= ruleKeywordID )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5265:1: (lv_identifiers_2_0= ruleKeywordID )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5266:3: lv_identifiers_2_0= ruleKeywordID
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getIdentifiersKeywordIDParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordID_in_ruleQualifiedName9529);
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
            	    break loop79;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5296:1: entryRuleSymbolReference returns [EObject current=null] : iv_ruleSymbolReference= ruleSymbolReference EOF ;
    public final EObject entryRuleSymbolReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5297:2: (iv_ruleSymbolReference= ruleSymbolReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5298:2: iv_ruleSymbolReference= ruleSymbolReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSymbolReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleSymbolReference_in_entryRuleSymbolReference9567);
            iv_ruleSymbolReference=ruleSymbolReference();
            _fsp--;

             current =iv_ruleSymbolReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSymbolReference9577); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5305:1: ruleSymbolReference returns [EObject current=null] : ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleSymbolReference() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        EObject lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5310:6: ( ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5311:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5311:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5311:2: ( (lv_global_0_0= '::' ) )? ( (lv_name_1_0= ruleQualifiedName ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5311:2: ( (lv_global_0_0= '::' ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==57) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5312:1: (lv_global_0_0= '::' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5312:1: (lv_global_0_0= '::' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5313:3: lv_global_0_0= '::'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleSymbolReference9620); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5332:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5333:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5333:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5334:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSymbolReferenceAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSymbolReference9655);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5364:1: entryRuleSubscript returns [EObject current=null] : iv_ruleSubscript= ruleSubscript EOF ;
    public final EObject entryRuleSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5365:2: (iv_ruleSubscript= ruleSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5366:2: iv_ruleSubscript= ruleSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubscript_in_entryRuleSubscript9691);
            iv_ruleSubscript=ruleSubscript();
            _fsp--;

             current =iv_ruleSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubscript9701); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5373:1: ruleSubscript returns [EObject current=null] : (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) ;
    public final EObject ruleSubscript() throws RecognitionException {
        EObject current = null;

        EObject this_ColonSubscript_0 = null;

        EObject this_ExpressionSubscript_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5378:6: ( (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5379:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5379:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==49) ) {
                alt81=1;
            }
            else if ( ((LA81_0>=RULE_ID && LA81_0<=RULE_STRING)||LA81_0==20||LA81_0==24||LA81_0==37||LA81_0==47||LA81_0==52||LA81_0==54||(LA81_0>=56 && LA81_0<=59)||(LA81_0>=74 && LA81_0<=75)) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5379:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5380:5: this_ColonSubscript_0= ruleColonSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getColonSubscriptParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleColonSubscript_in_ruleSubscript9748);
                    this_ColonSubscript_0=ruleColonSubscript();
                    _fsp--;

                     
                            current = this_ColonSubscript_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5390:5: this_ExpressionSubscript_1= ruleExpressionSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getExpressionSubscriptParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionSubscript_in_ruleSubscript9775);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5406:1: entryRuleColonSubscript returns [EObject current=null] : iv_ruleColonSubscript= ruleColonSubscript EOF ;
    public final EObject entryRuleColonSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5407:2: (iv_ruleColonSubscript= ruleColonSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5408:2: iv_ruleColonSubscript= ruleColonSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getColonSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript9810);
            iv_ruleColonSubscript=ruleColonSubscript();
            _fsp--;

             current =iv_ruleColonSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColonSubscript9820); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5415:1: ruleColonSubscript returns [EObject current=null] : ( () ':' ) ;
    public final EObject ruleColonSubscript() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5420:6: ( ( () ':' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5421:1: ( () ':' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5421:1: ( () ':' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5421:2: () ':'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5421:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5422:5: 
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

            match(input,49,FOLLOW_49_in_ruleColonSubscript9864); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5444:1: entryRuleExpressionSubscript returns [EObject current=null] : iv_ruleExpressionSubscript= ruleExpressionSubscript EOF ;
    public final EObject entryRuleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5445:2: (iv_ruleExpressionSubscript= ruleExpressionSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5446:2: iv_ruleExpressionSubscript= ruleExpressionSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript9900);
            iv_ruleExpressionSubscript=ruleExpressionSubscript();
            _fsp--;

             current =iv_ruleExpressionSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionSubscript9910); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5453:1: ruleExpressionSubscript returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5458:6: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5459:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5459:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5460:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5460:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5461:3: lv_expression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionSubscriptAccess().getExpressionExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionSubscript9955);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5491:1: entryRuleMatrixConstructionOperator returns [EObject current=null] : iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF ;
    public final EObject entryRuleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5492:2: (iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5493:2: iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMatrixConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator9990);
            iv_ruleMatrixConstructionOperator=ruleMatrixConstructionOperator();
            _fsp--;

             current =iv_ruleMatrixConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixConstructionOperator10000); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5500:1: ruleMatrixConstructionOperator returns [EObject current=null] : ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionLists_1_0 = null;

        EObject lv_expressionLists_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5505:6: ( ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5506:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5506:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5506:3: '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,37,FOLLOW_37_in_ruleMatrixConstructionOperator10035); 

                    createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5510:1: ( (lv_expressionLists_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5511:1: (lv_expressionLists_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5511:1: (lv_expressionLists_1_0= ruleExpressionList )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5512:3: lv_expressionLists_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10056);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5534:2: ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==18) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5534:4: ';' ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleMatrixConstructionOperator10067); 

            	            createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5538:1: ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5539:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5539:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5540:3: lv_expressionLists_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10088);
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
            	    break loop82;
                }
            } while (true);

            match(input,38,FOLLOW_38_in_ruleMatrixConstructionOperator10100); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5574:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5575:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5576:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList10136);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList10146); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5583:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5588:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5590:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5590:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5591:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10192);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5613:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==16) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5613:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleExpressionList10203); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5617:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5618:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5618:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5619:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10224);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5649:1: entryRuleUnitConstructionOperator returns [EObject current=null] : iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF ;
    public final EObject entryRuleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5650:2: (iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5651:2: iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10262);
            iv_ruleUnitConstructionOperator=ruleUnitConstructionOperator();
            _fsp--;

             current =iv_ruleUnitConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitConstructionOperator10272); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5658:1: ruleUnitConstructionOperator returns [EObject current=null] : ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' ) ;
    public final EObject ruleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_unitExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5663:6: ( ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5664:1: ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5664:1: ( 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5664:3: 'unit' '(' ( (lv_unitExpression_2_0= ruleUnitExpression ) ) ')'
            {
            match(input,47,FOLLOW_47_in_ruleUnitConstructionOperator10307); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitKeyword_0(), null); 
                
            match(input,20,FOLLOW_20_in_ruleUnitConstructionOperator10317); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5672:1: ( (lv_unitExpression_2_0= ruleUnitExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5673:1: (lv_unitExpression_2_0= ruleUnitExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5673:1: (lv_unitExpression_2_0= ruleUnitExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5674:3: lv_unitExpression_2_0= ruleUnitExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitExpressionUnitExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10338);
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

            match(input,21,FOLLOW_21_in_ruleUnitConstructionOperator10348); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5708:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5709:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5710:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10384);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression10394); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5717:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5722:6: ( ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5723:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5723:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5723:3: '(' ( (lv_expression_1_0= ruleExpression ) ) ')'
            {
            match(input,20,FOLLOW_20_in_ruleParenthesizedExpression10429); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5727:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5728:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5728:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5729:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10450);
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

            match(input,21,FOLLOW_21_in_ruleParenthesizedExpression10460); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5763:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5764:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5765:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10496);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression10506); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5772:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5777:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5778:1: ( () 'begin' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5778:1: ( () 'begin' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5778:2: () 'begin'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5778:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5779:5: 
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

            match(input,58,FOLLOW_58_in_ruleBeginExpression10550); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5801:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5802:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5803:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression10586);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression10596); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5810:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5815:6: ( ( () 'end' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5816:1: ( () 'end' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5816:1: ( () 'end' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5816:2: () 'end'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5816:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5817:5: 
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

            match(input,59,FOLLOW_59_in_ruleEndExpression10640); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5839:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5840:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5841:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10676);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression10686); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5848:1: ruleUnitExpression returns [EObject current=null] : ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_unspecified_0_0=null;
        EObject lv_expression_2_0 = null;

        EObject lv_numerator_3_0 = null;

        EObject lv_denominator_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5853:6: ( ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5854:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5854:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt85=1;
                }
                break;
            case 60:
                {
                alt85=2;
                }
                break;
            case RULE_ID:
            case RULE_INTEGER:
            case 56:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5854:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5854:2: ( (lv_unspecified_0_0= '?' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5854:2: ( (lv_unspecified_0_0= '?' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5855:1: (lv_unspecified_0_0= '?' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5855:1: (lv_unspecified_0_0= '?' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5856:3: lv_unspecified_0_0= '?'
                    {
                    lv_unspecified_0_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleUnitExpression10729); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5876:6: ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5876:6: ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5876:8: 'eval' ( (lv_expression_2_0= ruleExpression ) )
                    {
                    match(input,60,FOLLOW_60_in_ruleUnitExpression10759); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getEvalKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5880:1: ( (lv_expression_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5881:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5881:1: (lv_expression_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5882:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getExpressionExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleUnitExpression10780);
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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5905:6: ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5905:6: ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5905:7: ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5905:7: ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5906:1: (lv_numerator_3_0= ruleUnitExpressionNumerator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5906:1: (lv_numerator_3_0= ruleUnitExpressionNumerator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5907:3: lv_numerator_3_0= ruleUnitExpressionNumerator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10809);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5929:2: ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==61) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5929:4: '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) )
                            {
                            match(input,61,FOLLOW_61_in_ruleUnitExpression10820); 

                                    createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_2_1_0(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5933:1: ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5934:1: (lv_denominator_5_0= ruleUnitExpressionDenominator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5934:1: (lv_denominator_5_0= ruleUnitExpressionDenominator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5935:3: lv_denominator_5_0= ruleUnitExpressionDenominator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_2_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10841);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5965:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5966:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5967:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator10880);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator10890); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5974:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5979:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5980:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5980:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_INTEGER) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_ID||LA87_0==56) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5980:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5980:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5980:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5981:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5981:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5982:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator10932); 

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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6005:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6005:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6005:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6005:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6006:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6006:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6007:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10965);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6029:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==62) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6029:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,62,FOLLOW_62_in_ruleUnitExpressionNumerator10976); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6033:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6034:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6034:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6035:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10997);
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
                    	    break loop86;
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6065:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6066:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6067:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11036);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11046); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6074:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6079:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6080:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6080:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_ID||LA89_0==56) ) {
                alt89=1;
            }
            else if ( (LA89_0==20) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6080:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6080:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6080:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6081:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6081:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6082:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11092);
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
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6105:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6105:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6105:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleUnitExpressionDenominator11109); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6109:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6110:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6110:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6111:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11130);
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

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6133:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==62) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6133:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,62,FOLLOW_62_in_ruleUnitExpressionDenominator11141); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6137:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6138:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6138:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6139:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11162);
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
                    	    break loop88;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_ruleUnitExpressionDenominator11174); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6173:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6174:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6175:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11211);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor11221); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6182:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operand_0_0 = null;

        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6187:6: ( ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6188:1: ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6188:1: ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6188:2: ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6188:2: ( (lv_operand_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6189:1: (lv_operand_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6189:1: (lv_operand_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6190:3: lv_operand_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getOperandKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleUnitExpressionFactor11267);
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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6212:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==63) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6212:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,63,FOLLOW_63_in_ruleUnitExpressionFactor11278); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6216:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6217:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6217:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6218:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11299);
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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6248:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6249:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6250:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11337);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent11347); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6257:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6262:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6263:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6263:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6263:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6263:2: ( (lv_negative_0_0= '-' ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==54) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6264:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6264:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6265:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleUnitExpressionExponent11390); 

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

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6284:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6285:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6285:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6286:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11421); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6316:1: entryRuleKeywordID returns [String current=null] : iv_ruleKeywordID= ruleKeywordID EOF ;
    public final String entryRuleKeywordID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordID = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6317:2: (iv_ruleKeywordID= ruleKeywordID EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6318:2: iv_ruleKeywordID= ruleKeywordID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeywordID_in_entryRuleKeywordID11463);
            iv_ruleKeywordID=ruleKeywordID();
            _fsp--;

             current =iv_ruleKeywordID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordID11474); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6325:1: ruleKeywordID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'j' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6330:6: ( (this_ID_0= RULE_ID | kw= 'j' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6331:1: (this_ID_0= RULE_ID | kw= 'j' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6331:1: (this_ID_0= RULE_ID | kw= 'j' )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_ID) ) {
                alt92=1;
            }
            else if ( (LA92_0==56) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6331:1: (this_ID_0= RULE_ID | kw= 'j' )", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6331:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordID11514); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(grammarAccess.getKeywordIDAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6340:2: kw= 'j'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleKeywordID11538); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6353:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6357:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            int alt93=6;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt93=1;
                }
                break;
            case 65:
                {
                alt93=2;
                }
                break;
            case 66:
                {
                alt93=3;
                }
                break;
            case 67:
                {
                alt93=4;
                }
                break;
            case 68:
                {
                alt93=5;
                }
                break;
            case 69:
                {
                alt93=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6358:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:2: ( '<' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:2: ( '<' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:4: '<'
                    {
                    match(input,64,FOLLOW_64_in_ruleRelationalOperator11590); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6364:6: ( '<=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6364:6: ( '<=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6364:8: '<='
                    {
                    match(input,65,FOLLOW_65_in_ruleRelationalOperator11605); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6370:6: ( '>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6370:6: ( '>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6370:8: '>'
                    {
                    match(input,66,FOLLOW_66_in_ruleRelationalOperator11620); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6376:6: ( '>=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6376:6: ( '>=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6376:8: '>='
                    {
                    match(input,67,FOLLOW_67_in_ruleRelationalOperator11635); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6382:6: ( '==' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6382:6: ( '==' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6382:8: '=='
                    {
                    match(input,68,FOLLOW_68_in_ruleRelationalOperator11650); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6388:6: ( '<>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6388:6: ( '<>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6388:8: '<>'
                    {
                    match(input,69,FOLLOW_69_in_ruleRelationalOperator11665); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6398:1: ruleAddSubtractOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAddSubtractOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6402:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6403:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6403:1: ( ( '+' ) | ( '-' ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==70) ) {
                alt94=1;
            }
            else if ( (LA94_0==54) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6403:1: ( ( '+' ) | ( '-' ) )", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6403:2: ( '+' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6403:2: ( '+' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6403:4: '+'
                    {
                    match(input,70,FOLLOW_70_in_ruleAddSubtractOperator11708); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6409:6: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6409:6: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6409:8: '-'
                    {
                    match(input,54,FOLLOW_54_in_ruleAddSubtractOperator11723); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6419:1: ruleMultiplyDivideOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplyDivideOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6423:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6424:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6424:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt95=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt95=1;
                }
                break;
            case 61:
                {
                alt95=2;
                }
                break;
            case 71:
                {
                alt95=3;
                }
                break;
            case 72:
                {
                alt95=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6424:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6424:2: ( '*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6424:2: ( '*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6424:4: '*'
                    {
                    match(input,62,FOLLOW_62_in_ruleMultiplyDivideOperator11766); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6430:6: ( '/' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6430:6: ( '/' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6430:8: '/'
                    {
                    match(input,61,FOLLOW_61_in_ruleMultiplyDivideOperator11781); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6436:6: ( '.*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6436:6: ( '.*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6436:8: '.*'
                    {
                    match(input,71,FOLLOW_71_in_ruleMultiplyDivideOperator11796); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6442:6: ( './' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6442:6: ( './' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6442:8: './'
                    {
                    match(input,72,FOLLOW_72_in_ruleMultiplyDivideOperator11811); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6452:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6456:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6457:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6457:1: ( ( '^' ) | ( '.^' ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==63) ) {
                alt96=1;
            }
            else if ( (LA96_0==73) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6457:1: ( ( '^' ) | ( '.^' ) )", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6457:2: ( '^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6457:2: ( '^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6457:4: '^'
                    {
                    match(input,63,FOLLOW_63_in_rulePowerOperator11854); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6463:6: ( '.^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6463:6: ( '.^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6463:8: '.^'
                    {
                    match(input,73,FOLLOW_73_in_rulePowerOperator11869); 

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
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6473:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6477:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6478:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6478:1: ( ( 'false' ) | ( 'true' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==74) ) {
                alt97=1;
            }
            else if ( (LA97_0==75) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6478:1: ( ( 'false' ) | ( 'true' ) )", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6478:2: ( 'false' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6478:2: ( 'false' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6478:4: 'false'
                    {
                    match(input,74,FOLLOW_74_in_ruleBooleanKind11912); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6484:6: ( 'true' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6484:6: ( 'true' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6484:8: 'true'
                    {
                    match(input,75,FOLLOW_75_in_ruleBooleanKind11927); 

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
    public static final BitSet FOLLOW_13_in_rulePackageDefinition242 = new BitSet(new long[]{0x01009F93800AD010L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_rulePackageDefinition263 = new BitSet(new long[]{0x01009F93800AD010L});
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
    public static final BitSet FOLLOW_13_in_ruleRecordDefinition883 = new BitSet(new long[]{0x00001F9000004000L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition904 = new BitSet(new long[]{0x00001F9000004000L});
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
    public static final BitSet FOLLOW_19_in_ruleFunctionDefinition1251 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleFunctionDefinition1286 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFunctionDefinition1296 = new BitSet(new long[]{0x00009F9180680000L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1318 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionDefinition1329 = new BitSet(new long[]{0x00009F9180480000L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1350 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleFunctionDefinition1364 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunctionDefinition1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterDeclaration1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableModifier_in_ruleParameterDeclaration1477 = new BitSet(new long[]{0x00009F9000400000L});
    public static final BitSet FOLLOW_22_in_ruleParameterDeclaration1496 = new BitSet(new long[]{0x00009F9000000000L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_ruleParameterDeclaration1531 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleParameterDeclaration1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement1588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallStatement_in_ruleStatement1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoWhileStatement_in_ruleStatement1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeachStatement_in_ruleStatement1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleStatement1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStatement1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock1896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock1906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleBlock1950 = new BitSet(new long[]{0x0F009FBBB91860F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock1971 = new BitSet(new long[]{0x0F009FBBB91860F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_14_in_ruleBlock1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallStatement_in_entryRuleFeatureCallStatement2018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallStatement2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleFeatureCallStatement2074 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_23_in_ruleFeatureCallStatement2093 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCallStatement2127 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureCallStatement2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement2175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleIfStatement2220 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfCase_in_ruleIfStatement2241 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_25_in_ruleIfStatement2252 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleIfCase_in_ruleIfStatement2273 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_26_in_ruleIfStatement2286 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfCase_in_entryRuleIfCase2345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfCase2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfCase2401 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfCase2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement2458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleWhileStatement2503 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileStatement2524 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoWhileStatement_in_entryRuleDoWhileStatement2581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoWhileStatement2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDoWhileStatement2626 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleDoWhileStatement2647 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleDoWhileStatement2657 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDoWhileStatement2678 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDoWhileStatement2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeachStatement_in_entryRuleForeachStatement2724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForeachStatement2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleForeachStatement2769 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleForeachStatement2790 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleForeachStatement2800 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleForeachStatement2821 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleForeachStatement2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableModifier_in_ruleVariableDeclaration2934 = new BitSet(new long[]{0x00009F9000000000L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_ruleVariableDeclaration2956 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration2977 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleVariableDeclaration2988 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_ruleVariableDeclaration3009 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_18_in_ruleVariableDeclaration3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableModifier_in_entryRuleVariableModifier3057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableModifier3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVariableModifier3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVariableModifier3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVariableModifier3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationItem_in_entryRuleVariableDeclarationItem3233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationItem3243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleVariableDeclarationItem3289 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclarationItem3300 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclarationItem3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition3359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleTypeDefinition3404 = new BitSet(new long[]{0x00001F9000000000L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleTypeDefinition3425 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTypeDefinition3435 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleTypeDefinition3456 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTypeDefinition3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement3502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleReturnStatement3547 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement3568 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReturnStatement3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_entryRuleTypeSpecifier3614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeSpecifier3624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleTypeSpecifier3671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitTypeSpecifier_in_ruleTypeSpecifier3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier3733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeSpecifier3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier3790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier3817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier3852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier3963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier3998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericalTypeSpecifier4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericalTypeSpecifier4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier4171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleRealTypeSpecifier4225 = new BitSet(new long[]{0x0000002000100002L});
    public static final BitSet FOLLOW_20_in_ruleRealTypeSpecifier4236 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier4257 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleRealTypeSpecifier4267 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleRealTypeSpecifier4280 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4301 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleRealTypeSpecifier4312 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier4333 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleRealTypeSpecifier4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier4383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleIntegerTypeSpecifier4437 = new BitSet(new long[]{0x0000002000100002L});
    public static final BitSet FOLLOW_20_in_ruleIntegerTypeSpecifier4448 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier4469 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIntegerTypeSpecifier4479 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleIntegerTypeSpecifier4492 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4513 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleIntegerTypeSpecifier4524 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier4545 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleIntegerTypeSpecifier4557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier4595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleComplexTypeSpecifier4649 = new BitSet(new long[]{0x0000002000100002L});
    public static final BitSet FOLLOW_20_in_ruleComplexTypeSpecifier4660 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier4681 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleComplexTypeSpecifier4691 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleComplexTypeSpecifier4704 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4725 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleComplexTypeSpecifier4736 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier4757 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleComplexTypeSpecifier4769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier4807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleGaussianTypeSpecifier4861 = new BitSet(new long[]{0x0000002000100002L});
    public static final BitSet FOLLOW_20_in_ruleGaussianTypeSpecifier4872 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier4893 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleGaussianTypeSpecifier4903 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleGaussianTypeSpecifier4916 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier4937 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleGaussianTypeSpecifier4948 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier4969 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleGaussianTypeSpecifier4981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier5019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier5029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleBooleanTypeSpecifier5073 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleBooleanTypeSpecifier5084 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5105 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleBooleanTypeSpecifier5116 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier5137 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleBooleanTypeSpecifier5149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier5187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleStringTypeSpecifier5241 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleStringTypeSpecifier5252 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5273 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleStringTypeSpecifier5284 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier5305 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleStringTypeSpecifier5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier5355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTypeSpecifier5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleNamedTypeSpecifier5400 = new BitSet(new long[]{0x0300000000000010L});
    public static final BitSet FOLLOW_ruleSymbolReference_in_ruleNamedTypeSpecifier5421 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleNamedTypeSpecifier5432 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5453 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedTypeSpecifier5464 = new BitSet(new long[]{0x0F50A020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier5485 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleNamedTypeSpecifier5497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification5535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayDimensionSpecification5545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleArrayDimensionSpecification5588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5629 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleArrayDimensionSpecification5649 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification5670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitTypeSpecifier_in_entryRuleUnitTypeSpecifier5709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitTypeSpecifier5719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleUnitTypeSpecifier5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression5799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression5918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleConditionalExpression5963 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression5984 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleConditionalExpression5995 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression6016 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression6028 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpression6049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase6085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpressionCase6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6141 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleConditionalExpressionCase6151 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase6172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression6208 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression6218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6265 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRangeExpression6284 = new BitSet(new long[]{0x0F508020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6305 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRangeExpression6325 = new BitSet(new long[]{0x0F508020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression6346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression6386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression6396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6443 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLogicalOrExpression6463 = new BitSet(new long[]{0x0F508020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6484 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression6534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6581 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleLogicalAndExpression6601 = new BitSet(new long[]{0x0F508020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression6622 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression6662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression6672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleLogicalNotExpression6744 = new BitSet(new long[]{0x0F408020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression6765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression6812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression6859 = new BitSet(new long[]{0x0020000000000002L,0x000000000000003FL});
    public static final BitSet FOLLOW_53_in_ruleRelationalExpression6888 = new BitSet(new long[]{0x00001F9000000000L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6951 = new BitSet(new long[]{0x0F408020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression6972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression7012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddSubtractExpression7022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression7069 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression7100 = new BitSet(new long[]{0x0F408020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression7121 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression7161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyDivideExpression7171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression7218 = new BitSet(new long[]{0x6000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression7249 = new BitSet(new long[]{0x0F408020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression7270 = new BitSet(new long[]{0x6000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression7310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression7320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7367 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression7397 = new BitSet(new long[]{0x0F408020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression7418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression7456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryMinusExpression7466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnaryMinusExpression7538 = new BitSet(new long[]{0x0F008020001000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_ruleUnaryMinusExpression7559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall7596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall7606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleFeatureCall7653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall7681 = new BitSet(new long[]{0x0080002000100002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall7711 = new BitSet(new long[]{0x0080002000100002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart7751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallPart7761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_ruleFeatureCallPart7808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementReference_in_ruleFeatureCallPart7835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_ruleFeatureCallPart7862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference7897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureReference7907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFeatureReference7942 = new BitSet(new long[]{0x0000800000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureReference7961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureReference7982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementReference_in_entryRuleArrayElementReference8034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayElementReference8044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleArrayElementReference8079 = new BitSet(new long[]{0x0F528020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayElementReference8100 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleArrayElementReference8111 = new BitSet(new long[]{0x0F528020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayElementReference8132 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleArrayElementReference8144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_entryRuleOperationCall8180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCall8190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOperationCall8234 = new BitSet(new long[]{0x0F508020013000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall8256 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleOperationCall8267 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall8288 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleOperationCall8302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression8338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallablePrimaryExpression8348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_ruleCallablePrimaryExpression8395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSymbolReference_in_ruleCallablePrimaryExpression8422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression8449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression8484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression8494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression8541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression8568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression8595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression8622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral8657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral8667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_ruleLiteral8714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral8741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral8768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral8803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalLiteral8813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral8860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral8887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral8922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral8932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral8974 = new BitSet(new long[]{0x0100000000100002L});
    public static final BitSet FOLLOW_56_in_ruleRealLiteral8997 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleRealLiteral9022 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral9043 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleRealLiteral9053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral9091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral9101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral9143 = new BitSet(new long[]{0x0100000000100002L});
    public static final BitSet FOLLOW_56_in_ruleIntegerLiteral9166 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleIntegerLiteral9191 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral9212 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIntegerLiteral9222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral9260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral9270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral9315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral9350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral9360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral9401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleQualifiedName9497 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQualifiedName9508 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleQualifiedName9529 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_ruleSymbolReference_in_entryRuleSymbolReference9567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSymbolReference9577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSymbolReference9620 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSymbolReference9655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubscript_in_entryRuleSubscript9691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubscript9701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_ruleSubscript9748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_ruleSubscript9775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript9810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColonSubscript9820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleColonSubscript9864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript9900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionSubscript9910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionSubscript9955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator9990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixConstructionOperator10000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleMatrixConstructionOperator10035 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10056 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_18_in_ruleMatrixConstructionOperator10067 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator10088 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_38_in_ruleMatrixConstructionOperator10100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList10136 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList10146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10192 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionList10203 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10224 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitConstructionOperator10272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleUnitConstructionOperator10307 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleUnitConstructionOperator10317 = new BitSet(new long[]{0x1100200000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10338 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnitConstructionOperator10348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression10394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleParenthesizedExpression10429 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10450 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParenthesizedExpression10460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression10506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleBeginExpression10550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression10586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression10596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleEndExpression10640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression10686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleUnitExpression10729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUnitExpression10759 = new BitSet(new long[]{0x0F508020011000F0L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleUnitExpression10780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10809 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnitExpression10820 = new BitSet(new long[]{0x0100000000100010L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator10880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator10890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator10932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10965 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleUnitExpressionNumerator10976 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10997 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnitExpressionDenominator11109 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11130 = new BitSet(new long[]{0x4000000000200000L});
    public static final BitSet FOLLOW_62_in_ruleUnitExpressionDenominator11141 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11162 = new BitSet(new long[]{0x4000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleUnitExpressionDenominator11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor11221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleUnitExpressionFactor11267 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleUnitExpressionFactor11278 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent11347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnitExpressionExponent11390 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_entryRuleKeywordID11463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordID11474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordID11514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleKeywordID11538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleRelationalOperator11590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleRelationalOperator11605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleRelationalOperator11620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleRelationalOperator11635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRelationalOperator11650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleRelationalOperator11665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAddSubtractOperator11708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAddSubtractOperator11723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleMultiplyDivideOperator11766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleMultiplyDivideOperator11781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleMultiplyDivideOperator11796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplyDivideOperator11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_rulePowerOperator11854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rulePowerOperator11869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleBooleanKind11912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleBooleanKind11927 = new BitSet(new long[]{0x0000000000000002L});

}