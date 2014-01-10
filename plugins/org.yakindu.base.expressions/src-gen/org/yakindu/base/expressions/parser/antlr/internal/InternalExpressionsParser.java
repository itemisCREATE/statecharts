package org.yakindu.base.expressions.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.yakindu.base.expressions.services.ExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOL", "RULE_INT", "RULE_FLOAT", "RULE_HEX", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "':'", "'||'", "'&&'", "'!'", "'^'", "'|'", "'&'", "'.'", "'('", "','", "')'", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_BOOL=5;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_HEX=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_FLOAT=7;
    public static final int RULE_SL_COMMENT=11;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=9;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=12;

    // delegates
    // delegators


        public InternalExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g"; }



     	private ExpressionsGrammarAccess grammarAccess;
     	
        public InternalExpressionsParser(TokenStream input, ExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Expression";	
       	}
       	
       	@Override
       	protected ExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:68:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:69:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:70:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression75);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:77:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:80:28: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:82:5: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleExpression131);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AssignmentExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:98:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:99:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:100:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression165);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:107:1: ruleAssignmentExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:110:28: ( (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:111:1: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:111:1: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:112:5: this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression222);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConditionalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:120:1: ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=26 && LA1_0<=36)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:120:2: () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:120:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:121:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:126:2: ( (lv_operator_2_0= ruleAssignmentOperator ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:127:1: (lv_operator_2_0= ruleAssignmentOperator )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:127:1: (lv_operator_2_0= ruleAssignmentOperator )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:128:3: lv_operator_2_0= ruleAssignmentOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpression252);
            	    lv_operator_2_0=ruleAssignmentOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"AssignmentOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:144:2: ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:145:1: (lv_expression_3_0= ruleConditionalExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:145:1: (lv_expression_3_0= ruleConditionalExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:146:3: lv_expression_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression273);
            	    lv_expression_3_0=ruleConditionalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"expression",
            	              		lv_expression_3_0, 
            	              		"ConditionalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:170:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:171:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:172:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression311);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression321); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:179:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_trueCase_3_0 = null;

        EObject lv_falseCase_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:182:28: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:183:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:183:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:184:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression368);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:192:1: ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:192:2: () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:192:2: ()
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:193:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConditionalExpression389); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:202:1: ( (lv_trueCase_3_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:203:1: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:203:1: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:204:3: lv_trueCase_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression410);
                    lv_trueCase_3_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"trueCase",
                              		lv_trueCase_3_0, 
                              		"LogicalOrExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConditionalExpression422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                          
                    }
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:224:1: ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:225:1: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:225:1: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:226:3: lv_falseCase_5_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression443);
                    lv_falseCase_5_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"falseCase",
                              		lv_falseCase_5_0, 
                              		"LogicalOrExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:250:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:251:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:252:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression481);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression491); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:259:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:262:28: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:263:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:263:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:264:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression538);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:272:1: ( () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:272:2: () otherlv_2= '||' ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:272:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:273:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleLogicalOrExpression559); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:282:1: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:283:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:283:1: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:284:3: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression580);
            	    lv_rightOperand_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"LogicalAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:308:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:309:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:310:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression618);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression628); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:317:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:320:28: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:321:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:321:1: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:322:5: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression675);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalNotExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:330:1: ( () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:330:2: () otherlv_2= '&&' ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:330:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:331:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleLogicalAndExpression696); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:340:1: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:341:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:341:1: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:342:3: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression717);
            	    lv_rightOperand_3_0=ruleLogicalNotExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"LogicalNotExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalNotExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:366:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:367:2: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:368:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression755);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalNotExpression765); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalNotExpression"


    // $ANTLR start "ruleLogicalNotExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:375:1: ruleLogicalNotExpression returns [EObject current=null] : (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseXorExpression_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:378:28: ( (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:379:1: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:379:1: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_STRING)||LA5_0==23||(LA5_0>=39 && LA5_0<=40)||LA5_0==44) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:380:5: this_BitwiseXorExpression_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression812);
                    this_BitwiseXorExpression_0=ruleBitwiseXorExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BitwiseXorExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:389:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:389:6: ( () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:389:7: () otherlv_2= '!' ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:389:7: ()
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:390:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleLogicalNotExpression839); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLogicalNotExpressionAccess().getExclamationMarkKeyword_1_1());
                          
                    }
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:399:1: ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:400:1: (lv_operand_3_0= ruleBitwiseXorExpression )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:400:1: (lv_operand_3_0= ruleBitwiseXorExpression )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:401:3: lv_operand_3_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression860);
                    lv_operand_3_0=ruleBitwiseXorExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLogicalNotExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_3_0, 
                              		"BitwiseXorExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalNotExpression"


    // $ANTLR start "entryRuleBitwiseXorExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:425:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:426:2: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:427:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseXorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression897);
            iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseXorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseXorExpression907); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseXorExpression"


    // $ANTLR start "ruleBitwiseXorExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:434:1: ruleBitwiseXorExpression returns [EObject current=null] : (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:437:28: ( (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:438:1: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:438:1: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:439:5: this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression954);
            this_BitwiseOrExpression_0=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:447:1: ( () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:447:2: () otherlv_2= '^' ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:447:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:448:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleBitwiseXorExpression975); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseXorExpressionAccess().getCircumflexAccentKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:457:1: ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:458:1: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:458:1: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:459:3: lv_rightOperand_3_0= ruleBitwiseOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression996);
            	    lv_rightOperand_3_0=ruleBitwiseOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBitwiseXorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"BitwiseOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseXorExpression"


    // $ANTLR start "entryRuleBitwiseOrExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:483:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:484:2: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:485:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression1034);
            iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpression1044); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseOrExpression"


    // $ANTLR start "ruleBitwiseOrExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:492:1: ruleBitwiseOrExpression returns [EObject current=null] : (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:495:28: ( (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:496:1: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:496:1: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:497:5: this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression1091);
            this_BitwiseAndExpression_0=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:505:1: ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:505:2: () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:505:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:506:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleBitwiseOrExpression1112); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseOrExpressionAccess().getVerticalLineKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:515:1: ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:516:1: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:516:1: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:517:3: lv_rightOperand_3_0= ruleBitwiseAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression1133);
            	    lv_rightOperand_3_0=ruleBitwiseAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBitwiseOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"BitwiseAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseOrExpression"


    // $ANTLR start "entryRuleBitwiseAndExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:541:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:542:2: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:543:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression1171);
            iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpression1181); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseAndExpression"


    // $ANTLR start "ruleBitwiseAndExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:550:1: ruleBitwiseAndExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:553:28: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:554:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:554:1: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:555:5: this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression1228);
            this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_LogicalRelationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:563:1: ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:563:2: () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:563:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:564:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleBitwiseAndExpression1249); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseAndExpressionAccess().getAmpersandKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:573:1: ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:574:1: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:574:1: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:575:3: lv_rightOperand_3_0= ruleLogicalRelationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression1270);
            	    lv_rightOperand_3_0=ruleLogicalRelationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBitwiseAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"LogicalRelationExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseAndExpression"


    // $ANTLR start "entryRuleLogicalRelationExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:599:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:600:2: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:601:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression1308);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalRelationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalRelationExpression1318); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalRelationExpression"


    // $ANTLR start "ruleLogicalRelationExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:608:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:611:28: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:612:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:612:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:613:5: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression1365);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:621:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=45 && LA9_0<=50)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:621:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:621:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:622:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:627:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:628:1: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:628:1: (lv_operator_2_0= ruleRelationalOperator )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:629:3: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression1395);
            	    lv_operator_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalRelationExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"RelationalOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:645:2: ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:646:1: (lv_rightOperand_3_0= ruleShiftExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:646:1: (lv_rightOperand_3_0= ruleShiftExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:647:3: lv_rightOperand_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression1416);
            	    lv_rightOperand_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalRelationExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"ShiftExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalRelationExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:671:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:672:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:673:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression1454);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression1464); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:680:1: ruleShiftExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:683:28: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:684:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:684:1: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:685:5: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression1511);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalAddSubtractExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:693:1: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=37 && LA10_0<=38)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:693:2: () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:693:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:694:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:699:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:700:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:700:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:701:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpression1541);
            	    lv_operator_2_0=ruleShiftOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"ShiftOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:717:2: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:718:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:718:1: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:719:3: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression1562);
            	    lv_rightOperand_3_0=ruleNumericalAddSubtractExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"NumericalAddSubtractExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleNumericalAddSubtractExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:743:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:744:2: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:745:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression1600);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalAddSubtractExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression1610); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalAddSubtractExpression"


    // $ANTLR start "ruleNumericalAddSubtractExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:752:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:755:28: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:756:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:756:1: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:757:5: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression1657);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalMultiplyDivideExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:765:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=39 && LA11_0<=40)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:765:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:765:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:766:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:771:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:772:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:772:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:773:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression1687);
            	    lv_operator_2_0=ruleAdditiveOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNumericalAddSubtractExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"AdditiveOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:789:2: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:790:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:790:1: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:791:3: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression1708);
            	    lv_rightOperand_3_0=ruleNumericalMultiplyDivideExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNumericalAddSubtractExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"NumericalMultiplyDivideExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalAddSubtractExpression"


    // $ANTLR start "entryRuleNumericalMultiplyDivideExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:815:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:816:2: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:817:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression1746);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalMultiplyDivideExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression1756); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalMultiplyDivideExpression"


    // $ANTLR start "ruleNumericalMultiplyDivideExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:824:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:827:28: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:828:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:828:1: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:829:5: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression1803);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NumericalUnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:837:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=41 && LA12_0<=43)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:837:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:837:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:838:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:843:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:844:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:844:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:845:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression1833);
            	    lv_operator_2_0=ruleMultiplicativeOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNumericalMultiplyDivideExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"MultiplicativeOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:861:2: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:862:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:862:1: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:863:3: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression1854);
            	    lv_rightOperand_3_0=ruleNumericalUnaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNumericalMultiplyDivideExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"NumericalUnaryExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalMultiplyDivideExpression"


    // $ANTLR start "entryRuleNumericalUnaryExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:887:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:888:2: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:889:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression1892);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericalUnaryExpression1902); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalUnaryExpression"


    // $ANTLR start "ruleNumericalUnaryExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:896:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:899:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:900:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:900:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)||LA13_0==23) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=39 && LA13_0<=40)||LA13_0==44) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:901:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression1949);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:910:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:910:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:910:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePrimaryExpression ) )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:910:7: ()
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:911:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:916:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:917:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:917:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:918:3: lv_operator_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression1985);
                    lv_operator_2_0=ruleUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericalUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_2_0, 
                              		"UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:934:2: ( (lv_operand_3_0= rulePrimaryExpression ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:935:1: (lv_operand_3_0= rulePrimaryExpression )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:935:1: (lv_operand_3_0= rulePrimaryExpression )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:936:3: lv_operand_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression2006);
                    lv_operand_3_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericalUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_3_0, 
                              		"PrimaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:960:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:961:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:962:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2043);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2053); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:969:1: rulePrimaryExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_ParenthesizedExpression_2 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:972:28: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:973:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:973:1: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt14=3;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
            case RULE_INT:
            case RULE_FLOAT:
            case RULE_HEX:
            case RULE_STRING:
                {
                alt14=1;
                }
                break;
            case RULE_ID:
                {
                alt14=2;
                }
                break;
            case 23:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:974:5: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveValueExpression_in_rulePrimaryExpression2100);
                    this_PrimitiveValueExpression_0=rulePrimitiveValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveValueExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:984:5: this_FeatureCall_1= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePrimaryExpression2127);
                    this_FeatureCall_1=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FeatureCall_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:994:5: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression2154);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRulePrimitiveValueExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1010:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1011:2: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1012:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression2189);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveValueExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveValueExpression2199); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveValueExpression"


    // $ANTLR start "rulePrimitiveValueExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1019:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1022:28: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1023:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1023:1: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1023:2: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1023:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1024:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1029:2: ( (lv_value_1_0= ruleLiteral ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1030:1: (lv_value_1_0= ruleLiteral )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1030:1: (lv_value_1_0= ruleLiteral )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1031:3: lv_value_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression2254);
            lv_value_1_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveValueExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveValueExpression"


    // $ANTLR start "entryRuleFeatureCall"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1055:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1056:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1057:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2290);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall2300); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1064:1: ruleFeatureCall returns [EObject current=null] : (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_operationCall_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_ElementReferenceExpression_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1067:28: ( (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1068:1: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1068:1: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )* )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1069:5: this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_ruleFeatureCall2347);
            this_ElementReferenceExpression_0=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ElementReferenceExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1077:1: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )? )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==22) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1077:2: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )?
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1077:2: ()
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1078:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleFeatureCall2368); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1());
            	          
            	    }
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1087:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1088:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1088:1: (otherlv_3= RULE_ID )
            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1089:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getFeatureCallRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureCall2388); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1100:2: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )?
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==23) && (synpred1_InternalExpressions())) {
            	        alt17=1;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1100:3: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')'
            	            {
            	            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1100:3: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) )
            	            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1100:4: ( ( '(' ) )=> (lv_operationCall_4_0= '(' )
            	            {
            	            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1107:1: (lv_operationCall_4_0= '(' )
            	            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1108:3: lv_operationCall_4_0= '('
            	            {
            	            lv_operationCall_4_0=(Token)match(input,23,FOLLOW_23_in_ruleFeatureCall2422); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_operationCall_4_0, grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getFeatureCallRule());
            	              	        }
            	                     		setWithLastConsumed(current, "operationCall", true, "(");
            	              	    
            	            }

            	            }


            	            }

            	            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1121:2: ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )?
            	            int alt16=2;
            	            int LA16_0 = input.LA(1);

            	            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_STRING)||LA16_0==18||LA16_0==23||(LA16_0>=39 && LA16_0<=40)||LA16_0==44) ) {
            	                alt16=1;
            	            }
            	            switch (alt16) {
            	                case 1 :
            	                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1121:3: ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
            	                    {
            	                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1121:3: ( (lv_args_5_0= ruleExpression ) )
            	                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1122:1: (lv_args_5_0= ruleExpression )
            	                    {
            	                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1122:1: (lv_args_5_0= ruleExpression )
            	                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1123:3: lv_args_5_0= ruleExpression
            	                    {
            	                    if ( state.backtracking==0 ) {
            	                       
            	                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_0_0()); 
            	                      	    
            	                    }
            	                    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall2457);
            	                    lv_args_5_0=ruleExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      	        if (current==null) {
            	                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	                      	        }
            	                             		add(
            	                             			current, 
            	                             			"args",
            	                              		lv_args_5_0, 
            	                              		"Expression");
            	                      	        afterParserOrEnumRuleCall();
            	                      	    
            	                    }

            	                    }


            	                    }

            	                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1139:2: (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
            	                    loop15:
            	                    do {
            	                        int alt15=2;
            	                        int LA15_0 = input.LA(1);

            	                        if ( (LA15_0==24) ) {
            	                            alt15=1;
            	                        }


            	                        switch (alt15) {
            	                    	case 1 :
            	                    	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1139:4: otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleFeatureCall2470); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	          	newLeafNode(otherlv_6, grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_1_1_0());
            	                    	          
            	                    	    }
            	                    	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1143:1: ( (lv_args_7_0= ruleExpression ) )
            	                    	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1144:1: (lv_args_7_0= ruleExpression )
            	                    	    {
            	                    	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1144:1: (lv_args_7_0= ruleExpression )
            	                    	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1145:3: lv_args_7_0= ruleExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {
            	                    	       
            	                    	      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getArgsExpressionParserRuleCall_1_3_1_1_1_0()); 
            	                    	      	    
            	                    	    }
            	                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFeatureCall2491);
            	                    	    lv_args_7_0=ruleExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      	        if (current==null) {
            	                    	      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	                    	      	        }
            	                    	             		add(
            	                    	             			current, 
            	                    	             			"args",
            	                    	              		lv_args_7_0, 
            	                    	              		"Expression");
            	                    	      	        afterParserOrEnumRuleCall();
            	                    	      	    
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop15;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleFeatureCall2507); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_2());
            	                  
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleElementReferenceExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1173:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1174:2: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1175:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression2547);
            iv_ruleElementReferenceExpression=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementReferenceExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementReferenceExpression2557); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementReferenceExpression"


    // $ANTLR start "ruleElementReferenceExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1182:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) ;
    public final EObject ruleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_operationCall_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1185:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1186:1: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1186:1: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1186:2: () ( (otherlv_1= RULE_ID ) ) ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1186:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1187:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1192:2: ( (otherlv_1= RULE_ID ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1193:1: (otherlv_1= RULE_ID )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1193:1: (otherlv_1= RULE_ID )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1194:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElementReferenceExpression2611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1205:2: ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) && (synpred2_InternalExpressions())) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1205:3: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1205:3: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1205:4: ( ( '(' ) )=> (lv_operationCall_2_0= '(' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1212:1: (lv_operationCall_2_0= '(' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1213:3: lv_operationCall_2_0= '('
                    {
                    lv_operationCall_2_0=(Token)match(input,23,FOLLOW_23_in_ruleElementReferenceExpression2645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_operationCall_2_0, grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
                      	        }
                             		setWithLastConsumed(current, "operationCall", true, "(");
                      	    
                    }

                    }


                    }

                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1226:2: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)||LA20_0==18||LA20_0==23||(LA20_0>=39 && LA20_0<=40)||LA20_0==44) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1226:3: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1226:3: ( (lv_args_3_0= ruleExpression ) )
                            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1227:1: (lv_args_3_0= ruleExpression )
                            {
                            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1227:1: (lv_args_3_0= ruleExpression )
                            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1228:3: lv_args_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleElementReferenceExpression2680);
                            lv_args_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"args",
                                      		lv_args_3_0, 
                                      		"Expression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1244:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==24) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1244:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleElementReferenceExpression2693); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_4, grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_1_1_0());
                            	          
                            	    }
                            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1248:1: ( (lv_args_5_0= ruleExpression ) )
                            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1249:1: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1249:1: (lv_args_5_0= ruleExpression )
                            	    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1250:3: lv_args_5_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgsExpressionParserRuleCall_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExpression_in_ruleElementReferenceExpression2714);
                            	    lv_args_5_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_5_0, 
                            	              		"Expression");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleElementReferenceExpression2730); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_2_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementReferenceExpression"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1278:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1279:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1280:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression2768);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression2778); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1287:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1290:28: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1291:1: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1291:1: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1291:2: () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1291:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1292:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleParenthesizedExpression2824); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1301:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1302:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1302:1: (lv_expression_2_0= ruleExpression )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1303:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression2845);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleParenthesizedExpression2857); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1331:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1332:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1333:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2893);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2903); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1340:1: ruleLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BoolLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_HexLiteral_2 = null;

        EObject this_RealLiteral_3 = null;

        EObject this_StringLiteral_4 = null;


         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1343:28: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1344:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1344:1: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_RealLiteral_3= ruleRealLiteral | this_StringLiteral_4= ruleStringLiteral )
            int alt22=5;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt22=1;
                }
                break;
            case RULE_INT:
                {
                alt22=2;
                }
                break;
            case RULE_HEX:
                {
                alt22=3;
                }
                break;
            case RULE_FLOAT:
                {
                alt22=4;
                }
                break;
            case RULE_STRING:
                {
                alt22=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1345:5: this_BoolLiteral_0= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBoolLiteral_in_ruleLiteral2950);
                    this_BoolLiteral_0=ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BoolLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1355:5: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntLiteral_in_ruleLiteral2977);
                    this_IntLiteral_1=ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntLiteral_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1365:5: this_HexLiteral_2= ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getHexLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHexLiteral_in_ruleLiteral3004);
                    this_HexLiteral_2=ruleHexLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_HexLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1375:5: this_RealLiteral_3= ruleRealLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getRealLiteralParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleLiteral3031);
                    this_RealLiteral_3=ruleRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealLiteral_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1385:5: this_StringLiteral_4= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral3058);
                    this_StringLiteral_4=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringLiteral_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleBoolLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1401:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1402:2: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1403:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral3093);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolLiteral3103); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1410:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1413:28: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1414:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1414:1: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1414:2: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1414:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1415:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1420:2: ( (lv_value_1_0= RULE_BOOL ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1421:1: (lv_value_1_0= RULE_BOOL )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1421:1: (lv_value_1_0= RULE_BOOL )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1422:3: lv_value_1_0= RULE_BOOL
            {
            lv_value_1_0=(Token)match(input,RULE_BOOL,FOLLOW_RULE_BOOL_in_ruleBoolLiteral3154); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"BOOL");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1446:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1447:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1448:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3195);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntLiteral3205); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1455:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1458:28: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1459:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1459:1: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1459:2: () ( (lv_value_1_0= RULE_INT ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1459:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1460:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1465:2: ( (lv_value_1_0= RULE_INT ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1466:1: (lv_value_1_0= RULE_INT )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1466:1: (lv_value_1_0= RULE_INT )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1467:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntLiteral3256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1491:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1492:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1493:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3297);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral3307); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1500:1: ruleRealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1503:28: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1504:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1504:1: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1504:2: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1504:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1505:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRealLiteralAccess().getRealLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1510:2: ( (lv_value_1_0= RULE_FLOAT ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1511:1: (lv_value_1_0= RULE_FLOAT )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1511:1: (lv_value_1_0= RULE_FLOAT )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1512:3: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleRealLiteral3358); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getRealLiteralAccess().getValueFLOATTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRealLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"FLOAT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleHexLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1536:1: entryRuleHexLiteral returns [EObject current=null] : iv_ruleHexLiteral= ruleHexLiteral EOF ;
    public final EObject entryRuleHexLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexLiteral = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1537:2: (iv_ruleHexLiteral= ruleHexLiteral EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1538:2: iv_ruleHexLiteral= ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral3399);
            iv_ruleHexLiteral=ruleHexLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHexLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexLiteral3409); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHexLiteral"


    // $ANTLR start "ruleHexLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1545:1: ruleHexLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_HEX ) ) ) ;
    public final EObject ruleHexLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1548:28: ( ( () ( (lv_value_1_0= RULE_HEX ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1549:1: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1549:1: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1549:2: () ( (lv_value_1_0= RULE_HEX ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1549:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1550:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getHexLiteralAccess().getHexLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1555:2: ( (lv_value_1_0= RULE_HEX ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1556:1: (lv_value_1_0= RULE_HEX )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1556:1: (lv_value_1_0= RULE_HEX )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1557:3: lv_value_1_0= RULE_HEX
            {
            lv_value_1_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleHexLiteral3460); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getHexLiteralAccess().getValueHEXTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getHexLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"HEX");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHexLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1581:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1582:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1583:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3501);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral3511); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1590:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1593:28: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1594:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1594:1: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1594:2: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1594:2: ()
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1595:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1600:2: ( (lv_value_1_0= RULE_STRING ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1601:1: (lv_value_1_0= RULE_STRING )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1601:1: (lv_value_1_0= RULE_STRING )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1602:3: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral3562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "ruleAssignmentOperator"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1626:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) ;
    public final Enumerator ruleAssignmentOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1628:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1629:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1629:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            int alt23=11;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt23=1;
                }
                break;
            case 27:
                {
                alt23=2;
                }
                break;
            case 28:
                {
                alt23=3;
                }
                break;
            case 29:
                {
                alt23=4;
                }
                break;
            case 30:
                {
                alt23=5;
                }
                break;
            case 31:
                {
                alt23=6;
                }
                break;
            case 32:
                {
                alt23=7;
                }
                break;
            case 33:
                {
                alt23=8;
                }
                break;
            case 34:
                {
                alt23=9;
                }
                break;
            case 35:
                {
                alt23=10;
                }
                break;
            case 36:
                {
                alt23=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1629:2: (enumLiteral_0= '=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1629:2: (enumLiteral_0= '=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1629:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleAssignmentOperator3617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1635:6: (enumLiteral_1= '*=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1635:6: (enumLiteral_1= '*=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1635:8: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_27_in_ruleAssignmentOperator3634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1641:6: (enumLiteral_2= '/=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1641:6: (enumLiteral_2= '/=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1641:8: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleAssignmentOperator3651); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1647:6: (enumLiteral_3= '%=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1647:6: (enumLiteral_3= '%=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1647:8: enumLiteral_3= '%='
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleAssignmentOperator3668); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1653:6: (enumLiteral_4= '+=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1653:6: (enumLiteral_4= '+=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1653:8: enumLiteral_4= '+='
                    {
                    enumLiteral_4=(Token)match(input,30,FOLLOW_30_in_ruleAssignmentOperator3685); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1659:6: (enumLiteral_5= '-=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1659:6: (enumLiteral_5= '-=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1659:8: enumLiteral_5= '-='
                    {
                    enumLiteral_5=(Token)match(input,31,FOLLOW_31_in_ruleAssignmentOperator3702); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1665:6: (enumLiteral_6= '<<=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1665:6: (enumLiteral_6= '<<=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1665:8: enumLiteral_6= '<<='
                    {
                    enumLiteral_6=(Token)match(input,32,FOLLOW_32_in_ruleAssignmentOperator3719); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1671:6: (enumLiteral_7= '>>=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1671:6: (enumLiteral_7= '>>=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1671:8: enumLiteral_7= '>>='
                    {
                    enumLiteral_7=(Token)match(input,33,FOLLOW_33_in_ruleAssignmentOperator3736); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1677:6: (enumLiteral_8= '&=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1677:6: (enumLiteral_8= '&=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1677:8: enumLiteral_8= '&='
                    {
                    enumLiteral_8=(Token)match(input,34,FOLLOW_34_in_ruleAssignmentOperator3753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1683:6: (enumLiteral_9= '^=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1683:6: (enumLiteral_9= '^=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1683:8: enumLiteral_9= '^='
                    {
                    enumLiteral_9=(Token)match(input,35,FOLLOW_35_in_ruleAssignmentOperator3770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1689:6: (enumLiteral_10= '|=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1689:6: (enumLiteral_10= '|=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1689:8: enumLiteral_10= '|='
                    {
                    enumLiteral_10=(Token)match(input,36,FOLLOW_36_in_ruleAssignmentOperator3787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "ruleShiftOperator"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1699:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1701:28: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1702:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1702:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            else if ( (LA24_0==38) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1702:2: (enumLiteral_0= '<<' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1702:2: (enumLiteral_0= '<<' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1702:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_37_in_ruleShiftOperator3832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1708:6: (enumLiteral_1= '>>' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1708:6: (enumLiteral_1= '>>' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1708:8: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_38_in_ruleShiftOperator3849); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1718:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1720:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1721:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1721:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==39) ) {
                alt25=1;
            }
            else if ( (LA25_0==40) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1721:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1721:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1721:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_39_in_ruleAdditiveOperator3894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1727:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1727:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1727:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_40_in_ruleAdditiveOperator3911); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1737:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1739:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1740:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1740:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt26=1;
                }
                break;
            case 42:
                {
                alt26=2;
                }
                break;
            case 43:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1740:2: (enumLiteral_0= '*' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1740:2: (enumLiteral_0= '*' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1740:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_41_in_ruleMultiplicativeOperator3956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1746:6: (enumLiteral_1= '/' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1746:6: (enumLiteral_1= '/' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1746:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_42_in_ruleMultiplicativeOperator3973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1752:6: (enumLiteral_2= '%' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1752:6: (enumLiteral_2= '%' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1752:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_43_in_ruleMultiplicativeOperator3990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1762:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1764:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1765:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1765:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt27=1;
                }
                break;
            case 40:
                {
                alt27=2;
                }
                break;
            case 44:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1765:2: (enumLiteral_0= '+' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1765:2: (enumLiteral_0= '+' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1765:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_39_in_ruleUnaryOperator4035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1771:6: (enumLiteral_1= '-' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1771:6: (enumLiteral_1= '-' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1771:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_40_in_ruleUnaryOperator4052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1777:6: (enumLiteral_2= '~' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1777:6: (enumLiteral_2= '~' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1777:8: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_44_in_ruleUnaryOperator4069); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "ruleRelationalOperator"
    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1787:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1789:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1790:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1790:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt28=1;
                }
                break;
            case 46:
                {
                alt28=2;
                }
                break;
            case 47:
                {
                alt28=3;
                }
                break;
            case 48:
                {
                alt28=4;
                }
                break;
            case 49:
                {
                alt28=5;
                }
                break;
            case 50:
                {
                alt28=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1790:2: (enumLiteral_0= '<' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1790:2: (enumLiteral_0= '<' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1790:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_45_in_ruleRelationalOperator4114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1796:6: (enumLiteral_1= '<=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1796:6: (enumLiteral_1= '<=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1796:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_46_in_ruleRelationalOperator4131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1802:6: (enumLiteral_2= '>' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1802:6: (enumLiteral_2= '>' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1802:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_47_in_ruleRelationalOperator4148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1808:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1808:6: (enumLiteral_3= '>=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1808:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_48_in_ruleRelationalOperator4165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1814:6: (enumLiteral_4= '==' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1814:6: (enumLiteral_4= '==' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1814:8: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,49,FOLLOW_49_in_ruleRelationalOperator4182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1820:6: (enumLiteral_5= '!=' )
                    {
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1820:6: (enumLiteral_5= '!=' )
                    // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1820:8: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,50,FOLLOW_50_in_ruleRelationalOperator4199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"

    // $ANTLR start synpred1_InternalExpressions
    public final void synpred1_InternalExpressions_fragment() throws RecognitionException {   
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1100:4: ( ( '(' ) )
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1101:1: ( '(' )
        {
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1101:1: ( '(' )
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1102:2: '('
        {
        match(input,23,FOLLOW_23_in_synpred1_InternalExpressions2404); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalExpressions

    // $ANTLR start synpred2_InternalExpressions
    public final void synpred2_InternalExpressions_fragment() throws RecognitionException {   
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1205:4: ( ( '(' ) )
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1206:1: ( '(' )
        {
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1206:1: ( '(' )
        // ../org.yakindu.base.expressions/src-gen/org/yakindu/base/expressions/parser/antlr/internal/InternalExpressions.g:1207:2: '('
        {
        match(input,23,FOLLOW_23_in_synpred2_InternalExpressions2627); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalExpressions

    // Delegated rules

    public final boolean synpred2_InternalExpressions() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExpressions_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalExpressions() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalExpressions_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleExpression131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression222 = new BitSet(new long[]{0x0000001FFC000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpression252 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleAssignmentExpression273 = new BitSet(new long[]{0x0000001FFC000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression368 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleConditionalExpression389 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression410 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConditionalExpression422 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleConditionalExpression443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression538 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleLogicalOrExpression559 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression580 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression675 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleLogicalAndExpression696 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_ruleLogicalAndExpression717 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleLogicalNotExpression_in_entryRuleLogicalNotExpression755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalNotExpression765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleLogicalNotExpression839 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_ruleLogicalNotExpression860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseXorExpression_in_entryRuleBitwiseXorExpression897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseXorExpression907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression954 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleBitwiseXorExpression975 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_ruleBitwiseXorExpression996 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpression_in_entryRuleBitwiseOrExpression1034 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpression1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression1091 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleBitwiseOrExpression1112 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_ruleBitwiseOrExpression1133 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpression_in_entryRuleBitwiseAndExpression1171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpression1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression1228 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleBitwiseAndExpression1249 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_ruleBitwiseAndExpression1270 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleLogicalRelationExpression_in_entryRuleLogicalRelationExpression1308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalRelationExpression1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression1365 = new BitSet(new long[]{0x0007E00000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleLogicalRelationExpression1395 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleLogicalRelationExpression1416 = new BitSet(new long[]{0x0007E00000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression1454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression1511 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpression1541 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_ruleShiftExpression1562 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleNumericalAddSubtractExpression_in_entryRuleNumericalAddSubtractExpression1600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalAddSubtractExpression1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression1657 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleNumericalAddSubtractExpression1687 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_ruleNumericalAddSubtractExpression1708 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_ruleNumericalMultiplyDivideExpression_in_entryRuleNumericalMultiplyDivideExpression1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalMultiplyDivideExpression1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression1803 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleNumericalMultiplyDivideExpression1833 = new BitSet(new long[]{0x00001180008003F0L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_ruleNumericalMultiplyDivideExpression1854 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_ruleNumericalUnaryExpression_in_entryRuleNumericalUnaryExpression1892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericalUnaryExpression1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumericalUnaryExpression1985 = new BitSet(new long[]{0x00000000008003F0L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNumericalUnaryExpression2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_rulePrimaryExpression2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePrimaryExpression2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveValueExpression_in_entryRulePrimitiveValueExpression2189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveValueExpression2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimitiveValueExpression2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall2290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_ruleFeatureCall2347 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleFeatureCall2368 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCall2388 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_23_in_ruleFeatureCall2422 = new BitSet(new long[]{0x00001180028403F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall2457 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleFeatureCall2470 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFeatureCall2491 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleFeatureCall2507 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleElementReferenceExpression_in_entryRuleElementReferenceExpression2547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementReferenceExpression2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElementReferenceExpression2611 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleElementReferenceExpression2645 = new BitSet(new long[]{0x00001180028403F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleElementReferenceExpression2680 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleElementReferenceExpression2693 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleElementReferenceExpression2714 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleElementReferenceExpression2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression2768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleParenthesizedExpression2824 = new BitSet(new long[]{0x00001180008403F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression2845 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParenthesizedExpression2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_ruleLiteral2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_ruleLiteral2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_ruleLiteral3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleLiteral3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral3058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolLiteral_in_entryRuleBoolLiteral3093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolLiteral3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOL_in_ruleBoolLiteral3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntLiteral_in_entryRuleIntLiteral3195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntLiteral3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntLiteral3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral3297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleRealLiteral3358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexLiteral_in_entryRuleHexLiteral3399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexLiteral3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleHexLiteral3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral3501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral3511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAssignmentOperator3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleAssignmentOperator3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAssignmentOperator3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignmentOperator3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAssignmentOperator3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAssignmentOperator3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAssignmentOperator3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAssignmentOperator3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleAssignmentOperator3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleAssignmentOperator3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAssignmentOperator3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleShiftOperator3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleShiftOperator3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAdditiveOperator3894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAdditiveOperator3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleMultiplicativeOperator3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleMultiplicativeOperator3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleMultiplicativeOperator3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUnaryOperator4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUnaryOperator4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleUnaryOperator4069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelationalOperator4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelationalOperator4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelationalOperator4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRelationalOperator4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelationalOperator4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred1_InternalExpressions2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred2_InternalExpressions2627 = new BitSet(new long[]{0x0000000000000002L});

}