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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_HEX_LITERAL", "RULE_BOOLEAN_LITERAL", "RULE_STRING", "RULE_FLOATING_POINT_LITERAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'after'", "'('", "')'", "'var'", "';'", "'raise'", "'||'", "'&&'", "'^'", "'|'", "'&'", "'?'", "':'", "'s'", "'ms'", "'ns'", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=8;
    public static final int RULE_BOOLEAN_LITERAL=7;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_HEX_LITERAL=6;
    public static final int RULE_INT=5;
    public static final int RULE_FLOATING_POINT_LITERAL=9;
    public static final int RULE_WS=12;
    public static final int RULE_SL_COMMENT=11;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=10;

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
        	return "Expression";	
       	}
       	
       	@Override
       	protected ExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:78:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:79:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:80:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression75);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression85); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:87:1: ruleExpression returns [EObject current=null] : (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TriggerExpression_0 = null;

        EObject this_GuardExpression_1 = null;

        EObject this_ActionExpression_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:92:6: ( (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==EOF||LA1_1==14) ) {
                    alt1=1;
                }
                else if ( (LA1_1==16||(LA1_1>=31 && LA1_1<=41)) ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt1=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX_LITERAL:
            case RULE_BOOLEAN_LITERAL:
            case RULE_STRING:
            case RULE_FLOATING_POINT_LITERAL:
            case 16:
            case 50:
            case 51:
            case 55:
            case 56:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                int LA1_4 = input.LA(2);

                if ( (LA1_4==16) ) {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==RULE_ID) ) {
                        int LA1_7 = input.LA(4);

                        if ( (LA1_7==17) ) {
                            int LA1_8 = input.LA(5);

                            if ( (LA1_8==EOF||(LA1_8>=21 && LA1_8<=25)||(LA1_8>=42 && LA1_8<=54)) ) {
                                alt1=2;
                            }
                            else if ( ((LA1_8>=31 && LA1_8<=41)) ) {
                                alt1=3;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 8, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 7, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 4, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("93:1: (this_TriggerExpression_0= ruleTriggerExpression | this_GuardExpression_1= ruleGuardExpression | this_ActionExpression_2= ruleActionExpression )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:94:5: this_TriggerExpression_0= ruleTriggerExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getTriggerExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTriggerExpression_in_ruleExpression132);
                    this_TriggerExpression_0=ruleTriggerExpression();
                    _fsp--;

                     
                            current = this_TriggerExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:104:5: this_GuardExpression_1= ruleGuardExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getGuardExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGuardExpression_in_ruleExpression159);
                    this_GuardExpression_1=ruleGuardExpression();
                    _fsp--;

                     
                            current = this_GuardExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:114:5: this_ActionExpression_2= ruleActionExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getActionExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleActionExpression_in_ruleExpression186);
                    this_ActionExpression_2=ruleActionExpression();
                    _fsp--;

                     
                            current = this_ActionExpression_2; 
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


    // $ANTLR start entryRuleTriggerExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:130:1: entryRuleTriggerExpression returns [EObject current=null] : iv_ruleTriggerExpression= ruleTriggerExpression EOF ;
    public final EObject entryRuleTriggerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:131:2: (iv_ruleTriggerExpression= ruleTriggerExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:132:2: iv_ruleTriggerExpression= ruleTriggerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTriggerExpression_in_entryRuleTriggerExpression221);
            iv_ruleTriggerExpression=ruleTriggerExpression();
            _fsp--;

             current =iv_ruleTriggerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerExpression231); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTriggerExpression


    // $ANTLR start ruleTriggerExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:139:1: ruleTriggerExpression returns [EObject current=null] : ( ( (lv_triggers_0_0= ruleTrigger ) ) ( ',' ( (lv_triggers_2_0= ruleTrigger ) ) )* ) ;
    public final EObject ruleTriggerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:144:6: ( ( ( (lv_triggers_0_0= ruleTrigger ) ) ( ',' ( (lv_triggers_2_0= ruleTrigger ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:145:1: ( ( (lv_triggers_0_0= ruleTrigger ) ) ( ',' ( (lv_triggers_2_0= ruleTrigger ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:145:1: ( ( (lv_triggers_0_0= ruleTrigger ) ) ( ',' ( (lv_triggers_2_0= ruleTrigger ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:145:2: ( (lv_triggers_0_0= ruleTrigger ) ) ( ',' ( (lv_triggers_2_0= ruleTrigger ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:145:2: ( (lv_triggers_0_0= ruleTrigger ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:146:1: (lv_triggers_0_0= ruleTrigger )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:146:1: (lv_triggers_0_0= ruleTrigger )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:147:3: lv_triggers_0_0= ruleTrigger
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggerExpressionAccess().getTriggersTriggerParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTrigger_in_ruleTriggerExpression277);
            lv_triggers_0_0=ruleTrigger();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggerExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"triggers",
            	        		lv_triggers_0_0, 
            	        		"Trigger", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:169:2: ( ',' ( (lv_triggers_2_0= ruleTrigger ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:169:4: ',' ( (lv_triggers_2_0= ruleTrigger ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTriggerExpression288); 

            	            createLeafNode(grammarAccess.getTriggerExpressionAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:173:1: ( (lv_triggers_2_0= ruleTrigger ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:174:1: (lv_triggers_2_0= ruleTrigger )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:174:1: (lv_triggers_2_0= ruleTrigger )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:175:3: lv_triggers_2_0= ruleTrigger
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTriggerExpressionAccess().getTriggersTriggerParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTrigger_in_ruleTriggerExpression309);
            	    lv_triggers_2_0=ruleTrigger();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTriggerExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"triggers",
            	    	        		lv_triggers_2_0, 
            	    	        		"Trigger", 
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
            	    break loop2;
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
    // $ANTLR end ruleTriggerExpression


    // $ANTLR start entryRuleGuardExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:205:1: entryRuleGuardExpression returns [EObject current=null] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final EObject entryRuleGuardExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:206:2: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:207:2: iv_ruleGuardExpression= ruleGuardExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuardExpression_in_entryRuleGuardExpression347);
            iv_ruleGuardExpression=ruleGuardExpression();
            _fsp--;

             current =iv_ruleGuardExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardExpression357); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGuardExpression


    // $ANTLR start ruleGuardExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:214:1: ruleGuardExpression returns [EObject current=null] : ( (lv_expression_0_0= ruleBooleanOrExpression ) ) ;
    public final EObject ruleGuardExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:219:6: ( ( (lv_expression_0_0= ruleBooleanOrExpression ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:220:1: ( (lv_expression_0_0= ruleBooleanOrExpression ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:220:1: ( (lv_expression_0_0= ruleBooleanOrExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:221:1: (lv_expression_0_0= ruleBooleanOrExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:221:1: (lv_expression_0_0= ruleBooleanOrExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:222:3: lv_expression_0_0= ruleBooleanOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getGuardExpressionAccess().getExpressionBooleanOrExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOrExpression_in_ruleGuardExpression402);
            lv_expression_0_0=ruleBooleanOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGuardExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_0_0, 
            	        		"BooleanOrExpression", 
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
    // $ANTLR end ruleGuardExpression


    // $ANTLR start entryRuleActionExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:252:1: entryRuleActionExpression returns [EObject current=null] : iv_ruleActionExpression= ruleActionExpression EOF ;
    public final EObject entryRuleActionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:253:2: (iv_ruleActionExpression= ruleActionExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:254:2: iv_ruleActionExpression= ruleActionExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getActionExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleActionExpression_in_entryRuleActionExpression437);
            iv_ruleActionExpression=ruleActionExpression();
            _fsp--;

             current =iv_ruleActionExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActionExpression447); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleActionExpression


    // $ANTLR start ruleActionExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:261:1: ruleActionExpression returns [EObject current=null] : ( (lv_statement_0_0= ruleStatement ) )+ ;
    public final EObject ruleActionExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:266:6: ( ( (lv_statement_0_0= ruleStatement ) )+ )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:267:1: ( (lv_statement_0_0= ruleStatement ) )+
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:267:1: ( (lv_statement_0_0= ruleStatement ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||LA3_0==18||LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:268:1: (lv_statement_0_0= ruleStatement )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:268:1: (lv_statement_0_0= ruleStatement )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:269:3: lv_statement_0_0= ruleStatement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getActionExpressionAccess().getStatementStatementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleActionExpression492);
            	    lv_statement_0_0=ruleStatement();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getActionExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"statement",
            	    	        		lv_statement_0_0, 
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
    // $ANTLR end ruleActionExpression


    // $ANTLR start entryRuleTrigger
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:299:1: entryRuleTrigger returns [EObject current=null] : iv_ruleTrigger= ruleTrigger EOF ;
    public final EObject entryRuleTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrigger = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:300:2: (iv_ruleTrigger= ruleTrigger EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:301:2: iv_ruleTrigger= ruleTrigger EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTriggerRule(), currentNode); 
            pushFollow(FOLLOW_ruleTrigger_in_entryRuleTrigger528);
            iv_ruleTrigger=ruleTrigger();
            _fsp--;

             current =iv_ruleTrigger; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrigger538); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTrigger


    // $ANTLR start ruleTrigger
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:308:1: ruleTrigger returns [EObject current=null] : ( (lv_event_0_0= ruleEvent ) ) ;
    public final EObject ruleTrigger() throws RecognitionException {
        EObject current = null;

        EObject lv_event_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:313:6: ( ( (lv_event_0_0= ruleEvent ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:314:1: ( (lv_event_0_0= ruleEvent ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:314:1: ( (lv_event_0_0= ruleEvent ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:315:1: (lv_event_0_0= ruleEvent )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:315:1: (lv_event_0_0= ruleEvent )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:316:3: lv_event_0_0= ruleEvent
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTriggerAccess().getEventEventParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEvent_in_ruleTrigger583);
            lv_event_0_0=ruleEvent();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTriggerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"event",
            	        		lv_event_0_0, 
            	        		"Event", 
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
    // $ANTLR end ruleTrigger


    // $ANTLR start entryRuleEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:346:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:347:2: (iv_ruleEvent= ruleEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:348:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent618);
            iv_ruleEvent=ruleEvent();
            _fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent628); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEvent


    // $ANTLR start ruleEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:355:1: ruleEvent returns [EObject current=null] : (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_SignalEvent_0 = null;

        EObject this_TimeEvent_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:360:6: ( (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:361:1: (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:361:1: (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("361:1: (this_SignalEvent_0= ruleSignalEvent | this_TimeEvent_1= ruleTimeEvent )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:362:5: this_SignalEvent_0= ruleSignalEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventAccess().getSignalEventParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSignalEvent_in_ruleEvent675);
                    this_SignalEvent_0=ruleSignalEvent();
                    _fsp--;

                     
                            current = this_SignalEvent_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:372:5: this_TimeEvent_1= ruleTimeEvent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventAccess().getTimeEventParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeEvent_in_ruleEvent702);
                    this_TimeEvent_1=ruleTimeEvent();
                    _fsp--;

                     
                            current = this_TimeEvent_1; 
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
    // $ANTLR end ruleEvent


    // $ANTLR start entryRuleSignalEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:388:1: entryRuleSignalEvent returns [EObject current=null] : iv_ruleSignalEvent= ruleSignalEvent EOF ;
    public final EObject entryRuleSignalEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignalEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:389:2: (iv_ruleSignalEvent= ruleSignalEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:390:2: iv_ruleSignalEvent= ruleSignalEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSignalEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleSignalEvent_in_entryRuleSignalEvent737);
            iv_ruleSignalEvent=ruleSignalEvent();
            _fsp--;

             current =iv_ruleSignalEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignalEvent747); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSignalEvent


    // $ANTLR start ruleSignalEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:397:1: ruleSignalEvent returns [EObject current=null] : ( (lv_identifier_0_0= RULE_ID ) ) ;
    public final EObject ruleSignalEvent() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:402:6: ( ( (lv_identifier_0_0= RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:403:1: ( (lv_identifier_0_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:403:1: ( (lv_identifier_0_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:404:1: (lv_identifier_0_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:404:1: (lv_identifier_0_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:405:3: lv_identifier_0_0= RULE_ID
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignalEvent788); 

            			createLeafNode(grammarAccess.getSignalEventAccess().getIdentifierIDTerminalRuleCall_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSignalEventRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_0_0, 
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
    // $ANTLR end ruleSignalEvent


    // $ANTLR start entryRuleTimeEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:435:1: entryRuleTimeEvent returns [EObject current=null] : iv_ruleTimeEvent= ruleTimeEvent EOF ;
    public final EObject entryRuleTimeEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEvent = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:436:2: (iv_ruleTimeEvent= ruleTimeEvent EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:437:2: iv_ruleTimeEvent= ruleTimeEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeEvent_in_entryRuleTimeEvent828);
            iv_ruleTimeEvent=ruleTimeEvent();
            _fsp--;

             current =iv_ruleTimeEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEvent838); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTimeEvent


    // $ANTLR start ruleTimeEvent
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:444:1: ruleTimeEvent returns [EObject current=null] : ( 'after' '(' ( (lv_duration_2_0= ruleTimeExpression ) ) ')' ) ;
    public final EObject ruleTimeEvent() throws RecognitionException {
        EObject current = null;

        EObject lv_duration_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:449:6: ( ( 'after' '(' ( (lv_duration_2_0= ruleTimeExpression ) ) ')' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:450:1: ( 'after' '(' ( (lv_duration_2_0= ruleTimeExpression ) ) ')' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:450:1: ( 'after' '(' ( (lv_duration_2_0= ruleTimeExpression ) ) ')' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:450:3: 'after' '(' ( (lv_duration_2_0= ruleTimeExpression ) ) ')'
            {
            match(input,15,FOLLOW_15_in_ruleTimeEvent873); 

                    createLeafNode(grammarAccess.getTimeEventAccess().getAfterKeyword_0(), null); 
                
            match(input,16,FOLLOW_16_in_ruleTimeEvent883); 

                    createLeafNode(grammarAccess.getTimeEventAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:458:1: ( (lv_duration_2_0= ruleTimeExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:459:1: (lv_duration_2_0= ruleTimeExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:459:1: (lv_duration_2_0= ruleTimeExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:460:3: lv_duration_2_0= ruleTimeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTimeEventAccess().getDurationTimeExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTimeExpression_in_ruleTimeEvent904);
            lv_duration_2_0=ruleTimeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTimeEventRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"duration",
            	        		lv_duration_2_0, 
            	        		"TimeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleTimeEvent914); 

                    createLeafNode(grammarAccess.getTimeEventAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTimeEvent


    // $ANTLR start entryRuleTimeExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:494:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:495:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:496:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression950);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression960); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTimeExpression


    // $ANTLR start ruleTimeExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:503:1: ruleTimeExpression returns [EObject current=null] : (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TimeConstant_0 = null;

        EObject this_VariableReference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:508:6: ( (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:509:1: (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:509:1: (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("509:1: (this_TimeConstant_0= ruleTimeConstant | this_VariableReference_1= ruleVariableReference )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:510:5: this_TimeConstant_0= ruleTimeConstant
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getTimeConstantParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeConstant_in_ruleTimeExpression1007);
                    this_TimeConstant_0=ruleTimeConstant();
                    _fsp--;

                     
                            current = this_TimeConstant_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:520:5: this_VariableReference_1= ruleVariableReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getVariableReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableReference_in_ruleTimeExpression1034);
                    this_VariableReference_1=ruleVariableReference();
                    _fsp--;

                     
                            current = this_VariableReference_1; 
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
    // $ANTLR end ruleTimeExpression


    // $ANTLR start entryRuleVariableReference
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:536:1: entryRuleVariableReference returns [EObject current=null] : iv_ruleVariableReference= ruleVariableReference EOF ;
    public final EObject entryRuleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReference = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:537:2: (iv_ruleVariableReference= ruleVariableReference EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:538:2: iv_ruleVariableReference= ruleVariableReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableReference_in_entryRuleVariableReference1069);
            iv_ruleVariableReference=ruleVariableReference();
            _fsp--;

             current =iv_ruleVariableReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableReference1079); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariableReference


    // $ANTLR start ruleVariableReference
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:545:1: ruleVariableReference returns [EObject current=null] : ( ( (lv_variable_0_0= ruleVariable ) ) | ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' ) ) ;
    public final EObject ruleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_0_0 = null;

        EObject lv_variable_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:550:6: ( ( ( (lv_variable_0_0= ruleVariable ) ) | ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:551:1: ( ( (lv_variable_0_0= ruleVariable ) ) | ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:551:1: ( ( (lv_variable_0_0= ruleVariable ) ) | ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("551:1: ( ( (lv_variable_0_0= ruleVariable ) ) | ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:551:2: ( (lv_variable_0_0= ruleVariable ) )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:551:2: ( (lv_variable_0_0= ruleVariable ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:552:1: (lv_variable_0_0= ruleVariable )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:552:1: (lv_variable_0_0= ruleVariable )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:553:3: lv_variable_0_0= ruleVariable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableReferenceAccess().getVariableVariableParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableReference1125);
                    lv_variable_0_0=ruleVariable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"variable",
                    	        		lv_variable_0_0, 
                    	        		"Variable", 
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
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:576:6: ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:576:6: ( 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:576:8: 'var' '(' ( (lv_variable_3_0= ruleVariable ) ) ')'
                    {
                    match(input,18,FOLLOW_18_in_ruleVariableReference1142); 

                            createLeafNode(grammarAccess.getVariableReferenceAccess().getVarKeyword_1_0(), null); 
                        
                    match(input,16,FOLLOW_16_in_ruleVariableReference1152); 

                            createLeafNode(grammarAccess.getVariableReferenceAccess().getLeftParenthesisKeyword_1_1(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:584:1: ( (lv_variable_3_0= ruleVariable ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:585:1: (lv_variable_3_0= ruleVariable )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:585:1: (lv_variable_3_0= ruleVariable )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:586:3: lv_variable_3_0= ruleVariable
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableReferenceAccess().getVariableVariableParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableReference1173);
                    lv_variable_3_0=ruleVariable();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"variable",
                    	        		lv_variable_3_0, 
                    	        		"Variable", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,17,FOLLOW_17_in_ruleVariableReference1183); 

                            createLeafNode(grammarAccess.getVariableReferenceAccess().getRightParenthesisKeyword_1_3(), null); 
                        

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
    // $ANTLR end ruleVariableReference


    // $ANTLR start entryRuleVariable
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:620:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:621:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:622:2: iv_ruleVariable= ruleVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1220);
            iv_ruleVariable=ruleVariable();
            _fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable1230); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariable


    // $ANTLR start ruleVariable
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:629:1: ruleVariable returns [EObject current=null] : ( (lv_identifier_0_0= RULE_ID ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:634:6: ( ( (lv_identifier_0_0= RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:635:1: ( (lv_identifier_0_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:635:1: ( (lv_identifier_0_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:636:1: (lv_identifier_0_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:636:1: (lv_identifier_0_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:637:3: lv_identifier_0_0= RULE_ID
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable1271); 

            			createLeafNode(grammarAccess.getVariableAccess().getIdentifierIDTerminalRuleCall_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_0_0, 
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
    // $ANTLR end ruleVariable


    // $ANTLR start entryRuleTimeConstant
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:667:1: entryRuleTimeConstant returns [EObject current=null] : iv_ruleTimeConstant= ruleTimeConstant EOF ;
    public final EObject entryRuleTimeConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeConstant = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:668:2: (iv_ruleTimeConstant= ruleTimeConstant EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:669:2: iv_ruleTimeConstant= ruleTimeConstant EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeConstantRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeConstant_in_entryRuleTimeConstant1311);
            iv_ruleTimeConstant=ruleTimeConstant();
            _fsp--;

             current =iv_ruleTimeConstant; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeConstant1321); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTimeConstant


    // $ANTLR start ruleTimeConstant
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:676:1: ruleTimeConstant returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleTimeUnit ) )? ) ;
    public final EObject ruleTimeConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Enumerator lv_unit_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:681:6: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleTimeUnit ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:682:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleTimeUnit ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:682:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleTimeUnit ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:682:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= ruleTimeUnit ) )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:682:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:683:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:683:1: (lv_value_0_0= RULE_INT )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:684:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTimeConstant1363); 

            			createLeafNode(grammarAccess.getTimeConstantAccess().getValueINTTerminalRuleCall_0_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTimeConstantRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:706:2: ( (lv_unit_1_0= ruleTimeUnit ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=28 && LA7_0<=30)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:707:1: (lv_unit_1_0= ruleTimeUnit )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:707:1: (lv_unit_1_0= ruleTimeUnit )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:708:3: lv_unit_1_0= ruleTimeUnit
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTimeConstantAccess().getUnitTimeUnitEnumRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTimeUnit_in_ruleTimeConstant1389);
                    lv_unit_1_0=ruleTimeUnit();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTimeConstantRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_1_0, 
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
    // $ANTLR end ruleTimeConstant


    // $ANTLR start entryRuleStatement
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:738:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:739:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:740:2: iv_ruleStatement= ruleStatement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatementRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement1426);
            iv_ruleStatement=ruleStatement();
            _fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement1436); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:747:1: ruleStatement returns [EObject current=null] : ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableAssignment_0 = null;

        EObject this_EventRaising_1 = null;

        EObject this_ProcedureCall_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:752:6: ( ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:753:1: ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:753:1: ( (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:753:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall ) ';'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:753:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==16) ) {
                    alt8=3;
                }
                else if ( ((LA8_1>=31 && LA8_1<=41)) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("753:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall )", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("753:2: (this_VariableAssignment_0= ruleVariableAssignment | this_EventRaising_1= ruleEventRaising | this_ProcedureCall_2= ruleProcedureCall )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:754:5: this_VariableAssignment_0= ruleVariableAssignment
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getVariableAssignmentParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableAssignment_in_ruleStatement1484);
                    this_VariableAssignment_0=ruleVariableAssignment();
                    _fsp--;

                     
                            current = this_VariableAssignment_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:764:5: this_EventRaising_1= ruleEventRaising
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getEventRaisingParserRuleCall_0_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEventRaising_in_ruleStatement1511);
                    this_EventRaising_1=ruleEventRaising();
                    _fsp--;

                     
                            current = this_EventRaising_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:774:5: this_ProcedureCall_2= ruleProcedureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStatementAccess().getProcedureCallParserRuleCall_0_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleProcedureCall_in_ruleStatement1538);
                    this_ProcedureCall_2=ruleProcedureCall();
                    _fsp--;

                     
                            current = this_ProcedureCall_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleStatement1548); 

                    createLeafNode(grammarAccess.getStatementAccess().getSemicolonKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start entryRuleVariableAssignment
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:794:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:795:2: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:796:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableAssignmentRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableAssignment_in_entryRuleVariableAssignment1584);
            iv_ruleVariableAssignment=ruleVariableAssignment();
            _fsp--;

             current =iv_ruleVariableAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableAssignment1594); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleVariableAssignment


    // $ANTLR start ruleVariableAssignment
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:803:1: ruleVariableAssignment returns [EObject current=null] : ( ( (lv_variableReference_0_0= ruleVariableReference ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_value_2_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_variableReference_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:808:6: ( ( ( (lv_variableReference_0_0= ruleVariableReference ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_value_2_0= ruleConditionalExpression ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:809:1: ( ( (lv_variableReference_0_0= ruleVariableReference ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_value_2_0= ruleConditionalExpression ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:809:1: ( ( (lv_variableReference_0_0= ruleVariableReference ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_value_2_0= ruleConditionalExpression ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:809:2: ( (lv_variableReference_0_0= ruleVariableReference ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_value_2_0= ruleConditionalExpression ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:809:2: ( (lv_variableReference_0_0= ruleVariableReference ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:810:1: (lv_variableReference_0_0= ruleVariableReference )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:810:1: (lv_variableReference_0_0= ruleVariableReference )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:811:3: lv_variableReference_0_0= ruleVariableReference
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableAssignmentAccess().getVariableReferenceVariableReferenceParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVariableReference_in_ruleVariableAssignment1640);
            lv_variableReference_0_0=ruleVariableReference();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"variableReference",
            	        		lv_variableReference_0_0, 
            	        		"VariableReference", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:833:2: ( (lv_operator_1_0= ruleAssignmentOperator ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:834:1: (lv_operator_1_0= ruleAssignmentOperator )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:834:1: (lv_operator_1_0= ruleAssignmentOperator )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:835:3: lv_operator_1_0= ruleAssignmentOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableAssignmentAccess().getOperatorAssignmentOperatorEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleVariableAssignment1661);
            lv_operator_1_0=ruleAssignmentOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_1_0, 
            	        		"AssignmentOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:857:2: ( (lv_value_2_0= ruleConditionalExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:858:1: (lv_value_2_0= ruleConditionalExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:858:1: (lv_value_2_0= ruleConditionalExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:859:3: lv_value_2_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueConditionalExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleVariableAssignment1682);
            lv_value_2_0=ruleConditionalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableAssignmentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"ConditionalExpression", 
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
    // $ANTLR end ruleVariableAssignment


    // $ANTLR start entryRuleProcedureCall
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:889:1: entryRuleProcedureCall returns [EObject current=null] : iv_ruleProcedureCall= ruleProcedureCall EOF ;
    public final EObject entryRuleProcedureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedureCall = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:890:2: (iv_ruleProcedureCall= ruleProcedureCall EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:891:2: iv_ruleProcedureCall= ruleProcedureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProcedureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleProcedureCall_in_entryRuleProcedureCall1718);
            iv_ruleProcedureCall=ruleProcedureCall();
            _fsp--;

             current =iv_ruleProcedureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedureCall1728); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleProcedureCall


    // $ANTLR start ruleProcedureCall
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:898:1: ruleProcedureCall returns [EObject current=null] : ( ( (lv_procedure_0_0= ruleProcedure ) ) '(' ')' ) ;
    public final EObject ruleProcedureCall() throws RecognitionException {
        EObject current = null;

        EObject lv_procedure_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:903:6: ( ( ( (lv_procedure_0_0= ruleProcedure ) ) '(' ')' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:904:1: ( ( (lv_procedure_0_0= ruleProcedure ) ) '(' ')' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:904:1: ( ( (lv_procedure_0_0= ruleProcedure ) ) '(' ')' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:904:2: ( (lv_procedure_0_0= ruleProcedure ) ) '(' ')'
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:904:2: ( (lv_procedure_0_0= ruleProcedure ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:905:1: (lv_procedure_0_0= ruleProcedure )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:905:1: (lv_procedure_0_0= ruleProcedure )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:906:3: lv_procedure_0_0= ruleProcedure
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getProcedureCallAccess().getProcedureProcedureParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleProcedure_in_ruleProcedureCall1774);
            lv_procedure_0_0=ruleProcedure();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getProcedureCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"procedure",
            	        		lv_procedure_0_0, 
            	        		"Procedure", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleProcedureCall1784); 

                    createLeafNode(grammarAccess.getProcedureCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            match(input,17,FOLLOW_17_in_ruleProcedureCall1794); 

                    createLeafNode(grammarAccess.getProcedureCallAccess().getRightParenthesisKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleProcedureCall


    // $ANTLR start entryRuleProcedure
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:944:1: entryRuleProcedure returns [EObject current=null] : iv_ruleProcedure= ruleProcedure EOF ;
    public final EObject entryRuleProcedure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedure = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:945:2: (iv_ruleProcedure= ruleProcedure EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:946:2: iv_ruleProcedure= ruleProcedure EOF
            {
             currentNode = createCompositeNode(grammarAccess.getProcedureRule(), currentNode); 
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure1830);
            iv_ruleProcedure=ruleProcedure();
            _fsp--;

             current =iv_ruleProcedure; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure1840); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleProcedure


    // $ANTLR start ruleProcedure
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:953:1: ruleProcedure returns [EObject current=null] : ( (lv_identifier_0_0= RULE_ID ) ) ;
    public final EObject ruleProcedure() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:958:6: ( ( (lv_identifier_0_0= RULE_ID ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:959:1: ( (lv_identifier_0_0= RULE_ID ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:959:1: ( (lv_identifier_0_0= RULE_ID ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:960:1: (lv_identifier_0_0= RULE_ID )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:960:1: (lv_identifier_0_0= RULE_ID )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:961:3: lv_identifier_0_0= RULE_ID
            {
            lv_identifier_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcedure1881); 

            			createLeafNode(grammarAccess.getProcedureAccess().getIdentifierIDTerminalRuleCall_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getProcedureRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_0_0, 
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
    // $ANTLR end ruleProcedure


    // $ANTLR start entryRuleEventRaising
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:991:1: entryRuleEventRaising returns [EObject current=null] : iv_ruleEventRaising= ruleEventRaising EOF ;
    public final EObject entryRuleEventRaising() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRaising = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:992:2: (iv_ruleEventRaising= ruleEventRaising EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:993:2: iv_ruleEventRaising= ruleEventRaising EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventRaisingRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventRaising_in_entryRuleEventRaising1921);
            iv_ruleEventRaising=ruleEventRaising();
            _fsp--;

             current =iv_ruleEventRaising; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRaising1931); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEventRaising


    // $ANTLR start ruleEventRaising
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1000:1: ruleEventRaising returns [EObject current=null] : ( 'raise' '(' ( (lv_event_2_0= ruleSignalEvent ) ) ')' ) ;
    public final EObject ruleEventRaising() throws RecognitionException {
        EObject current = null;

        EObject lv_event_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1005:6: ( ( 'raise' '(' ( (lv_event_2_0= ruleSignalEvent ) ) ')' ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1006:1: ( 'raise' '(' ( (lv_event_2_0= ruleSignalEvent ) ) ')' )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1006:1: ( 'raise' '(' ( (lv_event_2_0= ruleSignalEvent ) ) ')' )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1006:3: 'raise' '(' ( (lv_event_2_0= ruleSignalEvent ) ) ')'
            {
            match(input,20,FOLLOW_20_in_ruleEventRaising1966); 

                    createLeafNode(grammarAccess.getEventRaisingAccess().getRaiseKeyword_0(), null); 
                
            match(input,16,FOLLOW_16_in_ruleEventRaising1976); 

                    createLeafNode(grammarAccess.getEventRaisingAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1014:1: ( (lv_event_2_0= ruleSignalEvent ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1015:1: (lv_event_2_0= ruleSignalEvent )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1015:1: (lv_event_2_0= ruleSignalEvent )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1016:3: lv_event_2_0= ruleSignalEvent
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEventRaisingAccess().getEventSignalEventParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSignalEvent_in_ruleEventRaising1997);
            lv_event_2_0=ruleSignalEvent();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEventRaisingRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"event",
            	        		lv_event_2_0, 
            	        		"SignalEvent", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleEventRaising2007); 

                    createLeafNode(grammarAccess.getEventRaisingAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEventRaising


    // $ANTLR start entryRuleBooleanOrExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1050:1: entryRuleBooleanOrExpression returns [EObject current=null] : iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF ;
    public final EObject entryRuleBooleanOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOrExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1051:2: (iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1052:2: iv_ruleBooleanOrExpression= ruleBooleanOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanOrExpression_in_entryRuleBooleanOrExpression2043);
            iv_ruleBooleanOrExpression=ruleBooleanOrExpression();
            _fsp--;

             current =iv_ruleBooleanOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanOrExpression2053); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanOrExpression


    // $ANTLR start ruleBooleanOrExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1059:1: ruleBooleanOrExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleBooleanAndExpression ) ) ( '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) ) )* ) ;
    public final EObject ruleBooleanOrExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1064:6: ( ( ( (lv_operand1_0_0= ruleBooleanAndExpression ) ) ( '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1065:1: ( ( (lv_operand1_0_0= ruleBooleanAndExpression ) ) ( '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1065:1: ( ( (lv_operand1_0_0= ruleBooleanAndExpression ) ) ( '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1065:2: ( (lv_operand1_0_0= ruleBooleanAndExpression ) ) ( '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1065:2: ( (lv_operand1_0_0= ruleBooleanAndExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1066:1: (lv_operand1_0_0= ruleBooleanAndExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1066:1: (lv_operand1_0_0= ruleBooleanAndExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1067:3: lv_operand1_0_0= ruleBooleanAndExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanOrExpressionAccess().getOperand1BooleanAndExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2099);
            lv_operand1_0_0=ruleBooleanAndExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanOrExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"BooleanAndExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1089:2: ( '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1089:4: '||' ( (lv_operand2_2_0= ruleBooleanAndExpression ) )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleBooleanOrExpression2110); 

            	            createLeafNode(grammarAccess.getBooleanOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1093:1: ( (lv_operand2_2_0= ruleBooleanAndExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1094:1: (lv_operand2_2_0= ruleBooleanAndExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1094:1: (lv_operand2_2_0= ruleBooleanAndExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1095:3: lv_operand2_2_0= ruleBooleanAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBooleanOrExpressionAccess().getOperand2BooleanAndExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2131);
            	    lv_operand2_2_0=ruleBooleanAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBooleanOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"BooleanAndExpression", 
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


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanOrExpression


    // $ANTLR start entryRuleBooleanAndExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1125:1: entryRuleBooleanAndExpression returns [EObject current=null] : iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF ;
    public final EObject entryRuleBooleanAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAndExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1126:2: (iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1127:2: iv_ruleBooleanAndExpression= ruleBooleanAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanAndExpression_in_entryRuleBooleanAndExpression2169);
            iv_ruleBooleanAndExpression=ruleBooleanAndExpression();
            _fsp--;

             current =iv_ruleBooleanAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAndExpression2179); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanAndExpression


    // $ANTLR start ruleBooleanAndExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1134:1: ruleBooleanAndExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleBitwiseXorExpression ) ) ( '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) ) )* ) ;
    public final EObject ruleBooleanAndExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1139:6: ( ( ( (lv_operand1_0_0= ruleBitwiseXorExpression ) ) ( '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1140:1: ( ( (lv_operand1_0_0= ruleBitwiseXorExpression ) ) ( '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1140:1: ( ( (lv_operand1_0_0= ruleBitwiseXorExpression ) ) ( '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1140:2: ( (lv_operand1_0_0= ruleBitwiseXorExpression ) ) ( '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1140:2: ( (lv_operand1_0_0= ruleBitwiseXorExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1141:1: (lv_operand1_0_0= ruleBitwiseXorExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1141:1: (lv_operand1_0_0= ruleBitwiseXorExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1142:3: lv_operand1_0_0= ruleBitwiseXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAndExpressionAccess().getOperand1BitwiseXorExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2225);
            lv_operand1_0_0=ruleBitwiseXorExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAndExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"BitwiseXorExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1164:2: ( '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1164:4: '&&' ( (lv_operand2_2_0= ruleBitwiseXorExpression ) )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleBooleanAndExpression2236); 

            	            createLeafNode(grammarAccess.getBooleanAndExpressionAccess().getAmpersandAmpersandKeyword_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1168:1: ( (lv_operand2_2_0= ruleBitwiseXorExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1169:1: (lv_operand2_2_0= ruleBitwiseXorExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1169:1: (lv_operand2_2_0= ruleBitwiseXorExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1170:3: lv_operand2_2_0= ruleBitwiseXorExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBooleanAndExpressionAccess().getOperand2BitwiseXorExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2257);
            	    lv_operand2_2_0=ruleBitwiseXorExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBooleanAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"BitwiseXorExpression", 
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


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanAndExpression


    // $ANTLR start entryRuleBitwiseXorExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1200:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1201:2: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1202:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBitwiseXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression2295);
            iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression();
            _fsp--;

             current =iv_ruleBitwiseXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseXorExpression2305); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBitwiseXorExpression


    // $ANTLR start ruleBitwiseXorExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1209:1: ruleBitwiseXorExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleBitwiseOrExpression ) ) ( '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1214:6: ( ( ( (lv_operand1_0_0= ruleBitwiseOrExpression ) ) ( '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1215:1: ( ( (lv_operand1_0_0= ruleBitwiseOrExpression ) ) ( '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1215:1: ( ( (lv_operand1_0_0= ruleBitwiseOrExpression ) ) ( '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1215:2: ( (lv_operand1_0_0= ruleBitwiseOrExpression ) ) ( '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1215:2: ( (lv_operand1_0_0= ruleBitwiseOrExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1216:1: (lv_operand1_0_0= ruleBitwiseOrExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1216:1: (lv_operand1_0_0= ruleBitwiseOrExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1217:3: lv_operand1_0_0= ruleBitwiseOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getOperand1BitwiseOrExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2351);
            lv_operand1_0_0=ruleBitwiseOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBitwiseXorExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"BitwiseOrExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1239:2: ( '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1239:4: '^' ( (lv_operand2_2_0= ruleBitwiseOrExpression ) )
            	    {
            	    match(input,23,FOLLOW_23_in_ruleBitwiseXorExpression2362); 

            	            createLeafNode(grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1243:1: ( (lv_operand2_2_0= ruleBitwiseOrExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1244:1: (lv_operand2_2_0= ruleBitwiseOrExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1244:1: (lv_operand2_2_0= ruleBitwiseOrExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1245:3: lv_operand2_2_0= ruleBitwiseOrExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getOperand2BitwiseOrExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2383);
            	    lv_operand2_2_0=ruleBitwiseOrExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBitwiseXorExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"BitwiseOrExpression", 
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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBitwiseXorExpression


    // $ANTLR start entryRuleBitwiseOrExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1275:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1276:2: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1277:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBitwiseOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression2421);
            iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression();
            _fsp--;

             current =iv_ruleBitwiseOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpression2431); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBitwiseOrExpression


    // $ANTLR start ruleBitwiseOrExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1284:1: ruleBitwiseOrExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleBitwiseAndExpression ) ) ( '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1289:6: ( ( ( (lv_operand1_0_0= ruleBitwiseAndExpression ) ) ( '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1290:1: ( ( (lv_operand1_0_0= ruleBitwiseAndExpression ) ) ( '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1290:1: ( ( (lv_operand1_0_0= ruleBitwiseAndExpression ) ) ( '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1290:2: ( (lv_operand1_0_0= ruleBitwiseAndExpression ) ) ( '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1290:2: ( (lv_operand1_0_0= ruleBitwiseAndExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1291:1: (lv_operand1_0_0= ruleBitwiseAndExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1291:1: (lv_operand1_0_0= ruleBitwiseAndExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1292:3: lv_operand1_0_0= ruleBitwiseAndExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getOperand1BitwiseAndExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2477);
            lv_operand1_0_0=ruleBitwiseAndExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBitwiseOrExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"BitwiseAndExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1314:2: ( '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1314:4: '|' ( (lv_operand2_2_0= ruleBitwiseAndExpression ) )
            	    {
            	    match(input,24,FOLLOW_24_in_ruleBitwiseOrExpression2488); 

            	            createLeafNode(grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1318:1: ( (lv_operand2_2_0= ruleBitwiseAndExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1319:1: (lv_operand2_2_0= ruleBitwiseAndExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1319:1: (lv_operand2_2_0= ruleBitwiseAndExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1320:3: lv_operand2_2_0= ruleBitwiseAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getOperand2BitwiseAndExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2509);
            	    lv_operand2_2_0=ruleBitwiseAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBitwiseOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"BitwiseAndExpression", 
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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBitwiseOrExpression


    // $ANTLR start entryRuleBitwiseAndExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1350:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1351:2: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1352:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBitwiseAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression2547);
            iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression();
            _fsp--;

             current =iv_ruleBitwiseAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpression2557); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBitwiseAndExpression


    // $ANTLR start ruleBitwiseAndExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1359:1: ruleBitwiseAndExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleEqualityExpression ) ) ( '&' ( (lv_operand2_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1364:6: ( ( ( (lv_operand1_0_0= ruleEqualityExpression ) ) ( '&' ( (lv_operand2_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1365:1: ( ( (lv_operand1_0_0= ruleEqualityExpression ) ) ( '&' ( (lv_operand2_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1365:1: ( ( (lv_operand1_0_0= ruleEqualityExpression ) ) ( '&' ( (lv_operand2_2_0= ruleEqualityExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1365:2: ( (lv_operand1_0_0= ruleEqualityExpression ) ) ( '&' ( (lv_operand2_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1365:2: ( (lv_operand1_0_0= ruleEqualityExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1366:1: (lv_operand1_0_0= ruleEqualityExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1366:1: (lv_operand1_0_0= ruleEqualityExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1367:3: lv_operand1_0_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getOperand1EqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2603);
            lv_operand1_0_0=ruleEqualityExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBitwiseAndExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"EqualityExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1389:2: ( '&' ( (lv_operand2_2_0= ruleEqualityExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1389:4: '&' ( (lv_operand2_2_0= ruleEqualityExpression ) )
            	    {
            	    match(input,25,FOLLOW_25_in_ruleBitwiseAndExpression2614); 

            	            createLeafNode(grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_0(), null); 
            	        
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1393:1: ( (lv_operand2_2_0= ruleEqualityExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1394:1: (lv_operand2_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1394:1: (lv_operand2_2_0= ruleEqualityExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1395:3: lv_operand2_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getOperand2EqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2635);
            	    lv_operand2_2_0=ruleEqualityExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBitwiseAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
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
            	    break loop13;
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
    // $ANTLR end ruleBitwiseAndExpression


    // $ANTLR start entryRuleEqualityExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1425:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1426:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1427:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression2673);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression2683); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1434:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleRelationalExpression ) ) ( ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1439:6: ( ( ( (lv_operand1_0_0= ruleRelationalExpression ) ) ( ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1440:1: ( ( (lv_operand1_0_0= ruleRelationalExpression ) ) ( ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1440:1: ( ( (lv_operand1_0_0= ruleRelationalExpression ) ) ( ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1440:2: ( (lv_operand1_0_0= ruleRelationalExpression ) ) ( ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1440:2: ( (lv_operand1_0_0= ruleRelationalExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1441:1: (lv_operand1_0_0= ruleRelationalExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1441:1: (lv_operand1_0_0= ruleRelationalExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1442:3: lv_operand1_0_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperand1RelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression2729);
            lv_operand1_0_0=ruleRelationalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"RelationalExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1464:2: ( ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=42 && LA14_0<=43)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1464:3: ( (lv_operator_1_0= ruleEqualityOperator ) ) ( (lv_operand2_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1464:3: ( (lv_operator_1_0= ruleEqualityOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1465:1: (lv_operator_1_0= ruleEqualityOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1465:1: (lv_operator_1_0= ruleEqualityOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1466:3: lv_operator_1_0= ruleEqualityOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression2751);
            	    lv_operator_1_0=ruleEqualityOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_1_0, 
            	    	        		"EqualityOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1488:2: ( (lv_operand2_2_0= ruleRelationalExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1489:1: (lv_operand2_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1489:1: (lv_operand2_2_0= ruleRelationalExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1490:3: lv_operand2_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperand2RelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression2772);
            	    lv_operand2_2_0=ruleRelationalExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
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

            	default :
            	    break loop14;
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
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1520:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1521:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1522:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression2810);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression2820); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1529:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleShiftExpression ) ) ( ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1534:6: ( ( ( (lv_operand1_0_0= ruleShiftExpression ) ) ( ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1535:1: ( ( (lv_operand1_0_0= ruleShiftExpression ) ) ( ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1535:1: ( ( (lv_operand1_0_0= ruleShiftExpression ) ) ( ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1535:2: ( (lv_operand1_0_0= ruleShiftExpression ) ) ( ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1535:2: ( (lv_operand1_0_0= ruleShiftExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1536:1: (lv_operand1_0_0= ruleShiftExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1536:1: (lv_operand1_0_0= ruleShiftExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1537:3: lv_operand1_0_0= ruleShiftExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperand1ShiftExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression2866);
            lv_operand1_0_0=ruleShiftExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"ShiftExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1559:2: ( ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=44 && LA15_0<=47)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1559:3: ( (lv_operator_1_0= ruleRelationalOperator ) ) ( (lv_operand2_2_0= ruleShiftExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1559:3: ( (lv_operator_1_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1560:1: (lv_operator_1_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1560:1: (lv_operator_1_0= ruleRelationalOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1561:3: lv_operator_1_0= ruleRelationalOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression2888);
            	    lv_operator_1_0=ruleRelationalOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_1_0, 
            	    	        		"RelationalOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1583:2: ( (lv_operand2_2_0= ruleShiftExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1584:1: (lv_operand2_2_0= ruleShiftExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1584:1: (lv_operand2_2_0= ruleShiftExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1585:3: lv_operand2_2_0= ruleShiftExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperand2ShiftExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression2909);
            	    lv_operand2_2_0=ruleShiftExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"ShiftExpression", 
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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start entryRuleConditionalExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1615:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1616:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1617:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression2947);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression2957); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1624:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleBooleanOrExpression ) ) ( '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        EObject lv_operand2_2_0 = null;

        EObject lv_operand3_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1629:6: ( ( ( (lv_operand1_0_0= ruleBooleanOrExpression ) ) ( '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) ) )? ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1630:1: ( ( (lv_operand1_0_0= ruleBooleanOrExpression ) ) ( '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) ) )? )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1630:1: ( ( (lv_operand1_0_0= ruleBooleanOrExpression ) ) ( '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) ) )? )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1630:2: ( (lv_operand1_0_0= ruleBooleanOrExpression ) ) ( '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) ) )?
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1630:2: ( (lv_operand1_0_0= ruleBooleanOrExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1631:1: (lv_operand1_0_0= ruleBooleanOrExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1631:1: (lv_operand1_0_0= ruleBooleanOrExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1632:3: lv_operand1_0_0= ruleBooleanOrExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand1BooleanOrExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOrExpression_in_ruleConditionalExpression3003);
            lv_operand1_0_0=ruleBooleanOrExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"BooleanOrExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1654:2: ( '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1654:4: '?' ( (lv_operand2_2_0= ruleShiftExpression ) ) ':' ( (lv_operand3_4_0= ruleShiftExpression ) )
                    {
                    match(input,26,FOLLOW_26_in_ruleConditionalExpression3014); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_0(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1658:1: ( (lv_operand2_2_0= ruleShiftExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1659:1: (lv_operand2_2_0= ruleShiftExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1659:1: (lv_operand2_2_0= ruleShiftExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1660:3: lv_operand2_2_0= ruleShiftExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand2ShiftExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3035);
                    lv_operand2_2_0=ruleShiftExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operand2",
                    	        		lv_operand2_2_0, 
                    	        		"ShiftExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleConditionalExpression3045); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1686:1: ( (lv_operand3_4_0= ruleShiftExpression ) )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1687:1: (lv_operand3_4_0= ruleShiftExpression )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1687:1: (lv_operand3_4_0= ruleShiftExpression )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1688:3: lv_operand3_4_0= ruleShiftExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand3ShiftExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3066);
                    lv_operand3_4_0=ruleShiftExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operand3",
                    	        		lv_operand3_4_0, 
                    	        		"ShiftExpression", 
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
    // $ANTLR end ruleConditionalExpression


    // $ANTLR start entryRuleShiftExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1718:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1719:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1720:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getShiftExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression3104);
            iv_ruleShiftExpression=ruleShiftExpression();
            _fsp--;

             current =iv_ruleShiftExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression3114); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleShiftExpression


    // $ANTLR start ruleShiftExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1727:1: ruleShiftExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleAdditiveExpression ) ) ( ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1732:6: ( ( ( (lv_operand1_0_0= ruleAdditiveExpression ) ) ( ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1733:1: ( ( (lv_operand1_0_0= ruleAdditiveExpression ) ) ( ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1733:1: ( ( (lv_operand1_0_0= ruleAdditiveExpression ) ) ( ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1733:2: ( (lv_operand1_0_0= ruleAdditiveExpression ) ) ( ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1733:2: ( (lv_operand1_0_0= ruleAdditiveExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1734:1: (lv_operand1_0_0= ruleAdditiveExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1734:1: (lv_operand1_0_0= ruleAdditiveExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1735:3: lv_operand1_0_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getShiftExpressionAccess().getOperand1AdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3160);
            lv_operand1_0_0=ruleAdditiveExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getShiftExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"AdditiveExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1757:2: ( ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=48 && LA17_0<=49)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1757:3: ( (lv_operator_1_0= ruleShiftOperator ) ) ( (lv_operand2_2_0= ruleAdditiveExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1757:3: ( (lv_operator_1_0= ruleShiftOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1758:1: (lv_operator_1_0= ruleShiftOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1758:1: (lv_operator_1_0= ruleShiftOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1759:3: lv_operator_1_0= ruleShiftOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpression3182);
            	    lv_operator_1_0=ruleShiftOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getShiftExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_1_0, 
            	    	        		"ShiftOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1781:2: ( (lv_operand2_2_0= ruleAdditiveExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1782:1: (lv_operand2_2_0= ruleAdditiveExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1782:1: (lv_operand2_2_0= ruleAdditiveExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1783:3: lv_operand2_2_0= ruleAdditiveExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getShiftExpressionAccess().getOperand2AdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3203);
            	    lv_operand2_2_0=ruleAdditiveExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getShiftExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"AdditiveExpression", 
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
            	    break loop17;
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
    // $ANTLR end ruleShiftExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1813:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1814:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1815:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression3241);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression3251); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1822:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1827:6: ( ( ( (lv_operand1_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1828:1: ( ( (lv_operand1_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1828:1: ( ( (lv_operand1_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1828:2: ( (lv_operand1_0_0= ruleMultiplicativeExpression ) ) ( ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1828:2: ( (lv_operand1_0_0= ruleMultiplicativeExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1829:1: (lv_operand1_0_0= ruleMultiplicativeExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1829:1: (lv_operand1_0_0= ruleMultiplicativeExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1830:3: lv_operand1_0_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperand1MultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3297);
            lv_operand1_0_0=ruleMultiplicativeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"MultiplicativeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1852:2: ( ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=50 && LA18_0<=51)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1852:3: ( (lv_operator_1_0= ruleAdditiveOperator ) ) ( (lv_operand2_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1852:3: ( (lv_operator_1_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1853:1: (lv_operator_1_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1853:1: (lv_operator_1_0= ruleAdditiveOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1854:3: lv_operator_1_0= ruleAdditiveOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpression3319);
            	    lv_operator_1_0=ruleAdditiveOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_1_0, 
            	    	        		"AdditiveOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1876:2: ( (lv_operand2_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1877:1: (lv_operand2_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1877:1: (lv_operand2_2_0= ruleMultiplicativeExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1878:3: lv_operand2_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperand2MultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3340);
            	    lv_operand2_2_0=ruleMultiplicativeExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
            	    	        		"MultiplicativeExpression", 
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
            	    break loop18;
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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1908:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1909:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1910:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression3378);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression3388); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1917:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_operand1_0_0= ruleUnaryExpression ) ) ( ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand1_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_operand2_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1922:6: ( ( ( (lv_operand1_0_0= ruleUnaryExpression ) ) ( ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1923:1: ( ( (lv_operand1_0_0= ruleUnaryExpression ) ) ( ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1923:1: ( ( (lv_operand1_0_0= ruleUnaryExpression ) ) ( ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) ) )* )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1923:2: ( (lv_operand1_0_0= ruleUnaryExpression ) ) ( ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1923:2: ( (lv_operand1_0_0= ruleUnaryExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1924:1: (lv_operand1_0_0= ruleUnaryExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1924:1: (lv_operand1_0_0= ruleUnaryExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1925:3: lv_operand1_0_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperand1UnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression3434);
            lv_operand1_0_0=ruleUnaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand1",
            	        		lv_operand1_0_0, 
            	        		"UnaryExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1947:2: ( ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=52 && LA19_0<=54)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1947:3: ( (lv_operator_1_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1947:3: ( (lv_operator_1_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1948:1: (lv_operator_1_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1948:1: (lv_operator_1_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1949:3: lv_operator_1_0= ruleMultiplicativeOperator
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpression3456);
            	    lv_operator_1_0=ruleMultiplicativeOperator();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operator",
            	    	        		lv_operator_1_0, 
            	    	        		"MultiplicativeOperator", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1971:2: ( (lv_operand2_2_0= ruleUnaryExpression ) )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1972:1: (lv_operand2_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1972:1: (lv_operand2_2_0= ruleUnaryExpression )
            	    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:1973:3: lv_operand2_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperand2UnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression3477);
            	    lv_operand2_2_0=ruleUnaryExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"operand2",
            	    	        		lv_operand2_2_0, 
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

            	default :
            	    break loop19;
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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2003:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2004:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2005:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression3515);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression3525); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2012:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_operator_0_0= ruleUnaryOperator ) )? ( (lv_operand_1_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2017:6: ( ( ( (lv_operator_0_0= ruleUnaryOperator ) )? ( (lv_operand_1_0= rulePrimaryExpression ) ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2018:1: ( ( (lv_operator_0_0= ruleUnaryOperator ) )? ( (lv_operand_1_0= rulePrimaryExpression ) ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2018:1: ( ( (lv_operator_0_0= ruleUnaryOperator ) )? ( (lv_operand_1_0= rulePrimaryExpression ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2018:2: ( (lv_operator_0_0= ruleUnaryOperator ) )? ( (lv_operand_1_0= rulePrimaryExpression ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2018:2: ( (lv_operator_0_0= ruleUnaryOperator ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=50 && LA20_0<=51)||(LA20_0>=55 && LA20_0<=56)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2019:1: (lv_operator_0_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2019:1: (lv_operator_0_0= ruleUnaryOperator )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2020:3: lv_operator_0_0= ruleUnaryOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression3571);
                    lv_operator_0_0=ruleUnaryOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_0_0, 
                    	        		"UnaryOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2042:3: ( (lv_operand_1_0= rulePrimaryExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2043:1: (lv_operand_1_0= rulePrimaryExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2043:1: (lv_operand_1_0= rulePrimaryExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2044:3: lv_operand_1_0= rulePrimaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression3593);
            lv_operand_1_0=rulePrimaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_1_0, 
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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start entryRulePrimaryExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2074:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2075:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2076:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3629);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3639); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2083:1: rulePrimaryExpression returns [EObject current=null] : (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_VariableReference_0 = null;

        EObject this_LiteralValue_1 = null;

        EObject this_NestedExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2088:6: ( (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2089:1: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2089:1: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 18:
                {
                alt21=1;
                }
                break;
            case RULE_INT:
            case RULE_HEX_LITERAL:
            case RULE_BOOLEAN_LITERAL:
            case RULE_STRING:
            case RULE_FLOATING_POINT_LITERAL:
                {
                alt21=2;
                }
                break;
            case 16:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2089:1: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue | ( '(' this_NestedExpression_3= ruleNestedExpression ')' ) )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2090:5: this_VariableReference_0= ruleVariableReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVariableReferenceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableReference_in_rulePrimaryExpression3686);
                    this_VariableReference_0=ruleVariableReference();
                    _fsp--;

                     
                            current = this_VariableReference_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2100:5: this_LiteralValue_1= ruleLiteralValue
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralValueParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteralValue_in_rulePrimaryExpression3713);
                    this_LiteralValue_1=ruleLiteralValue();
                    _fsp--;

                     
                            current = this_LiteralValue_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2109:6: ( '(' this_NestedExpression_3= ruleNestedExpression ')' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2109:6: ( '(' this_NestedExpression_3= ruleNestedExpression ')' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2109:8: '(' this_NestedExpression_3= ruleNestedExpression ')'
                    {
                    match(input,16,FOLLOW_16_in_rulePrimaryExpression3729); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestedExpressionParserRuleCall_2_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNestedExpression_in_rulePrimaryExpression3751);
                    this_NestedExpression_3=ruleNestedExpression();
                    _fsp--;

                     
                            current = this_NestedExpression_3; 
                            currentNode = currentNode.getParent();
                        
                    match(input,17,FOLLOW_17_in_rulePrimaryExpression3760); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

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


    // $ANTLR start entryRuleNestedExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2134:1: entryRuleNestedExpression returns [EObject current=null] : iv_ruleNestedExpression= ruleNestedExpression EOF ;
    public final EObject entryRuleNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpression = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2135:2: (iv_ruleNestedExpression= ruleNestedExpression EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2136:2: iv_ruleNestedExpression= ruleNestedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedExpression_in_entryRuleNestedExpression3797);
            iv_ruleNestedExpression=ruleNestedExpression();
            _fsp--;

             current =iv_ruleNestedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedExpression3807); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNestedExpression


    // $ANTLR start ruleNestedExpression
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2143:1: ruleNestedExpression returns [EObject current=null] : ( (lv_expression_0_0= ruleConditionalExpression ) ) ;
    public final EObject ruleNestedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2148:6: ( ( (lv_expression_0_0= ruleConditionalExpression ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2149:1: ( (lv_expression_0_0= ruleConditionalExpression ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2149:1: ( (lv_expression_0_0= ruleConditionalExpression ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2150:1: (lv_expression_0_0= ruleConditionalExpression )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2150:1: (lv_expression_0_0= ruleConditionalExpression )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2151:3: lv_expression_0_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNestedExpressionAccess().getExpressionConditionalExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleNestedExpression3852);
            lv_expression_0_0=ruleConditionalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNestedExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_0_0, 
            	        		"ConditionalExpression", 
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
    // $ANTLR end ruleNestedExpression


    // $ANTLR start entryRuleLiteralValue
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2181:1: entryRuleLiteralValue returns [EObject current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final EObject entryRuleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValue = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2182:2: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2183:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue3887);
            iv_ruleLiteralValue=ruleLiteralValue();
            _fsp--;

             current =iv_ruleLiteralValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue3897); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLiteralValue


    // $ANTLR start ruleLiteralValue
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2190:1: ruleLiteralValue returns [EObject current=null] : ( (lv_value_0_0= ruleLiteral ) ) ;
    public final EObject ruleLiteralValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2195:6: ( ( (lv_value_0_0= ruleLiteral ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2196:1: ( (lv_value_0_0= ruleLiteral ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2196:1: ( (lv_value_0_0= ruleLiteral ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2197:1: (lv_value_0_0= ruleLiteral )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2197:1: (lv_value_0_0= ruleLiteral )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2198:3: lv_value_0_0= ruleLiteral
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLiteralValueAccess().getValueLiteralParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLiteral_in_ruleLiteralValue3942);
            lv_value_0_0=ruleLiteral();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLiteralValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"Literal", 
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
    // $ANTLR end ruleLiteralValue


    // $ANTLR start entryRuleLiteral
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2228:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2229:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2230:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3978);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3989); 

            }

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2237:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_LITERAL_0=null;
        Token this_BOOLEAN_LITERAL_1=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;
        Token this_FLOATING_POINT_LITERAL_4=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2242:6: ( (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2243:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2243:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL )
            int alt22=5;
            switch ( input.LA(1) ) {
            case RULE_HEX_LITERAL:
                {
                alt22=1;
                }
                break;
            case RULE_BOOLEAN_LITERAL:
                {
                alt22=2;
                }
                break;
            case RULE_INT:
                {
                alt22=3;
                }
                break;
            case RULE_STRING:
                {
                alt22=4;
                }
                break;
            case RULE_FLOATING_POINT_LITERAL:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2243:1: (this_HEX_LITERAL_0= RULE_HEX_LITERAL | this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL | this_INT_2= RULE_INT | this_STRING_3= RULE_STRING | this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2243:6: this_HEX_LITERAL_0= RULE_HEX_LITERAL
                    {
                    this_HEX_LITERAL_0=(Token)input.LT(1);
                    match(input,RULE_HEX_LITERAL,FOLLOW_RULE_HEX_LITERAL_in_ruleLiteral4029); 

                    		current.merge(this_HEX_LITERAL_0);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getHEX_LITERALTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2251:10: this_BOOLEAN_LITERAL_1= RULE_BOOLEAN_LITERAL
                    {
                    this_BOOLEAN_LITERAL_1=(Token)input.LT(1);
                    match(input,RULE_BOOLEAN_LITERAL,FOLLOW_RULE_BOOLEAN_LITERAL_in_ruleLiteral4055); 

                    		current.merge(this_BOOLEAN_LITERAL_1);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getBOOLEAN_LITERALTerminalRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2259:10: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral4081); 

                    		current.merge(this_INT_2);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_2(), null); 
                        

                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2267:10: this_STRING_3= RULE_STRING
                    {
                    this_STRING_3=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteral4107); 

                    		current.merge(this_STRING_3);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_3(), null); 
                        

                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2275:10: this_FLOATING_POINT_LITERAL_4= RULE_FLOATING_POINT_LITERAL
                    {
                    this_FLOATING_POINT_LITERAL_4=(Token)input.LT(1);
                    match(input,RULE_FLOATING_POINT_LITERAL,FOLLOW_RULE_FLOATING_POINT_LITERAL_in_ruleLiteral4133); 

                    		current.merge(this_FLOATING_POINT_LITERAL_4);
                        
                     
                        createLeafNode(grammarAccess.getLiteralAccess().getFLOATING_POINT_LITERALTerminalRuleCall_4(), null); 
                        

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


    // $ANTLR start ruleTimeUnit
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2290:1: ruleTimeUnit returns [Enumerator current=null] : ( ( 's' ) | ( 'ms' ) | ( 'ns' ) ) ;
    public final Enumerator ruleTimeUnit() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2294:6: ( ( ( 's' ) | ( 'ms' ) | ( 'ns' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2295:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2295:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt23=1;
                }
                break;
            case 29:
                {
                alt23=2;
                }
                break;
            case 30:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2295:1: ( ( 's' ) | ( 'ms' ) | ( 'ns' ) )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2295:2: ( 's' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2295:2: ( 's' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2295:4: 's'
                    {
                    match(input,28,FOLLOW_28_in_ruleTimeUnit4190); 

                            current = grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getSecondEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2301:6: ( 'ms' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2301:6: ( 'ms' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2301:8: 'ms'
                    {
                    match(input,29,FOLLOW_29_in_ruleTimeUnit4205); 

                            current = grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTimeUnitAccess().getMillisecondEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2307:6: ( 'ns' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2307:6: ( 'ns' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2307:8: 'ns'
                    {
                    match(input,30,FOLLOW_30_in_ruleTimeUnit4220); 

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


    // $ANTLR start ruleAssignmentOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2317:1: ruleAssignmentOperator returns [Enumerator current=null] : ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) ) ;
    public final Enumerator ruleAssignmentOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2321:6: ( ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2322:1: ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2322:1: ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) )
            int alt24=11;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt24=1;
                }
                break;
            case 32:
                {
                alt24=2;
                }
                break;
            case 33:
                {
                alt24=3;
                }
                break;
            case 34:
                {
                alt24=4;
                }
                break;
            case 35:
                {
                alt24=5;
                }
                break;
            case 36:
                {
                alt24=6;
                }
                break;
            case 37:
                {
                alt24=7;
                }
                break;
            case 38:
                {
                alt24=8;
                }
                break;
            case 39:
                {
                alt24=9;
                }
                break;
            case 40:
                {
                alt24=10;
                }
                break;
            case 41:
                {
                alt24=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2322:1: ( ( '=' ) | ( '*=' ) | ( '/=' ) | ( '%=' ) | ( '+=' ) | ( '-=' ) | ( '<<=' ) | ( '>>=' ) | ( '&=' ) | ( '^=' ) | ( '|=' ) )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2322:2: ( '=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2322:2: ( '=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2322:4: '='
                    {
                    match(input,31,FOLLOW_31_in_ruleAssignmentOperator4263); 

                            current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2328:6: ( '*=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2328:6: ( '*=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2328:8: '*='
                    {
                    match(input,32,FOLLOW_32_in_ruleAssignmentOperator4278); 

                            current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2334:6: ( '/=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2334:6: ( '/=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2334:8: '/='
                    {
                    match(input,33,FOLLOW_33_in_ruleAssignmentOperator4293); 

                            current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2340:6: ( '%=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2340:6: ( '%=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2340:8: '%='
                    {
                    match(input,34,FOLLOW_34_in_ruleAssignmentOperator4308); 

                            current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:6: ( '+=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:6: ( '+=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2346:8: '+='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignmentOperator4323); 

                            current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2352:6: ( '-=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2352:6: ( '-=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2352:8: '-='
                    {
                    match(input,36,FOLLOW_36_in_ruleAssignmentOperator4338); 

                            current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2358:6: ( '<<=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2358:6: ( '<<=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2358:8: '<<='
                    {
                    match(input,37,FOLLOW_37_in_ruleAssignmentOperator4353); 

                            current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2364:6: ( '>>=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2364:6: ( '>>=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2364:8: '>>='
                    {
                    match(input,38,FOLLOW_38_in_ruleAssignmentOperator4368); 

                            current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2370:6: ( '&=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2370:6: ( '&=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2370:8: '&='
                    {
                    match(input,39,FOLLOW_39_in_ruleAssignmentOperator4383); 

                            current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2376:6: ( '^=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2376:6: ( '^=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2376:8: '^='
                    {
                    match(input,40,FOLLOW_40_in_ruleAssignmentOperator4398); 

                            current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2382:6: ( '|=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2382:6: ( '|=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2382:8: '|='
                    {
                    match(input,41,FOLLOW_41_in_ruleAssignmentOperator4413); 

                            current = grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10(), null); 
                        

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
    // $ANTLR end ruleAssignmentOperator


    // $ANTLR start ruleEqualityOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2392:1: ruleEqualityOperator returns [Enumerator current=null] : ( ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2396:6: ( ( ( '==' ) | ( '!=' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2397:1: ( ( '==' ) | ( '!=' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2397:1: ( ( '==' ) | ( '!=' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==42) ) {
                alt25=1;
            }
            else if ( (LA25_0==43) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2397:1: ( ( '==' ) | ( '!=' ) )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2397:2: ( '==' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2397:2: ( '==' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2397:4: '=='
                    {
                    match(input,42,FOLLOW_42_in_ruleEqualityOperator4456); 

                            current = grammarAccess.getEqualityOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getEqualsEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2403:6: ( '!=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2403:6: ( '!=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2403:8: '!='
                    {
                    match(input,43,FOLLOW_43_in_ruleEqualityOperator4471); 

                            current = grammarAccess.getEqualityOperatorAccess().getNotEqualsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getNotEqualsEnumLiteralDeclaration_1(), null); 
                        

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2413:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2417:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2418:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2418:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt26=1;
                }
                break;
            case 45:
                {
                alt26=2;
                }
                break;
            case 46:
                {
                alt26=3;
                }
                break;
            case 47:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2418:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2418:2: ( '<' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2418:2: ( '<' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2418:4: '<'
                    {
                    match(input,44,FOLLOW_44_in_ruleRelationalOperator4514); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2424:6: ( '>' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2424:6: ( '>' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2424:8: '>'
                    {
                    match(input,45,FOLLOW_45_in_ruleRelationalOperator4529); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2430:6: ( '<=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2430:6: ( '<=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2430:8: '<='
                    {
                    match(input,46,FOLLOW_46_in_ruleRelationalOperator4544); 

                            current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2436:6: ( '>=' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2436:6: ( '>=' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2436:8: '>='
                    {
                    match(input,47,FOLLOW_47_in_ruleRelationalOperator4559); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

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


    // $ANTLR start ruleShiftOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2446:1: ruleShiftOperator returns [Enumerator current=null] : ( ( '<<' ) | ( '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2450:6: ( ( ( '<<' ) | ( '>>' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2451:1: ( ( '<<' ) | ( '>>' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2451:1: ( ( '<<' ) | ( '>>' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==48) ) {
                alt27=1;
            }
            else if ( (LA27_0==49) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2451:1: ( ( '<<' ) | ( '>>' ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2451:2: ( '<<' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2451:2: ( '<<' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2451:4: '<<'
                    {
                    match(input,48,FOLLOW_48_in_ruleShiftOperator4602); 

                            current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2457:6: ( '>>' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2457:6: ( '>>' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2457:8: '>>'
                    {
                    match(input,49,FOLLOW_49_in_ruleShiftOperator4617); 

                            current = grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleShiftOperator


    // $ANTLR start ruleAdditiveOperator
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2467:1: ruleAdditiveOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2471:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2472:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2472:1: ( ( '+' ) | ( '-' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            else if ( (LA28_0==51) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2472:1: ( ( '+' ) | ( '-' ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2472:2: ( '+' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2472:2: ( '+' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2472:4: '+'
                    {
                    match(input,50,FOLLOW_50_in_ruleAdditiveOperator4660); 

                            current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2478:6: ( '-' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2478:6: ( '-' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2478:8: '-'
                    {
                    match(input,51,FOLLOW_51_in_ruleAdditiveOperator4675); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2488:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2492:6: ( ( ( '*' ) | ( '/' ) | ( '%' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2493:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2493:1: ( ( '*' ) | ( '/' ) | ( '%' ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt29=1;
                }
                break;
            case 53:
                {
                alt29=2;
                }
                break;
            case 54:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2493:1: ( ( '*' ) | ( '/' ) | ( '%' ) )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2493:2: ( '*' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2493:2: ( '*' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2493:4: '*'
                    {
                    match(input,52,FOLLOW_52_in_ruleMultiplicativeOperator4718); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2499:6: ( '/' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2499:6: ( '/' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2499:8: '/'
                    {
                    match(input,53,FOLLOW_53_in_ruleMultiplicativeOperator4733); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2505:6: ( '%' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2505:6: ( '%' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2505:8: '%'
                    {
                    match(input,54,FOLLOW_54_in_ruleMultiplicativeOperator4748); 

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
    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2515:1: ruleUnaryOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2519:6: ( ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) ) )
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2520:1: ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) )
            {
            // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2520:1: ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt30=1;
                }
                break;
            case 51:
                {
                alt30=2;
                }
                break;
            case 55:
                {
                alt30=3;
                }
                break;
            case 56:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2520:1: ( ( '+' ) | ( '-' ) | ( '~' ) | ( '!' ) )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2520:2: ( '+' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2520:2: ( '+' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2520:4: '+'
                    {
                    match(input,50,FOLLOW_50_in_ruleUnaryOperator4791); 

                            current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2526:6: ( '-' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2526:6: ( '-' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2526:8: '-'
                    {
                    match(input,51,FOLLOW_51_in_ruleUnaryOperator4806); 

                            current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2532:6: ( '~' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2532:6: ( '~' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2532:8: '~'
                    {
                    match(input,55,FOLLOW_55_in_ruleUnaryOperator4821); 

                            current = grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2538:6: ( '!' )
                    {
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2538:6: ( '!' )
                    // ../org.yakindu.sct.statechart.expressions/src-gen/org/yakindu/sct/statechart/parser/antlr/internal/InternalExpressions.g:2538:8: '!'
                    {
                    match(input,56,FOLLOW_56_in_ruleUnaryOperator4836); 

                            current = grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration_3(), null); 
                        

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


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerExpression_in_ruleExpression132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardExpression_in_ruleExpression159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActionExpression_in_ruleExpression186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerExpression_in_entryRuleTriggerExpression221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerExpression231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggerExpression277 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTriggerExpression288 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleTrigger_in_ruleTriggerExpression309 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleGuardExpression_in_entryRuleGuardExpression347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardExpression357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOrExpression_in_ruleGuardExpression402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActionExpression_in_entryRuleActionExpression437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActionExpression447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleActionExpression492 = new BitSet(new long[]{0x0000000000140012L});
    public static final BitSet FOLLOW_ruleTrigger_in_entryRuleTrigger528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrigger538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleTrigger583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalEvent_in_ruleEvent675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEvent_in_ruleEvent702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignalEvent_in_entryRuleSignalEvent737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignalEvent747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignalEvent788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEvent_in_entryRuleTimeEvent828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEvent838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTimeEvent873 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTimeEvent883 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleTimeEvent904 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTimeEvent914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeConstant_in_ruleTimeExpression1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_ruleTimeExpression1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_entryRuleVariableReference1069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableReference1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableReference1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVariableReference1142 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVariableReference1152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableReference1173 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableReference1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeConstant_in_entryRuleTimeConstant1311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeConstant1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTimeConstant1363 = new BitSet(new long[]{0x0000000070000002L});
    public static final BitSet FOLLOW_ruleTimeUnit_in_ruleTimeConstant1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement1426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_ruleStatement1484 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleEventRaising_in_ruleStatement1511 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleProcedureCall_in_ruleStatement1538 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleStatement1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableAssignment_in_entryRuleVariableAssignment1584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableAssignment1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_ruleVariableAssignment1640 = new BitSet(new long[]{0x000003FF80000000L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleVariableAssignment1661 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleVariableAssignment1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedureCall_in_entryRuleProcedureCall1718 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedureCall1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_ruleProcedureCall1774 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleProcedureCall1784 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleProcedureCall1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure1830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcedure1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRaising_in_entryRuleEventRaising1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRaising1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleEventRaising1966 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEventRaising1976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSignalEvent_in_ruleEventRaising1997 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEventRaising2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOrExpression_in_entryRuleBooleanOrExpression2043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanOrExpression2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2099 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleBooleanOrExpression2110 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBooleanAndExpression_in_ruleBooleanOrExpression2131 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleBooleanAndExpression_in_entryRuleBooleanAndExpression2169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAndExpression2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2225 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleBooleanAndExpression2236 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleBooleanAndExpression2257 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression2295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseXorExpression2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2351 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleBitwiseXorExpression2362 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression2383 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression2421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpression2431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2477 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleBitwiseOrExpression2488 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression2509 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression2547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpression2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2603 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleBitwiseAndExpression2614 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleBitwiseAndExpression2635 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression2673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression2729 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression2751 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression2772 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression2810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression2866 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression2888 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression2909 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression2947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOrExpression_in_ruleConditionalExpression3003 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression3014 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3035 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConditionalExpression3045 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleConditionalExpression3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression3104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression3114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3160 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpression3182 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3203 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression3241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression3251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3297 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpression3319 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression3340 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression3378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression3434 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpression3456 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression3477 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression3515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression3571 = new BitSet(new long[]{0x00000000000503F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableReference_in_rulePrimaryExpression3686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_rulePrimaryExpression3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePrimaryExpression3729 = new BitSet(new long[]{0x018C0000000503F0L});
    public static final BitSet FOLLOW_ruleNestedExpression_in_rulePrimaryExpression3751 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulePrimaryExpression3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedExpression_in_entryRuleNestedExpression3797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpression3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleNestedExpression3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue3887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLiteralValue3942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_LITERAL_in_ruleLiteral4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_LITERAL_in_ruleLiteral4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral4107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOATING_POINT_LITERAL_in_ruleLiteral4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTimeUnit4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTimeUnit4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTimeUnit4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentOperator4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAssignmentOperator4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAssignmentOperator4293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleAssignmentOperator4308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAssignmentOperator4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAssignmentOperator4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAssignmentOperator4353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleAssignmentOperator4368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAssignmentOperator4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAssignmentOperator4398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAssignmentOperator4413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleEqualityOperator4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleEqualityOperator4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleRelationalOperator4514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelationalOperator4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator4544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelationalOperator4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleShiftOperator4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleShiftOperator4617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAdditiveOperator4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAdditiveOperator4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleMultiplicativeOperator4718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMultiplicativeOperator4733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleMultiplicativeOperator4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleUnaryOperator4791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleUnaryOperator4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnaryOperator4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUnaryOperator4836 = new BitSet(new long[]{0x0000000000000002L});

}