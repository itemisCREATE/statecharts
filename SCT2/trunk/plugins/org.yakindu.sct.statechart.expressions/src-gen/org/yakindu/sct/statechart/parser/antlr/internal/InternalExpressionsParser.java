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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_BOOL", "RULE_STRING", "RULE_FLOAT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@@statechart@@'", "'@@state@@'", "'@@transition@@'", "'interface'", "':'", "'internal'", "'event'", "'='", "'var'", "'readonly'", "'external'", "'clock'", "'operation'", "'('", "','", "')'", "'entrypoint'", "'exitpoint'", "'/'", "'#'", "'['", "']'", "'>'", "'entry:'", "'exit:'", "'do:'", "'raise'", "'||'", "'&&'", "'!'", "'in'", "'out'", "'+'", "'-'", "'*'", "'%'", "'~'", "'<'", "'<='", "'>='", "'=='", "'!='", "'void'", "'integer'", "'real'", "'boolean'", "'string'"
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:429:1: ruleTransitionStatement returns [EObject current=null] : this_Reaction_0= ruleReaction ;
    public final EObject ruleTransitionStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Reaction_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:434:6: (this_Reaction_0= ruleReaction )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:436:5: this_Reaction_0= ruleReaction
            {
             
                    currentNode=createCompositeNode(grammarAccess.getTransitionStatementAccess().getReactionParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleReaction_in_ruleTransitionStatement866);
            this_Reaction_0=ruleReaction();
            _fsp--;

             
                    current = this_Reaction_0; 
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

                if ( (LA4_0==RULE_ID||LA4_0==19||LA4_0==21||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=29 && LA4_0<=30)||(LA4_0>=43 && LA4_0<=44)) ) {
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

                if ( (LA7_0==RULE_ID||LA7_0==19||LA7_0==21||(LA7_0>=24 && LA7_0<=25)||(LA7_0>=29 && LA7_0<=30)||(LA7_0>=43 && LA7_0<=44)) ) {
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

                if ( (LA8_0==RULE_ID||LA8_0==19||LA8_0==21||(LA8_0>=24 && LA8_0<=25)||(LA8_0>=29 && LA8_0<=30)||(LA8_0>=43 && LA8_0<=44)) ) {
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:719:1: ruleDefinition returns [EObject current=null] : (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_Reaction_4= ruleReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_EventDefinition_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_Clock_2 = null;

        EObject this_Operation_3 = null;

        EObject this_Reaction_4 = null;

        EObject this_Entrypoint_5 = null;

        EObject this_Exitpoint_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:724:6: ( (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_Reaction_4= ruleReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:725:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_Reaction_4= ruleReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:725:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_Reaction_4= ruleReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )
            int alt9=7;
            switch ( input.LA(1) ) {
            case 19:
            case 43:
            case 44:
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
                    new NoViableAltException("725:1: (this_EventDefinition_0= ruleEventDefinition | this_VariableDefinition_1= ruleVariableDefinition | this_Clock_2= ruleClock | this_Operation_3= ruleOperation | this_Reaction_4= ruleReaction | this_Entrypoint_5= ruleEntrypoint | this_Exitpoint_6= ruleExitpoint )", 9, 0, input);

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
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:766:5: this_Reaction_4= ruleReaction
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getReactionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReaction_in_ruleDefinition1555);
                    this_Reaction_4=ruleReaction();
                    _fsp--;

                     
                            current = this_Reaction_4; 
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

            if ( ((LA10_0>=43 && LA10_0<=44)) ) {
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1021:1: ruleVariableDefinition returns [EObject current=null] : ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_value_8_0= ruleLiteral ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_readonly_2_0=null;
        Token lv_external_3_0=null;
        Token lv_name_4_0=null;
        Enumerator lv_type_6_0 = null;

        AntlrDatatypeRuleToken lv_value_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1026:6: ( ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_value_8_0= ruleLiteral ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1027:1: ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_value_8_0= ruleLiteral ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1027:1: ( 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_value_8_0= ruleLiteral ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1027:3: 'var' ( ( ( ( ({...}? => ( ( (lv_readonly_2_0= 'readonly' ) ) ) ) | ({...}? => ( ( (lv_external_3_0= 'external' ) ) ) ) )* ) ) ) ( (lv_name_4_0= RULE_ID ) ) ':' ( (lv_type_6_0= ruleType ) ) ( '=' ( (lv_value_8_0= ruleLiteral ) ) )?
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1165:2: ( '=' ( (lv_value_8_0= ruleLiteral ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1165:4: '=' ( (lv_value_8_0= ruleLiteral ) )
                    {
                    match(input,20,FOLLOW_20_in_ruleVariableDefinition2267); 

                            createLeafNode(grammarAccess.getVariableDefinitionAccess().getEqualsSignKeyword_5_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1169:1: ( (lv_value_8_0= ruleLiteral ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1170:1: (lv_value_8_0= ruleLiteral )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1170:1: (lv_value_8_0= ruleLiteral )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1171:3: lv_value_8_0= ruleLiteral
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDefinitionAccess().getValueLiteralParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleVariableDefinition2288);
                    lv_value_8_0=ruleLiteral();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_8_0, 
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

            if ( ((LA17_0>=55 && LA17_0<=59)) ) {
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


    // $ANTLR start entryRuleReaction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1493:1: entryRuleReaction returns [EObject current=null] : iv_ruleReaction= ruleReaction EOF ;
    public final EObject entryRuleReaction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReaction = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1494:2: (iv_ruleReaction= ruleReaction EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1495:2: iv_ruleReaction= ruleReaction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionRule(), currentNode); 
            pushFollow(FOLLOW_ruleReaction_in_entryRuleReaction2850);
            iv_ruleReaction=ruleReaction();
            _fsp--;

             current =iv_ruleReaction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReaction2860); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReaction


    // $ANTLR start ruleReaction
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1502:1: ruleReaction returns [EObject current=null] : ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) ;
    public final EObject ruleReaction() throws RecognitionException {
        EObject current = null;

        EObject lv_trigger_0_0 = null;

        EObject lv_action_2_0 = null;

        EObject lv_properties_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1507:6: ( ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1508:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1508:1: ( ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1508:2: ( (lv_trigger_0_0= ruleReactionTrigger ) ) ( '/' ( (lv_action_2_0= ruleAction ) ) )? ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1508:2: ( (lv_trigger_0_0= ruleReactionTrigger ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1509:1: (lv_trigger_0_0= ruleReactionTrigger )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1509:1: (lv_trigger_0_0= ruleReactionTrigger )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1510:3: lv_trigger_0_0= ruleReactionTrigger
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getReactionAccess().getTriggerReactionTriggerParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleReactionTrigger_in_ruleReaction2906);
            lv_trigger_0_0=ruleReactionTrigger();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReactionRule().getType().getClassifier());
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1532:2: ( '/' ( (lv_action_2_0= ruleAction ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1532:4: '/' ( (lv_action_2_0= ruleAction ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleReaction2917); 

                            createLeafNode(grammarAccess.getReactionAccess().getSolidusKeyword_1_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1536:1: ( (lv_action_2_0= ruleAction ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1537:1: (lv_action_2_0= ruleAction )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1537:1: (lv_action_2_0= ruleAction )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1538:3: lv_action_2_0= ruleAction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReactionAccess().getActionActionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAction_in_ruleReaction2938);
                    lv_action_2_0=ruleAction();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReactionRule().getType().getClassifier());
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1560:4: ( '#' ( (lv_properties_4_0= ruleReactionProperties ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1560:6: '#' ( (lv_properties_4_0= ruleReactionProperties ) )
                    {
                    match(input,32,FOLLOW_32_in_ruleReaction2951); 

                            createLeafNode(grammarAccess.getReactionAccess().getNumberSignKeyword_2_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1564:1: ( (lv_properties_4_0= ruleReactionProperties ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1565:1: (lv_properties_4_0= ruleReactionProperties )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1565:1: (lv_properties_4_0= ruleReactionProperties )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1566:3: lv_properties_4_0= ruleReactionProperties
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReactionAccess().getPropertiesReactionPropertiesParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleReactionProperties_in_ruleReaction2972);
                    lv_properties_4_0=ruleReactionProperties();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReactionRule().getType().getClassifier());
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
    // $ANTLR end ruleReaction


    // $ANTLR start entryRuleReactionTrigger
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1596:1: entryRuleReactionTrigger returns [EObject current=null] : iv_ruleReactionTrigger= ruleReactionTrigger EOF ;
    public final EObject entryRuleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionTrigger = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1597:2: (iv_ruleReactionTrigger= ruleReactionTrigger EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1598:2: iv_ruleReactionTrigger= ruleReactionTrigger EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionTriggerRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3010);
            iv_ruleReactionTrigger=ruleReactionTrigger();
            _fsp--;

             current =iv_ruleReactionTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionTrigger3020); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1605:1: ruleReactionTrigger returns [EObject current=null] : ( ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? ) ;
    public final EObject ruleReactionTrigger() throws RecognitionException {
        EObject current = null;

        EObject lv_guardExpression_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1610:6: ( ( ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1611:1: ( ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1611:1: ( ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1611:2: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* ) ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1611:2: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1611:3: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1611:3: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1612:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1612:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1613:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReactionTriggerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReactionTrigger3064); 

            		createLeafNode(grammarAccess.getReactionTriggerAccess().getTriggersEventCrossReference_0_0_0(), "triggers"); 
            	

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1625:2: ( ',' ( ( RULE_ID ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==27) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1625:4: ',' ( ( RULE_ID ) )
            	    {
            	    match(input,27,FOLLOW_27_in_ruleReactionTrigger3075); 

            	            createLeafNode(grammarAccess.getReactionTriggerAccess().getCommaKeyword_0_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1629:1: ( ( RULE_ID ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1630:1: ( RULE_ID )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1630:1: ( RULE_ID )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1631:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getReactionTriggerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReactionTrigger3093); 

            	    		createLeafNode(grammarAccess.getReactionTriggerAccess().getTriggersEventCrossReference_0_1_1_0(), "triggers"); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1643:5: ( '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1643:7: '[' ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) ) ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleReactionTrigger3107); 

                            createLeafNode(grammarAccess.getReactionTriggerAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1647:1: ( (lv_guardExpression_4_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1648:1: (lv_guardExpression_4_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1648:1: (lv_guardExpression_4_0= ruleLogicalOrExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1649:3: lv_guardExpression_4_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getReactionTriggerAccess().getGuardExpressionLogicalOrExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleReactionTrigger3128);
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

                    match(input,34,FOLLOW_34_in_ruleReactionTrigger3138); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1683:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1684:2: (iv_ruleAction= ruleAction EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1685:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3176);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3186); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1692:1: ruleAction returns [EObject current=null] : ( (lv_action_0_0= ruleExpressionRule ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject lv_action_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1697:6: ( ( (lv_action_0_0= ruleExpressionRule ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1698:1: ( (lv_action_0_0= ruleExpressionRule ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1698:1: ( (lv_action_0_0= ruleExpressionRule ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1699:1: (lv_action_0_0= ruleExpressionRule )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1699:1: (lv_action_0_0= ruleExpressionRule )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1700:3: lv_action_0_0= ruleExpressionRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getActionAccess().getActionExpressionRuleParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionRule_in_ruleAction3231);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1730:1: entryRuleReactionProperties returns [EObject current=null] : iv_ruleReactionProperties= ruleReactionProperties EOF ;
    public final EObject entryRuleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperties = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1731:2: (iv_ruleReactionProperties= ruleReactionProperties EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1732:2: iv_ruleReactionProperties= ruleReactionProperties EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionPropertiesRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3266);
            iv_ruleReactionProperties=ruleReactionProperties();
            _fsp--;

             current =iv_ruleReactionProperties; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperties3276); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1739:1: ruleReactionProperties returns [EObject current=null] : ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) ;
    public final EObject ruleReactionProperties() throws RecognitionException {
        EObject current = null;

        EObject lv_properties_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1744:6: ( ( () ( (lv_properties_1_0= ruleReactionProperty ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1745:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1745:1: ( () ( (lv_properties_1_0= ruleReactionProperty ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1745:2: () ( (lv_properties_1_0= ruleReactionProperty ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1745:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1746:5: 
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1756:2: ( (lv_properties_1_0= ruleReactionProperty ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID) ) {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==35) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==RULE_INT||LA23_0==35) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1757:1: (lv_properties_1_0= ruleReactionProperty )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1757:1: (lv_properties_1_0= ruleReactionProperty )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1758:3: lv_properties_1_0= ruleReactionProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getReactionPropertiesAccess().getPropertiesReactionPropertyParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleReactionProperty_in_ruleReactionProperties3331);
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
            	    break loop23;
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1788:1: entryRuleReactionProperty returns [EObject current=null] : iv_ruleReactionProperty= ruleReactionProperty EOF ;
    public final EObject entryRuleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionProperty = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1789:2: (iv_ruleReactionProperty= ruleReactionProperty EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1790:2: iv_ruleReactionProperty= ruleReactionProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3368);
            iv_ruleReactionProperty=ruleReactionProperty();
            _fsp--;

             current =iv_ruleReactionProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionProperty3378); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1797:1: ruleReactionProperty returns [EObject current=null] : (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec ) ;
    public final EObject ruleReactionProperty() throws RecognitionException {
        EObject current = null;

        EObject this_ReactionPriority_0 = null;

        EObject this_EntryPointSpec_1 = null;

        EObject this_ExitPointSpec_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1802:6: ( (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1803:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1803:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )
            int alt24=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt24=1;
                }
                break;
            case 35:
                {
                alt24=2;
                }
                break;
            case RULE_ID:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1803:1: (this_ReactionPriority_0= ruleReactionPriority | this_EntryPointSpec_1= ruleEntryPointSpec | this_ExitPointSpec_2= ruleExitPointSpec )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1804:5: this_ReactionPriority_0= ruleReactionPriority
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReactionPropertyAccess().getReactionPriorityParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReactionPriority_in_ruleReactionProperty3425);
                    this_ReactionPriority_0=ruleReactionPriority();
                    _fsp--;

                     
                            current = this_ReactionPriority_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1814:5: this_EntryPointSpec_1= ruleEntryPointSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReactionPropertyAccess().getEntryPointSpecParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3452);
                    this_EntryPointSpec_1=ruleEntryPointSpec();
                    _fsp--;

                     
                            current = this_EntryPointSpec_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1824:5: this_ExitPointSpec_2= ruleExitPointSpec
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReactionPropertyAccess().getExitPointSpecParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3479);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1840:1: entryRuleReactionPriority returns [EObject current=null] : iv_ruleReactionPriority= ruleReactionPriority EOF ;
    public final EObject entryRuleReactionPriority() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReactionPriority = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1841:2: (iv_ruleReactionPriority= ruleReactionPriority EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1842:2: iv_ruleReactionPriority= ruleReactionPriority EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReactionPriorityRule(), currentNode); 
            pushFollow(FOLLOW_ruleReactionPriority_in_entryRuleReactionPriority3514);
            iv_ruleReactionPriority=ruleReactionPriority();
            _fsp--;

             current =iv_ruleReactionPriority; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReactionPriority3524); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1849:1: ruleReactionPriority returns [EObject current=null] : ( (lv_priority_0_0= RULE_INT ) ) ;
    public final EObject ruleReactionPriority() throws RecognitionException {
        EObject current = null;

        Token lv_priority_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1854:6: ( ( (lv_priority_0_0= RULE_INT ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1855:1: ( (lv_priority_0_0= RULE_INT ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1855:1: ( (lv_priority_0_0= RULE_INT ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1856:1: (lv_priority_0_0= RULE_INT )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1856:1: (lv_priority_0_0= RULE_INT )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1857:3: lv_priority_0_0= RULE_INT
            {
            lv_priority_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleReactionPriority3565); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1887:1: entryRuleEntryPointSpec returns [EObject current=null] : iv_ruleEntryPointSpec= ruleEntryPointSpec EOF ;
    public final EObject entryRuleEntryPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryPointSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1888:2: (iv_ruleEntryPointSpec= ruleEntryPointSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1889:2: iv_ruleEntryPointSpec= ruleEntryPointSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryPointSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3605);
            iv_ruleEntryPointSpec=ruleEntryPointSpec();
            _fsp--;

             current =iv_ruleEntryPointSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryPointSpec3615); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1896:1: ruleEntryPointSpec returns [EObject current=null] : ( '>' ( ( RULE_ID ) ) ) ;
    public final EObject ruleEntryPointSpec() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1901:6: ( ( '>' ( ( RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1902:1: ( '>' ( ( RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1902:1: ( '>' ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1902:3: '>' ( ( RULE_ID ) )
            {
            match(input,35,FOLLOW_35_in_ruleEntryPointSpec3650); 

                    createLeafNode(grammarAccess.getEntryPointSpecAccess().getGreaterThanSignKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1906:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1907:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1907:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1908:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEntryPointSpecRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryPointSpec3668); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1928:1: entryRuleExitPointSpec returns [EObject current=null] : iv_ruleExitPointSpec= ruleExitPointSpec EOF ;
    public final EObject entryRuleExitPointSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitPointSpec = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1929:2: (iv_ruleExitPointSpec= ruleExitPointSpec EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1930:2: iv_ruleExitPointSpec= ruleExitPointSpec EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitPointSpecRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec3704);
            iv_ruleExitPointSpec=ruleExitPointSpec();
            _fsp--;

             current =iv_ruleExitPointSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitPointSpec3714); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1937:1: ruleExitPointSpec returns [EObject current=null] : ( ( ( RULE_ID ) ) '>' ) ;
    public final EObject ruleExitPointSpec() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1942:6: ( ( ( ( RULE_ID ) ) '>' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1943:1: ( ( ( RULE_ID ) ) '>' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1943:1: ( ( ( RULE_ID ) ) '>' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1943:2: ( ( RULE_ID ) ) '>'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1943:2: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1944:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1944:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1945:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getExitPointSpecRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitPointSpec3757); 

            		createLeafNode(grammarAccess.getExitPointSpecAccess().getExitpointExitpointCrossReference_0_0(), "exitpoint"); 
            	

            }


            }

            match(input,35,FOLLOW_35_in_ruleExitPointSpec3767); 

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


    // $ANTLR start entryRuleEntryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1971:1: entryRuleEntryExpression returns [EObject current=null] : iv_ruleEntryExpression= ruleEntryExpression EOF ;
    public final EObject entryRuleEntryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1972:2: (iv_ruleEntryExpression= ruleEntryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1973:2: iv_ruleEntryExpression= ruleEntryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryExpression_in_entryRuleEntryExpression3805);
            iv_ruleEntryExpression=ruleEntryExpression();
            _fsp--;

             current =iv_ruleEntryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryExpression3815); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntryExpression


    // $ANTLR start ruleEntryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1980:1: ruleEntryExpression returns [EObject current=null] : ( 'entry:' ( (lv_expression_1_0= ruleExpressionRule ) ) ) ;
    public final EObject ruleEntryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1985:6: ( ( 'entry:' ( (lv_expression_1_0= ruleExpressionRule ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1986:1: ( 'entry:' ( (lv_expression_1_0= ruleExpressionRule ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1986:1: ( 'entry:' ( (lv_expression_1_0= ruleExpressionRule ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1986:3: 'entry:' ( (lv_expression_1_0= ruleExpressionRule ) )
            {
            match(input,36,FOLLOW_36_in_ruleEntryExpression3850); 

                    createLeafNode(grammarAccess.getEntryExpressionAccess().getEntryKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1990:1: ( (lv_expression_1_0= ruleExpressionRule ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1991:1: (lv_expression_1_0= ruleExpressionRule )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1991:1: (lv_expression_1_0= ruleExpressionRule )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1992:3: lv_expression_1_0= ruleExpressionRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntryExpressionAccess().getExpressionExpressionRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionRule_in_ruleEntryExpression3871);
            lv_expression_1_0=ruleExpressionRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntryExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_1_0, 
            	        		"ExpressionRule", 
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
    // $ANTLR end ruleEntryExpression


    // $ANTLR start entryRuleExitExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2022:1: entryRuleExitExpression returns [EObject current=null] : iv_ruleExitExpression= ruleExitExpression EOF ;
    public final EObject entryRuleExitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2023:2: (iv_ruleExitExpression= ruleExitExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2024:2: iv_ruleExitExpression= ruleExitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitExpression_in_entryRuleExitExpression3907);
            iv_ruleExitExpression=ruleExitExpression();
            _fsp--;

             current =iv_ruleExitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitExpression3917); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExitExpression


    // $ANTLR start ruleExitExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2031:1: ruleExitExpression returns [EObject current=null] : ( 'exit:' ( (lv_expression_1_0= ruleExpressionRule ) ) ) ;
    public final EObject ruleExitExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2036:6: ( ( 'exit:' ( (lv_expression_1_0= ruleExpressionRule ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2037:1: ( 'exit:' ( (lv_expression_1_0= ruleExpressionRule ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2037:1: ( 'exit:' ( (lv_expression_1_0= ruleExpressionRule ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2037:3: 'exit:' ( (lv_expression_1_0= ruleExpressionRule ) )
            {
            match(input,37,FOLLOW_37_in_ruleExitExpression3952); 

                    createLeafNode(grammarAccess.getExitExpressionAccess().getExitKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2041:1: ( (lv_expression_1_0= ruleExpressionRule ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2042:1: (lv_expression_1_0= ruleExpressionRule )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2042:1: (lv_expression_1_0= ruleExpressionRule )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2043:3: lv_expression_1_0= ruleExpressionRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExitExpressionAccess().getExpressionExpressionRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionRule_in_ruleExitExpression3973);
            lv_expression_1_0=ruleExpressionRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExitExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_1_0, 
            	        		"ExpressionRule", 
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
    // $ANTLR end ruleExitExpression


    // $ANTLR start entryRuleOnTickExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2073:1: entryRuleOnTickExpression returns [EObject current=null] : iv_ruleOnTickExpression= ruleOnTickExpression EOF ;
    public final EObject entryRuleOnTickExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnTickExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2074:2: (iv_ruleOnTickExpression= ruleOnTickExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2075:2: iv_ruleOnTickExpression= ruleOnTickExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOnTickExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOnTickExpression_in_entryRuleOnTickExpression4009);
            iv_ruleOnTickExpression=ruleOnTickExpression();
            _fsp--;

             current =iv_ruleOnTickExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOnTickExpression4019); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOnTickExpression


    // $ANTLR start ruleOnTickExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2082:1: ruleOnTickExpression returns [EObject current=null] : ( 'do:' ( (lv_expression_1_0= ruleExpressionRule ) ) ) ;
    public final EObject ruleOnTickExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2087:6: ( ( 'do:' ( (lv_expression_1_0= ruleExpressionRule ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2088:1: ( 'do:' ( (lv_expression_1_0= ruleExpressionRule ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2088:1: ( 'do:' ( (lv_expression_1_0= ruleExpressionRule ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2088:3: 'do:' ( (lv_expression_1_0= ruleExpressionRule ) )
            {
            match(input,38,FOLLOW_38_in_ruleOnTickExpression4054); 

                    createLeafNode(grammarAccess.getOnTickExpressionAccess().getDoKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2092:1: ( (lv_expression_1_0= ruleExpressionRule ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2093:1: (lv_expression_1_0= ruleExpressionRule )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2093:1: (lv_expression_1_0= ruleExpressionRule )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2094:3: lv_expression_1_0= ruleExpressionRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getOnTickExpressionAccess().getExpressionExpressionRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionRule_in_ruleOnTickExpression4075);
            lv_expression_1_0=ruleExpressionRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOnTickExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_1_0, 
            	        		"ExpressionRule", 
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
    // $ANTLR end ruleOnTickExpression


    // $ANTLR start entryRuleExpressionRule
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2124:1: entryRuleExpressionRule returns [EObject current=null] : iv_ruleExpressionRule= ruleExpressionRule EOF ;
    public final EObject entryRuleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionRule = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2125:2: (iv_ruleExpressionRule= ruleExpressionRule EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2126:2: iv_ruleExpressionRule= ruleExpressionRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionRule_in_entryRuleExpressionRule4111);
            iv_ruleExpressionRule=ruleExpressionRule();
            _fsp--;

             current =iv_ruleExpressionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionRule4121); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2133:1: ruleExpressionRule returns [EObject current=null] : ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) ) ;
    public final EObject ruleExpressionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_1 = null;

        EObject lv_expression_0_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2138:6: ( ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2139:1: ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2139:1: ( ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2140:1: ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2140:1: ( (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2141:1: (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2141:1: (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_FLOAT)||LA25_0==26||LA25_0==42||(LA25_0>=45 && LA25_0<=46)||LA25_0==49) ) {
                alt25=1;
            }
            else if ( (LA25_0==39) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2141:1: (lv_expression_0_1= ruleLogicalOrExpression | lv_expression_0_2= ruleRaiseEventExpression )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2142:3: lv_expression_0_1= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getExpressionRuleAccess().getExpressionLogicalOrExpressionParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleExpressionRule4168);
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
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2163:8: lv_expression_0_2= ruleRaiseEventExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getExpressionRuleAccess().getExpressionRaiseEventExpressionParserRuleCall_0_1(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRaiseEventExpression_in_ruleExpressionRule4187);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2195:1: entryRuleRaiseEventExpression returns [EObject current=null] : iv_ruleRaiseEventExpression= ruleRaiseEventExpression EOF ;
    public final EObject entryRuleRaiseEventExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRaiseEventExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2196:2: (iv_ruleRaiseEventExpression= ruleRaiseEventExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2197:2: iv_ruleRaiseEventExpression= ruleRaiseEventExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRaiseEventExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRaiseEventExpression_in_entryRuleRaiseEventExpression4225);
            iv_ruleRaiseEventExpression=ruleRaiseEventExpression();
            _fsp--;

             current =iv_ruleRaiseEventExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRaiseEventExpression4235); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2204:1: ruleRaiseEventExpression returns [EObject current=null] : ( 'raise' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRaiseEventExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2209:6: ( ( 'raise' ( ( RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2210:1: ( 'raise' ( ( RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2210:1: ( 'raise' ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2210:3: 'raise' ( ( RULE_ID ) )
            {
            match(input,39,FOLLOW_39_in_ruleRaiseEventExpression4270); 

                    createLeafNode(grammarAccess.getRaiseEventExpressionAccess().getRaiseKeyword_0(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2214:1: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2215:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2215:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2216:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRaiseEventExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRaiseEventExpression4288); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2236:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2237:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2238:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression4324);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression4334); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2245:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2250:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2251:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2251:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2252:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4381);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2260:1: ( () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2260:2: () '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2260:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2261:5: 
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

            	    match(input,40,FOLLOW_40_in_ruleLogicalOrExpression4400); 

            	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2280:1: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2281:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2281:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2282:3: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4421);
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
    // $ANTLR end ruleLogicalOrExpression


    // $ANTLR start entryRuleLogicalAndExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2312:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2313:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2314:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression4459);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression4469); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2321:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2326:6: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2327:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2327:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2328:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4516);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();
            _fsp--;

             
                    current = this_LogicalNotExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2336:1: ( () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2336:2: () '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2336:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2337:5: 
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

            	    match(input,41,FOLLOW_41_in_ruleLogicalAndExpression4535); 

            	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2356:1: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2357:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2357:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2358:3: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4556);
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
            	    break loop27;
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2388:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2389:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2390:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression4594);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();
            _fsp--;

             current =iv_ruleLogicalNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression4604); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2397:1: ruleLogicalNotExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2402:6: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2403:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2403:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_FLOAT)||LA28_0==26||(LA28_0>=45 && LA28_0<=46)||LA28_0==49) ) {
                alt28=1;
            }
            else if ( (LA28_0==42) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2403:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2404:5: this_LogicalRelationExpression_0= ruleLogicalRelationExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalRelationExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression4651);
                    this_LogicalRelationExpression_0=ruleLogicalRelationExpression();
                    _fsp--;

                     
                            current = this_LogicalRelationExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2413:6: ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2413:6: ( () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2413:7: () '!' ( (lv_operand_3_0= ruleLogicalRelationExpression ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2413:7: ()
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2414:5: 
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

                    match(input,42,FOLLOW_42_in_ruleLogicalNotExpression4676); 

                            createLeafNode(grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2428:1: ( (lv_operand_3_0= ruleLogicalRelationExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2429:1: (lv_operand_3_0= ruleLogicalRelationExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2429:1: (lv_operand_3_0= ruleLogicalRelationExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2430:3: lv_operand_3_0= ruleLogicalRelationExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandLogicalRelationExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression4697);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2460:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2461:2: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2462:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalRelationExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression4734);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();
            _fsp--;

             current =iv_ruleLogicalRelationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression4744); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2469:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2474:6: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2475:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2475:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2476:5: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression4791);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();
            _fsp--;

             
                    current = this_NumericalAddSubtractExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2484:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==35||(LA29_0>=50 && LA29_0<=54)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2484:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2484:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2485:5: 
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

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2500:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2501:1: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2501:1: (lv_operator_2_0= ruleRelationalOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2502:3: lv_operator_2_0= ruleRelationalOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression4821);
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

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2524:2: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2525:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2525:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2526:3: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression4842);
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
            	    break loop29;
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2556:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2557:2: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2558:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression4880);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();
            _fsp--;

             current =iv_ruleNumericalAddSubtractExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression4890); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2565:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2570:6: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2571:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2571:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2572:5: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression4937);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();
            _fsp--;

             
                    current = this_NumericalMultiplyDivideExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2580:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=45 && LA30_0<=46)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2580:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2580:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2581:5: 
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

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2596:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2597:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2597:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2598:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression4967);
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

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2620:2: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2621:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2621:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2622:3: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression4988);
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
    // $ANTLR end ruleNumericalAddSubtractExpression


    // $ANTLR start entryRuleNumericalMultiplyDivideExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2652:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2653:2: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2654:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression5026);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();
            _fsp--;

             current =iv_ruleNumericalMultiplyDivideExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression5036); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2661:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2666:6: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2667:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2667:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2668:5: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5083);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();
            _fsp--;

             
                    current = this_NumericalUnaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2676:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==31||(LA31_0>=47 && LA31_0<=48)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2676:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2676:2: ()
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2677:5: 
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

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2692:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2693:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2693:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2694:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression5113);
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

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2716:2: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2717:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2717:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2718:3: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5134);
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
            	    break loop31;
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2748:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2749:2: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2750:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericalUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression5172);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();
            _fsp--;

             current =iv_ruleNumericalUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression5182); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2757:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2762:6: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2763:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2763:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_FLOAT)||LA32_0==26) ) {
                alt32=1;
            }
            else if ( ((LA32_0>=45 && LA32_0<=46)||LA32_0==49) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2763:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2764:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression5229);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2773:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2773:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2773:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2773:7: ()
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2774:5: 
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

                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2784:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2785:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2785:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2786:3: lv_operator_2_0= ruleUnaryOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression5265);
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

                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2808:2: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2809:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2809:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2810:3: lv_operand_3_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression5286);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2840:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2841:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2842:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression5323);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression5333); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2849:1: rulePrimaryExpression returns [EObject current=null] : (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ValueExpression_0 = null;

        EObject this_LogicalOrExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2854:6: ( (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2855:1: (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2855:1: (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_FLOAT)) ) {
                alt33=1;
            }
            else if ( (LA33_0==26) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2855:1: (this_ValueExpression_0= ruleValueExpression | ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' ) )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2856:5: this_ValueExpression_0= ruleValueExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleValueExpression_in_rulePrimaryExpression5380);
                    this_ValueExpression_0=ruleValueExpression();
                    _fsp--;

                     
                            current = this_ValueExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2865:6: ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2865:6: ( '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2865:8: '(' this_LogicalOrExpression_2= ruleLogicalOrExpression ')'
                    {
                    match(input,26,FOLLOW_26_in_rulePrimaryExpression5396); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLogicalOrExpressionParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_rulePrimaryExpression5418);
                    this_LogicalOrExpression_2=ruleLogicalOrExpression();
                    _fsp--;

                     
                            current = this_LogicalOrExpression_2; 
                            currentNode = currentNode.getParent();
                        
                    match(input,28,FOLLOW_28_in_rulePrimaryExpression5427); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2890:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2891:2: (iv_ruleValueExpression= ruleValueExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2892:2: iv_ruleValueExpression= ruleValueExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueExpression_in_entryRuleValueExpression5464);
            iv_ruleValueExpression=ruleValueExpression();
            _fsp--;

             current =iv_ruleValueExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueExpression5474); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2899:1: ruleValueExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression ) ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_VariableReferenceExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2904:6: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2905:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2905:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_INT && LA34_0<=RULE_FLOAT)) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2905:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_VariableReferenceExpression_1= ruleVariableReferenceExpression )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2906:5: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression5521);
                    this_PrimitiveValueExpression_0=rulePrimitiveValueExpression();
                    _fsp--;

                     
                            current = this_PrimitiveValueExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2916:5: this_VariableReferenceExpression_1= ruleVariableReferenceExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueExpressionAccess().getVariableReferenceExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableReferenceExpression_in_ruleValueExpression5548);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2932:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2933:2: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2934:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveValueExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression5583);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();
            _fsp--;

             current =iv_rulePrimitiveValueExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression5593); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2941:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2946:6: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2947:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2947:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2947:2: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2947:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2948:5: 
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2958:2: ( (lv_value_1_0= ruleLiteral ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2959:1: (lv_value_1_0= ruleLiteral )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2959:1: (lv_value_1_0= ruleLiteral )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2960:3: lv_value_1_0= ruleLiteral
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression5648);
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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2990:1: entryRuleVariableReferenceExpression returns [EObject current=null] : iv_ruleVariableReferenceExpression= ruleVariableReferenceExpression EOF ;
    public final EObject entryRuleVariableReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReferenceExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2991:2: (iv_ruleVariableReferenceExpression= ruleVariableReferenceExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2992:2: iv_ruleVariableReferenceExpression= ruleVariableReferenceExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableReferenceExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableReferenceExpression_in_entryRuleVariableReferenceExpression5684);
            iv_ruleVariableReferenceExpression=ruleVariableReferenceExpression();
            _fsp--;

             current =iv_ruleVariableReferenceExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableReferenceExpression5694); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2999:1: ruleVariableReferenceExpression returns [EObject current=null] : ( () ( ( RULE_ID ) ) ) ;
    public final EObject ruleVariableReferenceExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3004:6: ( ( () ( ( RULE_ID ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3005:1: ( () ( ( RULE_ID ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3005:1: ( () ( ( RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3005:2: () ( ( RULE_ID ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3005:2: ()
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3006:5: 
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

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3016:2: ( ( RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3017:1: ( RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3017:1: ( RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3018:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableReferenceExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableReferenceExpression5746); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3038:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3039:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3040:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral5783);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral5794); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3047:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_FLOAT_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3052:6: ( (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3053:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3053:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )
            int alt35=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt35=1;
                }
                break;
            case RULE_INT:
                {
                alt35=2;
                }
                break;
            case RULE_STRING:
                {
                alt35=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3053:1: (this_BOOL_0= RULE_BOOL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_FLOAT_3= RULE_FLOAT )", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3053:6: this_BOOL_0= RULE_BOOL
                    {
                    this_BOOL_0=(Token)input.LT(1);
                    match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleLiteral5834); 

                    		current.merge(this_BOOL_0);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getBOOLTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3061:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral5860); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3069:10: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteral5886); 

                    		current.merge(this_STRING_2);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3077:10: this_FLOAT_3= RULE_FLOAT
                    {
                    this_FLOAT_3=(Token)input.LT(1);
                    match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleLiteral5912); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3092:1: ruleDirection returns [Enumerator current=null] : ( ( 'in' ) | ( 'out' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3096:6: ( ( ( 'in' ) | ( 'out' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3097:1: ( ( 'in' ) | ( 'out' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3097:1: ( ( 'in' ) | ( 'out' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==43) ) {
                alt36=1;
            }
            else if ( (LA36_0==44) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3097:1: ( ( 'in' ) | ( 'out' ) )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3097:2: ( 'in' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3097:2: ( 'in' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3097:4: 'in'
                    {
                    match(input,43,FOLLOW_43_in_ruleDirection5969); 

                            current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3103:6: ( 'out' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3103:6: ( 'out' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3103:8: 'out'
                    {
                    match(input,44,FOLLOW_44_in_ruleDirection5984); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3113:1: ruleAdditiveOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3117:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3118:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3118:1: ( ( '+' ) | ( '-' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==45) ) {
                alt37=1;
            }
            else if ( (LA37_0==46) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3118:1: ( ( '+' ) | ( '-' ) )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3118:2: ( '+' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3118:2: ( '+' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3118:4: '+'
                    {
                    match(input,45,FOLLOW_45_in_ruleAdditiveOperator6027); 

                            current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3124:6: ( '-' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3124:6: ( '-' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3124:8: '-'
                    {
                    match(input,46,FOLLOW_46_in_ruleAdditiveOperator6042); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3134:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3138:6: ( ( ( '*' ) | ( '/' ) | ( '%' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3139:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3139:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt38=1;
                }
                break;
            case 31:
                {
                alt38=2;
                }
                break;
            case 48:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3139:1: ( ( '*' ) | ( '/' ) | ( '%' ) )", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3139:2: ( '*' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3139:2: ( '*' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3139:4: '*'
                    {
                    match(input,47,FOLLOW_47_in_ruleMultiplicativeOperator6085); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3145:6: ( '/' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3145:6: ( '/' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3145:8: '/'
                    {
                    match(input,31,FOLLOW_31_in_ruleMultiplicativeOperator6100); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3151:6: ( '%' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3151:6: ( '%' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3151:8: '%'
                    {
                    match(input,48,FOLLOW_48_in_ruleMultiplicativeOperator6115); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3161:1: ruleUnaryOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3165:6: ( ( ( '+' ) | ( '-' ) | ( '~' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3166:1: ( ( '+' ) | ( '-' ) | ( '~' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3166:1: ( ( '+' ) | ( '-' ) | ( '~' ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt39=1;
                }
                break;
            case 46:
                {
                alt39=2;
                }
                break;
            case 49:
                {
                alt39=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3166:1: ( ( '+' ) | ( '-' ) | ( '~' ) )", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3166:2: ( '+' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3166:2: ( '+' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3166:4: '+'
                    {
                    match(input,45,FOLLOW_45_in_ruleUnaryOperator6158); 

                            current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3172:6: ( '-' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3172:6: ( '-' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3172:8: '-'
                    {
                    match(input,46,FOLLOW_46_in_ruleUnaryOperator6173); 

                            current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3178:6: ( '~' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3178:6: ( '~' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3178:8: '~'
                    {
                    match(input,49,FOLLOW_49_in_ruleUnaryOperator6188); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3188:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3192:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3193:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3193:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt40=1;
                }
                break;
            case 51:
                {
                alt40=2;
                }
                break;
            case 35:
                {
                alt40=3;
                }
                break;
            case 52:
                {
                alt40=4;
                }
                break;
            case 53:
                {
                alt40=5;
                }
                break;
            case 54:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3193:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) | ( '==' ) | ( '!=' ) )", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3193:2: ( '<' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3193:2: ( '<' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3193:4: '<'
                    {
                    match(input,50,FOLLOW_50_in_ruleRelationalOperator6231); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3199:6: ( '<=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3199:6: ( '<=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3199:8: '<='
                    {
                    match(input,51,FOLLOW_51_in_ruleRelationalOperator6246); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3205:6: ( '>' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3205:6: ( '>' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3205:8: '>'
                    {
                    match(input,35,FOLLOW_35_in_ruleRelationalOperator6261); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3211:6: ( '>=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3211:6: ( '>=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3211:8: '>='
                    {
                    match(input,52,FOLLOW_52_in_ruleRelationalOperator6276); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3217:6: ( '==' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3217:6: ( '==' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3217:8: '=='
                    {
                    match(input,53,FOLLOW_53_in_ruleRelationalOperator6291); 

                            current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3223:6: ( '!=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3223:6: ( '!=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3223:8: '!='
                    {
                    match(input,54,FOLLOW_54_in_ruleRelationalOperator6306); 

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


    // $ANTLR start ruleType
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3237:1: ruleType returns [Enumerator current=null] : ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3241:6: ( ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3242:1: ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3242:1: ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) )
            int alt41=5;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt41=1;
                }
                break;
            case 56:
                {
                alt41=2;
                }
                break;
            case 57:
                {
                alt41=3;
                }
                break;
            case 58:
                {
                alt41=4;
                }
                break;
            case 59:
                {
                alt41=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3242:1: ( ( 'void' ) | ( 'integer' ) | ( 'real' ) | ( 'boolean' ) | ( 'string' ) )", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3242:2: ( 'void' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3242:2: ( 'void' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3242:4: 'void'
                    {
                    match(input,55,FOLLOW_55_in_ruleType6353); 

                            current = grammarAccess.getTypeAccess().getVoidEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getVoidEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3248:6: ( 'integer' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3248:6: ( 'integer' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3248:8: 'integer'
                    {
                    match(input,56,FOLLOW_56_in_ruleType6368); 

                            current = grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getIntegerEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3254:6: ( 'real' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3254:6: ( 'real' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3254:8: 'real'
                    {
                    match(input,57,FOLLOW_57_in_ruleType6383); 

                            current = grammarAccess.getTypeAccess().getRealEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getRealEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3260:6: ( 'boolean' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3260:6: ( 'boolean' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3260:8: 'boolean'
                    {
                    match(input,58,FOLLOW_58_in_ruleType6398); 

                            current = grammarAccess.getTypeAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getBooleanEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3266:6: ( 'string' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3266:6: ( 'string' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:3266:8: 'string'
                    {
                    match(input,59,FOLLOW_59_in_ruleType6413); 

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
    public static final BitSet FOLLOW_14_in_ruleStateRoot459 = new BitSet(new long[]{0x0000180063280012L});
    public static final BitSet FOLLOW_ruleStateDefinition_in_ruleStateRoot480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRoot_in_entryRuleTransitionRoot516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRoot526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTransitionRoot561 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTransitionStatement_in_ruleTransitionRoot582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartDefinition_in_entryRuleStatechartDefinition618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartDefinition628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_ruleStatechartDefinition683 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleStateDefinition_in_entryRuleStateDefinition720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateDefinition730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleScope_in_ruleStateDefinition776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionStatement_in_entryRuleTransitionStatement810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionStatement820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReaction_in_ruleTransitionStatement866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleScope_in_entryRuleSimpleScope902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleScope912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleSimpleScope967 = new BitSet(new long[]{0x0000180063280012L});
    public static final BitSet FOLLOW_ruleStatechartScope_in_entryRuleStatechartScope1004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatechartScope1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_ruleStatechartScope1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalScope_in_ruleStatechartScope1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterfaceScope_in_entryRuleInterfaceScope1123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterfaceScope1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleInterfaceScope1177 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInterfaceScope1194 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInterfaceScope1210 = new BitSet(new long[]{0x0000180063280012L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInterfaceScope1231 = new BitSet(new long[]{0x0000180063280012L});
    public static final BitSet FOLLOW_ruleInternalScope_in_entryRuleInternalScope1268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalScope1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleInternalScope1322 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInternalScope1332 = new BitSet(new long[]{0x0000180063280012L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInternalScope1353 = new BitSet(new long[]{0x0000180063280012L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition1390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_ruleDefinition1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleDefinition1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClock_in_ruleDefinition1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleDefinition1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReaction_in_ruleDefinition1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_ruleDefinition1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_ruleDefinition1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDefinition_in_entryRuleEventDefinition1646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDefinition1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_ruleEventDefinition1702 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleEventDefinition1713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDefinition1730 = new BitSet(new long[]{0x0000000000120002L});
    public static final BitSet FOLLOW_17_in_ruleEventDefinition1746 = new BitSet(new long[]{0x0F80000000000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleEventDefinition1767 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_ruleEventDefinition1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDerivation_in_entryRuleEventDerivation1827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDerivation1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleEventDerivation1872 = new BitSet(new long[]{0x00026480040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleEventDerivation1893 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleEventDerivation1904 = new BitSet(new long[]{0x00026480040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleEventDerivation1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVariableDefinition2010 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_22_in_ruleVariableDefinition2070 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_23_in_ruleVariableDefinition2151 = new BitSet(new long[]{0x0000000000C00010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDefinition2220 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableDefinition2235 = new BitSet(new long[]{0x0F80000000000000L});
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
    public static final BitSet FOLLOW_26_in_ruleOperation2506 = new BitSet(new long[]{0x0F80000010000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2528 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleOperation2539 = new BitSet(new long[]{0x0F80000000000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2560 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleOperation2574 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleOperation2585 = new BitSet(new long[]{0x0F80000000000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleOperation2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntrypoint_in_entryRuleEntrypoint2644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntrypoint2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleEntrypoint2689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntrypoint2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitpoint_in_entryRuleExitpoint2747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitpoint2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleExitpoint2792 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitpoint2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReaction_in_entryRuleReaction2850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReaction2860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_ruleReaction2906 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleReaction2917 = new BitSet(new long[]{0x00026480040001F0L});
    public static final BitSet FOLLOW_ruleAction_in_ruleReaction2938 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleReaction2951 = new BitSet(new long[]{0x0000000800000032L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_ruleReaction2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionTrigger_in_entryRuleReactionTrigger3010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionTrigger3020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReactionTrigger3064 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_27_in_ruleReactionTrigger3075 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReactionTrigger3093 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_33_in_ruleReactionTrigger3107 = new BitSet(new long[]{0x00026400040001F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleReactionTrigger3128 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleReactionTrigger3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleAction3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperties_in_entryRuleReactionProperties3266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperties3276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_ruleReactionProperties3331 = new BitSet(new long[]{0x0000000800000032L});
    public static final BitSet FOLLOW_ruleReactionProperty_in_entryRuleReactionProperty3368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionProperty3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionPriority_in_ruleReactionProperty3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_ruleReactionProperty3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_ruleReactionProperty3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReactionPriority_in_entryRuleReactionPriority3514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReactionPriority3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleReactionPriority3565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryPointSpec_in_entryRuleEntryPointSpec3605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryPointSpec3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleEntryPointSpec3650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryPointSpec3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitPointSpec_in_entryRuleExitPointSpec3704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitPointSpec3714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitPointSpec3757 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleExitPointSpec3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryExpression_in_entryRuleEntryExpression3805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryExpression3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleEntryExpression3850 = new BitSet(new long[]{0x00026480040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleEntryExpression3871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitExpression_in_entryRuleExitExpression3907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitExpression3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleExitExpression3952 = new BitSet(new long[]{0x00026480040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleExitExpression3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOnTickExpression_in_entryRuleOnTickExpression4009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOnTickExpression4019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOnTickExpression4054 = new BitSet(new long[]{0x00026480040001F0L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_ruleOnTickExpression4075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionRule_in_entryRuleExpressionRule4111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionRule4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleExpressionRule4168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRaiseEventExpression_in_ruleExpressionRule4187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRaiseEventExpression_in_entryRuleRaiseEventExpression4225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRaiseEventExpression4235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleRaiseEventExpression4270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRaiseEventExpression4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression4324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4381 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleLogicalOrExpression4400 = new BitSet(new long[]{0x00026400040001F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression4421 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression4459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4516 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleLogicalAndExpression4535 = new BitSet(new long[]{0x00026400040001F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression4556 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression4594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression4604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLogicalNotExpression4676 = new BitSet(new long[]{0x00026000040001F0L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleLogicalNotExpression4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression4734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression4791 = new BitSet(new long[]{0x007C000800000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression4821 = new BitSet(new long[]{0x00026000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleLogicalRelationExpression4842 = new BitSet(new long[]{0x007C000800000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression4880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression4937 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression4967 = new BitSet(new long[]{0x00026000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression4988 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression5026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5083 = new BitSet(new long[]{0x0001800080000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression5113 = new BitSet(new long[]{0x00026000040001F0L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression5134 = new BitSet(new long[]{0x0001800080000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression5172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression5265 = new BitSet(new long[]{0x00000000040001F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression5323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_rulePrimaryExpression5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePrimaryExpression5396 = new BitSet(new long[]{0x00026400040001F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_rulePrimaryExpression5418 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePrimaryExpression5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueExpression_in_entryRuleValueExpression5464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueExpression5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_ruleValueExpression5521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReferenceExpression_in_ruleValueExpression5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression5583 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReferenceExpression_in_entryRuleVariableReferenceExpression5684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableReferenceExpression5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableReferenceExpression5746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral5783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral5794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleLiteral5834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral5860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleLiteral5912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleDirection5969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleDirection5984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleAdditiveOperator6027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleAdditiveOperator6042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleMultiplicativeOperator6085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeOperator6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleMultiplicativeOperator6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleUnaryOperator6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleUnaryOperator6173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleUnaryOperator6188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelationalOperator6231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRelationalOperator6246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleRelationalOperator6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleRelationalOperator6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleRelationalOperator6291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleRelationalOperator6306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleType6353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleType6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleType6383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleType6398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleType6413 = new BitSet(new long[]{0x0000000000000002L});

}
