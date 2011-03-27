package org.yakindu.sct.statechart.parser.antlr.internal; 

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
import org.yakindu.sct.statechart.services.ExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_BOOL", "RULE_STRING", "RULE_FLOAT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@@statechart@@'", "'@@state@@'", "'@@transition@@'", "'interface'", "':'", "'internal'", "'event'", "'='", "'var'", "'readonly'", "'external'", "'clock'", "'operation'", "'('", "','", "')'", "'entrypoint'", "'exitpoint'", "'/'", "'#'", "'['", "']'", "'>'", "'after'", "'enter'", "'exit'", "'oncycle'", "'always'", "'raise'", "'||'", "'&&'", "'!'", "'in'", "'out'", "'+'", "'-'", "'*'", "'%'", "'~'", "'<'", "'<='", "'>='", "'=='", "'!='", "'s'", "'ms'", "'ns'", "'void'", "'integer'", "'real'", "'boolean'", "'string'"
    };
    public static final int RULE_ML_COMMENT=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=11;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=7;
    public static final int RULE_BOOL=6;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_FLOAT=8;
    public static final int RULE_SL_COMMENT=10;

        public InternalExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g"; }



     	private ExpressionsGrammarAccess grammarAccess;
     	
        public InternalExpressionsParser(TokenStream input, IAstFactory factory, ExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected ExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:78:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:79:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:80:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();
            _fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoot85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRoot


    // $ANTLR start ruleRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:87:1: ruleRoot returns [EObject current=null] : ( (lv_roots_0_0= ruleDefRoot ) )* ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_roots_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:92:6: ( ( (lv_roots_0_0= ruleDefRoot ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:93:1: ( (lv_roots_0_0= ruleDefRoot ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:93:1: ( (lv_roots_0_0= ruleDefRoot ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:94:1: (lv_roots_0_0= ruleDefRoot )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:94:1: (lv_roots_0_0= ruleDefRoot )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:95:3: lv_roots_0_0= ruleDefRoot
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getRootsDefRootParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefRoot_in_ruleRoot130);
            	    lv_roots_0_0=ruleDefRoot();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"roots",
            	    	        		lv_roots_0_0, 
            	    	        		"DefRoot", 
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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleDefRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:125:1: entryRuleDefRoot returns [EObject current=null] : iv_ruleDefRoot= ruleDefRoot EOF ;
    public final EObject entryRuleDefRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefRoot = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:126:2: (iv_ruleDefRoot= ruleDefRoot EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:127:2: iv_ruleDefRoot= ruleDefRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefRootRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefRoot_in_entryRuleDefRoot166);
            iv_ruleDefRoot=ruleDefRoot();
            _fsp--;

             current =iv_ruleDefRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefRoot176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDefRoot


    // $ANTLR start ruleDefRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:134:1: ruleDefRoot returns [EObject current=null] : (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot ) ;
    public final EObject ruleDefRoot() throws RecognitionException {
        EObject current = null;

        EObject this_StatechartRoot_0 = null;

        EObject this_StateRoot_1 = null;

        EObject this_TransitionRoot_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:139:6: ( (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:140:1: (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:140:1: (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("140:1: (this_StatechartRoot_0= ruleStatechartRoot | this_StateRoot_1= ruleStateRoot | this_TransitionRoot_2= ruleTransitionRoot )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:141:5: this_StatechartRoot_0= ruleStatechartRoot
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefRootAccess().getStatechartRootParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStatechartRoot_in_ruleDefRoot223);
                    this_StatechartRoot_0=ruleStatechartRoot();
                    _fsp--;

                     
                            current = this_StatechartRoot_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:151:5: this_StateRoot_1= ruleStateRoot
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefRootAccess().getStateRootParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStateRoot_in_ruleDefRoot250);
                    this_StateRoot_1=ruleStateRoot();
                    _fsp--;

                     
                            current = this_StateRoot_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:161:5: this_TransitionRoot_2= ruleTransitionRoot
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefRootAccess().getTransitionRootParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTransitionRoot_in_ruleDefRoot277);
                    this_TransitionRoot_2=ruleTransitionRoot();
                    _fsp--;

                     
                            current = this_TransitionRoot_2; 
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
    // $ANTLR end ruleDefRoot


    // $ANTLR start entryRuleStatechartRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:177:1: entryRuleStatechartRoot returns [EObject current=null] : iv_ruleStatechartRoot= ruleStatechartRoot EOF ;
    public final EObject entryRuleStatechartRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartRoot = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:178:2: (iv_ruleStatechartRoot= ruleStatechartRoot EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:179:2: iv_ruleStatechartRoot= ruleStatechartRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatechartRootRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatechartRoot_in_entryRuleStatechartRoot312);
            iv_ruleStatechartRoot=ruleStatechartRoot();
            _fsp--;

             current =iv_ruleStatechartRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartRoot322); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStatechartRoot


    // $ANTLR start ruleStatechartRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:186:1: ruleStatechartRoot returns [EObject current=null] : ( '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) ) ;
    public final EObject ruleStatechartRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_def_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:191:6: ( ( '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:192:1: ( '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:192:1: ( '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:192:3: '@@statechart@@' ( (lv_def_1_0= ruleStatechartDefinition ) )
            {
            match(input,13,FOLLOW_13_in_ruleStatechartRoot357); 

                    createLeafNode(grammarAccess.getStatechartRootAccess().getStatechartKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:196:1: ( (lv_def_1_0= ruleStatechartDefinition ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:197:1: (lv_def_1_0= ruleStatechartDefinition )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:197:1: (lv_def_1_0= ruleStatechartDefinition )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:198:3: lv_def_1_0= ruleStatechartDefinition
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStatechartRootAccess().getDefStatechartDefinitionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleStatechartDefinition_in_ruleStatechartRoot378);
            lv_def_1_0=ruleStatechartDefinition();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStatechartRootRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"def",
            	        		lv_def_1_0, 
            	        		"StatechartDefinition", 
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
    // $ANTLR end ruleStatechartRoot


    // $ANTLR start entryRuleStateRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:228:1: entryRuleStateRoot returns [EObject current=null] : iv_ruleStateRoot= ruleStateRoot EOF ;
    public final EObject entryRuleStateRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateRoot = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:229:2: (iv_ruleStateRoot= ruleStateRoot EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:230:2: iv_ruleStateRoot= ruleStateRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRootRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateRoot_in_entryRuleStateRoot414);
            iv_ruleStateRoot=ruleStateRoot();
            _fsp--;

             current =iv_ruleStateRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateRoot424); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStateRoot


    // $ANTLR start ruleStateRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:237:1: ruleStateRoot returns [EObject current=null] : ( '@@state@@' ( (lv_def_1_0= ruleStateDefinition ) ) ) ;
    public final EObject ruleStateRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_def_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:242:6: ( ( '@@state@@' ( (lv_def_1_0= ruleStateDefinition ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:243:1: ( '@@state@@' ( (lv_def_1_0= ruleStateDefinition ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:243:1: ( '@@state@@' ( (lv_def_1_0= ruleStateDefinition ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:243:3: '@@state@@' ( (lv_def_1_0= ruleStateDefinition ) )
            {
            match(input,14,FOLLOW_14_in_ruleStateRoot459); 

                    createLeafNode(grammarAccess.getStateRootAccess().getStateKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:247:1: ( (lv_def_1_0= ruleStateDefinition ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:248:1: (lv_def_1_0= ruleStateDefinition )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:248:1: (lv_def_1_0= ruleStateDefinition )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:249:3: lv_def_1_0= ruleStateDefinition
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStateRootAccess().getDefStateDefinitionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleStateDefinition_in_ruleStateRoot480);
            lv_def_1_0=ruleStateDefinition();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStateRootRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"def",
            	        		lv_def_1_0, 
            	        		"StateDefinition", 
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
    // $ANTLR end ruleStateRoot


    // $ANTLR start entryRuleTransitionRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:279:1: entryRuleTransitionRoot returns [EObject current=null] : iv_ruleTransitionRoot= ruleTransitionRoot EOF ;
    public final EObject entryRuleTransitionRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionRoot = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:280:2: (iv_ruleTransitionRoot= ruleTransitionRoot EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:281:2: iv_ruleTransitionRoot= ruleTransitionRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRootRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot516);
            iv_ruleTransitionRoot=ruleTransitionRoot();
            _fsp--;

             current =iv_ruleTransitionRoot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionRoot526); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransitionRoot


    // $ANTLR start ruleTransitionRoot
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:288:1: ruleTransitionRoot returns [EObject current=null] : ( '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) ) ;
    public final EObject ruleTransitionRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_def_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:293:6: ( ( '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:294:1: ( '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:294:1: ( '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:294:3: '@@transition@@' ( (lv_def_1_0= ruleTransitionStatement ) )
            {
            match(input,15,FOLLOW_15_in_ruleTransitionRoot561); 

                    createLeafNode(grammarAccess.getTransitionRootAccess().getTransitionKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:298:1: ( (lv_def_1_0= ruleTransitionStatement ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:299:1: (lv_def_1_0= ruleTransitionStatement )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:299:1: (lv_def_1_0= ruleTransitionStatement )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:300:3: lv_def_1_0= ruleTransitionStatement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTransitionRootAccess().getDefTransitionStatementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTransitionStatement_in_ruleTransitionRoot582);
            lv_def_1_0=ruleTransitionStatement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTransitionRootRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"def",
            	        		lv_def_1_0, 
            	        		"TransitionStatement", 
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
    // $ANTLR end ruleTransitionRoot


    // $ANTLR start entryRuleStatechartDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:330:1: entryRuleStatechartDefinition returns [EObject current=null] : iv_ruleStatechartDefinition= ruleStatechartDefinition EOF ;
    public final EObject entryRuleStatechartDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartDefinition = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:331:2: (iv_ruleStatechartDefinition= ruleStatechartDefinition EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:332:2: iv_ruleStatechartDefinition= ruleStatechartDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatechartDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatechartDefinition_in_entryRuleStatechartDefinition618);
            iv_ruleStatechartDefinition=ruleStatechartDefinition();
            _fsp--;

             current =iv_ruleStatechartDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartDefinition628); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStatechartDefinition


    // $ANTLR start ruleStatechartDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:339:1: ruleStatechartDefinition returns [EObject current=null] : ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* ) ;
    public final EObject ruleStatechartDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_definitionScopes_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:344:6: ( ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:345:1: ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:345:1: ( () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:345:2: () ( (lv_definitionScopes_1_0= ruleStatechartScope ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:345:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:346:5: 
            {
             
                    temp=factory.create(grammarAccess.getStatechartDefinitionAccess().getStatechartDefinitionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getStatechartDefinitionAccess().getStatechartDefinitionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:356:2: ( (lv_definitionScopes_1_0= ruleStatechartScope ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16||LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:357:1: (lv_definitionScopes_1_0= ruleStatechartScope )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:357:1: (lv_definitionScopes_1_0= ruleStatechartScope )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:358:3: lv_definitionScopes_1_0= ruleStatechartScope
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStatechartDefinitionAccess().getDefinitionScopesStatechartScopeParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatechartScope_in_ruleStatechartDefinition683);
            	    lv_definitionScopes_1_0=ruleStatechartScope();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStatechartDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"definitionScopes",
            	    	        		lv_definitionScopes_1_0, 
            	    	        		"StatechartScope", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end ruleStatechartDefinition


    // $ANTLR start entryRuleStateDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:388:1: entryRuleStateDefinition returns [EObject current=null] : iv_ruleStateDefinition= ruleStateDefinition EOF ;
    public final EObject entryRuleStateDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateDefinition = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:389:2: (iv_ruleStateDefinition= ruleStateDefinition EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:390:2: iv_ruleStateDefinition= ruleStateDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateDefinition_in_entryRuleStateDefinition720);
            iv_ruleStateDefinition=ruleStateDefinition();
            _fsp--;

             current =iv_ruleStateDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateDefinition730); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStateDefinition


    // $ANTLR start ruleStateDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:397:1: ruleStateDefinition returns [EObject current=null] : this_SimpleScope_0= ruleSimpleScope ;
    public final EObject ruleStateDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleScope_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:402:6: (this_SimpleScope_0= ruleSimpleScope )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:404:5: this_SimpleScope_0= ruleSimpleScope
            {
             
                    currentNode=createCompositeNode(grammarAccess.getStateDefinitionAccess().getSimpleScopeParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleSimpleScope_in_ruleStateDefinition776);
            this_SimpleScope_0=ruleSimpleScope();
            _fsp--;

             
                    current = this_SimpleScope_0; 
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
    // $ANTLR end ruleStateDefinition


    // $ANTLR start entryRuleTransitionStatement
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:420:1: entryRuleTransitionStatement returns [EObject current=null] : iv_ruleTransitionStatement= ruleTransitionStatement EOF ;
    public final EObject entryRuleTransitionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionStatement = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:421:2: (iv_ruleTransitionStatement= ruleTransitionStatement EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:422:2: iv_ruleTransitionStatement= ruleTransitionStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionStatement_in_entryRuleTransitionStatement810);
            iv_ruleTransitionStatement=ruleTransitionStatement();
            _fsp--;

             current =iv_ruleTransitionStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionStatement820); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransitionStatement


    // $ANTLR start ruleTransitionStatement
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:429:1: ruleTransitionStatement returns [EObject current=null] : this_TransitionReaction_0= ruleTransitionReaction ;
    public final EObject ruleTransitionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TransitionReaction_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:434:6: (this_TransitionReaction_0= ruleTransitionReaction )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:436:5: this_TransitionReaction_0= ruleTransitionReaction
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTransitionStatementAccess().getTransitionReactionParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleTransitionReaction_in_ruleTransitionStatement866);
            this_TransitionReaction_0=ruleTransitionReaction();
            _fsp--;

             
                    current = this_TransitionReaction_0; 
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
    // $ANTLR end ruleTransitionStatement


    // $ANTLR start entryRuleSimpleScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:454:1: entryRuleSimpleScope returns [EObject current=null] : iv_ruleSimpleScope= ruleSimpleScope EOF ;
    public final EObject entryRuleSimpleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleScope = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:455:2: (iv_ruleSimpleScope= ruleSimpleScope EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:456:2: iv_ruleSimpleScope= ruleSimpleScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleScope_in_entryRuleSimpleScope902);
            iv_ruleSimpleScope=ruleSimpleScope();
            _fsp--;

             current =iv_ruleSimpleScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleScope912); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimpleScope


    // $ANTLR start ruleSimpleScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:463:1: ruleSimpleScope returns [EObject current=null] : ( () ( (lv_definitions_1_0= ruleDefinition ) )* ) ;
    public final EObject ruleSimpleScope() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:468:6: ( ( () ( (lv_definitions_1_0= ruleDefinition ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:469:1: ( () ( (lv_definitions_1_0= ruleDefinition ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:469:1: ( () ( (lv_definitions_1_0= ruleDefinition ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:469:2: () ( (lv_definitions_1_0= ruleDefinition ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:469:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:470:5: 
            {
             
                    temp=factory.create(grammarAccess.getSimpleScopeAccess().getSimpleScopeAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getSimpleScopeAccess().getSimpleScopeAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:480:2: ( (lv_definitions_1_0= ruleDefinition ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==19||LA4_0==21||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=29 && LA4_0<=30)||(LA4_0>=36 && LA4_0<=40)||(LA4_0>=45 && LA4_0<=46)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:481:1: (lv_definitions_1_0= ruleDefinition )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:481:1: (lv_definitions_1_0= ruleDefinition )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:482:3: lv_definitions_1_0= ruleDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSimpleScopeAccess().getDefinitionsDefinitionParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefinition_in_ruleSimpleScope967);
            	    lv_definitions_1_0=ruleDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSimpleScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"definitions",
            	    	        		lv_definitions_1_0, 
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
            	    break loop4;
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
    // $ANTLR end ruleSimpleScope


    // $ANTLR start entryRuleStatechartScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:512:1: entryRuleStatechartScope returns [EObject current=null] : iv_ruleStatechartScope= ruleStatechartScope EOF ;
    public final EObject entryRuleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatechartScope = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:513:2: (iv_ruleStatechartScope= ruleStatechartScope EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:514:2: iv_ruleStatechartScope= ruleStatechartScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatechartScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1004);
            iv_ruleStatechartScope=ruleStatechartScope();
            _fsp--;

             current =iv_ruleStatechartScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatechartScope1014); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStatechartScope


    // $ANTLR start ruleStatechartScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:521:1: ruleStatechartScope returns [EObject current=null] : (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) ;
    public final EObject ruleStatechartScope() throws RecognitionException {
        EObject current = null;

        EObject this_InterfaceScope_0 = null;

        EObject this_InternalScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:526:6: ( (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:527:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:527:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("527:1: (this_InterfaceScope_0= ruleInterfaceScope | this_InternalScope_1= ruleInternalScope )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:528:5: this_InterfaceScope_0= ruleInterfaceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatechartScopeAccess().getInterfaceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1061);
                    this_InterfaceScope_0=ruleInterfaceScope();
                    _fsp--;

                     
                            current = this_InterfaceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:538:5: this_InternalScope_1= ruleInternalScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatechartScopeAccess().getInternalScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInternalScope_in_ruleStatechartScope1088);
                    this_InternalScope_1=ruleInternalScope();
                    _fsp--;

                     
                            current = this_InternalScope_1; 
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
    // $ANTLR end ruleStatechartScope


    // $ANTLR start entryRuleInterfaceScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:554:1: entryRuleInterfaceScope returns [EObject current=null] : iv_ruleInterfaceScope= ruleInterfaceScope EOF ;
    public final EObject entryRuleInterfaceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceScope = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:555:2: (iv_ruleInterfaceScope= ruleInterfaceScope EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:556:2: iv_ruleInterfaceScope= ruleInterfaceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInterfaceScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1123);
            iv_ruleInterfaceScope=ruleInterfaceScope();
            _fsp--;

             current =iv_ruleInterfaceScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterfaceScope1133); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleInterfaceScope


    // $ANTLR start ruleInterfaceScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:563:1: ruleInterfaceScope returns [EObject current=null] : ( () 'interface' ( (lv_name_2_0= RULE_ID ) )? ':' ( (lv_definitions_4_0= ruleDefinition ) )* ) ;
    public final EObject ruleInterfaceScope() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_definitions_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:568:6: ( ( () 'interface' ( (lv_name_2_0= RULE_ID ) )? ':' ( (lv_definitions_4_0= ruleDefinition ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:569:1: ( () 'interface' ( (lv_name_2_0= RULE_ID ) )? ':' ( (lv_definitions_4_0= ruleDefinition ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:569:1: ( () 'interface' ( (lv_name_2_0= RULE_ID ) )? ':' ( (lv_definitions_4_0= ruleDefinition ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:569:2: () 'interface' ( (lv_name_2_0= RULE_ID ) )? ':' ( (lv_definitions_4_0= ruleDefinition ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:569:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:570:5: 
            {
             
                    temp=factory.create(grammarAccess.getInterfaceScopeAccess().getInterfaceScopeAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getInterfaceScopeAccess().getInterfaceScopeAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,16,FOLLOW_16_in_ruleInterfaceScope1177); 

                    createLeafNode(grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:584:1: ( (lv_name_2_0= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:585:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:585:1: (lv_name_2_0= RULE_ID )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:586:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInterfaceScope1194); 

                    			createLeafNode(grammarAccess.getInterfaceScopeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInterfaceScopeRule().getType().getClassifier());
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
                    break;

            }

            match(input,17,FOLLOW_17_in_ruleInterfaceScope1210); 

                    createLeafNode(grammarAccess.getInterfaceScopeAccess().getColonKeyword_3(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:612:1: ( (lv_definitions_4_0= ruleDefinition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==19||LA7_0==21||(LA7_0>=24 && LA7_0<=25)||(LA7_0>=29 && LA7_0<=30)||(LA7_0>=36 && LA7_0<=40)||(LA7_0>=45 && LA7_0<=46)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:613:1: (lv_definitions_4_0= ruleDefinition )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:613:1: (lv_definitions_4_0= ruleDefinition )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:614:3: lv_definitions_4_0= ruleDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getInterfaceScopeAccess().getDefinitionsDefinitionParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefinition_in_ruleInterfaceScope1231);
            	    lv_definitions_4_0=ruleDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getInterfaceScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"definitions",
            	    	        		lv_definitions_4_0, 
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
            	    break loop7;
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
    // $ANTLR end ruleInterfaceScope


    // $ANTLR start entryRuleInternalScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:644:1: entryRuleInternalScope returns [EObject current=null] : iv_ruleInternalScope= ruleInternalScope EOF ;
    public final EObject entryRuleInternalScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalScope = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:645:2: (iv_ruleInternalScope= ruleInternalScope EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:646:2: iv_ruleInternalScope= ruleInternalScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInternalScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleInternalScope_in_entryRuleInternalScope1268);
            iv_ruleInternalScope=ruleInternalScope();
            _fsp--;

             current =iv_ruleInternalScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalScope1278); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleInternalScope


    // $ANTLR start ruleInternalScope
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:653:1: ruleInternalScope returns [EObject current=null] : ( () 'internal' ':' ( (lv_definitions_3_0= ruleDefinition ) )* ) ;
    public final EObject ruleInternalScope() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:658:6: ( ( () 'internal' ':' ( (lv_definitions_3_0= ruleDefinition ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:659:1: ( () 'internal' ':' ( (lv_definitions_3_0= ruleDefinition ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:659:1: ( () 'internal' ':' ( (lv_definitions_3_0= ruleDefinition ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:659:2: () 'internal' ':' ( (lv_definitions_3_0= ruleDefinition ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:659:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:660:5: 
            {
             
                    temp=factory.create(grammarAccess.getInternalScopeAccess().getInternalScopeAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getInternalScopeAccess().getInternalScopeAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,18,FOLLOW_18_in_ruleInternalScope1322); 

                    createLeafNode(grammarAccess.getInternalScopeAccess().getInternalKeyword_1(), null); 
                
            match(input,17,FOLLOW_17_in_ruleInternalScope1332); 

                    createLeafNode(grammarAccess.getInternalScopeAccess().getColonKeyword_2(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:678:1: ( (lv_definitions_3_0= ruleDefinition ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==21||(LA8_0>=24 && LA8_0<=25)||(LA8_0>=29 && LA8_0<=30)||(LA8_0>=36 && LA8_0<=40)||(LA8_0>=45 && LA8_0<=46)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:679:1: (lv_definitions_3_0= ruleDefinition )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:679:1: (lv_definitions_3_0= ruleDefinition )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:680:3: lv_definitions_3_0= ruleDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getInternalScopeAccess().getDefinitionsDefinitionParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefinition_in_ruleInternalScope1353);
            	    lv_definitions_3_0=ruleDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getInternalScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"definitions",
            	    	        		lv_definitions_3_0, 
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
            	    break loop8;
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
    // $ANTLR end ruleInternalScope


    // $ANTLR start entryRuleDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:710:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:711:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:712:2: iv_ruleDefinition= ruleDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition1390);
            iv_ruleDefinition=ruleDefinition();
            _fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition1400); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:719:1: ruleDefinition returns [EObject current=null] : (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_EventDefinition_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_Clock_2 = null;

        EObject this_Operation_3 = null;

        EObject this_LocalReaction_4 = null;

        EObject this_Entrypoint_5 = null;

        EObject this_Exitpoint_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:724:6: ( (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:725:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:725:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 19:
            case 45:
            case 46:
                {
                alt9=1;
                }
                break;
            case 21:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            case RULE_ID:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt9=5;
                }
                break;
            case 29:
                {
                alt9=6;
                }
                break;
            case 30:
                {
                alt9=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("725:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_LocalReaction_4= ruleLocalReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:726:5: this_EventDefinition_0= ruleEventDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getEventDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEventDefinition_in_ruleDefinition1447);
                    this_EventDefinition_0=ruleEventDefinition();
                    _fsp--;

                     
                            current = this_EventDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:736:5: this_VariableDefinition_1= ruleVariableDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getVariableDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleDefinition1474);
                    this_VariableDefinition_1=ruleVariableDefinition();
                    _fsp--;

                     
                            current = this_VariableDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:746:5: this_Clock_2= ruleClock
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getClockParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleClock_in_ruleDefinition1501);
                    this_Clock_2=ruleClock();
                    _fsp--;

                     
                            current = this_Clock_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:756:5: this_Operation_3= ruleOperation
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getOperationParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperation_in_ruleDefinition1528);
                    this_Operation_3=ruleOperation();
                    _fsp--;

                     
                            current = this_Operation_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:766:5: this_LocalReaction_4= ruleLocalReaction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getLocalReactionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLocalReaction_in_ruleDefinition1555);
                    this_LocalReaction_4=ruleLocalReaction();
                    _fsp--;

                     
                            current = this_LocalReaction_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:776:5: this_Entrypoint_5= ruleEntrypoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getEntrypointParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntrypoint_in_ruleDefinition1582);
                    this_Entrypoint_5=ruleEntrypoint();
                    _fsp--;

                     
                            current = this_Entrypoint_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:786:5: this_Exitpoint_6= ruleExitpoint
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getExitpointParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExitpoint_in_ruleDefinition1609);
                    this_Exitpoint_6=ruleExitpoint();
                    _fsp--;

                     
                            current = this_Exitpoint_6; 
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


    // $ANTLR start entryRuleEventDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:804:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:805:2: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:806:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1646);
            iv_ruleEventDefinition=ruleEventDefinition();
            _fsp--;

             current =iv_ruleEventDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDefinition1656); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEventDefinition


    // $ANTLR start ruleEventDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:813:1: ruleEventDefinition returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirection ) )? 'event' ( (lv_name_2_0= RULE_ID ) ) ( ':' ( (lv_type_4_0= ruleType ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Enumerator lv_direction_0_0 = null;

        Enumerator lv_type_4_0 = null;

        EObject lv_derivation_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:818:6: ( ( ( (lv_direction_0_0= ruleDirection ) )? 'event' ( (lv_name_2_0= RULE_ID ) ) ( ':' ( (lv_type_4_0= ruleType ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:819:1: ( ( (lv_direction_0_0= ruleDirection ) )? 'event' ( (lv_name_2_0= RULE_ID ) ) ( ':' ( (lv_type_4_0= ruleType ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:819:1: ( ( (lv_direction_0_0= ruleDirection ) )? 'event' ( (lv_name_2_0= RULE_ID ) ) ( ':' ( (lv_type_4_0= ruleType ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:819:2: ( (lv_direction_0_0= ruleDirection ) )? 'event' ( (lv_name_2_0= RULE_ID ) ) ( ':' ( (lv_type_4_0= ruleType ) ) )? ( (lv_derivation_5_0= ruleEventDerivation ) )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:819:2: ( (lv_direction_0_0= ruleDirection ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=45 && LA10_0<=46)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:820:1: (lv_direction_0_0= ruleDirection )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:820:1: (lv_direction_0_0= ruleDirection )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:821:3: lv_direction_0_0= ruleDirection
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEventDefinitionAccess().getDirectionDirectionEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDirection_in_ruleEventDefinition1702);
                    lv_direction_0_0=ruleDirection();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEventDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"direction",
                    	        		lv_direction_0_0, 
                    	        		"Direction", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleEventDefinition1713); 

                    createLeafNode(grammarAccess.getEventDefinitionAccess().getEventKeyword_1(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:847:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:848:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:848:1: (lv_name_2_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:849:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDefinition1730); 

            			createLeafNode(grammarAccess.getEventDefinitionAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEventDefinitionRule().getType().getClassifier());
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:871:2: ( ':' ( (lv_type_4_0= ruleType ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:871:4: ':' ( (lv_type_4_0= ruleType ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleEventDefinition1746); 

                            createLeafNode(grammarAccess.getEventDefinitionAccess().getColonKeyword_3_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:875:1: ( (lv_type_4_0= ruleType ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:876:1: (lv_type_4_0= ruleType )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:876:1: (lv_type_4_0= ruleType )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:877:3: lv_type_4_0= ruleType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEventDefinitionAccess().getTypeTypeEnumRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleEventDefinition1767);
                    lv_type_4_0=ruleType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEventDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_4_0, 
                    	        		"Type", 
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:899:4: ( (lv_derivation_5_0= ruleEventDerivation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:900:1: (lv_derivation_5_0= ruleEventDerivation )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:900:1: (lv_derivation_5_0= ruleEventDerivation )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:901:3: lv_derivation_5_0= ruleEventDerivation
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEventDefinitionAccess().getDerivationEventDerivationParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEventDerivation_in_ruleEventDefinition1790);
                    lv_derivation_5_0=ruleEventDerivation();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEventDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"derivation",
                    	        		lv_derivation_5_0, 
                    	        		"EventDerivation", 
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
    // $ANTLR end ruleEventDefinition


    // $ANTLR start entryRuleEventDerivation
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:931:1: entryRuleEventDerivation returns [EObject current=null] : iv_ruleEventDerivation= ruleEventDerivation EOF ;
    public final EObject entryRuleEventDerivation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDerivation = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:932:2: (iv_ruleEventDerivation= ruleEventDerivation EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:933:2: iv_ruleEventDerivation= ruleEventDerivation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventDerivationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1827);
            iv_ruleEventDerivation=ruleEventDerivation();
            _fsp--;

             current =iv_ruleEventDerivation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDerivation1837); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEventDerivation


    // $ANTLR start ruleEventDerivation
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:940:1: ruleEventDerivation returns [EObject current=null] : ( '=' ( (lv_condition_1_0= ruleExpressionRule ) ) ( ':' ( (lv_value_3_0= ruleExpressionRule ) ) )? ) ;
    public final EObject ruleEventDerivation() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;

        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:945:6: ( ( '=' ( (lv_condition_1_0= ruleExpressionRule ) ) ( ':' ( (lv_value_3_0= ruleExpressionRule ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:946:1: ( '=' ( (lv_condition_1_0= ruleExpressionRule ) ) ( ':' ( (lv_value_3_0= ruleExpressionRule ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:946:1: ( '=' ( (lv_condition_1_0= ruleExpressionRule ) ) ( ':' ( (lv_value_3_0= ruleExpressionRule ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:946:3: '=' ( (lv_condition_1_0= ruleExpressionRule ) ) ( ':' ( (lv_value_3_0= ruleExpressionRule ) ) )?
            {
            match(input,20,FOLLOW_20_in_ruleEventDerivation1872); 

                    createLeafNode(grammarAccess.getEventDerivationAccess().getEqualsSignKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:950:1: ( (lv_condition_1_0= ruleExpressionRule ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:951:1: (lv_condition_1_0= ruleExpressionRule )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:951:1: (lv_condition_1_0= ruleExpressionRule )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:952:3: lv_condition_1_0= ruleExpressionRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEventDerivationAccess().getConditionExpressionRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionRule_in_ruleEventDerivation1893);
            lv_condition_1_0=ruleExpressionRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEventDerivationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_1_0, 
            	        		"ExpressionRule", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:974:2: ( ':' ( (lv_value_3_0= ruleExpressionRule ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:974:4: ':' ( (lv_value_3_0= ruleExpressionRule ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleEventDerivation1904); 

                            createLeafNode(grammarAccess.getEventDerivationAccess().getColonKeyword_2_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:978:1: ( (lv_value_3_0= ruleExpressionRule ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:979:1: (lv_value_3_0= ruleExpressionRule )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:979:1: (lv_value_3_0= ruleExpressionRule )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:980:3: lv_value_3_0= ruleExpressionRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEventDerivationAccess().getValueExpressionRuleParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpressionRule_in_ruleEventDerivation1925);
                    lv_value_3_0=ruleExpressionRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEventDerivationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_3_0, 
                    	        		"ExpressionRule", 
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
    // $ANTLR end ruleEventDerivation


    // $ANTLR start entryRuleVariableDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1012:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1013:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1014:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1965);
            iv_ruleVariableDefinition=ruleVariableDefinition();
            _fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition1975); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariableDefinition


    // $ANTLR start ruleVariableDefinition
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1021:1: ruleVariableDefinition returns [EObject current=null] : ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_initialValue_8_0= ruleLiteral ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_readonly_2_0=null;
        Token lv_external_3_0=null;
        Token lv_name_4_0=null;
        Enumerator lv_type_6_0 = null;

        AntlrDatatypeRuleToken lv_initialValue_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1026:6: ( ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_initialValue_8_0= ruleLiteral ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1027:1: ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_initialValue_8_0= ruleLiteral ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1027:1: ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_initialValue_8_0= ruleLiteral ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1027:3: 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_initialValue_8_0= ruleLiteral ) ) )?
            {
            match(input,21,FOLLOW_21_in_ruleVariableDefinition2010); 

                    createLeafNode(grammarAccess.getVariableDefinitionAccess().getVarKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1031:1: ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1033:1: ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1033:1: ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1034:2: ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1());
            	
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1037:2: ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1038:3: ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1038:3: ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( LA14_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 1) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1040:4: ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1040:4: ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1041:5: {...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1041:115: ( ( (lv_readonly_2_0= 'readonly' ) ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1042:6: ( (lv_readonly_2_0= 'readonly' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1045:6: ( (lv_readonly_2_0= 'readonly' ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1046:1: (lv_readonly_2_0= 'readonly' )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1046:1: (lv_readonly_2_0= 'readonly' )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1047:3: lv_readonly_2_0= 'readonly'
            	    {
            	    lv_readonly_2_0=(Token)input.LT(1);
            	    match(input,22,FOLLOW_22_in_ruleVariableDefinition2070); 

            	            createLeafNode(grammarAccess.getVariableDefinitionAccess().getReadonlyReadonlyKeyword_1_0_0(), "readonly"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getVariableDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "readonly", true, "readonly", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1073:4: ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1073:4: ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1074:5: {...}? => ( ( (lv_external_3_0= 'external' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleVariableDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1074:115: ( ( (lv_external_3_0= 'external' ) ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1075:6: ( (lv_external_3_0= 'external' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1078:6: ( (lv_external_3_0= 'external' ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1079:1: (lv_external_3_0= 'external' )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1079:1: (lv_external_3_0= 'external' )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1080:3: lv_external_3_0= 'external'
            	    {
            	    lv_external_3_0=(Token)input.LT(1);
            	    match(input,23,FOLLOW_23_in_ruleVariableDefinition2151); 

            	            createLeafNode(grammarAccess.getVariableDefinitionAccess().getExternalExternalKeyword_1_1_0(), "external"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getVariableDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "external", true, "external", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getVariableDefinitionAccess().getUnorderedGroup_1());
            	

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1113:2: ( (lv_name_4_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1114:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1114:1: (lv_name_4_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1115:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDefinition2220); 

            			createLeafNode(grammarAccess.getVariableDefinitionAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleVariableDefinition2235); 

                    createLeafNode(grammarAccess.getVariableDefinitionAccess().getColonKeyword_3(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1141:1: ( (lv_type_6_0= ruleType ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1142:1: (lv_type_6_0= ruleType )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1142:1: (lv_type_6_0= ruleType )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1143:3: lv_type_6_0= ruleType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeTypeEnumRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleVariableDefinition2256);
            lv_type_6_0=ruleType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_6_0, 
            	        		"Type", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1165:2: ( '=' ( (lv_initialValue_8_0= ruleLiteral ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1165:4: '=' ( (lv_initialValue_8_0= ruleLiteral ) )
                    {
                    match(input,20,FOLLOW_20_in_ruleVariableDefinition2267); 

                            createLeafNode(grammarAccess.getVariableDefinitionAccess().getEqualsSignKeyword_5_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1169:1: ( (lv_initialValue_8_0= ruleLiteral ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1170:1: (lv_initialValue_8_0= ruleLiteral )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1170:1: (lv_initialValue_8_0= ruleLiteral )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1171:3: lv_initialValue_8_0= ruleLiteral
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueLiteralParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleVariableDefinition2288);
                    lv_initialValue_8_0=ruleLiteral();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"initialValue",
                    	        		lv_initialValue_8_0, 
                    	        		"Literal", 
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
    // $ANTLR end ruleVariableDefinition


    // $ANTLR start entryRuleClock
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1201:1: entryRuleClock returns [EObject current=null] : iv_ruleClock= ruleClock EOF ;
    public final EObject entryRuleClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClock = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1202:2: (iv_ruleClock= ruleClock EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1203:2: iv_ruleClock= ruleClock EOF
            {
             currentNode = createCompositeNode(grammarAccess.getClockRule(), currentNode); 
            pushFollow(FOLLOW_ruleClock_in_entryRuleClock2326);
            iv_ruleClock=ruleClock();
            _fsp--;

             current =iv_ruleClock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClock2336); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleClock


    // $ANTLR start ruleClock
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1210:1: ruleClock returns [EObject current=null] : ( 'clock' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleClock() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1215:6: ( ( 'clock' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1216:1: ( 'clock' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1216:1: ( 'clock' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1216:3: 'clock' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,24,FOLLOW_24_in_ruleClock2371); 

                    createLeafNode(grammarAccess.getClockAccess().getClockKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1220:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1221:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1221:1: (lv_name_1_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1222:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClock2388); 

            			createLeafNode(grammarAccess.getClockAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getClockRule().getType().getClassifier());
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
    // $ANTLR end ruleClock


    // $ANTLR start entryRuleOperation
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1252:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1253:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1254:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation2429);
            iv_ruleOperation=ruleOperation();
            _fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation2439); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOperation


    // $ANTLR start ruleOperation
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1261:1: ruleOperation returns [EObject current=null] : ( 'operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )* )? ')' ( ':' ( (lv_type_8_0= ruleType ) ) )? ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_paramTypes_3_0 = null;

        Enumerator lv_paramTypes_5_0 = null;

        Enumerator lv_type_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1266:6: ( ( 'operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )* )? ')' ( ':' ( (lv_type_8_0= ruleType ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1267:1: ( 'operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )* )? ')' ( ':' ( (lv_type_8_0= ruleType ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1267:1: ( 'operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )* )? ')' ( ':' ( (lv_type_8_0= ruleType ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1267:3: 'operation' ( (lv_name_1_0= RULE_ID ) ) '(' ( ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )* )? ')' ( ':' ( (lv_type_8_0= ruleType ) ) )?
            {
            match(input,25,FOLLOW_25_in_ruleOperation2474); 

                    createLeafNode(grammarAccess.getOperationAccess().getOperationKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1271:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1272:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1272:1: (lv_name_1_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1273:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperation2491); 

            			createLeafNode(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
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

            match(input,26,FOLLOW_26_in_ruleOperation2506); 

                    createLeafNode(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1299:1: ( ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=60 && LA17_0<=64)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1299:2: ( (lv_paramTypes_3_0= ruleType ) ) ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )*
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1299:2: ( (lv_paramTypes_3_0= ruleType ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1300:1: (lv_paramTypes_3_0= ruleType )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1300:1: (lv_paramTypes_3_0= ruleType )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1301:3: lv_paramTypes_3_0= ruleType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getParamTypesTypeEnumRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleOperation2528);
                    lv_paramTypes_3_0=ruleType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"paramTypes",
                    	        		lv_paramTypes_3_0, 
                    	        		"Type", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1323:2: ( ',' ( (lv_paramTypes_5_0= ruleType ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==27) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1323:4: ',' ( (lv_paramTypes_5_0= ruleType ) )
                    	    {
                    	    match(input,27,FOLLOW_27_in_ruleOperation2539); 

                    	            createLeafNode(grammarAccess.getOperationAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1327:1: ( (lv_paramTypes_5_0= ruleType ) )
                    	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1328:1: (lv_paramTypes_5_0= ruleType )
                    	    {
                    	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1328:1: (lv_paramTypes_5_0= ruleType )
                    	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1329:3: lv_paramTypes_5_0= ruleType
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getParamTypesTypeEnumRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleType_in_ruleOperation2560);
                    	    lv_paramTypes_5_0=ruleType();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"paramTypes",
                    	    	        		lv_paramTypes_5_0, 
                    	    	        		"Type", 
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


                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_ruleOperation2574); 

                    createLeafNode(grammarAccess.getOperationAccess().getRightParenthesisKeyword_4(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1355:1: ( ':' ( (lv_type_8_0= ruleType ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1355:3: ':' ( (lv_type_8_0= ruleType ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleOperation2585); 

                            createLeafNode(grammarAccess.getOperationAccess().getColonKeyword_5_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1359:1: ( (lv_type_8_0= ruleType ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1360:1: (lv_type_8_0= ruleType )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1360:1: (lv_type_8_0= ruleType )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1361:3: lv_type_8_0= ruleType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getTypeTypeEnumRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleOperation2606);
                    lv_type_8_0=ruleType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_8_0, 
                    	        		"Type", 
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
    // $ANTLR end ruleOperation


    // $ANTLR start entryRuleEntrypoint
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1391:1: entryRuleEntrypoint returns [EObject current=null] : iv_ruleEntrypoint= ruleEntrypoint EOF ;
    public final EObject entryRuleEntrypoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntrypoint = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1392:2: (iv_ruleEntrypoint= ruleEntrypoint EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1393:2: iv_ruleEntrypoint= ruleEntrypoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntrypointRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2644);
            iv_ruleEntrypoint=ruleEntrypoint();
            _fsp--;

             current =iv_ruleEntrypoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntrypoint2654); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntrypoint


    // $ANTLR start ruleEntrypoint
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1400:1: ruleEntrypoint returns [EObject current=null] : ( 'entrypoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEntrypoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1405:6: ( ( 'entrypoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1406:1: ( 'entrypoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1406:1: ( 'entrypoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1406:3: 'entrypoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,29,FOLLOW_29_in_ruleEntrypoint2689); 

                    createLeafNode(grammarAccess.getEntrypointAccess().getEntrypointKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1410:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1411:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1411:1: (lv_name_1_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1412:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntrypoint2706); 

            			createLeafNode(grammarAccess.getEntrypointAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntrypointRule().getType().getClassifier());
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
    // $ANTLR end ruleEntrypoint


    // $ANTLR start entryRuleExitpoint
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1442:1: entryRuleExitpoint returns [EObject current=null] : iv_ruleExitpoint= ruleExitpoint EOF ;
    public final EObject entryRuleExitpoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitpoint = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1443:2: (iv_ruleExitpoint= ruleExitpoint EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1444:2: iv_ruleExitpoint= ruleExitpoint EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitpointRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitpoint_in_entryRuleExitpoint2747);
            iv_ruleExitpoint=ruleExitpoint();
            _fsp--;

             current =iv_ruleExitpoint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitpoint2757); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExitpoint


    // $ANTLR start ruleExitpoint
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1451:1: ruleExitpoint returns [EObject current=null] : ( 'exitpoint' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExitpoint() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1456:6: ( ( 'exitpoint' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1457:1: ( 'exitpoint' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1457:1: ( 'exitpoint' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1457:3: 'exitpoint' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,30,FOLLOW_30_in_ruleExitpoint2792); 

                    createLeafNode(grammarAccess.getExitpointAccess().getExitpointKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1461:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1462:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1462:1: (lv_name_1_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1463:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitpoint2809); 

            			createLeafNode(grammarAccess.getExitpointAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExitpointRule().getType().getClassifier());
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
    // $ANTLR end ruleExitpoint


    // $ANTLR start entryRuleLocalReaction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1495:1: entryRuleLocalReaction returns [EObject current=null] : iv_ruleLocalReaction= ruleLocalReaction EOF ;
    public final EObject entryRuleLocalReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalReaction = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1496:2: (iv_ruleLocalReaction= ruleLocalReaction EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1497:2: iv_ruleLocalReaction= ruleLocalReaction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLocalReactionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction2852);
            iv_ruleLocalReaction=ruleLocalReaction();
            _fsp--;

             current =iv_ruleLocalReaction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalReaction2862); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLocalReaction


    // $ANTLR start ruleLocalReaction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1504:1: ruleLocalReaction returns [EObject current=null] : ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleLocalReaction() throws RecognitionException {
        EObject current = null;

        EObject lv_trigger_0_0 = null;

        EObject lv_action_2_0 = null;

        EObject lv_properties_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1509:6: ( ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1510:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1510:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1510:2: ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1510:2: ( (lv_trigger_0_0= ruleReactionTrigger ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1511:1: (lv_trigger_0_0= ruleReactionTrigger )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1511:1: (lv_trigger_0_0= ruleReactionTrigger )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1512:3: lv_trigger_0_0= ruleReactionTrigger
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLocalReactionAccess().getTriggerReactionTriggerParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleReactionTrigger_in_ruleLocalReaction2908);
            lv_trigger_0_0=ruleReactionTrigger();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLocalReactionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"trigger",
            	        		lv_trigger_0_0, 
            	        		"ReactionTrigger", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1534:2: ( '/' ( (lv_action_2_0= ruleAction ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1534:4: '/' ( (lv_action_2_0= ruleAction ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleLocalReaction2919); 

                            createLeafNode(grammarAccess.getLocalReactionAccess().getSolidusKeyword_1_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1538:1: ( (lv_action_2_0= ruleAction ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1539:1: (lv_action_2_0= ruleAction )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1539:1: (lv_action_2_0= ruleAction )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1540:3: lv_action_2_0= ruleAction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLocalReactionAccess().getActionActionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAction_in_ruleLocalReaction2940);
                    lv_action_2_0=ruleAction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLocalReactionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_2_0, 
                    	        		"Action", 
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1562:4: ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1562:6: '#' ( (lv_properties_4_0= ruleReactionProperties ) )
                    {
                    match(input,32,FOLLOW_32_in_ruleLocalReaction2953); 

                            createLeafNode(grammarAccess.getLocalReactionAccess().getNumberSignKeyword_2_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1566:1: ( (lv_properties_4_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1567:1: (lv_properties_4_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1567:1: (lv_properties_4_0= ruleReactionProperties )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1568:3: lv_properties_4_0= ruleReactionProperties
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLocalReactionAccess().getPropertiesReactionPropertiesParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleLocalReaction2974);
                    lv_properties_4_0=ruleReactionProperties();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getLocalReactionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"properties",
                    	        		lv_properties_4_0, 
                    	        		"ReactionProperties", 
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
    // $ANTLR end ruleLocalReaction


    // $ANTLR start entryRuleTransitionReaction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1598:1: entryRuleTransitionReaction returns [EObject current=null] : iv_ruleTransitionReaction= ruleTransitionReaction EOF ;
    public final EObject entryRuleTransitionReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionReaction = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1599:2: (iv_ruleTransitionReaction= ruleTransitionReaction EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1600:2: iv_ruleTransitionReaction= ruleTransitionReaction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionReactionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3012);
            iv_ruleTransitionReaction=ruleTransitionReaction();
            _fsp--;

             current =iv_ruleTransitionReaction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionReaction3022); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransitionReaction


    // $ANTLR start ruleTransitionReaction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1607:1: ruleTransitionReaction returns [EObject current=null] : ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? ( '/' ( (lv_action_3_0= ruleAction ) ) )? ( '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleTransitionReaction() throws RecognitionException {
        EObject current = null;

        EObject lv_trigger_1_0 = null;

        EObject lv_action_3_0 = null;

        EObject lv_properties_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1612:6: ( ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? ( '/' ( (lv_action_3_0= ruleAction ) ) )? ( '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1613:1: ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? ( '/' ( (lv_action_3_0= ruleAction ) ) )? ( '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1613:1: ( () ( (lv_trigger_1_0= ruleReactionTrigger ) )? ( '/' ( (lv_action_3_0= ruleAction ) ) )? ( '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1613:2: () ( (lv_trigger_1_0= ruleReactionTrigger ) )? ( '/' ( (lv_action_3_0= ruleAction ) ) )? ( '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1613:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1614:5: 
            {
             
                    temp=factory.create(grammarAccess.getTransitionReactionAccess().getTransitionReactionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTransitionReactionAccess().getTransitionReactionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1624:2: ( (lv_trigger_1_0= ruleReactionTrigger ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||(LA21_0>=36 && LA21_0<=40)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1625:1: (lv_trigger_1_0= ruleReactionTrigger )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1625:1: (lv_trigger_1_0= ruleReactionTrigger )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1626:3: lv_trigger_1_0= ruleReactionTrigger
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionReactionAccess().getTriggerReactionTriggerParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleReactionTrigger_in_ruleTransitionReaction3077);
                    lv_trigger_1_0=ruleReactionTrigger();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionReactionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"trigger",
                    	        		lv_trigger_1_0, 
                    	        		"ReactionTrigger", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1648:3: ( '/' ( (lv_action_3_0= ruleAction ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1648:5: '/' ( (lv_action_3_0= ruleAction ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleTransitionReaction3089); 

                            createLeafNode(grammarAccess.getTransitionReactionAccess().getSolidusKeyword_2_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1652:1: ( (lv_action_3_0= ruleAction ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1653:1: (lv_action_3_0= ruleAction )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1653:1: (lv_action_3_0= ruleAction )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1654:3: lv_action_3_0= ruleAction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionReactionAccess().getActionActionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAction_in_ruleTransitionReaction3110);
                    lv_action_3_0=ruleAction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionReactionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"action",
                    	        		lv_action_3_0, 
                    	        		"Action", 
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1676:4: ( '#' ( (lv_properties_5_0= ruleReactionProperties ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1676:6: '#' ( (lv_properties_5_0= ruleReactionProperties ) )
                    {
                    match(input,32,FOLLOW_32_in_ruleTransitionReaction3123); 

                            createLeafNode(grammarAccess.getTransitionReactionAccess().getNumberSignKeyword_3_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1680:1: ( (lv_properties_5_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1681:1: (lv_properties_5_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1681:1: (lv_properties_5_0= ruleReactionProperties )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1682:3: lv_properties_5_0= ruleReactionProperties
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionReactionAccess().getPropertiesReactionPropertiesParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleTransitionReaction3144);
                    lv_properties_5_0=ruleReactionProperties();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionReactionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"properties",
                    	        		lv_properties_5_0, 
                    	        		"ReactionProperties", 
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
    // $ANTLR end ruleTransitionReaction


    // $ANTLR start entryRuleReactionTrigger
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1712:1: entryRuleReactionTrigger returns [EObject current=null] : iv_ruleReactionTrigger= ruleReactionTrigger EOF ;
    public final EObject entryRuleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionTrigger = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1713:2: (iv_ruleReactionTrigger= ruleReactionTrigger EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1714:2: iv_ruleReactionTrigger= ruleReactionTrigger EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionTriggerRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3182);
            iv_ruleReactionTrigger=ruleReactionTrigger();
            _fsp--;

             current =iv_ruleReactionTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionTrigger3192); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReactionTrigger


    // $ANTLR start ruleReactionTrigger
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1721:1: ruleReactionTrigger returns [EObject current=null] : ( ( ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? ) ;
    public final EObject ruleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;

        EObject lv_guardExpression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1726:6: ( ( ( ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:1: ( ( ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:1: ( ( ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:2: ( ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:2: ( ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:3: ( (lv_triggers_0_0= ruleEventSpec ) ) ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:3: ( (lv_triggers_0_0= ruleEventSpec ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1728:1: (lv_triggers_0_0= ruleEventSpec )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1728:1: (lv_triggers_0_0= ruleEventSpec )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1729:3: lv_triggers_0_0= ruleEventSpec
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_0_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3239);
            lv_triggers_0_0=ruleEventSpec();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReactionTriggerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"triggers",
            	        		lv_triggers_0_0, 
            	        		"EventSpec", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1751:2: ( ',' ( (lv_triggers_2_0= ruleEventSpec ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==27) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1751:4: ',' ( (lv_triggers_2_0= ruleEventSpec ) )
            	    {
            	    match(input,27,FOLLOW_27_in_ruleReactionTrigger3250); 

            	            createLeafNode(grammarAccess.getReactionTriggerAccess().getCommaKeyword_0_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1755:1: ( (lv_triggers_2_0= ruleEventSpec ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1756:1: (lv_triggers_2_0= ruleEventSpec )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1756:1: (lv_triggers_2_0= ruleEventSpec )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1757:3: lv_triggers_2_0= ruleEventSpec
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getReactionTriggerAccess().getTriggersEventSpecParserRuleCall_0_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEventSpec_in_ruleReactionTrigger3271);
            	    lv_triggers_2_0=ruleEventSpec();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getReactionTriggerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"triggers",
            	    	        		lv_triggers_2_0, 
            	    	        		"EventSpec", 
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


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1779:5: ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1779:7: '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleReactionTrigger3285); 

                            createLeafNode(grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1783:1: ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1784:1: (lv_guardExpression_4_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1784:1: (lv_guardExpression_4_0= ruleLogicalOrExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1785:3: lv_guardExpression_4_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionLogicalOrExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleReactionTrigger3306);
                    lv_guardExpression_4_0=ruleLogicalOrExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReactionTriggerRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"guardExpression",
                    	        		lv_guardExpression_4_0, 
                    	        		"LogicalOrExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,34,FOLLOW_34_in_ruleReactionTrigger3316); 

                            createLeafNode(grammarAccess.getReactionTriggerAccess().getRightSquareBracketKeyword_1_2(), null); 
                        

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
    // $ANTLR end ruleReactionTrigger


    // $ANTLR start entryRuleAction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1819:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1820:2: (iv_ruleAction= ruleAction EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1821:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3354);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3364); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1828:1: ruleAction returns [EObject current=null] : ( (lv_action_0_0= ruleExpressionRule ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject lv_action_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1833:6: ( ( (lv_action_0_0= ruleExpressionRule ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1834:1: ( (lv_action_0_0= ruleExpressionRule ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1834:1: ( (lv_action_0_0= ruleExpressionRule ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1835:1: (lv_action_0_0= ruleExpressionRule )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1835:1: (lv_action_0_0= ruleExpressionRule )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1836:3: lv_action_0_0= ruleExpressionRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getActionExpressionRuleParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionRule_in_ruleAction3409);
            lv_action_0_0=ruleExpressionRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getActionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"action",
            	        		lv_action_0_0, 
            	        		"ExpressionRule", 
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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleReactionProperties
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1866:1: entryRuleReactionProperties returns [EObject current=null] : iv_ruleReactionProperties= ruleReactionProperties EOF ;
    public final EObject entryRuleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperties = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1867:2: (iv_ruleReactionProperties= ruleReactionProperties EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1868:2: iv_ruleReactionProperties= ruleReactionProperties EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionPropertiesRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3444);
            iv_ruleReactionProperties=ruleReactionProperties();
            _fsp--;

             current =iv_ruleReactionProperties; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperties3454); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReactionProperties


    // $ANTLR start ruleReactionProperties
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1875:1: ruleReactionProperties returns [EObject current=null] : ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) ;
    public final EObject ruleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject lv_properties_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1880:6: ( ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1881:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1881:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1881:2: () ( (lv_properties_1_0= ruleReactionProperty ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1881:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1882:5: 
            {
             
                    temp=factory.create(grammarAccess.getReactionPropertiesAccess().getReactionPropertiesAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getReactionPropertiesAccess().getReactionPropertiesAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1892:2: ( (lv_properties_1_0= ruleReactionProperty ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    int LA26_2 = input.LA(2);

                    if ( (LA26_2==35) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==RULE_INT||LA26_0==35) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1893:1: (lv_properties_1_0= ruleReactionProperty )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1893:1: (lv_properties_1_0= ruleReactionProperty )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1894:3: lv_properties_1_0= ruleReactionProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getReactionPropertiesAccess().getPropertiesReactionPropertyParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleReactionProperty_in_ruleReactionProperties3509);
            	    lv_properties_1_0=ruleReactionProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getReactionPropertiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"properties",
            	    	        		lv_properties_1_0, 
            	    	        		"ReactionProperty", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end ruleReactionProperties


    // $ANTLR start entryRuleReactionProperty
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1924:1: entryRuleReactionProperty returns [EObject current=null] : iv_ruleReactionProperty= ruleReactionProperty EOF ;
    public final EObject entryRuleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperty = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1925:2: (iv_ruleReactionProperty= ruleReactionProperty EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1926:2: iv_ruleReactionProperty= ruleReactionProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3546);
            iv_ruleReactionProperty=ruleReactionProperty();
            _fsp--;

             current =iv_ruleReactionProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperty3556); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReactionProperty


    // $ANTLR start ruleReactionProperty
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1933:1: ruleReactionProperty returns [EObject current=null] : (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec ) ;
    public final EObject ruleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject this_ReactionPriority_0 = null;

        EObject this_EntryPointSpec_1 = null;

        EObject this_ExitPointSpec_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1938:6: ( (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1939:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1939:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )
            int alt27=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt27=1;
                }
                break;
            case 35:
                {
                alt27=2;
                }
                break;
            case RULE_ID:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1939:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1940:5: this_ReactionPriority_0= ruleReactionPriority
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReactionPropertyAccess().getReactionPriorityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReactionPriority_in_ruleReactionProperty3603);
                    this_ReactionPriority_0=ruleReactionPriority();
                    _fsp--;

                     
                            current = this_ReactionPriority_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1950:5: this_EntryPointSpec_1= ruleEntryPointSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReactionPropertyAccess().getEntryPointSpecParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3630);
                    this_EntryPointSpec_1=ruleEntryPointSpec();
                    _fsp--;

                     
                            current = this_EntryPointSpec_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1960:5: this_ExitPointSpec_2= ruleExitPointSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReactionPropertyAccess().getExitPointSpecParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3657);
                    this_ExitPointSpec_2=ruleExitPointSpec();
                    _fsp--;

                     
                            current = this_ExitPointSpec_2; 
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
    // $ANTLR end ruleReactionProperty


    // $ANTLR start entryRuleReactionPriority
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1976:1: entryRuleReactionPriority returns [EObject current=null] : iv_ruleReactionPriority= ruleReactionPriority EOF ;
    public final EObject entryRuleReactionPriority() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionPriority = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1977:2: (iv_ruleReactionPriority= ruleReactionPriority EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1978:2: iv_ruleReactionPriority= ruleReactionPriority EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionPriorityRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionPriority_in_entryRuleReactionPriority3692);
            iv_ruleReactionPriority=ruleReactionPriority();
            _fsp--;

             current =iv_ruleReactionPriority; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionPriority3702); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReactionPriority


    // $ANTLR start ruleReactionPriority
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1985:1: ruleReactionPriority returns [EObject current=null] : ( (lv_priority_0_0= RULE_INT ) ) ;
    public final EObject ruleReactionPriority() throws RecognitionException {
        EObject current = null;

        Token lv_priority_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1990:6: ( ( (lv_priority_0_0= RULE_INT ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1991:1: ( (lv_priority_0_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1991:1: ( (lv_priority_0_0= RULE_INT ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1992:1: (lv_priority_0_0= RULE_INT )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1992:1: (lv_priority_0_0= RULE_INT )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1993:3: lv_priority_0_0= RULE_INT
            {
            lv_priority_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleReactionPriority3743); 

            			createLeafNode(grammarAccess.getReactionPriorityAccess().getPriorityINTTerminalRuleCall_0(), "priority"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReactionPriorityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"priority",
            	        		lv_priority_0_0, 
            	        		"INT", 
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
    // $ANTLR end ruleReactionPriority


    // $ANTLR start entryRuleEntryPointSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2023:1: entryRuleEntryPointSpec returns [EObject current=null] : iv_ruleEntryPointSpec= ruleEntryPointSpec EOF ;
    public final EObject entryRuleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPointSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2024:2: (iv_ruleEntryPointSpec= ruleEntryPointSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2025:2: iv_ruleEntryPointSpec= ruleEntryPointSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryPointSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3783);
            iv_ruleEntryPointSpec=ruleEntryPointSpec();
            _fsp--;

             current =iv_ruleEntryPointSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPointSpec3793); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntryPointSpec


    // $ANTLR start ruleEntryPointSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2032:1: ruleEntryPointSpec returns [EObject current=null] : ( '>' ( ( RULE_ID ) ) ) ;
    public final EObject ruleEntryPointSpec() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2037:6: ( ( '>' ( ( RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2038:1: ( '>' ( ( RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2038:1: ( '>' ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2038:3: '>' ( ( RULE_ID ) )
            {
            match(input,35,FOLLOW_35_in_ruleEntryPointSpec3828); 

                    createLeafNode(grammarAccess.getEntryPointSpecAccess().getGreaterThanSignKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2042:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2043:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2043:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2044:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEntryPointSpecRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPointSpec3846); 

            		createLeafNode(grammarAccess.getEntryPointSpecAccess().getEntrypointEntrypointCrossReference_1_0(), "entrypoint"); 
            	

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
    // $ANTLR end ruleEntryPointSpec


    // $ANTLR start entryRuleExitPointSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2064:1: entryRuleExitPointSpec returns [EObject current=null] : iv_ruleExitPointSpec= ruleExitPointSpec EOF ;
    public final EObject entryRuleExitPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPointSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2065:2: (iv_ruleExitPointSpec= ruleExitPointSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2066:2: iv_ruleExitPointSpec= ruleExitPointSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitPointSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec3882);
            iv_ruleExitPointSpec=ruleExitPointSpec();
            _fsp--;

             current =iv_ruleExitPointSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPointSpec3892); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExitPointSpec


    // $ANTLR start ruleExitPointSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2073:1: ruleExitPointSpec returns [EObject current=null] : ( ( ( RULE_ID ) ) '>' ) ;
    public final EObject ruleExitPointSpec() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2078:6: ( ( ( ( RULE_ID ) ) '>' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2079:1: ( ( ( RULE_ID ) ) '>' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2079:1: ( ( ( RULE_ID ) ) '>' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2079:2: ( ( RULE_ID ) ) '>'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2079:2: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2080:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2080:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2081:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getExitPointSpecRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPointSpec3935); 

            		createLeafNode(grammarAccess.getExitPointSpecAccess().getExitpointExitpointCrossReference_0_0(), "exitpoint"); 
            	

            }


            }

            match(input,35,FOLLOW_35_in_ruleExitPointSpec3945); 

                    createLeafNode(grammarAccess.getExitPointSpecAccess().getGreaterThanSignKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExitPointSpec


    // $ANTLR start entryRuleEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2105:1: entryRuleEventSpec returns [EObject current=null] : iv_ruleEventSpec= ruleEventSpec EOF ;
    public final EObject entryRuleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2106:2: (iv_ruleEventSpec= ruleEventSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2107:2: iv_ruleEventSpec= ruleEventSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventSpec_in_entryRuleEventSpec3981);
            iv_ruleEventSpec=ruleEventSpec();
            _fsp--;

             current =iv_ruleEventSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventSpec3991); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEventSpec


    // $ANTLR start ruleEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2114:1: ruleEventSpec returns [EObject current=null] : (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) ;
    public final EObject ruleEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_RegularEventSpec_0 = null;

        EObject this_TimeEventSpec_1 = null;

        EObject this_BuiltinEventSpec_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2119:6: ( (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2120:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2120:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )
            int alt28=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt28=1;
                }
                break;
            case 36:
                {
                alt28=2;
                }
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2120:1: (this_RegularEventSpec_0= ruleRegularEventSpec | this_TimeEventSpec_1= ruleTimeEventSpec | this_BuiltinEventSpec_2= ruleBuiltinEventSpec )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2121:5: this_RegularEventSpec_0= ruleRegularEventSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventSpecAccess().getRegularEventSpecParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4038);
                    this_RegularEventSpec_0=ruleRegularEventSpec();
                    _fsp--;

                     
                            current = this_RegularEventSpec_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2131:5: this_TimeEventSpec_1= ruleTimeEventSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventSpecAccess().getTimeEventSpecParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4065);
                    this_TimeEventSpec_1=ruleTimeEventSpec();
                    _fsp--;

                     
                            current = this_TimeEventSpec_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2141:5: this_BuiltinEventSpec_2= ruleBuiltinEventSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventSpecAccess().getBuiltinEventSpecParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4092);
                    this_BuiltinEventSpec_2=ruleBuiltinEventSpec();
                    _fsp--;

                     
                            current = this_BuiltinEventSpec_2; 
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
    // $ANTLR end ruleEventSpec


    // $ANTLR start entryRuleRegularEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2157:1: entryRuleRegularEventSpec returns [EObject current=null] : iv_ruleRegularEventSpec= ruleRegularEventSpec EOF ;
    public final EObject entryRuleRegularEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEventSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2158:2: (iv_ruleRegularEventSpec= ruleRegularEventSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2159:2: iv_ruleRegularEventSpec= ruleRegularEventSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRegularEventSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4127);
            iv_ruleRegularEventSpec=ruleRegularEventSpec();
            _fsp--;

             current =iv_ruleRegularEventSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRegularEventSpec4137); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRegularEventSpec


    // $ANTLR start ruleRegularEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2166:1: ruleRegularEventSpec returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRegularEventSpec() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2171:6: ( ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2172:1: ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2172:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2173:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2173:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2174:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRegularEventSpecRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRegularEventSpec4179); 

            		createLeafNode(grammarAccess.getRegularEventSpecAccess().getEventEventCrossReference_0(), "event"); 
            	

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
    // $ANTLR end ruleRegularEventSpec


    // $ANTLR start entryRuleTimeEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2194:1: entryRuleTimeEventSpec returns [EObject current=null] : iv_ruleTimeEventSpec= ruleTimeEventSpec EOF ;
    public final EObject entryRuleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEventSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2195:2: (iv_ruleTimeEventSpec= ruleTimeEventSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2196:2: iv_ruleTimeEventSpec= ruleTimeEventSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeEventSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec4214);
            iv_ruleTimeEventSpec=ruleTimeEventSpec();
            _fsp--;

             current =iv_ruleTimeEventSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventSpec4224); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTimeEventSpec


    // $ANTLR start ruleTimeEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2203:1: ruleTimeEventSpec returns [EObject current=null] : ( 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? ) ;
    public final EObject ruleTimeEventSpec() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Enumerator lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2208:6: ( ( 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2209:1: ( 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2209:1: ( 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2209:3: 'after' ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleTimeUnit ) )?
            {
            match(input,36,FOLLOW_36_in_ruleTimeEventSpec4259); 

                    createLeafNode(grammarAccess.getTimeEventSpecAccess().getAfterKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2213:1: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2214:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2214:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2215:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimeEventSpec4276); 

            			createLeafNode(grammarAccess.getTimeEventSpecAccess().getValueINTTerminalRuleCall_1_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTimeEventSpecRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2237:2: ( (lv_unit_2_0= ruleTimeUnit ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=57 && LA29_0<=59)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2238:1: (lv_unit_2_0= ruleTimeUnit )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2238:1: (lv_unit_2_0= ruleTimeUnit )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2239:3: lv_unit_2_0= ruleTimeUnit
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTimeEventSpecAccess().getUnitTimeUnitEnumRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec4302);
                    lv_unit_2_0=ruleTimeUnit();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTimeEventSpecRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_2_0, 
                    	        		"TimeUnit", 
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
    // $ANTLR end ruleTimeEventSpec


    // $ANTLR start entryRuleBuiltinEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2269:1: entryRuleBuiltinEventSpec returns [EObject current=null] : iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF ;
    public final EObject entryRuleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuiltinEventSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2270:2: (iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2271:2: iv_ruleBuiltinEventSpec= ruleBuiltinEventSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBuiltinEventSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec4339);
            iv_ruleBuiltinEventSpec=ruleBuiltinEventSpec();
            _fsp--;

             current =iv_ruleBuiltinEventSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltinEventSpec4349); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBuiltinEventSpec


    // $ANTLR start ruleBuiltinEventSpec
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2278:1: ruleBuiltinEventSpec returns [EObject current=null] : (this_EnterEvent_0= ruleEnterEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent ) ;
    public final EObject ruleBuiltinEventSpec() throws RecognitionException {
        EObject current = null;

        EObject this_EnterEvent_0 = null;

        EObject this_ExitEvent_1 = null;

        EObject this_OnCycleEvent_2 = null;

        EObject this_AlwaysEvent_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2283:6: ( (this_EnterEvent_0= ruleEnterEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2284:1: (this_EnterEvent_0= ruleEnterEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2284:1: (this_EnterEvent_0= ruleEnterEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt30=1;
                }
                break;
            case 38:
                {
                alt30=2;
                }
                break;
            case 39:
                {
                alt30=3;
                }
                break;
            case 40:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2284:1: (this_EnterEvent_0= ruleEnterEvent | this_ExitEvent_1= ruleExitEvent | this_OnCycleEvent_2= ruleOnCycleEvent | this_AlwaysEvent_3= ruleAlwaysEvent )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2285:5: this_EnterEvent_0= ruleEnterEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getEnterEventParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnterEvent_in_ruleBuiltinEventSpec4396);
                    this_EnterEvent_0=ruleEnterEvent();
                    _fsp--;

                     
                            current = this_EnterEvent_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2295:5: this_ExitEvent_1= ruleExitEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getExitEventParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec4423);
                    this_ExitEvent_1=ruleExitEvent();
                    _fsp--;

                     
                            current = this_ExitEvent_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2305:5: this_OnCycleEvent_2= ruleOnCycleEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getOnCycleEventParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOnCycleEvent_in_ruleBuiltinEventSpec4450);
                    this_OnCycleEvent_2=ruleOnCycleEvent();
                    _fsp--;

                     
                            current = this_OnCycleEvent_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2315:5: this_AlwaysEvent_3= ruleAlwaysEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBuiltinEventSpecAccess().getAlwaysEventParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec4477);
                    this_AlwaysEvent_3=ruleAlwaysEvent();
                    _fsp--;

                     
                            current = this_AlwaysEvent_3; 
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
    // $ANTLR end ruleBuiltinEventSpec


    // $ANTLR start entryRuleEnterEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2331:1: entryRuleEnterEvent returns [EObject current=null] : iv_ruleEnterEvent= ruleEnterEvent EOF ;
    public final EObject entryRuleEnterEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnterEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2332:2: (iv_ruleEnterEvent= ruleEnterEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2333:2: iv_ruleEnterEvent= ruleEnterEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnterEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnterEvent_in_entryRuleEnterEvent4512);
            iv_ruleEnterEvent=ruleEnterEvent();
            _fsp--;

             current =iv_ruleEnterEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnterEvent4522); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEnterEvent


    // $ANTLR start ruleEnterEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2340:1: ruleEnterEvent returns [EObject current=null] : ( () 'enter' ) ;
    public final EObject ruleEnterEvent() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2345:6: ( ( () 'enter' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:1: ( () 'enter' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:1: ( () 'enter' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:2: () 'enter'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2347:5: 
            {
             
                    temp=factory.create(grammarAccess.getEnterEventAccess().getEnterEventAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getEnterEventAccess().getEnterEventAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,37,FOLLOW_37_in_ruleEnterEvent4566); 

                    createLeafNode(grammarAccess.getEnterEventAccess().getEnterKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEnterEvent


    // $ANTLR start entryRuleExitEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2369:1: entryRuleExitEvent returns [EObject current=null] : iv_ruleExitEvent= ruleExitEvent EOF ;
    public final EObject entryRuleExitEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2370:2: (iv_ruleExitEvent= ruleExitEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2371:2: iv_ruleExitEvent= ruleExitEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitEvent_in_entryRuleExitEvent4602);
            iv_ruleExitEvent=ruleExitEvent();
            _fsp--;

             current =iv_ruleExitEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitEvent4612); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExitEvent


    // $ANTLR start ruleExitEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2378:1: ruleExitEvent returns [EObject current=null] : ( () 'exit' ) ;
    public final EObject ruleExitEvent() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2383:6: ( ( () 'exit' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2384:1: ( () 'exit' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2384:1: ( () 'exit' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2384:2: () 'exit'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2384:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2385:5: 
            {
             
                    temp=factory.create(grammarAccess.getExitEventAccess().getExitEventAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getExitEventAccess().getExitEventAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,38,FOLLOW_38_in_ruleExitEvent4656); 

                    createLeafNode(grammarAccess.getExitEventAccess().getExitKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExitEvent


    // $ANTLR start entryRuleOnCycleEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2407:1: entryRuleOnCycleEvent returns [EObject current=null] : iv_ruleOnCycleEvent= ruleOnCycleEvent EOF ;
    public final EObject entryRuleOnCycleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnCycleEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2408:2: (iv_ruleOnCycleEvent= ruleOnCycleEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2409:2: iv_ruleOnCycleEvent= ruleOnCycleEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOnCycleEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleOnCycleEvent_in_entryRuleOnCycleEvent4692);
            iv_ruleOnCycleEvent=ruleOnCycleEvent();
            _fsp--;

             current =iv_ruleOnCycleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOnCycleEvent4702); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOnCycleEvent


    // $ANTLR start ruleOnCycleEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2416:1: ruleOnCycleEvent returns [EObject current=null] : ( () 'oncycle' ) ;
    public final EObject ruleOnCycleEvent() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2421:6: ( ( () 'oncycle' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2422:1: ( () 'oncycle' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2422:1: ( () 'oncycle' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2422:2: () 'oncycle'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2422:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2423:5: 
            {
             
                    temp=factory.create(grammarAccess.getOnCycleEventAccess().getOnCycleEventAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getOnCycleEventAccess().getOnCycleEventAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,39,FOLLOW_39_in_ruleOnCycleEvent4746); 

                    createLeafNode(grammarAccess.getOnCycleEventAccess().getOncycleKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOnCycleEvent


    // $ANTLR start entryRuleAlwaysEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2445:1: entryRuleAlwaysEvent returns [EObject current=null] : iv_ruleAlwaysEvent= ruleAlwaysEvent EOF ;
    public final EObject entryRuleAlwaysEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlwaysEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2446:2: (iv_ruleAlwaysEvent= ruleAlwaysEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2447:2: iv_ruleAlwaysEvent= ruleAlwaysEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlwaysEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent4782);
            iv_ruleAlwaysEvent=ruleAlwaysEvent();
            _fsp--;

             current =iv_ruleAlwaysEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlwaysEvent4792); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAlwaysEvent


    // $ANTLR start ruleAlwaysEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2454:1: ruleAlwaysEvent returns [EObject current=null] : ( () 'always' ) ;
    public final EObject ruleAlwaysEvent() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2459:6: ( ( () 'always' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2460:1: ( () 'always' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2460:1: ( () 'always' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2460:2: () 'always'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2460:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2461:5: 
            {
             
                    temp=factory.create(grammarAccess.getAlwaysEventAccess().getAlwaysEventAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getAlwaysEventAccess().getAlwaysEventAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,40,FOLLOW_40_in_ruleAlwaysEvent4836); 

                    createLeafNode(grammarAccess.getAlwaysEventAccess().getAlwaysKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAlwaysEvent


    // $ANTLR start entryRuleExpressionRule
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2483:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2484:2: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2485:2: iv_ruleExpressionRule= ruleExpressionRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionRule_in_entryRuleExpressionRule4872);
            iv_ruleExpressionRule=ruleExpressionRule();
            _fsp--;

             current =iv_ruleExpressionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionRule4882); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpressionRule


    // $ANTLR start ruleExpressionRule
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2492:1: ruleExpressionRule returns [EObject current=null] : ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) ) ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_1 = null;

        EObject lv_expression_0_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2497:6: ( ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2498:1: ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2498:1: ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2499:1: ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2499:1: ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2500:1: (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2500:1: (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_FLOAT)||LA31_0==26||LA31_0==44||(LA31_0>=47 && LA31_0<=48)||LA31_0==51) ) {
                alt31=1;
            }
            else if ( (LA31_0==41) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2500:1: (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2501:3: lv_expression_0_1= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getExpressionRuleAccess().getExpressionLogicalOrExpressionParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleExpressionRule4929);
                    lv_expression_0_1=ruleLogicalOrExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getExpressionRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_0_1, 
                    	        		"LogicalOrExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2522:8: lv_expression_0_2= ruleRaiseEventExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getExpressionRuleAccess().getExpressionRaiseEventExpressionParserRuleCall_0_1(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRaiseEventExpression_in_ruleExpressionRule4948);
                    lv_expression_0_2=ruleRaiseEventExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getExpressionRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_0_2, 
                    	        		"RaiseEventExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

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
    // $ANTLR end ruleExpressionRule


    // $ANTLR start entryRuleRaiseEventExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2554:1: entryRuleRaiseEventExpression returns [EObject current=null] : iv_ruleRaiseEventExpression= ruleRaiseEventExpression EOF ;
    public final EObject entryRuleRaiseEventExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRaiseEventExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2555:2: (iv_ruleRaiseEventExpression= ruleRaiseEventExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2556:2: iv_ruleRaiseEventExpression= ruleRaiseEventExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRaiseEventExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRaiseEventExpression_in_entryRuleRaiseEventExpression4986);
            iv_ruleRaiseEventExpression=ruleRaiseEventExpression();
            _fsp--;

             current =iv_ruleRaiseEventExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRaiseEventExpression4996); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRaiseEventExpression


    // $ANTLR start ruleRaiseEventExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2563:1: ruleRaiseEventExpression returns [EObject current=null] : ( 'raise' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRaiseEventExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2568:6: ( ( 'raise' ( ( RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2569:1: ( 'raise' ( ( RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2569:1: ( 'raise' ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2569:3: 'raise' ( ( RULE_ID ) )
            {
            match(input,41,FOLLOW_41_in_ruleRaiseEventExpression5031); 

                    createLeafNode(grammarAccess.getRaiseEventExpressionAccess().getRaiseKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2573:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2574:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2574:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2575:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRaiseEventExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRaiseEventExpression5049); 

            		createLeafNode(grammarAccess.getRaiseEventExpressionAccess().getEventEventCrossReference_1_0(), "event"); 
            	

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
    // $ANTLR end ruleRaiseEventExpression


    // $ANTLR start entryRuleLogicalOrExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2595:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2596:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2597:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5085);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression5095); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2604:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2609:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2610:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2610:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2611:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5142);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2619:1: ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==42) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2619:2: () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2619:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2620:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,42,FOLLOW_42_in_ruleLogicalOrExpression5161); 

            	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2639:1: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2640:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2640:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2641:3: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5182);
            	    lv_rightOperand_3_0=ruleLogicalAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"rightOperand",
            	    	        		lv_rightOperand_3_0, 
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
            	    break loop32;
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
    // $ANTLR end ruleLogicalOrExpression


    // $ANTLR start entryRuleLogicalAndExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2671:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2672:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2673:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5220);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression5230); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2680:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2685:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2686:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2686:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2687:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5277);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2695:1: ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==43) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2695:2: () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2695:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2696:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,43,FOLLOW_43_in_ruleLogicalAndExpression5296); 

            	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2715:1: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2716:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2716:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2717:3: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5317);
            	    lv_rightOperand_3_0=ruleLogicalNotExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"rightOperand",
            	    	        		lv_rightOperand_3_0, 
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
            	    break loop33;
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
    // $ANTLR end ruleLogicalAndExpression


    // $ANTLR start entryRuleLogicalNotExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2747:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2748:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2749:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression5355);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression5365); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2756:1: ruleLogicalNotExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2761:6: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2762:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2762:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_FLOAT)||LA34_0==26||(LA34_0>=47 && LA34_0<=48)||LA34_0==51) ) {
                alt34=1;
            }
            else if ( (LA34_0==44) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2762:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2763:5: this_LogicalRelationExpression_0= ruleLogicalRelationExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalRelationExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5412);
                    this_LogicalRelationExpression_0=ruleLogicalRelationExpression();
                    _fsp--;

                     
                            current = this_LogicalRelationExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2772:6: ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2772:6: ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2772:7: () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2772:7: ()
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2773:5: 
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

                    match(input,44,FOLLOW_44_in_ruleLogicalNotExpression5437); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2787:1: ( (lv_operand_3_0= ruleLogicalRelationExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2788:1: (lv_operand_3_0= ruleLogicalRelationExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2788:1: (lv_operand_3_0= ruleLogicalRelationExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2789:3: lv_operand_3_0= ruleLogicalRelationExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandLogicalRelationExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5458);
                    lv_operand_3_0=ruleLogicalRelationExpression();
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
                    	        		"LogicalRelationExpression", 
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


    // $ANTLR start entryRuleLogicalRelationExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2819:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2820:2: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2821:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalRelationExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression5495);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();
            _fsp--;

             current =iv_ruleLogicalRelationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression5505); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLogicalRelationExpression


    // $ANTLR start ruleLogicalRelationExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2828:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2833:6: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2834:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2834:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2835:5: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression5552);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();
            _fsp--;

             
                    current = this_NumericalAddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2843:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==35||(LA35_0>=52 && LA35_0<=56)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2843:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2843:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2844:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2859:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2860:1: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2860:1: (lv_operator_2_0= ruleRelationalOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2861:3: lv_operator_2_0= ruleRelationalOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression5582);
            	    lv_operator_2_0=ruleRelationalOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalRelationExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_2_0, 
            	    	        		"RelationalOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2883:2: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2884:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2884:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2885:3: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression5603);
            	    lv_rightOperand_3_0=ruleNumericalAddSubtractExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLogicalRelationExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"rightOperand",
            	    	        		lv_rightOperand_3_0, 
            	    	        		"NumericalAddSubtractExpression", 
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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalRelationExpression


    // $ANTLR start entryRuleNumericalAddSubtractExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2915:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2916:2: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2917:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression5641);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();
            _fsp--;

             current =iv_ruleNumericalAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression5651); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNumericalAddSubtractExpression


    // $ANTLR start ruleNumericalAddSubtractExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2924:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2929:6: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2930:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2930:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2931:5: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression5698);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();
            _fsp--;

             
                    current = this_NumericalMultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2939:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=47 && LA36_0<=48)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2939:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2939:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2940:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2955:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2956:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2956:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2957:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression5728);
            	    lv_operator_2_0=ruleAdditiveOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNumericalAddSubtractExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_2_0, 
            	    	        		"AdditiveOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2979:2: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2980:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2980:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2981:3: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression5749);
            	    lv_rightOperand_3_0=ruleNumericalMultiplyDivideExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNumericalAddSubtractExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"rightOperand",
            	    	        		lv_rightOperand_3_0, 
            	    	        		"NumericalMultiplyDivideExpression", 
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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNumericalAddSubtractExpression


    // $ANTLR start entryRuleNumericalMultiplyDivideExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3011:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3012:2: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3013:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression5787);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleNumericalMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression5797); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNumericalMultiplyDivideExpression


    // $ANTLR start ruleNumericalMultiplyDivideExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3020:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3025:6: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3026:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3026:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3027:5: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5844);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();
            _fsp--;

             
                    current = this_NumericalUnaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3035:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==31||(LA37_0>=49 && LA37_0<=50)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3035:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3035:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3036:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3051:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3052:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3052:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3053:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression5874);
            	    lv_operator_2_0=ruleMultiplicativeOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNumericalMultiplyDivideExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_2_0, 
            	    	        		"MultiplicativeOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3075:2: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3076:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3076:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3077:3: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5895);
            	    lv_rightOperand_3_0=ruleNumericalUnaryExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNumericalMultiplyDivideExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"rightOperand",
            	    	        		lv_rightOperand_3_0, 
            	    	        		"NumericalUnaryExpression", 
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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNumericalMultiplyDivideExpression


    // $ANTLR start entryRuleNumericalUnaryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3107:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3108:2: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3109:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression5933);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();
            _fsp--;

             current =iv_ruleNumericalUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression5943); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNumericalUnaryExpression


    // $ANTLR start ruleNumericalUnaryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3116:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3121:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3122:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3122:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_FLOAT)||LA38_0==26) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=47 && LA38_0<=48)||LA38_0==51) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3122:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3123:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression5990);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3132:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3132:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3132:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3132:7: ()
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3133:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3143:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3144:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3144:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3145:3: lv_operator_2_0= ruleUnaryOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression6026);
                    lv_operator_2_0=ruleUnaryOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNumericalUnaryExpressionRule().getType().getClassifier());
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

                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3167:2: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3168:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3168:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3169:3: lv_operand_3_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression6047);
                    lv_operand_3_0=rulePrimaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNumericalUnaryExpressionRule().getType().getClassifier());
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
    // $ANTLR end ruleNumericalUnaryExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3199:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3200:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3201:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6084);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression6094); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3208:1: rulePrimaryExpression returns [EObject current=null] : (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ValueExpression_0 = null;

        EObject this_LogicalOrExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3213:6: ( (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3214:1: (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3214:1: (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_FLOAT)) ) {
                alt39=1;
            }
            else if ( (LA39_0==26) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3214:1: (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3215:5: this_ValueExpression_0= ruleValueExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleValueExpression_in_rulePrimaryExpression6141);
                    this_ValueExpression_0=ruleValueExpression();
                    _fsp--;

                     
                            current = this_ValueExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3224:6: ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3224:6: ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3224:8: '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')'
                    {
                    match(input,26,FOLLOW_26_in_rulePrimaryExpression6157); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLogicalOrExpressionParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_rulePrimaryExpression6179);
                    this_LogicalOrExpression_2=ruleLogicalOrExpression();
                    _fsp--;

                     
                            current = this_LogicalOrExpression_2; 
                            currentNode = currentNode.getParent();
                        
                    match(input,28,FOLLOW_28_in_rulePrimaryExpression6188); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2(), null); 
                        

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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleValueExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3249:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3250:2: (iv_ruleValueExpression= ruleValueExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3251:2: iv_ruleValueExpression= ruleValueExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueExpression_in_entryRuleValueExpression6225);
            iv_ruleValueExpression=ruleValueExpression();
            _fsp--;

             current =iv_ruleValueExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueExpression6235); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleValueExpression


    // $ANTLR start ruleValueExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3258:1: ruleValueExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression ) ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_VariableReferenceExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3263:6: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3264:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3264:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_INT && LA40_0<=RULE_FLOAT)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3264:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3265:5: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression6282);
                    this_PrimitiveValueExpression_0=rulePrimitiveValueExpression();
                    _fsp--;

                     
                            current = this_PrimitiveValueExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3275:5: this_VariableReferenceExpression_1= ruleVariableReferenceExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueExpressionAccess().getVariableReferenceExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableReferenceExpression_in_ruleValueExpression6309);
                    this_VariableReferenceExpression_1=ruleVariableReferenceExpression();
                    _fsp--;

                     
                            current = this_VariableReferenceExpression_1; 
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
    // $ANTLR end ruleValueExpression


    // $ANTLR start entryRulePrimitiveValueExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3291:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3292:2: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3293:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveValueExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression6344);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();
            _fsp--;

             current =iv_rulePrimitiveValueExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression6354); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePrimitiveValueExpression


    // $ANTLR start rulePrimitiveValueExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3300:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3305:6: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3306:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3306:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3306:2: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3306:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3307:5: 
            {
             
                    temp=factory.create(grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3317:2: ( (lv_value_1_0= ruleLiteral ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3318:1: (lv_value_1_0= ruleLiteral )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3318:1: (lv_value_1_0= ruleLiteral )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3319:3: lv_value_1_0= ruleLiteral
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression6409);
            lv_value_1_0=ruleLiteral();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPrimitiveValueExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"Literal", 
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
    // $ANTLR end rulePrimitiveValueExpression


    // $ANTLR start entryRuleVariableReferenceExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3349:1: entryRuleVariableReferenceExpression returns [EObject current=null] : iv_ruleVariableReferenceExpression= ruleVariableReferenceExpression EOF ;
    public final EObject entryRuleVariableReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReferenceExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3350:2: (iv_ruleVariableReferenceExpression= ruleVariableReferenceExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3351:2: iv_ruleVariableReferenceExpression= ruleVariableReferenceExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableReferenceExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableReferenceExpression_in_entryRuleVariableReferenceExpression6445);
            iv_ruleVariableReferenceExpression=ruleVariableReferenceExpression();
            _fsp--;

             current =iv_ruleVariableReferenceExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableReferenceExpression6455); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariableReferenceExpression


    // $ANTLR start ruleVariableReferenceExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3358:1: ruleVariableReferenceExpression returns [EObject current=null] : ( () ( ( RULE_ID ) ) ) ;
    public final EObject ruleVariableReferenceExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3363:6: ( ( () ( ( RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3364:1: ( () ( ( RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3364:1: ( () ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3364:2: () ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3364:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3365:5: 
            {
             
                    temp=factory.create(grammarAccess.getVariableReferenceExpressionAccess().getPropertyReferenceExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getVariableReferenceExpressionAccess().getPropertyReferenceExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3375:2: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3376:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3376:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3377:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableReferenceExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableReferenceExpression6507); 

            		createLeafNode(grammarAccess.getVariableReferenceExpressionAccess().getValueVariableCrossReference_1_0(), "value"); 
            	

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
    // $ANTLR end ruleVariableReferenceExpression


    // $ANTLR start entryRuleLiteral
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3397:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3398:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3399:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral6544);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral6555); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3406:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_FLOAT_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3411:6: ( (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3412:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3412:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )
            int alt41=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt41=1;
                }
                break;
            case RULE_INT:
                {
                alt41=2;
                }
                break;
            case RULE_STRING:
                {
                alt41=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt41=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3412:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3412:6: this_BOOL_0= RULE_BOOL
                    {
                    this_BOOL_0=(Token)input.LT(1);
                    match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleLiteral6595); 

                    		current.merge(this_BOOL_0);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getBOOLTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3420:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral6621); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3428:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteral6647); 

                    		current.merge(this_STRING_2);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3436:10: this_FLOAT_3= RULE_FLOAT
                    {
                    this_FLOAT_3=(Token)input.LT(1);
                    match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleLiteral6673); 

                    		current.merge(this_FLOAT_3);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getFLOATTerminalRuleCall_3(), null); 
                        

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


    // $ANTLR start ruleDirection
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3451:1: ruleDirection returns [Enumerator current=null] : ( ( 'in' ) | ( 'out' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3455:6: ( ( ( 'in' ) | ( 'out' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3456:1: ( ( 'in' ) | ( 'out' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3456:1: ( ( 'in' ) | ( 'out' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==45) ) {
                alt42=1;
            }
            else if ( (LA42_0==46) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3456:1: ( ( 'in' ) | ( 'out' ) )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3456:2: ( 'in' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3456:2: ( 'in' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3456:4: 'in'
                    {
                    match(input,45,FOLLOW_45_in_ruleDirection6730); 

                            current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3462:6: ( 'out' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3462:6: ( 'out' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3462:8: 'out'
                    {
                    match(input,46,FOLLOW_46_in_ruleDirection6745); 

                            current = grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleDirection


    // $ANTLR start ruleAdditiveOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3472:1: ruleAdditiveOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3476:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3477:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3477:1: ( ( '+' ) | ( '-' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==47) ) {
                alt43=1;
            }
            else if ( (LA43_0==48) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3477:1: ( ( '+' ) | ( '-' ) )", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3477:2: ( '+' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3477:2: ( '+' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3477:4: '+'
                    {
                    match(input,47,FOLLOW_47_in_ruleAdditiveOperator6788); 

                            current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3483:6: ( '-' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3483:6: ( '-' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3483:8: '-'
                    {
                    match(input,48,FOLLOW_48_in_ruleAdditiveOperator6803); 

                            current = grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1(), null); 
                        

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3493:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3497:6: ( ( ( '*' ) | ( '/' ) | ( '%' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3498:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3498:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt44=1;
                }
                break;
            case 31:
                {
                alt44=2;
                }
                break;
            case 50:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3498:1: ( ( '*' ) | ( '/' ) | ( '%' ) )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3498:2: ( '*' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3498:2: ( '*' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3498:4: '*'
                    {
                    match(input,49,FOLLOW_49_in_ruleMultiplicativeOperator6846); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3504:6: ( '/' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3504:6: ( '/' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3504:8: '/'
                    {
                    match(input,31,FOLLOW_31_in_ruleMultiplicativeOperator6861); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3510:6: ( '%' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3510:6: ( '%' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3510:8: '%'
                    {
                    match(input,50,FOLLOW_50_in_ruleMultiplicativeOperator6876); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2(), null); 
                        

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


    // $ANTLR start ruleUnaryOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3520:1: ruleUnaryOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3524:6: ( ( ( '+' ) | ( '-' ) | ( '~' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3525:1: ( ( '+' ) | ( '-' ) | ( '~' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3525:1: ( ( '+' ) | ( '-' ) | ( '~' ) )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt45=1;
                }
                break;
            case 48:
                {
                alt45=2;
                }
                break;
            case 51:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3525:1: ( ( '+' ) | ( '-' ) | ( '~' ) )", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3525:2: ( '+' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3525:2: ( '+' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3525:4: '+'
                    {
                    match(input,47,FOLLOW_47_in_ruleUnaryOperator6919); 

                            current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3531:6: ( '-' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3531:6: ( '-' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3531:8: '-'
                    {
                    match(input,48,FOLLOW_48_in_ruleUnaryOperator6934); 

                            current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3537:6: ( '~' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3537:6: ( '~' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3537:8: '~'
                    {
                    match(input,51,FOLLOW_51_in_ruleUnaryOperator6949); 

                            current = grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2(), null); 
                        

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


    // $ANTLR start ruleRelationalOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3547:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3551:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3552:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3552:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )
            int alt46=6;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt46=1;
                }
                break;
            case 53:
                {
                alt46=2;
                }
                break;
            case 35:
                {
                alt46=3;
                }
                break;
            case 54:
                {
                alt46=4;
                }
                break;
            case 55:
                {
                alt46=5;
                }
                break;
            case 56:
                {
                alt46=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3552:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3552:2: ( '<' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3552:2: ( '<' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3552:4: '<'
                    {
                    match(input,52,FOLLOW_52_in_ruleRelationalOperator6992); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3558:6: ( '<=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3558:6: ( '<=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3558:8: '<='
                    {
                    match(input,53,FOLLOW_53_in_ruleRelationalOperator7007); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3564:6: ( '>' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3564:6: ( '>' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3564:8: '>'
                    {
                    match(input,35,FOLLOW_35_in_ruleRelationalOperator7022); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3570:6: ( '>=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3570:6: ( '>=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3570:8: '>='
                    {
                    match(input,54,FOLLOW_54_in_ruleRelationalOperator7037); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3576:6: ( '==' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3576:6: ( '==' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3576:8: '=='
                    {
                    match(input,55,FOLLOW_55_in_ruleRelationalOperator7052); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3582:6: ( '!=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3582:6: ( '!=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3582:8: '!='
                    {
                    match(input,56,FOLLOW_56_in_ruleRelationalOperator7067); 

                            current = grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5(), null); 
                        

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


    // $ANTLR start ruleTimeUnit
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3594:1: ruleTimeUnit returns [Enumerator current=null] : ( ( 's' ) | ( 'ms' ) | ( 'ns' ) ) ;
    public final Enumerator ruleTimeUnit() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3598:6: ( ( ( 's' ) | ( 'ms' ) | ( 'ns' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3599:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3599:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt47=1;
                }
                break;
            case 58:
                {
                alt47=2;
                }
                break;
            case 59:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3599:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3599:2: ( 's' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3599:2: ( 's' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3599:4: 's'
                    {
                    match(input,57,FOLLOW_57_in_ruleTimeUnit7112); 

                            current = grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3605:6: ( 'ms' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3605:6: ( 'ms' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3605:8: 'ms'
                    {
                    match(input,58,FOLLOW_58_in_ruleTimeUnit7127); 

                            current = grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3611:6: ( 'ns' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3611:6: ( 'ns' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3611:8: 'ns'
                    {
                    match(input,59,FOLLOW_59_in_ruleTimeUnit7142); 

                            current = grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getNanosecondEnumLiteralDeclaration_2(), null); 
                        

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
    // $ANTLR end ruleTimeUnit


    // $ANTLR start ruleType
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3621:1: ruleType returns [Enumerator current=null] : ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3625:6: ( ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3626:1: ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3626:1: ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt48=1;
                }
                break;
            case 61:
                {
                alt48=2;
                }
                break;
            case 62:
                {
                alt48=3;
                }
                break;
            case 63:
                {
                alt48=4;
                }
                break;
            case 64:
                {
                alt48=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3626:1: ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) )", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3626:2: ( 'void' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3626:2: ( 'void' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3626:4: 'void'
                    {
                    match(input,60,FOLLOW_60_in_ruleType7185); 

                            current = grammarAccess.getTypeAccess().getVoidEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getVoidEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3632:6: ( 'integer' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3632:6: ( 'integer' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3632:8: 'integer'
                    {
                    match(input,61,FOLLOW_61_in_ruleType7200); 

                            current = grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3638:6: ( 'real' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3638:6: ( 'real' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3638:8: 'real'
                    {
                    match(input,62,FOLLOW_62_in_ruleType7215); 

                            current = grammarAccess.getTypeAccess().getRealEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getRealEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3644:6: ( 'boolean' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3644:6: ( 'boolean' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3644:8: 'boolean'
                    {
                    match(input,63,FOLLOW_63_in_ruleType7230); 

                            current = grammarAccess.getTypeAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getBooleanEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3650:6: ( 'string' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3650:6: ( 'string' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3650:8: 'string'
                    {
                    match(input,64,FOLLOW_64_in_ruleType7245); 

                            current = grammarAccess.getTypeAccess().getStringEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getStringEnumLiteralDeclaration_4(), null); 
                        

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
    // $ANTLR end ruleType


 

    public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefRoot_in_ruleRoot130 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_ruleDefRoot_in_entryRuleDefRoot166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefRoot176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartRoot_in_ruleDefRoot223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateRoot_in_ruleDefRoot250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_ruleDefRoot277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartRoot_in_entryRuleStatechartRoot312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartRoot322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleStatechartRoot357 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleStatechartDefinition_in_ruleStatechartRoot378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateRoot_in_entryRuleStateRoot414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateRoot424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleStateRoot459 = new BitSet(new long[]{0x000061F063280012L});
    public static final BitSet FOLLOW_ruleStateDefinition_in_ruleStateRoot480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRoot526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTransitionRoot561 = new BitSet(new long[]{0x000001F180000012L});
    public static final BitSet FOLLOW_ruleTransitionStatement_in_ruleTransitionRoot582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartDefinition_in_entryRuleStatechartDefinition618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartDefinition628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_ruleStatechartDefinition683 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleStateDefinition_in_entryRuleStateDefinition720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateDefinition730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleScope_in_ruleStateDefinition776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionStatement_in_entryRuleTransitionStatement810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionStatement820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_ruleTransitionStatement866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleScope_in_entryRuleSimpleScope902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleScope912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleSimpleScope967 = new BitSet(new long[]{0x000061F063280012L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartScope1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalScope_in_ruleStatechartScope1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceScope1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceScope1177 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterfaceScope1194 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInterfaceScope1210 = new BitSet(new long[]{0x000061F063280012L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInterfaceScope1231 = new BitSet(new long[]{0x000061F063280012L});
    public static final BitSet FOLLOW_ruleInternalScope_in_entryRuleInternalScope1268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalScope1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleInternalScope1322 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInternalScope1332 = new BitSet(new long[]{0x000061F063280012L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInternalScope1353 = new BitSet(new long[]{0x000061F063280012L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition1390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleDefinition1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleDefinition1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClock_in_ruleDefinition1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleDefinition1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_ruleDefinition1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_ruleDefinition1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_ruleDefinition1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_ruleEventDefinition1702 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleEventDefinition1713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDefinition1730 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_17_in_ruleEventDefinition1746 = new BitSet(new long[]{0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleType_in_ruleEventDefinition1767 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_ruleEventDefinition1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDerivation1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleEventDerivation1872 = new BitSet(new long[]{0x00099200040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleEventDerivation1893 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleEventDerivation1904 = new BitSet(new long[]{0x00099200040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleEventDerivation1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVariableDefinition2010 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_22_in_ruleVariableDefinition2070 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_23_in_ruleVariableDefinition2151 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDefinition2220 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableDefinition2235 = new BitSet(new long[]{0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDefinition2256 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVariableDefinition2267 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleVariableDefinition2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClock_in_entryRuleClock2326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClock2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleClock2371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClock2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation2429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOperation2474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperation2491 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleOperation2506 = new BitSet(new long[]{0xF000000010000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2528 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleOperation2539 = new BitSet(new long[]{0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2560 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleOperation2574 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleOperation2585 = new BitSet(new long[]{0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntrypoint2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleEntrypoint2689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntrypoint2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_entryRuleExitpoint2747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitpoint2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleExitpoint2792 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitpoint2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalReaction_in_entryRuleLocalReaction2852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalReaction2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleLocalReaction2908 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleLocalReaction2919 = new BitSet(new long[]{0x00099200040001F0L});
    public static final BitSet FOLLOW_ruleAction_in_ruleLocalReaction2940 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleLocalReaction2953 = new BitSet(new long[]{0x0000000800000032L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleLocalReaction2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionReaction_in_entryRuleTransitionReaction3012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionReaction3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleTransitionReaction3077 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleTransitionReaction3089 = new BitSet(new long[]{0x00099200040001F0L});
    public static final BitSet FOLLOW_ruleAction_in_ruleTransitionReaction3110 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleTransitionReaction3123 = new BitSet(new long[]{0x0000000800000032L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleTransitionReaction3144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionTrigger3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3239 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_27_in_ruleReactionTrigger3250 = new BitSet(new long[]{0x000001F000000010L});
    public static final BitSet FOLLOW_ruleEventSpec_in_ruleReactionTrigger3271 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_33_in_ruleReactionTrigger3285 = new BitSet(new long[]{0x00099000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleReactionTrigger3306 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleReactionTrigger3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleAction3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperties3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_ruleReactionProperties3509 = new BitSet(new long[]{0x0000000800000032L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperty3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionPriority_in_ruleReactionProperty3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionPriority_in_entryRuleReactionPriority3692 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionPriority3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleReactionPriority3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPointSpec3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleEntryPointSpec3828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPointSpec3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec3882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPointSpec3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPointSpec3935 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleExitPointSpec3945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSpec_in_entryRuleEventSpec3981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventSpec3991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_ruleEventSpec4038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_ruleEventSpec4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_ruleEventSpec4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRegularEventSpec_in_entryRuleRegularEventSpec4127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRegularEventSpec4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRegularEventSpec4179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventSpec_in_entryRuleTimeEventSpec4214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventSpec4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTimeEventSpec4259 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimeEventSpec4276 = new BitSet(new long[]{0x0E00000000000002L});
    public static final BitSet FOLLOW_ruleTimeUnit_in_ruleTimeEventSpec4302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltinEventSpec_in_entryRuleBuiltinEventSpec4339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltinEventSpec4349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnterEvent_in_ruleBuiltinEventSpec4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_ruleBuiltinEventSpec4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnCycleEvent_in_ruleBuiltinEventSpec4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_ruleBuiltinEventSpec4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnterEvent_in_entryRuleEnterEvent4512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnterEvent4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleEnterEvent4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitEvent_in_entryRuleExitEvent4602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitEvent4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleExitEvent4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnCycleEvent_in_entryRuleOnCycleEvent4692 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOnCycleEvent4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOnCycleEvent4746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlwaysEvent_in_entryRuleAlwaysEvent4782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlwaysEvent4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAlwaysEvent4836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_entryRuleExpressionRule4872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionRule4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleExpressionRule4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRaiseEventExpression_in_ruleExpressionRule4948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRaiseEventExpression_in_entryRuleRaiseEventExpression4986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRaiseEventExpression4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRaiseEventExpression5031 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRaiseEventExpression5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5142 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleLogicalOrExpression5161 = new BitSet(new long[]{0x00099000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5182 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5277 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleLogicalAndExpression5296 = new BitSet(new long[]{0x00099000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression5317 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression5355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLogicalNotExpression5437 = new BitSet(new long[]{0x00098000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression5458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression5495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression5552 = new BitSet(new long[]{0x01F0000800000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression5582 = new BitSet(new long[]{0x00098000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression5603 = new BitSet(new long[]{0x01F0000800000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression5641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression5651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression5698 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression5728 = new BitSet(new long[]{0x00098000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression5749 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression5787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression5797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5844 = new BitSet(new long[]{0x0006000080000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression5874 = new BitSet(new long[]{0x00098000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5895 = new BitSet(new long[]{0x0006000080000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression5933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression5943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression5990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression6026 = new BitSet(new long[]{0x00000000040001F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression6047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_rulePrimaryExpression6141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePrimaryExpression6157 = new BitSet(new long[]{0x00099000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rulePrimaryExpression6179 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePrimaryExpression6188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_entryRuleValueExpression6225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueExpression6235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression6282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReferenceExpression_in_ruleValueExpression6309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression6344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression6354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReferenceExpression_in_entryRuleVariableReferenceExpression6445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableReferenceExpression6455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableReferenceExpression6507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral6544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral6555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleLiteral6595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral6621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral6647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleLiteral6673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleDirection6730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDirection6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleAdditiveOperator6788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAdditiveOperator6803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleMultiplicativeOperator6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeOperator6861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleMultiplicativeOperator6876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleUnaryOperator6919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleUnaryOperator6934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUnaryOperator6949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleRelationalOperator6992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleRelationalOperator7007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleRelationalOperator7022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleRelationalOperator7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleRelationalOperator7052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleRelationalOperator7067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleTimeUnit7112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleTimeUnit7127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleTimeUnit7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleType7185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleType7200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleType7215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleType7230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleType7245 = new BitSet(new long[]{0x0000000000000002L});

}
