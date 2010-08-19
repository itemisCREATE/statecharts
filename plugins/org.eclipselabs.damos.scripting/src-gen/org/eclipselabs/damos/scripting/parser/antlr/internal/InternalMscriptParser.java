package org.eclipselabs.damos.scripting.parser.antlr.internal; 

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
import org.eclipselabs.damos.scripting.services.MscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'enumeration'", "','", "'Real'", "'('", "')'", "'Integer'", "'Boolean'", "'String'", "'if'", "'elseif'", "'else'", "'then'", "':'", "'or'", "'and'", "'not'", "'-'", "'::'", "'der'", "'initial'", "'='", "'.'", "'['", "']'", "';'", "'begin'", "'end'", "'/'", "'*'", "'^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'<>'", "'+'", "'.+'", "'.-'", "'.*'", "'./'", "'.^'", "'false'", "'true'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_IDENT=4;
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
    public String getGrammarFileName() { return "../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g"; }



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
        	return classLoader.getResourceAsStream("org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.tokens");
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:78:1: entryRuleMscript returns [EObject current=null] : iv_ruleMscript= ruleMscript EOF ;
    public final EObject entryRuleMscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:79:2: (iv_ruleMscript= ruleMscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:80:2: iv_ruleMscript= ruleMscript EOF
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:87:1: ruleMscript returns [EObject current=null] : ( (lv_packages_0_0= rulePackageDefinition ) )* ;
    public final EObject ruleMscript() throws RecognitionException {
        EObject current = null;

        EObject lv_packages_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:92:6: ( ( (lv_packages_0_0= rulePackageDefinition ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_packages_0_0= rulePackageDefinition ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_packages_0_0= rulePackageDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:94:1: (lv_packages_0_0= rulePackageDefinition )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:94:1: (lv_packages_0_0= rulePackageDefinition )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:95:3: lv_packages_0_0= rulePackageDefinition
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:125:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:126:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:127:2: iv_rulePackageDefinition= rulePackageDefinition EOF
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:134:1: rulePackageDefinition returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:139:6: ( ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:140:1: ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:140:1: ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:140:3: 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_elements_3_0= rulePackageDefinitionElement ) )* '}'
            {
            match(input,12,FOLLOW_12_in_rulePackageDefinition211); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:144:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:145:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:145:1: (lv_name_1_0= ruleName )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:146:3: lv_name_1_0= ruleName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleName_in_rulePackageDefinition232);
            lv_name_1_0=ruleName();
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
            	        		"Name", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_rulePackageDefinition242); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:172:1: ( (lv_elements_3_0= rulePackageDefinitionElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:173:1: (lv_elements_3_0= rulePackageDefinitionElement )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:173:1: (lv_elements_3_0= rulePackageDefinitionElement )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:174:3: lv_elements_3_0= rulePackageDefinitionElement
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:208:1: entryRulePackageDefinitionElement returns [EObject current=null] : iv_rulePackageDefinitionElement= rulePackageDefinitionElement EOF ;
    public final EObject entryRulePackageDefinitionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinitionElement = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:209:2: (iv_rulePackageDefinitionElement= rulePackageDefinitionElement EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:210:2: iv_rulePackageDefinitionElement= rulePackageDefinitionElement EOF
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:217:1: rulePackageDefinitionElement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition ) ;
    public final EObject rulePackageDefinitionElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_EnumerationDefinition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:222:6: ( (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("223:1: (this_PackageDefinition_0= rulePackageDefinition | this_EnumerationDefinition_1= ruleEnumerationDefinition )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:224:5: this_PackageDefinition_0= rulePackageDefinition
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
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:234:5: this_EnumerationDefinition_1= ruleEnumerationDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageDefinitionElementAccess().getEnumerationDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumerationDefinition_in_rulePackageDefinitionElement394);
                    this_EnumerationDefinition_1=ruleEnumerationDefinition();
                    _fsp--;

                     
                            current = this_EnumerationDefinition_1; 
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:250:1: entryRuleEnumerationDefinition returns [EObject current=null] : iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF ;
    public final EObject entryRuleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationDefinition = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:251:2: (iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:252:2: iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition429);
            iv_ruleEnumerationDefinition=ruleEnumerationDefinition();
            _fsp--;

             current =iv_ruleEnumerationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationDefinition439); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:259:1: ruleEnumerationDefinition returns [EObject current=null] : ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )* )? '}' ) ;
    public final EObject ruleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:264:6: ( ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )* )? '}' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:265:1: ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )* )? '}' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:265:1: ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )* )? '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:265:3: 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )* )? '}'
            {
            match(input,15,FOLLOW_15_in_ruleEnumerationDefinition474); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getEnumerationKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:269:1: ( (lv_name_1_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:270:1: (lv_name_1_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:270:1: (lv_name_1_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:271:3: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleEnumerationDefinition491); 

            			createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getNameIDENTTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"IDENT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEnumerationDefinition506); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:297:1: ( ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_IDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:297:2: ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:297:2: ( (lv_literals_3_0= ruleEnumerationLiteralDefinition ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:298:1: (lv_literals_3_0= ruleEnumerationLiteralDefinition )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:298:1: (lv_literals_3_0= ruleEnumerationLiteralDefinition )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:299:3: lv_literals_3_0= ruleEnumerationLiteralDefinition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDefinitionParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralDefinition_in_ruleEnumerationDefinition528);
                    lv_literals_3_0=ruleEnumerationLiteralDefinition();
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
                    	        		"EnumerationLiteralDefinition", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:321:2: ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:321:4: ',' ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleEnumerationDefinition539); 

                    	            createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:325:1: ( (lv_literals_5_0= ruleEnumerationLiteralDefinition ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:326:1: (lv_literals_5_0= ruleEnumerationLiteralDefinition )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:326:1: (lv_literals_5_0= ruleEnumerationLiteralDefinition )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:327:3: lv_literals_5_0= ruleEnumerationLiteralDefinition
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDefinitionParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralDefinition_in_ruleEnumerationDefinition560);
                    	    lv_literals_5_0=ruleEnumerationLiteralDefinition();
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
                    	    	        		"EnumerationLiteralDefinition", 
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

            match(input,14,FOLLOW_14_in_ruleEnumerationDefinition574); 

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


    // $ANTLR start entryRuleEnumerationLiteralDefinition
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:361:1: entryRuleEnumerationLiteralDefinition returns [EObject current=null] : iv_ruleEnumerationLiteralDefinition= ruleEnumerationLiteralDefinition EOF ;
    public final EObject entryRuleEnumerationLiteralDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralDefinition = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:362:2: (iv_ruleEnumerationLiteralDefinition= ruleEnumerationLiteralDefinition EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:363:2: iv_ruleEnumerationLiteralDefinition= ruleEnumerationLiteralDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationLiteralDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationLiteralDefinition_in_entryRuleEnumerationLiteralDefinition610);
            iv_ruleEnumerationLiteralDefinition=ruleEnumerationLiteralDefinition();
            _fsp--;

             current =iv_ruleEnumerationLiteralDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralDefinition620); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnumerationLiteralDefinition


    // $ANTLR start ruleEnumerationLiteralDefinition
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:370:1: ruleEnumerationLiteralDefinition returns [EObject current=null] : ( (lv_name_0_0= RULE_IDENT ) ) ;
    public final EObject ruleEnumerationLiteralDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:375:6: ( ( (lv_name_0_0= RULE_IDENT ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:376:1: ( (lv_name_0_0= RULE_IDENT ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:376:1: ( (lv_name_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:377:1: (lv_name_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:377:1: (lv_name_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:378:3: lv_name_0_0= RULE_IDENT
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleEnumerationLiteralDefinition661); 

            			createLeafNode(grammarAccess.getEnumerationLiteralDefinitionAccess().getNameIDENTTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationLiteralDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"IDENT", 
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
    // $ANTLR end ruleEnumerationLiteralDefinition


    // $ANTLR start entryRulePrimitiveTypeSpecifier
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:410:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:411:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:412:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier703);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();
            _fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier713); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:419:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:424:6: ( (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:425:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:425:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 17:
            case 20:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case 22:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("425:1: (this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:426:5: this_NumericalTypeSpecifier_0= ruleNumericalTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericalTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier760);
                    this_NumericalTypeSpecifier_0=ruleNumericalTypeSpecifier();
                    _fsp--;

                     
                            current = this_NumericalTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:436:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier787);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();
                    _fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:446:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier814);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:462:1: entryRuleNumericalTypeSpecifier returns [EObject current=null] : iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF ;
    public final EObject entryRuleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:463:2: (iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:464:2: iv_ruleNumericalTypeSpecifier= ruleNumericalTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier849);
            iv_ruleNumericalTypeSpecifier=ruleNumericalTypeSpecifier();
            _fsp--;

             current =iv_ruleNumericalTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier859); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:471:1: ruleNumericalTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier ) ;
    public final EObject ruleNumericalTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:476:6: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:477:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:477:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("477:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:478:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier906);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();
                    _fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:488:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier933);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();
                    _fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:504:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:505:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:506:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier968);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();
            _fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier978); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:513:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () 'Real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:518:6: ( ( () 'Real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:519:1: ( () 'Real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:519:1: ( () 'Real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:519:2: () 'Real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:519:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:520:5: 
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

            match(input,17,FOLLOW_17_in_ruleRealTypeSpecifier1022); 

                    createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:534:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:534:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleRealTypeSpecifier1033); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:538:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:539:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:539:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:540:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier1054);
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

                    match(input,19,FOLLOW_19_in_ruleRealTypeSpecifier1064); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:574:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:575:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:576:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier1102);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();
            _fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier1112); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:583:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () 'Integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:588:6: ( ( () 'Integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:589:1: ( () 'Integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:589:1: ( () 'Integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:589:2: () 'Integer' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:589:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:590:5: 
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

            match(input,20,FOLLOW_20_in_ruleIntegerTypeSpecifier1156); 

                    createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntegerKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:604:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:604:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleIntegerTypeSpecifier1167); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:608:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:609:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:609:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:610:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier1188);
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

                    match(input,19,FOLLOW_19_in_ruleIntegerTypeSpecifier1198); 

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


    // $ANTLR start entryRuleBooleanTypeSpecifier
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:644:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:645:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:646:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier1236);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();
            _fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier1246); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:653:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () 'Boolean' ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:658:6: ( ( () 'Boolean' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:659:1: ( () 'Boolean' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:659:1: ( () 'Boolean' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:659:2: () 'Boolean'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:659:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:660:5: 
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

            match(input,21,FOLLOW_21_in_ruleBooleanTypeSpecifier1290); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:682:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:683:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:684:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier1326);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();
            _fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier1336); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:691:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () 'String' ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:696:6: ( ( () 'String' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:697:1: ( () 'String' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:697:1: ( () 'String' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:697:2: () 'String'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:697:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:698:5: 
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

            match(input,22,FOLLOW_22_in_ruleStringTypeSpecifier1380); 

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


    // $ANTLR start entryRuleComplexTypeSpecifier
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:720:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:721:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:722:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier1416);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();
            _fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier1426); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:729:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( (lv_name_0_0= ruleName ) ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:734:6: ( ( (lv_name_0_0= ruleName ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:735:1: ( (lv_name_0_0= ruleName ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:735:1: ( (lv_name_0_0= ruleName ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:736:1: (lv_name_0_0= ruleName )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:736:1: (lv_name_0_0= ruleName )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:737:3: lv_name_0_0= ruleName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getNameNameParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleName_in_ruleComplexTypeSpecifier1471);
            lv_name_0_0=ruleName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"Name", 
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
    // $ANTLR end ruleComplexTypeSpecifier


    // $ANTLR start entryRuleExpression
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:767:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:768:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:769:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1506);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1516); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:776:1: ruleExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        EObject this_RangeExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:781:6: ( (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:782:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:782:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=RULE_IDENT && LA10_0<=RULE_STRING)||LA10_0==13||LA10_0==18||(LA10_0>=30 && LA10_0<=34)||(LA10_0>=36 && LA10_0<=37)||(LA10_0>=40 && LA10_0<=41)||(LA10_0>=57 && LA10_0<=58)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("782:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:783:5: this_ConditionalExpression_0= ruleConditionalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression1563);
                    this_ConditionalExpression_0=ruleConditionalExpression();
                    _fsp--;

                     
                            current = this_ConditionalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:793:5: this_RangeExpression_1= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression1590);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:809:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:810:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:811:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1625);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression1635); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:818:1: ruleConditionalExpression returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:823:6: ( ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:824:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:824:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:824:3: 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,23,FOLLOW_23_in_ruleConditionalExpression1670); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:828:1: ( (lv_cases_1_0= ruleConditionalExpressionCase ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:829:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:829:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:830:3: lv_cases_1_0= ruleConditionalExpressionCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression1691);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:852:2: ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:852:4: 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    {
            	    match(input,24,FOLLOW_24_in_ruleConditionalExpression1702); 

            	            createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:856:1: ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:857:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:857:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:858:3: lv_cases_3_0= ruleConditionalExpressionCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression1723);
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
            	    break loop11;
                }
            } while (true);

            match(input,25,FOLLOW_25_in_ruleConditionalExpression1735); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseKeyword_3(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:884:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:885:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:885:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:886:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getElseExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpression1756);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:916:1: entryRuleConditionalExpressionCase returns [EObject current=null] : iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF ;
    public final EObject entryRuleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressionCase = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:917:2: (iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:918:2: iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase1792);
            iv_ruleConditionalExpressionCase=ruleConditionalExpressionCase();
            _fsp--;

             current =iv_ruleConditionalExpressionCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpressionCase1802); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:925:1: ruleConditionalExpressionCase returns [EObject current=null] : ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject lv_conditionExpression_0_0 = null;

        EObject lv_thenExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:930:6: ( ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:931:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:931:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:931:2: ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:931:2: ( (lv_conditionExpression_0_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:932:1: (lv_conditionExpression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:932:1: (lv_conditionExpression_0_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:933:3: lv_conditionExpression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getConditionExpressionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1848);
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

            match(input,26,FOLLOW_26_in_ruleConditionalExpressionCase1858); 

                    createLeafNode(grammarAccess.getConditionalExpressionCaseAccess().getThenKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:959:1: ( (lv_thenExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:960:1: (lv_thenExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:960:1: (lv_thenExpression_2_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:961:3: lv_thenExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getThenExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1879);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:991:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:992:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:993:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression1915);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression1925); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1000:1: ruleRangeExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_expressions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1005:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1006:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1006:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1007:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1972);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1015:1: ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1015:2: () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )?
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1015:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1016:5: 
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

                    match(input,27,FOLLOW_27_in_ruleRangeExpression1991); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1035:1: ( (lv_expressions_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1036:1: (lv_expressions_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1036:1: (lv_expressions_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1037:3: lv_expressions_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getExpressionsLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression2012);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1059:2: ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==27) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1059:4: ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) )
                            {
                            match(input,27,FOLLOW_27_in_ruleRangeExpression2023); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_0(), null); 
                                
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1063:1: ( (lv_expressions_5_0= ruleLogicalOrExpression ) )
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1064:1: (lv_expressions_5_0= ruleLogicalOrExpression )
                            {
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1064:1: (lv_expressions_5_0= ruleLogicalOrExpression )
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1065:3: lv_expressions_5_0= ruleLogicalOrExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getExpressionsLogicalOrExpressionParserRuleCall_1_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression2044);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1095:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1096:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1097:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression2084);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression2094); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1104:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1109:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1110:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1110:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1111:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression2141);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1119:1: ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1119:2: () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1119:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1120:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1135:2: ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==28) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1135:4: 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,28,FOLLOW_28_in_ruleLogicalOrExpression2161); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1139:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1140:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1140:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1141:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression2182);
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
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1171:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1172:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1173:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression2222);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression2232); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1180:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1185:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1186:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1186:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1187:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression2279);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1195:1: ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1195:2: () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1195:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1196:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1211:2: ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==29) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1211:4: 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    {
                    	    match(input,29,FOLLOW_29_in_ruleLogicalAndExpression2299); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1215:1: ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1216:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1216:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1217:3: lv_operands_3_0= ruleLogicalNotExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsLogicalNotExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression2320);
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
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1247:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1248:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1249:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression2360);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression2370); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1256:1: ruleLogicalNotExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1261:6: ( (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1262:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1262:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_IDENT && LA18_0<=RULE_STRING)||LA18_0==13||LA18_0==18||(LA18_0>=31 && LA18_0<=34)||(LA18_0>=36 && LA18_0<=37)||(LA18_0>=40 && LA18_0<=41)||(LA18_0>=57 && LA18_0<=58)) ) {
                alt18=1;
            }
            else if ( (LA18_0==30) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1262:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1263:5: this_RelationalExpression_0= ruleRelationalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression2417);
                    this_RelationalExpression_0=ruleRelationalExpression();
                    _fsp--;

                     
                            current = this_RelationalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1272:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1272:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1272:7: () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1272:7: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1273:5: 
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

                    match(input,30,FOLLOW_30_in_ruleLogicalNotExpression2442); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getNotKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1287:1: ( (lv_operand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1288:1: (lv_operand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1288:1: (lv_operand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1289:3: lv_operand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression2463);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1319:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1320:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1321:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression2500);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression2510); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1328:1: ruleRelationalExpression returns [EObject current=null] : (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddSubtractExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1333:6: ( (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1334:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1334:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1335:5: this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression2557);
            this_AddSubtractExpression_0=ruleAddSubtractExpression();
            _fsp--;

             
                    current = this_AddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1343:1: ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=45 && LA20_0<=50)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1343:2: () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1343:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1344:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1359:2: ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=45 && LA19_0<=50)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1359:3: ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1359:3: ( (lv_operators_2_0= ruleRelationalOperator ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1360:1: (lv_operators_2_0= ruleRelationalOperator )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1360:1: (lv_operators_2_0= ruleRelationalOperator )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1361:3: lv_operators_2_0= ruleRelationalOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorsRelationalOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression2588);
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

                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1383:2: ( (lv_operands_3_0= ruleAddSubtractExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1384:1: (lv_operands_3_0= ruleAddSubtractExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1384:1: (lv_operands_3_0= ruleAddSubtractExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1385:3: lv_operands_3_0= ruleAddSubtractExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperandsAddSubtractExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression2609);
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
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1415:1: entryRuleAddSubtractExpression returns [EObject current=null] : iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF ;
    public final EObject entryRuleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddSubtractExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1416:2: (iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1417:2: iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression2649);
            iv_ruleAddSubtractExpression=ruleAddSubtractExpression();
            _fsp--;

             current =iv_ruleAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddSubtractExpression2659); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1424:1: ruleAddSubtractExpression returns [EObject current=null] : (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) ;
    public final EObject ruleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplyDivideExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1429:6: ( (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1430:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1430:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1431:5: this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression2706);
            this_MultiplyDivideExpression_0=ruleMultiplyDivideExpression();
            _fsp--;

             
                    current = this_MultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1439:1: ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31||(LA22_0>=51 && LA22_0<=53)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1439:2: () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1439:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1440:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1455:2: ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==31||(LA21_0>=51 && LA21_0<=53)) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1455:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1455:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1456:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1456:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1457:3: lv_operators_2_0= ruleAddSubtractOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperatorsAddSubtractOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression2737);
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

                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1479:2: ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1480:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1480:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1481:3: lv_operands_3_0= ruleMultiplyDivideExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperandsMultiplyDivideExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression2758);
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
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1511:1: entryRuleMultiplyDivideExpression returns [EObject current=null] : iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF ;
    public final EObject entryRuleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1512:2: (iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1513:2: iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression2798);
            iv_ruleMultiplyDivideExpression=ruleMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyDivideExpression2808); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1520:1: ruleMultiplyDivideExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) ;
    public final EObject ruleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1525:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1526:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1526:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1527:5: this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2855);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1535:1: ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=42 && LA24_0<=43)||(LA24_0>=54 && LA24_0<=55)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1535:2: () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1535:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1536:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1551:2: ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>=42 && LA23_0<=43)||(LA23_0>=54 && LA23_0<=55)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1551:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1551:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1552:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1552:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1553:3: lv_operators_2_0= ruleMultiplyDivideOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperatorsMultiplyDivideOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression2886);
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

                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1575:2: ( (lv_operands_3_0= rulePowerExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1576:1: (lv_operands_3_0= rulePowerExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1576:1: (lv_operands_3_0= rulePowerExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1577:3: lv_operands_3_0= rulePowerExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperandsPowerExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2907);
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
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1607:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1608:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1609:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression2947);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression2957); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1616:1: rulePowerExpression returns [EObject current=null] : (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryMinusExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1621:6: ( (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1622:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1622:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1623:5: this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryMinusExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression3004);
            this_UnaryMinusExpression_0=ruleUnaryMinusExpression();
            _fsp--;

             
                    current = this_UnaryMinusExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1631:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==44||LA25_0==56) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1631:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1631:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1632:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1647:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1648:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1648:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1649:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression3034);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1671:2: ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1672:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1672:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1673:3: lv_exponent_3_0= ruleUnaryMinusExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryMinusExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression3055);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1703:1: entryRuleUnaryMinusExpression returns [EObject current=null] : iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF ;
    public final EObject entryRuleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryMinusExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1704:2: (iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1705:2: iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryMinusExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression3093);
            iv_ruleUnaryMinusExpression=ruleUnaryMinusExpression();
            _fsp--;

             current =iv_ruleUnaryMinusExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryMinusExpression3103); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1712:1: ruleUnaryMinusExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1717:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1718:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1718:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_IDENT && LA26_0<=RULE_STRING)||LA26_0==13||LA26_0==18||(LA26_0>=32 && LA26_0<=34)||(LA26_0>=36 && LA26_0<=37)||(LA26_0>=40 && LA26_0<=41)||(LA26_0>=57 && LA26_0<=58)) ) {
                alt26=1;
            }
            else if ( (LA26_0==31) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1718:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1719:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression3150);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1728:6: ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1728:6: ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1728:7: () '-' ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1728:7: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1729:5: 
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

                    match(input,31,FOLLOW_31_in_ruleUnaryMinusExpression3175); 

                            createLeafNode(grammarAccess.getUnaryMinusExpressionAccess().getHyphenMinusKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1743:1: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1744:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1744:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1745:3: lv_operand_3_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression3196);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1775:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1776:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1777:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3233);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3243); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1784:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_ComponentReference_2 = null;

        EObject this_ParenthesizedExpression_3 = null;

        EObject this_ArrayConcatenationOperator_4 = null;

        EObject this_ArrayConstructionOperator_5 = null;

        EObject this_BeginExpression_6 = null;

        EObject this_EndExpression_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1789:6: ( (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1790:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1790:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )
            int alt27=8;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 57:
            case 58:
                {
                alt27=1;
                }
                break;
            case 32:
            case 33:
            case 34:
                {
                alt27=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA27_3 = input.LA(2);

                if ( (LA27_3==18||LA27_3==32) ) {
                    alt27=2;
                }
                else if ( (LA27_3==EOF||LA27_3==14||LA27_3==16||LA27_3==19||(LA27_3>=24 && LA27_3<=29)||LA27_3==31||(LA27_3>=36 && LA27_3<=39)||(LA27_3>=42 && LA27_3<=56)) ) {
                    alt27=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1790:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )", 27, 3, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt27=3;
                }
                break;
            case 18:
                {
                alt27=4;
                }
                break;
            case 37:
                {
                alt27=5;
                }
                break;
            case 13:
                {
                alt27=6;
                }
                break;
            case 40:
                {
                alt27=7;
                }
                break;
            case 41:
                {
                alt27=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1790:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1791:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression3290);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1801:5: this_FunctionCall_1= ruleFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3317);
                    this_FunctionCall_1=ruleFunctionCall();
                    _fsp--;

                     
                            current = this_FunctionCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1811:5: this_ComponentReference_2= ruleComponentReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getComponentReferenceParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComponentReference_in_rulePrimaryExpression3344);
                    this_ComponentReference_2=ruleComponentReference();
                    _fsp--;

                     
                            current = this_ComponentReference_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1821:5: this_ParenthesizedExpression_3= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3371);
                    this_ParenthesizedExpression_3=ruleParenthesizedExpression();
                    _fsp--;

                     
                            current = this_ParenthesizedExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1831:5: this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArrayConcatenationOperatorParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_rulePrimaryExpression3398);
                    this_ArrayConcatenationOperator_4=ruleArrayConcatenationOperator();
                    _fsp--;

                     
                            current = this_ArrayConcatenationOperator_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1841:5: this_ArrayConstructionOperator_5= ruleArrayConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArrayConstructionOperatorParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayConstructionOperator_in_rulePrimaryExpression3425);
                    this_ArrayConstructionOperator_5=ruleArrayConstructionOperator();
                    _fsp--;

                     
                            current = this_ArrayConstructionOperator_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1851:5: this_BeginExpression_6= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression3452);
                    this_BeginExpression_6=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1861:5: this_EndExpression_7= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression3479);
                    this_EndExpression_7=ruleEndExpression();
                    _fsp--;

                     
                            current = this_EndExpression_7; 
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1877:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1878:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1879:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3514);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3524); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1886:1: ruleLiteral returns [EObject current=null] : (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1891:6: ( (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1892:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1892:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt28=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt28=1;
                }
                break;
            case 57:
            case 58:
                {
                alt28=2;
                }
                break;
            case RULE_STRING:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1892:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1893:5: this_NumericalLiteral_0= ruleNumericalLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericalLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalLiteral_in_ruleLiteral3571);
                    this_NumericalLiteral_0=ruleNumericalLiteral();
                    _fsp--;

                     
                            current = this_NumericalLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1903:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral3598);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1913:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral3625);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1929:1: entryRuleNumericalLiteral returns [EObject current=null] : iv_ruleNumericalLiteral= ruleNumericalLiteral EOF ;
    public final EObject entryRuleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1930:2: (iv_ruleNumericalLiteral= ruleNumericalLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1931:2: iv_ruleNumericalLiteral= ruleNumericalLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral3660);
            iv_ruleNumericalLiteral=ruleNumericalLiteral();
            _fsp--;

             current =iv_ruleNumericalLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalLiteral3670); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1938:1: ruleNumericalLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1943:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1944:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1944:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_REAL) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_INTEGER) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1944:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1945:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral3717);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1955:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral3744);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1971:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1972:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1973:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3779);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral3789); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1980:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1985:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1986:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1986:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1986:2: ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1986:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1987:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1987:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1988:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral3831); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2010:2: ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==18) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2010:4: '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleRealLiteral3847); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2014:1: ( (lv_unit_2_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2015:1: (lv_unit_2_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2015:1: (lv_unit_2_0= ruleUnitExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2016:3: lv_unit_2_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral3868);
                    lv_unit_2_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
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

                    match(input,19,FOLLOW_19_in_ruleRealLiteral3878); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getRightParenthesisKeyword_1_2(), null); 
                        

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2050:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2051:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2052:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral3916);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral3926); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2059:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2064:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2065:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2065:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2065:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2065:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2066:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2066:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2067:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral3968); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2089:2: ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==18) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2089:4: '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleIntegerLiteral3984); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2093:1: ( (lv_unit_2_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2094:1: (lv_unit_2_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2094:1: (lv_unit_2_0= ruleUnitExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2095:3: lv_unit_2_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral4005);
                    lv_unit_2_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
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

                    match(input,19,FOLLOW_19_in_ruleIntegerLiteral4015); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getRightParenthesisKeyword_1_2(), null); 
                        

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2129:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2130:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2131:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral4053);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral4063); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2138:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2143:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2144:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2144:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2145:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2145:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2146:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral4108);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2176:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2177:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2178:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4143);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral4153); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2185:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2190:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2191:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2191:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2192:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2192:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2193:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral4194); 

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


    // $ANTLR start entryRuleFunctionCall
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2223:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2224:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2225:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall4234);
            iv_ruleFunctionCall=ruleFunctionCall();
            _fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall4244); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFunctionCall


    // $ANTLR start ruleFunctionCall
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2232:1: ruleFunctionCall returns [EObject current=null] : (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject this_NamedFunctionCall_0 = null;

        EObject this_KeywordFunctionCall_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2237:6: ( (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2238:1: (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2238:1: (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_IDENT||LA32_0==32) ) {
                alt32=1;
            }
            else if ( ((LA32_0>=33 && LA32_0<=34)) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2238:1: (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2239:5: this_NamedFunctionCall_0= ruleNamedFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFunctionCallAccess().getNamedFunctionCallParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedFunctionCall_in_ruleFunctionCall4291);
                    this_NamedFunctionCall_0=ruleNamedFunctionCall();
                    _fsp--;

                     
                            current = this_NamedFunctionCall_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2249:5: this_KeywordFunctionCall_1= ruleKeywordFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFunctionCallAccess().getKeywordFunctionCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeywordFunctionCall_in_ruleFunctionCall4318);
                    this_KeywordFunctionCall_1=ruleKeywordFunctionCall();
                    _fsp--;

                     
                            current = this_KeywordFunctionCall_1; 
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
    // $ANTLR end ruleFunctionCall


    // $ANTLR start entryRuleNamedFunctionCall
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2265:1: entryRuleNamedFunctionCall returns [EObject current=null] : iv_ruleNamedFunctionCall= ruleNamedFunctionCall EOF ;
    public final EObject entryRuleNamedFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedFunctionCall = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2266:2: (iv_ruleNamedFunctionCall= ruleNamedFunctionCall EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2267:2: iv_ruleNamedFunctionCall= ruleNamedFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedFunctionCall_in_entryRuleNamedFunctionCall4353);
            iv_ruleNamedFunctionCall=ruleNamedFunctionCall();
            _fsp--;

             current =iv_ruleNamedFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedFunctionCall4363); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNamedFunctionCall


    // $ANTLR start ruleNamedFunctionCall
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2274:1: ruleNamedFunctionCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) ;
    public final EObject ruleNamedFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_argumentList_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2279:6: ( ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2280:1: ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2280:1: ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2280:2: ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2280:2: ( (lv_name_0_0= ruleName ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2281:1: (lv_name_0_0= ruleName )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2281:1: (lv_name_0_0= ruleName )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2282:3: lv_name_0_0= ruleName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedFunctionCallAccess().getNameNameParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleName_in_ruleNamedFunctionCall4409);
            lv_name_0_0=ruleName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedFunctionCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"Name", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleNamedFunctionCall4419); 

                    createLeafNode(grammarAccess.getNamedFunctionCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2308:1: ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_IDENT && LA33_0<=RULE_STRING)||LA33_0==13||LA33_0==18||LA33_0==23||(LA33_0>=30 && LA33_0<=34)||(LA33_0>=36 && LA33_0<=37)||(LA33_0>=40 && LA33_0<=41)||(LA33_0>=57 && LA33_0<=58)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2309:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2309:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2310:3: lv_argumentList_2_0= ruleFunctionArgumentList
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedFunctionCallAccess().getArgumentListFunctionArgumentListParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFunctionArgumentList_in_ruleNamedFunctionCall4440);
                    lv_argumentList_2_0=ruleFunctionArgumentList();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedFunctionCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"argumentList",
                    	        		lv_argumentList_2_0, 
                    	        		"FunctionArgumentList", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleNamedFunctionCall4451); 

                    createLeafNode(grammarAccess.getNamedFunctionCallAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamedFunctionCall


    // $ANTLR start entryRuleName
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2344:1: entryRuleName returns [EObject current=null] : iv_ruleName= ruleName EOF ;
    public final EObject entryRuleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleName = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2345:2: (iv_ruleName= ruleName EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2346:2: iv_ruleName= ruleName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleName_in_entryRuleName4487);
            iv_ruleName=ruleName();
            _fsp--;

             current =iv_ruleName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleName4497); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleName


    // $ANTLR start ruleName
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2353:1: ruleName returns [EObject current=null] : ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* ) ;
    public final EObject ruleName() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        Token lv_identifiers_1_0=null;
        Token lv_identifiers_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2358:6: ( ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2359:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2359:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2359:2: ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2359:2: ( (lv_global_0_0= '::' ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2360:1: (lv_global_0_0= '::' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2360:1: (lv_global_0_0= '::' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2361:3: lv_global_0_0= '::'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_ruleName4540); 

                            createLeafNode(grammarAccess.getNameAccess().getGlobalColonColonKeyword_0_0(), "global"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNameRule().getType().getClassifier());
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2380:3: ( (lv_identifiers_1_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2381:1: (lv_identifiers_1_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2381:1: (lv_identifiers_1_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2382:3: lv_identifiers_1_0= RULE_IDENT
            {
            lv_identifiers_1_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleName4571); 

            			createLeafNode(grammarAccess.getNameAccess().getIdentifiersIDENTTerminalRuleCall_1_0(), "identifiers"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"identifiers",
            	        		lv_identifiers_1_0, 
            	        		"IDENT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2404:2: ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==32) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2404:4: '::' ( (lv_identifiers_3_0= RULE_IDENT ) )
            	    {
            	    match(input,32,FOLLOW_32_in_ruleName4587); 

            	            createLeafNode(grammarAccess.getNameAccess().getColonColonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2408:1: ( (lv_identifiers_3_0= RULE_IDENT ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2409:1: (lv_identifiers_3_0= RULE_IDENT )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2409:1: (lv_identifiers_3_0= RULE_IDENT )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2410:3: lv_identifiers_3_0= RULE_IDENT
            	    {
            	    lv_identifiers_3_0=(Token)input.LT(1);
            	    match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleName4604); 

            	    			createLeafNode(grammarAccess.getNameAccess().getIdentifiersIDENTTerminalRuleCall_2_1_0(), "identifiers"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNameRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"identifiers",
            	    	        		lv_identifiers_3_0, 
            	    	        		"IDENT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end ruleName


    // $ANTLR start entryRuleKeywordFunctionCall
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2440:1: entryRuleKeywordFunctionCall returns [EObject current=null] : iv_ruleKeywordFunctionCall= ruleKeywordFunctionCall EOF ;
    public final EObject entryRuleKeywordFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordFunctionCall = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2441:2: (iv_ruleKeywordFunctionCall= ruleKeywordFunctionCall EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2442:2: iv_ruleKeywordFunctionCall= ruleKeywordFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeywordFunctionCall_in_entryRuleKeywordFunctionCall4647);
            iv_ruleKeywordFunctionCall=ruleKeywordFunctionCall();
            _fsp--;

             current =iv_ruleKeywordFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordFunctionCall4657); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleKeywordFunctionCall


    // $ANTLR start ruleKeywordFunctionCall
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2449:1: ruleKeywordFunctionCall returns [EObject current=null] : ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) ;
    public final EObject ruleKeywordFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        EObject lv_argumentList_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2454:6: ( ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2455:1: ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2455:1: ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2455:2: ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2455:2: ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2456:1: ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2456:1: ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2457:1: (lv_name_0_1= 'der' | lv_name_0_2= 'initial' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2457:1: (lv_name_0_1= 'der' | lv_name_0_2= 'initial' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==33) ) {
                alt36=1;
            }
            else if ( (LA36_0==34) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2457:1: (lv_name_0_1= 'der' | lv_name_0_2= 'initial' )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2458:3: lv_name_0_1= 'der'
                    {
                    lv_name_0_1=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_ruleKeywordFunctionCall4702); 

                            createLeafNode(grammarAccess.getKeywordFunctionCallAccess().getNameDerKeyword_0_0_0(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getKeywordFunctionCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_0_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2476:8: lv_name_0_2= 'initial'
                    {
                    lv_name_0_2=(Token)input.LT(1);
                    match(input,34,FOLLOW_34_in_ruleKeywordFunctionCall4731); 

                            createLeafNode(grammarAccess.getKeywordFunctionCallAccess().getNameInitialKeyword_0_0_1(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getKeywordFunctionCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_0_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

            match(input,18,FOLLOW_18_in_ruleKeywordFunctionCall4757); 

                    createLeafNode(grammarAccess.getKeywordFunctionCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2501:1: ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_IDENT && LA37_0<=RULE_STRING)||LA37_0==13||LA37_0==18||LA37_0==23||(LA37_0>=30 && LA37_0<=34)||(LA37_0>=36 && LA37_0<=37)||(LA37_0>=40 && LA37_0<=41)||(LA37_0>=57 && LA37_0<=58)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2502:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2502:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2503:3: lv_argumentList_2_0= ruleFunctionArgumentList
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getKeywordFunctionCallAccess().getArgumentListFunctionArgumentListParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFunctionArgumentList_in_ruleKeywordFunctionCall4778);
                    lv_argumentList_2_0=ruleFunctionArgumentList();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getKeywordFunctionCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"argumentList",
                    	        		lv_argumentList_2_0, 
                    	        		"FunctionArgumentList", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleKeywordFunctionCall4789); 

                    createLeafNode(grammarAccess.getKeywordFunctionCallAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKeywordFunctionCall


    // $ANTLR start entryRuleFunctionArgumentList
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2537:1: entryRuleFunctionArgumentList returns [EObject current=null] : iv_ruleFunctionArgumentList= ruleFunctionArgumentList EOF ;
    public final EObject entryRuleFunctionArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionArgumentList = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2538:2: (iv_ruleFunctionArgumentList= ruleFunctionArgumentList EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2539:2: iv_ruleFunctionArgumentList= ruleFunctionArgumentList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionArgumentListRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionArgumentList_in_entryRuleFunctionArgumentList4825);
            iv_ruleFunctionArgumentList=ruleFunctionArgumentList();
            _fsp--;

             current =iv_ruleFunctionArgumentList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionArgumentList4835); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFunctionArgumentList


    // $ANTLR start ruleFunctionArgumentList
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2546:1: ruleFunctionArgumentList returns [EObject current=null] : ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) ) ;
    public final EObject ruleFunctionArgumentList() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_namedArguments_4_0 = null;

        EObject lv_namedArguments_5_0 = null;

        EObject lv_namedArguments_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2551:6: ( ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2552:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2552:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_REAL && LA41_0<=RULE_STRING)||LA41_0==13||LA41_0==18||LA41_0==23||(LA41_0>=30 && LA41_0<=34)||(LA41_0>=36 && LA41_0<=37)||(LA41_0>=40 && LA41_0<=41)||(LA41_0>=57 && LA41_0<=58)) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_IDENT) ) {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==35) ) {
                    alt41=2;
                }
                else if ( (LA41_2==EOF||LA41_2==14||LA41_2==16||(LA41_2>=18 && LA41_2<=19)||(LA41_2>=27 && LA41_2<=29)||(LA41_2>=31 && LA41_2<=32)||(LA41_2>=36 && LA41_2<=37)||(LA41_2>=42 && LA41_2<=56)) ) {
                    alt41=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("2552:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )", 41, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2552:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2552:2: ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2552:2: ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2552:3: ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2552:3: ( (lv_arguments_0_0= ruleExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2553:1: (lv_arguments_0_0= ruleExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2553:1: (lv_arguments_0_0= ruleExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2554:3: lv_arguments_0_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getArgumentsExpressionParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionArgumentList4882);
                    lv_arguments_0_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionArgumentListRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"arguments",
                    	        		lv_arguments_0_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2576:2: ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2576:3: ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2576:3: ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==16) ) {
                            int LA38_1 = input.LA(2);

                            if ( ((LA38_1>=RULE_REAL && LA38_1<=RULE_STRING)||LA38_1==13||LA38_1==18||LA38_1==23||(LA38_1>=30 && LA38_1<=34)||(LA38_1>=36 && LA38_1<=37)||(LA38_1>=40 && LA38_1<=41)||(LA38_1>=57 && LA38_1<=58)) ) {
                                alt38=1;
                            }
                            else if ( (LA38_1==RULE_IDENT) ) {
                                int LA38_4 = input.LA(3);

                                if ( (LA38_4==EOF||LA38_4==14||LA38_4==16||(LA38_4>=18 && LA38_4<=19)||(LA38_4>=27 && LA38_4<=29)||(LA38_4>=31 && LA38_4<=32)||(LA38_4>=36 && LA38_4<=37)||(LA38_4>=42 && LA38_4<=56)) ) {
                                    alt38=1;
                                }


                            }


                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2576:5: ',' ( (lv_arguments_2_0= ruleExpression ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionArgumentList4894); 

                    	            createLeafNode(grammarAccess.getFunctionArgumentListAccess().getCommaKeyword_0_1_0_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2580:1: ( (lv_arguments_2_0= ruleExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2581:1: (lv_arguments_2_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2581:1: (lv_arguments_2_0= ruleExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2582:3: lv_arguments_2_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getArgumentsExpressionParserRuleCall_0_1_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionArgumentList4915);
                    	    lv_arguments_2_0=ruleExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionArgumentListRule().getType().getClassifier());
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


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2604:4: ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==16) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2604:6: ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionArgumentList4928); 

                    	            createLeafNode(grammarAccess.getFunctionArgumentListAccess().getCommaKeyword_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2608:1: ( (lv_namedArguments_4_0= ruleNamedArgument ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2609:1: (lv_namedArguments_4_0= ruleNamedArgument )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2609:1: (lv_namedArguments_4_0= ruleNamedArgument )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2610:3: lv_namedArguments_4_0= ruleNamedArgument
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getNamedArgumentsNamedArgumentParserRuleCall_0_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4949);
                    	    lv_namedArguments_4_0=ruleNamedArgument();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionArgumentListRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"namedArguments",
                    	    	        		lv_namedArguments_4_0, 
                    	    	        		"NamedArgument", 
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


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2633:6: ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2633:6: ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2633:7: ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2633:7: ( (lv_namedArguments_5_0= ruleNamedArgument ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2634:1: (lv_namedArguments_5_0= ruleNamedArgument )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2634:1: (lv_namedArguments_5_0= ruleNamedArgument )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2635:3: lv_namedArguments_5_0= ruleNamedArgument
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getNamedArgumentsNamedArgumentParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4981);
                    lv_namedArguments_5_0=ruleNamedArgument();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionArgumentListRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"namedArguments",
                    	        		lv_namedArguments_5_0, 
                    	        		"NamedArgument", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2657:2: ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==16) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2657:4: ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionArgumentList4992); 

                    	            createLeafNode(grammarAccess.getFunctionArgumentListAccess().getCommaKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2661:1: ( (lv_namedArguments_7_0= ruleNamedArgument ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2662:1: (lv_namedArguments_7_0= ruleNamedArgument )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2662:1: (lv_namedArguments_7_0= ruleNamedArgument )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2663:3: lv_namedArguments_7_0= ruleNamedArgument
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getNamedArgumentsNamedArgumentParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList5013);
                    	    lv_namedArguments_7_0=ruleNamedArgument();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionArgumentListRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"namedArguments",
                    	    	        		lv_namedArguments_7_0, 
                    	    	        		"NamedArgument", 
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
    // $ANTLR end ruleFunctionArgumentList


    // $ANTLR start entryRuleNamedArgument
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2693:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2694:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2695:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedArgumentRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument5052);
            iv_ruleNamedArgument=ruleNamedArgument();
            _fsp--;

             current =iv_ruleNamedArgument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument5062); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNamedArgument


    // $ANTLR start ruleNamedArgument
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2702:1: ruleNamedArgument returns [EObject current=null] : ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2707:6: ( ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2708:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2708:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2708:2: ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2708:2: ( (lv_identifier_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2709:1: (lv_identifier_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2709:1: (lv_identifier_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2710:3: lv_identifier_0_0= RULE_IDENT
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleNamedArgument5104); 

            			createLeafNode(grammarAccess.getNamedArgumentAccess().getIdentifierIDENTTerminalRuleCall_0_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedArgumentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_0_0, 
            	        		"IDENT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,35,FOLLOW_35_in_ruleNamedArgument5119); 

                    createLeafNode(grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2736:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2737:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2737:1: (lv_expression_2_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2738:3: lv_expression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedArgumentAccess().getExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument5140);
            lv_expression_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedArgumentRule().getType().getClassifier());
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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamedArgument


    // $ANTLR start entryRuleComponentReference
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2768:1: entryRuleComponentReference returns [EObject current=null] : iv_ruleComponentReference= ruleComponentReference EOF ;
    public final EObject entryRuleComponentReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentReference = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2769:2: (iv_ruleComponentReference= ruleComponentReference EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2770:2: iv_ruleComponentReference= ruleComponentReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComponentReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleComponentReference_in_entryRuleComponentReference5176);
            iv_ruleComponentReference=ruleComponentReference();
            _fsp--;

             current =iv_ruleComponentReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentReference5186); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2777:1: ruleComponentReference returns [EObject current=null] : ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* ) ;
    public final EObject ruleComponentReference() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        EObject lv_segments_1_0 = null;

        EObject lv_segments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2782:6: ( ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2783:1: ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2783:1: ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2783:2: ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2783:2: ( (lv_global_0_0= '.' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==36) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2784:1: (lv_global_0_0= '.' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2784:1: (lv_global_0_0= '.' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2785:3: lv_global_0_0= '.'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,36,FOLLOW_36_in_ruleComponentReference5229); 

                            createLeafNode(grammarAccess.getComponentReferenceAccess().getGlobalFullStopKeyword_0_0(), "global"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComponentReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "global", true, ".", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2804:3: ( (lv_segments_1_0= ruleComponentReferenceSegment ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2805:1: (lv_segments_1_0= ruleComponentReferenceSegment )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2805:1: (lv_segments_1_0= ruleComponentReferenceSegment )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2806:3: lv_segments_1_0= ruleComponentReferenceSegment
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getComponentReferenceAccess().getSegmentsComponentReferenceSegmentParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference5264);
            lv_segments_1_0=ruleComponentReferenceSegment();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getComponentReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"segments",
            	        		lv_segments_1_0, 
            	        		"ComponentReferenceSegment", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2828:2: ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==36) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2828:4: '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) )
            	    {
            	    match(input,36,FOLLOW_36_in_ruleComponentReference5275); 

            	            createLeafNode(grammarAccess.getComponentReferenceAccess().getFullStopKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2832:1: ( (lv_segments_3_0= ruleComponentReferenceSegment ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2833:1: (lv_segments_3_0= ruleComponentReferenceSegment )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2833:1: (lv_segments_3_0= ruleComponentReferenceSegment )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2834:3: lv_segments_3_0= ruleComponentReferenceSegment
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getComponentReferenceAccess().getSegmentsComponentReferenceSegmentParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference5296);
            	    lv_segments_3_0=ruleComponentReferenceSegment();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getComponentReferenceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"segments",
            	    	        		lv_segments_3_0, 
            	    	        		"ComponentReferenceSegment", 
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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start entryRuleComponentReferenceSegment
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2864:1: entryRuleComponentReferenceSegment returns [EObject current=null] : iv_ruleComponentReferenceSegment= ruleComponentReferenceSegment EOF ;
    public final EObject entryRuleComponentReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentReferenceSegment = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2865:2: (iv_ruleComponentReferenceSegment= ruleComponentReferenceSegment EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2866:2: iv_ruleComponentReferenceSegment= ruleComponentReferenceSegment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComponentReferenceSegmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleComponentReferenceSegment_in_entryRuleComponentReferenceSegment5334);
            iv_ruleComponentReferenceSegment=ruleComponentReferenceSegment();
            _fsp--;

             current =iv_ruleComponentReferenceSegment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentReferenceSegment5344); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleComponentReferenceSegment


    // $ANTLR start ruleComponentReferenceSegment
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2873:1: ruleComponentReferenceSegment returns [EObject current=null] : ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? ) ;
    public final EObject ruleComponentReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        EObject lv_subscriptList_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2878:6: ( ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2879:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2879:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2879:2: ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2879:2: ( (lv_identifier_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2880:1: (lv_identifier_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2880:1: (lv_identifier_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2881:3: lv_identifier_0_0= RULE_IDENT
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleComponentReferenceSegment5386); 

            			createLeafNode(grammarAccess.getComponentReferenceSegmentAccess().getIdentifierIDENTTerminalRuleCall_0_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getComponentReferenceSegmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_0_0, 
            	        		"IDENT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2903:2: ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==37) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2904:1: (lv_subscriptList_1_0= ruleArraySubscriptList )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2904:1: (lv_subscriptList_1_0= ruleArraySubscriptList )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2905:3: lv_subscriptList_1_0= ruleArraySubscriptList
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComponentReferenceSegmentAccess().getSubscriptListArraySubscriptListParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArraySubscriptList_in_ruleComponentReferenceSegment5412);
                    lv_subscriptList_1_0=ruleArraySubscriptList();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComponentReferenceSegmentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"subscriptList",
                    	        		lv_subscriptList_1_0, 
                    	        		"ArraySubscriptList", 
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
    // $ANTLR end ruleComponentReferenceSegment


    // $ANTLR start entryRuleArraySubscriptList
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2935:1: entryRuleArraySubscriptList returns [EObject current=null] : iv_ruleArraySubscriptList= ruleArraySubscriptList EOF ;
    public final EObject entryRuleArraySubscriptList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySubscriptList = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2936:2: (iv_ruleArraySubscriptList= ruleArraySubscriptList EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2937:2: iv_ruleArraySubscriptList= ruleArraySubscriptList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArraySubscriptListRule(), currentNode); 
            pushFollow(FOLLOW_ruleArraySubscriptList_in_entryRuleArraySubscriptList5449);
            iv_ruleArraySubscriptList=ruleArraySubscriptList();
            _fsp--;

             current =iv_ruleArraySubscriptList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArraySubscriptList5459); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleArraySubscriptList


    // $ANTLR start ruleArraySubscriptList
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2944:1: ruleArraySubscriptList returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) ;
    public final EObject ruleArraySubscriptList() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2949:6: ( ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2950:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2950:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2950:3: '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']'
            {
            match(input,37,FOLLOW_37_in_ruleArraySubscriptList5494); 

                    createLeafNode(grammarAccess.getArraySubscriptListAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2954:1: ( (lv_subscripts_1_0= ruleSubscript ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2955:1: (lv_subscripts_1_0= ruleSubscript )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2955:1: (lv_subscripts_1_0= ruleSubscript )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2956:3: lv_subscripts_1_0= ruleSubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArraySubscriptListAccess().getSubscriptsSubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSubscript_in_ruleArraySubscriptList5515);
            lv_subscripts_1_0=ruleSubscript();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArraySubscriptListRule().getType().getClassifier());
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2978:2: ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==16) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2978:4: ',' ( (lv_subscripts_3_0= ruleSubscript ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleArraySubscriptList5526); 

            	            createLeafNode(grammarAccess.getArraySubscriptListAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2982:1: ( (lv_subscripts_3_0= ruleSubscript ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2983:1: (lv_subscripts_3_0= ruleSubscript )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2983:1: (lv_subscripts_3_0= ruleSubscript )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2984:3: lv_subscripts_3_0= ruleSubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArraySubscriptListAccess().getSubscriptsSubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubscript_in_ruleArraySubscriptList5547);
            	    lv_subscripts_3_0=ruleSubscript();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArraySubscriptListRule().getType().getClassifier());
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
            	    break loop45;
                }
            } while (true);

            match(input,38,FOLLOW_38_in_ruleArraySubscriptList5559); 

                    createLeafNode(grammarAccess.getArraySubscriptListAccess().getRightSquareBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArraySubscriptList


    // $ANTLR start entryRuleSubscript
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3018:1: entryRuleSubscript returns [EObject current=null] : iv_ruleSubscript= ruleSubscript EOF ;
    public final EObject entryRuleSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3019:2: (iv_ruleSubscript= ruleSubscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3020:2: iv_ruleSubscript= ruleSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubscript_in_entryRuleSubscript5595);
            iv_ruleSubscript=ruleSubscript();
            _fsp--;

             current =iv_ruleSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubscript5605); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3027:1: ruleSubscript returns [EObject current=null] : (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) ;
    public final EObject ruleSubscript() throws RecognitionException {
        EObject current = null;

        EObject this_ColonSubscript_0 = null;

        EObject this_ExpressionSubscript_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3032:6: ( (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3033:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3033:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==27) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=RULE_IDENT && LA46_0<=RULE_STRING)||LA46_0==13||LA46_0==18||LA46_0==23||(LA46_0>=30 && LA46_0<=34)||(LA46_0>=36 && LA46_0<=37)||(LA46_0>=40 && LA46_0<=41)||(LA46_0>=57 && LA46_0<=58)) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3033:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3034:5: this_ColonSubscript_0= ruleColonSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getColonSubscriptParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleColonSubscript_in_ruleSubscript5652);
                    this_ColonSubscript_0=ruleColonSubscript();
                    _fsp--;

                     
                            current = this_ColonSubscript_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3044:5: this_ExpressionSubscript_1= ruleExpressionSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getExpressionSubscriptParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionSubscript_in_ruleSubscript5679);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3060:1: entryRuleColonSubscript returns [EObject current=null] : iv_ruleColonSubscript= ruleColonSubscript EOF ;
    public final EObject entryRuleColonSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonSubscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3061:2: (iv_ruleColonSubscript= ruleColonSubscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3062:2: iv_ruleColonSubscript= ruleColonSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getColonSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript5714);
            iv_ruleColonSubscript=ruleColonSubscript();
            _fsp--;

             current =iv_ruleColonSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColonSubscript5724); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3069:1: ruleColonSubscript returns [EObject current=null] : ( () ':' ) ;
    public final EObject ruleColonSubscript() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3074:6: ( ( () ':' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3075:1: ( () ':' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3075:1: ( () ':' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3075:2: () ':'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3075:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3076:5: 
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

            match(input,27,FOLLOW_27_in_ruleColonSubscript5768); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3098:1: entryRuleExpressionSubscript returns [EObject current=null] : iv_ruleExpressionSubscript= ruleExpressionSubscript EOF ;
    public final EObject entryRuleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionSubscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3099:2: (iv_ruleExpressionSubscript= ruleExpressionSubscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3100:2: iv_ruleExpressionSubscript= ruleExpressionSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript5804);
            iv_ruleExpressionSubscript=ruleExpressionSubscript();
            _fsp--;

             current =iv_ruleExpressionSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionSubscript5814); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3107:1: ruleExpressionSubscript returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3112:6: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3113:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3113:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3114:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3114:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3115:3: lv_expression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionSubscriptAccess().getExpressionExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionSubscript5859);
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


    // $ANTLR start entryRuleArrayConcatenationOperator
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3145:1: entryRuleArrayConcatenationOperator returns [EObject current=null] : iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF ;
    public final EObject entryRuleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConcatenationOperator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3146:2: (iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3147:2: iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConcatenationOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator5894);
            iv_ruleArrayConcatenationOperator=ruleArrayConcatenationOperator();
            _fsp--;

             current =iv_ruleArrayConcatenationOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConcatenationOperator5904); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3154:1: ruleArrayConcatenationOperator returns [EObject current=null] : ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionLists_1_0 = null;

        EObject lv_expressionLists_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3159:6: ( ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3160:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3160:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3160:3: '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,37,FOLLOW_37_in_ruleArrayConcatenationOperator5939); 

                    createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3164:1: ( (lv_expressionLists_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3165:1: (lv_expressionLists_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3165:1: (lv_expressionLists_1_0= ruleExpressionList )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3166:3: lv_expressionLists_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getExpressionListsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5960);
            lv_expressionLists_1_0=ruleExpressionList();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayConcatenationOperatorRule().getType().getClassifier());
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3188:2: ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==39) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3188:4: ';' ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    {
            	    match(input,39,FOLLOW_39_in_ruleArrayConcatenationOperator5971); 

            	            createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3192:1: ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3193:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3193:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3194:3: lv_expressionLists_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getExpressionListsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5992);
            	    lv_expressionLists_3_0=ruleExpressionList();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArrayConcatenationOperatorRule().getType().getClassifier());
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
            	    break loop47;
                }
            } while (true);

            match(input,38,FOLLOW_38_in_ruleArrayConcatenationOperator6004); 

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


    // $ANTLR start entryRuleArrayConstructionOperator
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3228:1: entryRuleArrayConstructionOperator returns [EObject current=null] : iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF ;
    public final EObject entryRuleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConstructionOperator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3229:2: (iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3230:2: iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator6040);
            iv_ruleArrayConstructionOperator=ruleArrayConstructionOperator();
            _fsp--;

             current =iv_ruleArrayConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConstructionOperator6050); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3237:1: ruleArrayConstructionOperator returns [EObject current=null] : ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' ) ;
    public final EObject ruleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_argumentList_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3242:6: ( ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3243:1: ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3243:1: ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3243:3: '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}'
            {
            match(input,13,FOLLOW_13_in_ruleArrayConstructionOperator6085); 

                    createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3247:1: ( (lv_argumentList_1_0= ruleFunctionArgumentList ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3248:1: (lv_argumentList_1_0= ruleFunctionArgumentList )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3248:1: (lv_argumentList_1_0= ruleFunctionArgumentList )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3249:3: lv_argumentList_1_0= ruleFunctionArgumentList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getArgumentListFunctionArgumentListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFunctionArgumentList_in_ruleArrayConstructionOperator6106);
            lv_argumentList_1_0=ruleFunctionArgumentList();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"argumentList",
            	        		lv_argumentList_1_0, 
            	        		"FunctionArgumentList", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,14,FOLLOW_14_in_ruleArrayConstructionOperator6116); 

                    createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getRightCurlyBracketKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start entryRuleExpressionList
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3283:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3284:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3285:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList6152);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList6162); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3292:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3297:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3298:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3298:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3298:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3298:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3299:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3299:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3300:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList6208);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3322:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==16) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3322:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleExpressionList6219); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3326:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3327:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3327:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3328:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList6240);
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
            	    break loop48;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3358:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3359:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3360:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression6278);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression6288); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3367:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3372:6: ( ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3373:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3373:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3373:3: '(' ( (lv_expression_1_0= ruleExpression ) ) ')'
            {
            match(input,18,FOLLOW_18_in_ruleParenthesizedExpression6323); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3377:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3378:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3378:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3379:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression6344);
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

            match(input,19,FOLLOW_19_in_ruleParenthesizedExpression6354); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3413:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3414:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3415:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression6390);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression6400); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3422:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3427:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3428:1: ( () 'begin' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3428:1: ( () 'begin' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3428:2: () 'begin'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3428:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3429:5: 
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

            match(input,40,FOLLOW_40_in_ruleBeginExpression6444); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3451:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3452:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3453:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression6480);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression6490); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3460:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3465:6: ( ( () 'end' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3466:1: ( () 'end' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3466:1: ( () 'end' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3466:2: () 'end'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3466:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3467:5: 
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

            match(input,41,FOLLOW_41_in_ruleEndExpression6534); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3489:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3490:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3491:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression6570);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression6580); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3498:1: ruleUnitExpression returns [EObject current=null] : ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_numerator_0_0 = null;

        EObject lv_denominator_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3503:6: ( ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3504:1: ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3504:1: ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3504:2: ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3504:2: ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3505:1: (lv_numerator_0_0= ruleUnitExpressionNumerator )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3505:1: (lv_numerator_0_0= ruleUnitExpressionNumerator )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3506:3: lv_numerator_0_0= ruleUnitExpressionNumerator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression6626);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3528:2: ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==42) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3528:4: '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) )
                    {
                    match(input,42,FOLLOW_42_in_ruleUnitExpression6637); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3532:1: ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3533:1: (lv_denominator_2_0= ruleUnitExpressionDenominator )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3533:1: (lv_denominator_2_0= ruleUnitExpressionDenominator )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3534:3: lv_denominator_2_0= ruleUnitExpressionDenominator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression6658);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3564:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3565:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3566:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator6696);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator6706); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3573:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3578:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3579:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3579:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_INTEGER) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_IDENT) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3579:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3579:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3579:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3580:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3580:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3581:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator6748); 

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
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3604:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3604:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3604:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3604:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3605:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3605:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3606:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator6781);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3628:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==43) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3628:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,43,FOLLOW_43_in_ruleUnitExpressionNumerator6792); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3632:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3633:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3633:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3634:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator6813);
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
                    	    break loop50;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3664:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3665:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3666:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator6852);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator6862); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3673:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3678:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3679:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3679:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_IDENT) ) {
                alt53=1;
            }
            else if ( (LA53_0==18) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3679:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3679:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3679:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3681:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6908);
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
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3704:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3704:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3704:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleUnitExpressionDenominator6925); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3708:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3709:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3709:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3710:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6946);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3732:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==43) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3732:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,43,FOLLOW_43_in_ruleUnitExpressionDenominator6957); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3736:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3737:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3737:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3738:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6978);
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
                    	    break loop52;
                        }
                    } while (true);

                    match(input,19,FOLLOW_19_in_ruleUnitExpressionDenominator6990); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3772:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3773:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3774:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor7027);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor7037); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3781:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;
        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3786:6: ( ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3787:1: ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3787:1: ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3787:2: ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3787:2: ( (lv_operand_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3788:1: (lv_operand_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3788:1: (lv_operand_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3789:3: lv_operand_0_0= RULE_IDENT
            {
            lv_operand_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleUnitExpressionFactor7079); 

            			createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getOperandIDENTTerminalRuleCall_0_0(), "operand"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionFactorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_0_0, 
            	        		"IDENT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3811:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==44) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3811:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,44,FOLLOW_44_in_ruleUnitExpressionFactor7095); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3815:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3816:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3816:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3817:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor7116);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3847:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3848:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3849:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent7154);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent7164); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3856:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3861:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3862:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3862:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3862:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3862:2: ( (lv_negative_0_0= '-' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==31) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3863:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3863:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3864:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleUnitExpressionExponent7207); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3883:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3884:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3884:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3885:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent7238); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3915:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3919:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3920:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3920:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            int alt56=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt56=1;
                }
                break;
            case 46:
                {
                alt56=2;
                }
                break;
            case 47:
                {
                alt56=3;
                }
                break;
            case 48:
                {
                alt56=4;
                }
                break;
            case 49:
                {
                alt56=5;
                }
                break;
            case 50:
                {
                alt56=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3920:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3920:2: ( '<' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3920:2: ( '<' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3920:4: '<'
                    {
                    match(input,45,FOLLOW_45_in_ruleRelationalOperator7291); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3926:6: ( '<=' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3926:6: ( '<=' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3926:8: '<='
                    {
                    match(input,46,FOLLOW_46_in_ruleRelationalOperator7306); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3932:6: ( '>' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3932:6: ( '>' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3932:8: '>'
                    {
                    match(input,47,FOLLOW_47_in_ruleRelationalOperator7321); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3938:6: ( '>=' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3938:6: ( '>=' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3938:8: '>='
                    {
                    match(input,48,FOLLOW_48_in_ruleRelationalOperator7336); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3944:6: ( '==' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3944:6: ( '==' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3944:8: '=='
                    {
                    match(input,49,FOLLOW_49_in_ruleRelationalOperator7351); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3950:6: ( '<>' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3950:6: ( '<>' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3950:8: '<>'
                    {
                    match(input,50,FOLLOW_50_in_ruleRelationalOperator7366); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3960:1: ruleAddSubtractOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) ) ;
    public final Enumerator ruleAddSubtractOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3964:6: ( ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3965:1: ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3965:1: ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) )
            int alt57=4;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt57=1;
                }
                break;
            case 31:
                {
                alt57=2;
                }
                break;
            case 52:
                {
                alt57=3;
                }
                break;
            case 53:
                {
                alt57=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3965:1: ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) )", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3965:2: ( '+' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3965:2: ( '+' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3965:4: '+'
                    {
                    match(input,51,FOLLOW_51_in_ruleAddSubtractOperator7409); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3971:6: ( '-' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3971:6: ( '-' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3971:8: '-'
                    {
                    match(input,31,FOLLOW_31_in_ruleAddSubtractOperator7424); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getSubtractEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3977:6: ( '.+' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3977:6: ( '.+' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3977:8: '.+'
                    {
                    match(input,52,FOLLOW_52_in_ruleAddSubtractOperator7439); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getElementWiseAddEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getElementWiseAddEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3983:6: ( '.-' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3983:6: ( '.-' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3983:8: '.-'
                    {
                    match(input,53,FOLLOW_53_in_ruleAddSubtractOperator7454); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getElementWiseSubtractEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getElementWiseSubtractEnumLiteralDeclaration_3(), null); 
                        

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3993:1: ruleMultiplyDivideOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplyDivideOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3997:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3998:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3998:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt58=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt58=1;
                }
                break;
            case 42:
                {
                alt58=2;
                }
                break;
            case 54:
                {
                alt58=3;
                }
                break;
            case 55:
                {
                alt58=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3998:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3998:2: ( '*' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3998:2: ( '*' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3998:4: '*'
                    {
                    match(input,43,FOLLOW_43_in_ruleMultiplyDivideOperator7497); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4004:6: ( '/' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4004:6: ( '/' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4004:8: '/'
                    {
                    match(input,42,FOLLOW_42_in_ruleMultiplyDivideOperator7512); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4010:6: ( '.*' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4010:6: ( '.*' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4010:8: '.*'
                    {
                    match(input,54,FOLLOW_54_in_ruleMultiplyDivideOperator7527); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4016:6: ( './' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4016:6: ( './' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4016:8: './'
                    {
                    match(input,55,FOLLOW_55_in_ruleMultiplyDivideOperator7542); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4026:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4030:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4031:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4031:1: ( ( '^' ) | ( '.^' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==44) ) {
                alt59=1;
            }
            else if ( (LA59_0==56) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4031:1: ( ( '^' ) | ( '.^' ) )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4031:2: ( '^' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4031:2: ( '^' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4031:4: '^'
                    {
                    match(input,44,FOLLOW_44_in_rulePowerOperator7585); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4037:6: ( '.^' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4037:6: ( '.^' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4037:8: '.^'
                    {
                    match(input,56,FOLLOW_56_in_rulePowerOperator7600); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4047:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4051:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4052:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4052:1: ( ( 'false' ) | ( 'true' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==57) ) {
                alt60=1;
            }
            else if ( (LA60_0==58) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4052:1: ( ( 'false' ) | ( 'true' ) )", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4052:2: ( 'false' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4052:2: ( 'false' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4052:4: 'false'
                    {
                    match(input,57,FOLLOW_57_in_ruleBooleanKind7643); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4058:6: ( 'true' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4058:6: ( 'true' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:4058:8: 'true'
                    {
                    match(input,58,FOLLOW_58_in_ruleBooleanKind7658); 

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
    public static final BitSet FOLLOW_12_in_rulePackageDefinition211 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleName_in_rulePackageDefinition232 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackageDefinition242 = new BitSet(new long[]{0x000000000000D000L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_rulePackageDefinition263 = new BitSet(new long[]{0x000000000000D000L});
    public static final BitSet FOLLOW_14_in_rulePackageDefinition274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinitionElement_in_entryRulePackageDefinitionElement310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinitionElement320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rulePackageDefinitionElement367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_rulePackageDefinitionElement394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationDefinition439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationDefinition474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleEnumerationDefinition491 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationDefinition506 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDefinition_in_ruleEnumerationDefinition528 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_ruleEnumerationDefinition539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDefinition_in_ruleEnumerationDefinition560 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationDefinition574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDefinition_in_entryRuleEnumerationLiteralDefinition610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralDefinition620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleEnumerationLiteralDefinition661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_rulePrimitiveTypeSpecifier760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalTypeSpecifier_in_entryRuleNumericalTypeSpecifier849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalTypeSpecifier859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericalTypeSpecifier906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericalTypeSpecifier933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRealTypeSpecifier1022 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleRealTypeSpecifier1033 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier1054 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRealTypeSpecifier1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier1102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleIntegerTypeSpecifier1156 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleIntegerTypeSpecifier1167 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier1188 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIntegerTypeSpecifier1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier1236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleBooleanTypeSpecifier1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier1326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleStringTypeSpecifier1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier1416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleComplexTypeSpecifier1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleConditionalExpression1670 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression1691 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleConditionalExpression1702 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression1723 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleConditionalExpression1735 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpression1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase1792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpressionCase1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1848 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpressionCase1858 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression1915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1972 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleRangeExpression1991 = new BitSet(new long[]{0x06000337C00420F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression2012 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleRangeExpression2023 = new BitSet(new long[]{0x06000337C00420F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression2084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression2141 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleLogicalOrExpression2161 = new BitSet(new long[]{0x06000337C00420F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression2182 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression2222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression2232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression2279 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleLogicalAndExpression2299 = new BitSet(new long[]{0x06000337C00420F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression2320 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression2360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleLogicalNotExpression2442 = new BitSet(new long[]{0x06000337800420F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression2500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression2557 = new BitSet(new long[]{0x0007E00000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression2588 = new BitSet(new long[]{0x06000337800420F0L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression2609 = new BitSet(new long[]{0x0007E00000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression2649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddSubtractExpression2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression2706 = new BitSet(new long[]{0x0038000080000002L});
    public static final BitSet FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression2737 = new BitSet(new long[]{0x06000337800420F0L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression2758 = new BitSet(new long[]{0x0038000080000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression2798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyDivideExpression2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2855 = new BitSet(new long[]{0x00C00C0000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression2886 = new BitSet(new long[]{0x06000337800420F0L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2907 = new BitSet(new long[]{0x00C00C0000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression2947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression3004 = new BitSet(new long[]{0x0100100000000002L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression3034 = new BitSet(new long[]{0x06000337800420F0L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression3093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryMinusExpression3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression3150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnaryMinusExpression3175 = new BitSet(new long[]{0x06000337000420F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentReference_in_rulePrimaryExpression3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_rulePrimaryExpression3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_rulePrimaryExpression3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_ruleLiteral3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral3598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral3660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalLiteral3670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral3831 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleRealLiteral3847 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral3868 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRealLiteral3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral3916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral3968 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleIntegerLiteral3984 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral4005 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIntegerLiteral4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral4053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral4108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral4143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall4234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedFunctionCall_in_ruleFunctionCall4291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordFunctionCall_in_ruleFunctionCall4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedFunctionCall_in_entryRuleNamedFunctionCall4353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedFunctionCall4363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleNamedFunctionCall4409 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNamedFunctionCall4419 = new BitSet(new long[]{0x06000337C08C20F0L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_ruleNamedFunctionCall4440 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNamedFunctionCall4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName4487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName4497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleName4540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleName4571 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleName4587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleName4604 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleKeywordFunctionCall_in_entryRuleKeywordFunctionCall4647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordFunctionCall4657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleKeywordFunctionCall4702 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_34_in_ruleKeywordFunctionCall4731 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleKeywordFunctionCall4757 = new BitSet(new long[]{0x06000337C08C20F0L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_ruleKeywordFunctionCall4778 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleKeywordFunctionCall4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_entryRuleFunctionArgumentList4825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionArgumentList4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionArgumentList4882 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctionArgumentList4894 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionArgumentList4915 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctionArgumentList4928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4949 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4981 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctionArgumentList4992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList5013 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument5052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleNamedArgument5104 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleNamedArgument5119 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument5140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentReference_in_entryRuleComponentReference5176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentReference5186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentReference5229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference5264 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentReference5275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference5296 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ruleComponentReferenceSegment_in_entryRuleComponentReferenceSegment5334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentReferenceSegment5344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleComponentReferenceSegment5386 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleArraySubscriptList_in_ruleComponentReferenceSegment5412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArraySubscriptList_in_entryRuleArraySubscriptList5449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArraySubscriptList5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleArraySubscriptList5494 = new BitSet(new long[]{0x06000337C88420F0L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArraySubscriptList5515 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_16_in_ruleArraySubscriptList5526 = new BitSet(new long[]{0x06000337C88420F0L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArraySubscriptList5547 = new BitSet(new long[]{0x0000004000010000L});
    public static final BitSet FOLLOW_38_in_ruleArraySubscriptList5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubscript_in_entryRuleSubscript5595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubscript5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_ruleSubscript5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_ruleSubscript5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript5714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColonSubscript5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleColonSubscript5768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript5804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionSubscript5814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionSubscript5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator5894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConcatenationOperator5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleArrayConcatenationOperator5939 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5960 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_39_in_ruleArrayConcatenationOperator5971 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5992 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_38_in_ruleArrayConcatenationOperator6004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator6040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConstructionOperator6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleArrayConstructionOperator6085 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_ruleArrayConstructionOperator6106 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleArrayConstructionOperator6116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList6152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList6162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList6208 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionList6219 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList6240 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression6278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleParenthesizedExpression6323 = new BitSet(new long[]{0x06000337C08420F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression6344 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleParenthesizedExpression6354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression6390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression6400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleBeginExpression6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression6480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleEndExpression6534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression6570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression6580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression6626 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleUnitExpression6637 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator6696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator6706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator6748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator6781 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleUnitExpressionNumerator6792 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator6813 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator6852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator6862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUnitExpressionDenominator6925 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6946 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_43_in_ruleUnitExpressionDenominator6957 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6978 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_19_in_ruleUnitExpressionDenominator6990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor7027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleUnitExpressionFactor7079 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleUnitExpressionFactor7095 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor7116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent7154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent7164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnitExpressionExponent7207 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent7238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelationalOperator7291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator7306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelationalOperator7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelationalOperator7336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRelationalOperator7351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelationalOperator7366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAddSubtractOperator7409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAddSubtractOperator7424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleAddSubtractOperator7439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleAddSubtractOperator7454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleMultiplyDivideOperator7497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleMultiplyDivideOperator7512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleMultiplyDivideOperator7527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleMultiplyDivideOperator7542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rulePowerOperator7585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rulePowerOperator7600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleBooleanKind7643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleBooleanKind7658 = new BitSet(new long[]{0x0000000000000002L});

}