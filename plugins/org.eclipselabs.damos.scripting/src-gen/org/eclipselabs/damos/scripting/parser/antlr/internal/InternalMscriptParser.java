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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'enumeration'", "','", "'if'", "'elseif'", "'else'", "'then'", "':'", "'or'", "'and'", "'not'", "'-'", "'('", "')'", "'::'", "'der'", "'initial'", "'='", "'.'", "'['", "']'", "';'", "'begin'", "'end'", "'/'", "'*'", "'^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'<>'", "'+'", "'.+'", "'.-'", "'.*'", "'./'", "'.^'", "'false'", "'true'"
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
        	return "Model";	
       	}
       	
       	@Override
       	protected MscriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:80:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:87:1: ruleModel returns [EObject current=null] : this_Expression_0= ruleExpression ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:92:6: (this_Expression_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:94:5: this_Expression_0= ruleExpression
            {
             
                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getExpressionParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleExpression_in_ruleModel131);
            this_Expression_0=ruleExpression();
            _fsp--;

             
                    current = this_Expression_0; 
                    currentNode = currentNode.getParent();
                

            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRulePackageAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:112:1: entryRulePackageAS returns [EObject current=null] : iv_rulePackageAS= rulePackageAS EOF ;
    public final EObject entryRulePackageAS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageAS = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:113:2: (iv_rulePackageAS= rulePackageAS EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:114:2: iv_rulePackageAS= rulePackageAS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageASRule(), currentNode); 
            pushFollow(FOLLOW_rulePackageAS_in_entryRulePackageAS167);
            iv_rulePackageAS=rulePackageAS();
            _fsp--;

             current =iv_rulePackageAS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageAS177); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePackageAS


    // $ANTLR start rulePackageAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:121:1: rulePackageAS returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_packagedElements_3_0= rulePackageableElementAS ) )* '}' ) ;
    public final EObject rulePackageAS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_1_0 = null;

        EObject lv_packagedElements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:126:6: ( ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_packagedElements_3_0= rulePackageableElementAS ) )* '}' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:127:1: ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_packagedElements_3_0= rulePackageableElementAS ) )* '}' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:127:1: ( 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_packagedElements_3_0= rulePackageableElementAS ) )* '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:127:3: 'package' ( (lv_name_1_0= ruleName ) ) '{' ( (lv_packagedElements_3_0= rulePackageableElementAS ) )* '}'
            {
            match(input,12,FOLLOW_12_in_rulePackageAS212); 

                    createLeafNode(grammarAccess.getPackageASAccess().getPackageKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:131:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:132:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:132:1: (lv_name_1_0= ruleName )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:133:3: lv_name_1_0= ruleName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPackageASAccess().getNameNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleName_in_rulePackageAS233);
            lv_name_1_0=ruleName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPackageASRule().getType().getClassifier());
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

            match(input,13,FOLLOW_13_in_rulePackageAS243); 

                    createLeafNode(grammarAccess.getPackageASAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:159:1: ( (lv_packagedElements_3_0= rulePackageableElementAS ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:160:1: (lv_packagedElements_3_0= rulePackageableElementAS )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:160:1: (lv_packagedElements_3_0= rulePackageableElementAS )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:161:3: lv_packagedElements_3_0= rulePackageableElementAS
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPackageASAccess().getPackagedElementsPackageableElementASParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageableElementAS_in_rulePackageAS264);
            	    lv_packagedElements_3_0=rulePackageableElementAS();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPackageASRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"packagedElements",
            	    	        		lv_packagedElements_3_0, 
            	    	        		"PackageableElementAS", 
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

            match(input,14,FOLLOW_14_in_rulePackageAS275); 

                    createLeafNode(grammarAccess.getPackageASAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePackageAS


    // $ANTLR start entryRulePackageableElementAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:195:1: entryRulePackageableElementAS returns [EObject current=null] : iv_rulePackageableElementAS= rulePackageableElementAS EOF ;
    public final EObject entryRulePackageableElementAS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageableElementAS = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:196:2: (iv_rulePackageableElementAS= rulePackageableElementAS EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:197:2: iv_rulePackageableElementAS= rulePackageableElementAS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageableElementASRule(), currentNode); 
            pushFollow(FOLLOW_rulePackageableElementAS_in_entryRulePackageableElementAS311);
            iv_rulePackageableElementAS=rulePackageableElementAS();
            _fsp--;

             current =iv_rulePackageableElementAS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageableElementAS321); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePackageableElementAS


    // $ANTLR start rulePackageableElementAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:204:1: rulePackageableElementAS returns [EObject current=null] : (this_PackageAS_0= rulePackageAS | this_EnumerationAS_1= ruleEnumerationAS ) ;
    public final EObject rulePackageableElementAS() throws RecognitionException {
        EObject current = null;

        EObject this_PackageAS_0 = null;

        EObject this_EnumerationAS_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:209:6: ( (this_PackageAS_0= rulePackageAS | this_EnumerationAS_1= ruleEnumerationAS ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:210:1: (this_PackageAS_0= rulePackageAS | this_EnumerationAS_1= ruleEnumerationAS )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:210:1: (this_PackageAS_0= rulePackageAS | this_EnumerationAS_1= ruleEnumerationAS )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("210:1: (this_PackageAS_0= rulePackageAS | this_EnumerationAS_1= ruleEnumerationAS )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:211:5: this_PackageAS_0= rulePackageAS
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageableElementASAccess().getPackageASParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePackageAS_in_rulePackageableElementAS368);
                    this_PackageAS_0=rulePackageAS();
                    _fsp--;

                     
                            current = this_PackageAS_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:221:5: this_EnumerationAS_1= ruleEnumerationAS
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPackageableElementASAccess().getEnumerationASParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumerationAS_in_rulePackageableElementAS395);
                    this_EnumerationAS_1=ruleEnumerationAS();
                    _fsp--;

                     
                            current = this_EnumerationAS_1; 
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
    // $ANTLR end rulePackageableElementAS


    // $ANTLR start entryRuleEnumerationAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:237:1: entryRuleEnumerationAS returns [EObject current=null] : iv_ruleEnumerationAS= ruleEnumerationAS EOF ;
    public final EObject entryRuleEnumerationAS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationAS = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:238:2: (iv_ruleEnumerationAS= ruleEnumerationAS EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:239:2: iv_ruleEnumerationAS= ruleEnumerationAS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationASRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationAS_in_entryRuleEnumerationAS430);
            iv_ruleEnumerationAS=ruleEnumerationAS();
            _fsp--;

             current =iv_ruleEnumerationAS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationAS440); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnumerationAS


    // $ANTLR start ruleEnumerationAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:246:1: ruleEnumerationAS returns [EObject current=null] : ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )* )? '}' ) ;
    public final EObject ruleEnumerationAS() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:251:6: ( ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )* )? '}' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:252:1: ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )* )? '}' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:252:1: ( 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )* )? '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:252:3: 'enumeration' ( (lv_name_1_0= RULE_IDENT ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )* )? '}'
            {
            match(input,15,FOLLOW_15_in_ruleEnumerationAS475); 

                    createLeafNode(grammarAccess.getEnumerationASAccess().getEnumerationKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:256:1: ( (lv_name_1_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:257:1: (lv_name_1_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:257:1: (lv_name_1_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:258:3: lv_name_1_0= RULE_IDENT
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleEnumerationAS492); 

            			createLeafNode(grammarAccess.getEnumerationASAccess().getNameIDENTTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationASRule().getType().getClassifier());
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

            match(input,13,FOLLOW_13_in_ruleEnumerationAS507); 

                    createLeafNode(grammarAccess.getEnumerationASAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:284:1: ( ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_IDENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:284:2: ( (lv_literals_3_0= ruleEnumerationLiteralAS ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:284:2: ( (lv_literals_3_0= ruleEnumerationLiteralAS ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:285:1: (lv_literals_3_0= ruleEnumerationLiteralAS )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:285:1: (lv_literals_3_0= ruleEnumerationLiteralAS )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:286:3: lv_literals_3_0= ruleEnumerationLiteralAS
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumerationASAccess().getLiteralsEnumerationLiteralASParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralAS_in_ruleEnumerationAS529);
                    lv_literals_3_0=ruleEnumerationLiteralAS();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumerationASRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"literals",
                    	        		lv_literals_3_0, 
                    	        		"EnumerationLiteralAS", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:308:2: ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==16) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:308:4: ',' ( (lv_literals_5_0= ruleEnumerationLiteralAS ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleEnumerationAS540); 

                    	            createLeafNode(grammarAccess.getEnumerationASAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:312:1: ( (lv_literals_5_0= ruleEnumerationLiteralAS ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:313:1: (lv_literals_5_0= ruleEnumerationLiteralAS )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:313:1: (lv_literals_5_0= ruleEnumerationLiteralAS )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:314:3: lv_literals_5_0= ruleEnumerationLiteralAS
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationASAccess().getLiteralsEnumerationLiteralASParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralAS_in_ruleEnumerationAS561);
                    	    lv_literals_5_0=ruleEnumerationLiteralAS();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumerationASRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"literals",
                    	    	        		lv_literals_5_0, 
                    	    	        		"EnumerationLiteralAS", 
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
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,14,FOLLOW_14_in_ruleEnumerationAS575); 

                    createLeafNode(grammarAccess.getEnumerationASAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEnumerationAS


    // $ANTLR start entryRuleEnumerationLiteralAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:348:1: entryRuleEnumerationLiteralAS returns [EObject current=null] : iv_ruleEnumerationLiteralAS= ruleEnumerationLiteralAS EOF ;
    public final EObject entryRuleEnumerationLiteralAS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralAS = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:349:2: (iv_ruleEnumerationLiteralAS= ruleEnumerationLiteralAS EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:350:2: iv_ruleEnumerationLiteralAS= ruleEnumerationLiteralAS EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationLiteralASRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationLiteralAS_in_entryRuleEnumerationLiteralAS611);
            iv_ruleEnumerationLiteralAS=ruleEnumerationLiteralAS();
            _fsp--;

             current =iv_ruleEnumerationLiteralAS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralAS621); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnumerationLiteralAS


    // $ANTLR start ruleEnumerationLiteralAS
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:357:1: ruleEnumerationLiteralAS returns [EObject current=null] : ( (lv_name_0_0= RULE_IDENT ) ) ;
    public final EObject ruleEnumerationLiteralAS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:362:6: ( ( (lv_name_0_0= RULE_IDENT ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:363:1: ( (lv_name_0_0= RULE_IDENT ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:363:1: ( (lv_name_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:364:1: (lv_name_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:364:1: (lv_name_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:365:3: lv_name_0_0= RULE_IDENT
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleEnumerationLiteralAS662); 

            			createLeafNode(grammarAccess.getEnumerationLiteralASAccess().getNameIDENTTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationLiteralASRule().getType().getClassifier());
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
    // $ANTLR end ruleEnumerationLiteralAS


    // $ANTLR start entryRuleExpression
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:395:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:396:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:397:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression702);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression712); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:404:1: ruleExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        EObject this_RangeExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:409:6: ( (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:410:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:410:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_IDENT && LA5_0<=RULE_STRING)||LA5_0==13||(LA5_0>=24 && LA5_0<=26)||(LA5_0>=28 && LA5_0<=30)||(LA5_0>=32 && LA5_0<=33)||(LA5_0>=36 && LA5_0<=37)||(LA5_0>=53 && LA5_0<=54)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("410:1: (this_ConditionalExpression_0= ruleConditionalExpression | this_RangeExpression_1= ruleRangeExpression )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:411:5: this_ConditionalExpression_0= ruleConditionalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression759);
                    this_ConditionalExpression_0=ruleConditionalExpression();
                    _fsp--;

                     
                            current = this_ConditionalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:421:5: this_RangeExpression_1= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression786);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:437:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:438:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:439:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression821);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression831); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:446:1: ruleConditionalExpression returns [EObject current=null] : ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_1_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:451:6: ( ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:452:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:452:1: ( 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:452:3: 'if' ( (lv_cases_1_0= ruleConditionalExpressionCase ) ) ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )* 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,17,FOLLOW_17_in_ruleConditionalExpression866); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:456:1: ( (lv_cases_1_0= ruleConditionalExpressionCase ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:457:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:457:1: (lv_cases_1_0= ruleConditionalExpressionCase )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:458:3: lv_cases_1_0= ruleConditionalExpressionCase
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression887);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:480:2: ( 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:480:4: 'elseif' ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleConditionalExpression898); 

            	            createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseifKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:484:1: ( (lv_cases_3_0= ruleConditionalExpressionCase ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:485:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:485:1: (lv_cases_3_0= ruleConditionalExpressionCase )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:486:3: lv_cases_3_0= ruleConditionalExpressionCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getCasesConditionalExpressionCaseParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression919);
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
            	    break loop6;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_ruleConditionalExpression931); 

                    createLeafNode(grammarAccess.getConditionalExpressionAccess().getElseKeyword_3(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:512:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:513:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:513:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:514:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getElseExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpression952);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:544:1: entryRuleConditionalExpressionCase returns [EObject current=null] : iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF ;
    public final EObject entryRuleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressionCase = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:545:2: (iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:546:2: iv_ruleConditionalExpressionCase= ruleConditionalExpressionCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase988);
            iv_ruleConditionalExpressionCase=ruleConditionalExpressionCase();
            _fsp--;

             current =iv_ruleConditionalExpressionCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpressionCase998); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:553:1: ruleConditionalExpressionCase returns [EObject current=null] : ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConditionalExpressionCase() throws RecognitionException {
        EObject current = null;

        EObject lv_conditionExpression_0_0 = null;

        EObject lv_thenExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:558:6: ( ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:559:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:559:1: ( ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:559:2: ( (lv_conditionExpression_0_0= ruleExpression ) ) 'then' ( (lv_thenExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:559:2: ( (lv_conditionExpression_0_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:560:1: (lv_conditionExpression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:560:1: (lv_conditionExpression_0_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:561:3: lv_conditionExpression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getConditionExpressionExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1044);
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

            match(input,20,FOLLOW_20_in_ruleConditionalExpressionCase1054); 

                    createLeafNode(grammarAccess.getConditionalExpressionCaseAccess().getThenKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:587:1: ( (lv_thenExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:588:1: (lv_thenExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:588:1: (lv_thenExpression_2_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:589:3: lv_thenExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionCaseAccess().getThenExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1075);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:619:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:620:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:621:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression1111);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression1121); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:628:1: ruleRangeExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_expressions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:633:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:634:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:634:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:635:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1168);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:643:1: ( () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:643:2: () ':' ( (lv_expressions_3_0= ruleLogicalOrExpression ) ) ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )?
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:643:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:644:5: 
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

                    match(input,21,FOLLOW_21_in_ruleRangeExpression1187); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:663:1: ( (lv_expressions_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:664:1: (lv_expressions_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:664:1: (lv_expressions_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:665:3: lv_expressions_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getExpressionsLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1208);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:687:2: ( ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==21) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:687:4: ':' ( (lv_expressions_5_0= ruleLogicalOrExpression ) )
                            {
                            match(input,21,FOLLOW_21_in_ruleRangeExpression1219); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_0(), null); 
                                
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:691:1: ( (lv_expressions_5_0= ruleLogicalOrExpression ) )
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:692:1: (lv_expressions_5_0= ruleLogicalOrExpression )
                            {
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:692:1: (lv_expressions_5_0= ruleLogicalOrExpression )
                            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:693:3: lv_expressions_5_0= ruleLogicalOrExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getExpressionsLogicalOrExpressionParserRuleCall_1_3_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1240);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:723:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:724:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:725:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression1280);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression1290); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:732:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:737:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:738:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:738:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:739:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression1337);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:747:1: ( () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:747:2: () ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:747:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:748:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:763:2: ( 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==22) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:763:4: 'or' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,22,FOLLOW_22_in_ruleLogicalOrExpression1357); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:767:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:768:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:768:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:769:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression1378);
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
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:799:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:800:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:801:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression1418);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression1428); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:808:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:813:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:814:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:814:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:815:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression1475);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:823:1: ( () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+ )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:823:2: () ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:823:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:824:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:839:2: ( 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==23) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:839:4: 'and' ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleLogicalAndExpression1495); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:843:1: ( (lv_operands_3_0= ruleLogicalNotExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:844:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:844:1: (lv_operands_3_0= ruleLogicalNotExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:845:3: lv_operands_3_0= ruleLogicalNotExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsLogicalNotExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression1516);
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
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:875:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:876:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:877:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression1556);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression1566); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:884:1: ruleLogicalNotExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:889:6: ( (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:890:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:890:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_IDENT && LA13_0<=RULE_STRING)||LA13_0==13||(LA13_0>=25 && LA13_0<=26)||(LA13_0>=28 && LA13_0<=30)||(LA13_0>=32 && LA13_0<=33)||(LA13_0>=36 && LA13_0<=37)||(LA13_0>=53 && LA13_0<=54)) ) {
                alt13=1;
            }
            else if ( (LA13_0==24) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("890:1: (this_RelationalExpression_0= ruleRelationalExpression | ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) ) )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:891:5: this_RelationalExpression_0= ruleRelationalExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression1613);
                    this_RelationalExpression_0=ruleRelationalExpression();
                    _fsp--;

                     
                            current = this_RelationalExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:900:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:900:6: ( () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:900:7: () 'not' ( (lv_operand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:900:7: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:901:5: 
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

                    match(input,24,FOLLOW_24_in_ruleLogicalNotExpression1638); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getNotKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:915:1: ( (lv_operand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:916:1: (lv_operand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:916:1: (lv_operand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:917:3: lv_operand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression1659);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:947:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:948:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:949:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1696);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1706); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:956:1: ruleRelationalExpression returns [EObject current=null] : (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddSubtractExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:961:6: ( (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:962:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:962:1: (this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:963:5: this_AddSubtractExpression_0= ruleAddSubtractExpression ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression1753);
            this_AddSubtractExpression_0=ruleAddSubtractExpression();
            _fsp--;

             
                    current = this_AddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:971:1: ( () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=41 && LA15_0<=46)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:971:2: () ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:971:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:972:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:987:2: ( ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=41 && LA14_0<=46)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:987:3: ( (lv_operators_2_0= ruleRelationalOperator ) ) ( (lv_operands_3_0= ruleAddSubtractExpression ) )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:987:3: ( (lv_operators_2_0= ruleRelationalOperator ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:988:1: (lv_operators_2_0= ruleRelationalOperator )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:988:1: (lv_operators_2_0= ruleRelationalOperator )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:989:3: lv_operators_2_0= ruleRelationalOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorsRelationalOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression1784);
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

                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1011:2: ( (lv_operands_3_0= ruleAddSubtractExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1012:1: (lv_operands_3_0= ruleAddSubtractExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1012:1: (lv_operands_3_0= ruleAddSubtractExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1013:3: lv_operands_3_0= ruleAddSubtractExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperandsAddSubtractExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression1805);
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAddSubtractExpression
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1043:1: entryRuleAddSubtractExpression returns [EObject current=null] : iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF ;
    public final EObject entryRuleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddSubtractExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1044:2: (iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1045:2: iv_ruleAddSubtractExpression= ruleAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression1845);
            iv_ruleAddSubtractExpression=ruleAddSubtractExpression();
            _fsp--;

             current =iv_ruleAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddSubtractExpression1855); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1052:1: ruleAddSubtractExpression returns [EObject current=null] : (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) ;
    public final EObject ruleAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplyDivideExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1057:6: ( (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1058:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1058:1: (this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1059:5: this_MultiplyDivideExpression_0= ruleMultiplyDivideExpression ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression1902);
            this_MultiplyDivideExpression_0=ruleMultiplyDivideExpression();
            _fsp--;

             
                    current = this_MultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1067:1: ( () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25||(LA17_0>=47 && LA17_0<=49)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1067:2: () ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1067:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1068:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1083:2: ( ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==25||(LA16_0>=47 && LA16_0<=49)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1083:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) ) ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1083:3: ( (lv_operators_2_0= ruleAddSubtractOperator ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1084:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1084:1: (lv_operators_2_0= ruleAddSubtractOperator )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1085:3: lv_operators_2_0= ruleAddSubtractOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperatorsAddSubtractOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression1933);
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

                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1107:2: ( (lv_operands_3_0= ruleMultiplyDivideExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1108:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1108:1: (lv_operands_3_0= ruleMultiplyDivideExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1109:3: lv_operands_3_0= ruleMultiplyDivideExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAddSubtractExpressionAccess().getOperandsMultiplyDivideExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression1954);
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
    // $ANTLR end ruleAddSubtractExpression


    // $ANTLR start entryRuleMultiplyDivideExpression
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1139:1: entryRuleMultiplyDivideExpression returns [EObject current=null] : iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF ;
    public final EObject entryRuleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplyDivideExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1140:2: (iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1141:2: iv_ruleMultiplyDivideExpression= ruleMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression1994);
            iv_ruleMultiplyDivideExpression=ruleMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplyDivideExpression2004); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1148:1: ruleMultiplyDivideExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) ;
    public final EObject ruleMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        Enumerator lv_operators_2_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1153:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1154:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1154:1: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1155:5: this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2051);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1163:1: ( () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+ )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=38 && LA19_0<=39)||(LA19_0>=50 && LA19_0<=51)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1163:2: () ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1163:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1164:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1179:2: ( ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=38 && LA18_0<=39)||(LA18_0>=50 && LA18_0<=51)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1179:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) ) ( (lv_operands_3_0= rulePowerExpression ) )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1179:3: ( (lv_operators_2_0= ruleMultiplyDivideOperator ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1180:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1180:1: (lv_operators_2_0= ruleMultiplyDivideOperator )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1181:3: lv_operators_2_0= ruleMultiplyDivideOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperatorsMultiplyDivideOperatorEnumRuleCall_1_1_0_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression2082);
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

                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1203:2: ( (lv_operands_3_0= rulePowerExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1204:1: (lv_operands_3_0= rulePowerExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1204:1: (lv_operands_3_0= rulePowerExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1205:3: lv_operands_3_0= rulePowerExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplyDivideExpressionAccess().getOperandsPowerExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2103);
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
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1235:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1236:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1237:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression2143);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression2153); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1244:1: rulePowerExpression returns [EObject current=null] : (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryMinusExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1249:6: ( (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1250:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1250:1: (this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1251:5: this_UnaryMinusExpression_0= ruleUnaryMinusExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryMinusExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression2200);
            this_UnaryMinusExpression_0=ruleUnaryMinusExpression();
            _fsp--;

             
                    current = this_UnaryMinusExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1259:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==40||LA20_0==52) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1259:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1259:2: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1260:5: 
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1275:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1276:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1276:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1277:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression2230);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1299:2: ( (lv_exponent_3_0= ruleUnaryMinusExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1300:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1300:1: (lv_exponent_3_0= ruleUnaryMinusExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1301:3: lv_exponent_3_0= ruleUnaryMinusExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryMinusExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression2251);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1331:1: entryRuleUnaryMinusExpression returns [EObject current=null] : iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF ;
    public final EObject entryRuleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryMinusExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1332:2: (iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1333:2: iv_ruleUnaryMinusExpression= ruleUnaryMinusExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryMinusExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression2289);
            iv_ruleUnaryMinusExpression=ruleUnaryMinusExpression();
            _fsp--;

             current =iv_ruleUnaryMinusExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryMinusExpression2299); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1340:1: ruleUnaryMinusExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleUnaryMinusExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1345:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1346:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1346:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_IDENT && LA21_0<=RULE_STRING)||LA21_0==13||LA21_0==26||(LA21_0>=28 && LA21_0<=30)||(LA21_0>=32 && LA21_0<=33)||(LA21_0>=36 && LA21_0<=37)||(LA21_0>=53 && LA21_0<=54)) ) {
                alt21=1;
            }
            else if ( (LA21_0==25) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1346:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1347:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression2346);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1356:6: ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1356:6: ( () '-' ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1356:7: () '-' ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1356:7: ()
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1357:5: 
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

                    match(input,25,FOLLOW_25_in_ruleUnaryMinusExpression2371); 

                            createLeafNode(grammarAccess.getUnaryMinusExpressionAccess().getHyphenMinusKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1371:1: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1372:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1372:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1373:3: lv_operand_3_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryMinusExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression2392);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1403:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1404:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1405:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2429);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2439); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1412:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression ) ;
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
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1417:6: ( (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1418:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1418:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )
            int alt22=8;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 53:
            case 54:
                {
                alt22=1;
                }
                break;
            case 28:
            case 29:
            case 30:
                {
                alt22=2;
                }
                break;
            case RULE_IDENT:
                {
                int LA22_3 = input.LA(2);

                if ( (LA22_3==26||LA22_3==28) ) {
                    alt22=2;
                }
                else if ( (LA22_3==EOF||LA22_3==14||LA22_3==16||(LA22_3>=18 && LA22_3<=23)||LA22_3==25||LA22_3==27||(LA22_3>=32 && LA22_3<=35)||(LA22_3>=38 && LA22_3<=52)) ) {
                    alt22=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1418:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )", 22, 3, input);

                    throw nvae;
                }
                }
                break;
            case 32:
                {
                alt22=3;
                }
                break;
            case 26:
                {
                alt22=4;
                }
                break;
            case 33:
                {
                alt22=5;
                }
                break;
            case 13:
                {
                alt22=6;
                }
                break;
            case 36:
                {
                alt22=7;
                }
                break;
            case 37:
                {
                alt22=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1418:1: (this_Literal_0= ruleLiteral | this_FunctionCall_1= ruleFunctionCall | this_ComponentReference_2= ruleComponentReference | this_ParenthesizedExpression_3= ruleParenthesizedExpression | this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator | this_ArrayConstructionOperator_5= ruleArrayConstructionOperator | this_BeginExpression_6= ruleBeginExpression | this_EndExpression_7= ruleEndExpression )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1419:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression2486);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1429:5: this_FunctionCall_1= ruleFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression2513);
                    this_FunctionCall_1=ruleFunctionCall();
                    _fsp--;

                     
                            current = this_FunctionCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1439:5: this_ComponentReference_2= ruleComponentReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getComponentReferenceParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComponentReference_in_rulePrimaryExpression2540);
                    this_ComponentReference_2=ruleComponentReference();
                    _fsp--;

                     
                            current = this_ComponentReference_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1449:5: this_ParenthesizedExpression_3= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression2567);
                    this_ParenthesizedExpression_3=ruleParenthesizedExpression();
                    _fsp--;

                     
                            current = this_ParenthesizedExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1459:5: this_ArrayConcatenationOperator_4= ruleArrayConcatenationOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArrayConcatenationOperatorParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_rulePrimaryExpression2594);
                    this_ArrayConcatenationOperator_4=ruleArrayConcatenationOperator();
                    _fsp--;

                     
                            current = this_ArrayConcatenationOperator_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1469:5: this_ArrayConstructionOperator_5= ruleArrayConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArrayConstructionOperatorParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayConstructionOperator_in_rulePrimaryExpression2621);
                    this_ArrayConstructionOperator_5=ruleArrayConstructionOperator();
                    _fsp--;

                     
                            current = this_ArrayConstructionOperator_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1479:5: this_BeginExpression_6= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression2648);
                    this_BeginExpression_6=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1489:5: this_EndExpression_7= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression2675);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1505:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1506:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1507:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2710);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2720); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1514:1: ruleLiteral returns [EObject current=null] : (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1519:6: ( (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1520:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1520:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt23=1;
                }
                break;
            case 53:
            case 54:
                {
                alt23=2;
                }
                break;
            case RULE_STRING:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1520:1: (this_NumericalLiteral_0= ruleNumericalLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1521:5: this_NumericalLiteral_0= ruleNumericalLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericalLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericalLiteral_in_ruleLiteral2767);
                    this_NumericalLiteral_0=ruleNumericalLiteral();
                    _fsp--;

                     
                            current = this_NumericalLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1531:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral2794);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1541:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral2821);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1557:1: entryRuleNumericalLiteral returns [EObject current=null] : iv_ruleNumericalLiteral= ruleNumericalLiteral EOF ;
    public final EObject entryRuleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1558:2: (iv_ruleNumericalLiteral= ruleNumericalLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1559:2: iv_ruleNumericalLiteral= ruleNumericalLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral2856);
            iv_ruleNumericalLiteral=ruleNumericalLiteral();
            _fsp--;

             current =iv_ruleNumericalLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalLiteral2866); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1566:1: ruleNumericalLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericalLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1571:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1572:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1572:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_REAL) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_INTEGER) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1572:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1573:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral2913);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1583:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral2940);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1599:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1600:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1601:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral2975);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral2985); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1608:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1613:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1614:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1614:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1614:2: ( (lv_value_0_0= RULE_REAL ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1614:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1615:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1615:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1616:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral3027); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1638:2: ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==26) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1638:4: '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleRealLiteral3043); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1642:1: ( (lv_unit_2_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1643:1: (lv_unit_2_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1643:1: (lv_unit_2_0= ruleUnitExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1644:3: lv_unit_2_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral3064);
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

                    match(input,27,FOLLOW_27_in_ruleRealLiteral3074); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1678:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1679:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1680:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral3112);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral3122); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1687:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1692:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1693:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1693:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1693:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1693:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1694:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1694:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1695:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral3164); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1717:2: ( '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1717:4: '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleIntegerLiteral3180); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1721:1: ( (lv_unit_2_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1722:1: (lv_unit_2_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1722:1: (lv_unit_2_0= ruleUnitExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1723:3: lv_unit_2_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral3201);
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

                    match(input,27,FOLLOW_27_in_ruleIntegerLiteral3211); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1757:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1758:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1759:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3249);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral3259); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1766:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1771:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1772:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1772:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1773:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1773:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1774:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral3304);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1804:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1805:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1806:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3339);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral3349); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1813:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1818:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1819:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1819:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1820:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1820:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1821:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral3390); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1851:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1852:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1853:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall3430);
            iv_ruleFunctionCall=ruleFunctionCall();
            _fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall3440); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1860:1: ruleFunctionCall returns [EObject current=null] : (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject this_NamedFunctionCall_0 = null;

        EObject this_KeywordFunctionCall_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1865:6: ( (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1866:1: (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1866:1: (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_IDENT||LA27_0==28) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=29 && LA27_0<=30)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1866:1: (this_NamedFunctionCall_0= ruleNamedFunctionCall | this_KeywordFunctionCall_1= ruleKeywordFunctionCall )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1867:5: this_NamedFunctionCall_0= ruleNamedFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFunctionCallAccess().getNamedFunctionCallParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedFunctionCall_in_ruleFunctionCall3487);
                    this_NamedFunctionCall_0=ruleNamedFunctionCall();
                    _fsp--;

                     
                            current = this_NamedFunctionCall_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1877:5: this_KeywordFunctionCall_1= ruleKeywordFunctionCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFunctionCallAccess().getKeywordFunctionCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleKeywordFunctionCall_in_ruleFunctionCall3514);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1893:1: entryRuleNamedFunctionCall returns [EObject current=null] : iv_ruleNamedFunctionCall= ruleNamedFunctionCall EOF ;
    public final EObject entryRuleNamedFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedFunctionCall = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1894:2: (iv_ruleNamedFunctionCall= ruleNamedFunctionCall EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1895:2: iv_ruleNamedFunctionCall= ruleNamedFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedFunctionCall_in_entryRuleNamedFunctionCall3549);
            iv_ruleNamedFunctionCall=ruleNamedFunctionCall();
            _fsp--;

             current =iv_ruleNamedFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedFunctionCall3559); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1902:1: ruleNamedFunctionCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) ;
    public final EObject ruleNamedFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_argumentList_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1907:6: ( ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1908:1: ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1908:1: ( ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1908:2: ( (lv_name_0_0= ruleName ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1908:2: ( (lv_name_0_0= ruleName ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1909:1: (lv_name_0_0= ruleName )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1909:1: (lv_name_0_0= ruleName )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1910:3: lv_name_0_0= ruleName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedFunctionCallAccess().getNameNameParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleName_in_ruleNamedFunctionCall3605);
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

            match(input,26,FOLLOW_26_in_ruleNamedFunctionCall3615); 

                    createLeafNode(grammarAccess.getNamedFunctionCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1936:1: ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_IDENT && LA28_0<=RULE_STRING)||LA28_0==13||LA28_0==17||(LA28_0>=24 && LA28_0<=26)||(LA28_0>=28 && LA28_0<=30)||(LA28_0>=32 && LA28_0<=33)||(LA28_0>=36 && LA28_0<=37)||(LA28_0>=53 && LA28_0<=54)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1937:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1937:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1938:3: lv_argumentList_2_0= ruleFunctionArgumentList
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedFunctionCallAccess().getArgumentListFunctionArgumentListParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFunctionArgumentList_in_ruleNamedFunctionCall3636);
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

            match(input,27,FOLLOW_27_in_ruleNamedFunctionCall3647); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1972:1: entryRuleName returns [EObject current=null] : iv_ruleName= ruleName EOF ;
    public final EObject entryRuleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleName = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1973:2: (iv_ruleName= ruleName EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1974:2: iv_ruleName= ruleName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleName_in_entryRuleName3683);
            iv_ruleName=ruleName();
            _fsp--;

             current =iv_ruleName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleName3693); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1981:1: ruleName returns [EObject current=null] : ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* ) ;
    public final EObject ruleName() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        Token lv_identifiers_1_0=null;
        Token lv_identifiers_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1986:6: ( ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1987:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1987:1: ( ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1987:2: ( (lv_global_0_0= '::' ) )? ( (lv_identifiers_1_0= RULE_IDENT ) ) ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1987:2: ( (lv_global_0_0= '::' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==28) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1988:1: (lv_global_0_0= '::' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1988:1: (lv_global_0_0= '::' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:1989:3: lv_global_0_0= '::'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleName3736); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2008:3: ( (lv_identifiers_1_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2009:1: (lv_identifiers_1_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2009:1: (lv_identifiers_1_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2010:3: lv_identifiers_1_0= RULE_IDENT
            {
            lv_identifiers_1_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleName3767); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2032:2: ( '::' ( (lv_identifiers_3_0= RULE_IDENT ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==28) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2032:4: '::' ( (lv_identifiers_3_0= RULE_IDENT ) )
            	    {
            	    match(input,28,FOLLOW_28_in_ruleName3783); 

            	            createLeafNode(grammarAccess.getNameAccess().getColonColonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2036:1: ( (lv_identifiers_3_0= RULE_IDENT ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2037:1: (lv_identifiers_3_0= RULE_IDENT )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2037:1: (lv_identifiers_3_0= RULE_IDENT )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2038:3: lv_identifiers_3_0= RULE_IDENT
            	    {
            	    lv_identifiers_3_0=(Token)input.LT(1);
            	    match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleName3800); 

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
            	    break loop30;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2068:1: entryRuleKeywordFunctionCall returns [EObject current=null] : iv_ruleKeywordFunctionCall= ruleKeywordFunctionCall EOF ;
    public final EObject entryRuleKeywordFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywordFunctionCall = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2069:2: (iv_ruleKeywordFunctionCall= ruleKeywordFunctionCall EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2070:2: iv_ruleKeywordFunctionCall= ruleKeywordFunctionCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordFunctionCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeywordFunctionCall_in_entryRuleKeywordFunctionCall3843);
            iv_ruleKeywordFunctionCall=ruleKeywordFunctionCall();
            _fsp--;

             current =iv_ruleKeywordFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordFunctionCall3853); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2077:1: ruleKeywordFunctionCall returns [EObject current=null] : ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) ;
    public final EObject ruleKeywordFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        EObject lv_argumentList_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2082:6: ( ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2083:1: ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2083:1: ( ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2083:2: ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) ) '(' ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )? ')'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2083:2: ( ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2084:1: ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2084:1: ( (lv_name_0_1= 'der' | lv_name_0_2= 'initial' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2085:1: (lv_name_0_1= 'der' | lv_name_0_2= 'initial' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2085:1: (lv_name_0_1= 'der' | lv_name_0_2= 'initial' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            else if ( (LA31_0==30) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2085:1: (lv_name_0_1= 'der' | lv_name_0_2= 'initial' )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2086:3: lv_name_0_1= 'der'
                    {
                    lv_name_0_1=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleKeywordFunctionCall3898); 

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
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2104:8: lv_name_0_2= 'initial'
                    {
                    lv_name_0_2=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleKeywordFunctionCall3927); 

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

            match(input,26,FOLLOW_26_in_ruleKeywordFunctionCall3953); 

                    createLeafNode(grammarAccess.getKeywordFunctionCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2129:1: ( (lv_argumentList_2_0= ruleFunctionArgumentList ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_IDENT && LA32_0<=RULE_STRING)||LA32_0==13||LA32_0==17||(LA32_0>=24 && LA32_0<=26)||(LA32_0>=28 && LA32_0<=30)||(LA32_0>=32 && LA32_0<=33)||(LA32_0>=36 && LA32_0<=37)||(LA32_0>=53 && LA32_0<=54)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2130:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2130:1: (lv_argumentList_2_0= ruleFunctionArgumentList )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2131:3: lv_argumentList_2_0= ruleFunctionArgumentList
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getKeywordFunctionCallAccess().getArgumentListFunctionArgumentListParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleFunctionArgumentList_in_ruleKeywordFunctionCall3974);
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

            match(input,27,FOLLOW_27_in_ruleKeywordFunctionCall3985); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2165:1: entryRuleFunctionArgumentList returns [EObject current=null] : iv_ruleFunctionArgumentList= ruleFunctionArgumentList EOF ;
    public final EObject entryRuleFunctionArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionArgumentList = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2166:2: (iv_ruleFunctionArgumentList= ruleFunctionArgumentList EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2167:2: iv_ruleFunctionArgumentList= ruleFunctionArgumentList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionArgumentListRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionArgumentList_in_entryRuleFunctionArgumentList4021);
            iv_ruleFunctionArgumentList=ruleFunctionArgumentList();
            _fsp--;

             current =iv_ruleFunctionArgumentList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionArgumentList4031); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2174:1: ruleFunctionArgumentList returns [EObject current=null] : ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) ) ;
    public final EObject ruleFunctionArgumentList() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_namedArguments_4_0 = null;

        EObject lv_namedArguments_5_0 = null;

        EObject lv_namedArguments_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2179:6: ( ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2180:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2180:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_REAL && LA36_0<=RULE_STRING)||LA36_0==13||LA36_0==17||(LA36_0>=24 && LA36_0<=26)||(LA36_0>=28 && LA36_0<=30)||(LA36_0>=32 && LA36_0<=33)||(LA36_0>=36 && LA36_0<=37)||(LA36_0>=53 && LA36_0<=54)) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_IDENT) ) {
                int LA36_2 = input.LA(2);

                if ( (LA36_2==31) ) {
                    alt36=2;
                }
                else if ( (LA36_2==EOF||LA36_2==14||LA36_2==16||(LA36_2>=21 && LA36_2<=23)||(LA36_2>=25 && LA36_2<=28)||(LA36_2>=32 && LA36_2<=33)||(LA36_2>=38 && LA36_2<=52)) ) {
                    alt36=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("2180:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )", 36, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2180:1: ( ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) ) | ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* ) )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2180:2: ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2180:2: ( ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2180:3: ( (lv_arguments_0_0= ruleExpression ) ) ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2180:3: ( (lv_arguments_0_0= ruleExpression ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2181:1: (lv_arguments_0_0= ruleExpression )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2181:1: (lv_arguments_0_0= ruleExpression )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2182:3: lv_arguments_0_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getArgumentsExpressionParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionArgumentList4078);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2204:2: ( ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )* )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2204:3: ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )* ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2204:3: ( ',' ( (lv_arguments_2_0= ruleExpression ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==16) ) {
                            int LA33_1 = input.LA(2);

                            if ( (LA33_1==RULE_IDENT) ) {
                                int LA33_3 = input.LA(3);

                                if ( (LA33_3==EOF||LA33_3==14||LA33_3==16||(LA33_3>=21 && LA33_3<=23)||(LA33_3>=25 && LA33_3<=28)||(LA33_3>=32 && LA33_3<=33)||(LA33_3>=38 && LA33_3<=52)) ) {
                                    alt33=1;
                                }


                            }
                            else if ( ((LA33_1>=RULE_REAL && LA33_1<=RULE_STRING)||LA33_1==13||LA33_1==17||(LA33_1>=24 && LA33_1<=26)||(LA33_1>=28 && LA33_1<=30)||(LA33_1>=32 && LA33_1<=33)||(LA33_1>=36 && LA33_1<=37)||(LA33_1>=53 && LA33_1<=54)) ) {
                                alt33=1;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2204:5: ',' ( (lv_arguments_2_0= ruleExpression ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionArgumentList4090); 

                    	            createLeafNode(grammarAccess.getFunctionArgumentListAccess().getCommaKeyword_0_1_0_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2208:1: ( (lv_arguments_2_0= ruleExpression ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2209:1: (lv_arguments_2_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2209:1: (lv_arguments_2_0= ruleExpression )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2210:3: lv_arguments_2_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getArgumentsExpressionParserRuleCall_0_1_0_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionArgumentList4111);
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
                    	    break loop33;
                        }
                    } while (true);

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2232:4: ( ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==16) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2232:6: ',' ( (lv_namedArguments_4_0= ruleNamedArgument ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionArgumentList4124); 

                    	            createLeafNode(grammarAccess.getFunctionArgumentListAccess().getCommaKeyword_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2236:1: ( (lv_namedArguments_4_0= ruleNamedArgument ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2237:1: (lv_namedArguments_4_0= ruleNamedArgument )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2237:1: (lv_namedArguments_4_0= ruleNamedArgument )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2238:3: lv_namedArguments_4_0= ruleNamedArgument
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getNamedArgumentsNamedArgumentParserRuleCall_0_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4145);
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
                    	    break loop34;
                        }
                    } while (true);


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2261:6: ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2261:6: ( ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )* )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2261:7: ( (lv_namedArguments_5_0= ruleNamedArgument ) ) ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2261:7: ( (lv_namedArguments_5_0= ruleNamedArgument ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2262:1: (lv_namedArguments_5_0= ruleNamedArgument )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2262:1: (lv_namedArguments_5_0= ruleNamedArgument )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2263:3: lv_namedArguments_5_0= ruleNamedArgument
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getNamedArgumentsNamedArgumentParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4177);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2285:2: ( ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==16) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2285:4: ',' ( (lv_namedArguments_7_0= ruleNamedArgument ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionArgumentList4188); 

                    	            createLeafNode(grammarAccess.getFunctionArgumentListAccess().getCommaKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2289:1: ( (lv_namedArguments_7_0= ruleNamedArgument ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2290:1: (lv_namedArguments_7_0= ruleNamedArgument )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2290:1: (lv_namedArguments_7_0= ruleNamedArgument )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2291:3: lv_namedArguments_7_0= ruleNamedArgument
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionArgumentListAccess().getNamedArgumentsNamedArgumentParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4209);
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
                    	    break loop35;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2321:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2322:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2323:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedArgumentRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4248);
            iv_ruleNamedArgument=ruleNamedArgument();
            _fsp--;

             current =iv_ruleNamedArgument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument4258); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2330:1: ruleNamedArgument returns [EObject current=null] : ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        EObject lv_expression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2335:6: ( ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2336:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2336:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2336:2: ( (lv_identifier_0_0= RULE_IDENT ) ) '=' ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2336:2: ( (lv_identifier_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2337:1: (lv_identifier_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2337:1: (lv_identifier_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2338:3: lv_identifier_0_0= RULE_IDENT
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleNamedArgument4300); 

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

            match(input,31,FOLLOW_31_in_ruleNamedArgument4315); 

                    createLeafNode(grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2364:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2365:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2365:1: (lv_expression_2_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2366:3: lv_expression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedArgumentAccess().getExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument4336);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2396:1: entryRuleComponentReference returns [EObject current=null] : iv_ruleComponentReference= ruleComponentReference EOF ;
    public final EObject entryRuleComponentReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentReference = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2397:2: (iv_ruleComponentReference= ruleComponentReference EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2398:2: iv_ruleComponentReference= ruleComponentReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComponentReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleComponentReference_in_entryRuleComponentReference4372);
            iv_ruleComponentReference=ruleComponentReference();
            _fsp--;

             current =iv_ruleComponentReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentReference4382); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2405:1: ruleComponentReference returns [EObject current=null] : ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* ) ;
    public final EObject ruleComponentReference() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        EObject lv_segments_1_0 = null;

        EObject lv_segments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2410:6: ( ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2411:1: ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2411:1: ( ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2411:2: ( (lv_global_0_0= '.' ) )? ( (lv_segments_1_0= ruleComponentReferenceSegment ) ) ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2411:2: ( (lv_global_0_0= '.' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2412:1: (lv_global_0_0= '.' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2412:1: (lv_global_0_0= '.' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2413:3: lv_global_0_0= '.'
                    {
                    lv_global_0_0=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_ruleComponentReference4425); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2432:3: ( (lv_segments_1_0= ruleComponentReferenceSegment ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2433:1: (lv_segments_1_0= ruleComponentReferenceSegment )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2433:1: (lv_segments_1_0= ruleComponentReferenceSegment )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2434:3: lv_segments_1_0= ruleComponentReferenceSegment
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getComponentReferenceAccess().getSegmentsComponentReferenceSegmentParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference4460);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2456:2: ( '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==32) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2456:4: '.' ( (lv_segments_3_0= ruleComponentReferenceSegment ) )
            	    {
            	    match(input,32,FOLLOW_32_in_ruleComponentReference4471); 

            	            createLeafNode(grammarAccess.getComponentReferenceAccess().getFullStopKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2460:1: ( (lv_segments_3_0= ruleComponentReferenceSegment ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2461:1: (lv_segments_3_0= ruleComponentReferenceSegment )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2461:1: (lv_segments_3_0= ruleComponentReferenceSegment )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2462:3: lv_segments_3_0= ruleComponentReferenceSegment
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getComponentReferenceAccess().getSegmentsComponentReferenceSegmentParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference4492);
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
            	    break loop38;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2492:1: entryRuleComponentReferenceSegment returns [EObject current=null] : iv_ruleComponentReferenceSegment= ruleComponentReferenceSegment EOF ;
    public final EObject entryRuleComponentReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentReferenceSegment = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2493:2: (iv_ruleComponentReferenceSegment= ruleComponentReferenceSegment EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2494:2: iv_ruleComponentReferenceSegment= ruleComponentReferenceSegment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComponentReferenceSegmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleComponentReferenceSegment_in_entryRuleComponentReferenceSegment4530);
            iv_ruleComponentReferenceSegment=ruleComponentReferenceSegment();
            _fsp--;

             current =iv_ruleComponentReferenceSegment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentReferenceSegment4540); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2501:1: ruleComponentReferenceSegment returns [EObject current=null] : ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? ) ;
    public final EObject ruleComponentReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        EObject lv_subscriptList_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2506:6: ( ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2507:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2507:1: ( ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2507:2: ( (lv_identifier_0_0= RULE_IDENT ) ) ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2507:2: ( (lv_identifier_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2508:1: (lv_identifier_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2508:1: (lv_identifier_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2509:3: lv_identifier_0_0= RULE_IDENT
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleComponentReferenceSegment4582); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2531:2: ( (lv_subscriptList_1_0= ruleArraySubscriptList ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==33) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2532:1: (lv_subscriptList_1_0= ruleArraySubscriptList )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2532:1: (lv_subscriptList_1_0= ruleArraySubscriptList )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2533:3: lv_subscriptList_1_0= ruleArraySubscriptList
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComponentReferenceSegmentAccess().getSubscriptListArraySubscriptListParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArraySubscriptList_in_ruleComponentReferenceSegment4608);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2563:1: entryRuleArraySubscriptList returns [EObject current=null] : iv_ruleArraySubscriptList= ruleArraySubscriptList EOF ;
    public final EObject entryRuleArraySubscriptList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySubscriptList = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2564:2: (iv_ruleArraySubscriptList= ruleArraySubscriptList EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2565:2: iv_ruleArraySubscriptList= ruleArraySubscriptList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArraySubscriptListRule(), currentNode); 
            pushFollow(FOLLOW_ruleArraySubscriptList_in_entryRuleArraySubscriptList4645);
            iv_ruleArraySubscriptList=ruleArraySubscriptList();
            _fsp--;

             current =iv_ruleArraySubscriptList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArraySubscriptList4655); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2572:1: ruleArraySubscriptList returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) ;
    public final EObject ruleArraySubscriptList() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2577:6: ( ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2578:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2578:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2578:3: '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']'
            {
            match(input,33,FOLLOW_33_in_ruleArraySubscriptList4690); 

                    createLeafNode(grammarAccess.getArraySubscriptListAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2582:1: ( (lv_subscripts_1_0= ruleSubscript ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2583:1: (lv_subscripts_1_0= ruleSubscript )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2583:1: (lv_subscripts_1_0= ruleSubscript )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2584:3: lv_subscripts_1_0= ruleSubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArraySubscriptListAccess().getSubscriptsSubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSubscript_in_ruleArraySubscriptList4711);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2606:2: ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==16) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2606:4: ',' ( (lv_subscripts_3_0= ruleSubscript ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleArraySubscriptList4722); 

            	            createLeafNode(grammarAccess.getArraySubscriptListAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2610:1: ( (lv_subscripts_3_0= ruleSubscript ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2611:1: (lv_subscripts_3_0= ruleSubscript )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2611:1: (lv_subscripts_3_0= ruleSubscript )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2612:3: lv_subscripts_3_0= ruleSubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArraySubscriptListAccess().getSubscriptsSubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubscript_in_ruleArraySubscriptList4743);
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
            	    break loop40;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_ruleArraySubscriptList4755); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2646:1: entryRuleSubscript returns [EObject current=null] : iv_ruleSubscript= ruleSubscript EOF ;
    public final EObject entryRuleSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2647:2: (iv_ruleSubscript= ruleSubscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2648:2: iv_ruleSubscript= ruleSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubscript_in_entryRuleSubscript4791);
            iv_ruleSubscript=ruleSubscript();
            _fsp--;

             current =iv_ruleSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubscript4801); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2655:1: ruleSubscript returns [EObject current=null] : (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) ;
    public final EObject ruleSubscript() throws RecognitionException {
        EObject current = null;

        EObject this_ColonSubscript_0 = null;

        EObject this_ExpressionSubscript_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2660:6: ( (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2661:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2661:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==21) ) {
                alt41=1;
            }
            else if ( ((LA41_0>=RULE_IDENT && LA41_0<=RULE_STRING)||LA41_0==13||LA41_0==17||(LA41_0>=24 && LA41_0<=26)||(LA41_0>=28 && LA41_0<=30)||(LA41_0>=32 && LA41_0<=33)||(LA41_0>=36 && LA41_0<=37)||(LA41_0>=53 && LA41_0<=54)) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2661:1: (this_ColonSubscript_0= ruleColonSubscript | this_ExpressionSubscript_1= ruleExpressionSubscript )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2662:5: this_ColonSubscript_0= ruleColonSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getColonSubscriptParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleColonSubscript_in_ruleSubscript4848);
                    this_ColonSubscript_0=ruleColonSubscript();
                    _fsp--;

                     
                            current = this_ColonSubscript_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2672:5: this_ExpressionSubscript_1= ruleExpressionSubscript
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getExpressionSubscriptParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionSubscript_in_ruleSubscript4875);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2688:1: entryRuleColonSubscript returns [EObject current=null] : iv_ruleColonSubscript= ruleColonSubscript EOF ;
    public final EObject entryRuleColonSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColonSubscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2689:2: (iv_ruleColonSubscript= ruleColonSubscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2690:2: iv_ruleColonSubscript= ruleColonSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getColonSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript4910);
            iv_ruleColonSubscript=ruleColonSubscript();
            _fsp--;

             current =iv_ruleColonSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleColonSubscript4920); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2697:1: ruleColonSubscript returns [EObject current=null] : ( () ':' ) ;
    public final EObject ruleColonSubscript() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2702:6: ( ( () ':' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2703:1: ( () ':' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2703:1: ( () ':' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2703:2: () ':'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2703:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2704:5: 
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

            match(input,21,FOLLOW_21_in_ruleColonSubscript4964); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2726:1: entryRuleExpressionSubscript returns [EObject current=null] : iv_ruleExpressionSubscript= ruleExpressionSubscript EOF ;
    public final EObject entryRuleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionSubscript = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2727:2: (iv_ruleExpressionSubscript= ruleExpressionSubscript EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2728:2: iv_ruleExpressionSubscript= ruleExpressionSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript5000);
            iv_ruleExpressionSubscript=ruleExpressionSubscript();
            _fsp--;

             current =iv_ruleExpressionSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionSubscript5010); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2735:1: ruleExpressionSubscript returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleExpressionSubscript() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2740:6: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2741:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2741:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2742:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2742:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2743:3: lv_expression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionSubscriptAccess().getExpressionExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionSubscript5055);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2773:1: entryRuleArrayConcatenationOperator returns [EObject current=null] : iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF ;
    public final EObject entryRuleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConcatenationOperator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2774:2: (iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2775:2: iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConcatenationOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator5090);
            iv_ruleArrayConcatenationOperator=ruleArrayConcatenationOperator();
            _fsp--;

             current =iv_ruleArrayConcatenationOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConcatenationOperator5100); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2782:1: ruleArrayConcatenationOperator returns [EObject current=null] : ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionLists_1_0 = null;

        EObject lv_expressionLists_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2787:6: ( ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2788:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2788:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2788:3: '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,33,FOLLOW_33_in_ruleArrayConcatenationOperator5135); 

                    createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2792:1: ( (lv_expressionLists_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2793:1: (lv_expressionLists_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2793:1: (lv_expressionLists_1_0= ruleExpressionList )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2794:3: lv_expressionLists_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getExpressionListsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5156);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2816:2: ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==35) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2816:4: ';' ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    {
            	    match(input,35,FOLLOW_35_in_ruleArrayConcatenationOperator5167); 

            	            createLeafNode(grammarAccess.getArrayConcatenationOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2820:1: ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2821:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2821:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2822:3: lv_expressionLists_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getExpressionListsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5188);
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
            	    break loop42;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_ruleArrayConcatenationOperator5200); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2856:1: entryRuleArrayConstructionOperator returns [EObject current=null] : iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF ;
    public final EObject entryRuleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConstructionOperator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2857:2: (iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2858:2: iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator5236);
            iv_ruleArrayConstructionOperator=ruleArrayConstructionOperator();
            _fsp--;

             current =iv_ruleArrayConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConstructionOperator5246); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2865:1: ruleArrayConstructionOperator returns [EObject current=null] : ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' ) ;
    public final EObject ruleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_argumentList_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2870:6: ( ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2871:1: ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2871:1: ( '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2871:3: '{' ( (lv_argumentList_1_0= ruleFunctionArgumentList ) ) '}'
            {
            match(input,13,FOLLOW_13_in_ruleArrayConstructionOperator5281); 

                    createLeafNode(grammarAccess.getArrayConstructionOperatorAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2875:1: ( (lv_argumentList_1_0= ruleFunctionArgumentList ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2876:1: (lv_argumentList_1_0= ruleFunctionArgumentList )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2876:1: (lv_argumentList_1_0= ruleFunctionArgumentList )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2877:3: lv_argumentList_1_0= ruleFunctionArgumentList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getArgumentListFunctionArgumentListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFunctionArgumentList_in_ruleArrayConstructionOperator5302);
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

            match(input,14,FOLLOW_14_in_ruleArrayConstructionOperator5312); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2911:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2912:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2913:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList5348);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList5358); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2920:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2925:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2926:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2926:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2926:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2926:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2927:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2927:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2928:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList5404);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2950:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==16) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2950:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleExpressionList5415); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2954:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2955:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2955:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2956:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList5436);
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
    // $ANTLR end ruleExpressionList


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2986:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2987:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2988:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression5474);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression5484); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:2995:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3000:6: ( ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3001:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3001:1: ( '(' ( (lv_expression_1_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3001:3: '(' ( (lv_expression_1_0= ruleExpression ) ) ')'
            {
            match(input,26,FOLLOW_26_in_ruleParenthesizedExpression5519); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3005:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3006:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3006:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3007:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression5540);
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

            match(input,27,FOLLOW_27_in_ruleParenthesizedExpression5550); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3041:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3042:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3043:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression5586);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression5596); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3050:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3055:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3056:1: ( () 'begin' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3056:1: ( () 'begin' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3056:2: () 'begin'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3056:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3057:5: 
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

            match(input,36,FOLLOW_36_in_ruleBeginExpression5640); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3079:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3080:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3081:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression5676);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression5686); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3088:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3093:6: ( ( () 'end' ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3094:1: ( () 'end' )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3094:1: ( () 'end' )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3094:2: () 'end'
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3094:2: ()
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3095:5: 
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

            match(input,37,FOLLOW_37_in_ruleEndExpression5730); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3117:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3118:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3119:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression5766);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression5776); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3126:1: ruleUnitExpression returns [EObject current=null] : ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_numerator_0_0 = null;

        EObject lv_denominator_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3131:6: ( ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3132:1: ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3132:1: ( ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3132:2: ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3132:2: ( (lv_numerator_0_0= ruleUnitExpressionNumerator ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3133:1: (lv_numerator_0_0= ruleUnitExpressionNumerator )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3133:1: (lv_numerator_0_0= ruleUnitExpressionNumerator )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3134:3: lv_numerator_0_0= ruleUnitExpressionNumerator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression5822);
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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3156:2: ( '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3156:4: '/' ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) )
                    {
                    match(input,38,FOLLOW_38_in_ruleUnitExpression5833); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3160:1: ( (lv_denominator_2_0= ruleUnitExpressionDenominator ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3161:1: (lv_denominator_2_0= ruleUnitExpressionDenominator )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3161:1: (lv_denominator_2_0= ruleUnitExpressionDenominator )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3162:3: lv_denominator_2_0= ruleUnitExpressionDenominator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression5854);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3192:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3193:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3194:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator5892);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator5902); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3201:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3206:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3207:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3207:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_INTEGER) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_IDENT) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3207:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3207:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3207:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3208:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3208:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3209:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator5944); 

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
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3232:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3232:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3232:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3232:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3233:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3233:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3234:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator5977);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3256:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==39) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3256:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,39,FOLLOW_39_in_ruleUnitExpressionNumerator5988); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3260:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3261:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3261:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3262:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator6009);
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
                    	    break loop45;
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3292:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3293:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3294:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator6048);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator6058); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3301:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3306:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3307:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3307:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_IDENT) ) {
                alt48=1;
            }
            else if ( (LA48_0==26) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3307:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3307:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3307:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3308:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3308:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3309:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6104);
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
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3332:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3332:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3332:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleUnitExpressionDenominator6121); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3336:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3337:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3337:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3338:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6142);
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

                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3360:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==39) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3360:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,39,FOLLOW_39_in_ruleUnitExpressionDenominator6153); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3364:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3365:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3365:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3366:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6174);
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
                    	    break loop47;
                        }
                    } while (true);

                    match(input,27,FOLLOW_27_in_ruleUnitExpressionDenominator6186); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3400:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3401:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3402:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor6223);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor6233); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3409:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;
        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3414:6: ( ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3415:1: ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3415:1: ( ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3415:2: ( (lv_operand_0_0= RULE_IDENT ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3415:2: ( (lv_operand_0_0= RULE_IDENT ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3416:1: (lv_operand_0_0= RULE_IDENT )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3416:1: (lv_operand_0_0= RULE_IDENT )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3417:3: lv_operand_0_0= RULE_IDENT
            {
            lv_operand_0_0=(Token)input.LT(1);
            match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleUnitExpressionFactor6275); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3439:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==40) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3439:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,40,FOLLOW_40_in_ruleUnitExpressionFactor6291); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3443:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3444:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3444:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3445:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor6312);
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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3475:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3476:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3477:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent6350);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent6360); 

            }

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3484:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3489:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3490:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3490:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3490:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3490:2: ( (lv_negative_0_0= '-' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==25) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3491:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3491:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3492:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleUnitExpressionExponent6403); 

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

            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3511:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3512:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3512:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3513:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent6434); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3543:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3547:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3548:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3548:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )
            int alt51=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt51=1;
                }
                break;
            case 42:
                {
                alt51=2;
                }
                break;
            case 43:
                {
                alt51=3;
                }
                break;
            case 44:
                {
                alt51=4;
                }
                break;
            case 45:
                {
                alt51=5;
                }
                break;
            case 46:
                {
                alt51=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3548:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '<>' ) )", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3548:2: ( '<' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3548:2: ( '<' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3548:4: '<'
                    {
                    match(input,41,FOLLOW_41_in_ruleRelationalOperator6487); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3554:6: ( '<=' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3554:6: ( '<=' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3554:8: '<='
                    {
                    match(input,42,FOLLOW_42_in_ruleRelationalOperator6502); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3560:6: ( '>' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3560:6: ( '>' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3560:8: '>'
                    {
                    match(input,43,FOLLOW_43_in_ruleRelationalOperator6517); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3566:6: ( '>=' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3566:6: ( '>=' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3566:8: '>='
                    {
                    match(input,44,FOLLOW_44_in_ruleRelationalOperator6532); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3572:6: ( '==' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3572:6: ( '==' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3572:8: '=='
                    {
                    match(input,45,FOLLOW_45_in_ruleRelationalOperator6547); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualToEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3578:6: ( '<>' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3578:6: ( '<>' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3578:8: '<>'
                    {
                    match(input,46,FOLLOW_46_in_ruleRelationalOperator6562); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3588:1: ruleAddSubtractOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) ) ;
    public final Enumerator ruleAddSubtractOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3592:6: ( ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3593:1: ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3593:1: ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt52=1;
                }
                break;
            case 25:
                {
                alt52=2;
                }
                break;
            case 48:
                {
                alt52=3;
                }
                break;
            case 49:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3593:1: ( ( '+' ) | ( '-' ) | ( '.+' ) | ( '.-' ) )", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3593:2: ( '+' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3593:2: ( '+' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3593:4: '+'
                    {
                    match(input,47,FOLLOW_47_in_ruleAddSubtractOperator6605); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getAddEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3599:6: ( '-' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3599:6: ( '-' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3599:8: '-'
                    {
                    match(input,25,FOLLOW_25_in_ruleAddSubtractOperator6620); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getSubtractEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3605:6: ( '.+' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3605:6: ( '.+' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3605:8: '.+'
                    {
                    match(input,48,FOLLOW_48_in_ruleAddSubtractOperator6635); 

                            current = grammarAccess.getAddSubtractOperatorAccess().getElementWiseAddEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAddSubtractOperatorAccess().getElementWiseAddEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3611:6: ( '.-' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3611:6: ( '.-' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3611:8: '.-'
                    {
                    match(input,49,FOLLOW_49_in_ruleAddSubtractOperator6650); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3621:1: ruleMultiplyDivideOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplyDivideOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3625:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3626:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3626:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt53=1;
                }
                break;
            case 38:
                {
                alt53=2;
                }
                break;
            case 50:
                {
                alt53=3;
                }
                break;
            case 51:
                {
                alt53=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3626:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3626:2: ( '*' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3626:2: ( '*' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3626:4: '*'
                    {
                    match(input,39,FOLLOW_39_in_ruleMultiplyDivideOperator6693); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getMultiplyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3632:6: ( '/' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3632:6: ( '/' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3632:8: '/'
                    {
                    match(input,38,FOLLOW_38_in_ruleMultiplyDivideOperator6708); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getDivideEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3638:6: ( '.*' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3638:6: ( '.*' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3638:8: '.*'
                    {
                    match(input,50,FOLLOW_50_in_ruleMultiplyDivideOperator6723); 

                            current = grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplyDivideOperatorAccess().getElementWiseMultiplyEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3644:6: ( './' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3644:6: ( './' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3644:8: './'
                    {
                    match(input,51,FOLLOW_51_in_ruleMultiplyDivideOperator6738); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3654:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3658:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3659:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3659:1: ( ( '^' ) | ( '.^' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==40) ) {
                alt54=1;
            }
            else if ( (LA54_0==52) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3659:1: ( ( '^' ) | ( '.^' ) )", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3659:2: ( '^' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3659:2: ( '^' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3659:4: '^'
                    {
                    match(input,40,FOLLOW_40_in_rulePowerOperator6781); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3665:6: ( '.^' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3665:6: ( '.^' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3665:8: '.^'
                    {
                    match(input,52,FOLLOW_52_in_rulePowerOperator6796); 

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
    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3675:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3679:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:1: ( ( 'false' ) | ( 'true' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==53) ) {
                alt55=1;
            }
            else if ( (LA55_0==54) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3680:1: ( ( 'false' ) | ( 'true' ) )", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:2: ( 'false' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:2: ( 'false' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3680:4: 'false'
                    {
                    match(input,53,FOLLOW_53_in_ruleBooleanKind6839); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3686:6: ( 'true' )
                    {
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3686:6: ( 'true' )
                    // ../org.eclipselabs.damos.scripting/src-gen/org/eclipselabs/damos/scripting/parser/antlr/internal/InternalMscript.g:3686:8: 'true'
                    {
                    match(input,54,FOLLOW_54_in_ruleBooleanKind6854); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageAS_in_entryRulePackageAS167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageAS177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePackageAS212 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_ruleName_in_rulePackageAS233 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePackageAS243 = new BitSet(new long[]{0x000000000000D000L});
    public static final BitSet FOLLOW_rulePackageableElementAS_in_rulePackageAS264 = new BitSet(new long[]{0x000000000000D000L});
    public static final BitSet FOLLOW_14_in_rulePackageAS275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageableElementAS_in_entryRulePackageableElementAS311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageableElementAS321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageAS_in_rulePackageableElementAS368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationAS_in_rulePackageableElementAS395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationAS_in_entryRuleEnumerationAS430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationAS440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationAS475 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleEnumerationAS492 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationAS507 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralAS_in_ruleEnumerationAS529 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_ruleEnumerationAS540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralAS_in_ruleEnumerationAS561 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationAS575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralAS_in_entryRuleEnumerationLiteralAS611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralAS621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleEnumerationLiteralAS662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleConditionalExpression866 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression887 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleConditionalExpression898 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_ruleConditionalExpression919 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_ruleConditionalExpression931 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpression952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpressionCase_in_entryRuleConditionalExpressionCase988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpressionCase998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1044 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConditionalExpressionCase1054 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpressionCase1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression1111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1168 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleRangeExpression1187 = new BitSet(new long[]{0x00600033770020F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1208 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleRangeExpression1219 = new BitSet(new long[]{0x00600033770020F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleRangeExpression1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression1280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression1337 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleLogicalOrExpression1357 = new BitSet(new long[]{0x00600033770020F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression1378 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression1418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression1475 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleLogicalAndExpression1495 = new BitSet(new long[]{0x00600033770020F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression1516 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression1556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleLogicalNotExpression1638 = new BitSet(new long[]{0x00600033760020F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleLogicalNotExpression1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression1753 = new BitSet(new long[]{0x00007E0000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression1784 = new BitSet(new long[]{0x00600033760020F0L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_ruleRelationalExpression1805 = new BitSet(new long[]{0x00007E0000000002L});
    public static final BitSet FOLLOW_ruleAddSubtractExpression_in_entryRuleAddSubtractExpression1845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddSubtractExpression1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression1902 = new BitSet(new long[]{0x0003800002000002L});
    public static final BitSet FOLLOW_ruleAddSubtractOperator_in_ruleAddSubtractExpression1933 = new BitSet(new long[]{0x00600033760020F0L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_ruleAddSubtractExpression1954 = new BitSet(new long[]{0x0003800002000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideExpression_in_entryRuleMultiplyDivideExpression1994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplyDivideExpression2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2051 = new BitSet(new long[]{0x000C00C000000002L});
    public static final BitSet FOLLOW_ruleMultiplyDivideOperator_in_ruleMultiplyDivideExpression2082 = new BitSet(new long[]{0x00600033760020F0L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplyDivideExpression2103 = new BitSet(new long[]{0x000C00C000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression2143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression2200 = new BitSet(new long[]{0x0010010000000002L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression2230 = new BitSet(new long[]{0x00600033760020F0L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_rulePowerExpression2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryMinusExpression_in_entryRuleUnaryMinusExpression2289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryMinusExpression2299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleUnaryMinusExpression2371 = new BitSet(new long[]{0x00600033740020F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryMinusExpression2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentReference_in_rulePrimaryExpression2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_rulePrimaryExpression2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_rulePrimaryExpression2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_ruleLiteral2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalLiteral_in_entryRuleNumericalLiteral2856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalLiteral2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericalLiteral2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericalLiteral2940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral2975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral3027 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleRealLiteral3043 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral3064 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleRealLiteral3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral3112 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral3122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral3164 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleIntegerLiteral3180 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral3201 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleIntegerLiteral3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral3304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall3430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedFunctionCall_in_ruleFunctionCall3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordFunctionCall_in_ruleFunctionCall3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedFunctionCall_in_entryRuleNamedFunctionCall3549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedFunctionCall3559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleNamedFunctionCall3605 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleNamedFunctionCall3615 = new BitSet(new long[]{0x006000337F0220F0L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_ruleNamedFunctionCall3636 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleNamedFunctionCall3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName3683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleName3736 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleName3767 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleName3783 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleName3800 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleKeywordFunctionCall_in_entryRuleKeywordFunctionCall3843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordFunctionCall3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleKeywordFunctionCall3898 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_30_in_ruleKeywordFunctionCall3927 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleKeywordFunctionCall3953 = new BitSet(new long[]{0x006000337F0220F0L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_ruleKeywordFunctionCall3974 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleKeywordFunctionCall3985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_entryRuleFunctionArgumentList4021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionArgumentList4031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionArgumentList4078 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctionArgumentList4090 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionArgumentList4111 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctionArgumentList4124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4145 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4177 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFunctionArgumentList4188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleFunctionArgumentList4209 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleNamedArgument4300 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleNamedArgument4315 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument4336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentReference_in_entryRuleComponentReference4372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentReference4382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleComponentReference4425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference4460 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleComponentReference4471 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleComponentReferenceSegment_in_ruleComponentReference4492 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleComponentReferenceSegment_in_entryRuleComponentReferenceSegment4530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentReferenceSegment4540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleComponentReferenceSegment4582 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleArraySubscriptList_in_ruleComponentReferenceSegment4608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArraySubscriptList_in_entryRuleArraySubscriptList4645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArraySubscriptList4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArraySubscriptList4690 = new BitSet(new long[]{0x00600033772220F0L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArraySubscriptList4711 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleArraySubscriptList4722 = new BitSet(new long[]{0x00600033772220F0L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArraySubscriptList4743 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleArraySubscriptList4755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubscript_in_entryRuleSubscript4791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubscript4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_ruleSubscript4848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_ruleSubscript4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleColonSubscript_in_entryRuleColonSubscript4910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleColonSubscript4920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleColonSubscript4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionSubscript_in_entryRuleExpressionSubscript5000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionSubscript5010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionSubscript5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator5090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConcatenationOperator5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArrayConcatenationOperator5135 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5156 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_35_in_ruleArrayConcatenationOperator5167 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator5188 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_34_in_ruleArrayConcatenationOperator5200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator5236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConstructionOperator5246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleArrayConstructionOperator5281 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleFunctionArgumentList_in_ruleArrayConstructionOperator5302 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleArrayConstructionOperator5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList5348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList5358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList5404 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionList5415 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList5436 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression5474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression5484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedExpression5519 = new BitSet(new long[]{0x00600033770220F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression5540 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleParenthesizedExpression5550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression5586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleBeginExpression5640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression5676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression5686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleEndExpression5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression5766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression5776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression5822 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleUnitExpression5833 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator5892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator5902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator5944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator5977 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleUnitExpressionNumerator5988 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator6009 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator6048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleUnitExpressionDenominator6121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6142 = new BitSet(new long[]{0x0000008008000000L});
    public static final BitSet FOLLOW_39_in_ruleUnitExpressionDenominator6153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator6174 = new BitSet(new long[]{0x0000008008000000L});
    public static final BitSet FOLLOW_27_in_ruleUnitExpressionDenominator6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor6223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor6233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleUnitExpressionFactor6275 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleUnitExpressionFactor6291 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor6312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent6350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent6360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleUnitExpressionExponent6403 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent6434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRelationalOperator6487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleRelationalOperator6502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleRelationalOperator6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleRelationalOperator6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelationalOperator6547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator6562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleAddSubtractOperator6605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleAddSubtractOperator6620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAddSubtractOperator6635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleAddSubtractOperator6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleMultiplyDivideOperator6693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleMultiplyDivideOperator6708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleMultiplyDivideOperator6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleMultiplyDivideOperator6738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rulePowerOperator6781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rulePowerOperator6796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleBooleanKind6839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleBooleanKind6854 = new BitSet(new long[]{0x0000000000000002L});

}